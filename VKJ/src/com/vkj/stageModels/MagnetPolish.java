/**
 * 
 */
package com.vkj.stageModels;



/**
 * @author ardhani
 * 
 */
public class MagnetPolish extends Stage {
	protected OrderPlaced orderPlaced ;
	protected OrderReceived orderReceived ;
	/**
	 * @return the orderPlaced
	 */
	public OrderPlaced getOrderPlaced() {
		return orderPlaced;
	}

	/**
	 * @param orderPlaced the orderPlaced to set
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
	 * @param orderReceived the orderReceived to set
	 */
	public void setOrderReceived(OrderReceived orderReceived) {
		this.orderReceived = orderReceived;
	}


	/**
	 * 
	 */
	public MagnetPolish() {
		stageName = "MagnetPolish";
		orderPlaced = new OrderPlaced();
		orderReceived = new OrderReceived();
	}

	public class OrderPlaced {
		public OrderPlaced(){
			
		}
		public String workerName = "";
		public String orderGivenDate = "";
		public String firstMetal = "";
		public String mouldAvailable = "";
		public String goldWeight = "";
		public String piecesCount = "";
		public String remarks = "";
		/**
		 * @return the workerName
		 */
		public String getWorkerName() {
			return workerName;
		}
		/**
		 * @param workerName the workerName to set
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
		 * @param orderGivenDate the orderGivenDate to set
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
		 * @param firstMetal the firstMetal to set
		 */
		public void setFirstMetal(String firstMetal) {
			this.firstMetal = firstMetal;
		}
		/**
		 * @return the mouldAvailable
		 */
		public String getMouldAvailable() {
			return mouldAvailable;
		}
		/**
		 * @param mouldAvailable the mouldAvailable to set
		 */
		public void setMouldAvailable(String mouldAvailable) {
			this.mouldAvailable = mouldAvailable;
		}
		/**
		 * @return the goldWeight
		 */
		public String getGoldWeight() {
			return goldWeight;
		}
		/**
		 * @param goldWeight the goldWeight to set
		 */
		public void setGoldWeight(String goldWeight) {
			this.goldWeight = goldWeight;
		}
		/**
		 * @return the piecesCount
		 */
		public String getPiecesCount() {
			return piecesCount;
		}
		/**
		 * @param piecesCount the piecesCount to set
		 */
		public void setPiecesCount(String piecesCount) {
			this.piecesCount = piecesCount;
		}
		/**
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}
		/**
		 * @param remarks the remarks to set
		 */
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
	}

	public class OrderReceived {
		public OrderReceived(){
			
		}
		public String workerName = "";
		public String orderReceivedDate = "";
		public String firstMetal = "";
		public String receivedQuantity = "";
		public float loss = 0;
		public String remarks = "";
		/**
		 * @return the workerName
		 */
		public String getWorkerName() {
			return workerName;
		}
		/**
		 * @param workerName the workerName to set
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
		 * @param orderReceivedDate the orderReceivedDate to set
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
		 * @param firstMetal the firstMetal to set
		 */
		public void setFirstMetal(String firstMetal) {
			this.firstMetal = firstMetal;
		}
		/**
		 * @return the receivedQuantity
		 */
		public String getReceivedQuantity() {
			return receivedQuantity;
		}
		/**
		 * @param receivedQuantity the receivedQuantity to set
		 */
		public void setReceivedQuantity(String receivedQuantity) {
			this.receivedQuantity = receivedQuantity;
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
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}
		/**
		 * @param remarks the remarks to set
		 */
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
	}

}
