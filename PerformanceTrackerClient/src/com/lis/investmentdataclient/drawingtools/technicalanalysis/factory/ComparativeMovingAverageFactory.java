package com.lis.investmentdataclient.drawingtools.technicalanalysis.factory;

import com.lis.investmentdataclient.drawingtools.technicalanalysis.ComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.DegenerateComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.DegenerateMovingAverage;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.ExpNormalizedMovingAverage;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.MovingAverageVisitor;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.NormalizedMovingAverage;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.RegularComparativeMovingAverageIndicator;
import com.lis.investmentdataclient.drawingtools.technicalanalysis.SimpleNormalizedMovingAverage;

public class ComparativeMovingAverageFactory implements MovingAverageVisitor{
	
	private ComparativeMovingAverageIndicator cmai;
	private NormalizedMovingAverage shorter;
	private NormalizedMovingAverage longer;

	public static ComparativeMovingAverageIndicator getInstance(
			NormalizedMovingAverage shorter, NormalizedMovingAverage longer) {
		ComparativeMovingAverageFactory factory = new ComparativeMovingAverageFactory();
		factory.shorter = shorter;
		factory.longer = longer;
		longer.accept(factory);
		return factory.cmai;
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
