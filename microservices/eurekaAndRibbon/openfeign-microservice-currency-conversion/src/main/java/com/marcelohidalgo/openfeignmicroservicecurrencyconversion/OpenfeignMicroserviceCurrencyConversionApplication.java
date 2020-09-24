package com.marcelohidalgo.openfeignmicroservicecurrencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.marcelohidalgo.openfeignmicroservicecurrencyconversion.proxy")
@EnableDiscoveryClient
public class OpenfeignMicroserviceCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignMicroserviceCurrencyConversionApplication.class, args);
	}

}
