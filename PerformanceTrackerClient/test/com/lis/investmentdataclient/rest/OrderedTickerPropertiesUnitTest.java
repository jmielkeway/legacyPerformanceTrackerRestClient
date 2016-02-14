package com.lis.investmentdataclient.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Etf;
import com.jhm.investmentdata.model.MutualFund;
import com.jhm.investmentdata.model.Ticker;

public class OrderedTickerPropertiesUnitTest {
	
	OrderedTickerProperties properties;
	
	@Before
	public void setUp() throws Exception {
		String tickerType = "MarketAchievers";
		properties = new OrderedTickerProperties(tickerType);
	}
	
	@Test
	public void shouldHaveCorrectNumberOfStoredTickerProperties() throws Exception {
		assertEquals(4, properties.getNumberOfTickerProperties());
	}
	
	@Test
	public void shouldHaveCorrectTickerAtIndex() throws Exception {
		Ticker firstTicker = properties.getTickerFromPropertiesAtIndex(0);
		Ticker secondTicker = properties.getTickerFromPropertiesAtIndex(1);
		Ticker thirdTicker = properties.getTickerFromPropertiesAtIndex(2);
		Ticker fourthTicker = properties.getTickerFromPropertiesAtIndex(3);
		assertEquals("RSP", firstTicker.getSymbol());
		assertEquals(Etf.class, firstTicker.getClass());
		assertEquals("FTA", secondTicker.getSymbol());
		assertEquals(Etf.class, secondTicker.getClass());
		assertEquals("CPEAX", thirdTicker.getSymbol());
		assertEquals(MutualFund.class, thirdTicker.getClass());
		assertEquals("SGOVX", fourthTicker.getSymbol());
		assertEquals(MutualFund.class, fourthTicker.getClass());
	}
}
