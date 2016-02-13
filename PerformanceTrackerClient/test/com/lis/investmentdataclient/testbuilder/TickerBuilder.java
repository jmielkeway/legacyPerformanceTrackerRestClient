package com.lis.investmentdataclient.testbuilder;

import com.jhm.investmentdata.model.Etf;
import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.rest.TickerImport;

public class TickerBuilder {
	
	private static final Ticker restTicker;
	static {
		restTicker = TickerImport.getRestTicker("RSP", Etf.class);
	}
	
	public static Ticker getCachedRestTicker() {
		return restTicker;
	}

}
