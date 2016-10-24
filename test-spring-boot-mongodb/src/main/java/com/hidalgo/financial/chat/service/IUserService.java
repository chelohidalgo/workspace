package com.hidalgo.financial.chat.service;

import java.io.Serializable;
import java.util.List;

import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.exception.FinancialChatException;

/**
 * Interface with services over users
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface IUserService extends Serializable {

	/**
	 * Find user using his/her first name
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @param firstName
	 *            : first name of user
	 * @return User : user founded
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public User findByFirstName(String firstName) throws FinancialChatException;

	/**
	 * Find all the users
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @return List<User> : users founded
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public List<User> findAll() throws FinancialChatException;

	/**
	 * Save an user
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public void saveUser(User user) throws FinancialChatException;

	/**
	 * Delete all users
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public void deleteAll() throws FinancialChatException;

	/**
	 * Find an user by email
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @param email
	 *            : email of user
	 * @return User : user founded
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public User findByEmail(String email) throws FinancialChatException;
}
