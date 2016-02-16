package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.SimpleNormalizedMovingAverage;

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
