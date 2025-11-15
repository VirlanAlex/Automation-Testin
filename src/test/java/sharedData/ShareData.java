package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ShareData {

    public WebDriver driver;

    @BeforeMethod
    public void setupEnviroment() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void clearEnviroment() {
        driver.quit();
    }
}