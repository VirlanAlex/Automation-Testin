package helpMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

    public WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificFrame(String frame){
        driver.switchTo().frame(frame);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
}
