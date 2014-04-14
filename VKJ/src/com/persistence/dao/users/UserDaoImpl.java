/**
 * 
 */
package com.persistence.dao.users;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.constants.QueryConstants;
import com.exception.DataException;
import com.model.enums.Role;
import com.persistence.dao.JDBCDaoBase;
import com.util.SQLPropertyManager;
import com.vkj.model.Person;
import com.vkj.model.User;

/**
 * @author Harish
 * 
 */
public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger("debugger");

	/**
	 * 
	 */
	public UserDaoImpl() {
	}

	@Override
	public User authenticate(String userName) throws DataException, Exception {

		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_AUTH_USER);

			ps = con.prepareStatement(queryString);
			ps.setString(1, userName);

			rs = ps.executeQuery();
			
			logger.debug(queryString.replaceAll("\\?", userName));

			while (rs.next()) {

				user = new User();
				Person person = new Person();
				Role role = new Role();

				person.setPersonId(rs.getInt(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				
				role.setRoleId(rs.getInt(4));
				role.setRoleName(rs.getString(5));
				
				user.setLoginId(userName);				
				user.setPassword(rs.getString(6));
				
				user.setPerson(person);
				user.setRole(role);
			}

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw e;

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw e;

		} finally {

			if (rs != null) {

				try {

					rs.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				rs = null;
			}

			if (ps != null) {

				try {

					ps.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				ps = null;
			}

			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				con = null;
			}
		}

		return user;
	}

	/* (non-Javadoc)
	 * @see com.persistence.dao.users.UserDao#getAllRoles()
	 */
	@Override
	public List<Role> getAllRoles() throws DataException, Exception {
		
		List<Role> roleList = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_FETCH_ALL_ROLES);

			ps = con.prepareStatement(queryString);
			rs = ps.executeQuery();
			
			roleList = new ArrayList<Role>();
			logger.debug(queryString);

			while (rs.next()) {

				Role role = new Role();
				role.setRoleId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				
				roleList.add(role);
			}
			
			Collections.sort(roleList);

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw e;

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw e;

		} finally {

			if (rs != null) {

				try {

					rs.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				rs = null;
			}

			if (ps != null) {

				try {

					ps.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				ps = null;
			}

			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				con = null;
			}
		}
		
		return roleList;
	}

	/* (non-Javadoc)
	 * @see com.persistence.dao.users.UserDao#createUser(com.model.users.User)
	 */
	@Override
	public int createUser(User user) throws DataException, Exception {
		
		Connection con = null;
		CallableStatement cs = null;
		
		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_CREATE_USER);

			cs = con.prepareCall(queryString);
			cs.setInt(1, user.getRole().getRoleId());
			cs.setString(2, user.getPassword());
			cs.setString(3, user.getPerson().getFirstName());
			cs.setString(4, user.getPerson().getLastName());
			cs.setString(5, String.valueOf(user.getPerson().getGender()));
			cs.setString(6, user.getPerson().getEmailId());
			cs.setString(7, user.getPerson().getMobileNo());
			cs.setInt(8, user.getCreatedBy());
			
			if (cs.execute()) {
			
				logger.debug(queryString);
				return 1;
			}

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw e;

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw e;

		} finally {

			if (cs != null) {

				try {

					cs.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				cs = null;
			}

			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				con = null;
			}
		}
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.persistence.dao.users.UserDao#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() throws DataException, Exception {
		
		List<User> userList = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_FETCH_ALL_USERS);

			ps = con.prepareStatement(queryString);
			rs = ps.executeQuery();
			
			logger.debug(queryString);
			userList = new ArrayList<User>();

			while (rs.next()) {

				User user = new User();
				Person person = new Person();
				Role role = new Role();

				person.setPersonId(rs.getInt(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setGender(rs.getString(4).toCharArray()[0]);
				person.setEmailId(rs.getString(5));
				person.setMobileNo(rs.getString(6));
				
				role.setRoleId(rs.getInt(7));
				role.setRoleName(rs.getString(8));
				
				user.setPerson(person);
				user.setRole(role);
				
				userList.add(user);
			}

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw e;

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw e;

		} finally {

			if (rs != null) {

				try {

					rs.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				rs = null;
			}

			if (ps != null) {

				try {

					ps.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				ps = null;
			}

			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				con = null;
			}
		}

		return userList;
	}

	/* (non-Javadoc)
	 * @see com.persistence.dao.users.UserDao#updateUser(com.model.users.User)
	 */
	@Override
	public int updateUser(User user) throws DataException, Exception {

		Connection con = null;
		CallableStatement cs = null;
		
		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_UPDATE_USER);

			cs = con.prepareCall(queryString);
			cs.setInt(1, user.getModifiedBy());
			cs.setString(2, user.getPerson().getFirstName());
			cs.setString(3, user.getPerson().getLastName());
			cs.setString(4, user.getPerson().getEmailId());
			cs.setString(5, user.getPerson().getMobileNo());
			cs.setInt(6, user.getRole().getRoleId());
			cs.setInt(7, user.getPerson().getPersonId());
			
			if (cs.execute()) {
			
				logger.debug(queryString);
				return 1;
			}

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw e;

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw e;

		} finally {

			if (cs != null) {

				try {

					cs.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				cs = null;
			}

			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				con = null;
			}
		}
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.persistence.dao.users.UserDao#deleteUser(long)
	 */
	@Override
	public int deleteUser(long personId) throws DataException, Exception {

		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;

		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_DELETE_USER);

			ps = con.prepareStatement(queryString);
			ps.setLong(1, personId);
			count = ps.executeUpdate();
			
			logger.debug(queryString.replaceAll("\\?", "" + personId));

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw e;

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw e;

		} finally {

			if (ps != null) {

				try {

					ps.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				ps = null;
			}

			if (con != null) {

				try {

					con.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}

				con = null;
			}
		}
		
		return count;
	}

	/* (non-Javadoc)
	 * @see com.persistence.dao.users.UserDao#deleteUsers(java.util.List)
	 */
	@Override
	public int deleteUsers(List<User> userList) throws DataException,
			Exception {

		return 0;
	}
}
