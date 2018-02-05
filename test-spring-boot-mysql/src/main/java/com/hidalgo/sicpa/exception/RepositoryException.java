package com.hidalgo.sicpa.exception;

/**
 * Exception for DAO pattern
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
public class RepositoryException extends Exception {

	public RepositoryException() {
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
