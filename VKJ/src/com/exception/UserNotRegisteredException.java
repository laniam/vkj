/**
 * 
 */
package com.exception;

/**
 * @author Harish
 * 
 */
public class UserNotRegisteredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3944659409852134165L;

	private String message = null;

	/**
	 * 
	 */
	public UserNotRegisteredException() {
	}

	/**
	 * @param message
	 */
	public UserNotRegisteredException(String message) {

		this.message = message;
	}

	/**
	 * @param cause
	 */
	public UserNotRegisteredException(Throwable cause) {

		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UserNotRegisteredException(String message, Throwable cause) {

		super(message, cause);
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {

		return this.message;
	}
}
