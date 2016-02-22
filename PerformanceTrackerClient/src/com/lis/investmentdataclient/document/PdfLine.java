package com.lis.investmentdataclient.document;

public class PdfLine implements PdfElement{
	
	private int widthPercent;
	private double trailingSpacing;

	public PdfLine(int widthPercent) {
		this.widthPercent = widthPercent;
		setTrailingSpacing(16.5);
	}
	
	protected void setTrailingSpacing(double trailingSpacing) {
		this.trailingSpacing = trailingSpacing;
	}

	@Override
	public void accept(ElementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public double getTrailingSpacing() {
		return trailingSpacing;
	}

	public int getWidthPercentage() {
		return widthPercent;
	}
}
