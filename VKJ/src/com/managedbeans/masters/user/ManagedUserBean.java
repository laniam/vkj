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
import com.crypt.CryptManager;
import com.exception.CryptException;
import com.exception.SystemException;
import com.model.enums.Role;
import com.service.users.UserMgtService;
import com.util.AppUtils;
import com.vkj.model.Person;
import com.vkj.model.User;

/**
 * @author Harish
 * 
 */
public class ManagedUserBean {

	private static Logger logger = Logger.getLogger("debugger");

	private String firstName = null;
	private String lastName = null;
	private String emailId = null;
	private String mobile = null;
	private String selectedRole = null;
	private String selectedGender = null;
	private List<Role> roleList = null;
	private List<User> userList = null;
	private List<String> genderList = null;
	private User loggedInUser = null;
	private User selectedUser = null;
	private FacesContext facesContext = null;
	private HttpSession session = null;

	/**
	 * 
	 */
	public ManagedUserBean() {
	}

	@PostConstruct
	public void init() {

		facesContext = FacesContext.getCurrentInstance();
		session = AppUtils.getSession(facesContext);
		setLoggedInUser(getCurrentUser(session));
		
		UserMgtService userService = new UserMgtService();
		
		try {

			this.roleList = userService.getAllRoles();
			this.userList = userService.getAllUsers();

		} catch (SystemException e) {

			this.roleList = null;
			e.printStackTrace();
		}
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the selectedRole
	 */
	public String getSelectedRole() {
		return selectedRole;
	}

	/**
	 * @param selectedRole
	 *            the selectedRole to set
	 */
	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
	}

	/**
	 * @return the selectedGender
	 */
	public String getSelectedGender() {
		return selectedGender;
	}

	/**
	 * @param selectedGender
	 *            the selectedGender to set
	 */
	public void setSelectedGender(String selectedGender) {
		this.selectedGender = selectedGender;
	}

	/**
	 * @return the genderList
	 */
	public List<String> getGenderList() {
		return genderList;
	}

	/**
	 * @param genderList
	 *            the genderList to set
	 */
	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

	/**
	 * @return the roleList
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList
	 *            the roleList to set
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the loggedInUser
	 */
	public User getLoggedInUser() {
		return loggedInUser;
	}

	/**
	 * @return the selectedUser
	 */
	public User getSelectedUser() {
		return selectedUser;
	}

	/**
	 * @param selectedUser the selectedUser to set
	 */
	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	/**
	 * @param loggedInUser
	 *            the loggedInUser to set
	 */
	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public String saveUser() {

		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;

		String output = AppConstants.OUTPUT_FAILURE;

		UserMgtService userService = new UserMgtService();

		User user = populateUserDetails(loggedInUser);

		try {

			userService.createUser(user);
			message = bundle.getString(MessageConstants.SUCCESS_SAVE);
			messageType = MessageConstants.MSG_INFO;

			output = AppConstants.OUTPUT_SUCCESS;

		} catch (SystemException e) {

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

		User updateUserRecord = (User) (editEvent.getObject());
		updateUser(updateUserRecord);
	}

	private void updateUser(User updateUserRecord) {

		updateUserRecord.setModifiedBy(loggedInUser.getPerson().getPersonId());

		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;

		UserMgtService userService = new UserMgtService();

		try {

			userService.updateUser(updateUserRecord);
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
	
	public void removeUser() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("msg.common.app");
		String message = null;
		byte messageType = MessageConstants.MSG_FATAL;

		UserMgtService userService = new UserMgtService();

		try {

			userService.deleteUser(selectedUser.getPerson().getPersonId());
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

	private User populateUserDetails(User loggedInUser) {

		User user = new User();
		Person person = new Person();
		Role role = new Role();

		user.setLoginId(this.emailId);
		user.setPassword(getDefaultEncryptedPassword());
		user.setCreatedBy(loggedInUser.getPerson().getPersonId());

		person.setFirstName(this.firstName);
		person.setLastName(this.lastName);
		person.setGender(this.selectedGender.toCharArray()[0]);
		person.setEmailId(this.emailId);
		person.setMobileNo(this.mobile);

		role.setRoleId(Integer.parseInt(this.selectedRole));

		user.setPerson(person);
		user.setRole(role);

		return user;
	}

	private String getDefaultEncryptedPassword() {

		String defaultPassword = "password1";
		String defaultEncryptedPassword = defaultPassword;

		CryptManager cryptManager = new CryptManager();

		try {

			defaultEncryptedPassword = cryptManager.encrypt(defaultPassword);

		} catch (CryptException e) {

			logger.debug("Exception encrypting default password" + e);
		}

		return defaultEncryptedPassword;
	}

	private User getCurrentUser(HttpSession session) {

		return (User) (session.getAttribute(AppConstants.KEY_SESSION_USER));
	}
}
