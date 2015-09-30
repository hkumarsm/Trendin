package com.trendin.tests;

import org.testng.annotations.Test;
import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.EndToEnd;
import com.trendin.pages.MyAddressPage;
import com.trendin.pages.QuickViewPage;

public class TestQuickViewPage extends TrendInTestSuite {

	// TC_TrendIN_Quick view_001
	@Test(groups = "Model1")
	public void testVerifyQuickView() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
	}

	// TC_TrendIN_Quick view_002
	@Test(groups = "Model1")
	public void testVerifyNextQuickView() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnNextButtonAndVerifyPopUp(driver);
	}

	// TC_TrendIN_Quick view_003
	@Test(groups = "Model1")
	public void testVerifyPreviousQuickView() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickPreviousButtonAndVerifyPopUp(driver);
	}

	// TC_TrendIN_Quick view_004
	@Test(groups = "Model1")
	public void testVerifyBackViewImage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
//		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
//		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.backViewImage(driver);
	}

	// TC_TrendIN_Quick view_005
	@Test(groups = "Model1")
	public void testVerifyFrontViewImage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.frontViewImage(driver);
	}

	// TC_TrendIN_Quick view_006
	@Test(groups = "Model1")
	public void testVerifySideViewImage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.sideViewImage(driver);
	}

	// TC_TrendIN_Quick view_007
	@Test(groups = "Model1")
	public void testVerifyDetailViewImage() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.detailViewImage(driver);
	}

	// TC_TrendIN_Quick view_008
	@Test(groups = "Model1")
	public void testClickViewDetailsLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnViewDetailsLinkInQuickViewPage(driver);
	}

	// TC_TrendIN_Quick view_009
	@Test(groups = "Model1")
	public void testverifyFocusOrangeColor() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
