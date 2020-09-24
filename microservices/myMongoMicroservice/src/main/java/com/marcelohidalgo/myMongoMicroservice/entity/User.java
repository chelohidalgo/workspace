package com.marcelohidalgo.myMongoMicroservice.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity for users collection in Mongo DB
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@Document(collection = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Indexed(unique = true)
	private String email;

	private String firstName;
	private String lastName;

	@DBRef
	private Profile profile;

	/**
	 * Constructor by default
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 */
	public User() {
	}

	/**
	 * Constructor using its parameters
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 */
	public User(String firstName, String lastName, String email, Profile profile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.profile = profile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {	
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", profile=" + profile
				+ "]";
	}
	
	
	
}
