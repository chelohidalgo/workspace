package com.chelohidalgo.picoplacapredictor.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.chelohidalgo.picoplacapredictor.constant.Constant;
import com.chelohidalgo.picoplacapredictor.enumeration.PicoPlacaDayEnumeration;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;

public class DateFormatUtil {
	
	public static Date convertStringDateToDate(String dateInString) throws PicoPlacaPredictorException {
		if (dateInString == null || dateInString.isEmpty()) {
			throw new PicoPlacaPredictorException("Error: The input date is null or empty");
		}

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_PATTERN, Locale.US);
			return formatter.parse(dateInString);
		} catch (ParseException e) {
			throw new PicoPlacaPredictorException("Error: The input date is wrong, must be " + Constant.DATE_PATTERN);
		}
	}
	
	public static Date convertStringHourToDate(String hourString) throws PicoPlacaPredictorException {
		if (hourString == null || hourString.isEmpty()) {
			throw new PicoPlacaPredictorException("Error: The input hour is null or empty");
		}

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(Constant.TIME_PATTERN, Locale.US);
			return formatter.parse(hourString);
		} catch (ParseException e) {
			throw new PicoPlacaPredictorException("Error: The input date is wrong, must be " + Constant.TIME_PATTERN);
		}
	}
	
	public static PicoPlacaDayEnumeration getPicoPlacaDayEnumeration(Date date) throws PicoPlacaPredictorException{
		if(date == null){
			throw new PicoPlacaPredictorException("Error: The date is null");
		}
			
	    return PicoPlacaDayEnumeration.valueOf(getFullDayName(date));
	}

	private static String getFullDayName(Date date) {
		Format formatter = new SimpleDateFormat(Constant.DAY_PATTERN, Locale.US); 
		return formatter.format(date).toUpperCase();
	}

}
