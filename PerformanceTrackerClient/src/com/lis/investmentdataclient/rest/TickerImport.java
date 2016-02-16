package com.lis.investmentdataclient.rest;

import java.util.TimeZone;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jhm.investmentdata.model.Ticker;
import com.lis.investmentdataclient.global.StaticGlobalProperties;

public class TickerImport {

	private static final RestTemplate REST_TEMPLATE;
	private static final String DOMAIN_STRING;
	
	
	static {
		setTimeZoneToGmtToFixJacksonDeserializationIssues();
		REST_TEMPLATE = new RestTemplate();
		DOMAIN_STRING = StaticGlobalProperties.getRestDomainString();
	}
	
	
	private static void setTimeZoneToGmtToFixJacksonDeserializationIssues() {
		TimeZone timeZone = TimeZone.getTimeZone("GMT");
		TimeZone.setDefault(timeZone);
	}
	
	
	public static Ticker getRestTicker(String tickerSymbol, Class<? extends Ticker> assetType) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json;charset=UTF-8");
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		return getRestTickerUsingHeadersAndRequestEntity(requestEntity, tickerSymbol, assetType);
	}
	
	
	private static Ticker getRestTickerUsingHeadersAndRequestEntity(HttpEntity<String> requestEntity, 
			String tickerSymbol, Class<? extends Ticker> assetType) {
		String restString = DOMAIN_STRING + "/tickers/{symbol}";
		ResponseEntity<? extends Ticker> responseEntity = REST_TEMPLATE
				.exchange(restString, HttpMethod.GET,
						requestEntity, assetType, tickerSymbol);
		Ticker ticker = responseEntity.getBody();
		return ticker;
	}
}
