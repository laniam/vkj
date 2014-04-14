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
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.constants.QueryConstants;
import com.exception.DataException;
import com.persistence.dao.JDBCDaoBase;
import com.persistence.dao.production.Production;
import com.util.SQLPropertyManager;
import com.vkj.productionModels.FactoryProduction;

/**
 * @author ardhani
 * 
 */
public class ProdDaoImpl implements ProdDao {
	private static final Logger logger = Logger.getLogger("debugger");

	@Override
	public int createFactoryProduction(FactoryProduction production)
			throws DataException, Exception {
		ObjectMapper mapper = new ObjectMapper();
		String value = mapper.writeValueAsString(production);
		String prodName = production.getProductionName();
		String prodType = "Factory";
		Connection con = null;
		CallableStatement cs = null;
		try {
			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_CREATE_PRODS);
			cs = con.prepareCall(queryString);
			cs.setString(1, prodName);
			cs.setString(2, prodType);
			cs.setString(3, value);
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

	@Override
	public List<Production> getAllFactoryProductions() throws DataException,
			Exception {
		List<Production> productionList = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = JDBCDaoBase.getInstance().getConnection();
		String queryString = SQLPropertyManager.getInstance().getSQLQuery(
				QueryConstants.QRY_FETCH_ALL_PRODS);

		ps = con.prepareStatement(queryString);
		rs = ps.executeQuery();
		logger.debug(queryString);
		productionList = new ArrayList<Production>();
		while (rs.next()) {
			Production prod = new Production();
			prod.setProdID(rs.getInt(1));
			prod.setProdName(rs.getString(2));
			prod.setProdType(rs.getString(3));
			prod.setProdDetalsStr(rs.getString(4));
			prod.setProdDate("");
			prod.init();
			productionList.add(prod);
		}

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

		return productionList;
	}

	@Override
	public void updateFactoryProduction(FactoryProduction production)
			throws DataException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteProduction(int prodId) throws DataException, Exception {

		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_DELETE_PRODS);

			ps = con.prepareStatement(queryString);
			ps.setLong(1, prodId);
			count = ps.executeUpdate();
			logger.debug(queryString.replaceAll("\\?", "" + prodId));
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
}
