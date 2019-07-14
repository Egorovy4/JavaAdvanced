package JavaAdvancedLesson03;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLoggerFile {
	private static Logger LOG = Logger.getLogger(CustomLoggerFile.class);

	public static void main(String[] args) {
		domLogging();
	}
	
	public static void domLogging() {
		DOMConfigurator.configure("loggerConfig.xml");
		LOG.trace("TRACE message");
		LOG.debug("DEBUG message");
		LOG.info("INFO message");
		LOG.warn("WARN message");
		LOG.error("ERROR message");
		LOG.fatal("FATAL message");
	}
}
