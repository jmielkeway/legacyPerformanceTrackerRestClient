package com.lis.investmentdataclient.document.customcells;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;


public abstract class AbstractPdfTableCellUnitTest {
	
	PdfTableCell tableCell;
	
	protected abstract PdfTableCell getTableCell();
	
	protected abstract String getExpectedCellString();
	
	protected abstract Font getExpectedCellFont();
	
	protected abstract int getExpectedColumnCount();
	
	
	@Test
	public void shouldHaveCorrectCellString() throws Exception {
		String expectedString = getExpectedCellString();
		String actualString = getTableCell().getCellText();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldHaveCorrectCellFont() throws Exception {
		Font expectedFont = getExpectedCellFont();
		Font actualFont = getTableCell().getCellFont();
		assertEquals(expectedFont, actualFont);
	}
	
	
	@Test
	public void shouldHaveCorrectColumnCount() throws Exception {
		int expectedColumnCount = getExpectedColumnCount();
		int actualColumnCount = getTableCell().getColumnWidth();
		assertEquals(expectedColumnCount, actualColumnCount);
	}
}
