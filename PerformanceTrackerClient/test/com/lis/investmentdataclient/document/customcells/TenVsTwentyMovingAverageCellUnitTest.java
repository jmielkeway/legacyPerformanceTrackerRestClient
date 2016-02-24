package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.customcells.TenVsTwentyMovingAverageCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class TenVsTwentyMovingAverageCellUnitTest extends AbstractIndicatorCellUnitTest {


	@Override
	protected String getExpectedCellString() {
		return "Yes";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}

	@Override
	protected PdfTableCell getIndicatorCell() {
		return new TenVsTwentyMovingAverageCell();
	}
}
