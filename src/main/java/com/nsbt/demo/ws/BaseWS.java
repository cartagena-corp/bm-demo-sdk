package com.nsbt.demo.ws;

import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.endpoint.Client;

/**
 * Clase que instancia un proxy {@link org.apache.cxf.jaxws.JaxWsProxyFactoryBean} con el
 * tipo del cliente del servicio web JAXWS con el que se extiende.
 * @param <T> Interface del cliente JAXWS
 */
public abstract class BaseWS<T> {

    // Interfaz del cliente JAXWS
    protected T serviceClient;

    /**
     * Devuelve la clase del tipo de la interface JAXWS
     * @return la clase del tipo
     */
    protected abstract Class<T> getBeanClass();

    /**
     * Constructor por defecto
     */
    public BaseWS() {
        super();
    }

    /**
     * Constructor que recibe los parámetros de configuración. Los parámetros username y
     * password serán {@code null} si no es necesaria autorización HTTP Basic
     *
     * @param endpoint el endpoint del servicio web
     * @param username el usuario para autorización HTTP Basic
     * @param password la constraseña para autorización HTTP Basic
     */
    public BaseWS(String endpoint, String username, String password) {
        configureService(endpoint, username, password, null);
    }

    /**
     * Experimental Constructor que recibe los parámetros de configuración en un objeto
     * {@link BaseProxyCfg}
     *
     * @param proxyCfg el objeto ProxyCfg con los valores concretos
     */
    public BaseWS(BaseProxyCfg proxyCfg) {
        configureService(proxyCfg.getEndpoint(), proxyCfg.getUsername(),
                proxyCfg.getPassword(), proxyCfg.getTimeout());
    }

    /**
     * Metodo encagado de configurar el proxy {@link JaxWsProxyFactoryBean} para el
     * cliente del servicio web
     *
     * @param endpoint el endpoint del servicio web
     * @param username el usuario para autorización HTTP Basic
     * @param password la contraseña para autorización HTTP Basic
     * @param timeout el timeout para HTTP
     */
    @SuppressWarnings("unchecked")
    private void configureService(String endpoint, String username, String password, String timeout) {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(getBeanClass());
        jaxWsProxyFactoryBean.setAddress(endpoint);
        jaxWsProxyFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        jaxWsProxyFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        this.serviceClient = (T) jaxWsProxyFactoryBean.create();

        if (username != null && !username.isEmpty()) {
            configureClient(username, password, timeout);
        }else if(validateTimeoutValue(timeout)){
            configureTimeout(timeout);
        }
    }

    /**
     * Metodo encagado de configurar el proxy {@link org.apache.cxf.frontend.ClientProxy}
     * con los parámetros necesarios para la capa de transporte
     * {@link org.apache.cxf.transport.http.HTTPConduit}
     *
     * @param username el usuario para autorización HTTP Basic
     * @param password la constraseña para autorización HTTP Basic
     * @param timeout el timeout para HTTP
     */
    private void configureClient(String username, String password, String timeout) {
        Client client = ClientProxy.getClient(this.serviceClient);
        if (client != null) {
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            AuthorizationPolicy auth = conduit.getAuthorization();
            if (null == auth){
                auth = new AuthorizationPolicy();
            }
            auth.setUserName(username);
            auth.setPassword(password);

            if (validateTimeoutValue(timeout)) {
                configureTimeout(timeout, conduit);
            }
        }
    }

    /**
     * Metodo encargado de configurar el timeout en la capa de transporte
     * {@link org.apache.cxf.transport.http.HTTPConduit}
     * @param timeout tiempo máximo de espera
     * @param conduit capa de transporte
     */
    private void configureTimeout(String timeout, HTTPConduit conduit){
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(Long.parseLong(timeout));
        policy.setReceiveTimeout(Long.parseLong(timeout));
        conduit.setClient(policy);
    }

    /**
     * Metodo encargado de configurar el timeout en la capa de transporte
     * {@link org.apache.cxf.transport.http.HTTPConduit}
     */
    private void configureTimeout(String timeout) {
        Client client = ClientProxy.getClient(this.serviceClient);
        if (client != null) {
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            HTTPClientPolicy policy = new HTTPClientPolicy();
            policy.setConnectionTimeout(Long.parseLong(timeout));
            policy.setReceiveTimeout(Long.parseLong(timeout));
            conduit.setClient(policy);
        }
    }

    /**
     * Validación del valor asignado a timeout
     */
    private boolean validateTimeoutValue(String timeout){
        if (timeout != null && !timeout.isEmpty()){
            try{
                long value = Long.parseLong(timeout);
                return value >= 0;
            } catch (NumberFormatException ignored){

            }
        }
        return false;
    }

}
