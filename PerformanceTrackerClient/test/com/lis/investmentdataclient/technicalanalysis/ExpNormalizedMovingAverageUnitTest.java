package com.lis.investmentdataclient.technicalanalysis;

public class ExpNormalizedMovingAverageUnitTest
		extends AbstractMovingAverageUnitTest {

	int period = 50;
	double value = 0.9566;
	
	@Override
	protected NormalizedMovingAverage getMovingAverageInstance() {
		return new ExpNormalizedMovingAverage(period, value);
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
