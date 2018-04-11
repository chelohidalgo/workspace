package com.chelohidalgo.picoplacapredictor.test;

import org.junit.Assert;
import org.junit.Test;

import com.chelohidalgo.picoplacapredictor.PicoPlacaPredictor;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;

public class PicoPlacaPredictorTest {

	@Test
	public void generatePicoPlacaPredictor() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "7-Jun-2013", "09:15");
		Assert.assertNotNull(picoPlacaPredictor);
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenLicensePlateNumberIsNull() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor(null, "7-Jun-2013", "09:15");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenLicensePlateNumberFormatIsEmpty() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("", "7-Jun-2013", "09:15");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenLicensePlateNumberFormatWrong() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC", "72013", "09:15");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenStringDateIsNull() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", null, "09:15");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenStringDateIsEmpty() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "", "09:15");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenStringDateIsWrong() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "72013", "09:15");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenStringTimeIsNull() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "7-Jun-2018", null);
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenStringTimeIsEmpty() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "7-Jun-2018", "");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test(expected = PicoPlacaPredictorException.class)
	public void shouldReturnExceptionWhenStringTimeIsWrong() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "7-Jun-2018", "0:A");
		picoPlacaPredictor.carCanBeOnRoad();
	}

	@Test
	public void shouldReturnYesYouCanRoadWhenIsWeekend() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "24-Mar-2018", "09:15");
		Assert.assertEquals("Yes, you can road", picoPlacaPredictor.carCanBeOnRoad());
	}

	@Test
	public void shouldReturnYesYouCanRoadWhenIsCarGovermentOrTaxi() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("XYZ-1234", "20-Mar-2018", "09:15");
		Assert.assertEquals("Yes, you can road", picoPlacaPredictor.carCanBeOnRoad());
	}

	@Test
	public void shouldReturnYesYouCanRoad() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1234", "23-Mar-2018", "09:15");
		Assert.assertEquals("Yes, you can road", picoPlacaPredictor.carCanBeOnRoad());
	}

	@Test
	public void shouldReturnNoYouCanNotRoadWhenIsPicoYPlacaDayAndTime() throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1239", "23-Mar-2018", "09:15");
		Assert.assertEquals("No, you can not road", picoPlacaPredictor.carCanBeOnRoad());
	}

	@Test
	public void shouldReturnYesYouCanRoadWhenIsPicoYPlacaDayButTimeNotInPicoPlacaTime()
			throws PicoPlacaPredictorException {
		PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor("ABC-1239", "23-Mar-2018", "09:31");
		Assert.assertEquals("Yes, you can road", picoPlacaPredictor.carCanBeOnRoad());
	}

}
