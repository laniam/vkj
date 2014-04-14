/**
 * 
 */
package com.exception;

/**
 * @author Harish
 *
 */
public class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426170590940514785L;
	
	private String message = null;

	/**
	 * 
	 */
	public SystemException() {
	}

	/**
	 * @param message
	 */
	public SystemException(String message) {
		this.message = message;
	}

	/**
	 * @param cause
	 */
	public SystemException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SystemException(String message, Throwable cause) {
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
