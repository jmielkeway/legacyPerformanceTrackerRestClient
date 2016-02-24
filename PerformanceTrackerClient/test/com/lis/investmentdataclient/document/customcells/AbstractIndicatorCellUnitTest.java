package com.lis.investmentdataclient.document.customcells;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.testbuilder.TestTickerFactory;

public abstract class AbstractIndicatorCellUnitTest
		extends AbstractPdfTableCellUnitTest {

	@Override
	protected PdfTableCell getTableCell() {
		Ticker ticker = TestTickerFactory.getStubbedTicker();
		Trackable trackable = new TechnicalTicker(ticker);
		TrackableBasedCell cell = (TrackableBasedCell) getIndicatorCell();
		cell.setTrackable(trackable);
		return cell;
	}
	
	protected abstract PdfTableCell getIndicatorCell();
	
	@Override
	protected int getExpectedColumnCount() {
		return 1;
	}

}
