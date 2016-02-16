package com.lis.investmentdataclient.rest;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.model.OrderedListOfTickers;
import com.lis.investmentdataclient.model.TickerStringPropertyReader;


public class OrderedListOfRestTickers implements OrderedListOfTickers {
	
	private TickerStringPropertyReader reader;

	
	public OrderedListOfRestTickers(TickerStringPropertyReader reader) {
		this.reader = reader;
	}
	
	
	@Override
	public Ticker getTickerAtIndex(int index) {
		String symbol = reader.getSymbolPropertyAtIndex(index);
		String className = reader.getTypePropertyAtIndex(index);
		Class<? extends Ticker> tickerClass = getTickerClass(className);
		return TickerImport.getRestTicker(symbol, tickerClass);
	}
	
	
	@SuppressWarnings("unchecked")
	private Class<? extends Ticker> getTickerClass(String className) {
		try {
			return (Class<? extends Ticker>) Class.forName(className);
		} 
		catch (ClassNotFoundException ex) {
			System.out.println("The programmer is an idiot!");
			throw new IllegalArgumentException();
		}
	}


	@Override
	public int getNumberOfTickers() {
		return reader.getNumberOfTickers();
	}
}
