package com.lis.investmentdataclient.model;

public class DefaultTickerGroupFactoryUnitTest
		extends AbstractTickerGroupFactoryUnitTest {

	@Override
	protected AbstractTickerGroupFactory getFactory() {
		return new DefaultTickerGroupFactory();
	}

	@Override
	protected int getExpectedGroupSize() {
		return 4;
	}
}
