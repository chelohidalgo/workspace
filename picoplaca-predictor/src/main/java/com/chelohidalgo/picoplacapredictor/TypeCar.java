package com.chelohidalgo.picoplacapredictor;

import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;

public class TypeCar {

	private boolean isGovermentCarOrTaxi;

	public boolean isGovermentCarOrTaxi() throws PicoPlacaPredictorException {
		return isGovermentCarOrTaxi;
	}

	public void setGovermentCarOrTaxi(boolean isGovermentCarOrTaxi) {
		this.isGovermentCarOrTaxi = isGovermentCarOrTaxi;
	}

}
