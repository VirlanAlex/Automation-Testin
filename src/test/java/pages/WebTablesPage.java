package pages;

import modelObject.WebTableModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    WebTableModel testData = new WebTableModel("src/test/resources/inputData/WebTableResource.json");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }
    public void createProcess(WebTableModel testData) {
        List<WebElement> continutTabel = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        System.out.println(" Dimensiunea tabelului este " + continutTabel.size());
        Assert.assertEquals(continutTabel.size(), 3, " Marimea tabelului nu este 3 ");

        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        elementsMethod.clickElement(addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        elementsMethod.fillElement(firstNameElement, testData.getFirstName());

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        elementsMethod.fillElement(lastNameElement, testData.getLastName());

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        elementsMethod.fillElement(userEmailElement, testData.getEditEmailElement());

        WebElement ageElement = driver.findElement(By.id("age"));
        elementsMethod.fillElement(ageElement, testData.getAge());

        WebElement salaryElement = driver.findElement(By.id("salary"));
        elementsMethod.fillElement(salaryElement, testData.getSalary());

        WebElement departmentElement = driver.findElement(By.id("department"));

        elementsMethod.fillElement(departmentElement, testData.getDepartment());

        WebElement submitButton = driver.findElement(By.id("submit"));
        elementsMethod.clickElement(submitButton);

        List<WebElement> continutTabelNou = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(continutTabelNou.size(), 4, "Marimea tabelului nu este 4");

        String continutRand = continutTabelNou.get(3).getText();
        Assert.assertTrue(continutRand.contains(testData.getFirstName()), "Randul nu contine first name");
        Assert.assertTrue(continutRand.contains(testData.getLastName()), "Randul nu contine last name");
//        Assert.assertTrue(continutRand.contains(testData.getUserEmail()), "Randul nu contine email");
        Assert.assertTrue(continutRand.contains(testData.getAge()), "Randul nu contine age");
        Assert.assertTrue(continutRand.contains(testData.getSalary()), "Randul nu contine salary");
        Assert.assertTrue(continutRand.contains(testData.getDepartment()), "Randul nu contine department");
    }

    public void editProcess() {
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        elementsMethod.clickElement(editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        editFirstNameElement.clear();
        elementsMethod.fillElement(editFirstNameElement, testData.getEditFirstNameElement());

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        editLastNameElement.clear();
        elementsMethod.fillElement(editLastNameElement, testData.getEditLastNameElement());

        WebElement editEmailElement = driver.findElement(By.id("userEmail"));
        editEmailElement.clear();
        elementsMethod.fillElement(editEmailElement, testData.getEditEmailElement());

        WebElement editAgeElement = driver.findElement(By.id("age"));
        editAgeElement.clear();
        elementsMethod.fillElement(editAgeElement, testData.getAge());

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

