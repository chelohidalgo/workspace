package com.marcelohidalgo.myMongoMicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcelohidalgo.myMongoMicroservice.dao.UserRepository;
import com.marcelohidalgo.myMongoMicroservice.entity.User;

@RestController
public class MongoService {
	
	@RequestMapping(value="/users/quemado", method = RequestMethod.GET)
	List<User> getUsersQuemados() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setEmail("marcelo@gmail.com");
		user.setFirstName("Marcelo");
		user.setLastName("hidalgo");
		users.add(user);
		return users;
	}

	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/users", method = RequestMethod.GET)
	List<User> getUsers() {
		return userRepository.findAll();
	}

	@RequestMapping(value="/user", method = RequestMethod.GET)
	Optional<User> getUser(@RequestParam(name = "id") String id) {
		return userRepository.findById(id);
	}

	@RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.PUT})
	User createUser(@RequestBody User user) {
		System.out.println(user.toString());
		return userRepository.save(user);
	}

	@RequestMapping(value="/user", method = RequestMethod.DELETE)
	void removeUser(@RequestBody User user) {
		userRepository.delete(user);
	}

}
