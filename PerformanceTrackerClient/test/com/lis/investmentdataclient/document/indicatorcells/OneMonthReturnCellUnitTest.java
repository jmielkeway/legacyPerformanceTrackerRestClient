package com.lis.investmentdataclient.document.indicatorcells;


import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class OneMonthReturnCellUnitTest extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		return new OneMonthReturnCell();
	}

	@Override
	protected String getExpectedCellString() {
		return "0.00%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}
}
