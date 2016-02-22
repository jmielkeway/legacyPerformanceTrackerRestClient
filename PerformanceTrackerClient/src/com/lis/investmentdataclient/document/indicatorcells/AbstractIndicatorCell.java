package com.lis.investmentdataclient.document.indicatorcells;

import java.sql.Date;
import java.time.LocalDate;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.PrintableTechnicalIndicator;
import com.lis.investmentdataclient.model.Trackable;

public abstract class AbstractIndicatorCell implements PdfTableCell {
	
	private Date observationDate;
	private PrintableTechnicalIndicator indicator;
	
	
	public AbstractIndicatorCell() {
		observationDate = Date.valueOf(LocalDate.now());
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
