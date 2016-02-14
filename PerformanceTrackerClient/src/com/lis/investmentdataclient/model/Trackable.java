package com.lis.investmentdataclient.model;

import java.sql.Date;

public interface Trackable {

	
	public String getReferenceName();
	
	public double getReturnBetween(Date startDate, Date endDate);
	
	public double getAnnualizedReturnBetween(Date startDate, Date endDate);
	
	public double getNormalizedSimpleMovingAverage(Date tradeDate, int period);
	
	public double getNormalizedExpMovingAverage(Date tradeDate, int period);
	
	public boolean isDateBeforeTradable(Date tradeDate);
	
	public boolean isPeriodTooLargeForMovingAverageCalculation(int period, Date tradeDate);
}
