package testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ControlActions;
import pages.LoginPage;

public class LoginTest {

	@BeforeMethod
	void start() {
		ControlActions.LaunchBrowser();
	}

	@Test
	public void verifyLogin() {
		// TODO Auto-generated method stub
		LoginPage loginPage = new LoginPage();
		loginPage.login("hbolty@gmail.com", "Pass=1234");
		boolean loginFlag = loginPage.isLoginSuccessfull();
		Assert.assertTrue(loginFlag);
	}

	@AfterMethod
	void teardown() {
		ControlActions.closeBrowser();
	}

}
