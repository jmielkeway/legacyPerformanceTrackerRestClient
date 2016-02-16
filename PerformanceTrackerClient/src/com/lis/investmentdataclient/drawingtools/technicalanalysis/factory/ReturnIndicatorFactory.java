package com.lis.investmentdataclient.drawingtools.technicalanalysis.factory;

import java.sql.Date;

import com.lis.investmentdataclient.drawingtools.technicalanalysis.DegenerateReturnIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.RegularReturnIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ReturnIndicator;
import com.lis.investmentdataclient.model.Trackable;

public class ReturnIndicatorFactory {

	public static ReturnIndicator getInstance(Trackable trackable, Date startDate,
			Date endDate) {
		if(trackable.isDateBeforeTradable(startDate))
			return new DegenerateReturnIndicator();
		else
			return getRegularReturnIndicator(trackable, startDate, endDate);
	}

	private static ReturnIndicator getRegularReturnIndicator(Trackable trackable,
			Date startDate, Date endDate) {
		double investmentReturnValue = trackable.getAnnualizedReturnBetween(startDate, endDate);
		return new RegularReturnIndicator(investmentReturnValue);
	}

}
