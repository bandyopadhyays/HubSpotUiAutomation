package hubspot.uiAutomation.LoginTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import hubspot.uiAutomation.Pages.LoginPage;
import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.ExcelUtil;
import hubspot.uiAutomation.Util.LoggerUtil;

public class LoginTests extends TestBase {
	
	private final Logger log = LoggerUtil.getLogger(LoginTests.class);
	

	@Test
	public void tc_001_VerifyLoginPageTitle() {
		LoginPage objLoginPage = new LoginPage();
		log.info("Starting test cases - " + "tc_001_VerifyLoginPageTitle");
		String pageTitle = objLoginPage.getLoginPageTitle();
		log.info("Found Page Title - " + pageTitle);
		log.info("#Actual Page Tile - " + pageTitle + " #Expected - " + "HubSpot Login");
		Assert.assertEquals(pageTitle, "HubSpot Login");
	}
	@Test
	public void tc_002_LoginWithValidCredentials() throws Exception {
		LoginPage objLoginPage = new LoginPage();
		log.info("Starting test cases - " + "tc_002_LoginWithValidCredentials");		
		objLoginPage.setEmailId(ExcelUtil.getDataFromExcel("Login","UserId/Email",1));
		
		//PageObjects.getLoginPageObject().setEmailId(ExcelUtil.getDataFromExcel("Login","UserId/Email",1));
		//PageObjects.getLoginPageObject().setPassword(ExcelUtil.getDataFromExcel("Login","Password",1));
		//PageObjects.getLoginPageObject().
	}

	
}
