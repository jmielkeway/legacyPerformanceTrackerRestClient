package com.lis.investmentdataclient.document.indicatorcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;

public class TwentyVsThirtyMovingAverageCellUnitTest
		extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		return new TwentyVsThirtyMovingAverageCell();
	}

	@Override
	protected String getExpectedCellString() {
		return "N/A";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new NeutralFont();
	}
}
