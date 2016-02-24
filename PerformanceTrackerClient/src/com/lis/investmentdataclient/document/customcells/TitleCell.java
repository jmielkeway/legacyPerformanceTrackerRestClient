package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.GenericFont;

public class TitleCell implements PdfTableCell {
	
	String title;
	int columnWidth;
	BackgroundColor backgroundColor;
	
	public TitleCell(String title, Color backgroundColor, int columnSpan) {
		this.title = title;
		this.backgroundColor = new BackgroundColor(backgroundColor);
		columnWidth = columnSpan;
	}

	@Override
	public String getCellText() {
		return title;
	}

	@Override
	public Font getCellFont() {
		return new GenericFont(255,255,255);
	}

	@Override
	public int getColumnWidth() {
		return columnWidth;
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
