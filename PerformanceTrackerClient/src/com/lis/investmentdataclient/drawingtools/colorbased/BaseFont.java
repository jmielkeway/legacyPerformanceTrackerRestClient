package com.lis.investmentdataclient.drawingtools.colorbased;

public abstract class BaseFont implements Font {
	
	private Color color;
	private int size;
	
	protected void setColor(Color color) {
		this.color = color;
	}
	
	
	@Override
	public void setFontSize(int size) {
		this.size = size;
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
	
	
	@Override
	public int getFontSize() {
		return this.size;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != getClass())
			return false;
		BaseFont f = (BaseFont) object;
		return this.color.equals(f.color) && this.size == f.size;
 	}
	
	
	@Override
	public int hashCode() {
		return 3 * color.hashCode() * size;
	}

}
