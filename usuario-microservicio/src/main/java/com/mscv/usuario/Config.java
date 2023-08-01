package com.mscv.usuario;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    @LoadBalanced //Se usa para usar balanceo de carga. Pasas a usar el nombre del service en la properties.
    public RestTemplate restTemplate(){ //Con este, puedo comunicar entre microservicios.
        return new RestTemplate();
    }
}
