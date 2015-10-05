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
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "New Arrivals";
		categoryModulePage.selectMainCategoryLink(driver, mainCategoryName);
		String menCategoriesName = ExcelReader.getValue("MenCategoriesName");
		categoryModulePage.verifySubCategoriesOptions(driver, menCategoriesName);
	}

	/////////////////////////////////SOWMYA///////////////////////////

	//TC_011-MF&L-TrendIN-Categories
	//Step 01
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderNewArrivalsMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "New Arrivals";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}

	//Step 02
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderMenMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "Men";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}

	//Step 03
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderWomenMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "Women";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}

	//Step 04
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderKidsMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "Kids";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}

	//Step 05
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderCollectionsMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "Collections";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}

	//Step 06
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderMyFitMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "My Fit";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}

	//Step 07
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderBrandStoriesMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "Brand Stories";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}
	//Step 08
	@Test(groups = "CategoryModule")
	public void testVerifySecurePaymentIconUnderSaleMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "Sale";
		String securePaymentOption = "Secure Payment";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, securePaymentOption);
		categoryModulePage.verifySecurePaymentSection(driver);
	}

	//TC_012-MF&L-TrendIN-Categories
	//Step 01
	@Test(groups = "CategoryModule")
	public void testVerifyFreeAlterationsUnderNewArrivalsMenu() throws Exception {
		HomePage homePage = new HomePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		homePage.verifyHomePageLogo(driver);
		String mainCategoryName = "New Arrivals";
		String freeAlteration = "Free Alterations";
		categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
		categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
		categoryModulePage.verifyAlterationPage(driver);
		String state = "Karnataka";
		String city = "Shimoga";
		categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
	}
	
	//Step 02
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsUnderMenMenu() throws Exception {
			HomePage homePage = new HomePage();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			homePage.verifyHomePageLogo(driver);
			String mainCategoryName = "Men";
			String freeAlteration = "Free Alterations";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
			categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
			categoryModulePage.verifyAlterationPage(driver);
			String state = "Karnataka";
			String city = "Shimoga";
			categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
		}

		//Step 03
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsUnderWomenMenu() throws Exception {
			HomePage homePage = new HomePage();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			homePage.verifyHomePageLogo(driver);
			String mainCategoryName = "Women";
			String freeAlteration = "Free Alterations";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
			categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
			categoryModulePage.verifyAlterationPage(driver);
			String state = "Karnataka";
			String city = "Shimoga";
			categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
		}

		//Step 04
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderKidsMenu() throws Exception {
			HomePage homePage = new HomePage();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			homePage.verifyHomePageLogo(driver);
			String mainCategoryName = "Kids";
			String freeAlteration = "Free Alterations";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
			categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
			categoryModulePage.verifyAlterationPage(driver);
			String state = "Karnataka";
			String city = "Shimoga";
			categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
		}

		//Step 05
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderCollectionsMenu() throws Exception {
			HomePage homePage = new HomePage();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			homePage.verifyHomePageLogo(driver);
			String mainCategoryName = "Collections";
			String freeAlteration = "Free Alterations";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
			categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
			categoryModulePage.verifyAlterationPage(driver);
			String state = "Karnataka";
			String city = "Shimoga";
			categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
		}

		//Step 06
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderMyFitMenu() throws Exception {
			HomePage homePage = new HomePage();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			homePage.verifyHomePageLogo(driver);
			String mainCategoryName = "My Fit";
			String freeAlteration = "Free Alterations";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
			categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
			categoryModulePage.verifyAlterationPage(driver);
			String state = "Karnataka";
			String city = "Shimoga";
			categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
		}

		//Step 07
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderBrandStoriesMenu() throws Exception {
			HomePage homePage = new HomePage();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			homePage.verifyHomePageLogo(driver);
			String mainCategoryName = "Brand Stories";
			String freeAlteration = "Free Alterations";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
			categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
			categoryModulePage.verifyAlterationPage(driver);
			String state = "Karnataka";
			String city = "Shimoga";
			categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
		}
		//Step 08
		@Test(groups = "CategoryModule")
		public void testVerifyFreeAlterationsIconUnderSaleMenu() throws Exception {
			HomePage homePage = new HomePage();
			CategoryModulePage categoryModulePage = new CategoryModulePage();
			homePage.verifyHomePageLogo(driver);
			String mainCategoryName = "Sale";
			String freeAlteration = "Free Alterations";
			categoryModulePage.mouseHoverOnHeaderLinksType(driver, mainCategoryName);
			categoryModulePage.selectBusinessOptionsInMainCategoryOverlay(driver, mainCategoryName, freeAlteration);
			categoryModulePage.verifyAlterationPage(driver);
			String state = "Karnataka";
			String city = "Shimoga";
			categoryModulePage.verifyFunctionalityOfStoreLocator(driver, state, city);
		}


}
