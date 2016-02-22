package com.lis.investmentdataclient.document;

public interface PdfElement {

	public void accept(ElementVisitor visitor);
	
	public double getTrailingSpacing();

}
