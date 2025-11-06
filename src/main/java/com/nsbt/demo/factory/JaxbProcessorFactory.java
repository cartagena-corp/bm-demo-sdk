package com.nsbt.demo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;

@Component
public class JaxbProcessorFactory {
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;

    public JaxbProcessorFactory(@Autowired Jaxb2Marshaller jaxb2Marshaller) {
        super();
        this.unmarshaller = jaxb2Marshaller;
        this.marshaller = jaxb2Marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public String objectToXml(Object obj) throws XmlMappingException, IOException {
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        marshaller.marshal(obj, result);
        return writer.toString();
    }

    public Object xmlToObject(String xml) throws XmlMappingException, IOException {
        StringReader reader = new StringReader(xml);
        StreamSource source = new StreamSource(reader);
        return unmarshaller.unmarshal(source);
    }
}
