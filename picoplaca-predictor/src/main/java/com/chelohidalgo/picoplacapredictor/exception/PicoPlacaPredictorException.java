package com.chelohidalgo.picoplacapredictor.exception;

public class PicoPlacaPredictorException extends Exception {

	private static final long serialVersionUID = -1869497885298710598L;

	public PicoPlacaPredictorException() {
		super();
	}

	public PicoPlacaPredictorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PicoPlacaPredictorException(String message, Throwable cause) {
		super(message, cause);
	}

	public PicoPlacaPredictorException(String message) {
		super(message);
	}

	public PicoPlacaPredictorException(Throwable cause) {
		super(cause);
	}

}
