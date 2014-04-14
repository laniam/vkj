/**
 * 
 */
package com.managedbeans.auth;

import java.io.Serializable;

/**
 * @author Harish
 * 
 */
public class Credentials implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -747049805364147460L;

	private String userName = null;
	private String password = null;

	/**
	 * 
	 */
	public Credentials() {
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
