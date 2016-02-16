package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.DegenerateComparativeMovingAverageIndicator;

public class DegenerateComparativeMovingAverageIndicatorUnitTest {
	
	
	@Test
	public void shouldHaveCorrectString() throws Exception {
		ComparativeMovingAverageIndicator cmai = new DegenerateComparativeMovingAverageIndicator();
		String expectedString = "N/A";
		String actualString = cmai.getIndicatorString();
		Font font = new NeutralFont();
		assertEquals(expectedString, actualString);
		assertEquals(font.getClass(), cmai.getFont().getClass());
	}
}
