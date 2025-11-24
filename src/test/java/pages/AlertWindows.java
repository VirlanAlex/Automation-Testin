package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertWindows extends BasePage {

    public WebDriver driver;
    public ElementsMethod elementsMethod;
    public AlertMethods alertMethods;



    public AlertWindows(WebDriver driver) {
        super(driver);
        this.driver = driver;
        elementsMethod = new ElementsMethod(this.driver);
        alertMethods = new AlertMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alert;

    @FindBy(id = "alertButton")
    private WebElement firstAlertElement;

    @FindBy(id ="timerAlertButton")
    private WebElement secondAlert;

    @FindBy(id = "confirmButton")
    private WebElement thirdAlertElement;

    @FindBy(id = "confirmResult")
    private WebElement textThirdAlert;

    @FindBy(id = "promtButton")
    private WebElement fourthAlertElement;

    public void clickAlert(){
        elementsMethod.javaScriptElement(alert);
        loggerUtility.infoLog(" The user clicks on Alert Submenu");
    }

    public  void dealAlertProcess(){
        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethod.clickElement(firstAlertElement);
        loggerUtility.infoLog(" The user clicks on First Alert Element");
        alertMethods.acceptAlert();
        loggerUtility.infoLog(" The user accept the alert");

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethod.clickElement(secondAlert);
        loggerUtility.infoLog(" The user clicks on Second Alert Element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog(" The user accept the alert");

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethod.clickElement(thirdAlertElement);
        loggerUtility.infoLog(" The user clicks on Second Alert Element Third Aler Element");

        boolean chooseAccept = true;  // pune false daca vrei Cancel
        alertMethods.acceptAlert(chooseAccept);
        loggerUtility.infoLog(" The user accept the alert");

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        alertMethods.verifyConfirmAlert(actualText, true);
        loggerUtility.infoLog(" The user verify if the alert is confirmed ");

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethod.clickElement(fourthAlertElement);
        loggerUtility.infoLog(" The user clicks on the Fourth Alert Element");
        alertMethods.fillAlert("Buna ziua");
        loggerUtility.infoLog(" The user fills the alert displayed");

    }
}
