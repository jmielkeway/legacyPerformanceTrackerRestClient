package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BearFont;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class RegularReturnIndicator implements ReturnIndicator {
	
	private double annualizedReturn;
	private Font font;

	public RegularReturnIndicator(double investmentReturnValue) {
		annualizedReturn = investmentReturnValue;
		font = establishFont();
	}
	
	private Font establishFont() {
		if (annualizedReturn >= 0)
			return new BullFont();
		else
			return new BearFont();
	}

	@Override
	public String getIndicatorString() {
		return String.format("%.1f", annualizedReturn*100) + "%";
	}

	@Override
	public Font getFont() {
		return font;
	}

}
