/**
 * 
 */
package com.persistence.dao.users;

import java.util.List;

import com.exception.DataException;
import com.model.enums.ProductionType;
import com.model.enums.Stages;
import com.vkj.model.Production;

/**
 * @author ardhani
 * 
 */
public interface ProductionDao {

	public List<Stages> getAllStages() throws DataException, Exception;

	public List<ProductionType> getAllProductionTypes() throws DataException,
			Exception;

	public int createProduction(Production production) throws DataException,
			Exception;

	public List<Production> getAllProductionEntries() throws DataException,
			Exception;
	public int updateProduction(Production production) throws DataException, Exception;
	public int deleteProduction(int productionId) throws DataException, Exception;
}
