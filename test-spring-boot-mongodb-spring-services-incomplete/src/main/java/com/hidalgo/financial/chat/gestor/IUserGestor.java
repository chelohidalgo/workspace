package com.hidalgo.financial.chat.gestor;

import java.io.Serializable;
import java.util.List;

import com.hidalgo.financial.chat.entity.User;

/**
 * Interfaz para conectar los servicios con los DAOs de usuario
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface IUserGestor extends Serializable {

	public void consumir();

	public User findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);

	public void saveUser(User user);
}
