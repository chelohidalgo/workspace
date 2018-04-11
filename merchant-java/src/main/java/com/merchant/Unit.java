package com.merchant;

import java.util.List;

import com.merchant.enumerations.util.MetalEnumUtil;
import com.merchant.util.Constants;
import com.merchant.util.CurrentLineUtil;
import com.merchant.util.NumberUtil;
import com.merchant.util.NumeralRomanConverter;
import com.merchant.util.UnitUtil;

public abstract class Unit {

	private String name;
	protected Double value;
	private Double preValue = new Double(Constants.VALUE_ZERO);

	public static Unit createUnit(List<Unit> units, CurrentLine currentLine) {
		if (currentLine.currentLineisConvertion()) {
			Unit unit = new UnitResult();
			unit.setPreValue(units, currentLine);
			return unit;
		} else {
			Unit unit = MetalEnumUtil.isMetalUnit(currentLine) ? new Metal() : new Dirt();
			unit.setValue(currentLine.getValue());
			unit.setPreValue(units, currentLine);
			return unit;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract Double getValue();

	public void setValue(String value) {
		this.value = NumberUtil.isNumber(value) ? Double.valueOf(value)	: convertNumeralRomanToArabic(value).doubleValue();
	}

	protected Integer convertNumeralRomanToArabic(String value) {
		return new NumeralRomanConverter().getArabic(value);
	}

	public Double getPreValue() {
		return preValue;
	}

	public void setPreValue(Double preValue) {
		this.preValue = preValue;
	}

	public abstract void setPreValue(List<Unit> units, CurrentLine currentLine);
	
	protected void setName(CurrentLine currentLine) {
		setName(CurrentLineUtil.getLastName(currentLine));
	}
	
	protected boolean isPreNamesLenghMoreThanOne(CurrentLine currentLine) {
		return CurrentLineUtil.getPreNames(currentLine).length > Constants.VALUE_ONE;
	}
	
	protected double getPreValue(List<Unit> units, CurrentLine currentLine) {
		return Integer.valueOf(toConvertPreValueToNumber(units, currentLine)).doubleValue();
	}

	protected int toConvertPreValueToNumber(List<Unit> units, CurrentLine currentLine) {
		return new NumeralRomanConverter().getArabic(UnitUtil.getValueOfPreNames(units, CurrentLineUtil.getPreNames(currentLine)));
	}

	@Override
	public String toString() {
		return "Unit [name=" + name + ", value=" + getValue() + "]";
	}

}