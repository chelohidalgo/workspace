package com.merchant.util.test;

import org.junit.Test;

import com.merchant.util.NumberUtil;

import junit.framework.TestCase;

public class NumberUtilTest extends TestCase {

	@Test
	public void testIsNumber() {
		assertTrue(NumberUtil.isNumber("3.141592"));
	}
	
	@Test
	public void testIsNotNumber() {
		assertFalse(NumberUtil.isNumber("X"));
	}
	
	@Test
	public void testIsNumberWitEmptyValue() {
		assertFalse(NumberUtil.isNumber(""));
	}
	
	@Test
	public void testIsNumberWithoutValue() {
		assertFalse(NumberUtil.isNumber(null));
	}

}
