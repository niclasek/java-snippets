package logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
	
	static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void main(String[] args) {
		logger.setLevel(Level.INFO); //Will log everything that is at a log level equal to or greater than info, i.e., info, warning, severe
		
		logger.log(Level.WARNING, "A warning log message");
		logger.log(Level.INFO, "An info log message");
		logger.log(Level.FINE, "A fine log message");
	}
}
