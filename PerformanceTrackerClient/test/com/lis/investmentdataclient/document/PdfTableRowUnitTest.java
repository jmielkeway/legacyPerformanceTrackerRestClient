package com.lis.investmentdataclient.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.testbuilder.TestTickerFactory;

public class PdfTableRowUnitTest {
	
	PdfTableRow row;
	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TestTickerFactory.getStubbedTicker();
		Trackable trackable = new TechnicalTicker(restTicker);
		row = new PerformanceAssessmentTableRow(trackable);
	}
	
	
	@Test
	public void shouldHaveOneRowPerStandardIndicatorPlusSymbol() throws Exception {
		int indicators = 12;
		int expectedInt = indicators + 1;
		int actualInt = row.getCells().length;
		assertEquals(expectedInt, actualInt);
	}
	
	
	@Test
	public void shouldHaveCorrectCellOrder() throws Exception {
		PdfTableCell [] cells = row.getCells();
		assertEquals("STUB", cells[0].getCellText());
		assertEquals("0.00%", cells[1].getCellText());
		assertEquals("8.37%", cells[6].getCellText());
		assertEquals("Yes", cells[9].getCellText());
	}
}
