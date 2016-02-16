package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ReturnIndicator;

public abstract class AbstractRetrurnIndicatorUnitTest {
	
	protected abstract ReturnIndicator getReturnIndicator();
	
	protected abstract String expectedReturnString();
	
	protected abstract Font getExpectedFont();
	
	@Test
	public void returnIndicatorShouldHaveExpectedReturnStringAndFontType() throws Exception {
		String expectedReturnString = expectedReturnString();
		String actualReturnString = getReturnIndicator().getIndicatorString();
		assertEquals(expectedReturnString, actualReturnString);
		assertEquals(getExpectedFont(), getReturnIndicator().getFont());
	}

}
