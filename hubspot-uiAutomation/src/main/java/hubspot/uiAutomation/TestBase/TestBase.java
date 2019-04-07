package hubspot.uiAutomation.TestBase;


import hubspot.uiAutomation.Config.ConfigReader;
import hubspot.uiAutomation.Util.LoggerUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static hubspot.uiAutomation.TestBase.BrowserFactory.getDriverObjecct;


public class TestBase {

	public static WebDriver driver;
	private ConfigReader congigObj = new ConfigReader();
	private final static Logger log = LoggerUtil.getLogger(TestBase.class);
	
	protected TestBase() {
		PageFactory.initElements(driver, this);
	}



	private void setUpDriver(String browser) {
		driver = getDriverObjecct(browser);
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
