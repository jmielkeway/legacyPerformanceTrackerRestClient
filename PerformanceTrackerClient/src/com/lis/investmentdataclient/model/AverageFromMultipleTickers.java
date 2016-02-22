package com.lis.investmentdataclient.model;

import java.sql.Date;

public class AverageFromMultipleTickers implements Trackable {

	private final String groupName;
	private Trackable[] trackables;
	
	public AverageFromMultipleTickers(Trackable ... allTechnicalTickers) {
		groupName = "Group Average";
		if(allTechnicalTickers.length == 0)
			throw new IllegalArgumentException();
		this.trackables = allTechnicalTickers;
	}

	@Override
	public String getReferenceName() {
		return groupName;
	}

	@Override
	public double getReturnBetween(Date startDate, Date endDate) {
		double investmentReturn = 0;
		for(Trackable tt : trackables)
			investmentReturn += (tt.getReturnBetween(startDate, endDate)) / trackables.length;
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
		for (Trackable tt : trackables)
			normalizedSma += Math.sqrt(tt.getNormalizedSimpleMovingAverage(tradeDate, period));
		return normalizedSma;
	}

	@Override
	public double getNormalizedExpMovingAverage(Date tradeDate, int period) {
		double normalizedEma = 0.0;
		for (Trackable tt : trackables)
			normalizedEma += Math.sqrt(tt.getNormalizedExpMovingAverage(tradeDate, period));
		return normalizedEma;
	}

	@Override
	public boolean isDateBeforeTradable(Date tradeDate) {
		for(Trackable tt : trackables)
			if(tt.isDateBeforeTradable(tradeDate))
				return true;
		return false;
	}

	@Override
	public boolean isPeriodTooLargeForMovingAverageCalculation(int period,
			Date tradeDate) {
		for(Trackable tt : trackables)
			if(tt.isPeriodTooLargeForMovingAverageCalculation(period, tradeDate))
				return true;
		return false;
	}

}
