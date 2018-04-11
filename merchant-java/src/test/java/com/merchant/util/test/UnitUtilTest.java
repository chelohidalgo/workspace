package com.merchant.util.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.merchant.CurrentLine;
import com.merchant.Dirt;
import com.merchant.Metal;
import com.merchant.Unit;
import com.merchant.util.CurrentLineUtil;
import com.merchant.util.UnitUtil;

import junit.framework.TestCase;

public class UnitUtilTest extends TestCase{
	
	@Test
	public void testExistUnitByName() {
		List<Unit> units = new ArrayList<Unit>();
		Unit unit = new Metal();
		unit.setName("Silver"); 
		units.add(unit);
		assertTrue(UnitUtil.existUnitByName(units, "Silver"));
	}
	
	@Test
	public void testGetUnitValueByName() {
		List<Unit> units = new ArrayList<Unit>();
		Unit unit = new Metal();
		unit.setName("Silver");
		unit.setValue("3");
		units.add(unit);
		assertEquals(3.0, UnitUtil.getUnitValueByName(units, "Silver"));
	}
	
	@Test
	public void testGetValueOfPreNames() {
		List<Unit> units = new ArrayList<Unit>();
		units.add(Unit.createUnit(units, new CurrentLine("glob", "I")));
		units.add(Unit.createUnit(units, new CurrentLine("prok", "V")));
		units.add(Unit.createUnit(units, new CurrentLine("pish", "X")));
		units.add(Unit.createUnit(units, new CurrentLine("tegj", "L")));
		CurrentLine currentLine = new CurrentLine("how much is pish tegj glob glob", "pish tegj glob glob");
		assertEquals("XLII", UnitUtil.getValueOfPreNames(units, CurrentLineUtil.getPreNames(currentLine)));
	}
	
	@Test
	public void testNoExistUnitByName() {
		List<Unit> units = new ArrayList<Unit>();
		Unit unit = new Metal();
		unit.setName("Iron"); 
		units.add(unit);
		assertFalse(UnitUtil.existUnitByName(units, "Silver"));
	}
	
	@Test
	public void testGetUnitValueByNameNoExist() {
		List<Unit> units = new ArrayList<Unit>();
		Unit metal = new Metal();
		metal.setName("Silver");
		metal.setValue("3");
		units.add(metal);
		Unit dirt = new Dirt();
		dirt.setName("Glob");
		dirt.setValue("1");
		units.add(dirt);
		assertNull(UnitUtil.getUnitValueByName(units, "Iron"));
	}
	
	@Test
	public void testNotExistUnitResultByName() {
		List<Unit> units = new ArrayList<Unit>();
		CurrentLine currentLine = new CurrentLine("how much wood could a woodchuck chuck if a woodchuck could chuck wood", "wood could a woodchuck chuck if a woodchuck could chuck wood");
		Unit unitResult = Unit.createUnit(units, currentLine);
		assertEquals("I have no idea what you are talking about", unitResult.toString());
	}
	
}
