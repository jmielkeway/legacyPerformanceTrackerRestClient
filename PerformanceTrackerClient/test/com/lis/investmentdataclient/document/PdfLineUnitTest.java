package com.lis.investmentdataclient.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PdfLineUnitTest {
	
	PdfLine line;
	
	@Before
	public void setUp() throws Exception {
		line = new PdfLine(80);
	}
	
	
	@Test
	public void shouldHaveCorrectSpacingAfter() throws Exception {
		assertEquals(16.5, line.getTrailingSpacing(), 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectHorizonatalWidthPercentage() throws Exception {
		assertEquals(80, line.getWidthPercentage());
	}

}
