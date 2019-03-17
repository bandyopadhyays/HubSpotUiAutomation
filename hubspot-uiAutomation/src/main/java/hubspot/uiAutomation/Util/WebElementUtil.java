package hubspot.uiAutomation.Util;

import org.openqa.selenium.WebElement;

public class WebElementUtil {

    public static boolean isElementVisible(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
