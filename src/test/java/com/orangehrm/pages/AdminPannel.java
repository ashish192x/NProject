package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.webdriver.WebDriverClass;

public class AdminPannel extends WebCommons{
	
	@FindBy(xpath="//b[text()='Admin']")
	private WebElement AdminPage;
	
	@FindBy(xpath="//a[text()='Users']")
	private WebElement userspage;
	
	@FindBy(xpath="//input[@name='searchSystemUser[userName]']")
	private WebElement username;
	
	@FindBy(xpath="//select[@name='searchSystemUser[userType]']")
	private WebElement userrole;
	
	@FindBy(xpath="//input[@name='searchSystemUser[employeeName][empName]']")
	private WebElement employeename;
	
	@FindBy(xpath="//select[@name='searchSystemUser[status]']")
	private WebElement status;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='resetBtn']")
	private WebElement resetBtn;
	
	@FindBy(xpath="//input[@name='chkSelectAll']")
	private WebElement checkselectAll;
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcomPage;	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;		
	
	By byLoginPanelHeading1 = By.xpath("//div[@id='logInPanelHeading']");
		
	public void verifyAdminPageElements() throws IOException {
		Logger = WebDriverClass.getLogger();
		
		try {
			Click(AdminPage);
			if (username.isDisplayed() && username.isEnabled()) {
				username.clear(); 
				username.sendKeys("AlexxGun"); 
			} else {
				System.out.println("Username Element is not ready to perform actions");
			}
			//EnterInfo(username, "AlexxGun");
			Select s = new Select(userrole);
			s.selectByIndex(2);
			if (employeename.isDisplayed() && employeename.isEnabled()) {
				employeename.clear(); 
				employeename.sendKeys("Fiona Grace"); 
			} else {
				System.out.println("Employee name Element is not ready to perform actions");
			}
			//EnterInfo(employeename, "Fiona Grace");
			Select s1 = new Select(status);
			s1.selectByIndex(1);
			Click(searchBtn);
			Click(resetBtn);
			selectCheckbox(checkselectAll);
			Click(welcomPage);
			Click(logout);
			WaitForElement(5, byLoginPanelHeading1);
			Logger.pass("Admin Page working as expected");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "AdminPage"));
			Logger.fail("Admin Page Elements not Available");
			Assert.fail("Admin Page Elements not Available");
		}
	}
	
	public static AdminPannel getAdminPannel() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AdminPannel.class);
	}

}

