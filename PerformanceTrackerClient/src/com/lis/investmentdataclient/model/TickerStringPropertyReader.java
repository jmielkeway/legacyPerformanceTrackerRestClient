package com.lis.investmentdataclient.model;

public interface TickerStringPropertyReader {
	
	public String getSymbolPropertyAtIndex(int index);
	
	public String getTypePropertyAtIndex(int index);
	
	public int getNumberOfTickers();

}
