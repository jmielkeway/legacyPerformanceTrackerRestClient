package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BearFont;

public class RegularReturnIndicatorBearishUnitTest 
	extends AbstractRetrurnIndicatorUnitTest{

	@Override
	protected ReturnIndicator getReturnIndicator() {
		double investmentReturn = -0.04566;
		return new RegularReturnIndicator(investmentReturn);
	}

	@Override
	protected String expectedReturnString() {
		return "-4.57%";
	}

	@Override
	protected Font getExpectedFont() {
		return new BearFont();
	}


}
