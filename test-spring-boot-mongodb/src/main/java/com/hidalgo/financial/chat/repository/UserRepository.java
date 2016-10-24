package com.hidalgo.financial.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.exception.DAOException;

/**
 * Services allowed for user
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * Return a user founded by his/her first name as a parameter
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @param firstName
	 *            : first name of user
	 * @return User : user founded
	 * @throws DAOException
	 *             : exception in case of error
	 */
	public User findByFirstName(String firstName) throws DAOException;

	/**
	 * Return a user founded by his/her email as a parameter
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @param email
	 *            : email of user
	 * @return User : user founded
	 * @throws DAOException
	 *             : exception in case of error
	 */
	public User findByEmail(String email) throws DAOException;

}
