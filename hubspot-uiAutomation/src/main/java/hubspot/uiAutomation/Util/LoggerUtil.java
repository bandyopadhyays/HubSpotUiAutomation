package hubspot.uiAutomation.Util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class<?> clz) {
		if(root) {
			return Logger.getLogger(clz);
		} else {
			root = true;
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/appConfig/log4j.properties");
			return Logger.getLogger(clz);
		}
	}

}
