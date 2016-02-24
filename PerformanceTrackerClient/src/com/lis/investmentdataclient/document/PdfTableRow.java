package com.lis.investmentdataclient.document;

public interface PdfTableRow {
	
	
	public void addCell(PdfTableCell cell);
	
	
	public PdfTableCell[] getCells();

}
