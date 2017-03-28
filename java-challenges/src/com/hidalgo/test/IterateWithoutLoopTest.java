package com.hidalgo.test;

import org.junit.Test;

import com.hidalgo.Father;
import com.hidalgo.Son;

import junit.framework.TestCase;

public class IterateWithoutLoopTest extends TestCase {

	/**
	 * <b> This method allow to iterate as a for, while,do_while, but, without
	 * using loops. This option is not the best solution.</b>
	 * 
	 * @author chelohidalgo
	 */
	@Test
	public void testWithoutLoop() {
		Son son = new Son(0);
		assertEquals(1000, son.max_value);
	}
	
	/**
	 * <b> This method allow to iterate as a for, while,do_while, but, without
	 * using loops.</b>
	 * 
	 * @author chelohidalgo
	 */
	@Test
	public void testWithoutLoop2() {
		
		Son son = new Son();
		assertEquals(1000, son.max_value);
		
	}
	
	/**
	 * <b> This method allow to iterate as a for, while,do_while, but, without
	 * using loops.</b>
	 * 
	 * @author chelohidalgo
	 */
	@Test
	public void testWithoutLoop3() {
		Father a = new Father();
		assertEquals(1000, a.iterate(0));
	}

}
