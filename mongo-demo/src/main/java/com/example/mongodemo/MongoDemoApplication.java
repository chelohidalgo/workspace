package com.example.mongodemo;

import com.example.mongodemo.entity.User;
import com.example.mongodemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDemoApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setFirstName("Marcelo");
        user.setLastName("test");
        userRepository.save(user);
        System.out.println("saved------>");
        user = userRepository.findByEmail("test@gmail.com");
        System.out.println("find------>");
        System.out.println(user);
        System.out.println("finish");
    }
}
