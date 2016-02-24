package com.lis.investmentdataclient.document;


import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;

public interface PdfTableCell {
	
	public String getCellText();
	
	public Font getCellFont();
	
	public int getColumnWidth();
	
	public BackgroundColor getBackgroundColor();
	
	public void setBackgroundColor(BackgroundColor backgroundColor);
}
