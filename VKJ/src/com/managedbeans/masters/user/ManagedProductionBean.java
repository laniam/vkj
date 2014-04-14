/**
 * 
 */
package com.managedbeans.masters.user;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import com.constants.AppConstants;
import com.constants.MessageConstants;
import com.exception.SystemException;
import com.model.enums.ProductionType;
import com.model.enums.Stages;
import com.service.users.ProductionMgtService;
import com.util.AppUtils;
import com.vkj.model.Production;
import com.vkj.model.User;

/**
 * @author ardhani
 * 
 */
public class ManagedProductionBean {
	private static Logger logger = Logger.getLogger("debugger");

	
	private List<Stages> stagesList;
	private List<ProductionType> prodTypeList;
	private String productionName;
	private String itemType;
	private String customer;
	private float inventoryLoss;

	private FacesContext facesContext = null;
	private HttpSession session = null;
	private User loggedInUser = null;
	private String selectedStage = null;
	private String selectedProdType = null;
	private List<Production> productionsList;
	private Production selectedProduction = null;

	/**
	 * @return the prodTypeList
	 */
	public List<ProductionType> getProdTypeList() {
		return prodTypeList;
		
	}

	/**
	 * @param prodTypeList
	 *            the prodTypeList to set
	 */
	public void setProdTypeList(List<ProductionType> prodTypeList) {
		this.prodTypeList = prodTypeList;
	}

	/**
	 * @return the selectedProdType
	 */
	public String getSelectedProdType() {
		return selectedProdType;
	}

	/**
	 * @param selectedProdType
	 *            the selectedProdType to set
	 */
	public void setSelectedProdType(String selectedProdType) {
		this.selectedProdType = selectedProdType;
	}

	/**
	 * @return the selectedStage
	 */
	public String getSelectedStage() {
		return selectedStage;
	}

	/**
	 * @param selectedStage
	 *            the selectedStage to set
	 */
	public void setSelectedStage(String selectedStage) {
		this.selectedStage = selectedStage;
	}

	/**
	 * 
	 */
	public ManagedProductionBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		facesContext = FacesContext.getCurrentInstance();
		session = AppUtils.getSession(facesContext);
		setLoggedInUser(getCurrentUser(session));

		ProductionMgtService prodMgtService = new ProductionMgtService();
		try {

			this.stagesList = prodMgtService.getAllStages();
			this.prodTypeList = prodMgtService.getAllProdTypes();
			this.productionsList = prodMgtService.getAllProductionEntries();
		} catch (SystemException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @return the stagesList
	 */
	public List<Stages> getStagesList() {
		return stagesList;
	}

	/**
	 * @param stagesList
	 *            the stagesList to set
	 */
	public void setStagesList(List<Stages> stagesList) {
		this.stagesList = stagesList;
	}

	/**
	 * @return the facesContext
	 */
	public FacesContext getFacesContext() {
		return facesContext;
	}

	/**
	 * @param facesContext
	 *            the facesContext to set
	 */
	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the loggedInUser
	 */
	public User getLoggedInUser() {
		return loggedInUser;
	}

	/**
	 * @param loggedInUser
	 *            the loggedInUser to set
	 */
	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	private User getCurrentUser(HttpSession session) {

		return (User) (session.getAttribute(AppConstants.KEY_SESSION_USER));
	}

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
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType
	 *            the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the inventoryLoss
	 */
	public float getInventoryLoss() {
		return inventoryLoss;
	}

	/**
	 * @param inventoryLoss
	 *            the inventoryLoss to set
	 */
	public void setInventoryLoss(float inventoryLoss) {
		this.inventoryLoss = inventoryLoss;
	}

	/**
	 * @return the productionsList
	 */
	public List<Production> getProductionsList() {
		return productionsList;
	}

	/**
	 * @param productionsList
	 *            the productionsList to set
	 */
	public void setProductionsList(List<Production> productionsList) {
		this.productionsList = productionsList;
	}

	/**
	 * @return the selectedProduction
	 */
	public Production getSelectedProduction() {
		return selectedProduction;
	}

	/**
	 * @param selectedProduction
	 *            the selectedProduction to set
	 */
	public void setSelectedProduction(Production selectedProduction) {
		this.selectedProduction = selectedProduction;
//		return "/factory/production/addProductionDetails.xhtml";
	}

	public String setSelectedProd(int id){
		this.selectedProduction = productionsList.get(id);
		return "/factory/production/addProductionDetails.xhtml";
	}
	public Production populateProduction() {
		Production production = new Production();
		production.setCustomer(this.customer);
		production.setItemType(this.itemType);
		production.setProductionName(this.productionName);
		production.setProductionId(this.selectedProdType);
		production.setTotalInvenoryLoss(this.inventoryLoss);
		return production;
	}

	public String saveProduction() {
		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;
		String output = AppConstants.OUTPUT_FAILURE;
		ProductionMgtService prodMgtService = new ProductionMgtService();
		Production production = populateProduction();
		try {
			prodMgtService.createProduction(production);
			message = bundle.getString(MessageConstants.SUCCESS_SAVE);
			messageType = MessageConstants.MSG_INFO;
			this.productionsList = prodMgtService.getAllProductionEntries();
			output = AppConstants.OUTPUT_SUCCESS;

		} catch (SystemException sysE) {
			message = bundle.getString(MessageConstants.SAVE_ERROR);
			messageType = MessageConstants.MSG_ERROR;
			logger.debug(message);
		}

		FacesMessage facesMessage = AppUtils.getFacesMessage(facesContext,
				message, messageType);
		facesContext.addMessage("saveUser", facesMessage);

		return output;
	}

	public void onUpdate(RowEditEvent editEvent) {
		Production updateUserRecord = (Production) (editEvent.getObject());
		updateProduction(updateUserRecord);
	}

	public void removeProduction() {

		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;

		ProductionMgtService prodService = new ProductionMgtService();
		try {

			prodService.deleteProduction(selectedProduction.getProductionId());
			this.productionsList = prodService.getAllProductionEntries();
			message = bundle.getString(MessageConstants.SUCCESS_DELETE);
			messageType = MessageConstants.MSG_INFO;

		} catch (SystemException e) {

			message = bundle.getString(MessageConstants.DELETE_ERROR);
			messageType = MessageConstants.MSG_ERROR;
			logger.debug("SystemException" + message);

		} catch (Exception e) {

			message = bundle.getString(MessageConstants.DELETE_ERROR);
			messageType = MessageConstants.MSG_ERROR;
			logger.debug("Exception" + message);
		}

		FacesMessage facesMessage = AppUtils.getFacesMessage(facesContext,
				message, messageType);
		facesContext.addMessage(null, facesMessage);
	}

	private void updateProduction(Production updateproductionRecord) {

		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;

		ProductionMgtService prodService = new ProductionMgtService();
		try {

			prodService.updateProduction(updateproductionRecord);
			this.productionsList = prodService.getAllProductionEntries();
			message = bundle.getString(MessageConstants.SUCCESS_UPDATE);
			messageType = MessageConstants.MSG_INFO;

		} catch (SystemException e) {

			message = bundle.getString(MessageConstants.UPDATE_ERROR);
			messageType = MessageConstants.MSG_ERROR;
			logger.debug(message);
		}

		FacesMessage facesMessage = AppUtils.getFacesMessage(facesContext,
				message, messageType);
		facesContext.addMessage("editUser", facesMessage);
	}

}
