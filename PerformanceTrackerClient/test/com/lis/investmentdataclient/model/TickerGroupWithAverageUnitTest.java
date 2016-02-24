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
		int actualNumber = group.getTrackables().length;
		assertEquals(expectedNumber, actualNumber);
	}
	
	
	@Test
	public void trackableReferenceShouldHaveCorrectProperties() throws Exception {
		Trackable single = group.getTrackables()[2];
		Trackable average = group.getTrackables()[group.getTrackables().length - 1];
		assertEquals("CPEAX", single.getReferenceName());
		assertEquals("Group Average", average.getReferenceName());
	}
}
