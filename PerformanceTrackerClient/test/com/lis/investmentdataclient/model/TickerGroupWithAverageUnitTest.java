package com.lis.investmentdataclient.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lis.investmentdataclient.rest.CsvTickerStringPropertyReader;
import com.lis.investmentdataclient.rest.OrderedListOfRestTickers;

public class TickerGroupWithAverageUnitTest {
	
	private TickerGroupWithAverage group;
	
	@Before
	public void setUp() throws Exception {
		String groupName = "Market Achievers";
		TickerStringPropertyReader reader = new CsvTickerStringPropertyReader(groupName);
		OrderedListOfTickers list = new OrderedListOfRestTickers(reader);
		group = new TickerGroupWithAverage(groupName, list);
	}
	
	
	@Test
	public void shouldHaveCorrectGroupName() throws Exception {
		String expectedGroupName = "Market Achievers";
		String actualGroupName = group.getName();
		assertEquals(expectedGroupName, actualGroupName);
	}
	
	
	@Test
	public void shouldHaveCorrectNumberOfTrackables() throws Exception {
		int expectedNumber = 5;
		int actualNumber = group.getNumberOfTrackables();
		assertEquals(expectedNumber, actualNumber);
	}
	
	
	@Test
	public void trackableReferenceShouldHaveCorrectProperties() throws Exception {
		Trackable single = group.getTrackableByIndexNumber(2);
		Trackable average = group.getTrackableByIndexNumber(group.getNumberOfTrackables() - 1);
		assertEquals("CPEAX", single.getReferenceName());
		assertEquals("Group Average", average.getReferenceName());
	}
}
