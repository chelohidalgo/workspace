package com.chelohidalgo.picoplacapredictor.exception;

public class PicoPlacaDayException extends Exception {

	private static final long serialVersionUID = -8576109877923421083L;

	public PicoPlacaDayException() {
		super();
	}

	public PicoPlacaDayException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PicoPlacaDayException(String message, Throwable cause) {
		super(message, cause);
	}

	public PicoPlacaDayException(String message) {
		super(message);
	}

	public PicoPlacaDayException(Throwable cause) {
		super(cause);
	}

}
