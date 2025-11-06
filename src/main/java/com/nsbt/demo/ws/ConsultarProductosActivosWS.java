package com.nsbt.demo.ws;

import com.nsbt.demo.exception.ConsultarProductosActivosWSException;
import com.nsbt.demo.factory.ConsultarProductosActivosFactory;
import com.nsbt.demo.exception.NSBTTimeOutException;
import com.nsbt.demo.soap.ws.X9996C1ExecuteResponse;
import org.springframework.stereotype.Service;
import com.nsbt.demo.soap.ws.X9996C1SoapPort;
import com.nsbt.demo.soap.ws.X9996C1Execute;
import jakarta.xml.ws.WebServiceException;
import com.nsbt.demo.model.PosPeNaRta;

@Service
public class ConsultarProductosActivosWS extends BaseWS<X9996C1SoapPort> {
    
    ConsultarProductosActivosFactory factory;

    public ConsultarProductosActivosWS(ConsultarProductosActivosProxyCfg consultarProductosActivosCfg, ConsultarProductosActivosFactory factory) {
        super(consultarProductosActivosCfg);
        this.factory = factory;
    }

    public PosPeNaRta getProductosActivos(X9996C1Execute parameter) throws NSBTTimeOutException {
        try {
            X9996C1ExecuteResponse response = serviceClient.execute(parameter);
            return factory.from(response);
        } catch (WebServiceException wsex){
            throw new NSBTTimeOutException(wsex.getMessage());
        } catch (Exception cte) {
            throw new ConsultarProductosActivosWSException(cte.getMessage(), cte);
        }
    }

    @Override
    protected Class<X9996C1SoapPort> getBeanClass() {
        return X9996C1SoapPort.class;
    }
}