//		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
//		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.verifyOrangeColorOnMouseHoverSize(driver);
	}

	// TC_TrendIN_Quick view_010
	@Test(groups = "Model1")
	public void testSelectSize() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
	}

	// TC_TrendIN_Quick view_011
	@Test(groups = "Model1")
	public void testClickReturnsLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOn30DaysReturnsLink(driver);
	}

	// TC_TrendIN_Quick view_012
	@Test(groups = "Model1")
	public void testClickFreeShippingLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnAllIndiaFreeShippingLink(driver);
	}

	// TC_TrendIN_Quick view_013
	@Test(groups = "Model1")
	public void testAddToMyBag() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
	}

	// TC_TrendIN_Quick view_014
	@Test(groups = "Model1")
	public void testAddToMyBagWithoutSize() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.VerifyMsgDisplayedClickedOnAddToMyBag(driver);
	}

	// TC_TrendIN_Quick view_017
	@Test(groups = "Model1")
	public void testVerifyCheckoutSummary() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		EndToEnd endToEnd = new EndToEnd();
		endToEnd.clickOnBuyNow();
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
	}

	// TC_TrendIN_Quick view_018
	@Test(groups = "Model1")
	public void testBuyNowWithoutSize() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		EndToEnd endToEnd = new EndToEnd();
		endToEnd.clickOnBuyNow();
		quickViewPage.VerifyMsgDisplayedClickingOnBuyNow(driver);
	}

	// TC_TrendIN_Quick view_021
	@Test(groups = "Model1")
	public void testClickVerifySizeGuide() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnSizeGuideAndVerifyItsDisplay(driver);
	}

	// TC_TrendIN_Quick view_022
	@Test(groups = "Model1")
	public void testClickVerifyCmsInchs() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnSizeGuideAndVerifyItsDisplay(driver);
		quickViewPage.clickInchesOnSizeGuideScreen(driver);
		quickViewPage.clickCmsOnSizeGuideScreen(driver);
	}

	// TC_TrendIN_Quick view_023
	@Test(groups = "Model1")
	public void testSizeGuideCloseIcon() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnSizeGuideAndVerifyItsDisplay(driver);
		quickViewPage.clickSizeGuideCloseIcon(driver);
	}

	// TC_TrendIN_Quick view_024
	@Test(groups = "Model1")
	public void testQuickCloseIcon() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnSizeGuideAndVerifyItsDisplay(driver);
		quickViewPage.clickOnCloseIconOfQuickView(driver);
	}

	// TC_TrendIN_Quick view_025
	@Test(groups = "Model1")
	public void testQuickViewClose() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.clickOnCloseIconOfQuickView(driver);		
	}

	/*// TC_TrendIN_Quick view_026
	@Test(groups = "Model1")
	public void testMinimizeAndVerify() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickMenuAndSelectItem(driver);
		quickViewPage.clickVerifyQuickView(driver);
		quickViewPage.minimizeAndVerify(driver);
	}*/

	// TC_TrendIN_Quick view_027
	 @Test(groups = "Model1")
	 public void testQuickViewColorOption() throws Exception {
	  QuickViewPage quickViewPage = new QuickViewPage();
	  quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
	  quickViewPage.clickOnAnyProductImage(driver);
	  quickViewPage.verifyOrangeColorOnMouseHoverSize(driver);   
	 }

	// TC_TrendIN_Quick view_028
	@Test(groups = "Model1")	
	public void testVerifyNextBtnPresent() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		EndToEnd endToEnd = new EndToEnd();
		String filterTypeName = ExcelReader.getValue("FilterTypeName");
		String selectFilterValue = ExcelReader.getValue("SelectFilterValue");
		endToEnd.selectFilterType(driver, filterTypeName, selectFilterValue);
		quickViewPage.clickOnQuickViewAndVerifyPopUpPage(driver);
		quickViewPage.verifyNextBtnIsNotPresent(driver);			
	}

	// TC_TrendIN_Quick view_029
	@Test(groups = "Model1")	
	public void testVerifyRecentProduct() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
	}

	// TC_TrendIN_Quick view_030
	@Test(groups = "Model1")	
	public void testVerifyRecentProdNext() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.clickOnNextButtonAndVerifyPopUp(driver);
	}	

	// TC_TrendIN_Quick view_031
	@Test(groups = "Model1")
	public void testVerifyRecentProdPrevios() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.clickPreviousButtonAndVerifyPopUp(driver);
	}

	// TC_TrendIN_Quick view_032
	@Test(groups = "Model1")
	public void testVerifyRecentProdBckView() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.backViewImage(driver);
	}

	// TC_TrendIN_Quick view_033
	@Test(groups = "Model1")
	public void testVerifyRecentProdSideView() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.sideViewImage(driver);
	}

	// TC_TrendIN_Quick view_034
	@Test(groups = "Model1")
	public void testVerifyRecentProdFrntView() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.frontViewImage(driver);
	}

	// TC_TrendIN_Quick view_035
	@Test(groups = "Model1")
	public void testVerifyRecentProdDtlView() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.detailViewImage(driver);
	}

	// TC_TrendIN_Quick view_036
	@Test(groups = "Model1")
	public void testVerifyRecentSelectSize() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
	}

	// TC_TrendIN_Quick view_037
	@Test(groups = "Model1")
	public void testVerifyRecentReturnLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.clickOn30DaysReturnsLink(driver);
	}	

	// TC_TrendIN_Quick view_038
	@Test(groups = "Model1")
	public void testVerifyRecentFreeShipLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.clickOnAllIndiaFreeShippingLink(driver);
	}	

	// TC_TrendIN_Quick view_039
	@Test(groups = "Model1")
	public void testVerifyRecentViewDetailLink() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.clickOnViewDetailsLinkInQuickViewPage(driver);
	}	

	// TC_TrendIN_Quick view_040
	@Test(groups = "Model1")
	public void testVerifyRecentAddBagBtn() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.checkCartValue(driver);
	}

	// TC_TrendIN_Quick view_041
	@Test(groups = "Model1")
	public void testVerifyRecentVrfyMsgAddBag() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.clickAddToMyBag(driver);
		quickViewPage.VerifyMsgDisplayedClickedOnAddToMyBag(driver);
	}	

	// TC_TrendIN_Quick view_044
	@Test(groups = "Model1")
	public void testVerifyRecentBuyNow() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		quickViewPage.selectSizeAndVerifyNumOfPiecesAvailableMsg(driver);
		EndToEnd endToEnd = new EndToEnd();
		endToEnd.clickOnBuyNow();
		quickViewPage.VerifyCheckOutSummaryPageTitle(driver);
	}	

	// TC_TrendIN_Quick view_045
	@Test(groups = "Model1")
	public void testVerifyRecentVrfyBuyNow() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		quickViewPage.clickOnMegaMenuAndSelectCategory(driver);
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);	
		driver.navigate().back();
		quickViewPage.clickProductImage(driver);
		quickViewPage.clickOnQuickViewForRecentlyViewedProduct(driver);
		EndToEnd endToEnd = new EndToEnd();
		endToEnd.clickOnBuyNow();
		quickViewPage.VerifyMsgDisplayedClickingOnBuyNow(driver);
	}	
	
////////////////////////////////////////////////////////////////////////////////////////////////
	@Test(groups = "Model1")
	public void testScenario3() throws Exception {
		QuickViewPage quickViewPage = new QuickViewPage();
		EndToEnd endToEnd = new EndToEnd();
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
		endToEnd.clickOnPlaceOrder();
		quickViewPage.clickOnOrderNum(driver);
	}
	

}

