/**
 * 
 */
package com.exception;

/**
 * @author Harish
 * 
 */
public class ResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6558311785314035780L;
	private String message = null;

	/**
	 * 
	 */
	public ResourceException() {
	}

	/**
	 * @param message
	 */
	public ResourceException(String message) {

		this.message = message;
	}

	/**
	 * @param cause
	 */
	public ResourceException(Throwable cause) {

		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResourceException(String message, Throwable cause) {

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
