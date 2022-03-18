package com.MyStore.utility;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter; //this is depreciated later version 4.0
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentManager {
		
		public static ExtentSparkReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		
		public static void setExtent() throws IOException {
			
			htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			//either you can use below commented code or extent-config.xml file as in later version of extent reports tis xml file is not necessary.
			//htmlReporter.config().setDocumentTitle("Automation Test Report"); 
			//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
			//htmlReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("HostName", "MyHost");
			extent.setSystemInfo("ProjectName", "MyStoreProject");
			extent.setSystemInfo("Tester", "Geeta");
			extent.setSystemInfo("OS", "Win10");
			extent.setSystemInfo("Browser", "Chrome");
		}
		//this s to closethe report at the end
		public static void endReport() {
			extent.flush();
		}
	}
