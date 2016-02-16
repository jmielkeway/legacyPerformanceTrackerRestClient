package com.lis.investmentdataclient.model;

import java.util.ArrayList;
import java.util.List;

import com.jhm.investmentdata.model.Ticker;

public class DefaultTickerGroup implements TickerGroup {

	private String groupName;
	private List<Trackable> trackables;
	
	public DefaultTickerGroup(String groupName, OrderedListOfTickers orderedList) {
		this.groupName = groupName;
		trackables = new ArrayList<Trackable>();
		for (int i = 0; i < orderedList.getNumberOfTickers(); i++)
			addTickersToTrackablesList(orderedList, i);
	}

	
	private void addTickersToTrackablesList(OrderedListOfTickers list, int index) {
		Ticker ticker = list.getTickerAtIndex(index);
		TechnicalTicker technicalTicker = new TechnicalTicker(ticker);
		trackables.add(technicalTicker);
	}


	@Override
	public String getName() {
		return groupName;
	}
	
	
	@Override
	public int getNumberOfTrackables() {
		return trackables.size();
	}

	
	@Override
	public Trackable getTrackableByIndexNumber(int index) {
		return trackables.get(index);
	}
}
