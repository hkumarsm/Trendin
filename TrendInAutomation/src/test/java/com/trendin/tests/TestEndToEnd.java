package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.CategoryModulePage;
import com.trendin.pages.EndToEnd;
import com.trendin.pages.LoginPage;
import com.trendin.pages.QuickViewPage;

public class TestEndToEnd extends TrendInTestSuite {
	// E2E test case 1
	@Test(groups = "Scenario")
	public void testVerifyNewlyRegisteredUser() throws Exception {
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.clickLoginOrRegister(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String yourName = ExcelReader.getValue("YourName");
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		String mobileNumberInputValue = ExcelReader.getValue("MobileNumberInputValue");
		loginPage.VerifyValidCrendentialsToLoginPageTextFields(driver, yourName, emailId, password, mobileNumberInputValue);
		String megaMenuName = ExcelReader.getValue("MegaMenuName"); // Men
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName"); // Shirts
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		String filterTypeName = ExcelReader.getValue("FilterTypeName");// "BRAND";
		String selectFilterValue = ExcelReader.getValue("SelectFilterValue");// "Louis
																				// Philippe
																				// (392)";
		endToEnd.selectFilterType(driver, filterTypeName, selectFilterValue);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnBuyNow();
		endToEnd.clickOnPlaceOrder();
		String zipCode = ExcelReader.getValue("ZipCode");
		endToEnd.enterZipForShippingAddress(driver, zipCode);
		endToEnd.clickOnCheckShippingAddressButton(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		// String mobileNumber = ExcelReader.getValue("MobileNumber");

		endToEnd.enteraAdressDetailsForShippingAddressPage(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumberInputValue);
		endToEnd.clickOnSaveAndContinue(driver);
		endToEnd.clickOnCashAndDelivery(driver);
		endToEnd.verifyCaptchaForPaymentOption(driver);
		endToEnd.clickOnPlaceOrder();
		endToEnd.verifyOrderNumber(driver);

	}

	@Test(groups = "Scenario")
	 public void testScenario3() throws Exception {
	  EndToEnd endToEnd = new EndToEnd();
	  QuickViewPage quickViewPage = new QuickViewPage();
	  quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
	  quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
	  quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
	  endToEnd.clickOnBuyNow();
	  quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
	  endToEnd.clickOnPlaceOrder();
	  quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
	  quickViewPage.enterValidZipCodeAndVerifyAddressPage(driver);
	  String firstName = ExcelReader.getValue("FName");
	  String lastName = ExcelReader.getValue("LName");
	  String addressLine1 = ExcelReader.getValue("AddressLine1");
	  String addressLine2 = ExcelReader.getValue("AddressLine2");
	  String addressLine3 = ExcelReader.getValue("AddressLine3");
	  String addressLandMark = ExcelReader.getValue("LandMark");
	  String mobileNumberInputValue = ExcelReader.getValue("MobileNumber");
	  quickViewPage.enterAdressDetailsForNonRegisteredUser(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumberInputValue);
	  quickViewPage.clickOnSaveAndContinueBtn(driver);
	  endToEnd.clickOnCashAndDelivery(driver);
	  endToEnd.verifyCaptchaForPaymentOption(driver);
	  quickViewPage.clickOnPlaceOrderInPaymentPage(driver);
	  quickViewPage.clickOnOrderNum(driver);
	 }

	// E2E test case 4
	@Test(groups = "Scenario")
	public void testVerifyOrderPlacingByLogginginInAddressPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName"); // New
																	// Arrivals
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName"); // Bottoms
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		endToEnd.clickOnQuickView(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		endToEnd.switchToDefault(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		endToEnd.verifySummaryPageIsDisplayed(driver);
		endToEnd.clickOnPlaceOrder();
		String emailId = ExcelReader.getValue("EmailId"); // kk@kk.com
		String password = ExcelReader.getValue("Password"); // 123456
		endToEnd.enterEmailId(driver, emailId, password);
		endToEnd.verifySummaryPageIsDisplayed(driver);
		endToEnd.clickOnPlaceOrder();
		String addressName = ExcelReader.getValue("AddressName");// Sunil
		endToEnd.selectRadioButtonForAddress(driver, addressName);
		endToEnd.clickOnContinueToPaymentButton(driver);
		endToEnd.clickOnCashAndDelivery(driver);
		endToEnd.clickOnPlaceOrder();
		endToEnd.verifySuccessMsg(driver);
		endToEnd.verifyOrderNumber(driver);

	}

	// E2E test case 2
	// Kavya
	@Test(groups = "Scenario")
	public void testVerifyOrderPlacingByLogginginInHomePage() throws Exception {
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.clickOnTheHomeBanner(driver);
		String filterTypeName = ExcelReader.getValue("FilterTypeName");
		String selectFilterValue = ExcelReader.getValue("SelectFilterValue");
		endToEnd.selectFilterType(driver, filterTypeName, selectFilterValue);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		loginPage.verifyForAddCartPlaceOrderFuctionality(driver);
	}

	// E2E test case 5
	// Manasa
	@Test(groups = "Scenario")
	public void testVerifyCancelOrderPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.clickOnTheHomeBanner(driver);
		String filterTypeName = ExcelReader.getValue("FilterTypeName");
		String selectFilterValue = ExcelReader.getValue("SelectFilterValue");
		endToEnd.selectFilterType(driver, filterTypeName, selectFilterValue);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		loginPage.verifyForAddCartPlaceOrderFuctionality(driver);
		loginPage.clickOnCancelOrder(driver);

	}

	// ##################Social elements end to end scenarios[9-23-2015]
	// Manasa
	// TC_END_TO_END_01

	@Test(groups = "Scenario")
	public void testVerifyLoginOrRegisterGoogleNavigation() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.signInWithGoogle(driver);
		loginPage.verifyUserNameInHomePage(driver);
	}

	// TC_END_TO_END_02

	@Test(groups = "Scenario")
	public void testVerifyLoginOrRegisterFacebookNavigation() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.verifyForSignInWithFacebookInLoginPage(driver);
		loginPage.verifyLoginToFacebook(driver);
		loginPage.verifyUserNameInHomePage(driver);
	}

