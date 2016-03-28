package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;
import com.lis.investmentdataclient.model.Trackable;

public class SymbolCell implements TrackableBasedCell {

	private Trackable trackable;
	private BackgroundColor backgroundColor;
	
	@Override
	public String getCellText() {
		return trackable.getReferenceName();
	}

	
	@Override
	public Font getCellFont() {
		Font font = new NeutralFont();
		font.setFontSize(9);
		return font;
	}

	
	@Override
	public TrackableBasedCell cloneCell() {
		return new SymbolCell();
	}

	
	@Override
	public void setTrackable(Trackable trackable) {
		this.trackable = trackable;
	}


	@Override
	public int getColumnWidth() {
		return 1;
	}


	@Override
	public BackgroundColor getBackgroundColor() {
		return backgroundColor;
	}


	@Override
	public void setBackgroundColor(BackgroundColor backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
