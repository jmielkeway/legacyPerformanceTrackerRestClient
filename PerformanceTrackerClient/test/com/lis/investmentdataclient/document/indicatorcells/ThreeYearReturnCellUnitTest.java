package com.lis.investmentdataclient.document.indicatorcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class ThreeYearReturnCellUnitTest extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		return new ThreeYearReturnCell();
	}

	@Override
	protected String getExpectedCellString() {
		return "8.37%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}

}
