package com.lis.investmentdataclient.document.customrows;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;

public class PerformanceTableHeaderRowUnitTest {
	
	private void testCorrectStringContentInCell(String expectedString, int cellIndex) {
		PdfTableRow row = new PerformanceTableHeaderRow();
		assertEquals(expectedString, row.getCells()[cellIndex].getCellText());
	}
	
	private void shouldHaveCorrectBackgroundColor(PdfTableCell cell) {
		BackgroundColor color = cell.getBackgroundColor();
		assertEquals(150, color.getRedChannel());
		assertEquals(150, color.getGreenChannel());
		assertEquals(150, color.getBlueChannel());
	}
	
	@Test
	public void shouldHaveCorrectHeaderNames() throws Exception {
		testCorrectStringContentInCell("Symbol", 0);
		testCorrectStringContentInCell("One Week Return", 1);
		testCorrectStringContentInCell("One Month Return", 2);
		testCorrectStringContentInCell("Three Month Return", 3);
		testCorrectStringContentInCell("YTD Return", 4);
		testCorrectStringContentInCell("One Year Return", 5);
		testCorrectStringContentInCell("Three Year Return", 6);
		testCorrectStringContentInCell("Five Year Return", 7);
		testCorrectStringContentInCell("Ten Year Return", 8);
		testCorrectStringContentInCell("10SMA > 20EMA", 9);
		testCorrectStringContentInCell("20EMA > 30EMA", 10);
		testCorrectStringContentInCell("30EMA > 50EMA", 11);
		testCorrectStringContentInCell("50EMA > 200EMA", 12);
	}
	
	@Test
	public void shouldHaveCorrectBackgroundColor() throws Exception {
		PdfTableRow row = new PerformanceTableHeaderRow();
		for(PdfTableCell cell : row.getCells())
			shouldHaveCorrectBackgroundColor(cell);
	}

	
}
