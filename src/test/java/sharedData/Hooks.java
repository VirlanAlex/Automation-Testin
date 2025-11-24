package sharedData;

import loggerUtility.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends ShareData {

    public LoggerUtility loggerUtility = new LoggerUtility();

    @BeforeMethod
    public void prepareEnvironment(){
        setupEnvironment();
        loggerUtility.startTest("AlertTest");
    }
    @AfterMethod
    public void clearEnvironment(){
        quitEnvironment();
        loggerUtility.finishTest("AlertTest");
    }
}
