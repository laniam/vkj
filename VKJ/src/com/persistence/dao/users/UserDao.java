/**
 * 
 */
package com.persistence.dao.users;

import java.util.List;

import com.exception.DataException;
import com.model.enums.Role;
import com.vkj.model.User;

/**
 * @author Harish
 * 
 */
public interface UserDao {

	public User authenticate(String userName) throws DataException, Exception;
	
	public List<Role> getAllRoles() throws DataException, Exception;
	
	public int createUser(User user) throws DataException, Exception;
	
	public List<User> getAllUsers() throws DataException, Exception;
	
	public int updateUser(User user) throws DataException, Exception;
	
	public int deleteUser(long personId) throws DataException, Exception;
	
	public int deleteUsers(List<User> userList) throws DataException, Exception;
}