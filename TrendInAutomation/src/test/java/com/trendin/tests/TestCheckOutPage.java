package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.CategoryModulePage;
import com.trendin.pages.CheckOutPage;
import com.trendin.pages.EndToEnd;
import com.trendin.pages.HomePage;
import com.trendin.pages.LoginPage;
import com.trendin.pages.QuickViewPage;

public class TestCheckOutPage extends TrendInTestSuite {
	
	// TC_TrendIN_CheckOut_001
	@Test(groups = "CheckOut")
	public void testVerifyCheckOutSummaryPage() throws Exception {
		String selectedProductTitle = "";
		QuickViewPage quickViewPage = new QuickViewPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
	}

	// TC_TrendIN_CheckOut_002
	@Test(groups = "CheckOut")
	public void testClickOnProduct() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.clickOnProductAndVerifyProductDesc(driver);
	}

	// TC_TrendIN_CheckOut_003
	@Test(groups = "CheckOut")
	public void testVerifySelectSizeListOnClickingEditLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.clickOnEditLink(driver);
		checkOutPage.verifySelectSizeListIsDisplayed(driver);		
	}

	// TC_TrendIN_CheckOut_004
	@Test(groups = "CheckOut")
	public void testSelectSizeFromSizeDropDownAndClickOnSave() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.clickOnEditLink(driver);
		checkOutPage.verifySelectSizeListIsDisplayed(driver);
		checkOutPage.selectSizeFromSizeDropDown(driver);
		checkOutPage.clickOnSaveButton(driver);
		checkOutPage.verifyEditedSizeIsSaved(driver);

	}

	// TC_TrendIN_CheckOut_005
	@Test(groups = "CheckOut")
	public void testSelectSizeFromSizeDropDownAndClickCancelLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.verifySizeIsNotChangedAfterClickingCancel(driver);

	}

	// TC_TrendIN_CheckOut_006
	@Test(groups = "CheckOut")
	public void testClickOnDeleteIcon() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		String selectedProductTitle = "";
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.clickOnDeleteIcon(driver);	
	}

	// TC_TrendIN_CheckOut_012
	@Test(groups = "CheckOut")
	public void testClickOnCouponsAndTrendInCredits() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		LoginPage loginPage = new LoginPage();
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
	}

	// TC_TrendIN_CheckOut_013
	@Test(groups = "CheckOut")
	public void testClickOnAvailableOffer() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		LoginPage loginPage = new LoginPage();
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.clickOnAvailableOfferLink(driver);
		checkOutPage.verifyAvailableOffersList(driver);
	}

	// TC_TrendIN_CheckOut_014
	@Test(groups = "CheckOut")
	public void testVerifyApplyBtnIsDisabled() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		LoginPage loginPage = new LoginPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyApplyBtnIsDisabled(driver);

	}

	// TC_TrendIN_CheckOut_015
	@Test(groups = "CheckOut")
	public void testVerifyForInvalidVoucherCode() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		LoginPage loginPage = new LoginPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.enterVoucherCode(driver);
		checkOutPage.clickOnApplyBtn(driver);
		checkOutPage.verifyErrMsgForInvalidVoucherCode(driver);
	}

	// TC_TrendIN_CheckOut_016
	@Test(groups = "CheckOut")
	public void testVerifyForValidVoucherCode() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		LoginPage loginPage = new LoginPage();
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.enterVoucherCode(driver);
		checkOutPage.clickOnApplyBtn(driver);
		//checkOutPage.verifyErrMsgForInvaldVoucherCode(driver);
	}

	// TC_TrendIN_CheckOut_017
	@Test(groups = "CheckOut")
	public void testVerifyForAnyDiscountCoupon() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		LoginPage loginPage = new LoginPage();
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.clickOnAvailableOfferLink(driver);
		checkOutPage.clickOnDiscountCode(driver);
	}

	// TC_TrendIN_CheckOut_042
	@Test(groups = "CheckOut")
	public void testVerifyZipCodeErrorMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.verifyZipCodeErrMsg(driver);
	}

	// TC_TrendIN_CheckOut_043
	@Test(groups = "CheckOut")
	public void testErrMsgsOnClickingContinueToPaymentBtn() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyErrMsgsOnClickingContinueToPaymentBtn(driver);
	}

	// TC_TrendIN_CheckOut_044
	@Test(groups = "CheckOut")
	public void testVerifyFirstNameErrMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.enterFirstname(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyFnameErrMsg(driver);
	}

	// TC_TrendIN_CheckOut_045
	@Test(groups = "CheckOut")
	public void testVerifyLastNameErrMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.enterLastname(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyErrorMsgForLnameField(driver);
	}

	// TC_TrendIN_CheckOut_046
	@Test(groups = "CheckOut")
	public void testVerifyAddressLine1ErrMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.enterAddressLine1(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyErrorMsgForAddressLine1Field(driver);
	}

	// TC_TrendIN_CheckOut_047
	@Test(groups = "CheckOut")
	public void testVerifyAddressLine2ErrMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.enterAddressLine2(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyErrorMsgForAddressLine2Field(driver);
	}
	// TC_TrendIN_CheckOut_048
	@Test(groups = "CheckOut")
	public void testVerifyAddressLine3ErrMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.enterAddressLine3(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyErrorMsgForAddressLine3Field(driver);
	}
	// TC_TrendIN_CheckOut_049
	@Test(groups = "CheckOut")
	public void testVerifyLandMarkErrMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.enterLandMark(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyErrorMsgForLandMarkField(driver);
	}
	// TC_TrendIN_CheckOut_050
	@Test(groups = "CheckOut")
	public void testVerifymobNumberErrMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.enterMobNum(driver);
		checkOutPage.clickOnContinueToPayment(driver);
		checkOutPage.verifyErrorMsgForMobNum(driver);
	}
	// TC_TrendIN_CheckOut_051
	@Test(groups = "CheckOut")
	public void testVerifyClearFormBtn() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		quickViewPage.enterValidEmailAndVerifyShippingAddressPage(driver);
		checkOutPage.enterZipCodeAndClickOnCheckBtn(driver);
		checkOutPage.clickOnClearFormBtn(driver);
	}

	// TC_TrendIn_CheckOut_021
	@Test(groups = "CheckOut")
	public void testVerifyMessageClickOnGiftWrapMessageCheckbox() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickAndVerifyTheGiftWrapThisOrderCheckBox(driver);

	}

	// TC_TrendIn_CheckOut_022
	@Test(groups = "CheckOut")
	public void testVerifyErrorMessageClickOnEmptySumbitButtonInGiftWrapPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickAndVerifyTheGiftWrapThisOrderCheckBox(driver);
		checkOutPage.clickOnSubmitButtonInGiftWrapPage(driver);
		checkOutPage.verifyErrorMessgaForEmptyFieldINGiftWrapPage(driver);

	}

	// //TC_TrendIn_CheckOut_023
	@Test(groups = "CheckOut")
	public void testVerifyCheckBoxIsSelectedInGiftWrapCheckBoXInCheckOutPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickAndVerifyTheGiftWrapThisOrderCheckBox(driver);
		checkOutPage.enterTextInTheTextAreaOfWrapText(driver);
		checkOutPage.clickOnSubmitButtonInGiftWrapPage(driver);
		checkOutPage.verifyCheckBoxIsSelectedOrNot(driver);
	}

	// TC_TrendIn_CheckOut_024
	@Test(groups = "CheckOut")
	public void testVerifyUnCheckedCheckBoxWhenUserCleclOnCancelButtoninGiftWrap() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickAndVerifyTheGiftWrapThisOrderCheckBox(driver);
		checkOutPage.clickOnCancelButton(driver);
		checkOutPage.verifyCheckBoxIsSelectedOrNot(driver);

	}

	@Test(groups = "CheckOut")
	public void testVerifyEditFunctionalityAfterClickedOnSubmitButton() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickAndVerifyTheGiftWrapThisOrderCheckBox(driver);
		checkOutPage.enterTextInTheTextAreaOfWrapText(driver);
		checkOutPage.clickOnSubmitButtonInGiftWrapPage(driver);
		checkOutPage.verifyCheckBoxIsSelectedOrNot(driver);
		checkOutPage.clickOnTheEditButton(driver);
	}

	@Test(groups = "CheckOut")
	public void testVerifyAddMoreProductsButtonInTheCheckOutPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickAndVerifyTheGiftWrapThisOrderCheckBox(driver);
		checkOutPage.enterTextInTheTextAreaOfWrapText(driver);
		checkOutPage.clickOnSubmitButtonInGiftWrapPage(driver);
		checkOutPage.verifyCheckBoxIsSelectedOrNot(driver);
		checkOutPage.clickOnTheAddMoreProductsButton(driver);
		loginPage.verifyTinyLoginIcon(driver);

	}

	// TC_TrendIn_CheckOut_028
	@Test(groups = "CheckOut")
	public void testVerifyNavigateToContactUsPageInCheckOutPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnContactUsInCheckOutSummaryPage(driver);

	}

	// TC_TrendIn_CheckOut_029
	@Test(groups = "CheckOut")
	public void testClickOnPlaceOrderInCheckOutPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnPlaceOrderIncheckOutSummaryPage(driver);
	}

	// TC_TrendIn_CheckOut_030
	@Test(groups = "CheckOut")
	public void testVeirfyEmailTextfieldInPlaceOrderPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnPlaceOrderIncheckOutSummaryPage(driver);
		String emailId = ExcelReader.getValue("EmailId");
		checkOutPage.verifyToEnterMaiLIdInTheMailIdTextFieldInCheckOutPage(driver, emailId);
		checkOutPage.verifyErrorMessageForInvalidMailIdInCheckoutPage(driver);
	}

	// TC_TrendIn_CheckOut_031
	@Test(groups = "CheckOut")
	public void testVerifyValidEmailTextFieldInPlaceOrderPage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnPlaceOrderIncheckOutSummaryPage(driver);
		String emailId = ExcelReader.getValue("EmailId");
		checkOutPage.verifyToEnterMaiLIdInTheMailIdTextFieldInCheckOutPage(driver, emailId);
	}

	// TC_TrendIn_CheckOut_032
	@Test(groups = "CheckOut")
	public void testVerifyAlreadyRegistereDMailMessage() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnPlaceOrderIncheckOutSummaryPage(driver);
		String emailId = ExcelReader.getValue("EmailId");
		checkOutPage.verifyToEnterMaiLIdInTheMailIdTextFieldInCheckOutPage(driver, emailId);

	}

	// TC_TrendIn_CheckOut_039
	@Test(groups = "CheckOut")
	public void testVerifyPinCodeTextfield() throws Exception {
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		categoryModulePage.clickOnProductCategory(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		endToEnd.clickOnCartLink(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnPlaceOrderIncheckOutSummaryPage(driver);
		String emailId = ExcelReader.getValue("EmailId");
		checkOutPage.verifyToEnterMaiLIdInTheMailIdTextFieldInCheckOutPage(driver, emailId);
		String pinCode = ExcelReader.getValue("PinCodeValue");
		checkOutPage.toEnterPinCodeInTheZipCodeTextfield(driver, pinCode);
		checkOutPage.verifyErrorMessageForInvalidPinCodeTextfield(driver, pinCode);
	}

	// TC_TrendIN_CheckOut_064
	@Test(groups = "CheckOut")
	public void testVerifyPlaceOrderForRegisteredUser() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.verifyShippingAddressPageHeader(driver);
	}

	// TC_TrendIN_CheckOut_065
	@Test(groups = "CheckOut")
	public void testClickOnShipNewAddressCheckBox() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.verifyShippingAddressPageHeader(driver);
		checkOutPage.checkOnShipNewAddressCheckBox(driver);
		checkOutPage.verifyYourShippingAddressHeader(driver);
	}

	// TC_TrendIN_CheckOut_066
	@Test(groups = "CheckOut")
	public void testClickOnExistingAddressRadioBtn() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.verifyShippingAddressPageHeader(driver);
		String addressName = ExcelReader.getValue("AddressName");
		endToEnd.selectRadioButtonForAddress(driver, addressName);
		checkOutPage.verifyPreviouslyShippedAddressText(driver);
	}

	// TC_TrendIN_CheckOut_067
	@Test(groups = "CheckOut")
	public void testClickOnEditLinkAndVerifyModifyAddPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		String selectedProductTitle = "";
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.verifyShippingAddressPageHeader(driver);
		checkOutPage.clickOnEditLinkInShippingAddrsPage(driver);
		checkOutPage.verifyEditAddressPage(driver);
	}

	// TC_TrendIN_CheckOut_068
	@Test(groups = "CheckOut")
	public void testClickOnContactUsLinkInAddressPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.verifyShippingAddressPageHeader(driver);
		homePage.clickFooterContactUsIcon(driver);
	}

	// TC_TrendIN_CheckOut_069
	@Test(groups = "CheckOut")
	public void testClickOnBackButtonInAddressPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.clickOnBackBtn(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
	}

	// TC_TrendIN_CheckOut_070
	@Test(groups = "CheckOut")
	public void testClickOnNoOfItemsLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.clickOnNoOfItemsLink(driver);
	}

	// TC_TrendIN_CheckOut_071
	@Test(groups = "CheckOut")
	public void testClickOnContinueBtnInCartSummaryPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.clickOnNoOfItemsLink(driver);
		checkOutPage.clickOnContinueBtnInCartSummaryPage(driver);
		checkOutPage.verifyShippingAddressPageHeader(driver);
	}

	// TC_TrendIN_CheckOut_072
	@Test(groups = "CheckOut")
	public void testClickOnCancelIconInCartSummaryPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.clickOnNoOfItemsLink(driver);
		checkOutPage.clickOnCancelIconInCartSummaryPage(driver);
		checkOutPage.verifyShippingAddressPageHeader(driver);
	}
	
	// TC_TrendIN_CheckOut_073
	@Test(groups = "CheckOut")
	public void testClickOnContinueToPayment() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String selectedProductTitle = "";
		String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
		String level2LinkToClick = ExcelReader.getValue("ItemToClick");
		categoryModulePage.selectMainCategoryLink(driver, mainCategory);
		categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
		selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		String addressName = ExcelReader.getValue("AddressName");
		endToEnd.selectRadioButtonForAddress(driver, addressName);
		endToEnd.clickOnContinueToPaymentButton(driver);
		checkOutPage.verifyPaymentPageDisplay(driver);
	}
	
	// TC_TrendIN_CheckOut_074
		@Test(groups = "CheckOut")
		public void testVerifyCashOnDeliveryRadBtnIsDisplayed() throws Exception {
			QuickViewPage quickViewPage = new QuickViewPage();
			LoginPage loginPage = new LoginPage();
			EndToEnd endToEnd = new EndToEnd();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			loginPage.gotoLoginOrRegisterMenu(driver);
			loginPage.clickAlreadyRegisteredLink(driver);
			String userName = ExcelReader.getValue("UserName");
			String passWord = ExcelReader.getValue("Password");
			loginPage.loginToTrendInAccount(driver, userName, passWord);
			String selectedProductTitle = "";
			String mainCategory = ExcelReader.getValue("MegaMenuBarsToClick");
			String level2LinkToClick = ExcelReader.getValue("ItemToClick");
			categoryModulePage.selectMainCategoryLink(driver, mainCategory);
			categoryModulePage.selectLevel2CategoryLink(driver, level2LinkToClick);
			selectedProductTitle = categoryModulePage.clickOnProductCategory(driver);
			quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
			quickViewPage.clickAddToMyBag(driver);
			quickViewPage.checkCartValue(driver);
			CheckOutPage checkOutPage = new CheckOutPage();
			checkOutPage.clickOnCartIcon(driver);
			quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
			endToEnd.clickOnPlaceOrder();
			String addressName = ExcelReader.getValue("AddressName");
			endToEnd.selectRadioButtonForAddress(driver, addressName);
			endToEnd.clickOnContinueToPaymentButton(driver);
			checkOutPage.verifyPaymentPageDisplay(driver);
			checkOutPage.verifyCashOnDeliveryOptionIsDisplayed(driver);
		}
}
