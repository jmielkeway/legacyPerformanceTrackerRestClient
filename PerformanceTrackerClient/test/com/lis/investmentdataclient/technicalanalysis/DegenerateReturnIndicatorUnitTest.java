package com.lis.investmentdataclient.technicalanalysis;

public class DegenerateReturnIndicatorUnitTest
		extends AbstractRetrurnIndicatorUnitTest {

	@Override
	protected ReturnIndicator getReturnIndicator() {
		return new DegenerateReturnIndicator();
	}

	@Override
	protected String expectedReturnString() {
		return "-";
	}

}
