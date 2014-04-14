/**
 * 
 */
package com.persistence.dao;

import java.sql.Connection;

import com.exception.ContextLookUpException;
import com.exception.DataException;

/**
 * @author Harish
 * 
 */
public interface JDBCDao {

	public Connection getConnection() throws DataException,
			ContextLookUpException, Exception;
}
