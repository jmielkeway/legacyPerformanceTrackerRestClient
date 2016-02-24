package com.lis.investmentdataclient.document.customcells;


import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.customcells.OneMonthReturnCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class OneMonthReturnCellUnitTest extends AbstractIndicatorCellUnitTest {


	@Override
	protected String getExpectedCellString() {
		return "0.00%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}

	@Override
	protected PdfTableCell getIndicatorCell() {
		return new OneMonthReturnCell();
	}
}
