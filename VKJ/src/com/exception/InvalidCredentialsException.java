/**
 * 
 */
package com.exception;

/**
 * @author Harish
 *
 */
public class InvalidCredentialsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3009788233387097200L;
	
	private String message = null;

	/**
	 * 
	 */
	public InvalidCredentialsException() {
	}

	/**
	 * @param message
	 */
	public InvalidCredentialsException(String message) {
		
		this.message = message;
	}

	/**
	 * @param cause
	 */
	public InvalidCredentialsException(Throwable cause) {
		
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidCredentialsException(String message, Throwable cause) {
		
		super(message, cause);
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {

		return this.message;
	}
}
