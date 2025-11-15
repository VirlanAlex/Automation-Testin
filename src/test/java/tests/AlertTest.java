package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertWindows;
import pages.HomePage;
import sharedData.ShareData;

import java.time.Duration;

public class AlertTest extends ShareData {

    ElementsMethod elementsMethod;
    AlertMethods alertsMethods;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethod(driver);
        alertsMethods = new AlertMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertWindows alertsWindows = new AlertWindows(driver);
        alertsWindows.clickAlert();
        alertsWindows.dealAlertProcess();
    }
}