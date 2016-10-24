package com.hidalgo.financial.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();

		// save a couple of customers
		userRepository.save(new User("Alice", "Smith","mail1@hotmail.com"));
		userRepository.save(new User("Bob", "Smith","mail2@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (User user : userRepository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(userRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (User customer : userRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
	}

}
