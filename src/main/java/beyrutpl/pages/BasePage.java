package beyrutpl.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected Logger log;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }
    protected WebElement locate(By locator) {
        return driver.findElement(locator);
    }
    private void waitFor(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void press(By locator) {
        waitFor(locator);
        locate(locator).click();
    }
    public void type(String text, By locator) {
        waitFor(locator);
        locate(locator).sendKeys(text);
    }
}
