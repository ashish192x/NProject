package com.orangehrm.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.orangehrm.frameowrk.commons.WebCommons;
import com.orangehrm.framework.webdriver.WebDriverClass;

public class LeaveMenuAssign extends WebCommons {

	@FindBy(xpath = "//b[text()='Leave']")
	private WebElement LeavePage;

	@FindBy(xpath = "//a[text()='Assign Leave']")
	private WebElement AssignLeaveMenu;

	@FindBy(xpath = "//input[@id='assignleave_txtEmployee_empName']")
	private WebElement EmployeeName;

	@FindBy(xpath = "//select[@id='assignleave_txtLeaveType']")
	private WebElement LeaveType;

	@FindBy(xpath = "//form[@id=\"frmLeaveApply\"]/fieldset/ol/li[4]/img[@class='ui-datepicker-trigger']")
	private WebElement FromDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement SelectMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement SelectYear;

	@FindBy(xpath = "//tbody/tr[3]/td[3]/a[text()='13']")
	private WebElement SelectDate;

	@FindBy(xpath = "//form[@id=\"frmLeaveApply\"]/fieldset/ol/li[5]/img[@class='ui-datepicker-trigger']")
	private WebElement ToDate;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement SelectMonth1;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement SelectYear1;

	@FindBy(xpath = "//tbody/tr[3]/td[5]/a[text()='15']")
	private WebElement SelectDate1;
	
	@FindBy(xpath = "//select[@id='assignleave_duration_duration']")
	private WebElement Duration;
	
	@FindBy(xpath = "//textarea[@id='assignleave_txtComment']")
	private WebElement Comment;

	@FindBy(xpath = "//input[@id='assignBtn']")
	private WebElement AssignBtn;

	@FindBy(xpath = "//a[@id='welcome']")
	private WebElement welcomPage;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	//By byLoginPanelHeading2 = By.xpath("//div[@id='logInPanelHeading']");

	public void verifyLeaveMenuAssignPage() throws IOException {
		Logger = WebDriverClass.getLogger();

		try {
			// Click(LeavePage);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Actions action = new Actions(driver);
			action.moveToElement(LeavePage).moveToElement(AssignLeaveMenu).click().build().perform();
			// Click(jobTitle);
			if (EmployeeName.isDisplayed() && EmployeeName.isEnabled()) {
				EmployeeName.clear();
				EmployeeName.sendKeys("Orange Test");
				EmployeeName.sendKeys(Keys.ENTER);
			} else
				System.out.println("send data is not available");

			Select s1 = new Select(LeaveType);
			s1.selectByVisibleText("CAN - FMLA");
			
			FromDate.click();
			
			Select s2 = new Select(SelectMonth);
			s2.selectByVisibleText("Oct");
			
			Select s3 = new Select(SelectYear);
			s3.selectByVisibleText("2021");
			
			Click(SelectDate);
			
			ToDate.click();

			Select s4 = new Select(SelectMonth1);
			s4.selectByVisibleText("Oct");
			
			Select s5 = new Select(SelectYear1);
			s5.selectByVisibleText("2021");
			
			Click(SelectDate1);
			
			Select s6 = new Select(Duration);
			s6.selectByVisibleText("Full Day");
			
			if (Comment.isDisplayed() && Comment.isEnabled()) {
				Comment.clear();
				Comment.sendKeys("Regarding visiting for 2 days");
			} else
				System.out.println("send data is not available");
			
			Click(AssignBtn);
			Click(welcomPage);
			Click(logout);
			System.out.println("Logout Successfully");
			// WaitForElement(5, byLoginPanelHeading2);
			Logger.pass("Leave Assign Page working as expected");
		} catch (Exception e) {
			Logger.addScreenCaptureFromPath(TakeScreenshot(driver, "LeaveAssignPage"));
			Logger.fail("Leave Assign Page Elements not Available");
			Assert.fail("Leave Assign Page Elements not Available");
		}
	}

	public static LeaveMenuAssign getLeaveMenuAssign() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LeaveMenuAssign.class);
	}

}
