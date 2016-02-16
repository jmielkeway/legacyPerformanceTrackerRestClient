package com.lis.investmentdataclient.drawingtools.colorbased;

public abstract class BaseFont implements Font {
	
	private Color color;
	
	protected void setColor(Color color) {
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
	
	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != getClass())
			return false;
		BaseFont f = (BaseFont) object;
		return this.color.equals(f.color);
 	}
	
	
	@Override
	public int hashCode() {
		return 3 * color.hashCode();
	}

}
