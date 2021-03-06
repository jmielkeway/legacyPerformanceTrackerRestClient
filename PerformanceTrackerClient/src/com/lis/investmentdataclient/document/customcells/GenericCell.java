package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.GenericFont;

public class GenericCell implements PdfTableCell {

	String text;
	BackgroundColor backgroundColor;
	
	public GenericCell(String text) {
		this.text = text;
	}
	
	@Override
	public String getCellText() {
		return text;
	}

	@Override
	public Font getCellFont() {
		return new GenericFont(0,0,0,9);
	}

	@Override
	public int getColumnWidth() {
		return 1;
	}

	@Override
	public BackgroundColor getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public void setBackgroundColor(BackgroundColor backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
