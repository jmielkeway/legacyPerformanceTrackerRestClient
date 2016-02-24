package com.lis.investmentdataclient.drawingtools.colorbased;

public class BackgroundColor implements Colorable {
	
	Color color;
	
	public BackgroundColor(Color color) {
		this.color = color;
	}

	@Override
	public int getRedChannel() {
		return color.getRed();
	}

	@Override
	public int getGreenChannel() {
		return color.getGreen();
	}

	@Override
	public int getBlueChannel() {
		return color.getBlue();
	}

	@Override
	public int getAlphaChannel() {
		return color.getAlpha();
	}

}
