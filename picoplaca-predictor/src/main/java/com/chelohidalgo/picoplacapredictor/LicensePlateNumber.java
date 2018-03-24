package com.chelohidalgo.picoplacapredictor;

import com.chelohidalgo.picoplacapredictor.constant.Constant;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;

public class LicensePlateNumber {

	private String number;

	public LicensePlateNumber(String number) {
		this.number = number;
	}

	public boolean isValidLicensePlateNumber() throws PicoPlacaPredictorException {
		try {
			if (toValidPatternLicensePlateNumber()) {
				return true;
			}
		} catch (Exception e) {
			throw new PicoPlacaPredictorException(e.getMessage());
		}
		return false;
	}

	private boolean toValidPatternLicensePlateNumber() throws PicoPlacaPredictorException {
		if (isNumberEmpty(number)) {
			throw new PicoPlacaPredictorException("Invalid license number, must not be null");
		}

		if (isPrefixLicensePlateNumberInvalid() || isSufixLicensePlateNumberInvalid()) {
			throw new PicoPlacaPredictorException(
					"Invalid pattern license number, must be " + Constant.LICENSE_PLATE_NUMBER_PATTERN);
		}
		return true;
	}

	private boolean isSufixLicensePlateNumberInvalid() {
		return Constant.SUFIX_LICENSE_PLATE_NUMBER_LENGTH != getSufixLicensePlateNumber().length();
	}

	private String getPrefixLicensePlateNumber() {
		return number.split(Constant.SEPARATOR_LICENSE_PLATE_NUMBER)[0];
	}

	private boolean isPrefixLicensePlateNumberInvalid() {
		return Constant.PREFIX_LICENSE_PLATE_NUMBER_LENGTH != getPrefixLicensePlateNumber().length();
	}

	private String getSufixLicensePlateNumber() {
		return number.split(Constant.SEPARATOR_LICENSE_PLATE_NUMBER)[1];
	}

	private boolean isNumberEmpty(String number) {
		return number == null || number.isEmpty();
	}

	public int getLastDigit(){
		return Integer.valueOf(number.substring(number.length() - Constant.ONE_INT_VALUE));
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
