package com.lis.investmentdataclient.model;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class TickerDecoratorUnitTest {
	
	TickerDecorator testTickerDecorator;
	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TickerBuilder.getCachedRestTicker();
		testTickerDecorator = new TickerDecorator(restTicker);
	}

	@Test
	public void shouldHaveCorrectMovingAverageValues() throws Exception {
		Date tradeDate = Date.valueOf("2007-07-16");
		double testMovingAverage = testTickerDecorator.getSimpleMovingAverage(tradeDate, 20);
		assertEquals(51.758, testMovingAverage, 0.0001);
	}
	
	
	@Test
	public void shouldHaveCorrectInvestmentReturnValue() throws Exception {
		Date startDate = Date.valueOf("2010-11-14");
		Date endDate = Date.valueOf("2011-11-14");
		double tickerReturn = testTickerDecorator.getReturnBetween(startDate, endDate);
		assertEquals(0.068296, tickerReturn, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectInvestmentReturnValueThruSplit() throws Exception {
		Date startDate = Date.valueOf("2006-03-20");
		Date endDate = Date.valueOf("2008-01-03");
		double tickerReturn = testTickerDecorator.getReturnBetween(startDate, endDate);
		assertEquals(0.071411, tickerReturn, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectNormalizedSimpleMovingAverage() throws Exception {
		Date tradeDate = Date.valueOf("2012-06-27");
		double testNormalizedMovingAverage = testTickerDecorator.getNormalizedSimpleMovingAverage(tradeDate, 50);
		assertEquals(1.247938, testNormalizedMovingAverage, 0.00001);
	}

}
