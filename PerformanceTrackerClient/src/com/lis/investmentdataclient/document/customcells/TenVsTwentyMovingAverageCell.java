package com.lis.investmentdataclient.document.customcells;

import java.sql.Date;

import com.lis.investmentdataclient.drawingtools.technicalanalysis.PrintableTechnicalIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.StandardIndicators;
import com.lis.investmentdataclient.model.Trackable;

public class TenVsTwentyMovingAverageCell extends AbstractIndicatorCell {

	@Override
	public TrackableBasedCell cloneCell() {
		return new TenVsTwentyMovingAverageCell();
	}

	@Override
	protected PrintableTechnicalIndicator setIndicator(Trackable trackable,
			Date observationDate) {
		return StandardIndicators.getTenSmaVsTwentyEma(trackable, observationDate);
	}

}
