package com.lis.investmentdataclient.document.indicatorcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class TenVsTwentyMovingAverageCellUnitTest extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		return new TenVsTwentyMovingAverageCell();
	}

	@Override
	protected String getExpectedCellString() {
		return "Yes";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}
}
