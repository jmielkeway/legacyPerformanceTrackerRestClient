package com.lis.investmentdataclient.technicalanalysis;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class AbstractRetrurnIndicatorUnitTest {
	
	protected abstract ReturnIndicator getReturnIndicator();
	
	protected abstract String expectedReturnString();
	
	@Test
	public void returnIndicatorShouldHaveExpectedReturnString() throws Exception {
		String expectedReturnString = expectedReturnString();
		String actualReturnString = getReturnIndicator().getIndicatorString();
		assertEquals(expectedReturnString, actualReturnString);
	}

}
