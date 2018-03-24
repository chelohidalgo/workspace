package com.chelohidalgo.picoplacapredictor.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import com.chelohidalgo.picoplacapredictor.PicoPlacaTimeConfiguration;
import com.chelohidalgo.picoplacapredictor.constant.Constant;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;

public class PicoPlacaTimeConfigurationTest {

	@Test
	public void loadPicoPlacaTimeConfiguration() {
		PicoPlacaTimeConfiguration picoPlacaTimeConfiguration = new PicoPlacaTimeConfiguration(new Date(), new Date());
		Assert.assertNotNull(picoPlacaTimeConfiguration);
	}

	@Test
	public void dateBetweenDates() throws PicoPlacaPredictorException {
		SimpleDateFormat formatter = new SimpleDateFormat(Constant.TIME_PATTERN, Locale.US);
		try {
			PicoPlacaTimeConfiguration picoPlacaTimeConfiguration = new PicoPlacaTimeConfiguration(
					formatter.parse("07:00"), formatter.parse("09:30"));
			Assert.assertTrue(picoPlacaTimeConfiguration.dateBetweenDates(formatter.parse("09:00")));
		} catch (ParseException e) {
			throw new PicoPlacaPredictorException("Error: The input date is wrong, must be " + Constant.TIME_PATTERN);
		}
	}

}
