package com.hidalgo.sicpa.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hidalgo.sicpa.entity.User;
import com.hidalgo.sicpa.enumeration.StatusEnum;
import com.hidalgo.sicpa.exception.StoreException;
import com.hidalgo.sicpa.service.UserService;

/**
 * Controller in order to exposing rest services for users
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

	private static final Logger LOG = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/add/{name}/{id}/{userName}/{password}/{email}/{city}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addNewUser(@PathVariable("name") String name,
			@PathVariable("id") Long id,
			@PathVariable("userName") String userName,
			@PathVariable("password") String password,
			@PathVariable("city") String city,
			@PathVariable("email") String email) {
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setStatus(StatusEnum.ACTIVE.getCode());
		user.setName(name);
		user.setCity(city);
		user.setMail(email);
		try {
			userService.saveUser(user);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to save user");
			
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{idUser}/{id}/{name}/{userName}/{password}/{city}/{email}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public void updateUser(@PathVariable("idUser") Long idUser,
			@PathVariable("id") Long id, @PathVariable("name") String name,
			@PathVariable("userName") String userName,
			@PathVariable("password") String password,
			@PathVariable("city") String city,
			@PathVariable("email") String email,
			@PathVariable("status") String status) {

		User user = new User();
		user.setId(id);
		user.setIdUser(idUser);
		user.setMail(email);
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);
		user.setCity(city);
		user.setStatus(status);
		try {
			userService.updateUser(user);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to update user");
			
		} catch (Exception e) {
			LOG.error("An error ocurred, try later");
			
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable("id") Long id) {
		User user = new User();
		user.setId(id);
		user.setStatus(StatusEnum.INACTIVE.getCode());
		try {
			userService.removeUser(user);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to try to delete user");
			
		}
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		Iterable<User> users = null;
		try {
			users = userService.findAll();
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all users");
			
		}
		return users;
	}
	
	@GetMapping(path = "/city/{city}")
	public @ResponseBody Iterable<User> getAllUsersByCity(@PathVariable("city") String city) {
		Iterable<User> users = null;
		try {
			users = userService.findByCity(city);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all users");
			
		}
		return users;
	}
	
	@GetMapping(path = "/username/{username}")
	public @ResponseBody Iterable<User> getAllUsersByUserName(@PathVariable("username") String username) {
		Iterable<User> users = null;
		try {
			users = userService.findByUserName(username);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all users");
			
		}
		return users;
	}
	
	@GetMapping(path = "/status/{status}")
	public @ResponseBody Iterable<User> getAllUsersByStatus(@PathVariable("status") String status) {
		Iterable<User> users = null;
		try {
			users = userService.findByStatus(status);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get all users");
			
		}
		return users;
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody User getUserByIdUser(@PathVariable("id") Long id) {
		User user = null;
		try {
			user = userService.findByIdUser(id);
		} catch (StoreException e) {
			LOG.error("An error ocurred when to get user");
			
		}
		return user;
	}
}
