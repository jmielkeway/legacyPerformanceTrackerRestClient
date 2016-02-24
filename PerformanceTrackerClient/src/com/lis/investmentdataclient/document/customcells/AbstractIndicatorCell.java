package com.lis.investmentdataclient.document.customcells;

import java.sql.Date;
import java.time.LocalDate;

import com.lis.investmentdataclient.drawingtools.colorbased.BackgroundColor;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.PrintableTechnicalIndicator;
import com.lis.investmentdataclient.model.Trackable;

public abstract class AbstractIndicatorCell implements TrackableBasedCell {
	
	private Date observationDate;
	private PrintableTechnicalIndicator indicator;
	private BackgroundColor backgroundColor;
	
	public AbstractIndicatorCell() {
		observationDate = Date.valueOf(LocalDate.now());
	}
	
	@Override
	public BackgroundColor getBackgroundColor() {
		return backgroundColor;
	}
	
	
	@Override
	public void setBackgroundColor(BackgroundColor backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	
	@Override
	public int getColumnWidth() {
		return 1;
	}

	
	@Override
	public String getCellText() {
		return indicator.getIndicatorString();
	}

	
	@Override
	public Font getCellFont() {
		return indicator.getFont();
	}

	
	@Override
	public void setTrackable(Trackable trackable) {
		indicator = setIndicator(trackable, observationDate);
	}
	
	
	protected abstract PrintableTechnicalIndicator setIndicator(Trackable trackable, Date observationDate);
}
