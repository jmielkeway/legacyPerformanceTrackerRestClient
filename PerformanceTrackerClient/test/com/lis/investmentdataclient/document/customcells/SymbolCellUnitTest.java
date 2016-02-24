package com.lis.investmentdataclient.document.customcells;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.customcells.SymbolCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.testbuilder.TestTickerFactory;

public class SymbolCellUnitTest extends AbstractPdfTableCellUnitTest {


	@Override
	protected String getExpectedCellString() {
		return "STUB";
	}

	@Override
	protected Font getExpectedCellFont() {
		return new NeutralFont();
	}


	@Override
	protected PdfTableCell getTableCell() {
		Ticker ticker = TestTickerFactory.getStubbedTicker();
		Trackable trackable = new TechnicalTicker(ticker);
		SymbolCell symbolCell = new SymbolCell();
		symbolCell.setTrackable(trackable);
		return symbolCell;
	}

	@Override
	protected int getExpectedColumnCount() {
		return 1;
	}
}
