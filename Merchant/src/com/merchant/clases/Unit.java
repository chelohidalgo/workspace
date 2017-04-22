package com.merchant.clases;

/** 
 * <b>
 * Class to manage the units used for the application.
 * </b>
 *  
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $ <p>[$Author: Marcelo Hidalgo$, $Date: 21/04/2017 $]</p>
 */
public class Unit {

	private String name;
	private Double value;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
}
