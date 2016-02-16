package com.lis.investmentdataclient.drawingtools.technicalanalysis.factory;

import java.sql.Date;

import com.lis.investmentdataclient.drawingtools.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ReturnIndicator;
import com.lis.investmentdataclient.model.Trackable;

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


	public static ComparativeMovingAverageIndicator getFiftyEmaVsTwoHundredEma(
			Trackable trackable, Date observationDate) {
		NormalizedMovingAverage fifty = NormalizedMovingAverageFactory
				.getExpInstance(trackable, observationDate, 50);
		NormalizedMovingAverage twoHundred = NormalizedMovingAverageFactory
				.getExpInstance(trackable, observationDate, 200);
		ComparativeMovingAverageIndicator cmai = ComparativeMovingAverageFactory
				.getInstance(fifty, twoHundred);
		return cmai;
	}


	public static ComparativeMovingAverageIndicator getThirtyEmaVsFiftyEma(
			Trackable trackable, Date observationDate) {
		NormalizedMovingAverage thirty = NormalizedMovingAverageFactory
				.getExpInstance(trackable, observationDate, 30);
		NormalizedMovingAverage fifty = NormalizedMovingAverageFactory
				.getExpInstance(trackable, observationDate, 50);
		ComparativeMovingAverageIndicator cmai = ComparativeMovingAverageFactory
				.getInstance(thirty, fifty);
		return cmai;
	}


	public static ComparativeMovingAverageIndicator getTwentyEmaVsThirtyEma(
			Trackable trackable, Date observationDate) {
		NormalizedMovingAverage twenty = NormalizedMovingAverageFactory
				.getExpInstance(trackable, observationDate, 20);
		NormalizedMovingAverage thirty = NormalizedMovingAverageFactory
				.getExpInstance(trackable, observationDate, 30);
		ComparativeMovingAverageIndicator cmai = ComparativeMovingAverageFactory
				.getInstance(twenty, thirty);
		return cmai;
	}


	public static ComparativeMovingAverageIndicator getTenSmaVsTwentyEma(
			Trackable trackable, Date observationDate) {
		NormalizedMovingAverage ten = NormalizedMovingAverageFactory
				.getSimpleInstance(trackable, observationDate, 10);
		NormalizedMovingAverage twenty = NormalizedMovingAverageFactory
				.getExpInstance(trackable, observationDate, 20);
		ComparativeMovingAverageIndicator cmai = ComparativeMovingAverageFactory
				.getInstance(ten, twenty);
		return cmai;
	}
}
