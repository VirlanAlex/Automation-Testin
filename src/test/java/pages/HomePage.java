package pages;

import helpMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertFrameWindow(){
        elementsMethod.javaScriptElement(alertFrameWindowMenu);
    }

    public void clickElementsMenu(){
        elementsMethod.javaScriptElement(elementsMenu);
    }

}