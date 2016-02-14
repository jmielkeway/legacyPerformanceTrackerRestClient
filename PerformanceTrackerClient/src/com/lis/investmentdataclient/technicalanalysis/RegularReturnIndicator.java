package com.lis.investmentdataclient.technicalanalysis;

public class RegularReturnIndicator implements ReturnIndicator {
	
	double annualizedReturn;

	public RegularReturnIndicator(double investmentReturnValue) {
		annualizedReturn = investmentReturnValue;
	}

	@Override
	public String getIndicatorString() {
		return String.format("%.2f", annualizedReturn*100) + "%";
	}

}
