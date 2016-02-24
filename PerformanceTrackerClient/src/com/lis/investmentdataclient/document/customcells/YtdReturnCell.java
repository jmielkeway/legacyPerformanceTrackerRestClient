package com.lis.investmentdataclient.document.customcells;

import java.sql.Date;

import com.lis.investmentdataclient.drawingtools.technicalanalysis.PrintableTechnicalIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.StandardIndicators;
import com.lis.investmentdataclient.model.Trackable;

public class YtdReturnCell extends AbstractIndicatorCell {
	

	@Override
	public TrackableBasedCell cloneCell() {
		return new YtdReturnCell();
	}


	@Override
	protected PrintableTechnicalIndicator setIndicator(Trackable trackable, Date observationDate) {
		return StandardIndicators.getYtdReturn(trackable, observationDate);
	}
}
