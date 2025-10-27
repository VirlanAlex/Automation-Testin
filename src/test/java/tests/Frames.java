package tests;

import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;
    ElementsMethod elementsMethod;
    FrameMethods frameMethods;

    @Test

    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethod = new ElementsMethod(driver);
        frameMethods = new FrameMethods(driver);

        WebElement framesMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(framesMeniu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementsMethod.clickElement(tabButton);

        frameMethods.switchToSpecificFrame("frame1");

        frameMethods.switchToParentFrame();

        frameMethods.switchToSpecificFrame("frame2");

    }
}