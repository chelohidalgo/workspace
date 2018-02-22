package com.merchant.enumerations.util.test;

import org.junit.Test;

import com.merchant.CurrentLine;
import com.merchant.enumerations.util.MetalEnumUtil;

import junit.framework.TestCase;

public class MetalEnumUtilTest extends TestCase {

	@Test
	public void testIsMetalUnit() {
		CurrentLine currentLine = new CurrentLine("Silver", "I");
		assertTrue(MetalEnumUtil.isMetalUnit(currentLine));
	}
	
	@Test
	public void testIsNotMetalUnit() {
		CurrentLine currentLine = new CurrentLine("glob", "I");
		assertFalse(MetalEnumUtil.isMetalUnit(currentLine));
	}

}
