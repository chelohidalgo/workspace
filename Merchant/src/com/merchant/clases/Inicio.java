/*
 * Copyright 2017
 * Todos los derechos reservados
 */
package com.merchant.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.merchant.util.Constantes;
import com.merchant.util.NumeroUtil;
import com.merchant.util.UnidadUtil;
import com.merchant.util.enumeraciones.MetalesEnum;
import com.merchant.util.enumeraciones.util.NumeroRomanoEnumUtil;

/**
 * <b> Convertidor unidades intergalacticas. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo$, $Date: 11/02/2017 $]
 *          </p>
 */
public class Inicio {

	protected static List<Unidad> unidades;

	/**
	 * <b> Ejecuta el funcionamiento del conversor. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 13/02/2014]
	 * </p>
	 *
	 */
	public static void main(String[] args) {
		Scanner entradaEscaner = new Scanner(System.in);
		presentarMensajesIniciales();
		String numeroCantidadUnidadesNueva = leerNumeroDeCantidadesNuevas(entradaEscaner);
		unidades = generarUnidadesMedida(entradaEscaner, numeroCantidadUnidadesNueva);
		presentarNuevasUnidades();
		String recalcular = "S";
		while ("S".equals(recalcular.toUpperCase())) {
			System.out.println("Calcular:");
			String cantidad = entradaEscaner.nextLine();
			System.out.println("El resultado es:" + convertir(cantidad));
			System.out.println("Desea realizar otro calculo?(S,N):");
			recalcular = entradaEscaner.nextLine();
		}
	}

	/**
	 * <b> Recupera el numero de nuevas unidades de medida a crear. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 12/02/2014]
	 * </p>
	 *
	 * @param entradaEscaner
	 *            objeto que lee desde consola
	 * @return cantidad de unidades nuevas a crear
	 */
	private static String leerNumeroDeCantidadesNuevas(Scanner entradaEscaner) {
		String cantidadUnidadesMedida = entradaEscaner.nextLine();

		if (validarCantidadUnidadesDeMedida(cantidadUnidadesMedida))
			return cantidadUnidadesMedida;
		else {
			System.out.println("Numero mayor a 7 o número invalido, intente nuevamente");
			return leerNumeroDeCantidadesNuevas(entradaEscaner);
		}
	}

	/**
	 * <b> Imprime en consola las nuevas unidades de medida. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 12/02/2014]
	 * </p>
	 * 
	 */
	private static void presentarNuevasUnidades() {
		System.out.println("Las nuevas unidades son:");
		for (Unidad unidad : unidades) {
			System.out.println("Nombre: " + unidad.getNombre().toUpperCase() + "\t Valor: " + unidad.getValor());
		}
	}

	/**
	 * <b> Imprime en consola los mensajes iniciales. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 12/02/2014]
	 * </p>
	 * 
	 */
	private static void presentarMensajesIniciales() {
		System.out
				.println("---******************************** BIENVENIDO ****************************************---");
		System.out.println("---*** CONVERSOR UNIDADES INTERGALACTICAS ***---");
		System.out.println("--------NUMEROS ROMANOS Y VALORES POSIBLES----------");
		System.out.println("1.- SIMBOLO \t VALOR");
		System.out.println("1.- I \t \t 1");
		System.out.println("2.- V \t \t 5");
		System.out.println("3.- X \t \t 10");
		System.out.println("4.- L \t \t 50");
		System.out.println("5.- C \t \t 100");
		System.out.println("6.- D \t \t 500");
		System.out.println("7.- M \t \t 1000");
		System.out.println("---*** INGRESE EL NUMERO DE UNIDADES DE MEDIDA A DEFINIR (MAX 7) ***---");
	}

	/**
	 * <b> Genera las unidades de medida. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 12/02/2014]
	 * </p>
	 * 
	 * @param entradaEscaner
	 *            objeto que lee desde consola
	 * @param cantidadUnidadesMedida
	 *            cantidad de nuevas unidades a construir
	 * @return List<Unidad> lista de unidades instanciadas
	 */
	public static List<Unidad> generarUnidadesMedida(Scanner entradaEscaner, String cantidadUnidadesMedida) {
		List<Unidad> unidades = new ArrayList<Unidad>();
		for (int i = Constantes.VALOR_UNO; i <= Integer.valueOf(cantidadUnidadesMedida); i++) {

			Unidad unidad = crearUnidad(entradaEscaner, i, unidades);
			unidades.add(unidad);
		}
		return unidades;
	}

