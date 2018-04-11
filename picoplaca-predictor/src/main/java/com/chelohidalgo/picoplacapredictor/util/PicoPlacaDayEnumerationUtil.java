package com.chelohidalgo.picoplacapredictor.util;

import java.util.Date;

import com.chelohidalgo.picoplacapredictor.enumeration.PicoPlacaDayEnumeration;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaDayException;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;

public class PicoPlacaDayEnumerationUtil {

	public static PicoPlacaDayEnumeration getPicoPlacaFullDayName(Date date)
			throws PicoPlacaDayException, PicoPlacaPredictorException {
		try {
			return DateFormatUtil.getPicoPlacaDayEnumeration(date);
		} catch (IllegalArgumentException e) {
			throw new PicoPlacaDayException("Weekend has not pico y placa");
		}
	}

}
