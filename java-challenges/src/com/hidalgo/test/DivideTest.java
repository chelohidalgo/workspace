package com.hidalgo.test;

import org.junit.Test;

import com.hidalgo.Divison;

import junit.framework.TestCase;

public class DivideTest extends TestCase{

	@Test
	public void testDivide(){
		Divison divison = new Divison();
		assertEquals(5,divison.divide2(20, 7));
	}
	
}
