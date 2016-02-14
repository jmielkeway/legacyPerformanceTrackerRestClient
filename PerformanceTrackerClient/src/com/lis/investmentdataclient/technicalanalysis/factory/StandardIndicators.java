package com.lis.investmentdataclient.technicalanalysis.factory;

import java.sql.Date;

import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.technicalanalysis.ReturnIndicator;

public class StandardIndicators {

	public static ReturnIndicator getTenYearReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().minusYears(10));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}

	
	public static ReturnIndicator getFiveYearReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().minusYears(5));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}

	
	public static ReturnIndicator getThreeYearReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().minusYears(3));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}

	
	public static ReturnIndicator getOneYearReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().minusYears(1));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}


	public static ReturnIndicator getYtdReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().withDayOfYear(1));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}


	public static ReturnIndicator getThreeMonthReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().minusMonths(3));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}


	public static ReturnIndicator getOneMonthReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().minusMonths(1));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}


	public static ReturnIndicator getOneWeekReturn(Trackable trackable, Date observationDate) {
		Date startDate = Date.valueOf(observationDate.toLocalDate().minusWeeks(1));
		ReturnIndicator ri = ReturnIndicatorFactory.getInstance(trackable, startDate, observationDate);
		return ri;
	}

}
