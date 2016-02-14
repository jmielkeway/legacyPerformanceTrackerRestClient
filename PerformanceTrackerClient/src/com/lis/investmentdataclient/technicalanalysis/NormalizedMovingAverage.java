package com.lis.investmentdataclient.technicalanalysis;

public interface NormalizedMovingAverage {
	
	public int getMovingAveragePeriod();
	
	public double getNormalizedMovingAverageValue();

	public void accept(MovingAverageVisitor visitor);
}
