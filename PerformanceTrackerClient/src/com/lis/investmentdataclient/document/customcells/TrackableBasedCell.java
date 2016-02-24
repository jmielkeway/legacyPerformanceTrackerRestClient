package com.lis.investmentdataclient.document.customcells;

import com.lis.investmentdataclient.document.PdfTableCell;
import com.lis.investmentdataclient.model.Trackable;

public interface TrackableBasedCell extends PdfTableCell {
	
	public void setTrackable(Trackable trackable);
	
	public TrackableBasedCell cloneCell();
	
}
