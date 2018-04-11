package com.chelohidalgo.picoplacapredictor;

import java.util.ArrayList;
import java.util.List;

public class ThursdayConfiguration extends DayConfiguration {

	@Override
	public List<Integer> getForbiddenNumbers() {
		List<Integer> forbiddenNumbers = new ArrayList<Integer>();
		forbiddenNumbers.add(7);
		forbiddenNumbers.add(8);
		return forbiddenNumbers;
	}

}
