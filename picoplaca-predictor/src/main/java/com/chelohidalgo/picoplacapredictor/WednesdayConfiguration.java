package com.chelohidalgo.picoplacapredictor;

import java.util.ArrayList;
import java.util.List;

public class WednesdayConfiguration extends DayConfiguration {

	@Override
	public List<Integer> getForbiddenNumbers() {
		List<Integer> forbiddenNumbers = new ArrayList<Integer>();
		forbiddenNumbers.add(5);
		forbiddenNumbers.add(6);
		return forbiddenNumbers;
	}

}
