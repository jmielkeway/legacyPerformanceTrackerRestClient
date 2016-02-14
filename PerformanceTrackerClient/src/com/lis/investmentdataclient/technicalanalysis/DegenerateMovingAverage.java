package com.lis.investmentdataclient.technicalanalysis;

public class DegenerateMovingAverage implements NormalizedMovingAverage {

	int period;
	
	public DegenerateMovingAverage(int period) {
		this.period = period;
	}

	@Override
	public int getMovingAveragePeriod() {
		return period;
	}

	@Override
	public double getNormalizedMovingAverageValue() {
		throw new IllegalArgumentException();
	}

	@Override
	public void accept(MovingAverageVisitor visitor) {
		visitor.visit(this);
	}

}
