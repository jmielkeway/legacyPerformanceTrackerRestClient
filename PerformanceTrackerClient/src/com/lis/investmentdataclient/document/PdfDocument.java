package com.lis.investmentdataclient.document;

public interface PdfDocument {

	public boolean add(PdfElement element);

	public void open();
	
	public void close();

	public boolean addPage();

	public int getNumberOfPages();

}
