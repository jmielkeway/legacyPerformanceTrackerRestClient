package com.lis.investmentdataclient.model;

import com.jhm.investmentdata.model.Ticker;

public interface OrderedListOfTickers {

	
	public Ticker getTickerAtIndex(int index);
	
	public int getNumberOfTickers();
	
}
