/**
 * 
 */
package com.persistence.dao.production;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.vkj.productionModels.FactoryProduction;

/**
 * @author ardhani
 * 
 */
public class Production {

	public int prodID;
	public String prodName;
	public String prodDate;
	public String prodDetalsStr;
	public String detailsURLPath;
	public String prodType;
	public FactoryProduction factoryProduction;

	/**
	 * @return the factoryProduction
	 */
	public FactoryProduction getFactoryProduction() {
		return factoryProduction;
	}

	/**
	 * @param factoryProduction
	 *            the factoryProduction to set
	 */
	public void setFactoryProduction(FactoryProduction factoryProduction) {
		this.factoryProduction = factoryProduction;
	}

	/**
	 * @return the prodType
	 */
	public String getProdType() {
		return prodType;
	}

	/**
	 * @param prodType
	 *            the prodType to set
	 */
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	/**
	 * @return the prodID
	 */
	public int getProdID() {
		return prodID;
	}

	/**
	 * @param prodID
	 *            the prodID to set
	 */
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * @param prodName
	 *            the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/**
	 * @return the prodDate
	 */
	public String getProdDate() {
		return prodDate;
	}

	/**
	 * @param prodDate
	 *            the prodDate to set
	 */
	public void setProdDate(String prodDate) {
		this.prodDate = prodDate;
	}

	/**
	 * @return the prodDetalsStr
	 */
	public String getProdDetalsStr() {
		return prodDetalsStr;
	}

	/**
	 * @param prodDetalsStr
	 *            the prodDetalsStr to set
	 */
	public void setProdDetalsStr(String prodDetalsStr) {
		this.prodDetalsStr = prodDetalsStr;
	}

	/**
	 * @return the detailsURLPath
	 */
	public String getDetailsURLPath() {
		return detailsURLPath;
	}

	public void init() {
		setDetailsURLPath("");
	}

	/**
	 * @param detailsURLPath
	 *            the detailsURLPath to set
	 */
	public void setDetailsURLPath(String detailsURLPath) {
		// String url = factoryProductionDisplay.jsf;
		ObjectMapper mapper = new ObjectMapper();
		if (prodType.equals("Factory")) {
			this.detailsURLPath = "/factory/production/factoryProductionDisplay.xhtml";
			try {
				factoryProduction = mapper.readValue(getProdDetalsStr(),
						FactoryProduction.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
