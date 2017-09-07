package com.epam.bigdata.restaurant.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class InfoLogger {
	
	private static final Logger LOG = Logger.getLogger(InfoLogger.class.getSimpleName());
	
	public InfoLogger(String message) {
		DOMConfigurator.configure("log4j.xml");
		LOG.info(message);
	}
}
