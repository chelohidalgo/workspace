package com.marcelohidalgo.ribbonmicroservicescurrencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.marcelohidalgo.ribbonmicroservicescurrencyconversion.proxy")
@EnableDiscoveryClient
public class RibbonMicroservicesCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonMicroservicesCurrencyConversionApplication.class, args);
	}

}
