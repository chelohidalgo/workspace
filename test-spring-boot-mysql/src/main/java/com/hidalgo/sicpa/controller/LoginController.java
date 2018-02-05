package com.hidalgo.sicpa.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hidalgo.sicpa.entity.User;
import com.hidalgo.sicpa.exception.StoreException;
import com.hidalgo.sicpa.service.UserService;

/**
 * Controller in order to validate the login
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@Controller
@RequestMapping(path = "/login")
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	/**
	 * Validate if the username exist in the database
	 * 
	 * @version 1.0 - 15/10/2017
	 * @author Marcelo Hidalgo
	 * @param userName
	 *            : username
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{userName}")
	@ResponseStatus(HttpStatus.OK)
	public void validateUserName(@PathVariable("userName") String userName) {

		Iterable<User> user = null;
		try {
			user = userService.findByUserName(userName);
			if (user != null) {
				LOG.info("username founded");
			} else {
				LOG.info("username invalid");
				throw new StoreException("username invalid");
			}
		} catch (StoreException e) {
			LOG.error(e.getMessage());

		}
	}

	/**
	 * Validate if the username and password of the user are correct
	 * 
	 * @version 1.0 - 15/10/2017
	 * @author Marcelo Hidalgo
	 * @param userName
	 *            : username
	 * @param password
	 *            : password
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{username}/{password}")
	@ResponseStatus(HttpStatus.OK)
	public void validateUserNameAndPassword(
			@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Iterable<User> users = null;
		User user = null;
		try {
			users = userService.findByUserName(username);
			if (users != null) {
				LOG.info("username founded");
				user = userService
						.findByUserNameAndPassword(username, password);
				if (user != null) {
					LOG.info("Loggin successfully");
				} else {
					LOG.info("Password invalid");
					throw new StoreException("Password invalid");
				}
			} else {
				LOG.info("User invalid");
				throw new StoreException("User invalid");
			}
		} catch (StoreException e) {
			LOG.error(e.getMessage());

		}
	}

}
