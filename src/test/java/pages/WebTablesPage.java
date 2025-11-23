package pages;

import helpMethods.ElementsMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage extends BasePage {

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> tableContentList;

    @FindBy(id = "addNewRecordButoon")
    private WebElement addElement;

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElement;

    @FindBy(id = "userEmail")
    private WebElement userEmailElement;

    @FindBy(id = "age")
    private WebElement ageElement;

    @FindBy(id = "salary")
    private WebElement salaryElement;

    @FindBy(id = "department")
    private WebElement departmentElement;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> continutTabelNou;

    @FindBy(xpath = "edit-record-4")
    private WebElement editElement;

    @FindBy(xpath = "editFirstNameElement")
    private WebElement editFirstNameElement;

    @FindBy(xpath = "lastName")
    private WebElement editLastNameElement;

    @FindBy(xpath = "userEmail")
    private WebElement editEmailElement;

    @FindBy(xpath = "age")
    private WebElement editAgeElement;

    @FindBy(xpath = "salary")
    private WebElement editSalaryElement;

    @FindBy(xpath = "delete-record-4")
    private WebElement deleteElement;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> continutTabelSters;

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void createProcess() {
        List<WebElement> continutTabel = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        System.out.println(" Dimensiunea tabelului este " + continutTabel.size());
        Assert.assertEquals(continutTabel.size(), 3, " Marimea tabelului nu este 3 ");

        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementsMethod.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Johny";
        elementsMethod.fillElement(firstNameElement, firstName);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Cash";
        elementsMethod.fillElement(lastNameElement, lastName);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmai = "johnycash12n@gmail.com";
        elementsMethod.fillElement(userEmailElement, userEmai);

        WebElement ageElement = driver.findElement(By.id("age"));
        String age = "31";
        elementsMethod.fillElement(ageElement, age);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salary = "5000";
        elementsMethod.fillElement(salaryElement, salary);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String department = "Discogs";
        elementsMethod.fillElement(departmentElement, department);

        WebElement submitButton = driver.findElement(By.id("submit"));
        elementsMethod.clickElement(submitButton);

        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(), 4, "Marimea tabelului nu este 4");

        String continutRand = continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains(firstName), "Randul nu contine first name");
        Assert.assertTrue(continutRand.contains(lastName), "Randul nu contine last name");
        Assert.assertTrue(continutRand.contains(userEmai), "Randul nu contine email");
        Assert.assertTrue(continutRand.contains(age), "Randul nu contine age");
        Assert.assertTrue(continutRand.contains(salary), "Randul nu contine salary");
        Assert.assertTrue(continutRand.contains(department), "Randul nu contine department");
    }

    public void editProcess() {
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
    }

    public void deleteProcess() {
        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        elementsMethod.clickElement(deleteElement);

        List<WebElement> continutTabelSters = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelSters.size(), 3, "Noul tabel nu contine 3 randuri");
    }


}

