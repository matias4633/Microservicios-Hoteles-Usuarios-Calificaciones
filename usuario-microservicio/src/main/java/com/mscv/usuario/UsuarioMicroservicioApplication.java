package com.mscv.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //NOtacion para activar OpenFeign, COmunicacion entre microservicios delarativa.
public class UsuarioMicroservicioApplication {
//Este microservicio  es el principal. Desde este consume a los demas.
	public static void main(String[] args) {
		SpringApplication.run(UsuarioMicroservicioApplication.class, args);
	}

}
