package pages;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertWindows {

    public WebDriver driver;
    public ElementsMethod elementsMethod;
    public AlertMethods alertMethods;



    public AlertWindows(WebDriver driver) {
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
    }

    public  void dealAlertProcess(){
        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethod.clickElement(firstAlertElement);
        alertMethods.acceptAlert();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethod.clickElement(secondAlert);

        alertMethods.acceptAlert();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethod.clickElement(thirdAlertElement);

        boolean chooseAccept = true;  // pune false daca vrei Cancel
        alertMethods.acceptAlert(chooseAccept);

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        alertMethods.verifyConfirmAlert(actualText, true);

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethod.clickElement(fourthAlertElement);
        alertMethods.fillAlert("Buna ziua");

    }
}