	/**
	 * <b> Crea la nueva unidad de medida. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 12/02/2014]
	 * </p>
	 * 
	 * @param entradaEscaner
	 *            objeto que lee desde consola
	 * @param numeroUnidad
	 *            numero de la unidad a instanciar
	 * @return Unidad devuelve la unidad instanciada
	 */
	private static Unidad crearUnidad(Scanner entradaEscaner, int numeroUnidad, List<Unidad> unidades) {
		System.out.print("Unidad " + numeroUnidad + " nombre:");
		String nombre = entradaEscaner.nextLine();
		double valor = 0;

		if (UnidadUtil.existUnitByName(unidades, nombre)) {
			System.out.println("Unidad " + nombre + " existente, ingrese nuevamente");
			crearUnidad(entradaEscaner, numeroUnidad, unidades);
		}

		String[] palabras = nombre.split(" ");
		if (palabras.length > Constantes.VALOR_UNO) {
			String preNombre = "";
			for (String palabra : palabras) {
				if (UnidadUtil.existUnitByName(unidades, palabra)) {

					NumeroRomanoEnumUtil num = new NumeroRomanoEnumUtil(
							UnidadUtil.getUnitValueByName(unidades, palabra).intValue());
					preNombre += num.toString();
				} else
					nombre = palabra;
			}

			NumeroRomanoEnumUtil num = new NumeroRomanoEnumUtil(preNombre);
			valor = num.toInt();
			System.out.println("numero transformado es " + valor);
		}

		System.out.print("Unidad " + numeroUnidad + ": Valor( Arabicos / "
				+ NumeroRomanoEnumUtil.obtenerSimbolosNumerosRomanos() + "):");
		String valorIngresado = entradaEscaner.nextLine();
		if (NumeroUtil.esNumero(valorIngresado)) {
			valor = valor != 0 ? Integer.valueOf(valorIngresado) / valor : Integer.valueOf(valorIngresado);
		} else {
			NumeroRomanoEnumUtil num = new NumeroRomanoEnumUtil(valorIngresado);
			if (num.toInt() != 0)
				valor = valor != 0 ? num.toInt() / valor : num.toInt();
		}

		Unidad unidad = new Unidad();
		unidad.setNombre(nombre);
		unidad.setValor(valor);
		return unidad;
	}

	/**
	 * Valida si la cantidad ingresada es un numero y si es menor a 8
	 *
	 * @author Marcelo Hidalgo - ALES
	 * @version 11/02/2014
	 * 
	 * @param cantidadUnidadesMedida
	 * @return verdadero si cumple las dos condiciones
	 */
	private static boolean validarCantidadUnidadesDeMedida(String cantidadUnidadesMedida) {
		return NumeroUtil.esNumero(cantidadUnidadesMedida)
				&& (Integer.valueOf(cantidadUnidadesMedida) > Constantes.VALOR_CERO
						&& Integer.valueOf(cantidadUnidadesMedida) <= Constantes.VALOR_SIETE);
	}

	/**
	 * <b> Convierte la cantidad ingresada. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 12/02/2014]
	 * </p>
	 * 
	 */
	private static Double convertir(String cantidad) {
		if (cantidad != null && cantidad.length() > 0) {
			Double valorMetal = null;
			String[] palabras = cantidad.split(" ");

			if (palabras.length > Constantes.VALOR_UNO) {
				String unidadAtransformar = "";
				for (String palabra : palabras) {
					if (MetalesEnum.GOLD.toString().equals(palabra.toUpperCase()) || MetalesEnum.SILVER.toString().equals(palabra.toUpperCase())
							|| MetalesEnum.IRON.toString().equals(palabra.toUpperCase())) {
						valorMetal = UnidadUtil.getUnitValueByName(unidades, palabra);
						break;
					}

					if (UnidadUtil.noExistUnitByName(unidades, palabra)) {
						System.out.println("I have no idea what you are talking about");
						return new Double(0);
					}

					NumeroRomanoEnumUtil num = new NumeroRomanoEnumUtil(
							UnidadUtil.getUnitValueByName(unidades, palabra).intValue());
					unidadAtransformar += num.toString();
				}

				NumeroRomanoEnumUtil num = new NumeroRomanoEnumUtil(unidadAtransformar);

				return valorMetal != null ? new Double(num.toInt() * valorMetal) : new Double(num.toInt());
			}
		}
		return new Double(0);
	}

}
