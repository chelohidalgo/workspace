package com.chelohidalgo.picoplacapredictor;

import java.util.ArrayList;
import java.util.List;

public class TuesdayConfiguration extends DayConfiguration {

	@Override
	public List<Integer> getForbiddenNumbers() {
		List<Integer> forbiddenNumbers = new ArrayList<Integer>();
		forbiddenNumbers.add(3);
		forbiddenNumbers.add(4);
		return forbiddenNumbers;
	}

}
