package com.orangehrm.pages;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons{

	@FindBy(xpath="//div[@id='logInPanelHeading']")
	private WebElement logInPanelHeading;
	
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement usernameTxtb;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement passwordTxtb;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	private WebElement loginBtn;
	
	public void launchTheApplication() throws IOException {
		Logger = WebDriverClass.getLogger();
		String Url = WebDriverClass.appProperties().getProperty("Url");
		try {
			driver.get(Url);
			Logger.pass("Application Launched");
		}catch(Exception e) {
			Logger.fail("Error while launching the application");
			Logger.addScreenCaptureFromPath(WebCommons.TakeScreenshot(driver, "ApplicationLaunch"));
			Assert.fail("Error while launching the application");
		}		
	}
	
	public void verfiyTitle() throws IOException {
		Logger = WebDriverClass.getLogger();
		try {
			if(getPageTitle().equals("OrangeHRM")) {
				Logger.pass("Applicaton title matched");
			}else {
				Logger.fail("Applicaton title not matched");
				Logger.addScreenCaptureFromPath(WebCommons.TakeScreenshot(driver, "ApplicationTitle"));
				Assert.fail("Applicaton title not matched");
			}
		} catch (Exception e) {
			Logger.fail("Error while Checking the application title");
			Logger.addScreenCaptureFromPath(WebCommons.TakeScreenshot(driver, "ApplicationLaunch"));
			Assert.fail("Error while Checking the application title");
		}
	}
	
	
	public void LoginIntoApplication(String username,String password) throws IOException {
		System.out.println("Credentials"+ username+" === " +password);
		Logger = WebDriverClass.getLogger();
		Logger.info("Credentials :  "+ username+" === " +password);
		try {
			EnterInfo(usernameTxtb,username);
			EnterInfo(passwordTxtb,password);
			Click(loginBtn);
			Logger.pass("Updated username&Password and Application Login is completed");
		} catch (Exception e) {
			Logger.fail("Error while Login into the application");
			Logger.addScreenCaptureFromPath(WebCommons.TakeScreenshot(driver, "AppplicationLogin"));
			Assert.fail("Error while Login into the application");
		}
	}
		
	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}

}
