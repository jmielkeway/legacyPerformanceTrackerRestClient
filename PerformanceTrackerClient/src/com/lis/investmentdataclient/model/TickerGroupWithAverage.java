package com.lis.investmentdataclient.model;

import java.util.ArrayList;
import java.util.List;

import com.jhm.investmentdata.model.Ticker;

public class TickerGroupWithAverage implements TickerGroup {
	
	private String groupName;
	private List<Trackable> trackables;
	
	
	public TickerGroupWithAverage(String groupName, OrderedListOfTickers listOfTickers) {
		this.groupName = groupName;
		trackables = new ArrayList<Trackable>();
		for (int i = 0; i < listOfTickers.getNumberOfTickers(); i++)
			addTickersToList(listOfTickers, i);
		addGroupAverageToTrackablesCollection();
	}

	
	private void addTickersToList(OrderedListOfTickers listOfTickers, int index) {
		Ticker t = listOfTickers.getTickerAtIndex(index);
		TechnicalTicker tech = new TechnicalTicker(t);
		trackables.add(tech);
	}
	
	
	private void addGroupAverageToTrackablesCollection() {
		Trackable [] trackableArray = trackables.toArray(new Trackable[trackables.size()]);
		AverageFromMultipleTickers average = new AverageFromMultipleTickers(trackableArray);
		trackables.add(average);
	}


	@Override
	public String getName() {
		return groupName;
	}


	@Override
	public Trackable[] getTrackables() {
		return trackables.toArray(new Trackable[trackables.size()]);
	}
}