	// TC_END_TO_END_03

	@Test(groups = "Scenario")
	public void testVerifyCouponsAndVouchersGoogleNavigation() throws Exception {
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.clickOnTheHomeBanner(driver);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnBuyNow();
		endToEnd.clickOnCoupnsAndVochersButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.signInWithGoogle(driver);

	}

	// TC_END_TO_END_04

	@Test(groups = "Scenario")
	public void testVerifyCouponsAndVouchersFaceBookNavigation() throws Exception {
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.clickOnTheHomeBanner(driver);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnBuyNow();
		endToEnd.clickOnCoupnsAndVochersButton(driver);
		loginPage.verifyColorChangeOnMouseOverFacebookButton(driver);
		loginPage.verifyForSignInWithFacebookInLoginPage(driver);
		loginPage.verifyLoginToFacebook(driver);

	}

	// Sowmya
	@Test(groups = "Scenario")
	 public void testVerifyUserNameInHomePageFromGoogle() throws Exception {
	  LoginPage loginPage = new LoginPage();
	  QuickViewPage quickViewPage = new QuickViewPage();
	  EndToEnd endToEnd = new EndToEnd();
	  CategoryModulePage categoryModulePage = new CategoryModulePage();
	  quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
	  categoryModulePage.clickOnProductCategory(driver);
	  loginPage.clickOnProductSize(driver);
	  endToEnd.clickOnBuyNow();
	  quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
	  endToEnd.clickOnPlaceOrder();
	  endToEnd.enterRandomEmail(driver);
	  quickViewPage.enterValidZipCodeAndVerifyAddressPage(driver);
	  String firstName = ExcelReader.getValue("FName");
	  String lastName = ExcelReader.getValue("LName");
	  String addressLine1 = ExcelReader.getValue("AddressLine1");
	  String addressLine2 = ExcelReader.getValue("AddressLine2");
	  String addressLine3 = ExcelReader.getValue("AddressLine3");
	  String addressLandMark = ExcelReader.getValue("LandMark");
	  String mobileNumberInputValue = ExcelReader.getValue("MobileNumber");
	  quickViewPage.enterAdressDetailsForNonRegisteredUser(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumberInputValue);
	  quickViewPage.clickOnSaveAndContinueBtn(driver);
	  endToEnd.clickOnCashAndDelivery(driver);
	  endToEnd.verifyCaptchaForPaymentOption(driver);
	  endToEnd.clickOnPlaceOrder();
	  quickViewPage.clickOnOrderNum(driver);
	  loginPage.verifyMyAccountPage(driver);
	  loginPage.verifyMyAccountNewUserPage(driver);
	  loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
	  loginPage.verifyErrorMessageOnPasswordTextfield(driver);
	  loginPage.verifyUserNameInHomePage(driver); 
	 }
	
	
	@Test(groups = "Scenario")
	 public void testVerifyUserNameInHomePageFromFacebook() throws Exception {
	  LoginPage loginPage = new LoginPage();
	  QuickViewPage quickViewPage = new QuickViewPage();
	  EndToEnd endToEnd = new EndToEnd();
	  CategoryModulePage categoryModulePage = new CategoryModulePage();
	  quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
	  categoryModulePage.clickOnProductCategory(driver);
	  loginPage.clickOnProductSize(driver);
	  endToEnd.clickOnBuyNow();
	  quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
	  endToEnd.clickOnPlaceOrder();
	  endToEnd.enterRandomEmail(driver);
	  quickViewPage.enterValidZipCodeAndVerifyAddressPage(driver);
	  String firstName = ExcelReader.getValue("FName");
	  String lastName = ExcelReader.getValue("LName");
	  String addressLine1 = ExcelReader.getValue("AddressLine1");
	  String addressLine2 = ExcelReader.getValue("AddressLine2");
	  String addressLine3 = ExcelReader.getValue("AddressLine3");
	  String addressLandMark = ExcelReader.getValue("LandMark");
	  String mobileNumberInputValue = ExcelReader.getValue("MobileNumber");
	  quickViewPage.enterAdressDetailsForNonRegisteredUser(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumberInputValue);
	  quickViewPage.clickOnSaveAndContinueBtn(driver);
	  endToEnd.clickOnCashAndDelivery(driver);
	  endToEnd.verifyCaptchaForPaymentOption(driver);
	  endToEnd.clickOnPlaceOrder();
	  quickViewPage.clickOnOrderNum(driver);
	  loginPage.verifyMyAccountPage(driver);
	  loginPage.verifyMyAccountNewUserPage(driver);
	  loginPage.signInWithFacebook(driver);
	 }
}
