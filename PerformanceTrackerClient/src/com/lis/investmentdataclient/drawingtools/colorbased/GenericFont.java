package com.lis.investmentdataclient.drawingtools.colorbased;

public class GenericFont extends BaseFont {


	public GenericFont(int red, int green, int blue, int size) {
		Color color = new Color(red, green, blue);
		setColor(color);
		setFontSize(size);
	}
	
}
