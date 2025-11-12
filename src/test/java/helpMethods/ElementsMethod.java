package helpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementsMethod {

    private final WebDriver driver;
    private final Duration defaultTimeout = Duration.ofSeconds(10);

    public ElementsMethod(WebDriver driver) {
        this.driver = driver;
    }

    // --- Wait helpers
    private WebDriverWait wait(Duration timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public WebElement waitVisible(By locator) {
        return wait(defaultTimeout).until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public WebElement waitClickable(By locator) {
        return wait(defaultTimeout).until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    // Overload pe WebElement (mai puțin robust – folosește doar dacă trebuie)
    public void waitVisible(WebElement element) {
        wait(defaultTimeout).until(ExpectedConditions.visibilityOf(element));
    }

    // --- Actions
    public void click(By locator) {
        WebElement el = waitClickable(locator);
        try {
            el.click();
        } catch (ElementClickInterceptedException e) {
            // fallback JS click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }

    public void click(WebElement element) {
        waitVisible(element); // minim
        try {
            wait(defaultTimeout).until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void type(By locator, String text) {
        WebElement el = waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }

    public void type(WebElement element, String text) {
        waitVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void jsClick(By locator) {
        WebElement el = waitVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    public void selectByText(By locator, String text) {
        WebElement el = waitVisible(locator);
        if (!"select".equalsIgnoreCase(el.getTagName()))
            throw new IllegalArgumentException("Elementul nu este <select>.");
        new Select(el).selectByVisibleText(text);
    }
}