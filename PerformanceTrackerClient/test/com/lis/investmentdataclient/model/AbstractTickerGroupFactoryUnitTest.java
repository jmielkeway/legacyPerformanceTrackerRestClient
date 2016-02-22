package com.lis.investmentdataclient.model;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class AbstractTickerGroupFactoryUnitTest {
	
	protected String getExpectedGroupName() {
		return "Market Achievers";
	}

	
	protected abstract AbstractTickerGroupFactory getFactory();
	
	protected abstract int getExpectedGroupSize();
	
	
	@Test
	public void shouldHaveCorrectNameForTickerGroup() throws Exception {
		TickerGroup tg = getFactory().getInstance("Market Achievers");
		String expectedName = getExpectedGroupName();
		String actualName = tg.getName();
		assertEquals(expectedName, actualName);
	}
	
	@Test
	public void shouldHaveCorrectGroupSize() throws Exception {
		TickerGroup tg = getFactory().getInstance("Market Achievers");
		int expectedSize = getExpectedGroupSize();
		int actualSize = tg.getNumberOfTrackables();
		assertEquals(expectedSize, actualSize);
	}

}
