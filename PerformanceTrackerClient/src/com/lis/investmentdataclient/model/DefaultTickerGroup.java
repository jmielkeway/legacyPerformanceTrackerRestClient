package com.lis.investmentdataclient.model;

import java.util.ArrayList;
import java.util.List;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.rest.OrderedTickerProperties;

public class DefaultTickerGroup implements TickerGroup {

	private String groupName;
	private List<Trackable> trackables;
	
	public DefaultTickerGroup(String groupName) {
		this.groupName = groupName;
		trackables = new ArrayList<Trackable>();
		String pathName = groupName.replace(" ", "");
		OrderedTickerProperties props = new OrderedTickerProperties(pathName);
		for (int i = 0; i < props.getNumberOfTickerProperties(); i++)
			addTickersToTrackablesList(props, i);
	}

	
	private void addTickersToTrackablesList(OrderedTickerProperties props, int index) {
		Ticker ticker = props.getTickerFromPropertiesAtIndex(index);
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
