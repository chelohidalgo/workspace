package com.chelohidalgo.picoplacapredictor.service;

import com.chelohidalgo.picoplacapredictor.constant.Constant;

public class AgenciaNacionalTransitoDummyService {

	public static boolean isPicoPlacaExceptionByLicensePlateNumber(String number) {
		return Constant.LICENSE_PLATE_NUMBER_EXCEPTION.equalsIgnoreCase(number);
	}

}
