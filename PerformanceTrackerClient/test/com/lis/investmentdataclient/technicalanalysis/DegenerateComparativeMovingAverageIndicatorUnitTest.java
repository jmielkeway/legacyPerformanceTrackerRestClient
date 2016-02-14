package com.lis.investmentdataclient.technicalanalysis;

import static org.junit.Assert.*;

import org.junit.Test;

public class DegenerateComparativeMovingAverageIndicatorUnitTest {
	
	
	@Test
	public void shouldHaveCorrectString() throws Exception {
		ComparativeMovingAverageIndicator cmai = new DegenerateComparativeMovingAverageIndicator();
		String expectedString = "N/A";
		String actualString = cmai.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
}
