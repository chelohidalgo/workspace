package com.hidalgo.financial.chat.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity for profiles collection in Mongo DB
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@Document(collection = "profiles")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Indexed(unique = true)
	private String idProfile;

	private String name;
	private String description;

	/**
	 * Entity for users collection in Mongo DB
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 */
	public Profile(String idProfile, String name, String description) {
		this.idProfile = idProfile;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Profile[id=%s, idProfile='%s', name='%s',description='%s']", id, idProfile, name,
				description);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(String idProfile) {
		this.idProfile = idProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
