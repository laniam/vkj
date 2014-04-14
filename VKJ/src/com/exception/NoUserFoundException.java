/**
 * 
 */
package com.exception;

/**
 * @author Harish
 * 
 */
public class NoUserFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7683152528162868338L;
	private String message = null;

	/**
	 * 
	 */
	public NoUserFoundException() {
	}

	/**
	 * @param message
	 */
	public NoUserFoundException(String message) {

		this.message = message;
	}

	/**
	 * @param cause
	 */
	public NoUserFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoUserFoundException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

}
