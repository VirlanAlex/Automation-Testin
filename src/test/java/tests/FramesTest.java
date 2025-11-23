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
import sharedData.ShareData;

public class FramesTest extends ShareData {
    ElementsMethod elementsMethod;
    FrameMethods frameMethods;

    @Test

    public void metodaTest() {
        //Deschidem un browser

        elementsMethod = new ElementsMethod(getDriver());
        frameMethods = new FrameMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        FramesPage frames = new FramesPage(getDriver());
        frames.clickFramesButton();
        frames.switchFrames("frame1", "frame2");
    }
}