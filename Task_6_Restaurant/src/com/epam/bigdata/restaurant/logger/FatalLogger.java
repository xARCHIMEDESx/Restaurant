package com.epam.bigdata.restaurant.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class FatalLogger {

	private static final Logger LOG = Logger.getLogger(FatalLogger.class.getSimpleName());
	
	public FatalLogger(String message) {
		DOMConfigurator.configure("log4j.xml");
		LOG.fatal(message);
	}
}
