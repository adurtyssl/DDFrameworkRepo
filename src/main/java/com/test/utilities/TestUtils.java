package com.test.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.test.base.TestBase;

public class TestUtils extends TestBase {
	

	public static String screenshotPath;
	
	public static String captureScreenshot(String screenShotName) {
		
		Date dt = new Date();
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		try {
			FileUtils.copyFile(scrFile, new File(("user.dir")
					+ "\\target\\error-screenshots\\"+ screenShotName + dt +".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenShotName;
		
}
}