package hubspot.uiAutomation.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static hubspot.uiAutomation.Util.LoggerUtil.getLogger;

public class BrowserFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final Logger log = getLogger(BrowserFactory.class);

    private BrowserFactory() {
        // prevent to create object of this class
        // prevent class to be inherited
    }

    public static WebDriver getDriverObject(String browser) {
        driver = getWebDriverInstance(browser);
        return driver;
    }

    public static WebDriverWait getWebDriverWait(int timeunitInSecconds) {
        wait = getWaitInstance(timeunitInSecconds);
        return wait;
    }

    private static WebDriver getWebDriverInstance(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {
            log.info("Initializing Chrome driver..");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/driverServer/chromedriver.exe");
            return new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            log.info("Initializing FireFox driver..");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/driverServer/geckodriver.exe");
            return new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            log.info("Initializing Edge driver..");
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/main/resources/driverServer/MicrosoftWebDriver.exe");
            return new EdgeDriver();
        }
        else {
            log.info("Unable to Initialize driver..");
            return null;
        }
    }

    private static WebDriverWait getWaitInstance(int timeunitInSecconds) {
        return new WebDriverWait(driver, timeunitInSecconds);
    }


}
