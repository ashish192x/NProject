package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.webdriver.WebDriverClass;

public class ForgotPassword extends WebCommons{
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath ="//input[@id='securityAuthentication_userName']")
	private WebElement usernameTxtb;
	
	@FindBy(xpath ="//input[@id='btnSearchValues']")
	private WebElement resetPasswordBtn;
	
	@FindBy(xpath ="//input[@id='btnCancel']")
	private WebElement cancelBtn;
	
	public void verifyForgotPasswordPageElements() throws IOException {
		Logger = WebDriverClass.getLogger();
		
		try {
			Click(forgotPasswordLink);
			usernameTxtb.isDisplayed();
			resetPasswordBtn.isDisplayed();
			cancelBtn.isDisplayed();
			Logger.pass("Forgot Password Page Elements Available");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "ForgotPasswordPage"));
			Logger.fail("Forgot Password Page Elements not Available");
			Assert.fail("Forgot Password Page Elements not Available");
		}
	}
	
	public static ForgotPassword getForgotPassword() {
		return PageFactory.initElements(WebDriverClass.getDriver(), ForgotPassword.class);
	}

}
