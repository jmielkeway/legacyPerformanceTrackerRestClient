package com.lis.investmentdataclient.technicalanalysis;

public class RegularReturnIndicatorUnitTest
		extends AbstractRetrurnIndicatorUnitTest {

	@Override
	protected ReturnIndicator getReturnIndicator() {
		double investmentReturnValue = .33178;
		return new RegularReturnIndicator(investmentReturnValue);
	}

	@Override
	protected String expectedReturnString() {
		return "33.18%";
	}
}
