package com.hidalgo.financial.chat.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hidalgo.financial.chat.Application;
import com.hidalgo.financial.chat.entity.Message;
import com.hidalgo.financial.chat.entity.Profile;
import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.exception.DAOException;
import com.hidalgo.financial.chat.repository.MessageRepository;
import com.hidalgo.financial.chat.repository.ProfileRepository;
import com.hidalgo.financial.chat.repository.UserRepository;

import junit.framework.Assert;

/**
 * Test Mongo Repositories
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class TestRepository {

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileRepository profileRepository;

	@Test
	public void testSaveUser() {
		User user = new User("Test", "Test", "test@company.com", null);
		userRepository.save(user);
	}

	@Test
	public void testFindUserByFirstName() {
		User user = null;
		try {
			user = userRepository.findByFirstName("Test");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("test@company.com", user != null ? user.getEmail() : "");
	}

	@Test
	public void testSaveMessage() {
		User user = null;
		try {
			user = userRepository.findByFirstName("Test");
			Message message = new Message(new Date(), "mensaje", user.getId());
			messageRepository.save(message);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveProfile() {
		Profile profileUser = new Profile("test", "test", "Profile test");
		profileRepository.save(profileUser);
	}

	@Test
	public void testFindUsers() {
		List<User> users = userRepository.findAll();
		Assert.assertEquals(1, users != null ? users.size() : 0);
	}

	@Test
	public void testFindProfiles() {
		List<Profile> profiles = profileRepository.findAll();
		Assert.assertEquals(1, profiles != null ? profiles.size() : 0);
	}

	@Test
	public void testFindByUserIdOrderByTimeAsc() {
		User user = null;
		List<Message> messages = null;
		try {
			user = userRepository.findByFirstName("Test");
			if (user != null) {
				Pageable pageable = new PageRequest(0, 50);
				messages = messageRepository.findByUserIdOrderByTimeAsc(user.getId(), pageable);
			}
			Assert.assertEquals(1, messages != null ? messages.size() : 0);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindMessages() {
		List<Message> messages = messageRepository.findAll();
		Assert.assertEquals(1, messages != null ? messages.size() : 0);
	}
}
