package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;


    @Test

    public void metodaTest (){

        //Deschidem un browser

        driver=new ChromeDriver();

        //Accesam un URL

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        WebElement elementsMeniu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMeniu.click();

        WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTable.click();

        List<WebElement> continutTabel = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
//        System.out.println("Dimensiunea tabelului este" +continutTabel.size());
        Assert.assertEquals(continutTabel.size(),3,"Marimea tabelului nu este 3");

// Definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

// First Name
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Johny";
        firstNameElement.sendKeys(firstName);

// Last Name
        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Cash";
        lastNameElement.sendKeys(lastName);

// Email
        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmail = "johnycash12n@gmail.com";
        userEmailElement.sendKeys(userEmail);

// Age
        WebElement ageElement = driver.findElement(By.id("age"));
        String age = "31";
        ageElement.sendKeys(age);

// Salary
        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salary = "5000";
        salaryElement.sendKeys(salary);

// Department
        WebElement departmentElement = driver.findElement(By.id("department"));
        String department = "Discogs";
        departmentElement.sendKeys(department);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

//      Validam noua dimensiune a tabelului

        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(),4,"Marimea tabelului nu este 4");

//       Validam valorile pe care le-am introdus

        String continutRand = continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine first name");
        Assert.assertTrue(continutRand.contains(lastName),"Randul nu contine last name");
        Assert.assertTrue(continutRand.contains(userEmail),"Randul nu contine email");
        Assert.assertTrue(continutRand.contains(age),"Randul nu contine age");
        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine salary");
        Assert.assertTrue(continutRand.contains(department),"Randul nu contine department");

        //Functionalitate de edit
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        editElement.click();


        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        editFirstNameElement.clear();
        String editFirstName = "John";
        editFirstNameElement.sendKeys(editFirstName);


        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        editLastNameElement.clear();
        String editLastName = "Smith";
        editLastNameElement.sendKeys(editLastName);

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        editEmailElement.clear();
        String editEmail = "johnysmithasd2@conver.com";
        editEmailElement.sendKeys(editEmail);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        editAgeElement.clear();
        String editAge = "50";
        editAgeElement.sendKeys(editAge);

        WebElement submitButton2Button = driver.findElement(By.id("submit"));
        submitButton2Button.click();

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        List<WebElement> continutTabelSters = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelSters.size(),3, "Noul tabel nu contine 3 randuri");

        //Daca vreti sa identificati un elemeent dupa text puteti face asta doar cu 'XPath'.
        //CSS Selector nu permite acest lucru
        //XPath are o structura specifica: tag, atribut, valoare

//        driver.close();

    }
}
