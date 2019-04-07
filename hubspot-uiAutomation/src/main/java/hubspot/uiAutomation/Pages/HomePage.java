package hubspot.uiAutomation.Pages;

import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.LoggerUtil;
import hubspot.uiAutomation.Util.WebElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends TestBase {

    public HomePage() {
        super();
    }

    private static final Logger log = LoggerUtil.getLogger(HomePage.class);

    @FindBy(xpath = "//span[@class='account-name ']")
    private WebElement userAccountDropdown;

    public void isSuccessfullLogin(){
        log.info("Trying to locate user account dropdown ..");
        Assert.assertTrue(WebElementUtil.isElementVisible(userAccountDropdown));
        log.info("User logged in successfully..");
    }



}
