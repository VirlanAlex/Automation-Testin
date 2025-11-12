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
import sharedData.SharedData;

public class FramesTest extends SharedData {

    ElementsMethod elementsMethod;
    FrameMethods frameMethods;

    @Test
    public void metodaTest() {
        elementsMethod = new ElementsMethod(driver);
        frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        FramesPage frames = new FramesPage(driver);
        frames.clickFramesButton();
        frames.switchFrames("frame1", "frame2");
    }
}