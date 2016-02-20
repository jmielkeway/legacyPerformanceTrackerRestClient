package com.lis.investmentdataclient.model;

import java.sql.Date;

public class TickerGroupAverage implements Trackable {

	private final String groupName;
	private TechnicalTicker[] tickers;
	
	public TickerGroupAverage(TechnicalTicker ... tickers) {
		groupName = "Group Average";
		if(tickers.length == 0)
			throw new IllegalArgumentException();
		this.tickers = tickers;
	}

	@Override
	public String getReferenceName() {
		return groupName;
	}

	@Override
	public double getReturnBetween(Date startDate, Date endDate) {
		double investmentReturn = 0;
		for(TechnicalTicker tt : tickers)
			investmentReturn += (tt.getReturnBetween(startDate, endDate)) / tickers.length;
		return investmentReturn;
	}

	@Override
	public double getAnnualizedReturnBetween(Date startDate, Date endDate) {
		double antiExponent = 1.0/getYearsForAnnualization(startDate, endDate);
		double totalReturn = getReturnBetween(startDate, endDate);
		double annualizedReturn = Math.pow(1 + totalReturn, antiExponent) - 1;
		return annualizedReturn;
	}

	private int getYearsForAnnualization(Date startDate, Date endDate) {
		int start = startDate.toLocalDate().getYear();
		int end = endDate.toLocalDate().getYear();
		return end - start;
	}

	@Override
	public double getNormalizedSimpleMovingAverage(Date tradeDate, int period) {
		double normalizedSma = 0.0;
		for (TechnicalTicker tt : tickers)
			normalizedSma += Math.sqrt(tt.getNormalizedSimpleMovingAverage(tradeDate, period));
		return normalizedSma;
	}

	@Override
	public double getNormalizedExpMovingAverage(Date tradeDate, int period) {
		double normalizedEma = 0.0;
		for (TechnicalTicker tt : tickers)
			normalizedEma += Math.sqrt(tt.getNormalizedExpMovingAverage(tradeDate, period));
		return normalizedEma;
	}

	@Override
	public boolean isDateBeforeTradable(Date tradeDate) {
		for(TechnicalTicker tt : tickers)
			if(tt.isDateBeforeTradable(tradeDate))
				return true;
		return false;
	}

	@Override
	public boolean isPeriodTooLargeForMovingAverageCalculation(int period,
			Date tradeDate) {
		for(TechnicalTicker tt : tickers)
			if(tt.isPeriodTooLargeForMovingAverageCalculation(period, tradeDate))
				return true;
		return false;
	}

}
