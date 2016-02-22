package com.lis.investmentdataclient.document;

public interface PdfTableRow {
	
	public int getNumberOfCells();
	
	public void addCell(PdfTableCell cell);
	
	public PdfTableCell getCellAtColumnIndex(int index);
	
	public PdfTableCell[] getCells();

}
