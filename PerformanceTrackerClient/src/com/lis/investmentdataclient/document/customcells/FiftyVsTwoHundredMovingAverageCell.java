package com.lis.investmentdataclient.document.customcells;

import java.sql.Date;

import com.lis.investmentdataclient.drawingtools.technicalanalysis.PrintableTechnicalIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.StandardIndicators;
import com.lis.investmentdataclient.model.Trackable;

public class FiftyVsTwoHundredMovingAverageCell extends AbstractIndicatorCell {

	@Override
	public TrackableBasedCell cloneCell() {
		return new FiftyVsTwoHundredMovingAverageCell();
	}

	@Override
	protected PrintableTechnicalIndicator setIndicator(Trackable trackable,
			Date observationDate) {
		return StandardIndicators.getFiftyEmaVsTwoHundredEma(trackable, observationDate);
	}


}
