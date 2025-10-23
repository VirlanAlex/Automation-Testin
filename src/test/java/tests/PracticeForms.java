package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.io.File;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class PracticeForms {

    public WebDriver driver;


    @Test

    public void metodaTest() {

        //Deschidem un browser

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Accesam un URL

        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement formsMeniu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsMeniu.click();

        WebElement practiceForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceForm.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstName = "Johny";
        firstNameElement.sendKeys(firstName);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastName = "Cash";
        lastNameElement.sendKeys(lastName);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmail = "johnycash12n@gmail.com";
        userEmailElement.sendKeys(userEmail);

        WebElement mobileElement = driver.findElement(By.id("userNumber"));
        String mobile = "0745213252";
        mobileElement.sendKeys(mobile);

//        Date of birth interaction

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect=new Select(monthElement);
        String monthValue = "January";
        monthSelect.selectByVisibleText(monthValue);

        WebElement yearElement = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect=new Select(yearElement);
        String yearValue = "2030";
        yearSelect.selectByVisibleText(yearValue);

        String dayValue = "15";
        List<WebElement> daysList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--0') and not(contains(@class,'outside-month'))]"));
        for (int index=0;index<daysList.size();index++){
            if (daysList.get(index).getText().equals(dayValue)){
                daysList.get(index).click();
                break;
            }
        }



//        WebElement currentAdressElement = driver.findElement(By.id("currentAddress"));
//        String adress = "Cluj";
//        currentAdressElement.sendKeys(adress);
//
//        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
//        String genderValue = "Male";
//
//        switch (genderValue) {
//            case "Male":
//
//                js.executeScript("arguments[0].click();", genderOptionsList.get(0));
//                break;
//            case "Female":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(1));
//                break;
//            case "Other":
//                js.executeScript("arguments[0].click();", genderOptionsList.get(2));
//                break;
//        }
//
//        WebElement subjectElementField = driver.findElement(By.id("subjectsInput"));
//        String subjectValue = "Accounting";
//        subjectElement.sendKeys(subjectValue);
//        subjectElement.sendKeys(Keys.ENTER);

//        List<String> subjectElements = Arrays.asList("Accounting", "Maths", "English");
//        for (int index = 0; index < subjectElements.size(); index++) {
//            subjectElementField.sendKeys(subjectElements.get(index));
//            subjectElementField.sendKeys(Keys.ENTER);

//        }
//        List<String> hobbiesElements = Arrays.asList("Sports", "Reading");
//        List<WebElement> hobbiesCheckList = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        for (int index = 0; index < hobbiesElements.size(); index++) {
//            js.executeScript("arguments[0].click();", hobbiesCheckList.get(index));
//        }
//        WebElement photoElementField = driver.findElement(By.id("uploadPicture"));
//        File resourcesDirectory = new File("src/test/resources/istockphoto-1313456479-2048x2048.jpg");
//        photoElementField.sendKeys(resourcesDirectory.getAbsolutePath());
//
//// Găsim dropdownul "Select State" și îl aducem în view
//        WebElement stateElement = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,'-placeholder') or contains(@class,'-singleValue')]"));
//        js.executeScript("arguments[0].click();", stateElement);
//
//// Click pe dropdown ca să se deschidă și să apară inputul ascuns
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(stateElement)).click();
//
//// După ce apare inputul React-Select, îl capturăm
//        WebElement stateInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='state']//input[starts-with(@id,'react-select') and @type='text']")
//        ));
//
//// Trimitem valoarea + ENTER
//        stateInputElement.sendKeys("NCR");
//        stateInputElement.sendKeys(Keys.ENTER);
//
////  Găsim dropdownul "Select City" și îl aducem în view
//        WebElement cityElement = driver.findElement(By.xpath("//div[@id='city']//div[contains(@class,'-placeholder') or contains(@class,'-singleValue')]")
//        );
//        js.executeScript("arguments[0].scrollIntoView({block:'center'})", cityElement);
//// adu în viewport + click pe dropdown
//        wait.until(ExpectedConditions.elementToBeClickable(cityElement)).click();
//
//// inputul dinamic pentru City (React-Select)
//        WebElement cityInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='city']//input[starts-with(@id,'react-select') and @type='text']"))
//        );
//
//// Trimitem valoarea + ENTER
//        cityInputElement.sendKeys("Delhi");
//        cityInputElement.sendKeys(Keys.ENTER);
//
////  Trimitem formularul + click
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
//
//        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
//        Assert.assertEquals(thankYouElement.getText(), "Thanks for submitting the form");
//
//        List<WebElement> labelList = driver.findElements(By.xpath("//Table[@class='table table-dark table-striped table-bordered table-hover']//td[1]"));
//        Assert.assertEquals(labelList.get(0).getText(), "Student Name");
//        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
//        Assert.assertEquals(labelList.get(2).getText(), "Gender");
//        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
//        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
//        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
//        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
//        Assert.assertEquals(labelList.get(7).getText(), "Picture");
//        Assert.assertEquals(labelList.get(8).getText(), "Address");
//        Assert.assertEquals(labelList.get(9).getText(), "State and City");
//
//        List<WebElement> valueList = driver.findElements(By.xpath("//Table[@class='table table-dark table-striped table-bordered table-hover']//td[2]"));
//        Assert.assertEquals(valueList.get(0).getText(),firstName+" "+lastName);
//        Assert.assertEquals(valueList.get(1).getText(),userEmail);
//        Assert.assertEquals(valueList.get(2).getText(),genderValue);
//        Assert.assertEquals(valueList.get(3).getText(),mobile);




    }

}


