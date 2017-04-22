package com.merchant.util.enumeraciones.util;

import com.merchant.util.enumeraciones.MetalEnum;

/**
 * Util Class in order to use with metals.
 * 
 * @author  Marcelo Hidalgo
 * @version 1.0.0, 21/04/2014
 *
 */
public class MetalEnumUtil {

	/**
	 * <b> Verify if the name as a parameter is a metal as SILVER, IRON, GOLD... </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 * 
	 */
	public static boolean isMetal(String name){
		if(name != null){
			for(MetalEnum metalEnum : MetalEnum.values()){
				if(metalEnum.toString().equals(name.toUpperCase()))
					return true;
			}
		}
		return false;
	}
	
}
