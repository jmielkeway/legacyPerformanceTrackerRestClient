package com.lis.investmentdataclient.document.indicatorcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class FiveYearReturnCellUnitTest extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		return new FiveYearReturnCell();
	}

	@Override
	protected String getExpectedCellString() {
		return "9.24%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}
}
