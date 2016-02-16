package com.lis.investmentdataclient.rest;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.lis.investmentdataclient.exception.MisplacedFileException;
import com.opencsv.CSVReader;

public class CsvReaderWrapper {
	
	List<String[]> rows;
	
	public CsvReaderWrapper(String filePath) {
		rows = loadRows(filePath);
	}

	private List<String[]> loadRows(String filePath) {
		try {
			FileReader fileReader = new FileReader(filePath);
			CSVReader reader = new CSVReader(fileReader);
			rows = reader.readAll();
			reader.close();
			return rows;
		}
		catch (IOException ex) {
			throw new MisplacedFileException();
		}
	}
	
	public String getStringLocatedAt(int row, int column) {
		return rows.get(row)[column];
	}
	
	
	public int getNumberOfRows() {
		return rows.size();
	}

}
