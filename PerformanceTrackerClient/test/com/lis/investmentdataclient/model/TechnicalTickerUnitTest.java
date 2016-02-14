package com.lis.investmentdataclient.model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class TechnicalTickerUnitTest {
	
	TechnicalTicker technicalTicker;
	
	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TickerBuilder.getCachedRestTicker();
		technicalTicker = new TechnicalTicker(restTicker);
	}

	
	@Test
	public void shouldHaveCorrectReferenceName() throws Exception {
		assertEquals("RSP", technicalTicker.getReferenceName());
	}

	
	@Test
	public void shouldHaveCorrectNormalizedExponentialMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2007-07-16");
		double testMovingAverage = technicalTicker.getNormalizedExpMovingAverage(tradeDate, 20);
		assertEquals(1.238096, testMovingAverage, 0.0001);
	}
	
	
	@Test
	public void shouldHaveCorrectInvestmentReturnValueForOneYear() throws Exception {
		Date startDate = Date.valueOf("2010-11-14");
		Date endDate = Date.valueOf("2011-11-14");
		double tickerReturn = technicalTicker.getAnnualizedReturnBetween(startDate, endDate);
		assertEquals(0.068296, tickerReturn, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectInvestmentReturnValueForOneQuarter() throws Exception {
		Date startDate = Date.valueOf("2012-01-16");
		Date endDate = Date.valueOf("2012-04-16");
		double tickerReturn = technicalTicker.getAnnualizedReturnBetween(startDate, endDate);
		assertEquals(0.058595, tickerReturn, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectInvestmentReturnValueThruSplit() throws Exception {
		Date startDate = Date.valueOf("2006-03-20");
		Date endDate = Date.valueOf("2008-03-20");
		double tickerReturn = technicalTicker.getAnnualizedReturnBetween(startDate, endDate);
		assertEquals(0.00074411, tickerReturn, 0.00000001);
	}
	
	
	@Test
	public void shouldHaveCorrectNormalizedSimpleMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2012-06-27");
		double testNormalizedMovingAverage = technicalTicker.getNormalizedSimpleMovingAverage(tradeDate, 50);
		assertEquals(1.247938, testNormalizedMovingAverage, 0.00001);
	}
	
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void shouldBeOutOfBoundsBecauseSizeTooLarge() throws Exception {
		Date tradeDate = Date.valueOf("2007-10-10");
		double testNormalizedMovingAverage = technicalTicker.getNormalizedSimpleMovingAverage(tradeDate, 1500);
		assertEquals(0.0, testNormalizedMovingAverage, 0.00001);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldIllegalArgumentBecauseDateTooEarly() throws Exception {
		Date startDate = Date.valueOf("1998-12-12");
		Date endDate = Date.valueOf("2008-12-12");
		double tickerReturn = technicalTicker.getAnnualizedReturnBetween(startDate, endDate);
		assertEquals(0.0, tickerReturn, 0.00001);
	}

	
	@Test
	public void shouldIdentifyIfDateIsBeforeInitialObservation() throws Exception {
		Date startDate = Date.valueOf(LocalDate.now());
		Date endDate = Date.valueOf(LocalDate.now().minusYears(10000));
		assertTrue(technicalTicker.isDateBeforeTradable(endDate));
		assertFalse(technicalTicker.isDateBeforeTradable(startDate));
	}
	
	
	@Test
	public void shouldIdentifyIfEnoughObservationsExistToCalculateMovingAverage() throws Exception {
		int validPeriod = 50;
		int invalidPeriod = 50000000;
		Date tradeDate = Date.valueOf("2009-05-17");
		assertTrue(technicalTicker.isPeriodTooLargeForMovingAverageCalculation(invalidPeriod, tradeDate));
		assertFalse(technicalTicker.isPeriodTooLargeForMovingAverageCalculation(validPeriod, tradeDate));
		assertFalse(technicalTicker.isPeriodTooLargeForMovingAverageCalculation(824, tradeDate));
		assertTrue(technicalTicker.isPeriodTooLargeForMovingAverageCalculation(825, tradeDate));
	}

	
	@Test
	public void shouldGetAnnualizedReturnFigure() throws Exception {
		Date startDate = Date.valueOf("2006-11-17");
		Date endDate = Date.valueOf("2009-11-17");
		double annualizedReturn = technicalTicker.getAnnualizedReturnBetween(startDate, endDate);	
		assertEquals(-0.04850, annualizedReturn, 0.00001);
	}
}
