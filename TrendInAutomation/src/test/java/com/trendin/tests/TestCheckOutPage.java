package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.CheckOutPage;
import com.trendin.pages.ContactUsPage;
import com.trendin.pages.EndToEnd;
import com.trendin.pages.LoginPage;
import com.trendin.pages.QuickViewPage;

public class TestCheckOutPage extends TrendInTestSuite {

	// TC_TrendIN_CheckOut_001
	@Test(groups = "CheckOut")
	public void testVerifyCheckOutSummaryPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickProductImage(driver);
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
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
	}

	// TC_TrendIN_CheckOut_013
	@Test(groups = "CheckOut")
	public void testClickOnAvailableOffer() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.clickOnAvailableOfferLink(driver);
		checkOutPage.verifyAvailableOffersList(driver);
	}

	// TC_TrendIN_CheckOut_014
	@Test(groups = "CheckOut")
	public void testVerifyApplyBtnIsDisabled() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		//checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.verifyApplyBtnIsDisabled(driver);

	}

	// TC_TrendIN_CheckOut_015
	@Test(groups = "CheckOut")
	public void testVerifyForInvalidVoucherCode() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.enterVoucherCode(driver);
		checkOutPage.clickOnApplyBtn(driver);
		checkOutPage.verifyErrMsgForInvaldVoucherCode(driver);
	}

	// TC_TrendIN_CheckOut_016
	@Test(groups = "CheckOut")
	public void testVerifyForValidVoucherCode() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		checkOutPage.ClickOnCouponsAndTrendInCredits(driver);
		checkOutPage.verifyDiscountCouponsPageHeader(driver);
		checkOutPage.clickOnAvailableOfferLink(driver);
		checkOutPage.clickOnDiscountCode(driver);
	}

	// TC_TrendIN_CheckOut_042
	@Test(groups = "CheckOut")
	public void testVerifyZipCodeErrorMsg() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		EndToEnd endToEnd = new EndToEnd();
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		endToEnd.clickOnProductCategory(driver);
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
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		endToEnd.clickOnProductCategory(driver);
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
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		endToEnd.clickOnProductCategory(driver);
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
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		endToEnd.clickOnProductCategory(driver);
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
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		endToEnd.clickOnProductCategory(driver);
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
		String megaMenuName = ExcelReader.getValue("MegaMenuName");
		String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
		endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
		endToEnd.clickOnProductCategory(driver);
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
	 @Test(groups = "CheckOut1")
	 public void testVerifyNavigateToContactUsPageInCheckOutPage() throws Exception {
	  EndToEnd endToEnd = new EndToEnd();
	  LoginPage loginPage = new LoginPage();
	  String megaMenuName = ExcelReader.getValue("MegaMenuName");
	  String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
	  endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
	  endToEnd.clickOnProductCategory(driver);
	  loginPage.clickOnProductSize(driver);
	  endToEnd.clickOnAddToBagLink(driver);
	  loginPage.verifyForTopButton(driver);
	  endToEnd.clickOnCartLink(driver);
	  CheckOutPage checkOutPage = new CheckOutPage();
	  checkOutPage.clickOnContactUsInCheckOutSummaryPage(driver);

	 }

	 // TC_TrendIn_CheckOut_029
	 @Test(groups = "CheckOut1")
	 public void testClickOnPlaceOrderInCheckOutPage() throws Exception {
	  EndToEnd endToEnd = new EndToEnd();
	  LoginPage loginPage = new LoginPage();
	  String megaMenuName = ExcelReader.getValue("MegaMenuName");
	  String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
	  endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
	  endToEnd.clickOnProductCategory(driver);
	  loginPage.clickOnProductSize(driver);
	  endToEnd.clickOnAddToBagLink(driver);
	  loginPage.verifyForTopButton(driver);
	  endToEnd.clickOnCartLink(driver);
	  CheckOutPage checkOutPage = new CheckOutPage();
	  checkOutPage.clickOnPlaceOrderIncheckOutSummaryPage(driver);
	 }

	 // TC_TrendIn_CheckOut_030
	 @Test(groups = "CheckOut1")
	 public void testVeirfyEmailTextfieldInPlaceOrderPage() throws Exception {
	  EndToEnd endToEnd = new EndToEnd();
	  LoginPage loginPage = new LoginPage();
	  String megaMenuName = ExcelReader.getValue("MegaMenuName");
	  String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
	  endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
	  endToEnd.clickOnProductCategory(driver);
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
	 @Test(groups = "CheckOut1")
	 public void testVerifyValidEmailTextFieldInPlaceOrderPage() throws Exception {
	  EndToEnd endToEnd = new EndToEnd();
	  LoginPage loginPage = new LoginPage();
	  String megaMenuName = ExcelReader.getValue("MegaMenuName");
	  String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
	  endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
	  endToEnd.clickOnProductCategory(driver);
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
	 @Test(groups = "CheckOut1")
	 public void testVerifyAlreadyRegistereDMailMessage() throws Exception {
	  EndToEnd endToEnd = new EndToEnd();
	  LoginPage loginPage = new LoginPage();
	  String megaMenuName = ExcelReader.getValue("MegaMenuName");
	  String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
	  endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
	  endToEnd.clickOnProductCategory(driver);
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
	 @Test(groups = "CheckOut1")
	 public void testVerifyPinCodeTextfield() throws Exception {
	  EndToEnd endToEnd = new EndToEnd();
	  LoginPage loginPage = new LoginPage();
	  String megaMenuName = ExcelReader.getValue("MegaMenuName");
	  String megaMenuCategoryName = ExcelReader.getValue("MegaMenuCategoryName");
	  endToEnd.clickOnMegaMenuCategory(driver, megaMenuName, megaMenuCategoryName);
	  endToEnd.clickOnProductCategory(driver);
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
		EndToEnd endToEnd = new EndToEnd();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		EndToEnd endToEnd = new EndToEnd();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
	public void testClickOnExixtingAddressRadioBtn() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.verifyShippingAddressPageHeader(driver);
		checkOutPage.clickOnEditLinkInShippinghAddrsPage(driver);
		checkOutPage.verifyEditAddressPage(driver);
	}

	// TC_TrendIN_CheckOut_068
	@Test(groups = "CheckOut")
	public void testClickOnContactUsLinkInAddressPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
		CheckOutPage checkOutPage = new CheckOutPage();
		checkOutPage.clickOnCartIcon(driver);
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
		endToEnd.clickOnPlaceOrder();
		checkOutPage.verifyShippingAddressPageHeader(driver);
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.clickContactUsFooter(driver);
	}

	// TC_TrendIN_CheckOut_069
	@Test(groups = "CheckOut")
	public void testClickOnBackButtonInAddressPage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
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
	
	}
