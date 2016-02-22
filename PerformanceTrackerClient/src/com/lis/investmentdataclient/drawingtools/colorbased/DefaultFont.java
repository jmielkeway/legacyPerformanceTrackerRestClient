package com.lis.investmentdataclient.drawingtools.colorbased;

public class DefaultFont extends BaseFont {

	Color color;
	
	public DefaultFont() {
		this.color = new Color(0,0,0,100);
		setColor(color);
		setFontSize(11);
	}
	
}
