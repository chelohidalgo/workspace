package com.merchant.util;

public class NumberUtil {

	@SuppressWarnings("unused")
	public static boolean isNumber(String value) {
		double dat = 0;
		boolean result = false;
		if (value != null) {
			try {
				dat = Double.valueOf(value).doubleValue();
				result = true;
			} catch (NumberFormatException e) {
				result = false;
			}
		}
		return result;
	}

}
