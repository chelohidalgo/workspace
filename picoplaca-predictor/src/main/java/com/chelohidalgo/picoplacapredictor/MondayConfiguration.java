package com.chelohidalgo.picoplacapredictor;

import java.util.ArrayList;
import java.util.List;

public class MondayConfiguration extends DayConfiguration {

	@Override
	public List<Integer> getForbiddenNumbers() {
		List<Integer> forbiddenNumbers = new ArrayList<Integer>();
		forbiddenNumbers.add(1);
		forbiddenNumbers.add(2);
		return forbiddenNumbers;
	}

}
