package com.lis.investmentdataclient.document.indicatorcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class ThreeMonthReturnCellUnitTest extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		return new ThreeMonthReturnCell();
	}

	@Override
	protected String getExpectedCellString() {
		return "3.70%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}

}