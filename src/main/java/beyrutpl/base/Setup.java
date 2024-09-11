package beyrutpl.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Setup {
    protected WebDriver driver;
    protected Logger log;

    @BeforeTest
    public void setup(ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
        log = LogManager.getLogger(testName);
        log.info(suiteName + " " + testName);

        DriverManager manager = new DriverManager(log);
        driver = manager.createDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown(){
        log.info("Close browser");
        driver.quit();
    }
}
