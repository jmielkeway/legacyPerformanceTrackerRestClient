package com.lis.investmentdataclient.document.customrows;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.document.customrows.TitleTableRow;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;

public class TitleTableRowUnitTest {

	PdfTableRow row;
	
	@Before
	public void setUp() throws Exception {
		row = new TitleTableRow("Market Achievers", new Color(100,120,150), 13);
	}
	
	@Test
	public void shouldOnlyContainOneCell() throws Exception {
		assertEquals(1, row.getCells().length);
	}
	
	@Test
	public void shouldHaveCorrectBackgroundColor() throws Exception {
		BackgroundColor color = row.getCells()[0].getBackgroundColor();
		assertEquals(100, color.getRedChannel());
		assertEquals(120, color.getGreenChannel());
		assertEquals(150, color.getBlueChannel());
	}
}
