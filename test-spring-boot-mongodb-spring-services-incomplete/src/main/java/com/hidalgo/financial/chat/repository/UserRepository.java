package com.hidalgo.financial.chat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hidalgo.financial.chat.entity.User;

/**
 * Servicios sobre User
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface UserRepository extends MongoRepository<User, String> {

	public User findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);

}
