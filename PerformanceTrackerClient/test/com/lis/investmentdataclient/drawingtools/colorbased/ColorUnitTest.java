package com.lis.investmentdataclient.drawingtools.colorbased;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lis.investmentdataclient.drawingtools.colorbased.Color;

public class ColorUnitTest {
	
	@Test
	public void shouldHaveCorrectRedGreenBlueDefaultAlphaValues() throws Exception {
		Color color = new Color(255,166,172);
		assertEquals(255, color.getRed());
		assertEquals(166, color.getGreen());
		assertEquals(172, color.getBlue());
		assertEquals(100, color.getAlpha());
	}
	
	
	@Test
	public void shouldHaveCorrectRedGreenBlueAlphaValues() throws Exception {
		Color color = new Color(12,16,35,52);
		assertEquals(12, color.getRed());
		assertEquals(16, color.getGreen());
		assertEquals(35, color.getBlue());
		assertEquals(52, color.getAlpha());
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldBeIllegalBecauseRgbTooHigh() throws Exception {
		Color color = new Color(256, 16, 0);
		assertEquals(256, color.getRed());
	}

}
