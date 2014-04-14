/**
 * 
 */
package com.vkj.productionModels;


import java.util.List;

import com.vkj.stageModels.Stage;

/**
 * @author ardhani
 *
 */
public class Production {

	protected List<Stage> stages;
	protected String prodType ;
	protected String prodID;
	protected String date;
	
	/**
	 * 
	 */
	public Production() {
	}

	/**
	 * @return the stages
	 */
	public List<Stage> getStages() {
		return stages;
	}

	/**
	 * @param stages the stages to set
	 */
	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	/**
	 * @return the prodType
	 */
	public String getProdType() {
		return prodType;
	}

	/**
	 * @param prodType the prodType to set
	 */
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	/**
	 * @return the prodID
	 */
	public String getProdID() {
		return prodID;
	}

	/**
	 * @param prodID the prodID to set
	 */
	public void setProdID(String prodID) {
		this.prodID = prodID;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
