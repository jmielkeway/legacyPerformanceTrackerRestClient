package com.lis.investmentdataclient.document.indicatorcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class OneYearReturnCellUnitTest extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		return new OneYearReturnCell();
	}

	@Override
	protected String getExpectedCellString() {
		return "7.69%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}

}
