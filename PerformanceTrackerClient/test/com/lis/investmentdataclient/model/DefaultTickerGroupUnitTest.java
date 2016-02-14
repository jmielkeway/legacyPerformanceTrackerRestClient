package com.lis.investmentdataclient.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DefaultTickerGroupUnitTest {
	
	DefaultTickerGroup tickerGroup;
	
	
	@Before
	public void setUp() throws Exception {
		String groupName = "Market Achievers";
		tickerGroup = new DefaultTickerGroup(groupName);
	}
	
	
	@Test
	public void shouldHaveTheCorrectGroupName() throws Exception {
		assertEquals("Market Achievers", tickerGroup.getName());
	}
	
	
	@Test
	public void shouldHaveCorrectNumberOfTrackableEntities() throws Exception {
		assertEquals(4, tickerGroup.getNumberOfTrackables());
	}
	
	
	@Test
	public void shouldReturnCorrectTrackableInstance() throws Exception {
		Trackable trackable = tickerGroup.getTrackableByIndexNumber(2);
		assertEquals("CPEAX", trackable.getReferenceName());
	}
}
