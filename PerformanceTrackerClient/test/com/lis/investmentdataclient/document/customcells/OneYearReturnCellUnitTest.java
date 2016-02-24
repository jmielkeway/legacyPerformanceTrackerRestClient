package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.customcells.OneYearReturnCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class OneYearReturnCellUnitTest extends AbstractIndicatorCellUnitTest {


	@Override
	protected String getExpectedCellString() {
		return "7.69%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}

	@Override
	protected PdfTableCell getIndicatorCell() {
		return new OneYearReturnCell();
	}

}
