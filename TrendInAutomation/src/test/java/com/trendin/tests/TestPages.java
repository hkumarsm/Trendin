package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.ContactUsPage;
import com.trendin.pages.HomePage;

public class TestPages extends TrendInTestSuite {
	@Test
	public void testFirstTestCase() throws Exception {
		System.out.println("Hemanth Success.");
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
	}
	
	@Test 
	public void verifyMyAccountTestCase()  throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyMyAccount(driver);
	}
	
	/*@Test 
	public void verifyCreateNewUser()  throws Exception {
		MyAccountPage myAccountPage = new MyAccountPage();
		myAccountPage.createNewUser(driver);
	}*/
	
	@Test 
	public void verifyContactUsBottom()  throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyContactUsBottomLink(driver);
	}
	
	@Test 
	public void verifyContactUsTiny()  throws Exception {
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		String expectedIconsToVerify = "Be sure to check;Check Delivery time & COD availability;Email us;Current Promotions;Call us";
		contactUsPage.verifyContactUsPage(driver, expectedIconsToVerify);
	}
}
