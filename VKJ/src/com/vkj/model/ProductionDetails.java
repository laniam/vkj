/**
 * 
 */
package com.vkj.model;

import java.io.Serializable;

/**
 * @author ardhani
 *
 */
public class ProductionDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 664805849888012503L;

	/**
	 * 
	 */
	public ProductionDetails() {
		// TODO Auto-generated constructor stub
	}

	
	private int id;
	private int productionId;
	private String stageName;
	private String metalInventory;
	private String stoneInventory;
	private float loss;
	private int createdBy;
	private int modifiedBy;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the productionId
	 */
	public int getProductionId() {
		return productionId;
	}
	/**
	 * @param productionId the productionId to set
	 */
	public void setProductionId(int productionId) {
		this.productionId = productionId;
	}
	/**
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}
	/**
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	/**
	 * @return the metalInventory
	 */
	public String getMetalInventory() {
		return metalInventory;
	}
	/**
	 * @param metalInventory the metalInventory to set
	 */
	public void setMetalInventory(String metalInventory) {
		this.metalInventory = metalInventory;
	}
	/**
	 * @return the stoneInventory
	 */
	public String getStoneInventory() {
		return stoneInventory;
	}
	/**
	 * @param stoneInventory the stoneInventory to set
	 */
	public void setStoneInventory(String stoneInventory) {
		this.stoneInventory = stoneInventory;
	}
	/**
	 * @return the loss
	 */
	public float getLoss() {
		return loss;
	}
	/**
	 * @param loss the loss to set
	 */
	public void setLoss(float loss) {
		this.loss = loss;
	}
	/**
	 * @return the createdBy
	 */
	public int getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the modifiedBy
	 */
	public int getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
