package com.lis.investmentdataclient.model;

import com.lis.investmentdataclient.rest.CsvTickerStringPropertyReader;
import com.lis.investmentdataclient.rest.OrderedListOfRestTickers;

public class TickerGroupWithAverageFactory
		implements AbstractTickerGroupFactory {

	@Override
	public TickerGroup getInstance(String groupName) {
		TickerStringPropertyReader reader = new CsvTickerStringPropertyReader(groupName);
		OrderedListOfTickers list = new OrderedListOfRestTickers(reader);
		return new TickerGroupWithAverage(groupName, list);
	}

}
