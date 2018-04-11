package com.chelohidalgo.picoplacapredictor.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.chelohidalgo.picoplacapredictor.PicoPlacaDayConfiguration;
import com.chelohidalgo.picoplacapredictor.enumeration.PicoPlacaDayEnumeration;

public class PicoPlacaDayConfigurationTest {

	@Test
	public void shouldReturnForbiddenNumbersForMonday() {
		PicoPlacaDayConfiguration picoPlacaDayConfiguration = new PicoPlacaDayConfiguration(
				PicoPlacaDayEnumeration.MONDAY);
		List<Integer> forbiddenNumbers = picoPlacaDayConfiguration.getForbiddenNumbersByDay();
		Integer[] forbiddenNumbersExpected = {1,2};
		Assert.assertArrayEquals(forbiddenNumbersExpected, forbiddenNumbers.toArray());
	}
	
	@Test
	public void shouldReturnForbiddenNumbersForTuesday() {
		PicoPlacaDayConfiguration picoPlacaDayConfiguration = new PicoPlacaDayConfiguration(
				PicoPlacaDayEnumeration.TUESDAY);
		List<Integer> forbiddenNumbers = picoPlacaDayConfiguration.getForbiddenNumbersByDay();
		Integer[] forbiddenNumbersExpected = {3,4};
		Assert.assertArrayEquals(forbiddenNumbersExpected, forbiddenNumbers.toArray());
	}
	
	@Test
	public void shouldReturnForbiddenNumbersForWednesday() {
		PicoPlacaDayConfiguration picoPlacaDayConfiguration = new PicoPlacaDayConfiguration(
				PicoPlacaDayEnumeration.WEDNESDAY);
		List<Integer> forbiddenNumbers = picoPlacaDayConfiguration.getForbiddenNumbersByDay();
		Integer[] forbiddenNumbersExpected = {5,6};
		Assert.assertArrayEquals(forbiddenNumbersExpected, forbiddenNumbers.toArray());
	}
	
	@Test
	public void shouldReturnForbiddenNumbersForThursday() {
		PicoPlacaDayConfiguration picoPlacaDayConfiguration = new PicoPlacaDayConfiguration(
				PicoPlacaDayEnumeration.THURSDAY);
		List<Integer> forbiddenNumbers = picoPlacaDayConfiguration.getForbiddenNumbersByDay();
		Integer[] forbiddenNumbersExpected = {7,8};
		Assert.assertArrayEquals(forbiddenNumbersExpected, forbiddenNumbers.toArray());
	}
	
	@Test
	public void shouldReturnForbiddenNumbersForFriday() {
		PicoPlacaDayConfiguration picoPlacaDayConfiguration = new PicoPlacaDayConfiguration(
				PicoPlacaDayEnumeration.FRIDAY);
		List<Integer> forbiddenNumbers = picoPlacaDayConfiguration.getForbiddenNumbersByDay();
		Integer[] forbiddenNumbersExpected = {9,0};
		Assert.assertArrayEquals(forbiddenNumbersExpected, forbiddenNumbers.toArray());
	}

}
