package com.lis.investmentdataclient.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TimeZone;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jhm.investmentdata.model.Ticker;

public class TickerImport {

	private static final RestTemplate REST_TEMPLATE;
	private static final String DOMAIN_STRING;
	
	
	static {
		setTimeZoneToGmtToFixJacksonDeserializationIssues();
		REST_TEMPLATE = new RestTemplate();
		Properties props = getPropertiesFromResourceFile();
		DOMAIN_STRING = props.getProperty("domain.leadingString");
	}
	
	private static void setTimeZoneToGmtToFixJacksonDeserializationIssues() {
		TimeZone timeZone = TimeZone.getTimeZone("GMT");
		TimeZone.setDefault(timeZone);
	}
	
	
	private static Properties getPropertiesFromResourceFile() {
		Properties props = new Properties();
		InputStream is = TickerImport.class.getClassLoader().getResourceAsStream("domain.properties");
		attemptToLoadPropertiesFromFile(props, is);
		return props;
	}
	
	
	private static void attemptToLoadPropertiesFromFile(Properties props, InputStream is) {
		try {
			props.load(is);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Properties file not found");
		}
	}
	
	
	public static Ticker getRestTicker(String tickerSymbol, Class<? extends Ticker> assetType) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json;charset=UTF-8");
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		return getRestTickerUsingDomainStringAndRequest(requestEntity, tickerSymbol, assetType);
	}
	
	
	private static Ticker getRestTickerUsingDomainStringAndRequest(HttpEntity<String> requestEntity, 
			String tickerSymbol, Class<? extends Ticker> assetType) {
		String domainString = DOMAIN_STRING + "/tickers/{symbol}";
		ResponseEntity<? extends Ticker> responseEntity = REST_TEMPLATE
				.exchange(domainString, HttpMethod.GET,
						requestEntity, assetType, tickerSymbol);
		Ticker ticker = responseEntity.getBody();
		//fixJacksonSqlDateDeserializationIssues(ticker);
		return ticker;
	}

	
//	private static void fixJacksonSqlDateDeserializationIssues(Ticker ticker) {
//		for (PriceRecord pr : ticker.getPriceRecords())
//			pr.setTradeDate(Date.valueOf(Date.valueOf(pr.getTradeDate().toLocalDate().plusDays(1)).toString()));
//	}
}
