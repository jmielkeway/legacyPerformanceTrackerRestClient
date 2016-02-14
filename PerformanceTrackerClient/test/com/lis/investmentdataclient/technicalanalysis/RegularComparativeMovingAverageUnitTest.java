package com.lis.investmentdataclient.technicalanalysis;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.technicalanalysis.factory.NormalizedMovingAverageFactory;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class RegularComparativeMovingAverageUnitTest {
	
	Ticker restTicker;

	
	@Before
	public void setUp() throws Exception {
		restTicker = TickerBuilder.getCachedRestTicker();
	}
	
	
	private void doCompartiveMovingAverageTest(Date tradeDate, int shorter, int longer, String expectedString) {
		NormalizedMovingAverage shorterMa = NormalizedMovingAverageFactory
				.getSimpleInstance(restTicker, tradeDate, shorter);
		NormalizedMovingAverage longerMa = NormalizedMovingAverageFactory
				.getSimpleInstance(restTicker, tradeDate, longer);
		ComparativeMovingAverageIndicator cmai = new RegularComparativeMovingAverageIndicator(shorterMa, longerMa);
		String actualString = cmai.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldBeIllegalBecauseShortAndLongAreInWrongOrder() throws Exception {
		Date tradeDate = Date.valueOf("2014-02-15");
		int shorterPeriod = 50;
		int longerPeriod = 20;
		String expectedString = "";
		doCompartiveMovingAverageTest(tradeDate, shorterPeriod, longerPeriod, expectedString);
	}
	
	
	@Test
	public void shouldHaveGreaterValueForShorterMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2007-01-26");
		int shorter = 20;
		int longer = 50;
		String expectedString = "Yes";
		doCompartiveMovingAverageTest(tradeDate, shorter, longer, expectedString);
	}
	
	
	@Test
	public void shouldHaveGreaterValueForLongerMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2009-01-28");
		int shorter = 50;
		int longer = 200;
		String expectedString = "No";
		doCompartiveMovingAverageTest(tradeDate, shorter, longer, expectedString);
	}
}
