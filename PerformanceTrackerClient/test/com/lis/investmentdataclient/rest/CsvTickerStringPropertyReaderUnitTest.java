package com.lis.investmentdataclient.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CsvTickerStringPropertyReaderUnitTest {
	
	CsvTickerStringPropertyReader reader;
	
	
	@Before
	public void setUp() throws Exception {
		reader = new CsvTickerStringPropertyReader("Market Achievers");
	}
	
	
	@Test
	public void shouldReturnCorrectSymbolPropertyGivenIndex() throws Exception {
		String expectedString = "RSP";
		String actualString = reader.getSymbolPropertyAtIndex(0);
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectTypePropertyGivenIndex() throws Exception {
		String expectedString = "com.jhm.investmentdata.model.Etf";
		String actualString = reader.getTypePropertyAtIndex(1);
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldHaveCorrectNumberOfTickers() throws Exception {
		int expectedNumber = 4;
		int actualNumber = reader.getNumberOfTickers();
		assertEquals(expectedNumber, actualNumber);
	}
}
