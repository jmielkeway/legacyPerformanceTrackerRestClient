package com.lis.investmentdataclient.technicalanalysis;

public class SimpleNormalizedMovingAverageUnitTest
		extends AbstractMovingAverageUnitTest {
	
	int period = 30;
	double value = 1.25;

	@Override
	protected NormalizedMovingAverage getMovingAverageInstance() {
		return new SimpleNormalizedMovingAverage(period, value);
	}

	@Override
	protected int getExpectedMovingAveragePeriod() {
		return period;
	}

	@Override
	protected double getExpectedMovingAverageValue() {
		return value;
	}

}
