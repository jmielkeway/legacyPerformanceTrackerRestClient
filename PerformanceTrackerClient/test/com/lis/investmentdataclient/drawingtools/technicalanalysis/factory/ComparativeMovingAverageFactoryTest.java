package com.lis.investmentdataclient.drawingtools.technicalanalysis.factory;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.ComparativeMovingAverageFactory;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.NormalizedMovingAverageFactory;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class ComparativeMovingAverageFactoryTest {
	
	TechnicalTicker technicalTicker;
	
	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TickerBuilder.getCachedRestTicker();
		technicalTicker = new TechnicalTicker(restTicker);
	}
	
	
	private void doComparativeMovingAverageFromFactoryTest(Date tradeDate, int shorterPeriod,
			int longerPeriod, String expectedString) {
		NormalizedMovingAverage shorter = NormalizedMovingAverageFactory
				.getExpInstance(technicalTicker, tradeDate, shorterPeriod);
		NormalizedMovingAverage longer = NormalizedMovingAverageFactory
				.getExpInstance(technicalTicker, tradeDate, longerPeriod);
		ComparativeMovingAverageIndicator cmai = ComparativeMovingAverageFactory
				.getInstance(shorter, longer);
		String actualString = cmai.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldCreateDegenerateComparativeMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2008-12-15");
		int shorterPeriod = 50;
		int longerPeriod = 999999;
		String expectedString = "N/A";
		doComparativeMovingAverageFromFactoryTest(tradeDate, shorterPeriod, longerPeriod, expectedString);
	}
	
	
	@Test
	public void shouldCreateBullishComparativeMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2007-01-26");
		int shorterPeriod = 20;
		int longerPeriod = 50;
		String expectedString = "Yes";
		doComparativeMovingAverageFromFactoryTest(tradeDate, shorterPeriod, longerPeriod, expectedString);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldBeIllegalBecauseShorterAndLongerAreBackwards() throws Exception {
		Date tradeDate = Date.valueOf("2014-08-22");
		int shorterPeriod = 50;
		int longerPeriod = 20;
		String expectedString = "";
		doComparativeMovingAverageFromFactoryTest(tradeDate, shorterPeriod, longerPeriod, expectedString);
	}

}
