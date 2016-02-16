package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BearFont;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class RegularComparativeMovingAverageIndicator
		implements ComparativeMovingAverageIndicator {
	
	private double longerMovingAverageValue;
	private double shorterMovingAverageValue;
	private Font font;

	
	public RegularComparativeMovingAverageIndicator(
			NormalizedMovingAverage shorter, NormalizedMovingAverage longer) {
		if(shorter.getMovingAveragePeriod() > longer.getMovingAveragePeriod())
			throw new IllegalArgumentException();
		longerMovingAverageValue = longer.getNormalizedMovingAverageValue();
		shorterMovingAverageValue = shorter.getNormalizedMovingAverageValue();
		font = establishFont();
	}

	
	private Font establishFont() {
		if(shorterMovingAverageValue >= longerMovingAverageValue)
			return new BullFont();
		else
			return new BearFont();
	}


	@Override
	public String getIndicatorString() {
		if(shorterMovingAverageValue > longerMovingAverageValue)
			return "Yes";
		else
			return "No";
	}


	@Override
	public Font getFont() {
		return font;
	}

}
