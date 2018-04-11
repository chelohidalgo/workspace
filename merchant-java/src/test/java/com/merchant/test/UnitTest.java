package com.merchant.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.merchant.CurrentLine;
import com.merchant.Dirt;
import com.merchant.File;
import com.merchant.Metal;
import com.merchant.Unit;

import junit.framework.TestCase;

public class UnitTest extends TestCase {

	File file;

	@Before
	public void setup() {
		file = new File();
	}

	@Test
	public void testCreateDirtUnitWithArabicValue() {
		Unit unit = new Dirt();
		unit.setValue("1");
		assertEquals(1.0, unit.getValue());
	}

	@Test
	public void testCreateDirtUnitWithNumeralRomanAsValue() {
		Unit unit = new Dirt();
		unit.setValue("I");
		assertEquals(1.0, unit.getValue());
	}

	@Test(expected = NumberFormatException.class)
	public void testCreateDirtUnitWithoutValue() {
		Unit unit = new Dirt();
		try {
			unit.setValue("");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void testCreateDirtUnitWithDirtUnitPreExist() throws Exception {
		List<Unit> units = new ArrayList<Unit>();
		units.add(Unit.createUnit(units, new CurrentLine("glob", "I")));
		CurrentLine currentLine = new CurrentLine("glob prok", "V");
		Unit unit = Unit.createUnit(units, currentLine);
		assertEquals(5.0, unit.getValue());
	}

	@Test
	public void testCreateDirtUnitWithDirtUnitsPreExist() throws Exception {
		List<Unit> units = new ArrayList<Unit>();
		units.add(Unit.createUnit(units, new CurrentLine("glob", "I")));
		units.add(Unit.createUnit(units, new CurrentLine("prok", "V")));
		CurrentLine currentLine = new CurrentLine("glob prok tegj", "16");
		Unit unit = Unit.createUnit(units, currentLine);
		assertEquals(4.0, unit.getValue());
	}

	@Test
	public void testCreateMetalUnitWithArabicValue() {
		List<Unit> units = new ArrayList<Unit>();
		CurrentLine currentLine = new CurrentLine("Silver", "13.5");
		Unit unit = Unit.createUnit(units, currentLine);
		assertEquals(13.5, unit.getValue());
	}

	@Test
	public void testCreateMetalUnitWithNumeralRomanAsValue() {
		Unit unit = new Metal();
		unit.setValue("V");
		assertEquals(5.0, unit.getValue());
	}

	@Test(expected = NumberFormatException.class)
	public void testCreateMetalUnitWithoutValue() {
		Unit unit = new Metal();
		try {
			unit.setValue("");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void testCreateMetalUnitWithDirtUnitPreExist() throws Exception {
		List<Unit> units = new ArrayList<Unit>();
		units.add(Unit.createUnit(units, new CurrentLine("glob", "I")));
		CurrentLine currentLine = new CurrentLine("glob glob SILVER", "20");
		Unit unit = Unit.createUnit(units, currentLine);
		assertEquals(10.0, unit.getValue());
	}

	@Test
	public void testCreateMetalUnitWithDirtUnitsPreExist() throws Exception {
		List<Unit> units = new ArrayList<Unit>();
		units.add(Unit.createUnit(units, new CurrentLine("glob", "I")));
		units.add(Unit.createUnit(units, new CurrentLine("prok", "V")));
		CurrentLine currentLine = new CurrentLine("glob prok SILVER", "20");
		Unit unit = Unit.createUnit(units, currentLine);
		assertEquals(5.0, unit.getValue());
	}

	@Test
	public void testGetUnitResultIncludedMetal() {
		List<Unit> units = new ArrayList<Unit>();
		units.add(Unit.createUnit(units, new CurrentLine("glob", "I")));
		units.add(Unit.createUnit(units, new CurrentLine("prok", "V")));
		units.add(Unit.createUnit(units, new CurrentLine("glob prok SILVER", "20")));
		CurrentLine currentLine = new CurrentLine("how many Credits is glob prok Silver", "glob prok Silver");
		Unit unit = Unit.createUnit(units, currentLine);
		assertEquals(20.0, unit.getValue());
	}

	@Test
	public void testGetUnitResultWithoutIncludedMetal() {
		List<Unit> units = new ArrayList<Unit>();
		units.add(Unit.createUnit(units, new CurrentLine("glob", "I")));
		units.add(Unit.createUnit(units, new CurrentLine("prok", "V")));
		units.add(Unit.createUnit(units, new CurrentLine("pish", "X")));
		units.add(Unit.createUnit(units, new CurrentLine("tegj", "L")));
		CurrentLine currentLine = new CurrentLine("how much is pish tegj glob glob", "pish tegj glob glob");
		Unit unit = Unit.createUnit(units, currentLine);
		assertEquals(42.0, unit.getValue());
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCreateUnitWithDefaultFile() throws Exception {
		file.getFile();
		List<Unit> units = new ArrayList<Unit>();
		Unit unit = Unit.createUnit(units, File.getCurrentLine());
		assertNotNull(unit);
	}

}
