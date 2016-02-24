package com.lis.investmentdataclient.document.customrows;

import java.util.ArrayList;
import java.util.List;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.document.customcells.TitleCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;

public class TitleTableRow implements PdfTableRow {

	List<PdfTableCell> cells;
	
	public TitleTableRow(String tableTitle, Color backgroundColor, int columnSpan) {
		cells = new ArrayList<PdfTableCell>();
		PdfTableCell cell = new TitleCell(tableTitle, backgroundColor, columnSpan);
		cells.add(cell);
	}


	@Override
	public void addCell(PdfTableCell cell) {
	}

	
	@Override
	public PdfTableCell[] getCells() {
		return cells.toArray(new PdfTableCell[cells.size()]);
	}
}
