package com.merchant.util;

import java.util.List;

import com.merchant.CurrentLine;
import com.merchant.Unit;
import com.merchant.enumerations.util.MetalEnumUtil;

public class UnitUtil {
	
	public static Boolean existUnitByName(List<Unit> units, String unitName) {
		if (unitListIsNotEmpty(units)) {
			for (Unit unit : units) {
				if (isTheSameUnitName(unitName, unit))
					return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	private static boolean unitListIsNotEmpty(List<Unit> units) {
		return units != null && units.size() > Constants.VALUE_ZERO;
	}
	
	private static boolean isTheSameUnitName(String unitName, Unit unit) {
		return unit.getName().equalsIgnoreCase(unitName);
	}

	public static Double getUnitValueByName(List<Unit> units, String name) {
		if (unitListIsNotEmpty(units)) {
			for (Unit unit : units) {
				if (isTheSameUnitName(name, unit))
					return unit.getValue();
			}
		}
		return null;
	}
	
	public static String getValueOfPreNames(List<Unit> units, String[] preNames) {
		StringBuilder preName = new StringBuilder();
		for (String name : preNames) {
			if (MetalEnumUtil.isMetalUnit(new CurrentLine(name, null)))
				break;
			if (UnitUtil.existUnitByName(units, name)) {
				Double unitValue = UnitUtil.getUnitValueByName(units, name);
				preName.append(new NumeralRomanConverter().getRomanNumeral(unitValue.intValue()));
			}
		}
		return preName.toString();
	}
	
	public static Boolean noExistUnitsByName(List<Unit> units, String unitName) {
		if (unitListIsNotEmpty(units)) {
			for (Unit unit : units) {
				if (isTheSameUnitName(unitName, unit))
					return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

}
