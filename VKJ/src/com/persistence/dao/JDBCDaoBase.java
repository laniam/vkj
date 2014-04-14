/**
 * 
 */
package com.persistence.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.exception.ContextLookUpException;
import com.exception.DataException;
import com.util.AppUtils;

/**
 * @author Harish
 * 
 */
public class JDBCDaoBase implements JDBCDao {

	private static final Logger logger = Logger.getLogger("debugger");
	
	private static JDBCDaoBase instance = null;

	/**
	 * 
	 */
	private JDBCDaoBase() {
	}

	public synchronized static JDBCDaoBase getInstance() {

		if (instance == null) {

			instance = new JDBCDaoBase();
		}

		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.persistence.dao.JDBCDao#getConnection()
	 */
	@Override
	public Connection getConnection() throws DataException,
			ContextLookUpException, Exception {

		Connection connection = null;
		Context ctx = null;
		DataSource dataSource = null;
		String dataSourceName = AppUtils.getAppDataSourceName();

		try {

			ctx = new InitialContext();
			dataSource = (DataSource) (ctx.lookup("java:comp/env/" + dataSourceName));
			connection = dataSource.getConnection();

		} catch (NamingException e) {

			logger.debug("NamingException: " + e);
			throw new ContextLookUpException(
					"Unable to lookup Context information or datasource information");

		} catch (SQLException e) {

			logger.debug("SQLException: " + e);
			throw new DataException("Unable to get DataBase Connection");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw e;
		}

		return connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException();
	}
}
