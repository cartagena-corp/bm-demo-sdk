package com.nsbt.demo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import com.nsbt.demo.soap.ws.X9996C1ExecuteResponse;
import org.springframework.stereotype.Component;
import com.nsbt.demo.model.PosPeNaRta;
import java.io.IOException;
import java.util.List;

@Component
public class ConsultarProductosActivosFactory {
    private static final String CLAVE = "PosPeNaRta";
    private JaxbProcessorFactory mapper;

    public ConsultarProductosActivosFactory(@Autowired JaxbProcessorFactory mapper) {
        super();
        this.mapper = mapper;
    }

    public PosPeNaRta from(X9996C1ExecuteResponse response) throws IOException {
        return (PosPeNaRta) mapper.xmlToObject(response.getEvalls().getItem().get(getIndexOfPosPeNaRtaInArrayEvalls(response)));
    }

    private int getIndexOfPosPeNaRtaInArrayEvalls(X9996C1ExecuteResponse response) {
        List<String> eDatos = response.getEdatos().getItem();
        return eDatos.indexOf(CLAVE);
    }
}

