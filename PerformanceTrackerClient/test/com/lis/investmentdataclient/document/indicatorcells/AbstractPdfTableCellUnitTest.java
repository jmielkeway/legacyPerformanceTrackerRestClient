package com.lis.investmentdataclient.document.indicatorcells;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.testbuilder.TestTickerFactory;


public abstract class AbstractPdfTableCellUnitTest {
	
	PdfTableCell tableCell;
	
	protected abstract PdfTableCell getTableCell();
	
	protected abstract String getExpectedCellString();
	
	protected abstract Font getExpectedCellFont();
	
	private PdfTableCell getCellBuiltForTest() {
		Ticker ticker = TestTickerFactory.getStubbedTicker();
		Trackable trackable = new TechnicalTicker(ticker);
		PdfTableCell cell = getTableCell();
		cell.setTrackable(trackable);
		return cell;
	}

	
	
	@Test
	public void shouldHaveCorrectCellString() throws Exception {
		String expectedString = getExpectedCellString();
		String actualString = getCellBuiltForTest().getCellText();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldHaveCorrectCellFont() throws Exception {
		Font expectedFont = getExpectedCellFont();
		Font actualFont = getCellBuiltForTest().getCellFont();
		assertEquals(expectedFont, actualFont);
	}
}
