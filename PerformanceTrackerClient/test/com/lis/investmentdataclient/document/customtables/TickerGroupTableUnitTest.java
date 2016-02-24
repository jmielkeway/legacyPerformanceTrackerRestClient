package com.lis.investmentdataclient.document.customtables;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lis.investmentdataclient.document.PdfTable;
import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;
import com.lis.investmentdataclient.model.TickerGroup;
import com.lis.investmentdataclient.model.TickerGroupWithAverageFactory;

public class TickerGroupTableUnitTest {
	
	PdfTable table;
	
	@Before
	public void setUp() throws Exception {
		TickerGroup group = new TickerGroupWithAverageFactory().getInstance("Market Achievers");
		Color color = new Color(153, 25,74);
		table = new TickerGroupTable(group, color);
	}
	
	
	private void shouldHaveCorrectFirstColumnText(String expectedString, int index) {
		PdfTableRow row = table.getRows()[index];
		assertEquals(expectedString, row.getCells()[0].getCellText());
	}
	
	
	private void rowsShouldHaveCorrectColors(int expRed, int expGreen, int expBlue, int index) {
		BackgroundColor color = table.getRows()[index].getCells()[0].getBackgroundColor();
		assertEquals(expRed, color.getRedChannel());
		assertEquals(expGreen, color.getGreenChannel());
		assertEquals(expBlue, color.getBlueChannel());
	}
	
	
	@Test
	public void shouldHaveCorrectNumberOfRows() throws Exception {
		assertEquals(7, table.getRows().length);
	}
	
	
	@Test
	public void eachRowShouldHaveCorrectFirstColumnText() throws Exception {
		shouldHaveCorrectFirstColumnText("Market Achievers Performance Table", 0);
		shouldHaveCorrectFirstColumnText("Symbol", 1);
		shouldHaveCorrectFirstColumnText("RSP", 2);
		shouldHaveCorrectFirstColumnText("FTA", 3);
		shouldHaveCorrectFirstColumnText("CPEAX", 4);
		shouldHaveCorrectFirstColumnText("SGOVX", 5);
		shouldHaveCorrectFirstColumnText("Group Average", 6);
	}
	
	
	@Test
	public void tableShouldHaveCorrectColumnLengthAndFirstRowShouldSpanEntireLength() throws Exception {
		assertEquals(13, table.getRows()[0].getCells()[0].getColumnWidth());
	}
	
	
	@Test
	public void rowsShouldHaveCorrectColors() throws Exception {
		rowsShouldHaveCorrectColors(153, 25, 74, 0);
		rowsShouldHaveCorrectColors(150, 150, 150, 1);
		rowsShouldHaveCorrectColors(255, 255, 255, 2);
		rowsShouldHaveCorrectColors(150, 150, 150, 3);
		rowsShouldHaveCorrectColors(255, 255, 255, 4);
		rowsShouldHaveCorrectColors(150, 150, 150, 5);
	}
	
	
	@Test
	public void shouldHaveCorrectColumnWidths() throws Exception {
		double [] widths = table.getColumnWidths();
		assertEquals(1.0/13, widths[0], 0.0001);
		assertEquals(13, widths.length);
	}
}
