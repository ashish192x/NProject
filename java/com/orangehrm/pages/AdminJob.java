package com.orangehrm.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.webdriver.WebDriverClass;

public class AdminJob extends WebCommons {
	
	@FindBy(xpath="//b[text()='Admin']")
	private WebElement AdminPage;
	
	@FindBy(xpath="//a[text()='Job']")
	private WebElement jobMenu;
	
	@FindBy(xpath="//a[text()='Job Titles']")
	private WebElement jobTitle;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	private WebElement btnAdd;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	private WebElement btnDelete;	
	
	@FindBy(xpath="//input[@id='jobTitle_jobTitle']")
	private WebElement jobtitleValue;
		
	@FindBy(xpath="//textarea[@id='jobTitle_jobDescription']")
	private WebElement jobDescription;
	
	@FindBy(xpath="//input[@name='jobTitle[jobSpec]']")
	private WebElement jobSpecChooseFile;
	
	@FindBy(xpath="//textarea[@name='jobTitle[note]']")
	private WebElement jobNote;
	
	@FindBy(xpath="//input[@name='btnSave']")
	private WebElement btnSave;	
	
	@FindBy(xpath="//input[@name='btnCancel']")
	private WebElement btnCancel;		
	
	@FindBy(xpath="//input[@name='chkSelectAll']")
	private WebElement checkselectAll;
	
	@FindBy(xpath="//input[@id='ohrmList_chkSelectRecord_57']")
	private WebElement checkselect31;
	
	@FindBy(xpath="//input[@id='dialogDeleteBtn']")
	private WebElement dialogDeltBtn;
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcomPage;	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;		
	
	By byLoginPanelHeading2 = By.xpath("//div[@id='logInPanelHeading']");
	
	public void verifyAdminPageJobElements() throws IOException {
		Logger = WebDriverClass.getLogger();
		
		try {
			Click(AdminPage);
			//Click(jobMenu);
			Actions action = new Actions(driver);
			action.moveToElement(jobMenu).moveToElement(jobTitle).click().build().perform();
			//Click(jobTitle);
			Click(btnAdd);
			jobtitleValue.clear();
			jobtitleValue.sendKeys("Account Manager4");
			jobDescription.clear();
			jobDescription.sendKeys("selenium testing4");
			//WaitForElement(7, By.xpath(jobSpecChooseFile.toString()));
			//Click(jobSpecChooseFile);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			jobSpecChooseFile.sendKeys("C:\\Users\\ASHISH\\Documents\\job specification.txt");
			//driver.switchTo().activeElement().sendKeys("C:\\Users\\ASHISH\\Documents\\job specification.txt");
			System.out.println("File Uploaded Successfully");
			jobNote.clear();
			jobNote.sendKeys("good to go");
			Click(btnSave);
			System.out.println("Info saved Successfully");
			//selectCheckbox(checkselectAll);
			selectCheckbox(checkselect31);
			Click(btnDelete);
			Click(dialogDeltBtn);
			//System.out.println(driver.switchTo().alert().getText());
			//driver.switchTo().alert().accept();
			System.out.println("Deleted Successfully");
			Click(welcomPage);
			Click(logout);
			System.out.println("Logout Successfully");
			//WaitForElement(5, byLoginPanelHeading2);
			Logger.pass("Admin Job Page working as expected");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "AdminJobPage"));
			Logger.fail("Admin Job Page Elements not Available");
			Assert.fail("Admin Job Page Elements not Available");
		}
	}
	
	public static AdminJob getAdminJob() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AdminJob.class);
	}

}
	
	
	
	
	
	
	
	
	
	
	
	

