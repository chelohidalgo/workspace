package com.hidalgo.financial.chat.service.impl;

import java.util.List;

import com.hidalgo.financial.chat.entity.User;
import com.hidalgo.financial.chat.gestor.IUserGestor;
import com.hidalgo.financial.chat.service.IUserService;

/**
 * Implementacion de los servicios disponibles sobre usuario
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
public class UserService implements IUserService{
	
	private IUserGestor userGestor;

	public IUserGestor getUserGestor() {
		return userGestor;
	}

	public void setUserGestor(IUserGestor userGestor) {
		this.userGestor = userGestor;
	}

	@Override
	public void consumir() {
		System.out.println("ENTER al servicio");
		this.userGestor.consumir();
		System.out.println("EXIT al servicio");
	}

	@Override
	public User findByFirstName(String firstName) {
		return this.userGestor.findByFirstName(firstName);
	}

	@Override
	public List<User> findByLastName(String lastName) {
		return this.userGestor.findByLastName(lastName);
	}

	@Override
	public void saveUser(User user) {
		this.userGestor.saveUser(user);
		
	}

}
