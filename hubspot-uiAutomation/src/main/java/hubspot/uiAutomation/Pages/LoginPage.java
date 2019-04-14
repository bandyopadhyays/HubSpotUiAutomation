package hubspot.uiAutomation.Pages;

import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.LoggerUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TestBase{

	private LoginPage() {
		super();
	}

	private final Logger log = LoggerUtil.getLogger(LoginPage.class);

	public static LoginPage getLoginPageObject() {
		return new LoginPage();
	}

	@FindBy(id = "username")
	private WebElement emailIdtxtBx;
	@FindBy(id = "password")
	private WebElement passwordTxtbx;
	@FindBy(id = "loginBtn")
	private WebElement loginBtn;

	public LoginPage setEmailId(String email) {
		log.info("Setting Email Id - " + email + " ..");
		this.emailIdtxtBx.sendKeys(email);
		return this;
	}

	public LoginPage setPassword(String password) {
		log.info("Setting Password - " + password + " ..");
		this.passwordTxtbx.sendKeys(password);
		return this;
	}

	public void clickOnLoginBtn() {
		log.info("Clicking on login button..");
		this.loginBtn.click();
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
