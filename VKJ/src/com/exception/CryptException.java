/**
 * 
 */
package com.exception;

/**
 * @author Harish
 * 
 */
public class CryptException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5678081058204030857L;
	private String message = null;

	/**
	 * 
	 */
	public CryptException() {
	}

	/**
	 * @param message
	 */
	public CryptException(String message) {

		this.message = message;
	}

	/**
	 * @param cause
	 */
	public CryptException(Throwable cause) {

		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CryptException(String message, Throwable cause) {

		super(message, cause);
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {

		return this.message;
	}
}
