package com.marcelohidalgo.eurekamicroservicescurrencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMicroservicesCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMicroservicesCurrencyConversionApplication.class, args);
	}

}
