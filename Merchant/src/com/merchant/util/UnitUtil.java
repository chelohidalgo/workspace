package com.merchant.util;

import java.util.List;

import com.merchant.clases.Unit;

/**
 * <b> Util Class to use with units</b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo $, $Date: 21/04/2017 $]
 *          </p>
 */
public class UnitUtil {

	/**
	 * Return true if the unit exist with the name as a parameter.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 21/04/2017
	 * 
	 * @param units : list of units
	 * @param unitName : unit name
	 * @return boolean : TRUE if the value is a number.
	 */
	public static Boolean existUnitByName(List<Unit> units, String unitName) {
		if (units != null && units.size() > Constants.VALUE_ZERO) {
			for (Unit unit : units) {
				if (unit.getName().equals(unitName.toUpperCase()))
					return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Return true if the unit exist with the value as a parameter.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 21/04/2017
	 * 
	 * @param units : list of units
	 * @param value : unit value
	 * @return boolean : TRUE if the unit exist.
	 */
	public static Boolean existUnitByValue(List<Unit> units, Integer value) {
		if (units != null && units.size() > Constants.VALUE_ZERO) {
			for (Unit unit : units) {
				if (unit.getValue().equals(value))
					return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * Return true if the unit does not exist with the value as a parameter.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 21/04/2017
	 * 
	 * @param units : list of units
	 * @param value : unit value
	 * @return boolean : TRUE if the unit does not exist .
	 */
	public static Boolean noExistUnitByValue(List<Unit> units, Integer value) {
		return !existUnitByValue(units, value);
	}
	
	/**
	 * Return true if the unit does not exist with the name as a parameter.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 21/04/2017
	 * 
	 * @param units : list of units
	 * @param unitName : unit name
	 * @return boolean : TRUE if the unit does not exist .
	 */
	public static Boolean noExistUnitByName(List<Unit> units, String unitName) {
		return !existUnitByName(units, unitName);
	}

	/**
	 * Return the value of the unit founded with the name as a parameter.
	 * 
	 * @author Marcelo Hidalgo
	 * @version 21/04/2017
	 * 
	 * @param units : list of units
	 * @param name : unit name
	 * @return Double : value of the unit .
	 */
	public static Double getUnitValueByName(List<Unit> units, String name) {
		if (units != null && units.size() > Constants.VALUE_ZERO) {
			for (Unit unit : units) {
				if (unit.getName().equals(name.toUpperCase()))
					return unit.getValue();
			}
		}
		return null;
	}
	
}
