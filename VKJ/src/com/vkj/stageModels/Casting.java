/**
 * 
 */
package com.vkj.stageModels;

/**
 * @author ardhani
 * 
 */
public class Casting extends Stage {

	private OrderPlaced orderPlaced;
	private OrderReceived orderReceived;
	private String stageName;

	/**
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}

	/**
	 * @param stageName
	 *            the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	/**
	 * @return the orderPlaced
	 */
	public OrderPlaced getOrderPlaced() {
		return orderPlaced;
	}

	/**
	 * @param orderPlaced
	 *            the orderPlaced to set
	 */
	public void setOrderPlaced(OrderPlaced orderPlaced) {
		this.orderPlaced = orderPlaced;
	}

	/**
	 * @return the orderReceived
	 */
	public OrderReceived getOrderReceived() {
		return orderReceived;
	}

	/**
	 * @param orderReceived
	 *            the orderReceived to set
	 */
	public void setOrderReceived(OrderReceived orderReceived) {
		this.orderReceived = orderReceived;
	}

	/**
	 * 
	 */
	public Casting() {
		stageName = "Casting";
		orderPlaced = new OrderPlaced();
		orderReceived = new OrderReceived();
	}

	public class OrderPlaced {
		public String workerName = "";
		public String orderGivenDate = "";
		public String firstMetal = "";
		public String firstMetalWeight = "";
		public String firstMetalWeightUnit = "";
		public float firstMetalPurity = 0;
		public String alloy = "";
		public String alloyMetalWeight = "";
		public String alloyMetalWeightUnit = "";

		/**
		 * @return the firstMetalWeightUnit
		 */
		public String getFirstMetalWeightUnit() {
			return firstMetalWeightUnit;
		}

		/**
		 * @param firstMetalWeightUnit
		 *            the firstMetalWeightUnit to set
		 */
		public void setFirstMetalWeightUnit(String firstMetalWeightUnit) {
			this.firstMetalWeightUnit = firstMetalWeightUnit;
		}

		/**
		 * @return the alloyMetalWeightUnit
		 */
		public String getAlloyMetalWeightUnit() {
			return alloyMetalWeightUnit;
		}

		/**
		 * @param alloyMetalWeightUnit
		 *            the alloyMetalWeightUnit to set
		 */
		public void setAlloyMetalWeightUnit(String alloyMetalWeightUnit) {
			this.alloyMetalWeightUnit = alloyMetalWeightUnit;
		}

		/**
		 * 
		 * @return the workerName
		 */
		public String getWorkerName() {
			return workerName;
		}

		/**
		 * @param workerName
		 *            the workerName to set
		 */
		public void setWorkerName(String workerName) {
			this.workerName = workerName;
		}

		/**
		 * @return the orderGivenDate
		 */
		public String getOrderGivenDate() {
			return orderGivenDate;
		}

		/**
		 * @param orderGivenDate
		 *            the orderGivenDate to set
		 */
		public void setOrderGivenDate(String orderGivenDate) {
			this.orderGivenDate = orderGivenDate;
		}

		/**
		 * @return the firstMetal
		 */
		public String getFirstMetal() {
			return firstMetal;
		}

		/**
		 * @param firstMetal
		 *            the firstMetal to set
		 */
		public void setFirstMetal(String firstMetal) {
			this.firstMetal = firstMetal;
		}

		/**
		 * @return the firstMetalWeight
		 */
		public String getFirstMetalWeight() {
			return firstMetalWeight;
		}

		/**
		 * @param firstMetalWeight
		 *            the firstMetalWeight to set
		 */
		public void setFirstMetalWeight(String firstMetalWeight) {
			this.firstMetalWeight = firstMetalWeight;
		}

		/**
		 * @return the firstMetalPurity
		 */
		public float getFirstMetalPurity() {
			return firstMetalPurity;
		}

		/**
		 * @param firstMetalPurity
		 *            the firstMetalPurity to set
		 */
		public void setFirstMetalPurity(float firstMetalPurity) {
			this.firstMetalPurity = firstMetalPurity;
		}

		/**
		 * @return the alloy
		 */
		public String getAlloy() {
			return alloy;
		}

		/**
		 * @param alloy
		 *            the alloy to set
		 */
		public void setAlloy(String alloy) {
			this.alloy = alloy;
		}

		/**
		 * @return the alloyMetalWeight
		 */
		public String getAlloyMetalWeight() {
			return alloyMetalWeight;
		}

		/**
		 * @param alloyMetalWeight
		 *            the alloyMetalWeight to set
		 */
		public void setAlloyMetalWeight(String alloyMetalWeight) {
			this.alloyMetalWeight = alloyMetalWeight;
		}

	}

	public class OrderReceived {
		public OrderReceived() {

		}
		public String firstMetalWeightUnit = "";
		
		/**
		 * @return the firstMetalWeightUnit
		 */
		public String getFirstMetalWeightUnit() {
			return firstMetalWeightUnit;
		}

		/**
		 * @param firstMetalWeightUnit the firstMetalWeightUnit to set
		 */
		public void setFirstMetalWeightUnit(String firstMetalWeightUnit) {
			this.firstMetalWeightUnit = firstMetalWeightUnit;
		}
		public String workerName = "";
		public String orderReceivedDate = "";
		public String firstMetal = "";
		public String firstMetalWeight = "";
		public float firstMetalPurity = 0;
		public float loss = 0;

		/**
		 * @return the workerName
		 */
		public String getWorkerName() {
			return workerName;
		}

		/**
		 * @param workerName
		 *            the workerName to set
		 */
		public void setWorkerName(String workerName) {
			this.workerName = workerName;
		}

		/**
		 * @return the orderReceivedDate
		 */
		public String getOrderReceivedDate() {
			return orderReceivedDate;
		}

		/**
		 * @param orderReceivedDate
		 *            the orderReceivedDate to set
		 */
		public void setOrderReceivedDate(String orderReceivedDate) {
			this.orderReceivedDate = orderReceivedDate;
		}

		/**
		 * @return the firstMetal
		 */
		public String getFirstMetal() {
			return firstMetal;
		}

		/**
		 * @param firstMetal
		 *            the firstMetal to set
		 */
		public void setFirstMetal(String firstMetal) {
			this.firstMetal = firstMetal;
		}

		/**
		 * @return the firstMetalWeight
		 */
		public String getFirstMetalWeight() {
			return firstMetalWeight;
		}

		/**
		 * @param firstMetalWeight
		 *            the firstMetalWeight to set
		 */
		public void setFirstMetalWeight(String firstMetalWeight) {
			this.firstMetalWeight = firstMetalWeight;
		}

		/**
		 * @return the firstMetalPurity
		 */
		public float getFirstMetalPurity() {
			return firstMetalPurity;
		}

		/**
		 * @param firstMetalPurity
		 *            the firstMetalPurity to set
		 */
		public void setFirstMetalPurity(float firstMetalPurity) {
			this.firstMetalPurity = firstMetalPurity;
		}

		/**
		 * @return the loss
		 */
		public float getLoss() {
			return loss;
		}

		/**
		 * @param loss
		 *            the loss to set
		 */
		public void setLoss(float loss) {
			this.loss = loss;
		}

	}
}