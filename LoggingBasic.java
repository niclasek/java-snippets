import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingBasic {
	
	/* Logger - logs the message, i.e., it creates the log request. It does not publish the message to the destinations.
	 * Handler - Publish the message and also has a level on the messages it outputs.
	 * Formatter - Formats log info.
	 * 
	 * Each logger can have multiple handlers
	 * Each handler has one formatter
	 * */
	
	static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void main(String[] args) {
		//Will log everything that is at a log level equal to or greater than info, i.e., info, warning, severe.
		//You might need to change the level of the handler as well.
		logger.setLevel(Level.INFO);
		
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
		
		myMethod("hello", "world");
	}
	
	private static void myMethod(String a, String b) {
		logger.setLevel(Level.ALL);
		
		//Not a pretty solution for logging the finer level to the System.err 
		ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINER);
        logger.addHandler(handler);
        
		//Logs on Finer level that we are entering in the method and also outputs the parameters
		logger.entering("logging.Main", "main", new Object[] {a,b});
		
		String result = String.join(" ", a, "great", b);
		
		//Logs on Finer level that we are exiting from the method and returns result.
		logger.exiting("logging.Main", "myMethod", result);
	}
}
