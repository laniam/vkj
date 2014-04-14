/**
 * 
 */
package com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.DBType;
import com.exception.ResourceException;

/**
 * @author Harish
 * 
 */
public class SQLPropertyManager {

	private static SQLPropertyManager instance = null;
	private static String queryFileName = null;

	static {

		String appDataBase = AppUtils.getDbType();

		if (appDataBase.equals(DBType.ORACLE.getDbEngine())) {

			queryFileName = "Queries-oracle.properties";

		} else if (appDataBase.equals(DBType.SQLSERVER.getDbEngine())) {

			queryFileName = "Queries-sqlserver.properties";

		} else if (appDataBase.equals(DBType.SYBASE.getDbEngine())) {

			queryFileName = "Queries-sybase.properties";

		} else if (appDataBase.equals(DBType.DB2.getDbEngine())) {

			queryFileName = "Queries-db2.properties";

		} else if (appDataBase.equals(DBType.MYSQL.getDbEngine())) {

			queryFileName = "Queries-mysql.properties";
		}
	}

	/**
	 * 
	 */
	private SQLPropertyManager() {
	}

	public static synchronized SQLPropertyManager getInstance() {

		if (instance == null) {

			instance = new SQLPropertyManager();
		}

		return instance;
	}

	public String getSQLQuery(String queryName) throws ResourceException,
			Exception {

		String queryString = null;
		String appRoot = null;

		StringBuilder pathBuilder = new StringBuilder();

		try {

			appRoot = System.getProperty("appRoot");

		} catch (Exception e) {

			throw new Exception("Exception while reading system property: " + e);
		}

		try {

			pathBuilder.append(appRoot);
			pathBuilder.append("properties/queries/");
			pathBuilder.append(queryFileName);

			Properties properties = new Properties();

			properties.load(new FileReader(pathBuilder.toString()));
			queryString = properties.getProperty(queryName);

		} catch (FileNotFoundException e) {

			throw new ResourceException("Unable to locate resource file");

		} catch (IOException e) {

			throw new ResourceException("Exception reading resource file");

		} catch (Exception e) {

			throw new ResourceException(
					"Other exception while locating/reading resource file");

		}

		return queryString;
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
