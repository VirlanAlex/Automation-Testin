package pages;

import helpMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    public ElementsMethod elementsMethod;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementsMethod = new ElementsMethod(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowMenu;

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;

    public void clickAlertFrameWindow(){
        elementsMethod.javaScriptElement(alertFrameWindowMenu);
    }

    public void clickElementsMenu(){
        elementsMethod.javaScriptElement(elementsMenu);
    }
}
