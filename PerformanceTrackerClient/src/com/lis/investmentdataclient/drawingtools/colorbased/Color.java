package com.lis.investmentdataclient.drawingtools.colorbased;

public class Color {
	
	private int red;
	private int green;
	private int blue;
	private int alpha;
	
	public Color(int red, int green, int blue) {
		this(red, green, blue, 100);
	}

	public Color(int red, int green, int blue, int alpha) {
		if(isOutOfRange(red,green,blue,alpha))
			throw new IllegalArgumentException();
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	
	private boolean isOutOfRange(int red, int green, int blue, int alpha) {
		if(red < 0 || green < 0 || blue < 0 || alpha < 0)
			return true;
		if(red > 255 || green > 255 || blue > 255 || alpha > 100)
			return true;
		return false;
	}

	public int getRed() {
		return red;
	}
	
	
	public int getGreen() {
		return green;
	}
	
	
	public int getBlue() {
		return blue;
	}
	
	
	public int getAlpha() {
		return alpha;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != getClass())
			return false;
		Color c = (Color) obj;
		return this.red == c.red && this.green == c.green &&
				this.blue == c.blue && this.alpha == c.alpha;
	}
	
	
	@Override
	public int hashCode() {
		return 2 * (3 * red + 5 * blue + 7 * green + 11 * alpha);
	}
}
