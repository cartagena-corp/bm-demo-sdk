package com.nsbt.demo.ws;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "demo.ws.consultar-productos-activos")
@Component
public class ConsultarProductosActivosProxyCfg extends BaseProxyCfg {

}