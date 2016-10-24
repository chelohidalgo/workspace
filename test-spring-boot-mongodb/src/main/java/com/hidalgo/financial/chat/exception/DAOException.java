package com.hidalgo.financial.chat.exception;

/**
 * Exception for DAO pattern
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException() {
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
