package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;


    @Test

    public void metodaTest () {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethod = new ElementsMethod(driver);

        WebElement alertMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethod.javaScriptElement(alertMenu);

        WebElement tabButton = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementsMethod.javaScriptElement(tabButton);

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        elementsMethod.clickElement(newTabButton);

        System.out.println("URL-ul paginii curent este " +driver.getCurrentUrl());
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));

        System.out.println("URL-ul paginii curent este " +driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(tabsList.get(0));

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        newWindowElement.click();
        List<String> newWindowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindowList.get(1));



    }
}
