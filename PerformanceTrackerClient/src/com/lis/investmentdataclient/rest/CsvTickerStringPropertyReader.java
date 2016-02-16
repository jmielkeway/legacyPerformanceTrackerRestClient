package com.lis.investmentdataclient.rest;

import com.lis.investmentdataclient.global.StaticGlobalProperties;
import com.lis.investmentdataclient.model.TickerStringPropertyReader;

public class CsvTickerStringPropertyReader implements TickerStringPropertyReader{

	private CsvReaderWrapper reader;
	private static final int SYMBOL_COLUMN = 0;
	private static final int TYPE_COLUMN = 1;
	private static final int START_INDEX_ADJUSTEMENT = 1;
	
	public CsvTickerStringPropertyReader(String groupName) {
		String adjustedPathName = groupName.replace(" ", "");
		String fileHeader = StaticGlobalProperties.getTickerPropertiesRoot();
		String completeFilePath = fileHeader + "/" + adjustedPathName + ".csv";
		reader = new CsvReaderWrapper(completeFilePath);
	}

	@Override
	public String getSymbolPropertyAtIndex(int index) {
		int adjustedIndex = index + START_INDEX_ADJUSTEMENT;
		return reader.getStringLocatedAt(adjustedIndex, SYMBOL_COLUMN);
	}

	@Override
	public String getTypePropertyAtIndex(int index) {
		int adjustedIndex = index + START_INDEX_ADJUSTEMENT;
		String leadingString = "com.jhm.investmentdata.model.";
		String typeString = reader.getStringLocatedAt(adjustedIndex, TYPE_COLUMN);
		return leadingString + typeString;
	}

	@Override
	public int getNumberOfTickers() {
		return reader.getNumberOfRows() - START_INDEX_ADJUSTEMENT;
	}

}
