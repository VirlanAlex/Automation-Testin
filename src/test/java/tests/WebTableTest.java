package tests;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    ElementsMethod elementsMethod;


    @Test

    public void metodaTest() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        elementsMethod = new ElementsMethod(driver);

        WebElement elementsMeniu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethod.clickElement(elementsMeniu);

        WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsMethod.clickElement(webTable);

        List<WebElement> continutTabel = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        System.out.println(" Dimensiunea tabelului este " + continutTabel.size());
        Assert.assertEquals(continutTabel.size(), 3, " Marimea tabelului nu este 3 ");

// Definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementsMethod.clickElement(addElement);

// First Name
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        elementsMethod.fillElement(firstNameElement, "Johny");

// Last Name
        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        elementsMethod.fillElement(lastNameElement, "Cash");

// Email
        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        elementsMethod.fillElement(userEmailElement, "johnycash12n@gmail.com");

// Age
        WebElement ageElement = driver.findElement(By.id("age"));
        elementsMethod.fillElement(ageElement, "31");

// Salary
        WebElement salaryElement = driver.findElement(By.id("salary"));
        elementsMethod.fillElement(salaryElement, "5000");

// Department
        WebElement departmentElement = driver.findElement(By.id("department"));
        elementsMethod.fillElement(departmentElement, "Discogs");

        WebElement submitButton = driver.findElement(By.id("submit"));
        elementsMethod.clickElement(submitButton);

//      Validam noua dimensiune a tabelului

        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(), 4, "Marimea tabelului nu este 4");

//       Validam valorile pe care le-am introdus

        String continutRand = continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains("Johny"), "Randul nu contine first name");
        Assert.assertTrue(continutRand.contains("Cash"), "Randul nu contine last name");
        Assert.assertTrue(continutRand.contains("johnycash12n@gmail.com"), "Randul nu contine email");
        Assert.assertTrue(continutRand.contains("31"), "Randul nu contine age");
        Assert.assertTrue(continutRand.contains("5000"), "Randul nu contine salary");
        Assert.assertTrue(continutRand.contains("Discogs"), "Randul nu contine department");

        //Functionalitate de edit

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementsMethod.clickElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        editFirstNameElement.clear();
        elementsMethod.fillElement(editFirstNameElement, "John");

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        editLastNameElement.clear();
        elementsMethod.fillElement(editLastNameElement, "Smith");

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        editEmailElement.clear();
        elementsMethod.fillElement(editEmailElement, "johnysmithasd2@conver.com");

        WebElement editAgeElement = driver.findElement(By.id("age"));
        editAgeElement.clear();
        elementsMethod.fillElement(editAgeElement, "50");

        WebElement submitButton2Button = driver.findElement(By.id("submit"));
        elementsMethod.clickElement(submitButton2Button);

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementsMethod.clickElement(deleteElement);

        List<WebElement> continutTabelSters = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelSters.size(), 3, "Noul tabel nu contine 3 randuri");

        //Daca vreti sa identificati un elemeent dupa text puteti face asta doar cu 'XPath'.
        //CSS Selector nu permite acest lucru
        //XPath are o structura specifica: tag, atribut, valoare

//        driver.close();

    }
}
