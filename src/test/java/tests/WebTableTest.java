package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablesPage;
import sharedData.Hooks;
import sharedData.ShareData;

import java.util.List;

public class WebTableTest extends Hooks {

    ElementsMethod elementsMethod;

    @Test
    public void metodaTest() {

        elementsMethod = new ElementsMethod(getDriver());

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElementsMenu();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        WebTablesPage webTablePage = new WebTablesPage(getDriver());
        webTablePage.createProcess();

        //Functionalitate de edit

        webTablePage.editProcess();
        webTablePage.deleteProcess();

        //Daca vreti sa identificati un elemeent dupa text puteti face asta doar cu 'XPath'.
        //CSS Selector nu permite acest lucru
        //XPath are o structura specifica: tag, atribut, valoare

//        driver.close();

    }
}


// Daca vrem sa identificam un element dupa text putem face asta doar cu XPath.
// CSS Selector nu permite acest lucru.
// XPath are o structura specifica: tag,atribut,valoare
// CTRL + F ca sa deschidem searchul
// formula pentru XPath Relative //h5[text()='Elements']