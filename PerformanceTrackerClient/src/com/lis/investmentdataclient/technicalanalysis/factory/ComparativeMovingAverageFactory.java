package com.lis.investmentdataclient.technicalanalysis.factory;

import com.lis.investmentdataclient.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.technicalanalysis.MovingAverageVisitor;
import com.lis.investmentdataclient.technicalanalysis.DegenerateComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.technicalanalysis.DegenerateMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.ExpNormalizedMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.technicalanalysis.RegularComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.technicalanalysis.SimpleNormalizedMovingAverage;

public class ComparativeMovingAverageFactory implements MovingAverageVisitor{
	
	private ComparativeMovingAverageIndicator cmai;
	private NormalizedMovingAverage shorter;
	private NormalizedMovingAverage longer;

	public ComparativeMovingAverageIndicator getInstance(
			NormalizedMovingAverage shorter, NormalizedMovingAverage longer) {
		this.shorter = shorter;
		this.longer = longer;
		longer.accept(this);
		return cmai;
	}

	@Override
	public void visit(DegenerateMovingAverage degenerateMovingAverage) {
		cmai = new DegenerateComparativeMovingAverageIndicator();
	}

	@Override
	public void visit(SimpleNormalizedMovingAverage simpleMovingAverage) {
		cmai = new RegularComparativeMovingAverageIndicator(shorter, longer);
	}

	@Override
	public void visit(ExpNormalizedMovingAverage expMovingAverage) {
		cmai = new RegularComparativeMovingAverageIndicator(shorter, longer);
	}
}
