package com.lis.investmentdataclient.technicalanalysis.factory;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class ComparativeMovingAverageFactoryTest {
	
	Ticker restTicker;
	
	
	@Before
	public void setUp() throws Exception {
		restTicker = TickerBuilder.getCachedRestTicker();
	}
	
	
	private void doComparativeMovingAverageFromFactoryTest(Date tradeDate, int shorterPeriod,
			int longerPeriod, String expectedString) {
		NormalizedMovingAverage shorter = NormalizedMovingAverageFactory
				.getSimpleInstance(restTicker, tradeDate, shorterPeriod);
		NormalizedMovingAverage longer = NormalizedMovingAverageFactory
				.getSimpleInstance(restTicker, tradeDate, longerPeriod);
		ComparativeMovingAverageIndicator cmai = new ComparativeMovingAverageFactory()
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
