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

public class AdminOrganization extends WebCommons {

	@FindBy(xpath="//b[text()='Admin']")
	private WebElement AdminPage;
	
	@FindBy(xpath="//a[@id='menu_admin_Organization']")
	private WebElement OrgMenu;
	
	@FindBy(xpath="//a[@id='menu_admin_viewLocations']")
	private WebElement locations;
	
	@FindBy(xpath="//input[@id='searchLocation_name']")
	private WebElement locationName;
	
	@FindBy(xpath="//input[@id='searchLocation_city']")
	private WebElement searchbyCity;	
	
	@FindBy(xpath="//select[@id='searchLocation_country']")
	private WebElement searchbyCountry;
		
	@FindBy(xpath="//input[@id='btnSearch']")
	private WebElement search;
	
	@FindBy(xpath="//input[@id='btnReset']")
	private WebElement reset;
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcomPage;	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public void verifyAdminPageOrgElements() throws IOException {
		Logger = WebDriverClass.getLogger();
		
		try {
			
			Click(AdminPage);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			action.moveToElement(OrgMenu).moveToElement(locations).click().build().perform();
			locationName.clear();
			locationName.sendKeys("Chapra");
			searchbyCity.clear();
			searchbyCity.sendKeys("Saran");
			SelectDropdownOption(searchbyCountry, "India", "IN");
			Click(search);
			System.out.println("Searched Successfully");
			Click(reset);
			Click(welcomPage);
			Click(logout);
			System.out.println("Logout Successfully");
			//WaitForElement(5, byLoginPanelHeading2);
			Logger.pass("Admin Organization Page working as expected");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "AdminOrganizationPage"));
			Logger.fail("Admin Organization Page Elements not Available");
			Assert.fail("Admin Organization Page Elements not Available");
		}
	}
	
	public static AdminOrganization getAdminOrganization() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AdminOrganization.class);
	}

}
	

