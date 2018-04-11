package com.merchant.util;

public final class NumeralRomanConverter {
	
	public final int[] NUMBER_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    public final String[] NUMBER_LETTERS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public int getArabic(String roman) {
    	for (int i = 0; i < NUMBER_LETTERS.length; i++) {
    		if(roman.startsWith(NUMBER_LETTERS[i])) 
                return NUMBER_VALUES[i] + getArabic(roman.replaceFirst(NUMBER_LETTERS[i], ""));
		}
        return 0;
    }

    public String getRomanNumeral(int num) {
    	if (num < Constants.VALUE_ONE && num > Constants.MAX_VALUE_ROMAN_NUMERAL)
            throw new NumberFormatException("Value of RomanNumeral must be between 1 and 3999.");
        String roman = ""; 
        for (int i = 0; i < NUMBER_VALUES.length; i++) {
        	while (num >= NUMBER_VALUES[i]) { 
                roman += NUMBER_LETTERS[i]; 
                num -= NUMBER_VALUES[i]; 
            }
		}
        return roman;
    }

}
