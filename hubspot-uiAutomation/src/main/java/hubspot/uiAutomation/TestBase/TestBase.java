package hubspot.uiAutomation.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import hubspot.uiAutomation.Config.ConfigReader;
import hubspot.uiAutomation.Util.LoggerUtil;

public class TestBase {

	public static WebDriver driver;
	private ConfigReader congigObj = new ConfigReader();
	private final static Logger log = LoggerUtil.getLogger(TestBase.class);
	
	protected TestBase() {
		PageFactory.initElements(driver, this);
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
	
	private void setUpDriver(String browser) {
		driver = getWebDriverInstancce(browser);
		driver.manage().window().maximize();
		log.info("Navigating to App URL..");
		driver.get(congigObj.getAppURL());
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
	}
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		setUpDriver(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();
	}

}
