package com.lis.investmentdataclient.document.customtables;

import java.util.ArrayList;
import java.util.List;

import com.lis.investmentdataclient.document.ElementVisitor;
import com.lis.investmentdataclient.document.PdfTable;
import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.document.customrows.PerformanceAssessmentTableRow;
import com.lis.investmentdataclient.document.customrows.PerformanceTableHeaderRow;
import com.lis.investmentdataclient.document.customrows.TitleTableRow;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;
import com.lis.investmentdataclient.model.TickerGroup;
import com.lis.investmentdataclient.model.Trackable;

public class TickerGroupTable implements PdfTable {

	private List<PdfTableRow> rows;
	private TickerGroup tickerGroup;
	
	
	public TickerGroupTable(TickerGroup tickerGroup, Color color) {
		this.tickerGroup = tickerGroup;
		String tableName = tickerGroup.getName() + " Performance Table";
		int columnSpan = 13;
		setUpRowsCollection(tableName, color, columnSpan);
	}
	
	
	private void setUpRowsCollection(String tableName, Color color, int columnSpan) {
		rows = new ArrayList<PdfTableRow>();
		rows.add(new TitleTableRow(tableName, color, columnSpan));
		rows.add(new PerformanceTableHeaderRow());
		addAllPerformanceAssessmentRows();
	}
	
	
	private void addAllPerformanceAssessmentRows() {
		for(int i = 0; i < tickerGroup.getTrackables().length; i++) 
			addRowWithCorrectColor(tickerGroup.getTrackables()[i], i);
	}


	private void addRowWithCorrectColor(Trackable t, int index) {
		Color color = getCellColor(index);
		rows.add(new PerformanceAssessmentTableRow(t, color));
	}


	private Color getCellColor(int index) {
		if(index % 2 == 0)
			return new Color(255, 255, 255);
		else
			return new Color(150, 150, 150);
	}


	@Override
	public PdfTableRow[] getRows() {
		return rows.toArray(new PdfTableRow[rows.size()]);
	}


	@Override
	public double[] getColumnWidths() {
		return new double [] { 
				0.1, .9/12, .9/12,
				.085, .065, .9/12,
				.9/12, .9/12, .9/12,
				.9/12, .9/12, .9/12, 
				.9/12
		};
	}


	@Override
	public void accept(ElementVisitor visitor) {
		visitor.visit(this);
	}


	@Override
	public double getTrailingSpacing() {
		return 0;
	}

}
