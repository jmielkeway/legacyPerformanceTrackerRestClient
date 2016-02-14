package com.lis.investmentdataclient.technicalanalysis.factory;

import java.sql.Date;

import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.technicalanalysis.DegenerateReturnIndicator;
import com.lis.investmentdataclient.technicalanalysis.RegularReturnIndicator;
import com.lis.investmentdataclient.technicalanalysis.ReturnIndicator;

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
