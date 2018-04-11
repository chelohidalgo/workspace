package com.hidalgo.sicpa.enumeration;

/**
 * Enum to manage status states
 * 
 * @version 1.0 - 15/10/2017
 * @author Marcelo Hidalgo
 */
public enum StatusEnum {

	ACTIVE("Active"), INACTIVE("Inactive");

	private StatusEnum(String code) {
		this.code = code;
	}

	private String code;

	public String getCode() {
		return code;
	}

}
