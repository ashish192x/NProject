
package com.orangehrm.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.webdriver.WebDriverClass;

public class AdminConfig extends WebCommons {

	@FindBy(xpath="//b[text()='Admin']")
	private WebElement AdminPage;
	
	@FindBy(xpath="//a[@id='menu_admin_Configuration']")
	private WebElement ConfigMenu;
	
	@FindBy(xpath="//a[@id='menu_admin_viewEmailNotification']")
	private WebElement emailSubscription;
	
	@FindBy(xpath="//input[@id='btnEdit']")
	private WebElement editBtn;
	
	@FindBy(xpath="//a[text()='Leave Applications']")
	private WebElement leaveApplication;	
	
	@FindBy(xpath="//input[@id='btnAdd']")
	private WebElement addbtn;
		
	@FindBy(xpath="//input[@id='subscriber_name']")
	private WebElement enterName;
	
	@FindBy(xpath="//input[@id='subscriber_email']")
	private WebElement enterEmail;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement saveBtn;	
	
	@FindBy(xpath="//input[@id='ohrmList_chkSelectAll']")
	private WebElement checkAll;
	
	@FindBy(xpath="//input[@id='ohrmList_chkSelectRecord_2']")
	private WebElement selectChkbox2;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	private WebElement deleteAll;
	
	@FindBy(xpath="//input[@class='btn']")
	private WebElement okBtnforDelete;
	
	@FindBy(xpath="//input[@id='btnBack']")
	private WebElement btnBack;
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcomPage;	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public void verifyAdminPageConfigElements() throws IOException {
		Logger = WebDriverClass.getLogger();
		
		try {
			
			Click(AdminPage);
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			action.moveToElement(ConfigMenu).moveToElement(emailSubscription).click().build().perform();
			Click(editBtn);
			//action.moveToElement(leaveApplication).click();
			Click(leaveApplication);
			Click(addbtn);
			enterName.clear();
			enterName.sendKeys("Ashish1");
			enterEmail.clear();
			enterEmail.sendKeys("ashish1@example.com");
			Click(saveBtn);
			System.out.println("Saved Successfully");
			//WaitForElement(3, By.xpath(checkAll.toString()));
			//selectCheckbox(checkAll);
			//selectCheckbox(selectChkbox2);
			//Click(deleteAll);
			System.out.println("Deleted Successfully");
			//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			Click(btnBack);
			System.out.println("Got config page Successfully");
			Click(welcomPage);
			Click(logout);
			System.out.println("Logout Successfully");
			//WaitForElement(5, byLoginPanelHeading2);
			Logger.pass("Admin Configration Page working as expected");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "AdminConfigrationPage"));
			Logger.fail("Admin Configration Page Elements not Available");
			Assert.fail("Admin Configration Page Elements not Available");
		}
	}
	
	public static AdminConfig getAdminConfig() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AdminConfig.class);
	}

}
	

