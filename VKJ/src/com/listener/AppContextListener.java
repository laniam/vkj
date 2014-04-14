package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.util.AppUtils;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 * 
 */
public class AppContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public AppContextListener() {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		ServletContext servletContext = servletContextEvent.getServletContext();

		String dataSourceName = servletContext
				.getInitParameter("jndiDataSourceName");
		AppUtils.setAppDataSourceName(dataSourceName);
		System.setProperty("appRoot", servletContext.getRealPath("/"));

		String dbType = servletContext.getInitParameter("dbType");
		AppUtils.setDbType(dbType);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

		AppUtils.setAppDataSourceName(null);
		System.clearProperty("appRoot");
	}
}
