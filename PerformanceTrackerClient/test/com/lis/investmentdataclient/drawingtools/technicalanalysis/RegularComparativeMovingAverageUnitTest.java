package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BearFont;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.RegularComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.NormalizedMovingAverageFactory;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.testbuilder.TestTickerFactory;

public class RegularComparativeMovingAverageUnitTest {
	
	TechnicalTicker technicalTicker;

	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TestTickerFactory.getCachedRestTicker();
		technicalTicker = new TechnicalTicker(restTicker);
	}
	
	
	private void doCompartiveMovingAverageTest(Date tradeDate, int shorter, int longer, 
			String expectedString, Font font) {
		NormalizedMovingAverage shorterMa = NormalizedMovingAverageFactory
				.getSimpleInstance(technicalTicker, tradeDate, shorter);
		NormalizedMovingAverage longerMa = NormalizedMovingAverageFactory
				.getSimpleInstance(technicalTicker, tradeDate, longer);
		ComparativeMovingAverageIndicator cmai = new RegularComparativeMovingAverageIndicator(shorterMa, longerMa);
		String actualString = cmai.getIndicatorString();
		assertEquals(expectedString, actualString);
		assertEquals(font, cmai.getFont());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldBeIllegalBecauseShortAndLongAreInWrongOrder() throws Exception {
		Date tradeDate = Date.valueOf("2014-02-15");
		int shorterPeriod = 50;
		int longerPeriod = 20;
		String expectedString = "";
		doCompartiveMovingAverageTest(tradeDate, shorterPeriod, longerPeriod, expectedString, new NeutralFont());
	}
	
	
	@Test
	public void shouldHaveGreaterValueForShorterMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2007-01-26");
		int shorter = 20;
		int longer = 50;
		String expectedString = "Yes";
		doCompartiveMovingAverageTest(tradeDate, shorter, longer, expectedString, new BullFont());
	}
	
	
	@Test
	public void shouldHaveGreaterValueForLongerMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2009-01-28");
		int shorter = 50;
		int longer = 200;
		String expectedString = "No";
		doCompartiveMovingAverageTest(tradeDate, shorter, longer, expectedString, new BearFont());
	}
}
