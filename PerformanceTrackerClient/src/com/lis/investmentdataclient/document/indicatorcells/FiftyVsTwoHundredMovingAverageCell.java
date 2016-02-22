package com.lis.investmentdataclient.document.indicatorcells;

import java.sql.Date;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.PrintableTechnicalIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.StandardIndicators;
import com.lis.investmentdataclient.model.Trackable;

public class FiftyVsTwoHundredMovingAverageCell extends AbstractIndicatorCell {

	@Override
	public PdfTableCell cloneCell() {
		return new FiftyVsTwoHundredMovingAverageCell();
	}

	@Override
	protected PrintableTechnicalIndicator setIndicator(Trackable trackable,
			Date observationDate) {
		return StandardIndicators.getFiftyEmaVsTwoHundredEma(trackable, observationDate);
	}


}
