package tests;

import helpMethods.ElementsMethod;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.HomePage;

public class FramesTest {
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

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        FramesPage frames = new FramesPage(driver);
        frames.clickFramesButton();
        frames.switchFrames("frame1", "frame2");
    }
}