package hubspot.uiAutomation.Config;

import hubspot.uiAutomation.Util.PropertyFileReaderUtil;

public class ConfigReader implements AppConfig{

	@Override
	public String getAppURL() {
		return PropertyFileReaderUtil.getProperty("URL");
	}

    @Override
    public int getWaitTime() {
        return Integer.valueOf(PropertyFileReaderUtil.getProperty("ExplicitWaitTime"));
    }

}
