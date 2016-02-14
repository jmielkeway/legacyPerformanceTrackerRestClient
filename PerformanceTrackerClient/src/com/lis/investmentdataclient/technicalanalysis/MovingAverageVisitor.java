package com.lis.investmentdataclient.technicalanalysis;

public interface MovingAverageVisitor {

	public void visit(DegenerateMovingAverage degenerateMovingAverage);
	
	public void visit(SimpleNormalizedMovingAverage simpleMovingAverage);
	
	public void visit(ExpNormalizedMovingAverage expMovingAverage);
}
