package com.lis.investmentdataclient.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.jhm.investmentdata.model.PriceRecord;
import com.jhm.investmentdata.model.Ticker;

public class TickerDecorator {
	
	private Ticker ticker;
	private List<PriceRecord> priceRecords;
	private List<Double> adjustedPrices;

	
	public TickerDecorator(Ticker ticker) {
		this.ticker = ticker;
		priceRecords = ticker.getPriceRecords();
		adjustedPrices = new ArrayList<Double>();
		cacheAdjustedPrices();
	}
	
	
	private void cacheAdjustedPrices() {
		adjustedPrices.add(1.0);
		double initialDividendSum = 0.0;
		double initialSplitRatio = 1.0;
		calculateSubsequentAdjustedPrices(1, initialDividendSum, initialSplitRatio);
	}


	private void calculateSubsequentAdjustedPrices(int index, double initialDividendSum,
			double initialSplitRatio) {
		if(index >= priceRecords.size())
			return;
		else
			addAdjustedPricesToCollection(index, initialDividendSum, initialSplitRatio);
	}


	private void addAdjustedPricesToCollection(int index,
			double initialDividendSum, double initialSplitRatio) {
		PriceRecord pr = priceRecords.get(index);
		double closePrice = pr.getClosePrice();
		double splitRatio = initialSplitRatio * pr.getSplitRatio();
		double dividendSum = initialDividendSum + (pr.getDividend() * splitRatio);
		double normalizingDivisor = priceRecords.get(0).getClosePrice();
		double finalValue = (closePrice * splitRatio + dividendSum) / normalizingDivisor;
		adjustedPrices.add(finalValue);
		calculateSubsequentAdjustedPrices(index + 1, dividendSum, splitRatio);
	}


	private PriceRecord getConditionalPriceRecord(Date tradeDate) {
		PriceRecord pr = new PriceRecord();
		pr.setTicker(ticker);
		pr.setTradeDate(tradeDate);
		return pr;
	}
	
	
	private double getClosePriceOn(Date tradeDate) {
		int index = getIndexOfPriceRecordOn(tradeDate);
		double price = priceRecords.get(index).getClosePrice();
		return price;
	}
	
	
	private int getIndexOfPriceRecordOn(Date tradeDate) {
		Date adjustedTradeDate = getAdjustedTradeDate(tradeDate);
		PriceRecord pr = getConditionalPriceRecord(adjustedTradeDate);
		return priceRecords.indexOf(pr);
	}
	
	
	private double getProductOfSplitRatios(Date startDate, Date endDate) {
		int finalIndex = getIndexOfPriceRecordOn(endDate);
		int startIndex = getIndexOfPriceRecordOn(startDate);
		double splitRatioProduct = 1.0;
		for(int i = finalIndex; i > startIndex; i--)
			splitRatioProduct *= priceRecords.get(i).getSplitRatio();
		return splitRatioProduct;
	}
	
	private double getSumOfDividends(Date startDate, Date endDate) {
		int finalIndex = getIndexOfPriceRecordOn(endDate);
		int startIndex = getIndexOfPriceRecordOn(startDate);
		double sumOfDividends = 0.0;
		for(int i = finalIndex; i > startIndex; i--)
			sumOfDividends += (priceRecords.get(i).getDividend() *
					getProductOfSplitRatios(startDate, priceRecords.get(i).getTradeDate()));
		return sumOfDividends;
	}
	
	
	private Date getAdjustedTradeDate(Date tradeDate) {
		PriceRecord pr = getConditionalPriceRecord(tradeDate);
		if (tradeDate.before(priceRecords.get(0).getTradeDate()))
			throw new IllegalArgumentException();
		if (priceRecords.contains(pr))
			return tradeDate;
		else
			return getAdjustedTradeDate(Date.valueOf(tradeDate.toLocalDate().minusDays(1)));
	}
	

	public double getSimpleMovingAverage(Date tradeDate, int period) {
		int finalObservationIndex = getIndexOfPriceRecordOn(tradeDate);
		int startObservationIndex = finalObservationIndex - period;
		double averageSum = 0;
		for (int i = finalObservationIndex; i > startObservationIndex; i--)
			averageSum += (priceRecords.get(i).getClosePrice() / period);
		return averageSum;
	}

	
	public double getReturnBetween(Date startDate, Date endDate) {
		double  startValue = getClosePriceOn(startDate);
		double endValue = getClosePriceOn(endDate) * getProductOfSplitRatios(startDate, endDate)
				+ getSumOfDividends(startDate, endDate);
		return endValue / startValue - 1;
	}


	public double getNormalizedSimpleMovingAverage(Date tradeDate, int period) {
		int finalObservationIndex = getIndexOfPriceRecordOn(tradeDate);
		int startObservationIndex = finalObservationIndex - period;
		double averageSum = 0;
		for (int i = finalObservationIndex; i > startObservationIndex; i--)
			averageSum += (adjustedPrices.get(i) / period);
		return averageSum;
	}

}
