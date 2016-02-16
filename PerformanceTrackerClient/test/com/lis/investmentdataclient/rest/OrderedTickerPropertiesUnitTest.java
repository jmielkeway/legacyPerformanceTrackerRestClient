package com.lis.investmentdataclient.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Etf;
import com.jhm.investmentdata.model.MutualFund;
import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.model.TickerStringPropertyReader;

public class OrderedTickerPropertiesUnitTest {
	
	OrderedListOfRestTickers list;
	
	@Before
	public void setUp() throws Exception {
		String tickerType = "Market Achievers";
		TickerStringPropertyReader reader = new CsvTickerStringPropertyReader(tickerType);
		list = new OrderedListOfRestTickers(reader);
	}
	
	@Test
	public void shouldHaveCorrectNumberOfStoredTickerProperties() throws Exception {
		assertEquals(4, list.getNumberOfTickers());
	}
	
	@Test
	public void shouldHaveCorrectTickerAtIndex() throws Exception {
		Ticker firstTicker = list.getTickerAtIndex(0);
		Ticker secondTicker = list.getTickerAtIndex(1);
		Ticker thirdTicker = list.getTickerAtIndex(2);
		Ticker fourthTicker = list.getTickerAtIndex(3);
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
