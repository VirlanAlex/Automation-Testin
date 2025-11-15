package tests;

import helpMethods.ElementsMethod;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import sharedData.ShareData;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest extends ShareData {

    ElementsMethod elementsMethod;
    TabMethods tabMethods;

    @Test

    public void metodaTest() {

        elementsMethod = new ElementsMethod(driver);
        tabMethods = new TabMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethod.javaScriptElement(tabButton);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementsMethod.clickElement(newTabButton);

        tabMethods.switchSpecificTab(1);

        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementsMethod.javaScriptElement(newWindowElement);
        tabMethods.switchSpecificTab(1);
    }
}