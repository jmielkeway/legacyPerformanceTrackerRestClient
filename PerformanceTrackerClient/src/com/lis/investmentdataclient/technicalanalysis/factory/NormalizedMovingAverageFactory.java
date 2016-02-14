package com.lis.investmentdataclient.technicalanalysis.factory;

import java.sql.Date;

import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.technicalanalysis.DegenerateMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.ExpNormalizedMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.SimpleNormalizedMovingAverage;

public class NormalizedMovingAverageFactory {

	public static NormalizedMovingAverage getSimpleInstance(Trackable trackable,
			Date tradeDate, int period) {
		if(trackable.isPeriodTooLargeForMovingAverageCalculation(period, tradeDate))
			return new DegenerateMovingAverage(period);
		else
			return getSimpleNormalizedMovingAverage(trackable, tradeDate, period);
	}

	private static SimpleNormalizedMovingAverage getSimpleNormalizedMovingAverage(
			Trackable trackable, Date tradeDate, int period) {
		double movingAverageValue = trackable.getNormalizedSimpleMovingAverage(tradeDate, period);
		return new SimpleNormalizedMovingAverage(period, movingAverageValue);
	}

	public static NormalizedMovingAverage getExpInstance(Trackable trackable,
			Date tradeDate, int period) {
		if(trackable.isPeriodTooLargeForMovingAverageCalculation(period, tradeDate))
			return new DegenerateMovingAverage(period);
		else
			return getExpNormalizedMovingAverage(trackable, tradeDate, period);
	}

	private static ExpNormalizedMovingAverage getExpNormalizedMovingAverage(
			Trackable trackable, Date tradeDate, int period) {
		double movingAverageValue = trackable.getNormalizedExpMovingAverage(tradeDate, period);
		return new ExpNormalizedMovingAverage(period, movingAverageValue);
	}

}
