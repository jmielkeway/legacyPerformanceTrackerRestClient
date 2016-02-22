package com.lis.investmentdataclient.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Etf;
import com.jhm.investmentdata.model.MutualFund;
import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.rest.TickerImport;

public class AverageFromMultipleTickersUnitTest {
	
	AverageFromMultipleTickers average;
	
	@Before
	public void setUp() throws Exception {
		Ticker rspTicker = TickerImport.getRestTicker("RSP", Etf.class);
		Ticker cpeaxTicker = TickerImport.getRestTicker("CPEAX", MutualFund.class);
		TechnicalTicker rsp = new TechnicalTicker(rspTicker);
		TechnicalTicker cpeax = new TechnicalTicker(cpeaxTicker);
		average = new AverageFromMultipleTickers(rsp, cpeax);
	}
	
	@Test
	public void shouldHaveCorrectGroupName() throws Exception {
		assertEquals("Group Average", average.getReferenceName());
	}
	
	
	@Test
	public void shouldHaveCorrectAnswerForIsDateBeforeTradable() throws Exception {
		Date notTradable = Date.valueOf("2009-06-14");
		Date tradable = Date.valueOf("2014-05-01");
		assertTrue(average.isDateBeforeTradable(notTradable));
		assertFalse(average.isDateBeforeTradable(tradable));
	}
	
	
	@Test
	public void shouldHaveCorrectAnswerForIsPeriodTooLargeForMovingPeriodCalculation() throws Exception {
		Date tradeDate = Date.valueOf("2015-01-05");
		int tooLargePeriod = 1500;
		int inRangePeriod = 300;
		assertTrue(average.isPeriodTooLargeForMovingAverageCalculation(tooLargePeriod, tradeDate));
		assertFalse(average.isPeriodTooLargeForMovingAverageCalculation(inRangePeriod, tradeDate));
	}
	
	
	@Test
	public void shouldReturnCorrectAbsoluteReturn() throws Exception {
		Date startDate = Date.valueOf("2013-03-07");
		Date endDate = Date.valueOf("2014-03-07");
		double expectedReturn = 0.265752;
		double actualReturn = average.getReturnBetween(startDate, endDate);
		assertEquals(expectedReturn, actualReturn, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectAnnualizedReturn() throws Exception {
		Date startDate = Date.valueOf("2012-03-07");
		Date endDate = Date.valueOf("2014-03-07");
		double expectedAnnualizedReturn = 0.216862;
		double actualAnnualizedReturn = average.getAnnualizedReturnBetween(startDate, endDate);
		assertEquals(expectedAnnualizedReturn, actualAnnualizedReturn, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectNormalizedSimpleMovingAverageAdjustedForSquareRootOfAverages() throws Exception {
		Date observationDate = Date.valueOf("2015-04-05");
		int period = 10;
		double expectedSma = 2.733099;
		double actualSma = average.getNormalizedSimpleMovingAverage(observationDate, period);
		assertEquals(expectedSma, actualSma, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectNormalizedExponentialMovingAverageAdjustedForSquareRootOfAverages() throws Exception {
		Date observationDate = Date.valueOf("2012-02-27");
		int period = 20;
		double expectedEma = 2.149683;
		double actualEma = average.getNormalizedExpMovingAverage(observationDate, period);
		assertEquals(expectedEma, actualEma, 0.00001);
	}

}
