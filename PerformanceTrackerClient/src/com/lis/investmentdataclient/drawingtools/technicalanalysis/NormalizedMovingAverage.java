package com.lis.investmentdataclient.drawingtools.technicalanalysis;

public interface NormalizedMovingAverage {
	
	public int getMovingAveragePeriod();
	
	public double getNormalizedMovingAverageValue();

	public void accept(MovingAverageVisitor visitor);
}
