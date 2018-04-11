package com.chelohidalgo.picoplacapredictor.test;

import org.junit.Assert;
import org.junit.Test;

import com.chelohidalgo.picoplacapredictor.LicensePlateNumber;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;

public class LicensePlateNumberTest {

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenLicensePlateNumberIsNull() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber(null);
		licensePlateNumber.isValidLicensePlateNumber();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenLicensePlateNumberFormatIsEmpty() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber("");
		licensePlateNumber.isValidLicensePlateNumber();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenLicensePlateNumberFormatWrong() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber("ABC");
		licensePlateNumber.isValidLicensePlateNumber();
	}

	@Test
	public void generateLicensePlateNumber() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber("ABC-1234");
		Assert.assertEquals(true, licensePlateNumber.isValidLicensePlateNumber());
	}

	@Test
	public void shouldReturnFalseWhenLicensePlateNumberIsNull() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber(null);
		try {
			Assert.assertEquals(false, licensePlateNumber.isValidLicensePlateNumber());
		} catch (Exception e) {

		}
	}

	@Test
	public void shouldReturnFalseWhenLicensePlateNumberFormatIsEmpty() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber("");
		try {
			Assert.assertEquals(false, licensePlateNumber.isValidLicensePlateNumber());
		} catch (Exception e) {

		}
	}

	@Test
	public void shouldReturnFalseWhenLicensePlateNumberFormatWrong() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber("ABC");
		try {
			Assert.assertEquals(false, licensePlateNumber.isValidLicensePlateNumber());
		} catch (Exception e) {

		}
	}

	@Test
	public void shouldReturnTrueWhenLicensePlateNumberIsValid() throws PicoPlacaPredictorException {
		LicensePlateNumber licensePlateNumber = new LicensePlateNumber("ABC-1234");
		try {
			Assert.assertEquals(true, licensePlateNumber.isValidLicensePlateNumber());
		} catch (Exception e) {

		}
	}

}
