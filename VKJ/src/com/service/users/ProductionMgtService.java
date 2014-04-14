/**
 * 
 */
package com.service.users;

import java.util.List;

import org.apache.log4j.Logger;

import com.exception.DataException;
import com.exception.SystemException;
import com.model.enums.ProductionType;
import com.model.enums.Stages;
import com.persistence.dao.users.ProductionDao;
import com.persistence.dao.users.ProductionDaoImpl;
import com.vkj.model.Production;

/**
 * @author ardhani
 * 
 */
public class ProductionMgtService {
	private static final Logger logger = Logger.getLogger("debugger");
	private ProductionDao productionDao = new ProductionDaoImpl();

	/**
	 * 
	 */
	public ProductionMgtService() {
		// TODO Auto-generated constructor stub
	}

	public List<Production> getAllProductionEntries() throws SystemException {
		List<Production> productionentriesList = null;
		try {
			productionentriesList = productionDao.getAllProductionEntries();
		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}

		return productionentriesList;
	}

	public List<ProductionType> getAllProdTypes() throws SystemException {

		List<ProductionType> prodTypeList = null;

		try {

			prodTypeList = productionDao.getAllProductionTypes();

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}

		return prodTypeList;

	}

	public List<Stages> getAllStages() throws SystemException {

		List<Stages> stagesList = null;

		try {

			stagesList = productionDao.getAllStages();

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}

		return stagesList;

	}

	public int createProduction(Production production) throws SystemException {
		ProductionDao prodDao = new ProductionDaoImpl();

		try {

			return prodDao.createProduction(production);

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}

	}

	public int updateProduction(Production production) throws SystemException {

		ProductionDao prodDao = new ProductionDaoImpl();
		try {

			return prodDao.updateProduction(production);

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}
	}

	public int deleteProduction(int productionID) throws SystemException {

		ProductionDao prodDao = new ProductionDaoImpl();
		try {

			return prodDao.deleteProduction(productionID);

		} catch (DataException e) {

			logger.debug("DataException: " + e);
			throw new SystemException("Generic Database Exception");

		} catch (Exception e) {

			logger.debug("Exception: " + e);
			throw new SystemException("Generic System Exception");
		}
	}
}
