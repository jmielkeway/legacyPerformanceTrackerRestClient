package com.lis.investmentdataclient.technicalanalysis;

import org.junit.Test;

public class DegenerateMovingAverageUnitTest extends AbstractMovingAverageUnitTest{

	@Override
	protected NormalizedMovingAverage getMovingAverageInstance() {
		int period = 200;
		return new DegenerateMovingAverage(period);
	}

	@Override
	protected int getExpectedMovingAveragePeriod() {
		return 200;
	}

	@Override
	protected double getExpectedMovingAverageValue() {
		return 0;
	}
	
	
	@Override
	@Test(expected = IllegalArgumentException.class)
	public void shouldHaveCorrectMovingAverageValue() throws Exception {
		super.shouldHaveCorrectMovingAverageValue();
	}

}
