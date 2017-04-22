package com.merchant.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.merchant.util.Constants;
import com.merchant.util.NumberUtil;
import com.merchant.util.UnitUtil;
import com.merchant.util.enumeraciones.util.MetalEnumUtil;
import com.merchant.util.enumeraciones.util.NumeralRomanEnumUtil;

/**
 * <b> Converter intergalactic units. </b>
 * 
 * @author Marcelo Hidalgo
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: Marcelo Hidalgo$, $Date: 21/04/2017 $]
 *          </p>
 */
public class Inicio {

	private static List<Unit> units;
	private static BufferedReader br;
	private static final String NAME_VALUE_SEPARATOR = " is ";

	/**
	 * <b> Method main in order to execute the application. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 *
	 */
	public static void main(String[] args) {
		try {
			getFile();
			units = new ArrayList<Unit>();
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				String[] words = currentLine.split(NAME_VALUE_SEPARATOR);
				units.add(createUnit(words[Constants.VALUE_ZERO], words[Constants.VALUE_ONE]));
			}
			br.close();
			Scanner in = new Scanner(System.in);
			printIntergalacticUnits();
			String letter = Constants.LETTER_YES;
			while (Constants.LETTER_YES.equals(letter.toUpperCase())) {
				System.out.print("Value to calculate is ");
				String input = in.nextLine();
				System.out.println("The outcome for:" + input + NAME_VALUE_SEPARATOR + convert(input));
				System.out.println("Do you want to convert anything else?(Y,N):");
				letter = in.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * <b> Print in console the intergalactic units in order to use with the application. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 * 
	 */
	private static void printIntergalacticUnits() {
		System.out.println("The intergalactic units are:");
		for (Unit unidad : units) {
			System.out.println("Unit: " + unidad.getName().toUpperCase() + "\t Value: " + unidad.getValue());
		}
	}

	/**
	 * <b> Create the intergalactic unit </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 * 
	 * @param name : unit's name
	 * @param value : units's value
	 *            
	 * @return Unit : unit created
	 */
	private static Unit createUnit(String name, String value) {
		double valuePreName = 0;

		if (UnitUtil.existUnitByName(units, name)) {
			System.out.println("There is a unit with name " + name + ", skipped");
			return null;
		}

		String[] words = name.split(Constants.CHAR_SPACE);
		if (words.length > Constants.VALUE_ONE) {
			StringBuilder preName = new StringBuilder();
			for (String word : words) {
				if (UnitUtil.existUnitByName(units, word)) {
					NumeralRomanEnumUtil num = new NumeralRomanEnumUtil(UnitUtil.getUnitValueByName(units, word).intValue());
					preName.append(num.getRomanNumeral()).append(Constants.CHAR_EMPTY);
				} else {
					name = word;
				}
			}

			NumeralRomanEnumUtil num = new NumeralRomanEnumUtil(preName.toString());
			valuePreName = num.getArabic();
		}

		if (NumberUtil.isNumber(value)) {
			valuePreName = valuePreName != 0 ? Integer.valueOf(value) / valuePreName : Integer.valueOf(value);
		} else {
			NumeralRomanEnumUtil num = new NumeralRomanEnumUtil(value);
			if (num.getArabic() != 0)
				valuePreName = valuePreName != 0 ? num.getArabic() / valuePreName : num.getArabic();
		}

		Unit unit = new Unit();
		unit.setName(name.toUpperCase());
		unit.setValue(valuePreName);
		return unit;
	}

	/**
	 * <b> Convert the intergalactic unit to number </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 * 
	 */
	private static Double convert(String input) {
		if (input != null && input.length() > 0) {
			Double value = null;
			String[] words = input.split(Constants.CHAR_SPACE);

			StringBuilder unitToTransform = new StringBuilder();
			for (String word : words) {
				if (MetalEnumUtil.isMetal(word)) {
					value = UnitUtil.getUnitValueByName(units, word);
					if(existMoreWords(words, word)){
						System.out.println("I have no idea what you are talking about");
						return null;
					}
					break;
				}
				
				if (UnitUtil.noExistUnitByName(units, word)) {
					System.out.println("I have no idea what you are talking about");
					return null;
				}
				
				NumeralRomanEnumUtil num = new NumeralRomanEnumUtil(UnitUtil.getUnitValueByName(units, word).intValue());
				unitToTransform.append(num.getRomanNumeral()).append(Constants.CHAR_EMPTY);
			}
			
			if(words.length == Constants.VALUE_ONE)
				return value; 
			
			NumeralRomanEnumUtil num = new NumeralRomanEnumUtil(unitToTransform.toString().trim());
			
			return value != null ? new Double(num.getArabic() * value) : new Double(num.getArabic());
		}
		return new Double(0);
	}

	/**
	 * <b> Verify if the metal is the last word of the quantity to convert. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 * 
	 * @param words : quantity to convert
	 * @param word : word to validate if is the last 
	 * @return boolean : true if the word as a parameter is the last
	 */
	private static boolean existMoreWords(String[] words, String word) {
		if(words != null && words.length > Constants.VALUE_ZERO && word.equals(words[words.length - Constants.VALUE_ONE])){
			 return false;
		}
		return true;
	}

	/**
	 * <b> Get the input file in order to generate the intergalactic units. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 * 
	 * @throws Exception
	 *             : when exist an error
	 */
	private static void getFile() throws Exception {
		StringBuilder filename = new StringBuilder();
		try {
			filename.append(Constants.PATH_FILE).append(Constants.FILENAME);
			br = new BufferedReader(new FileReader(filename.toString()));
		} catch (IOException ex) {
			throw new Exception("File not founded or corrupted");
		} catch (Exception e) {
			throw new Exception("Sorry, we have troubles with the application, please try later...");
		}
	}

}
