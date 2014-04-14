/**
 * 
 */
package com.vkj.model;

import java.io.Serializable;

/**
 * @author Harish
 * 
 */
public class Menu implements Serializable, Comparable<Menu> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2175836394394686266L;

	private byte menuId = 0;
	private String label = null;
	private String description = null;
	private String url = null;
	private byte parentId = 0;

	/**
	 * 
	 */
	public Menu() {
	}

	/**
	 * @return the menuId
	 */
	public byte getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(byte menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the parentId
	 */
	public byte getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(byte parentId) {
		this.parentId = parentId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Menu menu) {

		return (this.menuId - menu.getMenuId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ("Id: " + this.menuId + " | Label: " + this.label + " | URL: "
				+ this.url + " | Parent: " + this.parentId);
	}
}
