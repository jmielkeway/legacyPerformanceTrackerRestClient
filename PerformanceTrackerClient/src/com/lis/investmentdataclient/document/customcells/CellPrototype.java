package com.lis.investmentdataclient.document.customcells;

import java.util.EnumMap;
import java.util.Map;

import com.lis.investmentdataclient.model.Trackable;

public class CellPrototype {
	
	private static Map<CellType, TrackableBasedCell> cellMap = 
			new EnumMap<CellType, TrackableBasedCell>(CellType.class);
	
	static {
		cellMap.put(CellType.SYMBOL, new SymbolCell());
		cellMap.put(CellType.ONE_WEEK_RETURN, new OneWeekReturnCell());
		cellMap.put(CellType.ONE_MONTH_RETURN, new OneMonthReturnCell());
		cellMap.put(CellType.THREE_MONTH_RETURN, new ThreeMonthReturnCell());
		cellMap.put(CellType.YEAR_TO_DATE, new YtdReturnCell());
		cellMap.put(CellType.ONE_YEAR_RETURN, new OneYearReturnCell());
		cellMap.put(CellType.THREE_YEAR_RETURN, new ThreeYearReturnCell());
		cellMap.put(CellType.FIVE_YEAR_RETURN, new FiveYearReturnCell());
		cellMap.put(CellType.TEN_YEAR_RETURN, new TenYearReturnCell());
		cellMap.put(CellType.TEN_VS_TWENTY, new TenVsTwentyMovingAverageCell());
		cellMap.put(CellType.TWENTY_VS_THIRTY, new TwentyVsThirtyMovingAverageCell());
		cellMap.put(CellType.THIRTY_VS_FIFTY, new ThirtyVsFiftyMovingAverageCell());
		cellMap.put(CellType.FIFTY_VS_TWO_HUNDRED, new FiftyVsTwoHundredMovingAverageCell());
	}

	public static TrackableBasedCell getCell(CellType key, Trackable trackable) {
		TrackableBasedCell clonedCell = cellMap.get(key).cloneCell();
		clonedCell.setTrackable(trackable);
		return clonedCell;
	}

}
