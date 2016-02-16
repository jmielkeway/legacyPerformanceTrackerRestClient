package com.lis.investmentdataclient.drawingtools.technicalanalysis.factory;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class StandardIndicatorsMovingAverageUnitTest {
	
	Trackable trackable;
	Date observationDate;
	ComparativeMovingAverageIndicator cma;
	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TickerBuilder.getCachedRestTicker();
		trackable = new TechnicalTicker(restTicker);
		observationDate = Date.valueOf("2006-10-02");
	}
	
	
	@Test
	public void shouldReturnDegenerateMovingAverage() throws Exception {
		cma = StandardIndicators.getFiftyEmaVsTwoHundredEma(trackable, observationDate);
		String expectedString = "N/A";
		String actualString = cma.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldIdentifyIfThirtyEmaIsAboveFiftyEma() throws Exception {
		cma = StandardIndicators.getThirtyEmaVsFiftyEma(trackable, observationDate);
		String expectedString = "Yes";
		String actualString = cma.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldIdentifyIfTwentyEmaIsAboveThirtyEma() throws Exception {
		cma = StandardIndicators.getTwentyEmaVsThirtyEma(trackable, observationDate);
		String expectedString = "Yes";
		String actualString = cma.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldIdentifyIfTenSmaIsAboveTwentyEma() throws Exception {
		cma = StandardIndicators.getTenSmaVsTwentyEma(trackable, observationDate);
		String expectedString = "Yes";
		String actualString = cma.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
}
