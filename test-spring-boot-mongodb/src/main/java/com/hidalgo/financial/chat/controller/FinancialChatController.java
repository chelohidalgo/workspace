package com.hidalgo.financial.chat.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hidalgo.financial.chat.entity.Message;
import com.hidalgo.financial.chat.entity.Profile;
import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.service.impl.MessageService;
import com.hidalgo.financial.chat.service.impl.ProfileService;
import com.hidalgo.financial.chat.service.impl.UserService;
import com.hidalgo.financial.chat.util.Constant;

/**
 * Class to control the services exposed for the application
 * 
 * @version 1.0 - 18/10/2016
 * @author Marcelo Hidalgo
 */
@RestController
@RequestMapping("/financial_chat")
public final class FinancialChatController {

	private final UserService userService;
	private final ProfileService profileService;
	private final MessageService messageService;

	/**
	 * Constructor
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 * @param userService
	 *            : services on users
	 * @param profileService
	 *            : services on profiles
	 * @param messageService
	 *            : services on messages
	 */
	@Autowired
	public FinancialChatController(UserService userService, ProfileService profileService,
			MessageService messageService) {
		this.userService = userService;
		this.profileService = profileService;
		this.messageService = messageService;
	}

	/**
	 * Method in order to populate the collections in mondoDB
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create() {
		try {
			profileService.deleteAll();
			userService.deleteAll();
			messageService.deleteAll();

			Profile profileAdmin = new Profile("admin", "Administrador", "Profile administrator");
			Profile profileUser = new Profile("user", "User", "Profile administrator");
			profileService.saveProfile(profileAdmin);
			profileService.saveProfile(profileUser);

			User user1 = new User("Marcelo", "Hidalgo", "marceloh@company.com", profileAdmin);
			User user2 = new User("Alice", "Smith", "alices@company.com", profileUser);
			User user3 = new User("Bob", "Smith", "bobs@company.xom", profileUser);
			userService.saveUser(user1);
			userService.saveUser(user2);
			userService.saveUser(user3);

			saveMessages(user1, 0);
			saveMessages(user2, 0);
			saveMessages(user3, 0);
		} catch (Exception e) {
			System.out.println("Error, the system is not available, please try later");
		}
	}

	/**
	 * Method in order to get all the users in the application
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 * @return List<User> : users stored in the the application
	 */
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		try {
			return userService.findAll();
		} catch (Exception e) {
			System.out.println("Error, the system is not available, please try later");
		}
		return null;
	}

	/**
	 * Method in order to get all the profiles in the application
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 * @return List<Profile> : profiles stored in the application
	 */
	@RequestMapping(path = "/profiles", method = RequestMethod.GET)
	public List<Profile> getAllProfiles() {
		try {
			return profileService.findProfiles();
		} catch (Exception e) {
			System.out.println("Error, the system is not available, please try later");
		}
		return null;
	}

	/**
	 * Method in order to get a user using the first name
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 * @param firstName
	 *            : first name of user
	 * @return User : user founded with the first name as a parameter
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/users/{firstName}")
	User findByFirstName(@PathVariable("firstName") String firstName) {
		try {
			return userService.findByFirstName(firstName);
		} catch (Exception e) {
			System.out.println("Error, the system is not available, please try later");
		}
		return null;
	}

	/**
	 * Method in order to get the last 50 messages of one user using his/her
	 * email account
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 * @param email
	 *            : email of user
	 * @return List<Message> : messages founded with the email as a parameter
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{email}")
	List<Message> findLastMessages(@PathVariable("email") String email) {
		try {
			if (BooleanUtils.isFalse(email.contains(".com"))) {
				email = email.concat(".com");
			}
			User user = userService.findByEmail(email);
			// Pageable has 2 properties(page, size), then those properties to get as a
			// parameters
			Pageable pageable = new PageRequest(0, 50);
			return user != null ? messageService.findLastMessagesOrderByTimeAsc(user.getId(), pageable) : null;
		} catch (Exception e) {
			System.out.println("Error, the system is not available, please try later");
		}
		return null;
	}

	/**
	 * Save the message document in mongoDB
	 * 
	 * @version 1.0 - 18/10/2016
	 * @author Marcelo Hidalgo
	 * @param
	 */
	private void saveMessages(User user, int contador) {
		try {
			if (contador < Constant.NUMBER_HUNDRED) {
				Message message = new Message(new Date(), "mensaje" + contador, user.getId());
				messageService.saveMessage(message);
				contador++;
				saveMessages(user, contador);
			}
		} catch (Exception e) {
			System.out.println("Error, the system is not available, please try later");
		}
	}
}
