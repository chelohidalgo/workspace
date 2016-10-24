package com.hidalgo.financial.chat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.exception.FinancialChatException;
import com.hidalgo.financial.chat.repository.UserRepository;
import com.hidalgo.financial.chat.service.IUserService;

/**
 * Implementacion de servicios para conectar servicios con DAOs de usuario
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
@Service
public class UserService implements IUserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByFirstName(String firstName) throws FinancialChatException {
		try {
			return this.userRepository.findByFirstName(firstName);
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to find a user by first name");
		}
	}

	@Override
	public void saveUser(User user) throws FinancialChatException {
		try {
			this.userRepository.save(user);
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to save an user");
		}
	}

	@Override
	public List<User> findAll() throws FinancialChatException {
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to fin all the users");
		}
	}

	@Override
	public void deleteAll() throws FinancialChatException {
		try {
			this.userRepository.deleteAll();
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to delete all users");
		}
	}

	@Override
	public User findByEmail(String email) throws FinancialChatException {
		try {
			return this.userRepository.findByEmail(email);
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to find ans user by email");
		}
	}

}
