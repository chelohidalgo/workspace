package com.merchant;

import java.util.List;

import com.merchant.enumerations.util.MetalEnumUtil;
import com.merchant.util.Constants;
import com.merchant.util.CurrentLineUtil;
import com.merchant.util.UnitUtil;

public class UnitResult extends Unit {
	
	private String valueString;

	@Override
	public Double getValue() {
		return getPreValue();
	}

	@Override
	public void setPreValue(List<Unit> units, CurrentLine currentLine) {
		setName(currentLine.getValue());
		if (isPreNamesLenghMoreThanOne(currentLine)) {
			if (isInvalidCurrentLine(units, currentLine)) {
				setValueString("I have no idea what you are talking about");
				return;
			}
			setPreValue(getPreValue(units, currentLine));
			if (MetalEnumUtil.isMetalUnit(currentLine))
				setPreValue(getPreValue() * getMetalUnitValue(units, currentLine));
		}
	}

	private Double getMetalUnitValue(List<Unit> units, CurrentLine currentLine) {
		return UnitUtil.getUnitValueByName(units, CurrentLineUtil.getLastName(currentLine));
	}
	
	private boolean isInvalidCurrentLine(List<Unit> units, CurrentLine currentLine) {
		for (String name : CurrentLineUtil.getPreNames(currentLine)) {
			if (UnitUtil.noExistUnitsByName(units, name)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		if(getValueString() == null) {
			return getName() + Constants.CHAR_EMPTY + Constants.IS_SEPARATOR + Constants.CHAR_EMPTY + getValue();
		} else {
			return getValueString();
		}
	}

	public String getValueString() {
		return valueString;
	}

	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
	
	

}