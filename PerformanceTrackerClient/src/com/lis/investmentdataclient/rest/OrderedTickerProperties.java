package com.lis.investmentdataclient.rest;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.jhm.investmentdata.model.Ticker;
import com.opencsv.CSVReader;

public class OrderedTickerProperties {
	
	private List<String[]> rows;
	public static final int START_INDEX_ADJUSTMENT = 1;
	private static final int SYMBOL_COLUMN = 0;
	private static final int TICKER_TYPE_COLUMN = 1;

	public OrderedTickerProperties(String tickerType) {
		String filePath = "config/" + tickerType + ".csv";
		initializeCollection(filePath);
	}
	
	
	private void initializeCollection(String filePath) {
		try {
			FileReader fileReader = new FileReader(filePath);
			CSVReader csvReader = new CSVReader(fileReader);
			rows = csvReader.readAll();
			csvReader.close();
		} 
		catch (IOException ex) {
			System.out.println("The programmer is an idiot!");
		}
	}

	
	public int getNumberOfTickerProperties() {
		return rows.size() - START_INDEX_ADJUSTMENT;
	}

	
	public Ticker getTickerFromPropertiesAtIndex(int index) {
		int adjustedIndex = index + START_INDEX_ADJUSTMENT;
		String symbol = rows.get(adjustedIndex)[SYMBOL_COLUMN];
		String className = "com.jhm.investmentdata.model." + rows.get(adjustedIndex)[TICKER_TYPE_COLUMN];
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
}
