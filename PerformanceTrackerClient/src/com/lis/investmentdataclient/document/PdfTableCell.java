package com.lis.investmentdataclient.document;


import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.model.Trackable;

public interface PdfTableCell {
	
	public String getCellText();
	
	public Font getCellFont();
	
	public PdfTableCell cloneCell();
	
	public void setTrackable(Trackable trackable);
	
}
