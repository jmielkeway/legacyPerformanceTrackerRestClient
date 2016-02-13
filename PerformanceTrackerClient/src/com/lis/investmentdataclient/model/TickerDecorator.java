package com.lis.investmentdataclient.model;

import java.sql.Date;
import java.util.List;

import com.jhm.investmentdata.model.PriceRecord;
import com.jhm.investmentdata.model.Ticker;

public class TickerDecorator {
	
	private Ticker ticker;

	public TickerDecorator(Ticker ticker) {
		this.ticker = ticker;
	}
	
	
	private PriceRecord getConditionalPriceRecord(Date tradeDate) {
		PriceRecord pr = new PriceRecord();
		pr.setTicker(ticker);
		pr.setTradeDate(tradeDate);
		return pr;
	}
	
	
	private double getClosePriceOn(Date tradeDate) {
		int index = getIndexOfPriceRecordOn(tradeDate);
		double price = ticker.getPriceRecords().get(index).getClosePrice();
		return price;
	}
	
	
	private int getIndexOfPriceRecordOn(Date tradeDate) {
		Date adjustedTradeDate = getAdjustedTradeDate(tradeDate);
		PriceRecord pr = getConditionalPriceRecord(adjustedTradeDate);
		return ticker.getPriceRecords().indexOf(pr);
	}
	
	
	private double getProductOfSplitRatios(Date startDate, Date endDate) {
		int finalIndex = getIndexOfPriceRecordOn(endDate);
		int startIndex = getIndexOfPriceRecordOn(startDate);
		double splitRatioProduct = 1.0;
		for(int i = finalIndex; i > startIndex; i--)
			splitRatioProduct *= ticker.getPriceRecords().get(i).getSplitRatio();
		return splitRatioProduct;
	}
	
	private double getSumOfDividends(Date startDate, Date endDate) {
		List<PriceRecord> priceRecords = ticker.getPriceRecords();
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
		if (tradeDate.before(ticker.getPriceRecords().get(0).getTradeDate()))
			throw new IllegalArgumentException();
		if (ticker.getPriceRecords().contains(pr))
			return tradeDate;
		else
			return getAdjustedTradeDate(Date.valueOf(tradeDate.toLocalDate().minusDays(1)));
	}
	

	public double getSimpleMovingAverage(Date tradeDate, int period) {
		int finalObservationIndex = getIndexOfPriceRecordOn(tradeDate);
		int startObservationIndex = finalObservationIndex - period;
		double averageSum = 0;
		for (int i = finalObservationIndex; i > startObservationIndex; i--)
			averageSum += (ticker.getPriceRecords().get(i).getClosePrice() / period);
		return averageSum;
	}

	
	public double getReturnBetween(Date startDate, Date endDate) {
		double  startValue = getClosePriceOn(startDate);
		double endValue = getClosePriceOn(endDate) * getProductOfSplitRatios(startDate, endDate)
				+ getSumOfDividends(startDate, endDate);
		return endValue / startValue - 1;
	}

}
