package hubspot.uiAutomation.Pages;

import hubspot.uiAutomation.TestBase.TestBase;
import hubspot.uiAutomation.Util.LoggerUtil;
import org.apache.log4j.Logger;


public class HomePage extends TestBase {

    // private constructor to prevent class to be inherited
    private HomePage() {
        super();
    }

    private static final Logger log = LoggerUtil.getLogger(HomePage.class);

    public static HomePage getHomePageObject() {
        return new HomePage();
    }







}
