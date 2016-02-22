package com.lis.investmentdataclient.document.indicatorcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;
import com.lis.investmentdataclient.model.Trackable;

public class SymbolCell implements PdfTableCell {

	private Trackable trackable;
	
	@Override
	public String getCellText() {
		return trackable.getReferenceName();
	}

	@Override
	public Font getCellFont() {
		return new NeutralFont();
	}

	@Override
	public PdfTableCell cloneCell() {
		return new SymbolCell();
	}

	@Override
	public void setTrackable(Trackable trackable) {
		this.trackable = trackable;
	}

}
