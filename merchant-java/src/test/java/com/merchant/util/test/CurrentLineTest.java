package com.merchant.util.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.merchant.CurrentLine;
import com.merchant.util.CurrentLineUtil;

import junit.framework.TestCase;

public class CurrentLineTest extends TestCase {

	@Test
	public void testGetPreNames() {
		CurrentLine currentLine = new CurrentLine("glob prok Silver", null);
		String[] preNames = CurrentLineUtil.getPreNames(currentLine);
		assertEquals(3, preNames.length);
	}
	
	@Test
	public void testGetPreNamesWithCurrentLineNameEmpty() {
		CurrentLine currentLine = new CurrentLine("", null);
		String[] preNames = CurrentLineUtil.getPreNames(currentLine);
		assertNotEquals(0, preNames.length);
	}

	@Test
	public void testGetLastName() {
		CurrentLine currentLine = new CurrentLine("glob prok Silver", null);
		assertEquals("Silver", CurrentLineUtil.getLastName(currentLine));
	}
	
	@Test
	public void testGetLastNameWithCurrentLineNameEmpty() {
		CurrentLine currentLine = new CurrentLine("", null);
		assertEquals("", CurrentLineUtil.getLastName(currentLine));
	}

}
