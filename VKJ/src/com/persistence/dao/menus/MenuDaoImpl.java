/**
 * 
 */
package com.persistence.dao.menus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.constants.QueryConstants;
import com.exception.DataException;
import com.persistence.dao.JDBCDaoBase;
import com.util.SQLPropertyManager;
import com.vkj.model.Menu;

/**
 * @author Harish
 * 
 */
public class MenuDaoImpl implements MenuDao {

	private static final Logger logger = Logger.getLogger("debugger");

	/**
	 * 
	 */
	public MenuDaoImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.persistence.dao.menus.MenuDao#getMenusForRole(int)
	 */
	@Override
	public List<Menu> getMenusForRole(int roleId) throws DataException,
			Exception {

		List<Menu> menuList = null;
		Menu menu = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_MENU_DISPLAY);

			ps = con.prepareStatement(queryString);
			ps.setInt(1, roleId);

			rs = ps.executeQuery();

			logger.debug(queryString.replaceAll("\\?", String.valueOf(roleId)));

			if (rs != null) {

				menuList = new ArrayList<Menu>();

				while (rs.next()) {

					menu = new Menu();
					menu.setMenuId(rs.getByte("MENU_ID"));
					menu.setLabel(rs.getString("LABEL"));
					menu.setUrl(rs.getString("URL"));
					menu.setParentId(rs.getByte("PARENT_ID"));

					menuList.add(menu);
				}
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

		return menuList;
	}
}
