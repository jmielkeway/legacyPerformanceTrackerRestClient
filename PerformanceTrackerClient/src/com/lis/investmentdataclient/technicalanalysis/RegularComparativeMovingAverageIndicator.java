package com.lis.investmentdataclient.technicalanalysis;

public class RegularComparativeMovingAverageIndicator
		implements ComparativeMovingAverageIndicator {
	
	private double longerMovingAverageValue;
	private double shorterMovingAverageValue;

	
	public RegularComparativeMovingAverageIndicator(
			NormalizedMovingAverage shorter, NormalizedMovingAverage longer) {
		if(shorter.getMovingAveragePeriod() > longer.getMovingAveragePeriod())
			throw new IllegalArgumentException();
		longerMovingAverageValue = longer.getNormalizedMovingAverageValue();
		shorterMovingAverageValue = shorter.getNormalizedMovingAverageValue();
	}

	
	@Override
	public String getIndicatorString() {
		if(shorterMovingAverageValue > longerMovingAverageValue)
			return "Yes";
		else
			return "No";
	}

}
