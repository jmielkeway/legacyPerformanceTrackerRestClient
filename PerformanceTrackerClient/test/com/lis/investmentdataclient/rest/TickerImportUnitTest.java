package com.lis.investmentdataclient.rest;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Etf;
import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.testbuilder.TestTickerFactory;

public class TickerImportUnitTest {
	
	Ticker restTicker;
	
	@Before
	public void setUp() throws Exception {
		restTicker = TestTickerFactory.getCachedRestTicker();
	}
	
	@Test
	public void shouldBeEqualEnhancedTickersWithSameSymbol() throws Exception {
		Ticker testTicker = new Etf();
		testTicker.setSymbol("RSP");
		assertEquals(testTicker, restTicker);
	}
	
	
	@Test
	public void restTickerShouldHaveCorrectValuesForFirstPriceRecordObservation() throws Exception {
		assertEquals(Date.valueOf("2006-02-07"), restTicker.getPriceRecords().get(0).getTradeDate());
		assertEquals(170.07, restTicker.getPriceRecords().get(0).getClosePrice(), 0.0001);
		assertEquals(0.0, restTicker.getPriceRecords().get(0).getDividend(), 0.000001);
		assertEquals(1.0, restTicker.getPriceRecords().get(0).getSplitRatio(), 0.00001);
	}
}
