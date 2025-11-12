package pages;

import helpMethods.ElementsMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTableSubMenu;

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWebTable(){elementsMethod.javaScriptElement(webTableSubMenu);
    }
}
