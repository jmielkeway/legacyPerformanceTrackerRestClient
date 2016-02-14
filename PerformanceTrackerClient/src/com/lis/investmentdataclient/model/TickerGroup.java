package com.lis.investmentdataclient.model;

public interface TickerGroup {
	
	
	public String getName();
	
	public int getNumberOfTrackables();
	
	public Trackable getTrackableByIndexNumber(int index);

}
