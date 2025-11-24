package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementsMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertWindows;
import pages.HomePage;
import sharedData.Hooks;
import sharedData.ShareData;

import java.time.Duration;

public class AlertTest extends Hooks {

    ElementsMethod elementsMethod;
    AlertMethods alertsMethods;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethod(getDriver());
        alertsMethods = new AlertMethods(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertWindows alertsWindows = new AlertWindows(getDriver());
        alertsWindows.clickAlert();
        alertsWindows.dealAlertProcess();
    }
}