package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.LoginPage;
import com.trendin.pages.SignInWithSocialLoginPage;

public class TestSignInWithSocialLoginPage extends TrendInTestSuite {
	/*
	 * TC_TrendIN_Sign-in With Social_Login_001
	 */
	@Test 
	public void testVerifyLoginLinksOfSocialNetworks() throws Exception {
		SignInWithSocialLoginPage signInWithSocialLoginPage = new SignInWithSocialLoginPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		String socialNetworkButtonNames = ExcelReader.getValue("SocialNetworkButtonNames");
		signInWithSocialLoginPage.verifySocialNetworkButtonsAreDisplayed(driver, socialNetworkButtonNames);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.verifyExistingPageDisplayDetails(driver);
	}
	/*
	 * TC_TrendIN_Sign-in With Social_Login_002
	 */
	@Test
	public void testVerifyGoogleLoginLinkColor() throws Exception {
		SignInWithSocialLoginPage signInWithSocialLoginPage = new SignInWithSocialLoginPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		Thread.sleep(1000);
		signInWithSocialLoginPage.verifyGoogleLoginLinkColor(driver);
	}
	/*
	 * TC_TrendIN_Sign-in With Social_Login_003
	 */
	@Test
	public void testVerifyPageIsNavigatedToGmail() throws Exception {
		SignInWithSocialLoginPage signInWithSocialLoginPage = new SignInWithSocialLoginPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		signInWithSocialLoginPage.clickGoogleLinkLogin(driver);
		Thread.sleep(1000);
	}
	@Test
	public void testAllMethods() throws Exception {
		SignInWithSocialLoginPage signInWithSocialLoginPage = new SignInWithSocialLoginPage();
		signInWithSocialLoginPage.verifyFaceBookLoginLinkColor(driver);
	}
}
