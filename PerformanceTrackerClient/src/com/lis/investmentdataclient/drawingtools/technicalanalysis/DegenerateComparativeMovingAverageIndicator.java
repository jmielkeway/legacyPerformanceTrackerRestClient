package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;

public class DegenerateComparativeMovingAverageIndicator
		implements ComparativeMovingAverageIndicator {
	
	private Font font = new NeutralFont();

	@Override
	public String getIndicatorString() {
		return "N/A";
	}

	@Override
	public Font getFont() {
		return font;
	}

}
