/**
 * 
 */
package com.persistence.dao.users;

import java.util.List;

import com.exception.DataException;
import com.persistence.dao.production.Production;
import com.vkj.productionModels.FactoryProduction;

/**
 * @author ardhani
 * 
 */
public interface ProdDao {

	public int createFactoryProduction(FactoryProduction production) throws DataException,
			Exception;

	public List<Production> getAllFactoryProductions() throws DataException, Exception;

	public void updateFactoryProduction(FactoryProduction production) throws DataException,
			Exception;

	public int deleteProduction(int prodId) throws DataException, Exception;
}
