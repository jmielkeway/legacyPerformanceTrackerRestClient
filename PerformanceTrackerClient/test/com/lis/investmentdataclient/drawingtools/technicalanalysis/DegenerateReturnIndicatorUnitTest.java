package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.NeutralFont;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.DegenerateReturnIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ReturnIndicator;

public class DegenerateReturnIndicatorUnitTest
		extends AbstractRetrurnIndicatorUnitTest {

	@Override
	protected ReturnIndicator getReturnIndicator() {
		return new DegenerateReturnIndicator();
	}

	@Override
	protected String expectedReturnString() {
		return "-";
	}

	@Override
	protected Font getExpectedFont() {
		return new NeutralFont();
	}


}
