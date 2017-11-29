import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingFileHandler {

	/* Common built-in handlers
	 * ConsoleHandler
	 * StreamHandler
	 * SocketHandler
	 * FileHandler
	 * */
	
	static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void main(String[] args) {
		
		//Logs to files LoggingHandlers_<number 0-3>.log, the files will rotate using 4 files and each file will 
		//have a maximum size of 1000 bytes 
		try {
			FileHandler fileHandler = new FileHandler("LoggingHandlers_%g.log",1000, 4);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			for(int i = 0; i < 100;i++)
				logger.info("hello world");
			
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
