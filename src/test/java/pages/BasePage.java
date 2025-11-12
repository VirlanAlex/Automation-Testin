package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;
    public ElementsMethod elementsMethod;
    public AlertMethods alertMethods;
    public FrameMethods frameMethods;
    public TabMethods tabMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementsMethod = new ElementsMethod(this.driver);
        alertMethods = new AlertMethods(this.driver);
        frameMethods = new FrameMethods(this.driver);
        tabMethods = new TabMethods(this.driver);
    }
}
