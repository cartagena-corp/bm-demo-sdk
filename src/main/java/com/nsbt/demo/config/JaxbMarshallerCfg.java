package com.nsbt.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.context.annotation.Bean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class JaxbMarshallerCfg {
    @Bean
    public Jaxb2Marshaller getMarshaller(@Value("${movcli.jaxb.marshaller.packagescan}") List<String> DTO_PACKAGE_TO_SCAN) {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan(DTO_PACKAGE_TO_SCAN.toArray(new String[DTO_PACKAGE_TO_SCAN.size()]));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jaxb.formatted.output", true);
        jaxb2Marshaller.setMarshallerProperties(map);
        return jaxb2Marshaller;
    }

}
