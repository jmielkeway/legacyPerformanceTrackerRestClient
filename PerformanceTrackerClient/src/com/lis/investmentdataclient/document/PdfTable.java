package com.lis.investmentdataclient.document;

public interface PdfTable extends PdfElement {
	
	public PdfTableRow[] getRows();

	public double[] getColumnWidths();


}
