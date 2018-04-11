package com.hidalgo.sicpa.repository;

/**
 * Allow to make CRUD operations for users over the database
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
import org.springframework.data.repository.CrudRepository;

import com.hidalgo.sicpa.entity.User;
import com.hidalgo.sicpa.exception.RepositoryException;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findById(Long id) throws RepositoryException;

	public User findByName(String name) throws RepositoryException;

	public Iterable<User> findByUserName(String userName) throws RepositoryException;

	public Iterable<User> findByStatus(String status)
			throws RepositoryException;

	public Iterable<User> findByCity(String city) throws RepositoryException;

	public User findByUserNameAndPassword(String userName, String password)
			throws RepositoryException;

}
