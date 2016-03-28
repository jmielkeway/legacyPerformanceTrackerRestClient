package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.GenericFont;

public class TitleCellUnitTest extends AbstractPdfTableCellUnitTest {
	
	String title = "Market Achievers";
	Font font = new GenericFont(100, 100, 100, 12);
	int columnCount = 13;

	@Override
	protected PdfTableCell getTableCell() {
		return new TitleCell(title, new Color(100, 100, 100), columnCount);
	}

	@Override
	protected String getExpectedCellString() {
		return title;
	}

	@Override
	protected Font getExpectedCellFont() {
		return font;
	}

	@Override
	protected int getExpectedColumnCount() {
		return columnCount;
	}

}
