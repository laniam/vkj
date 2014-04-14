/**
 * 
 */
package com.exception;

/**
 * @author Harish
 * 
 */
public class DataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2925863746687850795L;
	private String message = null;

	/**
	 * 
	 */
	public DataException() {
	}

	/**
	 * @param message
	 */
	public DataException(String message) {

		this.message = message;
	}

	/**
	 * @param cause
	 */
	public DataException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DataException(String message, Throwable cause) {

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
