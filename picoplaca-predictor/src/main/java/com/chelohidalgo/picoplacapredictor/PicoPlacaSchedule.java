package com.chelohidalgo.picoplacapredictor;

import java.util.Date;
import java.util.List;

import com.chelohidalgo.picoplacapredictor.enumeration.PicoPlacaDayEnumeration;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaDayException;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;
import com.chelohidalgo.picoplacapredictor.util.PicoPlacaDayEnumerationUtil;

public class PicoPlacaSchedule {

	private Car car;
	private PicoPlacaConfiguration picoPlacaConfiguration;

	public PicoPlacaSchedule(Car car) {
		this.car = car;
	}

	public boolean isPicoPlaca(Date date, Date time) throws PicoPlacaPredictorException {
		try {
			if (isFeriadoOrWeekend(date) || car.isGovermentCarOrTaxi())
				return false;
			if (car.getLicensePlateNumber().isValidLicensePlateNumber()) {
				picoPlacaConfiguration = new PicoPlacaConfiguration();
				return toVerifyPicoPlaca(date, time);
			}
		} catch (Exception e) {
			throw new PicoPlacaPredictorException(e.getMessage());
		}
		return false;
	}

	private boolean toVerifyPicoPlaca(Date date, Date time)
			throws PicoPlacaPredictorException, PicoPlacaDayException {
		if (isDayPicoPlaca(date) && isTimePicoPlaca(time)) {
			return true;
		}
		return false;
	}

	private boolean isDayPicoPlaca(Date date) throws PicoPlacaDayException, PicoPlacaPredictorException {
		PicoPlacaDayEnumeration day = PicoPlacaDayEnumerationUtil.getPicoPlacaFullDayName(date);
		PicoPlacaDayConfiguration picoPlacaDayConfiguration = picoPlacaConfiguration.getPicoPlacaDayConfiguration(day);
		List<Integer> forbiddenNumbers = picoPlacaDayConfiguration.getForbiddenNumbersByDay();
		return forbiddenNumbers.contains(car.getLicensePlateNumber().getLastDigit());
	}

	private boolean isTimePicoPlaca(Date time) throws PicoPlacaPredictorException {
		return isBetweenMorningPicoPlacaTime(time) || isBetweenAfternoonPicoPlacaTime(time);
	}

	private boolean isBetweenAfternoonPicoPlacaTime(Date hour) {
		return picoPlacaConfiguration.getDateTimeAfternoonConfiguration().dateBetweenDates(hour);
	}

	private boolean isBetweenMorningPicoPlacaTime(Date hour) {
		return picoPlacaConfiguration.getDateTimeMorningConfiguration().dateBetweenDates(hour);
	}

	private boolean isFeriadoOrWeekend(Date date) throws PicoPlacaPredictorException {
		try {
			if (PicoPlacaDayEnumerationUtil.getPicoPlacaFullDayName(date) != null)
				return false;
		} catch (PicoPlacaDayException e) {
			return true;
		} catch (Exception e) {
			throw new PicoPlacaPredictorException(e.getMessage());
		}
		return true;
	}

}
