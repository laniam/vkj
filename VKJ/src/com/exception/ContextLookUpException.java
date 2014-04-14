/**
 * 
 */
package com.exception;

/**
 * @author Harish
 * 
 */
public class ContextLookUpException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6667553800418230686L;

	private String message = null;

	/**
	 * 
	 */
	public ContextLookUpException() {
	}

	/**
	 * @param message
	 */
	public ContextLookUpException(String message) {

		this.message = message;
	}

	/**
	 * @param cause
	 */
	public ContextLookUpException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ContextLookUpException(String message, Throwable cause) {

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
