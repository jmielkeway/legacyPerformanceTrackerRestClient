package com.lis.investmentdataclient.technicalanalysis;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class AbstractMovingAverageUnitTest {
	
	protected abstract NormalizedMovingAverage getMovingAverageInstance();
	
	protected abstract int getExpectedMovingAveragePeriod();
	
	protected abstract double getExpectedMovingAverageValue();
	
	@Test
	public void shouldHaveCorrectMovingAveragePeriod() throws Exception {
		int expectedMovingAveragePeriod = getExpectedMovingAveragePeriod();
		int actualMovingAveragePeriod = getMovingAverageInstance().getMovingAveragePeriod();
		assertEquals(expectedMovingAveragePeriod, actualMovingAveragePeriod);
	}
	
	
	@Test
	public void shouldHaveCorrectMovingAverageValue() throws Exception {
		double expectedValue = getExpectedMovingAverageValue();
		double actualValue = getMovingAverageInstance().getNormalizedMovingAverageValue();
		assertEquals(expectedValue, actualValue, 0.00001);
	}

}
