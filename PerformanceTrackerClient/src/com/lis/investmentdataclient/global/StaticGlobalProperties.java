package com.lis.investmentdataclient.global;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.lis.investmentdataclient.exception.MisplacedFileException;


public class StaticGlobalProperties {
	
	private final static Properties ioProperties;
	private final static Properties domainProperties;
	
	
	static {
		ioProperties = new Properties();
		InputStream ioStream = StaticGlobalProperties.class.getClassLoader().getResourceAsStream("io.properties");
		loadProperties(ioProperties, ioStream);
		
		domainProperties = new Properties();
		InputStream domainStream = StaticGlobalProperties.class.getClassLoader().getResourceAsStream("domain.properties");
		loadProperties(domainProperties, domainStream);
	}
	
	private static void loadProperties(Properties props, InputStream is) {
		try {
			props.load(is);
		}
		catch (IOException ex) {
			throw new MisplacedFileException();
		}
	}

	
	public static String getTickerPropertiesRoot() {
		return ioProperties.getProperty("io.tickerPropertiesRoot");
	}
	
	
	public static String getRestDomainString() {
		return domainProperties.getProperty("domain.leadingString");
	}
	
	
}
