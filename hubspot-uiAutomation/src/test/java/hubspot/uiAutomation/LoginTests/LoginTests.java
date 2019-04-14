package hubspot.uiAutomation.LoginTests;


import com.aventstack.extentreports.ExtentTest;
import hubspot.uiAutomation.Pages.CommonHeader;
import hubspot.uiAutomation.Pages.LoginPage;
import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.ExcelUtil;
import hubspot.uiAutomation.Util.LoggerUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import static hubspot.uiAutomation.Pages.CommonHeader.getCommonHeaderObject;
import static hubspot.uiAutomation.Pages.LoginPage.getLoginPageObject;

public class LoginTests extends TestBase {
	
	private final Logger log = LoggerUtil.getLogger(LoginTests.class);

	public ExtentTest extentLogger;
	ITestResult result;
	
	@Test
	public void tc_001_VerifyLoginPageTitle() {
		extentLogger = report.createTest("Login Page Title Validation");
		LoginPage objLoginPage = getLoginPageObject();

		try {
			extentLogger.info("Starting test case VerifyLoginPageTitle..");
			log.info("Starting Test Case - tc_001_VerifyLoginPageTitle..");
			String actualPageTitle = objLoginPage.getLoginPageTitle();
			log.info("Actual Login Page title - " + actualPageTitle + "Expected is - " + "HubSpot Login");
			extentLogger.info("Actual Login Page title - " + actualPageTitle + "Expected is - " + "HubSpot Login");
			Assert.assertEquals(actualPageTitle, "HubSpot Login");
			extentLogger.pass("Test case passed!!");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.setStatus(2);
			extentLogger.fail(e.getMessage());
		}
	}

	@Test
	public void tc_002_LoginWithValidCredentials() {
		extentLogger = report.createTest("Login With Valid Credentials");
		LoginPage objLoginPage = getLoginPageObject();
		CommonHeader objCommonHeader = getCommonHeaderObject();
		try {
			log.info("Starting Test Case - tc_002_LoginWithValidCredentials..");
			objLoginPage.setEmailId(ExcelUtil.getDataFromExcel("Login", "UserId/Email", 1))
					.setPassword(ExcelUtil.getDataFromExcel("Login", "Password", 1))
					.clickOnLoginBtn();
			objCommonHeader.isSuccessfullLogin();
			objCommonHeader.clickOnLoggedInUserLink()
					.clickOnlogOutLink();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.setStatus(2);
		}
	}
	
}
