package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private Logger logger = LogManager.getLogger();

//    Meteoda care indica inceperea testului

    public void startTest(String testName) {
        logger.info(" ******* EXECUTION STARTED " + testName + " ********");
    }
//    Medota care logheaza un info

    public void infoLog(String message) {
        logger.info(message);
    }
//    Medota care logheaza un error

    public void errorLog(String message) {
        logger.error(message);
    }
//    Metoda care indica sfarsitul testului

    public void finishTest(String testName) {
        logger.info(" ******* EXECUTION FINISHED " + testName + " ********");
    }
}
