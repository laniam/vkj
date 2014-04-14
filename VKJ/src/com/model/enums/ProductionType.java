/**
 * 
 */
package com.model.enums;

import java.io.Serializable;

/**
 * @author ardhani
 * 
 */
public class ProductionType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7989142715901940903L;
	private String productionTypeName = null;
	private String productionTypeDescription = null;

	public ProductionType() {

	}

	public String getProductionTypeName() {
		return productionTypeName;
	}

	public void setProductionTypeName(String productionTYpeName) {
		this.productionTypeName = productionTYpeName;
	}

	public String getProductionTYpeDescription() {
		return productionTypeDescription;
	}

	public void setProductionTypeDescription(String productionTYpeDescription) {
		this.productionTypeDescription = productionTYpeDescription;
	}

	@Override
	public String toString() {
		return "Production Type: " + this.productionTypeName
				+ " | Production Type Description "
				+ this.productionTypeDescription;
	}
}
