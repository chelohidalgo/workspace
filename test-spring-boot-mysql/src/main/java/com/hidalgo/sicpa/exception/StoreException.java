package com.hidalgo.sicpa.exception;

/**
 * Exception to manage the service layer
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
public class StoreException extends Exception {
	
	public StoreException() {
	}

	public StoreException(String message) {
		super(message);
	}

	public StoreException(Throwable cause) {
		super(cause);
	}

	public StoreException(String message, Throwable cause) {
		super(message, cause);
	}

}
