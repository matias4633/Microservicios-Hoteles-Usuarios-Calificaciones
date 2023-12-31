package com.msvc.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServicioApplication.class, args);
	}

}
