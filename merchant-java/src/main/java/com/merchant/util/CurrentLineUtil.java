package com.merchant.util;

import com.merchant.CurrentLine;

public class CurrentLineUtil {

	public static String[] getPreNames(CurrentLine currentLine) {
		return currentLine.getName().split(Constants.CHAR_SPACE);
	}

	public static String getLastName(CurrentLine currentLine) {
		return getPreNames(currentLine)[getPreNames(currentLine).length - Constants.VALUE_ONE];
	}

}
