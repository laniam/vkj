/**
 * 
 */
package com.crypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

import com.exception.CryptException;

/**
 * @author Harish
 * 
 */
public class CryptManager {

	/**
	 * 
	 */
	public CryptManager() {
	}

	public String encrypt(String inputString) throws CryptException {

		String encryptedString = null;
		MessageDigest messageDigest = null;

		try {

			messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(inputString.getBytes("UTF-8"));

			byte[] rawBytes = messageDigest.digest();

			BASE64Encoder base64Encoder = new BASE64Encoder();
			encryptedString = base64Encoder.encode(rawBytes);

		} catch (NoSuchAlgorithmException e) {

			throw new CryptException("Invalid Algorithm");

		} catch (UnsupportedEncodingException e) {

			throw new CryptException("Invalid Encoding used");

		} catch (Exception e) {

			throw new CryptException("System Exception");
		}

		return encryptedString;
	}
}
