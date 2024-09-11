package beyrutpl;

import beyrutpl.base.Setup;
import beyrutpl.pages.HomePage;
import beyrutpl.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Setup {

    @Test
    public void loginTest() {

        HomePage home = new HomePage(driver, log);

        home.openPage();

        LoginPage loginPage = home.goToLoginPage();

        loginPage.login("Test", "TESTpass");

        Assert.assertTrue(loginPage.isLogOutButtonVisible(), "Log Out button is not visible");

    }
}
