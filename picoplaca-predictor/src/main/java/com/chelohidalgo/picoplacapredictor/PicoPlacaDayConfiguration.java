package com.chelohidalgo.picoplacapredictor;

import java.util.List;

import com.chelohidalgo.picoplacapredictor.enumeration.PicoPlacaDayEnumeration;

public class PicoPlacaDayConfiguration {

	private DayConfiguration dayConfiguration;

	public PicoPlacaDayConfiguration(PicoPlacaDayEnumeration picoPlacaDayEnumeration) {
		super();
		setDayConfiguration(picoPlacaDayEnumeration);
	}

	public DayConfiguration getDayConfiguration() {
		return dayConfiguration;
	}

	public void setDayConfiguration(PicoPlacaDayEnumeration picoPlacaDayEnumeration) {
		switch (picoPlacaDayEnumeration) {
		case MONDAY:
			this.dayConfiguration = new MondayConfiguration();
			break;
		case TUESDAY:
			this.dayConfiguration = new TuesdayConfiguration();
			break;
		case WEDNESDAY:
			this.dayConfiguration = new WednesdayConfiguration();
			break;
		case THURSDAY:
			this.dayConfiguration = new ThursdayConfiguration();
			break;
		case FRIDAY:
			this.dayConfiguration = new FridayConfiguration();
			break;
		}
	}

	public List<Integer> getForbiddenNumbersByDay() {
		return dayConfiguration.getForbiddenNumbers();
	}

}
