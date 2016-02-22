package com.lis.investmentdataclient.model;

public class TickerGroupWithAverageFactoryUnitTest
		extends AbstractTickerGroupFactoryUnitTest {

	@Override
	protected AbstractTickerGroupFactory getFactory() {
		return new TickerGroupWithAverageFactory();
	}

	@Override
	protected int getExpectedGroupSize() {
		return 5;
	}

}
