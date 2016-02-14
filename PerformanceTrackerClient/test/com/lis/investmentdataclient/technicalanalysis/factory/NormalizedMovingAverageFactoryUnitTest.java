package com.lis.investmentdataclient.technicalanalysis.factory;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class NormalizedMovingAverageFactoryUnitTest {
	
	Ticker restTicker;
	
	@Before
	public void setUp() throws Exception {
		restTicker = TickerBuilder.getCachedRestTicker();
	}
	
	
	private void doSimpleMovingAverageTest(int period, double expectedValue) {
		Date tradeDate = Date.valueOf("2010-05-03");
		NormalizedMovingAverage snma = NormalizedMovingAverageFactory
				.getSimpleInstance(restTicker, tradeDate, period);
		double actualDouble = snma.getNormalizedMovingAverageValue();
		assertEquals(actualDouble, expectedValue, 0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldCreateDegenerateSimpleMovingAverageBecausePeriodTooLarge() throws Exception {
		doSimpleMovingAverageTest(50000000, 0.00);
	}
	
	
	@Test
	public void shouldCreateSimpleMovingAverage() throws Exception {
		doSimpleMovingAverageTest(50, 1.058435);
	}
	
	
	private void doExponentialMovingAverageTest(int period, double expectedValue) {
		Date tradeDate = Date.valueOf("2008-04-12");
		NormalizedMovingAverage enma = NormalizedMovingAverageFactory
				.getExpInstance(restTicker, tradeDate, period);
		double actualDouble = enma.getNormalizedMovingAverageValue();
		assertEquals(actualDouble, expectedValue, 0.00001);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldCreateDegenerateExpMovingAverageBecausePeriodTooLarge() throws Exception {
		doExponentialMovingAverageTest(9999999, 0.0);
	}
	
	
	@Test
	public void shouldCreateExpMovingAverage() throws Exception {
		doExponentialMovingAverageTest(200, 1.11445);
	}
}
