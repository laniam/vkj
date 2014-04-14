/**
 * 
 */
package com.managedbeans.masters.user;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.constants.AppConstants;
import com.constants.MessageConstants;
import com.exception.DataException;
import com.exception.SystemException;
import com.persistence.dao.production.Production;
import com.persistence.dao.users.ProdDaoImpl;
import com.util.AppUtils;
import com.vkj.model.User;
import com.vkj.productionModels.FactoryProduction;

/**
 * @author ardhani
 * 
 */
public class ProductionBean {
	// prodBean.produtionName
	public FactoryProduction factoryProduction = new FactoryProduction();

	private List<String> unitsList;
	public Production selectedBean;
	public boolean editScreen = false;

	public String enableEditScreen() {
		editScreen = true;
		return "success";
	}

	public String disableEditScreen() {
		editScreen = false;
		return "success";
	}

	/**
	 * @return the editScreen
	 */
	public boolean isEditScreen() {
		return editScreen;
	}

	/**
	 * @param editScreen
	 *            the editScreen to set
	 */
	public void setEditScreen(boolean editScreen) {
		this.editScreen = editScreen;
	}

	/**
	 * @return the selectedBean
	 */
	public Production getSelectedBean() {
		return selectedBean;
	}

	/**
	 * @param selectedBean
	 *            the selectedBean to set
	 */
	public void setSelectedBean(Production selectedBean) {
		this.selectedBean = selectedBean;
	}

	private List<String> workersNames;
	private List<String> metal1Type;
	private FacesContext facesContext = null;
	public List<Production> prodList = new ArrayList<Production>();

	/**
	 * @return the prodList
	 */
	public List<Production> getProdList() {
		return prodList;
	}

	/**
	 * @param prodList
	 *            the prodList to set
	 */
	public void setProdList(List<Production> prodList) {
		this.prodList = prodList;
	}

	/**
	 * @return the metal1Type
	 */
	public List<String> getMetal1Type() {
		return metal1Type;
	}

	/**
	 * @param metal1Type
	 *            the metal1Type to set
	 */
	public void setMetal1Type(List<String> metal1Type) {
		this.metal1Type = metal1Type;
	}

	private String worker;

	/**
	 * @return the worker
	 */
	public String getWorker() {
		return worker;
	}

	/**
	 * @param worker
	 *            the worker to set
	 */
	public void setWorker(String worker) {
		this.worker = worker;
	}

	/**
	 * @return the workersNames
	 */
	public List<String> getWorkersNames() {
		return workersNames;
	}

	/**
	 * @param workersNames
	 *            the workersNames to set
	 */
	public void setWorkersNames(List<String> workersNames) {
		this.workersNames = workersNames;
	}

	/**
	 * @return the unitsList
	 */
	public List<String> getUnitsList() {
		return unitsList;
	}

	/**
	 * @param unitsList
	 *            the unitsList to set
	 */
	public void setUnitsList(List<String> unitsList) {
		this.unitsList = unitsList;
	}

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
	 * 
	 */

	public ProductionBean() {
		unitsList = new ArrayList<String>();
		workersNames = new ArrayList<String>();
		metal1Type = new ArrayList<String>();

		unitsList.add("Kilograms");
		unitsList.add("grams");

		workersNames.add("Worker 1");
		workersNames.add("Worker 2");
		workersNames.add("Worker 3");
		workersNames.add("Worker 4");

		metal1Type.add("G24K");
		metal1Type.add("G22K");
		metal1Type.add("G20K");
		metal1Type.add("G18K");
	}

	public String saveProduction() {
		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;
		String output = AppConstants.OUTPUT_FAILURE;
		ProdDaoImpl prodDaoImpl = new ProdDaoImpl();
		try {
			prodDaoImpl.createFactoryProduction(factoryProduction);
			message = bundle.getString(MessageConstants.SUCCESS_SAVE);
			messageType = MessageConstants.MSG_INFO;
			output = AppConstants.OUTPUT_SUCCESS;
		} catch (SystemException sysE) {
			message = bundle.getString(MessageConstants.SAVE_ERROR);
			messageType = MessageConstants.MSG_ERROR;
		} catch (DataException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesMessage facesMessage = AppUtils.getFacesMessage(facesContext,
				message, messageType);
		facesContext.addMessage("saveProduction", facesMessage);
		return output;
	}

	private HttpSession session = null;
	private User loggedInUser = null;

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

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	private User getCurrentUser(HttpSession session) {

		return (User) (session.getAttribute(AppConstants.KEY_SESSION_USER));
	}

	@PostConstruct
	public void init() {
		facesContext = FacesContext.getCurrentInstance();
		session = AppUtils.getSession(facesContext);
		setLoggedInUser(getCurrentUser(session));
		ProdDaoImpl prodDao = new ProdDaoImpl();
		try {
			this.prodList = prodDao.getAllFactoryProductions();
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String removeProduction() {
		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;
		ProdDaoImpl prod = new ProdDaoImpl();
		try {
			prod.deleteProduction(selectedBean.getProdID());
			this.prodList = prod.getAllFactoryProductions();
			message = AppConstants.OUTPUT_SUCCESS;
			messageType = MessageConstants.MSG_INFO;
		} catch (SystemException e) {
			message = bundle.getString(MessageConstants.DELETE_ERROR);
			messageType = MessageConstants.MSG_ERROR;
		} catch (Exception e) {
			message = bundle.getString(MessageConstants.DELETE_ERROR);
			messageType = MessageConstants.MSG_ERROR;
		}

		FacesMessage facesMessage = AppUtils.getFacesMessage(facesContext,
				message, messageType);
		facesContext.addMessage(null, facesMessage);
		return message;
	}

	public String getSuccess() {
		return "success";
	}

	public void updateProduction() {

	}
}
