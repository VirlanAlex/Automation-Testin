package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;
    ElementsMethod elementsMethod;

    @Test

    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethod = new ElementsMethod(driver);

        WebElement framesMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(framesMeniu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementsMethod.clickElement(tabButton);

        driver.switchTo().frame("frame1");
        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");
        WebElement sampleTextElement1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement1.getText());

    }
}