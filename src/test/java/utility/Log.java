package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	// initialize log4j logs
	public static Logger logger = LogManager.getLogger("async_logger");
	
	// Print log in the beginning of each test case
	public static void startTestCase(String sTestCaseName) {
		 logger.info("Logger name => " + logger.getName() + ", Level set => " + logger.getLevel());
		 logger.info("****************************************************************************************");
		 logger.info("****************************************************************************************");
		 logger.info("$$$$$$$$$                 " + "TC Name: " + sTestCaseName + "       $$$$$$$$$");
		 logger.info("****************************************************************************************");
		 logger.info("****************************************************************************************");
	}
	 
	// Print log in the ending of each test case
	public static void endTestCase(String sTestCaseName) {
		 logger.info("XXXXXXXXXXXXXXXX             " + "E-N-D of Test-Case: " + sTestCaseName + "             XXXXXXXXXXXXXXXX");
	}
	 
	// differ types of global log methods available  
	public static void info(String message) {
		 logger.info(message);
	}
	 
	public static void warn(String message) {
		 logger.warn(message);
	}
	 
	public static void error(String message) {
		 logger.error(message);
	}
	 
	public static void fatal(String message) {
		 logger.fatal(message);
	}
	 
	public static void debug(String message) {
		 logger.debug(message);
	}

}
