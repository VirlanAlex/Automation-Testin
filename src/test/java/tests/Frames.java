package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;

    @Test

    public void metodaTest() {
        //Deschidem un browser

        driver = new ChromeDriver();

        //Accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement framesMeniu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));

        js.executeScript("arguments[0].click();", framesMeniu);
        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Frames']"));
        tabButton.click();

        driver.switchTo().frame("frame1");
        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");
        WebElement sampleTextElement1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement1.getText());

    }
}