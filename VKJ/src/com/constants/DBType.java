/**
 * 
 */
package com.constants;

/**
 * @author Harish
 * 
 */
public enum DBType {

	ORACLE("oracle"), SQLSERVER("sqlserver"), DB2("db2"), SYBASE("sybase"), MYSQL(
			"mysql");

	private String dbEngine = null;

	private DBType(String dbEngine) {

		this.dbEngine = dbEngine;
	}

	/**
	 * @return the dbEngine
	 */
	public String getDbEngine() {

		return this.dbEngine;
	}
}
