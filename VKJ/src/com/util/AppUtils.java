/**
 * 
 */
package com.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.constants.MessageConstants;

/**
 * @author Harish
 * 
 */
public class AppUtils {

	private static String appDataSourceName = null;
	private static String dbType = null;

	/**
	 * @return the appDataSourceName
	 */
	public static String getAppDataSourceName() {
		return appDataSourceName;
	}

	/**
	 * @param appDataSourceName
	 *            the appDataSourceName to set
	 */
	public static void setAppDataSourceName(String appDataSourceName) {
		AppUtils.appDataSourceName = appDataSourceName;
	}

	/**
	 * @return the dbType
	 */
	public static String getDbType() {
		return dbType;
	}

	/**
	 * @param dbType
	 *            the dbType to set
	 */
	public static void setDbType(String dbType) {
		AppUtils.dbType = dbType;
	}

	public static HttpSession getSession(FacesContext facesContext) {

		HttpSession session = null;

		HttpServletRequest request = (HttpServletRequest) (facesContext
				.getExternalContext().getRequest());
		session = request.getSession();

		return session;
	}

	public static FacesMessage getFacesMessage(FacesContext facesContext,
			String message, byte messageType) {

		FacesMessage facesMessage = null;

		if (message != null) {

			facesMessage = new FacesMessage(message);

			switch (messageType) {

			case MessageConstants.MSG_INFO:
			default:

				facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
				break;

			case MessageConstants.MSG_WARN:

				facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
				break;

			case MessageConstants.MSG_ERROR:

				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				break;

			case MessageConstants.MSG_FATAL:

				facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				break;
			}
		}

		return facesMessage;
	}

	/**
	 * 
	 */
	public AppUtils() {
	}
}
