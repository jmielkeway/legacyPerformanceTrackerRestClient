package com.lis.investmentdataclient.document.customrows;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.document.customrows.PerformanceAssessmentTableRow;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.testbuilder.TestTickerFactory;

public class PerformanceAssessmentTableRowUnitTest {
	
	PdfTableRow row;
	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TestTickerFactory.getStubbedTicker();
		Trackable trackable = new TechnicalTicker(restTicker);
		row = new PerformanceAssessmentTableRow(trackable, new Color(100,120,140));
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
	
	@Test
	public void shouldHaveCorrectBackgroundColor() throws Exception {
		for(PdfTableCell cell : row.getCells())
			shouldHaveCorrectRgbBgColor(cell);
	}


	private void shouldHaveCorrectRgbBgColor(PdfTableCell cell) {
		BackgroundColor color = cell.getBackgroundColor();
		assertEquals(100, color.getRedChannel());
		assertEquals(120, color.getGreenChannel());
		assertEquals(140, color.getBlueChannel());
	}
}
