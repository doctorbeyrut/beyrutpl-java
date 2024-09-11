package beyrutpl.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    protected WebDriver driver;
    protected Logger log;
    private By navLinkSelenium = By.id("selenium_btn");
    private By navLinkApi = By.id("api_btn");
    private By navLinkPhp = By.id("php_btn");
    private By navLinkLogin = By.id("login_btn");
    private String url = "https://beyrut.pl";

    public HomePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }
    protected WebElement locate(By locator) {
        return driver.findElement(locator);
    }
    public void openPage() {
        log.info("Opening: " + url);
        driver.get(url);
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
    public void goToSeleniumPage() {
        press(navLinkSelenium);
        log.info("Opening Selenium Page");
    }
    public void goToApiPage() {
        press(navLinkApi);
        log.info("Opening Api Page");
    }
    public void goToPhpPage() {
        press(navLinkPhp);
        log.info("Opening Php Page");
    }
    public LoginPage goToLoginPage() {
        press(navLinkLogin);
        log.info("Opening Login Page");
        return new LoginPage(driver, log);
    }
}
