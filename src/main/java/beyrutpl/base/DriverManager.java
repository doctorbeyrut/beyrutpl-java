package beyrutpl.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private Logger log;
    public DriverManager(Logger log) {
        this.log = log;
    }
    public WebDriver createDriver() {

        log.info("Create Chromedriver");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver.set(new ChromeDriver(options));
        options.addArguments("--disable-search-engine-choice-screen");
        return driver.get();
    }
}
