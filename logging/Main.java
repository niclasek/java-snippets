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
		
		//A more convenient way of logging
		logger.warning("Another way to log a warning message");
		logger.info("An info log message");
		logger.fine("A fine log message");
		
		//Precise logging method
		//It doesn't rely on the call stack for the class and method names
		logger.logp(Level.SEVERE, "logging.Main", "main", "A precise log message");
		
		//Parameterized message methods
		logger.log(Level.INFO, "{0} is my favorite color", "green");
		logger.log(Level.INFO, "{0} is {1} days from {2}", new Object[] {"wed", 2, "Fri"});
	}
}
