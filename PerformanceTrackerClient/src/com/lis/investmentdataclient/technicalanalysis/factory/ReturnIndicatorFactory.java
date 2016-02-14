package com.lis.investmentdataclient.technicalanalysis.factory;

import java.sql.Date;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.technicalanalysis.DegenerateReturnIndicator;
import com.lis.investmentdataclient.technicalanalysis.RegularReturnIndicator;
import com.lis.investmentdataclient.technicalanalysis.ReturnIndicator;

public class ReturnIndicatorFactory {

	public static ReturnIndicator getInstance(Ticker ticker, Date startDate,
			Date endDate) {
		TechnicalTicker technicalTicker = new TechnicalTicker(ticker);
		if(technicalTicker.isDateBeforeTradable(startDate))
			return new DegenerateReturnIndicator();
		else
			return getRegularReturnIndicator(technicalTicker, startDate, endDate);
	}

	private static ReturnIndicator getRegularReturnIndicator(TechnicalTicker technicalTicker,
			Date startDate, Date endDate) {
		double investmentReturnValue = technicalTicker.getAnnualizedReturnBetween(startDate, endDate);
		return new RegularReturnIndicator(investmentReturnValue);
	}

}
