package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.customcells.ThreeMonthReturnCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;

public class ThreeMonthReturnCellUnitTest extends AbstractIndicatorCellUnitTest {


	@Override
	protected String getExpectedCellString() {
		return "3.70%";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new BullFont();
	}

	@Override
	protected PdfTableCell getIndicatorCell() {
		return new ThreeMonthReturnCell();
	}

}
