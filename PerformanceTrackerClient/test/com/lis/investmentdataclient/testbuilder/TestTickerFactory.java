package com.lis.investmentdataclient.testbuilder;

import com.jhm.investmentdata.model.Etf;
import com.jhm.investmentdata.model.Stock;
import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.rest.TickerImport;

public class TestTickerFactory {
	
	private static final Ticker restTicker; 
	private static final Ticker stubbedTicker;
	static {
		restTicker = TickerImport.getRestTicker("RSP", Etf.class);
		stubbedTicker = TickerImport.getRestTicker("STUB", Stock.class);
	}
	
	public static Ticker getCachedRestTicker() {
		return restTicker;
	}

	public static Ticker getStubbedTicker() {
		return stubbedTicker;
	}

}
