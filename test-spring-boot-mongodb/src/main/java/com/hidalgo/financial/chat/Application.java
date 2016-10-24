package com.hidalgo.financial.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot application in order to make the application executable
 * 
 * @version 1.0 - 18/10/2016
 * @author Marcelo Hidalgo
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application{
	
	/**
	 * Main method
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 */

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
