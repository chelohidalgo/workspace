package com.merchant.enumerations.util;

import com.merchant.CurrentLine;
import com.merchant.enumerations.MetalEnum;

public class MetalEnumUtil {
	
	public static boolean isMetalUnit(CurrentLine currentLine) {
		for (MetalEnum metalName : MetalEnum.values()) {
			if (currentLine.getName().toUpperCase().contains(metalName.name()))
				return true;
		}
		return false;
	}

}
