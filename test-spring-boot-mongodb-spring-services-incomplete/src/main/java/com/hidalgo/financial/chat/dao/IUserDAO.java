package com.hidalgo.financial.chat.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hidalgo.financial.chat.entity.User;

/**
 * Interfaz que ofrece los servicios sobre la base de datos de usuario
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface IUserDAO extends MongoRepository<User, String>{
	
	public void consumir();
	
	public User findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);
//	
//	public void saveUser(User user);

}
