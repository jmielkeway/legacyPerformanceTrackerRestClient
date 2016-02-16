package com.lis.investmentdataclient.drawingtools.technicalanalysis.factory;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ReturnIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.factory.StandardIndicators;
import com.lis.investmentdataclient.model.TechnicalTicker;
import com.lis.investmentdataclient.model.Trackable;
import com.lis.investmentdataclient.testbuilder.TickerBuilder;

public class StandardIndicatorsReturnUnitTest {
	
	Trackable trackable;
	Date observationDate;
	
	@Before
	public void setUp() throws Exception {
		Ticker restTicker = TickerBuilder.getCachedRestTicker();
		trackable = new TechnicalTicker(restTicker);
		observationDate = Date.valueOf("2012-10-02");
	}
	
	@Test
	public void shouldReturnDegenerateTenYearReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getTenYearReturn(trackable, observationDate);
		String expectedString = "-";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectFiveYearReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getFiveYearReturn(trackable, observationDate);
		String expectedString = "1.91%";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectThreeYearReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getThreeYearReturn(trackable, observationDate);
		String expectedString = "14.96%";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectOneYearReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getOneYearReturn(trackable, observationDate);
		String expectedString = "28.33%";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectYtdReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getYtdReturn(trackable, observationDate);
		String expectedString = "14.39%";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectThreeMonthReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getThreeMonthReturn(trackable, observationDate);
		String expectedString = "5.88%";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectOneMonthReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getOneMonthReturn(trackable, observationDate);
		String expectedString = "2.85%";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldReturnCorrectOneWeekReturn() throws Exception {
		ReturnIndicator ri = StandardIndicators.getOneWeekReturn(trackable, observationDate);
		String expectedString = "0.27%";
		String actualString = ri.getIndicatorString();
		assertEquals(expectedString, actualString);
	}
}
