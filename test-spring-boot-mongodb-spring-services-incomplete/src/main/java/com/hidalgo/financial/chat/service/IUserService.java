package com.hidalgo.financial.chat.service;

import java.io.Serializable;
import java.util.List;

import com.hidalgo.financial.chat.entity.User;

/**
 * Interfaz que ofrece los servicios sobre usuario
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface IUserService extends Serializable{

	public void consumir();
	
	public User findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);
	
	public void saveUser(User user);
}
