package com.lis.investmentdataclient.drawingtools.technicalanalysis;

public class SimpleNormalizedMovingAverage implements NormalizedMovingAverage {

	private int period;
	private double value;
	
	public SimpleNormalizedMovingAverage(int period, double value) {
		this.period = period;
		this.value = value;
	}

	@Override
	public int getMovingAveragePeriod() {
		return period;
	}

	@Override
	public double getNormalizedMovingAverageValue() {
		return value;
	}

	@Override
	public void accept(MovingAverageVisitor visitor) {
		visitor.visit(this);
	}

}
