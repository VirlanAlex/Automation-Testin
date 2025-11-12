package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertWindows;
import pages.HomePage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    ElementsMethod elementsMethod;
    AlertMethods alertMethods;


    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethod(driver);
        alertMethods = new AlertMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertWindows alertWindows = new AlertWindows(driver);
        alertWindows.clickAlert();
        alertWindows.dealAlertProcess();

    }
}
