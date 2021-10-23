package com.orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.framework.webdriver.WebDriverClass;
import com.orangehrm.pages.AdminConfig;
import com.orangehrm.pages.AdminConfigSMA;
import com.orangehrm.pages.AdminJob;
import com.orangehrm.pages.AdminOrganization;
import com.orangehrm.pages.AdminPannel;
import com.orangehrm.pages.ForgotPassword;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LeaveMenuAssign;
import com.orangehrm.pages.LoginPage;

public class OranageHRMTest extends WebDriverClass {
	
	@Test(priority=1, enabled = false)
	public void VerifyApplicationTitle() throws IOException {
		initiateTestCaseReporting("Verify Application Title");
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.launchTheApplication();
		loginpage.verfiyTitle();		
	}
	
	@Test(dataProvider="data",priority=2, enabled = false)
	public void VerifyApplicationLogin(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Application Login is Successful or not");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();		
	}
	
	@Test(dataProvider="LogoutData",priority=3, enabled = false)
	public void VerifyApplicationLogout(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Application Logout is Successful or not");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();		
		homePage.verifyApplicationLogout();
	}
	
	@Test(priority=4, enabled = false)
	public void VerfiyForgotPasswordPage() throws IOException {
		initiateTestCaseReporting("Verify Forgot Password Page");
		LoginPage loginpage = LoginPage.getLoginPage();
		ForgotPassword forgotPasswordPage=ForgotPassword.getForgotPassword();
		loginpage.launchTheApplication();
		forgotPasswordPage.verifyForgotPasswordPageElements();
	}
	@Test(dataProvider="data", priority=5, enabled=false)
	public void VerfiyAdminPage(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Admin Page");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		AdminPannel adminPage=AdminPannel.getAdminPannel();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();	
		adminPage.verifyAdminPageElements();
		//homePage.verifyApplicationLogout();
	}
	@Test(dataProvider="data", priority=6, enabled =false)
	public void VerfiyAdminJobPage(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Admin job Page");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		//AdminPannel adminPage=AdminPannel.getAdminPannel();
		AdminJob adminjobpage = AdminJob.getAdminJob();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();	
		//adminPage.verifyAdminPageElements();
		adminjobpage.verifyAdminPageJobElements();
	
}
	@Test(dataProvider="data", priority=7, enabled =false)
	public void VerfiyAdminOrgPage(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Admin Organization Page");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		AdminOrganization adminorgpage = AdminOrganization.getAdminOrganization();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();	
		adminorgpage.verifyAdminPageOrgElements();
	
}
	@Test(dataProvider="data", priority=8, enabled =false)
	public void VerfiyAdminConfigPage(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Admin Configration Page");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		AdminConfig adminconfigpage = AdminConfig.getAdminConfig();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();	
		adminconfigpage.verifyAdminPageConfigElements();
	}
	
	@Test(dataProvider="data", priority=9, enabled =false)
	public void VerfiyAdminConfigSMAPage(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Admin Configration SMAPage");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		AdminConfigSMA adminconfiSMAgpage = AdminConfigSMA.getAdminConfigSMA();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();	
		adminconfiSMAgpage.verifyAdminPageConfigSMAElements();
	}
	@Test(dataProvider="data", priority=10, enabled =true)
	public void VerfiyLeaveAssignPage(String Username,String Password) throws IOException {
		initiateTestCaseReporting("Verify Leave Assign page");
		LoginPage loginpage = LoginPage.getLoginPage();
		HomePage homePage = HomePage.getHomePage();
		LeaveMenuAssign leaveassignpage = LeaveMenuAssign.getLeaveMenuAssign();
		loginpage.launchTheApplication();
		loginpage.LoginIntoApplication(Username, Password);
		homePage.verifyWhetherAppLoginIsSuccessful();	
		leaveassignpage.verifyLeaveMenuAssignPage();
	}
}



