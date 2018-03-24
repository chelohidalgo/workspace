package com.chelohidalgo.picoplacapredictor.test;

import org.junit.Assert;
import org.junit.Test;

import com.chelohidalgo.picoplacapredictor.PicoPlacaConfiguration;
import com.chelohidalgo.picoplacapredictor.PicoPlacaDayConfiguration;
import com.chelohidalgo.picoplacapredictor.PicoPlacaTimeConfiguration;
import com.chelohidalgo.picoplacapredictor.enumeration.PicoPlacaDayEnumeration;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaDayException;

public class PicoPlacaConfigurationTest {

	@Test
	public void loadPicoPlacaConfiguration() {
		PicoPlacaConfiguration picoPlacaConfiguration = null;
		try {
			picoPlacaConfiguration = new PicoPlacaConfiguration();
		} catch (PicoPlacaDayException e) {

		}
		Assert.assertNotNull(picoPlacaConfiguration);
	}

	@Test
	public void loadPicoPlacaDayConfigurationForMonday() {
		try {
			PicoPlacaConfiguration picoPlacaConfiguration = new PicoPlacaConfiguration();
			PicoPlacaDayConfiguration picoPlacaDayConfiguration = picoPlacaConfiguration
					.getPicoPlacaDayConfiguration(PicoPlacaDayEnumeration.MONDAY);
			Assert.assertNotNull(picoPlacaDayConfiguration);
		} catch (PicoPlacaDayException e) {

		}
	}

	@Test
	public void loadPicoPlacaDayConfigurationForTuesday() {
		try {
			PicoPlacaConfiguration picoPlacaConfiguration = new PicoPlacaConfiguration();
			PicoPlacaDayConfiguration picoPlacaDayConfiguration = picoPlacaConfiguration
					.getPicoPlacaDayConfiguration(PicoPlacaDayEnumeration.TUESDAY);
			Assert.assertNotNull(picoPlacaDayConfiguration);
		} catch (PicoPlacaDayException e) {

		}
	}

	@Test
	public void loadPicoPlacaDayConfigurationForWednesday() {
		try {
			PicoPlacaConfiguration picoPlacaConfiguration = new PicoPlacaConfiguration();
			PicoPlacaDayConfiguration picoPlacaDayConfiguration = picoPlacaConfiguration
					.getPicoPlacaDayConfiguration(PicoPlacaDayEnumeration.WEDNESDAY);
			Assert.assertNotNull(picoPlacaDayConfiguration);
		} catch (PicoPlacaDayException e) {

		}
	}

	@Test
	public void loadPicoPlacaDayConfigurationForThursday() {
		try {
			PicoPlacaConfiguration picoPlacaConfiguration = new PicoPlacaConfiguration();
			PicoPlacaDayConfiguration picoPlacaDayConfiguration = picoPlacaConfiguration
					.getPicoPlacaDayConfiguration(PicoPlacaDayEnumeration.THURSDAY);
			Assert.assertNotNull(picoPlacaDayConfiguration);
		} catch (PicoPlacaDayException e) {

		}
	}

	@Test
	public void loadPicoPlacaDayConfigurationForFriday() {
		try {
			PicoPlacaConfiguration picoPlacaConfiguration = new PicoPlacaConfiguration();
			PicoPlacaDayConfiguration picoPlacaDayConfiguration = picoPlacaConfiguration
					.getPicoPlacaDayConfiguration(PicoPlacaDayEnumeration.FRIDAY);
			Assert.assertNotNull(picoPlacaDayConfiguration);
		} catch (PicoPlacaDayException e) {

		}
	}

	@Test
	public void loadPicoPlacaMorningTimeConfiguration() {
		try {
			PicoPlacaConfiguration picoPlacaConfiguration = new PicoPlacaConfiguration();
			PicoPlacaTimeConfiguration picoPlacaTimeConfiguration = picoPlacaConfiguration
					.getDateTimeMorningConfiguration();
			Assert.assertNotNull(picoPlacaTimeConfiguration);
		} catch (PicoPlacaDayException e) {

		}
	}

	@Test
	public void loadPicoPlacaAfternoonTimeConfiguration() {
		try {
			PicoPlacaConfiguration picoPlacaConfiguration = new PicoPlacaConfiguration();
			PicoPlacaTimeConfiguration picoPlacaTimeConfiguration = picoPlacaConfiguration
					.getDateTimeAfternoonConfiguration();
			Assert.assertNotNull(picoPlacaTimeConfiguration);
		} catch (PicoPlacaDayException e) {

		}
	}

}
