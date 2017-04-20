package com.merchant.util;

import java.util.List;

import com.merchant.clases.Unidad;

public class UnidadUtil {

	public static Boolean existUnitByName(List<Unidad> units, String unitName) {
		if (units != null && units.size() > Constantes.VALOR_CERO) {
			for (Unidad unit : units) {
				if (unit.getNombre().equals(unitName))
					return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public static Boolean existUnitByValue(List<Unidad> units, Integer value) {
		if (units != null && units.size() > Constantes.VALOR_CERO) {
			for (Unidad unit : units) {
				if (unit.getValor().equals(value))
					return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public static Boolean noExistUnitByValue(List<Unidad> units, Integer value) {
		return !existUnitByValue(units, value);
	}
	
	public static Boolean noExistUnitByName(List<Unidad> units, String unitName) {
		return !existUnitByName(units, unitName);
	}

	public static Double getUnitValueByName(List<Unidad> units, String name) {
		if (units != null && units.size() > Constantes.VALOR_CERO) {
			for (Unidad unit : units) {
				if (unit.getNombre().equals(name))
					return unit.getValor();
			}
		}
		return null;
	}
	
}
