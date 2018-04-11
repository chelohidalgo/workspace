package com.merchant.util.test;

import org.junit.Test;

import com.merchant.util.NumeralRomanConverter;

import junit.framework.TestCase;

public class NumeralRomanConverterTest extends TestCase {

	@Test
	public void testGetRomanNumeralFromArabicValue() {
		NumeralRomanConverter numeralRomanEnumUtil = new NumeralRomanConverter();
		assertEquals("XLII", numeralRomanEnumUtil.getRomanNumeral(42));
	}

	@Test
	public void testGetRomanNumeralFromMaxValue() {
		NumeralRomanConverter numeralRomanEnumUtil = new NumeralRomanConverter();
		assertEquals("MMMCMXCIX", numeralRomanEnumUtil.getRomanNumeral(3999));
	}

	@Test(expected = NumberFormatException.class)
	public void testGetRomanNumeralFromMoreThanMaxValue() {
		NumeralRomanConverter numeralRomanEnumUtil = new NumeralRomanConverter();
		try {
			numeralRomanEnumUtil.getRomanNumeral(4000);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test(expected = NumberFormatException.class)
	public void testGetRomanNumeralFromValueZero() {
		NumeralRomanConverter numeralRomanEnumUtil = new NumeralRomanConverter();
		try {
			numeralRomanEnumUtil.getRomanNumeral(0);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void testGetArabicFromNumeralRoman() {
		NumeralRomanConverter numeralRomanEnumUtil = new NumeralRomanConverter();
		assertEquals(17, numeralRomanEnumUtil.getArabic("XVII"));
	}

	@Test
	public void testGetArabicFromMaxNumeralRoman() {
		NumeralRomanConverter numeralRomanEnumUtil = new NumeralRomanConverter();
		assertEquals(3999, numeralRomanEnumUtil.getArabic("MMMCMXCIX"));
	}

	@Test
	public void testGetArabicFromEmptyValue() {
		NumeralRomanConverter numeralRomanEnumUtil = new NumeralRomanConverter();
		assertEquals(0, numeralRomanEnumUtil.getArabic(""));
	}

}
