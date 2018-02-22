package com.merchant.test;

import org.junit.Test;

import com.merchant.CurrentLine;
import com.merchant.File;

import junit.framework.TestCase;

public class FileTest extends TestCase {

	@Test
	public void testDefaultGetFile() throws Exception {
		File.getFile();
		assertTrue(File.br != null);
		File.close();
	}

	@Test
	public void testDefaultFirstCurrentLine() throws Exception {
		File.getFile();
		CurrentLine currentLine = File.getCurrentLine();
		assertEquals("I", currentLine.getValue());
		File.close();
	}

	@Test(expected = Exception.class)
	public void throwsExceptionGetCurrentLineWithFileNotLoaded() {
		try {
			File.getCurrentLine();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
