package hubspot.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.LoggerUtil;

public class LoginPage extends TestBase{

	public LoginPage() {
		super();
		//PageFactory.initElements(driver, this);
	}

	private final Logger log = LoggerUtil.getLogger(LoginPage.class);

	@FindBy(id = "username")
	private WebElement emailIdtxtBx;
	@FindBy(id = "password")
	private WebElement passwordTxtbx;
	@FindBy(id = "loginBtn")
	private WebElement loginBtn;
	
	public void setEmailId(String email) {
		log.info("Setting Email Id - " + email + " ..");
		emailIdtxtBx.sendKeys(email);
	}
	
	public void setPassword(String password) {
		log.info("Setting Password - " + password + " ..");
		passwordTxtbx.sendKeys(password);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
}
