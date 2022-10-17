package com.test.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent==null){
			
			
			extent = new ExtentReports(System.getProperty("user.dir")
					+ "\\test-output\\html\\extent-reports\\extentrpt.html", true, DisplayOrder.OLDEST_FIRST);
			
			//Define all the parameters that are displayed in the report using one config file
			extent.loadConfig(new File(System.getProperty("user.dir")+
					"\\src\\main\\resources\\extentconfig\\ExtentReportConfig.xml"));		
		}
		return extent;
	}

}
