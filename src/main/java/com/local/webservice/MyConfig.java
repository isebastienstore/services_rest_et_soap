package com.local.webservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class MyConfig {

    /**
     * Exposition du web service saop UserWS
     * @return serviceExpoter
     */
    @Bean
    SimpleJaxWsServiceExporter serviceExporter(){
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://localhost:3000/UserWS");
        return serviceExporter;
    }
}
