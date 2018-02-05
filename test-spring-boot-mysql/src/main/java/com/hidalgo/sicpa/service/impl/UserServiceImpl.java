package com.hidalgo.sicpa.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hidalgo.sicpa.entity.User;
import com.hidalgo.sicpa.exception.StoreException;
import com.hidalgo.sicpa.repository.UserRepository;
import com.hidalgo.sicpa.service.UserService;

/**
 * Implementation of services for user
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> findAll() throws StoreException {
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find all users");
		}
	}

	@Override
	public void saveUser(User user) throws StoreException {
		try {
			userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			LOG.error("Error: There is an user with the same id");
			throw new StoreException("Error: There is an user with the same id");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to save user");
		}
	}

	@Override
	public void updateUser(User user) throws StoreException {
		User userAux = null;
		try {
			userAux = userRepository.findOne(user.getIdUser());
			if (userAux != null) {
				userAux.setUserName(user.getUserName());
				userAux.setId(user.getId());
				userAux.setPassword(user.getPassword());
				userAux.setName(user.getName());
				userAux.setCity(user.getCity());
				userAux.setMail(user.getMail());
				userAux.setStatus(user.getStatus());
				userRepository.save(userAux);
			} else {
				LOG.info("User not founded");
				throw new StoreException("User not founded, try again");
			}
		} catch (DataIntegrityViolationException e) {
			LOG.error("Error: There is an user with the same id");
			throw new StoreException("Error: There is an user with the same id");
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to update the user");
		}
	}

	@Override
	public void removeUser(User user) throws StoreException {
		User userAux = null;
		try {
			userAux = userRepository.findById(user.getId());
			if (userAux != null) {
				userAux.setStatus(user.getStatus());
				userRepository.save(userAux);
			} else {
				LOG.info("User not founded");
				throw new StoreException("User not founded, try again");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to remove the user");
		}
	}

	@Override
	public void deleteAll() throws StoreException {
		try {
			userRepository.deleteAll();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to remove all users");
		}
	}

	@Override
	public Iterable<User> findByUserName(String userName) throws StoreException {
		try {
			return userRepository.findByUserName(userName);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find user by username");
		}
	}

	@Override
	public User findById(Long id) throws StoreException {
		try {
			return userRepository.findById(id);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find user by id");
		}
	}

	@Override
	public Iterable<User> findByStatus(String status) throws StoreException {
		try {
			return userRepository.findByStatus(status);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find users by status");
		}
	}

	@Override
	public Iterable<User> findByCity(String city) throws StoreException {
		try {
			return userRepository.findByCity(city);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find users by city");
		}
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password)
			throws StoreException {
		try {
			return userRepository.findByUserNameAndPassword(userName, password);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find user by userName and password");
		}
	}

	@Override
	public User findByIdUser(Long id) throws StoreException {
		try {
			return userRepository.findOne(id);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new StoreException(
					"Error: something wrong happen trying to find user by idUser");
		}
	}

}
