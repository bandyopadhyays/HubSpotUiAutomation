package hubspot.uiAutomation.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import hubspot.uiAutomation.Config.ConfigReader;
import hubspot.uiAutomation.Util.LoggerUtil;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static hubspot.uiAutomation.TestBase.BrowserFactory.getDriverObject;
import static hubspot.uiAutomation.TestBase.BrowserFactory.getWebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public ExtentReports report;
	public ExtentTest logger;
	private ConfigReader congigObj = new ConfigReader();
	private final static Logger log = LoggerUtil.getLogger(TestBase.class);

	protected TestBase() {
		PageFactory.initElements(driver, this);
	}

	private void setUpDriver(String browser) {
		driver = getDriverObject(browser);
		driver.manage().window().maximize();
		log.info("Navigating to App URL..");
		driver.get(congigObj.getAppURL());
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		wait = getWebDriverWait(congigObj.getWaitTime());
	}

	@BeforeSuite
	public void setUpSuite() {
		report = new ExtentReports(new File(System.getProperty("user.dir")) + "/ExtentReports/report.html",true);
		report.loadConfig(new File(System.getProperty("user.dir")+"/src/main/resources/extentReportConfig/extent-config.xml"));
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		setUpDriver(browser);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {		
		
		driver.close();
		driver.quit();
		
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Fails - " + result.getName());
			logger.log(LogStatus.FAIL, "Error - " + result.getThrowable());
		} else if(result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case Skipped - " + result.getName());
		}
		
		report.endTest(logger);
	}
	
	@AfterSuite
	public void endSuite() {
		report.flush();
		report.close();
	}

}
