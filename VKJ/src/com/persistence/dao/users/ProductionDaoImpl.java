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

import com.constants.QueryConstants;
import com.exception.DataException;
import com.model.enums.ProductionType;
import com.model.enums.Stages;
import com.persistence.dao.JDBCDaoBase;
import com.util.SQLPropertyManager;
import com.vkj.model.Production;

/**
 * @author ardhani
 * 
 */
public class ProductionDaoImpl implements ProductionDao {

	private static final Logger logger = Logger.getLogger("debugger");

	/**
	 * 
	 */
	public ProductionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.persistence.dao.users.ProductionDao#getAllStages()
	 */
	@Override
	public List<Stages> getAllStages() throws DataException, Exception {
		List<Stages> stagesList = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_ALL_STAGES);

			ps = con.prepareStatement(queryString);
			rs = ps.executeQuery();

			stagesList = new ArrayList<Stages>();
			while (rs.next()) {

				Stages stage = new Stages();
				stage.setStageName(rs.getString(1));
				stage.setStageDescription(rs.getString(2));

				stagesList.add(stage);
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

		return stagesList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.persistence.dao.users.ProductionDao#getAllProductionTypes()
	 */
	@Override
	public List<ProductionType> getAllProductionTypes() throws DataException,
			Exception {
		List<ProductionType> prodTYpeList = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_ALL_PROD_TYPES);

			ps = con.prepareStatement(queryString);
			rs = ps.executeQuery();

			prodTYpeList = new ArrayList<ProductionType>();
			while (rs.next()) {

				ProductionType prodType = new ProductionType();
				prodType.setProductionTypeDescription(rs.getString(2));
				prodType.setProductionTypeName(rs.getString(1));

				prodTYpeList.add(prodType);
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

		return prodTYpeList;
	}

	@Override
	public int createProduction(Production production) throws DataException,
			Exception {
		Connection con = null;
		CallableStatement cs = null;
		try {
			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_CREATE_PRODUCTION);
			cs = con.prepareCall(queryString);
			cs.setString(1, production.getProductionType());
			cs.setString(2, production.getProductionName());
			cs.setString(3, production.getCustomer());
			cs.setString(4, production.getItemType());
			cs.setFloat(5, production.getTotalInvenoryLoss());
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
	public List<Production> getAllProductionEntries() throws DataException,
			Exception {
		List<Production> producionEntriesList = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_FETCH_ALL_PRODUCTION_ENTRIES);

			ps = con.prepareStatement(queryString);
			rs = ps.executeQuery();

			logger.debug(queryString);
			producionEntriesList = new ArrayList<Production>();

			while (rs.next()) {
				Production prod = new Production();
				prod.setProductionId(rs.getInt(1));
				prod.setProductionType(rs.getString(2));
				prod.setProductionName(rs.getString(3));
				prod.setCustomer(rs.getString(4));
				prod.setItemType(rs.getString(5));
				prod.setTotalInvenoryLoss(rs.getFloat(6));
				producionEntriesList.add(prod);
			}
		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw e;

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			System.out.println(e);
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

		return producionEntriesList;

	}

	@Override
	public int updateProduction(Production production) throws DataException,
			Exception {

		Connection con = null;
		CallableStatement cs = null;
		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_UPDATE_PRODUCTION);

			cs = con.prepareCall(queryString);
			cs.setString(1, production.getProductionType());
			cs.setString(2, production.getProductionName());
			cs.setString(3, production.getItemType());
			cs.setString(4, production.getCustomer());
			cs.setInt(5, production.getProductionId());

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
	public int deleteProduction(int productionId) throws DataException,
			Exception {

		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;

		try {

			con = JDBCDaoBase.getInstance().getConnection();
			String queryString = SQLPropertyManager.getInstance().getSQLQuery(
					QueryConstants.QRY_DELETE_PRODUCTION);

			ps = con.prepareStatement(queryString);
			ps.setLong(1, productionId);
			count = ps.executeUpdate();

			logger.debug(queryString.replaceAll("\\?", "" + productionId));

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
