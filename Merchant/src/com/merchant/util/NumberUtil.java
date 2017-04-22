package com.merchant.util;

/**
 * <b> Util Class to use with numbers</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 21/04/2017 $]
 *          </p>
 */
public class NumberUtil {

	/**
	 * Return true if the value is a number.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 21/04/2017
	 * 
	 * @param value : String value to validate.
	 * @return boolean TRUE if the value is a number.
	 */
	public static boolean isNumber(String value) {
		@SuppressWarnings("unused")
		int dat = 0;
		boolean result = true;
		if (value != null) {
			try {
				dat = Integer.valueOf(value).intValue();
			} catch (NumberFormatException e) {
				result = false;
			}
		}
		return result;
	}

}
