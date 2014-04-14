/**
 * 
 */
package com.vkj.productionModels;

import com.vkj.stageModels.Casting;
import com.vkj.stageModels.GhatPolish;
import com.vkj.stageModels.MagnetPolish;

/**
 * @author ardhani
 * 
 */
public class FactoryProduction {

	public Casting casting;
	public MagnetPolish magnetPolish;
	public GhatPolish ghatPloish;
	public String productionName;

	/**
	 * @return the productionName
	 */
	public String getProductionName() {
		return productionName;
	}

	/**
	 * @param productionName
	 *            the productionName to set
	 */
	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}

	/**
	 * 	
	 */
	public FactoryProduction() {
		casting = new Casting();
		magnetPolish = new MagnetPolish();
		ghatPloish = new GhatPolish();
	}

	/**
	 * @return the casting
	 */
	public Casting getCasting() {
		return casting;
	}

	/**
	 * @param casting
	 *            the casting to set
	 */
	public void setCasting(Casting casting) {
		this.casting = casting;
	}

	/**
	 * @return the magnetPolish
	 */
	public MagnetPolish getMagnetPolish() {
		return magnetPolish;
	}

	/**
	 * @param magnetPolish
	 *            the magnetPolish to set
	 */
	public void setMagnetPolish(MagnetPolish magnetPolish) {
		this.magnetPolish = magnetPolish;
	}

	/**
	 * @return the ghatPloish
	 */
	public GhatPolish getGhatPloish() {
		return ghatPloish;
	}

	/**
	 * @param ghatPloish
	 *            the ghatPloish to set
	 */
	public void setGhatPloish(GhatPolish ghatPloish) {
		this.ghatPloish = ghatPloish;
	}

}