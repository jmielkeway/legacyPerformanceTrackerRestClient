package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.customcells.ThirtyVsFiftyMovingAverageCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;

public class ThirtyVsFiftyMovingAverageCellUnitTest extends AbstractIndicatorCellUnitTest {


	@Override
	protected String getExpectedCellString() {
		return "N/A";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new NeutralFont();
	}

	@Override
	protected PdfTableCell getIndicatorCell() {
		return new ThirtyVsFiftyMovingAverageCell();
	}

}
