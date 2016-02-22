package com.lis.investmentdataclient.model;

import com.lis.investmentdataclient.rest.CsvTickerStringPropertyReader;
import com.lis.investmentdataclient.rest.OrderedListOfRestTickers;

public class DefaultTickerGroupFactory implements AbstractTickerGroupFactory{

	@Override
	public TickerGroup getInstance(String groupName) {
		TickerStringPropertyReader reader = new CsvTickerStringPropertyReader(groupName);
		OrderedListOfTickers listOfTickers = new OrderedListOfRestTickers(reader);
		return new DefaultTickerGroup(groupName, listOfTickers);
	}

}
