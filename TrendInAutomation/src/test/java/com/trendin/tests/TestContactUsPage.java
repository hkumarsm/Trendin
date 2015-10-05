package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.CategoryModulePage;
import com.trendin.pages.ContactUsPage;
import com.trendin.pages.HomePage;

public class TestContactUsPage extends TrendInTestSuite {

	// To click on contact us icon and verify page is displayed or not
	// [TC-01]pass
	@Test(groups = "Module3")
	public void testVerifyClickContactUsIcon() throws Exception {
		String tabsToVerifyInContactUsPage = ExcelReader.getValue("ElementsToVerify");
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyContactUsPage(driver, tabsToVerifyInContactUsPage);
	}

	// To click on contact us in footer and verify page is displayed or not
	// [TC-02]pass
	@Test(groups = "Module3")
	public void testClickContactUsFooter() throws Exception {
		String tabsToVerifyInContactUsPage = ExcelReader.getValue("ElementsToVerify");
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickFooterContactUsIcon(driver);
		contactUsPage.verifyContactUsPage(driver, tabsToVerifyInContactUsPage);
	}

	// To click on contact us icon and verify Faqs is displayed or not
	// [TC-03]pass
	@Test(groups = "Module3")
	public void testClickOnFaqs() throws Exception {
		String tabsToVerifyInContactUsPage = ExcelReader.getValue("ElementsToVerify");
		String elementsToVerifyInFAQsPage = ExcelReader.getValue("ElementsToVerifyInFaqPage");
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickFooterContactUsIcon(driver);
		contactUsPage.verifyContactUsPage(driver, tabsToVerifyInContactUsPage);
		contactUsPage.clickOnFaqsAndVerify(driver, elementsToVerifyInFAQsPage);
	}

	// [TC-04] To verify pincode field pass
	@Test(groups = "Module3")
	public void testVerifyPinCodeField() throws Exception {
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickFooterContactUsIcon(driver);
		String inputPINValueAndMessages = ExcelReader.getValue("ElementsToVerify"); 
		contactUsPage.verifyPinCodeFieldValidationAndFunctionality(driver, inputPINValueAndMessages);
	}

	// To verify invalid pin code [TC-05] pass
	@Test(groups = "Module3")
	public void testVerifyInvalidPinCodeField() throws Exception {
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyInvalidPinCodeField(driver);
	}

	// Verify for blank pin code field TC-06 pass
	@Test(groups = "Module3")
	public void testVerifyBlankPinCodeField() throws Exception {
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyBlankPinCodeField(driver);
	}

	// To verify user can send mail or not [TC-07 pass]
	@Test(groups = "Module3")
	public void testVerifyContactUsFunctionalityViaEMail() throws Exception {
		String userName = ExcelReader.getValue("UserName");
		String password = ExcelReader.getValue("Password");
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyContactUsFunctionalityViaEMail(driver, userName, password);
	}

	// To verify call us details TC-08 pass
	@Test(groups = "Module3")
	public void testVerifyCallUsDetails() throws Exception {
		String callUsDetails = ExcelReader.getValue("CallUsDetails");
		String staticDetails = ExcelReader.getValue("StaticDetails");
		String tabsToVerifyInContactUsPage = ExcelReader.getValue("ElementsToVerify");
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyContactUsPage(driver, tabsToVerifyInContactUsPage);
		contactUsPage.verifyCallUsDetails(driver, callUsDetails, staticDetails);
	}

	// To verify T&C offers TC-09 pass
	@Test(groups = "Module3")
	public void testVerifyTCOffers() throws Exception {
		String tabsToVerifyInContactUsPage = ExcelReader.getValue("ElementsToVerify");
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyContactUsPage(driver, tabsToVerifyInContactUsPage);
		contactUsPage.verifyTCOffers(driver);
	}

	// To verify altration page TC-10 pass
	@Test(groups = "Module3")
	public void testVerifyAlterationImage() throws Exception {
		String tabsToVerifyInContactUsPage = ExcelReader.getValue("ElementsToVerify");
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyContactUsPage(driver, tabsToVerifyInContactUsPage);
		contactUsPage.gotoAlerrationPageFromContactUsPage(driver);
		categoryModulePage.verifyAlterationPage(driver);
	}

	// To verify top button page TC-11 pass
	@Test(groups = "Module3")
	public void testVerifyPresenceOfTOPButtonAndClickInContactUs() throws Exception {
		HomePage homePage = new HomePage();
		ContactUsPage contactUsPage = new ContactUsPage();
		homePage.clickHeaderContactIcon(driver);
		contactUsPage.verifyPresenceOfTOPButtonAndClick(driver, true);
	}

}
