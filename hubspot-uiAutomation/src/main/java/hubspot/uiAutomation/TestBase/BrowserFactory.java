package hubspot.uiAutomation.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static hubspot.uiAutomation.Util.LoggerUtil.getLogger;

public class BrowserFactory {

    private static WebDriver driver;
    private static final Logger log = getLogger(BrowserFactory.class);

    private BrowserFactory() {
        // prevent to create object of this class
        // prevent calss to be inherited
    }

    public static WebDriver getDriverObjecct(String browser) {
        driver = getWebDriverInstancce(browser);
        return driver;
    }

    private static WebDriver getWebDriverInstancce(String browser){

        if(browser.equalsIgnoreCase("chrome")) {
            log.info("Intitializing Chrome driver..");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/driverServer/chromedriver.exe");
            return new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            log.info("Intitializing FireFox driver..");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/driverServer/geckodriver.exe");
            return new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            log.info("Intitializing Edge driver..");
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/main/resources/driverServer/MicrosoftWebDriver.exe");
            return new EdgeDriver();
        }
        else {
            log.info("Unable to Initialize driver..");
            return null;
        }
    }


}
