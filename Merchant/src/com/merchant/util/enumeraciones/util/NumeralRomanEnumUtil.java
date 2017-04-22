package com.merchant.util.enumeraciones.util;

import com.merchant.util.Constants;
import com.merchant.util.enumeraciones.NumeralRomanEnum;

/**
 * Util Class to convert numbers to numeral romans or vice versa.
 * 
 * @author  Marcelo Hidalgo
 * @version 1.0.0, 21/04/2014
 *
 */
public final class NumeralRomanEnumUtil {

	private final int number;
	private static int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static String[] letters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	/**
	 * <b> Constructor with the int value specified as a parameter in order to
	 * convert to roman numerals.</b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 *
	 * @param arabic : value specified to convert
	 */
    public NumeralRomanEnumUtil(int arabic) {
       if (arabic < Constants.VALUE_ONE && arabic > Constants.MAX_VALUE_ROMAN_NUMERAL)
          throw new NumberFormatException("Value of RomanNumeral must be between 1 and 3999.");
       number = arabic;
    }
    
	/**
	 * <b> Constructor with the Roman number as a parameter in order to convert
	 * to arabic. </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 *
	 * @param arabic : value specified to covert
	 */
    public NumeralRomanEnumUtil(String romanNumeral) {
       if (romanNumeral.length() == Constants.VALUE_ZERO)
          throw new NumberFormatException("There is not a roman numeral with an empty string.");
          
       romanNumeral = romanNumeral.toUpperCase();  
       int position = Constants.VALUE_ZERO;       
       int arabic = Constants.VALUE_ZERO;
       
       while (position < romanNumeral.length()) {
       
          char letter = romanNumeral.charAt(position);        
          int number = findTheValueOfRomanNumeral(findNumeralRomanBySymbol(letter));
          position++;
          
          if (position == romanNumeral.length()) {
             arabic += number;
          } else {
             int nextNumber = findTheValueOfRomanNumeral(findNumeralRomanBySymbol(romanNumeral.charAt(position)));
             if (nextNumber > number) {
                arabic += (nextNumber - number);
                position++;
             } else {
                arabic += number;
             }
          }
       }  
       
       if (arabic > Constants.MAX_VALUE_ROMAN_NUMERAL)
          throw new NumberFormatException("Value of RomanNumeral must be between 1 and 3999.");
       number = arabic;
    } 
    
    /**
	 * <b> Return the value of a roman numeral </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 *
	 * @param numeralRomanEnum : numeralRomanEnum specified to covert
	 */
    private int findTheValueOfRomanNumeral(NumeralRomanEnum numeralRomanEnum) {
       switch (numeralRomanEnum) {
          case ONE:  return 1;
          case FIVE:  return 5;
          case TEN:  return 10;
          case FIFTY:  return 50;
          case HUNDRED:  return 100;
          case FIVE_HUNDRED:  return 500;
          case THOUSAND:  return 1000;
          default:   throw new NumberFormatException("Numeral Roman does not exist.");
       }
    }
    
    /**
	 * <b> Return the roman numeral </b>
	 * <p>
	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
	 * </p>
	 *
	 */
    public String getRomanNumeral() {
       String roman = "";  
       int N = number;
       NumeralRomanEnum[] numeralRomans = NumeralRomanEnum.values();
       int position = Constants.VALUE_ZERO;
       roman = iterateRomanNumeral(position, position, numeralRomans, N, roman);                  
//       for (int i = 0; i < numbers.length; i++) {
//          while (N >= numbers[i]) {
//             roman += letters[i];
//             N -= numbers[i];
//          }
//       }
       return roman;
    }
    
    /**
   	 * <b> Iterate the roman numerals in order to find out the roman numeral</b>
   	 * <p>
   	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
   	 * </p>
   	 *
   	 */
    private String iterateRomanNumeral(int i, int j, NumeralRomanEnum[] numeralRomanEnums, int N, String roman){
    	int position = j;
    	if(i < NumeralRomanEnum.values().length && numeralRomanEnums[i] != null){
    		 if (N >= numeralRomanEnums[i].getValue()) {
                 roman += numeralRomanEnums[i].getSymbol();
                 N -= numeralRomanEnums[i].getValue();
                 roman = iterateRomanNumeral(i, j, numeralRomanEnums, N, roman);
              } else{
            	  position ++ ;
            	  return roman = iterateRomanNumeral(position, position ,numeralRomanEnums, N, roman); 
              }
    		 i++;
    		 roman = iterateRomanNumeral(i, j, numeralRomanEnums, N, roman);
    	 } 
    	 return roman;
    }
    
    /**
   	 * <b> Return the arabic number </b>
   	 * <p>
   	 * [Author: Marcelo Hidalgo, Date: 21/04/2017]
   	 * </p>
   	 *
   	 */
    public int getArabic() {
       return number;
    }
    
    /**
	 * Return the enumeration by symbol as a parameter. 
	 *
	 * @author  Marcelo Hidalgo
	 * @version 21/04/2017
	 * 
	 * @param symbol symbol.
	 * @return NumeralRomanEnum result.
	 */
	private static NumeralRomanEnum findNumeralRomanBySymbol(final char symbol) {
		NumeralRomanEnum rumeralRomanEnum = null;
		NumeralRomanEnum[] numerosRomanosEnums = NumeralRomanEnum.values();
		for (int i = 0; i < numerosRomanosEnums.length; i++) {
			if(numerosRomanosEnums[i].getSymbol().equals(String.valueOf(symbol))) {
				rumeralRomanEnum = numerosRomanosEnums[i];
				break;
			}
		}
		return rumeralRomanEnum;
	}
  
}
