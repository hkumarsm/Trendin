package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.CategoryModulePage;
import com.trendin.pages.HomePage;

public class TestCategoryModulePage extends TrendInTestSuite {
	/*
	 * TC_001-MF&L-TrendIN-Categories
	 */
	@Test 
	public void testVerifyHomePage() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);

	}

	@Test 
	public void testVerifyNewArrivalMenCategory() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "New Arrivals";
		categoryModulePage.clickOnHeaderLinksType(driver, linkTypeName);
		String menCategoriesName =ExcelReader.getValue("MenCategoriesName");
		categoryModulePage.veriyMenCategory(driver, menCategoriesName);
	}

	/////////////////////////////////SOWMYA///////////////////////////

	//TC_011-MF&L-TrendIN-Categories
	//Step 01
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderNewArrivalsMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "New Arrivals";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}

	//Step 02
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderMenMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "Men";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}

	//Step 03
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderWomenMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "Women";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}

	//Step 04
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderKidsMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "Kids";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}

	//Step 05
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderCollectionsMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "Collections";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}

	//Step 06
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderMyFitMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "My Fit";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}

	//Step 07
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderBrandStoriesMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "Brand Stories";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}
	//Step 08
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderSaleMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "Sale";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnSecurePaymentIcon(driver);
		categoryModulePage.verifySecurePaymentHeader(driver);
	}

	//TC_012-MF&L-TrendIN-Categories
	//Step 01
	@Test(groups = "CategoryModule")
	public void testVerifyFreeAlterationsUnderNewArrivalsMenu() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "New Arrivals";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
		categoryModulePage.clickOnFreeAlterationIcon(driver);
		categoryModulePage.verifyAlterationPageTitle(driver);
		categoryModulePage.verifyelementsInAlterationPage(driver);
		categoryModulePage.selectStateFromSelectStateDropDown(driver);
		categoryModulePage.clickOnLocateStoreBtn(driver);
		
	}
	
	//Step 02
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderMenMenu() throws Exception {
			HomePage homePage = new HomePage();
			homePage.verifyHomePageLogo(driver);
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			String linkTypeName = "Men";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
			categoryModulePage.clickOnFreeAlterationIcon(driver);
			categoryModulePage.verifyAlterationPageTitle(driver);
			categoryModulePage.verifyelementsInAlterationPage(driver);
			categoryModulePage.selectStateFromSelectStateDropDown(driver);
			categoryModulePage.clickOnLocateStoreBtn(driver);
		}

		//Step 03
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderWomenMenu() throws Exception {
			HomePage homePage = new HomePage();
			homePage.verifyHomePageLogo(driver);
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			String linkTypeName = "Women";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
			categoryModulePage.clickOnFreeAlterationIcon(driver);
			categoryModulePage.verifyAlterationPageTitle(driver);
			categoryModulePage.verifyelementsInAlterationPage(driver);
			categoryModulePage.selectStateFromSelectStateDropDown(driver);
			categoryModulePage.clickOnLocateStoreBtn(driver);
		}

		//Step 04
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderKidsMenu() throws Exception {
			HomePage homePage = new HomePage();
			homePage.verifyHomePageLogo(driver);
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			String linkTypeName = "Kids";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
			categoryModulePage.clickOnFreeAlterationIcon(driver);
			categoryModulePage.verifyAlterationPageTitle(driver);
			categoryModulePage.verifyelementsInAlterationPage(driver);
			categoryModulePage.selectStateFromSelectStateDropDown(driver);
			categoryModulePage.clickOnLocateStoreBtn(driver);
		}

		//Step 05
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderCollectionsMenu() throws Exception {
			HomePage homePage = new HomePage();
			homePage.verifyHomePageLogo(driver);
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			String linkTypeName = "Collections";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
			categoryModulePage.clickOnFreeAlterationIcon(driver);
			categoryModulePage.verifyAlterationPageTitle(driver);
			categoryModulePage.verifyelementsInAlterationPage(driver);
			categoryModulePage.selectStateFromSelectStateDropDown(driver);
			categoryModulePage.clickOnLocateStoreBtn(driver);
		}

		//Step 06
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderMyFitMenu() throws Exception {
			HomePage homePage = new HomePage();
			homePage.verifyHomePageLogo(driver);
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			String linkTypeName = "My Fit";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
			categoryModulePage.clickOnFreeAlterationIcon(driver);
			categoryModulePage.verifyAlterationPageTitle(driver);
			categoryModulePage.verifyelementsInAlterationPage(driver);
			categoryModulePage.selectStateFromSelectStateDropDown(driver);
			categoryModulePage.clickOnLocateStoreBtn(driver);
		}

		//Step 07
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderBrandStoriesMenu() throws Exception {
			HomePage homePage = new HomePage();
			homePage.verifyHomePageLogo(driver);
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			String linkTypeName = "Brand Stories";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
			categoryModulePage.clickOnFreeAlterationIcon(driver);
			categoryModulePage.verifyAlterationPageTitle(driver);
			categoryModulePage.verifyelementsInAlterationPage(driver);
			categoryModulePage.selectStateFromSelectStateDropDown(driver);
			categoryModulePage.clickOnLocateStoreBtn(driver);
		}
		//Step 08
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderSaleMenu() throws Exception {
			HomePage homePage = new HomePage();
			homePage.verifyHomePageLogo(driver);
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			String linkTypeName = "Sale";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, linkTypeName);
			categoryModulePage.clickOnFreeAlterationIcon(driver);
			categoryModulePage.verifyAlterationPageTitle(driver);
			categoryModulePage.verifyelementsInAlterationPage(driver);
			categoryModulePage.selectStateFromSelectStateDropDown(driver);
			categoryModulePage.clickOnLocateStoreBtn(driver);
		}


}
