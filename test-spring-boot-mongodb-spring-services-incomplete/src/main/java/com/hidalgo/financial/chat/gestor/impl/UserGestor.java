package com.hidalgo.financial.chat.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hidalgo.financial.chat.dao.IUserDAO;
import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.gestor.IUserGestor;

/**
 * Implementacion de servicios para conectar servicios con DAOs de usuario
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
public class UserGestor implements IUserGestor{
	
	private IUserDAO userDAO;
	
	@Autowired
	public UserGestor(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void consumir() {
		System.out.println("ENTER AL GESTOR");
		this.userDAO.consumir();
		System.out.println("EXIT DEL GESTOR");
	}

	@Override
	public User findByFirstName(String firstName) {
		return this.userDAO.findByFirstName(firstName);
	}

	@Override
	public List<User> findByLastName(String lastName) {
		return this.userDAO.findByLastName(lastName);
	}

	@Override
	public void saveUser(User user) {
		this.userDAO.save(user);
	}

}
