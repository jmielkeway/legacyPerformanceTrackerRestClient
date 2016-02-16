package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;

public interface PrintableTechnicalIndicator extends TechnicalIndicator{
	
	public String getIndicatorString();
	
	public Font getFont();

}
