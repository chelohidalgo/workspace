package com.chelohidalgo.picoplacapredictor;

import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;
import com.chelohidalgo.picoplacapredictor.service.AgenciaNacionalTransitoDummyService;

public class Car extends TypeCar {

	private LicensePlateNumber licensePlateNumber;

	public Car(String licencePlateNumber) {
		this.licensePlateNumber = new LicensePlateNumber(licencePlateNumber);
	}

	public LicensePlateNumber getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(LicensePlateNumber licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	@Override
	public boolean isGovermentCarOrTaxi() throws PicoPlacaPredictorException {
		try {
			if(licensePlateNumber.isValidLicensePlateNumber()){
				return AgenciaNacionalTransitoDummyService.isPicoPlacaExceptionByLicensePlateNumber(licensePlateNumber.getNumber());
			}
		} catch (Exception e) {
			throw new PicoPlacaPredictorException();
		}
		return false;
	}
}
