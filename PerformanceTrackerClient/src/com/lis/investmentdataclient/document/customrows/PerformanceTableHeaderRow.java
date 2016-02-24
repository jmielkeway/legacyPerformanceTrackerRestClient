package com.lis.investmentdataclient.document.customrows;

import java.util.ArrayList;
import java.util.List;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.document.customcells.GenericCell;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;

public class PerformanceTableHeaderRow implements PdfTableRow {

	List<PdfTableCell> cells;
	
	public PerformanceTableHeaderRow() {
		cells = new ArrayList<PdfTableCell>();
		cells.add(new GenericCell("Symbol"));
		cells.add(new GenericCell("One Week Return"));
		cells.add(new GenericCell("One Month Return"));
		cells.add(new GenericCell("Three Month Return"));
		cells.add(new GenericCell("YTD Return"));
		cells.add(new GenericCell("One Year Return"));
		cells.add(new GenericCell("Three Year Return"));
		cells.add(new GenericCell("Five Year Return"));
		cells.add(new GenericCell("Ten Year Return"));
		cells.add(new GenericCell("10SMA > 20EMA"));
		cells.add(new GenericCell("20EMA > 30EMA"));
		cells.add(new GenericCell("30EMA > 50EMA"));
		cells.add(new GenericCell("50EMA > 200EMA"));
		for(PdfTableCell cell : cells)
			cell.setBackgroundColor(new BackgroundColor(new Color(150,150,150)));
	}

	@Override
	public void addCell(PdfTableCell cell) {
	}

	@Override
	public PdfTableCell[] getCells() {
		return cells.toArray(new PdfTableCell[cells.size()]);
	}
}
