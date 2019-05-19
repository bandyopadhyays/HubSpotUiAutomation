package hubspot.uiAutomation.LoginTests;

import hubspot.uiAutomation.Pages.CommonHeader;
import hubspot.uiAutomation.Pages.LoginPage;
import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.ExcelUtil;
import hubspot.uiAutomation.Util.LoggerUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import static hubspot.uiAutomation.Pages.CommonHeader.getCommonHeaderObject;
import static hubspot.uiAutomation.Pages.LoginPage.getLoginPageObject;

public class LoginTests extends TestBase {

	private final Logger log = LoggerUtil.getLogger(LoginTests.class);
	ITestResult result;

	@Test
	public void tc_001_VerifyLoginPageTitle() {
		logger = report.startTest("Login Page Title Validation");
		LoginPage objLoginPage = getLoginPageObject();

		try {
			log.info("Starting Test Case - tc_001_VerifyLoginPageTitle..");
			
			String actualPageTitle = objLoginPage.getLoginPageTitle();
			log.info("Actual Login Page title - " + actualPageTitle + "Expected is - " + "HubSpot Login");
			Assert.assertEquals(actualPageTitle, "HubSpot Login");
			logger.log(LogStatus.PASS, "Login Page title validated successfully");
		
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}

	@Test
	public void tc_002_LoginWithValidCredentials() {
		logger = report.startTest("Login With Valid Credentials");
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
			
			logger.log(LogStatus.PASS,"Login Success!!");
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.setStatus(ITestResult.FAILURE);
		}
	}

}
