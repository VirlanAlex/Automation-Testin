package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {

    public WebDriver driver;


    @Test

    public void metodaTest() {

        //Deschidem un browser

        driver = new ChromeDriver();

        //Accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

//        wait implicit ( vegheaza asupra codului )
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertMeniu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Alerts']"));
        tabButton.click();

        WebElement firstAlertElement = driver.findElement(By.id("alertButton"));
        firstAlertElement.click();
        Alert firsAlert = driver.switchTo().alert();
        firsAlert.accept();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        secondAlert.click();

//        Wait explicit

        WebDriverWait waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
        Alert secondAlertElement = driver.switchTo().alert();
        System.out.println(secondAlertElement.getText());
        secondAlertElement.accept();

        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        thirdAlertElement.click();
        Alert thirdAlert = driver.switchTo().alert();
        boolean chooseAccept = true;  // pune false daca vrei Cancel
            if(chooseAccept) {
                thirdAlert.accept();
            } else {
                thirdAlert.dismiss();
            }

        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
        String actualText = textThirdAlert.getText();
        if (chooseAccept) {
            Assert.assertEquals(actualText, "You selected Ok");
            System.out.println("User selected OK");
        } else  {
            Assert.assertEquals(actualText, "You selected Cancel");
            System.out.println("User selected Cancel");
        }

//        Alert thirdAlert = driver.switchTo().alert();
//            if (Math.random() > 0.5) {
//                thirdAlert.accept();
//            } else  {
//                thirdAlert.dismiss();
//            }

//        WebElement textThirdAlert = driver.findElement(By.id("confirmResult"));
//        String actualText = textThirdAlert.getText();
//        Assert.assertTrue(actualText.equals("You selected Ok") || actualText.equals("You selected Cancel"), "Unexpected alert result: "+ actualText);

        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        fourthAlertElement.click();
        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys("Hakunamatata");
        fourthAlert.accept();

//        driver.quit();


    }
}
