package pages;

import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends BasePage {

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement frameButton;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void clickFramesButton(){
        elementsMethod.javaScriptElement(frameButton);
    }

    public void switchFrames(String frame1, String frame2){
        frameMethods.switchToSpecificFrame(frame1);
        frameMethods.switchToParentFrame();
        frameMethods.switchToSpecificFrame(frame2);
    }
}
