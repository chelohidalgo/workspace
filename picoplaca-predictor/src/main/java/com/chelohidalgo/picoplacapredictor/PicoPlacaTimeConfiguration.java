package com.chelohidalgo.picoplacapredictor;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PicoPlacaTimeConfiguration {

	private Date initialTime;
	private Date finalTime;

	public PicoPlacaTimeConfiguration(Date initialTime, Date finalTime) {
		this.initialTime = initialTime;
		this.finalTime = finalTime;
	}

	public Date getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(Date initialTime) {
		this.initialTime = initialTime;
	}

	public Date getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(Date finalTime) {
		this.finalTime = finalTime;
	}
	
	public boolean dateBetweenDates(Date date) {
		Calendar calendar = Calendar.getInstance(Locale.US);
		calendar.setTime(date);
		return calendar.after(getTimeCalendar(initialTime)) && calendar.before(getTimeCalendar(finalTime));
	}

	private Calendar getTimeCalendar(Date date) {
		Calendar calendar = Calendar.getInstance(Locale.US);
		calendar.setTime(date);
		return calendar;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
