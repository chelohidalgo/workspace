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

	public static Double getUnitValueByName(List<Unidad> units, String name){
		if(units != null && units.size() > Constantes.VALOR_CERO){
			for (Unidad unit : units) {
				if(unit.getNombre().equals(name))
					return unit.getValor();
			}
		}
		return null;
	}
	
//	/**
//	 * <b>
//	 * Construye los objetos nuevos de unidad de medida.
//	 * </b>
//	 * <p>[Author: Marcelo Hidalgo, Date: 12/02/2014]</p>
//	 * 
//	 * @param entradaEscaner objeto que lee desde consola
//	 * @param numeroUnidad numero de la unidad a instanciar
//	 * @return Unidad devuelve la unidad instanciada
//	 */
//	private static Unidad instanciarUnidad(List<Unidad> unidades, String nombre, String valor) {
//
//		while (validarExistenciaDeUnidadSegunSimbolo(unidades, simbolo, unidad) == null) {
//			System.out.print("Unidad " + nombre + " existente, ingrese nuevamente");
//			nombre = entradaEscaner.nextLine();
//		}
//		unidad = validarExistenciaDeUnidadSegunSimbolo(unidades, simbolo, unidad);
//		return unidad;
//	}
}
