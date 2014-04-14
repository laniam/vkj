/**
 * 
 */
package com.service.menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.exception.DataException;
import com.persistence.dao.menus.MenuDaoImpl;
import com.vkj.model.Menu;

/**
 * @author Harish
 * 
 */
public class MenuMgtService {

	private static final Logger logger = Logger.getLogger("debugger");

	/**
	 * 
	 */
	public MenuMgtService() {
	}

	public Map<String, List<Menu>> getMenusForRole(int roleId) {

		Map<String, List<Menu>> menuMap = null;

		try {

			List<Menu> menuObjList = new MenuDaoImpl().getMenusForRole(roleId);

			Collections.sort(menuObjList);
			menuMap = new HashMap<String, List<Menu>>();
			Iterator<Menu> itr = menuObjList.iterator();

			while (itr.hasNext()) {

				Menu menu = itr.next();

				switch (menu.getParentId()) {

				case 0:

					List<Menu> menuList = new ArrayList<Menu>();

					for (Object obj : menuObjList) {

						Menu m = (Menu) obj;
						
						if (m.getParentId() == menu.getMenuId()) {

							menuList.add(m);
						}
					}

					menuMap.put(menu.getLabel(), menuList);

					break;
				}
				
				itr.remove();
			}

		} catch (DataException e) {

			logger.debug("DataException: " + e);

		} catch (Exception e) {

			logger.debug("Exception: " + e);
		}

		return menuMap;
	}
}
