package com.lis.investmentdataclient.drawingtools.technicalanalysis;

public class ExpNormalizedMovingAverage implements NormalizedMovingAverage {

	private int period;
	private double value;
	
	
	public ExpNormalizedMovingAverage(int period, double value) {
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
