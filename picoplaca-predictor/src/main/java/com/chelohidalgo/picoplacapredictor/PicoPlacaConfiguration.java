package com.chelohidalgo.picoplacapredictor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.chelohidalgo.picoplacapredictor.constant.Constant;
import com.chelohidalgo.picoplacapredictor.enumeration.PicoPlacaDayEnumeration;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaDayException;
import com.chelohidalgo.picoplacapredictor.exception.PicoPlacaPredictorException;
import com.chelohidalgo.picoplacapredictor.util.DateFormatUtil;

public class PicoPlacaConfiguration {

	private Map<PicoPlacaDayEnumeration, PicoPlacaDayConfiguration> picoPlacaDayConfigurations;
	private PicoPlacaTimeConfiguration dateTimeMorningConfiguration;
	private PicoPlacaTimeConfiguration dateTimeAfternoonConfiguration;

	public PicoPlacaConfiguration() throws PicoPlacaDayException {
		try {
			toConfigurePicoPlacaDays();
			toConfigurePicoPlacaTimes();
		} catch (Exception e) {
			throw new PicoPlacaDayException(e.getMessage());
		}
	}

	private void toConfigurePicoPlacaDays() {
		this.picoPlacaDayConfigurations = new HashMap<PicoPlacaDayEnumeration, PicoPlacaDayConfiguration>();
		picoPlacaDayConfigurations.put(PicoPlacaDayEnumeration.MONDAY,
				new PicoPlacaDayConfiguration(PicoPlacaDayEnumeration.MONDAY));
		picoPlacaDayConfigurations.put(PicoPlacaDayEnumeration.TUESDAY,
				new PicoPlacaDayConfiguration(PicoPlacaDayEnumeration.TUESDAY));
		picoPlacaDayConfigurations.put(PicoPlacaDayEnumeration.WEDNESDAY,
				new PicoPlacaDayConfiguration(PicoPlacaDayEnumeration.WEDNESDAY));
		picoPlacaDayConfigurations.put(PicoPlacaDayEnumeration.THURSDAY,
				new PicoPlacaDayConfiguration(PicoPlacaDayEnumeration.THURSDAY));
		picoPlacaDayConfigurations.put(PicoPlacaDayEnumeration.FRIDAY,
				new PicoPlacaDayConfiguration(PicoPlacaDayEnumeration.FRIDAY));
	}

	private void toConfigurePicoPlacaTimes() throws PicoPlacaPredictorException {
		Date initialMorningTime = getTime(Constant.INICIAL_MORNING_TIME);
		Date finalMorningTime = getTime(Constant.FINAL_MORNING_TIME);
		Date initialAfternoonTime = getTime(Constant.INICIAL_AFTERNOON_TIME);
		Date finalAfternoonTime = getTime(Constant.FINAL_AFTERNOON_TIME);
		this.dateTimeMorningConfiguration = new PicoPlacaTimeConfiguration(initialMorningTime, finalMorningTime);
		this.dateTimeAfternoonConfiguration = new PicoPlacaTimeConfiguration(initialAfternoonTime, finalAfternoonTime);
	}

	private Date getTime(String dateString) throws PicoPlacaPredictorException {
		return DateFormatUtil.convertStringHourToDate(dateString);
	}

	public Map<PicoPlacaDayEnumeration, PicoPlacaDayConfiguration> getPicoPlacaDayConfigurations() {
		return picoPlacaDayConfigurations;
	}

	public void setPicoPlacaDayConfigurations(
			Map<PicoPlacaDayEnumeration, PicoPlacaDayConfiguration> picoPlacaDayConfigurations) {
		this.picoPlacaDayConfigurations = picoPlacaDayConfigurations;
	}

	public PicoPlacaTimeConfiguration getDateTimeMorningConfiguration() {
		return dateTimeMorningConfiguration;
	}

	public void setDateTimeMorningConfiguration(PicoPlacaTimeConfiguration dateTimeMorningConfiguration) {
		this.dateTimeMorningConfiguration = dateTimeMorningConfiguration;
	}

	public PicoPlacaTimeConfiguration getDateTimeAfternoonConfiguration() {
		return dateTimeAfternoonConfiguration;
	}

	public void setDateTimeAfternoonConfiguration(PicoPlacaTimeConfiguration dateTimeAfternoonConfiguration) {
		this.dateTimeAfternoonConfiguration = dateTimeAfternoonConfiguration;
	}

	public PicoPlacaDayConfiguration getPicoPlacaDayConfiguration(PicoPlacaDayEnumeration picoPlacaDayEnumeration){
		return picoPlacaDayConfigurations.get(picoPlacaDayEnumeration);
	}
}
