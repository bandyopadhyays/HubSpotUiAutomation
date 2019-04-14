package hubspot.uiAutomation.Util;

import hubspot.uiAutomation.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil extends TestBase {

    private static Actions actions;

    static {
        actions = new Actions(driver);
    }

    public static void moveToElementAndClick(WebElement element) {
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
    }


}
