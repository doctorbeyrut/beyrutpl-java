package beyrutpl.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HomePage {

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("loginBtn");
    private By logOutBtn = By.id("logout_btn");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void login(String username, String password) {
        log.info("Logging in with user credentials");
        type(username, usernameField);
        type(password, passwordField);
        press(loginBtn);
    }
    public boolean isLogOutButtonVisible() {
        return locate(logOutBtn).isDisplayed();
    }
}
