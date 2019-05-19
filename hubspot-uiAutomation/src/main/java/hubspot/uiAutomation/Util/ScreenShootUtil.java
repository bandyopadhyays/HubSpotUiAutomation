package hubspot.uiAutomation.Util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import hubspot.uiAutomation.TestBase.TestBase;

public class ScreenShootUtil extends TestBase {

	public static String  getScreenShoot(String fileName) {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot sc = (TakesScreenshot) driver;
		File screenShootFile = sc.getScreenshotAs(OutputType.FILE);
		File destinFile = new File(System.getProperty("user.dir") + "\\ExtentReports\\" + fileName + dateName + ".jpg");
		try {
			FileUtils.copyFile(screenShootFile, destinFile);
			// FileUtils.cop

		} catch (Exception e) {

		}
		
		return destinFile.getAbsolutePath();
	}

}
