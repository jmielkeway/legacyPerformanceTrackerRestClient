package com.lis.investmentdataclient.drawingtools.colorbased.bias;

import com.lis.investmentdataclient.drawingtools.colorbased.BaseFont;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;

public class BearFont extends BaseFont{
	
	Color color;
	
	public BearFont() {
		color = new Color(255,0,0);
		setColor(color);
	}

}
