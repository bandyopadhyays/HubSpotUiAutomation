package hubspot.uiAutomation.TestBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import hubspot.uiAutomation.Config.ConfigReader;
import hubspot.uiAutomation.Util.LoggerUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;

import static hubspot.uiAutomation.TestBase.BrowserFactory.getDriverObject;
import static hubspot.uiAutomation.TestBase.BrowserFactory.getWebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public ExtentReports report;
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
		// driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		wait = getWebDriverWait(congigObj.getWaitTime());
	}

	@BeforeSuite
	public void setUpSuite() {
		ExtentHtmlReporter extentHtmlreports = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/reports/TestRunResult.html"));
		report = new ExtentReports();
		report.attachReporter(extentHtmlreports);
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		setUpDriver(browser);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		// driver.quit();
		report.flush();
	}

}
