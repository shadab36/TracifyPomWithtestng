package com.herokuapp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.lib.TakeScreenshot;
import com.qa.lib.WebElementListener;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base {
	 public static String AppURL;
		public static WebDriver driver;
		public static String browserName;
		public static Logger Log;
		public static EventFiringWebDriver e_driver;
		public static WebDriverEventListener eventListener;
		public static Logger logger;
		public static ExtentTest log;
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		static String nodeURL;
		public static Properties prop;
		
		@BeforeSuite
		public void ReportSetup() throws IOException 
		{
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport1.html");
			extent = new ExtentReports ();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Application Name", "tracify-test");
			extent.setSystemInfo("User Name", "Chhotu");
			extent.setSystemInfo("Envirnoment", "Production");

			htmlReporter.config().setDocumentTitle("tracify-test Automation Testing Report");
			htmlReporter.config().setReportName("tracify-test Automation Testing");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);	
		}

		
		
		{
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/"
						+ "/qa/Config/Conf.properties");
				prop.load(ip);
				logger=Logger.getLogger("Tricfy automation");
				PropertyConfigurator.configure(".\\src\\main\\java\\com\\qa\\Config\\log4j.properties");
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public static void initialization()throws MalformedURLException
		{
			String browserName = prop.getProperty("browser");

			if(browserName.equals("Chrome")){
				WebDriverManager.chromedriver().setup();		
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FireFox")){
				System.setProperty("webdriver.gecko.driver","C:\\Users\\ankur.jain\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}
			else if (browserName.equals("Grid")) {
				nodeURL = "http://10.50.88.59:4444/wd/hub";
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL(nodeURL), capability);
			
			}

			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebElementListener();
			e_driver.register(eventListener);
			driver = e_driver;

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));

		}

		@AfterMethod
		public void getResult(ITestResult result) throws Exception
		{
			if(result.getStatus() == ITestResult.FAILURE)
			{
				//MarkupHelper is used to display the output in different colors
				log.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				log.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

				//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
				//We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 

				//	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
				String screenshotPath = TakeScreenshot.captuerScreenshot(driver, result.getName());
				//To add it in the extent report 

				log.fail("Test Case Failed Snapshot is below " + log.addScreenCaptureFromPath(screenshotPath));


			}
			else if(result.getStatus() == ITestResult.SKIP){
				//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
				log.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
			} 
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				log.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			}

		}
	
		@AfterMethod

		public void Exit() {

			driver.quit();
		}

		@AfterSuite
		public void endReport()
		{
			extent.flush();
		}
	
}

