package com.hidalgo.financial.chat.exception;

/**
 * Exception for services layer
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
public class FinancialChatException extends Exception {

	public FinancialChatException() {
	}

	public FinancialChatException(String message) {
		super(message);
	}

	public FinancialChatException(Throwable cause) {
		super(cause);
	}

	public FinancialChatException(String message, Throwable cause) {
		super(message, cause);
	}

}
