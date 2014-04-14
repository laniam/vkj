/**
 * 
 */
package com.service.users;

import java.util.List;

import org.apache.log4j.Logger;

import com.exception.DataException;
import com.exception.SystemException;
import com.managedbeans.auth.Credentials;
import com.model.enums.Role;
import com.persistence.dao.users.UserDao;
import com.persistence.dao.users.UserDaoImpl;
import com.vkj.model.User;

/**
 * @author Harish
 * 
 */
public class UserMgtService {

	private static final Logger logger = Logger.getLogger("debugger");

	/**
	 * 
	 */
	public UserMgtService() {
	}

	public User authenticate(Credentials credentials) throws SystemException {

		User user = null;
		UserDao userDao = new UserDaoImpl();

		try {

			user = userDao.authenticate(credentials.getUserName());

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}

		return user;
	}

	public List<Role> getAllRoles() throws SystemException {

		List<Role> roleList = null;
		UserDao userDao = new UserDaoImpl();

		try {

			roleList = userDao.getAllRoles();

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}

		return roleList;
	}

	public int createUser(User user) throws SystemException {

		UserDao userDao = new UserDaoImpl();

		try {

			return userDao.createUser(user);

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}
	}

	public int updateUser(User user) throws SystemException {

		UserDao userDao = new UserDaoImpl();

		try {

			return userDao.updateUser(user);

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}
	}

	public List<User> getAllUsers() throws SystemException {

		List<User> userList = null;
		UserDao userDao = new UserDaoImpl();

		try {

			userList = userDao.getAllUsers();

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}

		return userList;
	}

	public int deleteUser(long personId) throws SystemException {

		UserDao userDao = new UserDaoImpl();

		try {

			return userDao.deleteUser(personId);

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}
	}
}
