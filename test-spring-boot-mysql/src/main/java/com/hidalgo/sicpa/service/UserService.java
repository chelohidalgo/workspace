package com.hidalgo.sicpa.service;

import java.io.Serializable;

import com.hidalgo.sicpa.entity.User;
import com.hidalgo.sicpa.exception.StoreException;

/**
 * Services for user
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
public interface UserService extends Serializable {

	public Iterable<User> findAll() throws StoreException;

	public void saveUser(User user) throws StoreException;

	public void updateUser(User user) throws StoreException;

	public void removeUser(User user) throws StoreException;

	public void deleteAll() throws StoreException;

	public Iterable<User> findByUserName(String userName) throws StoreException;

	public User findById(Long id) throws StoreException;

	public Iterable<User> findByStatus(String status) throws StoreException;

	public Iterable<User> findByCity(String city) throws StoreException;

	public User findByUserNameAndPassword(String userName, String password)
			throws StoreException;

	public User findByIdUser(Long id) throws StoreException;
}
