/**
 * 
 */
package com.persistence.dao.menus;

import java.util.List;

import com.exception.DataException;
import com.vkj.model.Menu;

/**
 * @author Harish
 * 
 */
public interface MenuDao {

	public List<Menu> getMenusForRole(int roleId) throws DataException, Exception;
}
