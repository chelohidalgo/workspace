package com.hidalgo.financial.chat.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity for messages collection in Mongo DB
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@Document(collection = "messages")
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private Date time;
	private String content;
	private String userId;

	/**
	 * Consructor
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 */
	public Message(Date time, String content, String userId) {
		this.time = time;
		this.content = content;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return String.format("Message[id=%s, time='%s', content='%s',userId='%s']", id, time, content, userId);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser_id() {
		return userId;
	}

	public void setUser_id(String userId) {
		this.userId = userId;
	}

}
