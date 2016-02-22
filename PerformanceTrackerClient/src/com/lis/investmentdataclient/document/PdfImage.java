package com.lis.investmentdataclient.document;

import java.net.URL;

public class PdfImage implements PdfElement {

	String path;
	int height;
	int width;

	public PdfImage(String path, int percentageHeight, int percentageWidth) {
		this.path = path;
		this.height = percentageHeight;
		this.width = percentageWidth;
	}

	@Override
	public void accept(ElementVisitor visitor) {
		visitor.visit(this);
	}

	public URL getImageUrl() {
		return getClass().getClassLoader().getResource(path);
	}
	
	public int getPercentageHeight() {
		return this.height;
	}
	
	public int getPercentageWidth() {
		return this.width;
	}

	@Override
	public double getTrailingSpacing() {
		return 0;
	}

}
