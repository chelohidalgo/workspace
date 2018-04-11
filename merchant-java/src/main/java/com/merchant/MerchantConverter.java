package com.merchant;

import java.util.ArrayList;
import java.util.List;

public class MerchantConverter {
	
	public static void main(String[] args) {
		List<Unit> units = new ArrayList<Unit>();
		try {
			File.getFile();
			CurrentLine currentLine;
			while ((currentLine = File.getCurrentLine()) != null) {
				units.add(getUnit(units, currentLine));
			}
			printResults(units);
			File.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printResults(List<Unit> units) {
		System.out.println("****** RESULTS ******");
		for (Unit unit : units) {
			if(unit instanceof UnitResult)
				System.out.println(unit.toString());
		}
	}
	
	private static Unit getUnit(List<Unit> units, CurrentLine currentLine) {
		return Unit.createUnit(units, currentLine);
	}
	
}
