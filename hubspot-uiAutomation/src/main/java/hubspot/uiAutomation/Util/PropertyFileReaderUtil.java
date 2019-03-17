package hubspot.uiAutomation.Util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReaderUtil {
	
	private static FileInputStream fis;
	private static Properties prop;
	
	static {
		try {
			prop = new Properties();
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/appConfig/config.properties");
			prop.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
