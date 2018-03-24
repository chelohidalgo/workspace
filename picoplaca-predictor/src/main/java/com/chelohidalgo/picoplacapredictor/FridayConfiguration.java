package com.chelohidalgo.picoplacapredictor;

import java.util.ArrayList;
import java.util.List;

public class FridayConfiguration extends DayConfiguration {

	@Override
	public List<Integer> getForbiddenNumbers() {
		List<Integer> forbiddenNumbers = new ArrayList<Integer>();
		forbiddenNumbers.add(9);
		forbiddenNumbers.add(0);
		return forbiddenNumbers;
	}

}
