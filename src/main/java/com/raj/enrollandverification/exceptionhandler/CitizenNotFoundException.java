package com.raj.enrollandverification.exceptionhandler;

public class CitizenNotFoundException extends RuntimeException	 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CitizenNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CitizenNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CitizenNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CitizenNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CitizenNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
