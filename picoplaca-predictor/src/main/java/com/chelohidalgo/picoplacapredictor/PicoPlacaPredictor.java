package com.chelohidalgo.picoplacapredictor;

import java.util.Date;

import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;
import com.chelohidalgo.picoplacapredictor.util.DateFormatUtil;

public class PicoPlacaPredictor {

	private String date;
	private String time;
	private String licencePlateNumber;

	public PicoPlacaPredictor(String licencePlateNumber, String dateInString, String time) throws PicoPlacaPredictorException{
		this.licencePlateNumber = licencePlateNumber;
		this.date = dateInString;
		this.time = time;
	}

	public String carCanBeOnRoad() throws PicoPlacaPredictorException {
		try {
			Car car = new Car(this.licencePlateNumber);
			PicoPlacaSchedule picoPlacaSchedule = new PicoPlacaSchedule(car);
			if(picoPlacaSchedule.isPicoPlaca(getDate(date), getTime(time))){
				return "No, you can not road";
			} else {
				return "Yes, you can road";
			}
		} catch (Exception e) {
			throw new PicoPlacaPredictorException(e.getMessage());
		}
	}
	
	private Date getDate(String date) throws PicoPlacaPredictorException {
		return DateFormatUtil.convertStringDateToDate(date);
	}
	
	private Date getTime(String time) throws PicoPlacaPredictorException {
		return DateFormatUtil.convertStringHourToDate(time);
	}

}
