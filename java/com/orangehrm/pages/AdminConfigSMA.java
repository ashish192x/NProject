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

public class AdminConfigSMA extends WebCommons {

	@FindBy(xpath="//b[text()='Admin']")
	private WebElement AdminPage;
	
	@FindBy(xpath="//a[@id='menu_admin_Configuration']")
	private WebElement ConfigMenu;
	
	@FindBy(xpath="//a[@id='menu_admin_openIdProvider']")
	private WebElement smaPage;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	private WebElement addBtn;
	
	@FindBy(xpath="//select[@id='openIdProvider_type']")
	private WebElement selectOption;	
	
	@FindBy(xpath="//input[@id='openIdProvider_name']")
	private WebElement enterName;
		
	@FindBy(xpath="//input[@id='openIdProvider_url']")
	private WebElement enterURL;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement btnSave;
	
	@FindBy(xpath="//input[@name='chkSelectAll']")
	private WebElement selectChkboxAll;	
	
	@FindBy(xpath="//input[@id='btnDelete']")
	private WebElement deleteChkbox1;
	
	@FindBy(xpath="//input[@id='dialogDeleteBtn']")
	private WebElement okBtn;
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcomPage;	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public void verifyAdminPageConfigSMAElements() throws IOException {
		Logger = WebDriverClass.getLogger();
		
		try {
			
			Click(AdminPage);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			action.moveToElement(ConfigMenu).moveToElement(smaPage).click().build().perform();
			Click(addBtn);
			SelectDropdownOption(selectOption, "OpenId", "1");
			enterName.clear();
			enterName.sendKeys("Ashish1992");
			enterURL.clear();
			enterURL.sendKeys("https://www.breathing-ss.com");
			Click(btnSave);
			System.out.println("Saved Successfully");
			//selectCheckbox(selectChkbox1);
			//Select s1 =new Select(selectChkbox1);
			//s1.selectByValue("2");
			Click(selectChkboxAll);
			Click(deleteChkbox1);
			System.out.println("Deleted Successfully");
			//Click(welcomPage);
			//Click(logout);
			//System.out.println("Logout Successfully");
			//WaitForElement(5, byLoginPanelHeading2);
			Logger.pass("Admin Configration SMAPage working as expected");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "AdminConfigrationSMAPage"));
			Logger.fail("Admin Configration SMAPage Elements not Available");
			Assert.fail("Admin Configration SMAPage Elements not Available");
		}
	}
	
	public static AdminConfigSMA getAdminConfigSMA() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AdminConfigSMA.class);
	}
}
