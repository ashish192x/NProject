package com.orangehrm.framework.webdriver;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.utilities.ReadDataFromExcel;
import com.orangehrm.framework.utilities.ReadDataFromPropertyFile;

public class WebDriverClass {
	
	protected WebDriver driver;
	public static ExtentReports extent = null;  // initialize report
	public static ExtentTest logger = null;
	public static ThreadLocal<WebDriver> driversession = new ThreadLocal<WebDriver>(); //variable to maintain  driver session 
	
	//Method to generate Html report
	@BeforeSuite
	public void setupReport() {
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Reports\\AutomationReport_"+WebCommons.generateUniqueID()+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("User", "ASHISH");
		extent.setSystemInfo("Project", "OrangeHRM");
	}
	
	//Method to start printing the events of test case
	public static void initiateTestCaseReporting(String testcasename) {
		logger=extent.createTest(testcasename);
	}
	
	public static ExtentTest getLogger() {
		return logger;
	}
	
	//Method to read data from Config.properties file
	public static Properties appProperties() {
		Properties prop = ReadDataFromPropertyFile.readProperties(System.getProperty("user.dir") +"\\Config\\Config.properties");
		return prop;
	}
		
	//Method to Launch the Browser and Maximize the Browser
	@BeforeMethod
	@Parameters("browser")
	public void SetupBrowser(String browsername) {
		
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();	
			setDriver(driver);
		}else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
			setDriver(driver);
		}
		driver.manage().window().maximize();
	}
	
	//Method to close the Browser
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		extent.flush();
	}
	
	//Method to set driver session details in 'driver session' variable
	public synchronized static void setDriver(WebDriver driver) {
		driversession.set(driver);
	}
	
	//Method to pass driver session in all other classes-whenever it's required
	public synchronized static WebDriver getDriver() {
		return driversession.get();
	}
	
	//Method to read data from Test Data File
	@DataProvider (name= "data")
	public Object[][] testData() {
		Object[][] data = new ReadDataFromExcel().getExcelData(System.getProperty("user.dir") +"\\TestData\\TestData.xlsx", "Data");
		return data;
	}	
	
	@DataProvider (name= "LogoutData")
	public Object[][] testData2() {
		Object[][] data = new ReadDataFromExcel().getExcelData(System.getProperty("user.dir") +"\\TestData\\TestData.xlsx", "Logout");
		return data;
	}	

}
