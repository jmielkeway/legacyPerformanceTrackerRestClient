package com.lis.investmentdataclient.drawingtools.technicalanalysis;

import com.lis.investmentdataclient.drawingtools.colorbased.Font;
import com.lis.investmentdataclient.drawingtools.colorbased.bias.BullFont;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.RegularReturnIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ReturnIndicator;

public class RegularReturnIndicatorBullishUnitTest
		extends AbstractRetrurnIndicatorUnitTest {

	@Override
	protected ReturnIndicator getReturnIndicator() {
		double investmentReturnValue = .33178;
		return new RegularReturnIndicator(investmentReturnValue);
	}

	@Override
	protected String expectedReturnString() {
		return "33.18%";
	}

	@Override
	protected Font getExpectedFont() {
		return new BullFont();
	}

}
