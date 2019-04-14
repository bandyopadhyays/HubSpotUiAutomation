package hubspot.uiAutomation.Pages;

import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.ActionUtil;
import hubspot.uiAutomation.Util.LoggerUtil;
import hubspot.uiAutomation.Util.WebElementUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CommonHeader extends TestBase {

    private static final Logger log = LoggerUtil.getLogger(CommonHeader.class);
    @FindBy(xpath = "//span[@class='account-name ']")
    private WebElement userAccountDropdown;
    @FindBy(xpath = "//a[contains(.,'Sign out')]")
    private WebElement linkLogOut;

    private CommonHeader() {
        super();
    }

    public static CommonHeader getCommonHeaderObject() {
        return new CommonHeader();
    }

    public CommonHeader clickOnLoggedInUserLink() {
        log.info("Moving mouse hover to user profile link..");
        wait.until(ExpectedConditions.elementToBeClickable(userAccountDropdown));
        ActionUtil.moveToElementAndClick(this.userAccountDropdown);
        return this;
    }

    public void isSuccessfullLogin() {
        log.info("Trying to locate user account dropdown ..");
        wait.until(ExpectedConditions.elementToBeClickable(userAccountDropdown));
        Assert.assertTrue(WebElementUtil.isElementVisible(userAccountDropdown));
        log.info("User logged in successfully..");
    }

    public void clickOnlogOutLink() {
        log.info("clicking on logout link..");
        linkLogOut.click();
    }
}
