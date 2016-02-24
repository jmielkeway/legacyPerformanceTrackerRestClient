package com.lis.investmentdataclient.document.customrows;

import java.util.ArrayList;
import java.util.List;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.document.PdfTableRow;
import com.lis.investmentdataclient.document.customcells.CellPrototype;
import com.lis.investmentdataclient.document.customcells.CellType;
import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Color;
import com.lis.investmentdataclient.model.Trackable;

public class PerformanceAssessmentTableRow implements PdfTableRow {
	
	List<PdfTableCell> cells;
	
	public PerformanceAssessmentTableRow(Trackable trackable, Color color) {
		cells = new ArrayList<PdfTableCell>();
		cells.add(CellPrototype.getCell(CellType.SYMBOL, trackable));
		cells.add(CellPrototype.getCell(CellType.ONE_WEEK_RETURN, trackable));
		cells.add(CellPrototype.getCell(CellType.ONE_MONTH_RETURN, trackable));
		cells.add(CellPrototype.getCell(CellType.THREE_MONTH_RETURN, trackable));
		cells.add(CellPrototype.getCell(CellType.YEAR_TO_DATE, trackable));
		cells.add(CellPrototype.getCell(CellType.ONE_YEAR_RETURN, trackable));
		cells.add(CellPrototype.getCell(CellType.THREE_YEAR_RETURN, trackable));
		cells.add(CellPrototype.getCell(CellType.FIVE_YEAR_RETURN, trackable));
		cells.add(CellPrototype.getCell(CellType.TEN_YEAR_RETURN, trackable));
		cells.add(CellPrototype.getCell(CellType.TEN_VS_TWENTY, trackable));
		cells.add(CellPrototype.getCell(CellType.TWENTY_VS_THIRTY, trackable));
		cells.add(CellPrototype.getCell(CellType.THIRTY_VS_FIFTY, trackable));
		cells.add(CellPrototype.getCell(CellType.FIFTY_VS_TWO_HUNDRED, trackable));
		for (PdfTableCell cell : cells)
			cell.setBackgroundColor(new BackgroundColor(color));
	}
	

	@Override
	public void addCell(PdfTableCell cell) {
		cells.add(cell);
	}


	@Override
	public PdfTableCell[] getCells() {
		return cells.toArray(new PdfTableCell[cells.size()]);
	}

}
