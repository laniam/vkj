
/**
 * 
 */
package com.managedbeans.auth;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import com.constants.AppConstants;
import com.constants.MessageConstants;
import com.crypt.CryptManager;
import com.exception.CryptException;
import com.exception.InvalidCredentialsException;
import com.exception.NoUserFoundException;
import com.exception.SystemException;
import com.exception.UserNotRegisteredException;
import com.model.enums.Role;
import com.service.menus.MenuMgtService;
import com.service.users.UserMgtService;
import com.vkj.model.Menu;
import com.vkj.model.User;

/**
 * @author Harish
 * 
 */
public class Authentication {

	private static Logger logger = Logger.getLogger("debugger");

	private boolean validUser = false;
	private Credentials credentials = null;

	/**
	 * 
	 */
	public Authentication() {
	}

	/**
	 * @return the validUser
	 */
	public boolean isValidUser() {
		return validUser;
	}

	/**
	 * @return the credentials
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials
	 *            the credentials to set
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	/**
	 * @param validUser
	 *            the validUser to set
	 */
	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}

	public String authenticate() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) (facesContext
				.getExternalContext().getRequest());
		HttpSession session = request.getSession();

		ResourceBundle bundle = ResourceBundle.getBundle("msg.auth.login");

		String output = AppConstants.OUTPUT_FAILURE;
		String message = null;
		byte messageType = (byte) 0;

		User user = null;

		String userName = this.credentials.getUserName() == null ? ""
				: this.credentials.getUserName().trim();
		String password = this.credentials.getPassword() == null ? ""
				: this.credentials.getPassword().trim();

		if (!userName.equals("") && (!password.equals(""))) {

			try {

				user = getUser(this.credentials);

				if (isValidUser(this.credentials, user)) {

					this.validUser = true;

					MenuModel model = populateMenuForRole(user.getRole());

					session.setAttribute(AppConstants.KEY_SESSION_USER, user);
					session.setAttribute(AppConstants.KEY_SESSION_MENU_MODEL,
							model);
					logger.debug(model.toString());
					output = AppConstants.OUTPUT_SUCCESS;
				}

				if (!output.equals(AppConstants.OUTPUT_SUCCESS)) {

					message = bundle.getString(MessageConstants.SYSTEM_ERROR);
					messageType = (byte) 4;
					logger.debug(message);
				}

			} catch (NoUserFoundException e) {

				logger.debug("NoUserFoundException: " + e);
				message = bundle.getString(MessageConstants.INVALID_USERNAME);
				messageType = (byte) 3;

			} catch (InvalidCredentialsException e) {

				logger.debug("InvalidCredentialsException: " + e);
				message = bundle.getString(MessageConstants.INVALID_PASSWORD);
				messageType = (byte) 3;

			} catch (SystemException e) {

				logger.debug("SystemException: " + e);
				message = bundle.getString(MessageConstants.SYSTEM_ERROR);
				messageType = (byte) 4;

			} catch (Exception e) {

				logger.debug("Exception: " + e);
				message = bundle.getString(MessageConstants.SYSTEM_ERROR);
				messageType = (byte) 4;
			}

		} else {

			if (userName.equals("") && (password.equals(""))) {

				message = bundle
						.getString(MessageConstants.USERNAME_PASSWORD_MANDATORY);
				messageType = (byte) 3;

			} else if (userName.equals("")) {

				message = bundle.getString(MessageConstants.USERNAME_MANDATORY);
				messageType = (byte) 3;

			} else if (password.equals("")) {

				message = bundle.getString(MessageConstants.PASSWORD_MANDATORY);
				messageType = (byte) 3;
			}
		}

		populateMessage(facesContext, message, messageType);
		return output;
	}

	private User getUser(Credentials credentials) throws NoUserFoundException,
			SystemException {

		User user = new UserMgtService().authenticate(credentials);

		if (user == null) {

			throw new NoUserFoundException("User not registered");
		}

		return user;
	}

	private boolean isValidUser(Credentials credentials, User user)
			throws InvalidCredentialsException {

		CryptManager cryptManager = new CryptManager();
		String encryptedPassword = null;

		try {

			encryptedPassword = cryptManager.encrypt(credentials.getPassword());

		} catch (CryptException e) {

			logger.debug("CryptException: " + e);

			return false;

		} catch (Exception e) {

			logger.debug("Exception: " + e);

			return false;
		}

		if (!encryptedPassword.equals(user.getPassword())) {

			throw new InvalidCredentialsException("Invalid Credentials");
		}

		return true;
	}

	private MenuModel populateMenuForRole(Role role)
			throws UserNotRegisteredException {

		Map<String, List<Menu>> menuMap = fetchMenuForRole(role);

		logger.debug("Menu Map: " + menuMap);

		MenuModel model = null;

		if ((menuMap != null) && (!menuMap.isEmpty())) {

			model = new DefaultMenuModel();
			byte parentMenuCount = 0;

			for (Map.Entry<String, List<Menu>> mapEntry : menuMap.entrySet()) {

				Submenu subMenu = new Submenu();
				subMenu.setId("sm_" + ++parentMenuCount);
				subMenu.setLabel(mapEntry.getKey());

				List<Menu> menuList = mapEntry.getValue();

				for (Menu menu : menuList) {

					MenuItem menuItem = new MenuItem();
					menuItem.setId(String.valueOf("mi_" + menu.getMenuId()));
					menuItem.setValue(menu.getLabel());
					menuItem.setUrl(menu.getUrl());
					menuItem.setAjax(false);

					subMenu.getChildren().add(menuItem);
				}

				model.addSubmenu(subMenu);
			}
		}

		return model;
	}

	private Map<String, List<Menu>> fetchMenuForRole(Role role)
			throws UserNotRegisteredException {

		Map<String, List<Menu>> menuMap = new MenuMgtService()
				.getMenusForRole(role.getRoleId());

		if (menuMap == null) {

			throw new UserNotRegisteredException("No matching roles found");
		}

		return menuMap;
	}

	private void populateMessage(FacesContext facesContext, String message,
			byte messageType) {

		if (message != null) {

			FacesMessage facesMessage = new FacesMessage(message);

			switch (messageType) {

			case (byte) 1:
			default:

				facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
				break;

			case (byte) 2:

				facesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
				break;

			case (byte) 3:

				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				break;

			case (byte) 4:

				facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				break;
			}

			facesContext.addMessage(null, facesMessage);
		}
	}

	public String logout() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) (facesContext
				.getExternalContext().getRequest());
		HttpSession session = request.getSession();
		session.invalidate();

		return AppConstants.OUTPUT_SUCCESS;
	}
}
