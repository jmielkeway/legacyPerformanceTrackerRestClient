package com.lis.investmentdataclient.technicalanalysis.factory;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.technicalanalysis.ReturnIndicator;
import com.lis.investmentdataclient.technicalanalysis.factory.ReturnIndicatorFactory;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class ReturnIndicatorFactoryUnitTest {
	
	Ticker restTicker;
	
	@Before
	public void setUp() throws Exception {
		restTicker = TickerBuilder.getCachedRestTicker();
	}
	
	@Test
	public void shouldCreateDegenerateReturnIndicator() throws Exception {
		Date startDate = Date.valueOf("1800-01-07");
		Date endDate = Date.valueOf("2007-06-05");
		ReturnIndicator returnIndicator = ReturnIndicatorFactory.getInstance(restTicker, startDate, endDate);
		String expectedString = "-";
		String actualString = returnIndicator.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldCreateRegularReturnIndicatorWithCorrectReturnString() throws Exception {
		Date startDate = Date.valueOf("2010-05-23");
		Date endDate = Date.valueOf("2010-09-19");
		ReturnIndicator returnIndicator = ReturnIndicatorFactory.getInstance(restTicker, startDate, endDate);
		String expectedString = "4.45%";
		String actualString = returnIndicator.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldCreateRegularReturnIndicatorWithCorrectAnnualizeReturnString() throws Exception {
		Date startDate = Date.valueOf("2006-11-17");
		Date endDate = Date.valueOf("2009-11-17");
		ReturnIndicator returnIndicator = ReturnIndicatorFactory.getInstance(restTicker, startDate, endDate);
		String expectedString = "-4.85%";
		String actualString = returnIndicator.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
}
