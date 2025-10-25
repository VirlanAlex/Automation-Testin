package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;


    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethod = new ElementsMethod(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMeniu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementsMethod.clickElement(tabButton);

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethod.clickElement(firstAlertElement);
        Alert firsAlert = driver.switchTo().alert();
        firsAlert.accept();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementsMethod.clickElement(secondAlert);

        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());

        Alert secondAlertElement = driver.switchTo().alert();
        System.out.println(secondAlertElement.getText());
        secondAlertElement.accept();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethod.clickElement(thirdAlertElement);
        Alert thirdAlert = driver.switchTo().alert();
        boolean chooseAccept = true;  // pune false daca vrei Cancel
        if (chooseAccept) {
            thirdAlert.accept();
        } else {
            thirdAlert.dismiss();
        }

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        if (chooseAccept) {
            Assert.assertEquals(actualText, "You selected Ok");
            System.out.println("User selected OK");
        } else {
            Assert.assertEquals(actualText, "You selected Cancel");
            System.out.println("User selected Cancel");
        }

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethod.clickElement(fourthAlertElement);
        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys("Hakunamatata");
        fourthAlert.accept();

//        driver.quit();


    }
}
