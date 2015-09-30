package com.trendin.tests;


import org.testng.annotations.Test;

import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.ExistingUserPage;

public class TestAccountPage extends TrendInTestSuite {

	//To login using existing user 
	@Test
	public void verifyMyAccountPage() throws Exception {
		ExistingUserPage existingPage = new ExistingUserPage();
		existingPage.existingUser(driver);
	}
	//To logout from TrendIn
	@Test
	public void logoutTrendInClick() throws Exception {
		ExistingUserPage existingPage = new ExistingUserPage();
		existingPage.existingUser(driver);
		existingPage.logoutTrendIn(driver);
	}
	//To click on forgot password link
	@Test
	public void forgotPasswordClick() throws Exception {
		ExistingUserPage existingPage = new ExistingUserPage();
		existingPage.forgotPassword(driver);
	}
}
