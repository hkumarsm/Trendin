package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.ContactUsPage;

public class TestContactUsPage extends TrendInTestSuite {

	// To click on contact us icon and verify page is displayed or not
	// [TC-01]pass
	@Test(groups = "Module3")
	public void testVerifyclickContactUsIcon() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
	}

	// To click on contact us in footer and verify page is displayed or not
	// [TC-02]pass
	@Test(groups = "Module3")
	public void testClickContactUsFooter() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsFooter(driver);
	}

	// To click on contact us icon and verify Faqs is displayed or not
	// [TC-03]pass
	@Test(groups = "Module3")
	public void testClickOnFaqs() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.clickOnFaqsAndVerify(driver);
	}

	// [TC-04] To verify pincode field pass
	@Test(groups = "Module3")
	public void testVerifyPinCodeField() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyPinCodeField(driver);
	}

	// To verify invalid pin code [TC-05] pass
	@Test(groups = "Module3")
	public void testVerifyInvalidPinCodeField() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyInvalidPinCodeField(driver);
	}

	// Verify for blank pin code field TC-06 pass
	@Test(groups = "Module3")
	public void testVerifyBlankPinCodeField() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyBlankPinCodeField(driver);
	}

	// To verify user can send mail or not [TC-07 pass]
	@Test(groups = "Module3")
	public void testVerifyMailFunctionalityOfTrnedin() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyMailFunctionalityOfTrnedin(driver);
	}

	// To verify call us details TC-08 pass
	@Test(groups = "Module3")
	public void testVerifyCallUsDetails() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyCallUsDetails(driver);
	}

	// To verify T&C offers TC-09 pass
	@Test(groups = "Module3")
	public void testVerifyTCOffers() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyTCOffers(driver);
	}

	// To verify altration page TC-10 pass
	@Test(groups = "Module3")
	public void testVerifyAlterationImage() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyAlterationImage(driver);
	}

	// To verify top button page TC-11 pass
	@Test(groups = "Module3")
	public void testVerifyForTopButton() throws Exception {
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsIcon(driver);
		contactUsPage.verifyForTopButton(driver);
	}

}
