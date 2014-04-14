/**
 * 
 */
package com.model.enums;

import java.io.Serializable;

/**
 * @author ardhani
 * 
 */
public class Stages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2708662809629635566L;
	private String stageName = null;
	private String stageDescription = null;

	public Stages() {

	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getStageDescription() {
		return stageDescription;
	}

	public void setStageDescription(String stageDescription) {
		this.stageDescription = stageDescription;
	}

	@Override
	public String toString() {
		return "Stage name: " + stageName + "  | Stage Description: "
				+ stageDescription;
	}

}
