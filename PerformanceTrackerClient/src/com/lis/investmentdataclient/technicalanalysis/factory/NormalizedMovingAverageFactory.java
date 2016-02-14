package com.lis.investmentdataclient.technicalanalysis.factory;

import java.sql.Date;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.technicalanalysis.DegenerateMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.ExpNormalizedMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.SimpleNormalizedMovingAverage;

public class NormalizedMovingAverageFactory {

	public static NormalizedMovingAverage getSimpleInstance(Ticker ticker,
			Date tradeDate, int period) {
		TechnicalTicker technicalTicker = new TechnicalTicker(ticker);
		if(technicalTicker.isPeriodTooLargeForMovingAverageCalculation(period, tradeDate))
			return new DegenerateMovingAverage(period);
		else
			return getSimpleNormalizedMovingAverage(technicalTicker, tradeDate, period);
	}

	private static SimpleNormalizedMovingAverage getSimpleNormalizedMovingAverage(
			TechnicalTicker technicalTicker, Date tradeDate, int period) {
		double movingAverageValue = technicalTicker.getNormalizedSimpleMovingAverage(tradeDate, period);
		return new SimpleNormalizedMovingAverage(period, movingAverageValue);
	}

	public static NormalizedMovingAverage getExpInstance(Ticker ticker,
			Date tradeDate, int period) {
		TechnicalTicker technicalTicker = new TechnicalTicker(ticker);
		if(technicalTicker.isPeriodTooLargeForMovingAverageCalculation(period, tradeDate))
			return new DegenerateMovingAverage(period);
		else
			return getExpNormalizedMovingAverage(technicalTicker, tradeDate, period);
	}

	private static ExpNormalizedMovingAverage getExpNormalizedMovingAverage(
			TechnicalTicker technicalTicker, Date tradeDate, int period) {
		double movingAverageValue = technicalTicker.getNormalizedExpMovingAverage(tradeDate, period);
		return new ExpNormalizedMovingAverage(period, movingAverageValue);
	}

}
