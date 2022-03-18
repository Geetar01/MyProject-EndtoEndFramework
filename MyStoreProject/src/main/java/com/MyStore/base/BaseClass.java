package com.MyStore.base;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;	
	import org.apache.commons.io.FileUtils;
	import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;

import com.MyStore.utility.ExtentManager;
import com.MyStore.utility.ReadConfig;
//import io.github.bonigarcia.wdm.WebDriverManager;


	public class BaseClass{
		
		// Declare ThreadLocal Driver this is used for // execution as if 1 tc is failing function is scrrnsht() eexecuting
		public static ThreadLocal<RemoteWebDriver> tsdriver = new ThreadLocal<>();
		//public static WebDriver driver;
		ReadConfig readconfig=new ReadConfig();
		
		public String browserName=readconfig.getBrowserName(); //OR//String bname=prop.getProperty("browser"); directly from property file
		public String baseURL=readconfig.getApplicationURL();
		public String username=readconfig.getUsername();
		public String password=readconfig.getPassword();
		
		
		public static WebDriver getDriver() {
			// Get Driver from threadLocalmap
			return tsdriver.get();
		}
		
		
		//this blck in only for logs 
		@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
		public void beforeSuite() throws IOException
		{
			ExtentManager.setExtent();
			DOMConfigurator.configure("log4j.xml");
		}
		

		//@Parameters("browser")
		//@BeforeClass
		public void initializeDriver()
		{
			//WebDriverManager.chromedriver().setup();
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
				//driver=new ChromeDriver();
				// Set Browser to ThreadLocalMap
				tsdriver.set(new ChromeDriver());
				
			}
			else
			if(browserName.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				//driver=new FirefoxDriver();
				// Set Browser to ThreadLocalMap
				tsdriver.set(new FirefoxDriver());
		
			}
			else
			if(browserName.contains("InternetExplorer"))
			{
			System.setProperty("webdriver.gecko.driver",readconfig.getIEPath());
			//driver=new InternetExplorerDriver();
			// Set Browser to ThreadLocalMap
			tsdriver.set(new InternetExplorerDriver());
			}
			/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(baseURL);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());*/
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			getDriver().get(baseURL);
			getDriver().manage().window().maximize();
			System.out.println(getDriver().getTitle());
			//return driver;
		}
		
		//@AfterMethod(alwaysRun = true)
		public static String captureScreenShot(WebDriver driver1, String testfilename) throws IOException
		{
			//this.driver = driver1;
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot) driver1; 
			//File source = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			System.out.println("000000");
			File source = ts.getScreenshotAs(OutputType.FILE);
			System.out.println("111111111111");
			//File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+ ".png");
			//FileUtils.copyFile(source, target);
			String target=System.getProperty("user.dir")+"\\Screenshots\\" + testfilename+ "_" + dateName + ".png";
			System.out.println("111111111111");
			System.out.println("Screenshot taken");
				FileUtils.copyFile(source,new File(target));
				System.out.println("Screenshot Inserted into folder");
	/*		// This new path for jenkins
			String newImageString = "C:\\Users\\Piyush\\eclipse\\GeetaWorkspace\\MyStoreProject\\Screenshots" + tname + "_"
					+ dateName + ".png";  */
			return target;
		}
		// create 5 character string which would b taken randomly available in "commons lang3" dependencies
		public String randomString()
		{
			String generatedstring= RandomStringUtils.randomAlphabetic(5); 
			return(generatedstring);
		}
		
		// create 5 numeric string which would b taken randomly available in "commons lang3" dependencies
		public static String randomNum()
		{
			String generatedstring2= RandomStringUtils.randomNumeric(4); 
			return(generatedstring2);
		}
		
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})				//this will execute after the end
		public void tearDown()
		{
			getDriver().quit();  //or write tsdriver.quit(); in test classes if we are quitting from test cases not directly from base class
			//driver.close();
		}
		@AfterSuite
		public void afterSuite()
		{
		ExtentManager.endReport();
		}

		
}
