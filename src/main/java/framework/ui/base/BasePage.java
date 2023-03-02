package framework.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utils.PropertiesLoader.TIMEOUT;

/**
 * class contains common methods for web elements
 */
public class BasePage {
    protected WebDriver driver;
    public BasePage (WebDriver driver) {
        this.driver = driver;
    }


    public void enterText(By elem, String text) {
        getElement(elem).sendKeys(text);
    }
    public void click(By elem) {
        getElement(elem).click();
    }

    public boolean isElementDisplayed(By elem) {
        return getElement(elem).isDisplayed();
    }

    public WebElement getElement(By elem) {
        waitForElementIsPresent(elem);
        return driver.findElement(elem);
    }

    public void waitForElementIsPresent(By elem) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(elem));
        }
        catch (TimeoutException e) {
            throw new AssertionError("Cannot find element :" + elem);
        }

    }
}
