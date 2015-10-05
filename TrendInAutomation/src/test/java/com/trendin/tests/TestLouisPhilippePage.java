package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.CategoryModulePage;
import com.trendin.pages.EndToEnd;
import com.trendin.pages.LoginPage;
import com.trendin.pages.LouisPhilippePage;

public class TestLouisPhilippePage extends TrendInTestSuite {

	// TC-01
	@Test(groups = "Module5")
	public void testVerifyBrandLouisPhilippe() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		louisPhilippePage.verifyBrandLouisPhilippe(driver);
	}

	// TC-04
	@Test(groups = "Module5")
	public void testClickOnShopByBrandOptionAndVerify() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
	}

	// TC-05
	@Test(groups = "Module5")
	public void testVerifyForAllBrandLink() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.verifyForAllBrandLink(driver);
	}

	// TC-06
	@Test(groups = "Module5")
	public void testVerifyForCloseShopByBrands() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnCloseShopByBrands(driver);
	}

	// TC-07
	@Test(groups = "Module5")
	public void testClickOnTrendInLogo() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnTrendInLogo(driver);
	}

	// TC-08
	@Test(groups = "Module5")
	public void testVerifyGuestUser() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		louisPhilippePage.verifyGuestUserRegistration(driver);
	}

	// TC-09
	@Test(groups = "Module5")
	public void testExistingUserLoginAndVerify() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.existingUserLoginPageLogoVerify(driver);
	}

	// TC-10
	@Test(groups = "Module5")
	public void testVerifyUserDropDown() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyUserDropDown(driver);
	}

	// TC-11
	@Test(groups = "Module5")
	public void testVerifyUserDropDownNavigationPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.verifyMyAccount(driver);
		loginPage.verifyMyOrder(driver);
		loginPage.verifyReturn(driver);
		loginPage.clickLogoutTrendIn(driver);
	}

	// TC-12
	@Test(groups = "Module5")
	public void testVerifyTinyUserNamePage() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.userNameClick(driver);
		louisPhilippePage.verifyTinyUserNamePage(driver);

	}

	// TC-13
	@Test(groups = "Module5")
	public void testVerifyTinyStorePage() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyTinyStorePage(driver);

	}

	// TC-14
	@Test(groups = "Module5")
	public void testVerifyTinyTrackOrderPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyTinyTrackOrderPage(driver);

	}

	// TC-15
	@Test(groups = "Module5")
	public void testVerifyTinyContactUsPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyTinyContactUsPage(driver);

	}

	// TC-16
	@Test(groups = "Module5")
	public void testVerifyLogoPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyLogoPage(driver);

	}

	// TC-17
	@Test(groups = "Module5")
	public void testVerifyDefaultSearchLabel() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyDefaultSearchLabel(driver);

	}

	// TC-18
	@Test(groups = "Module5")
	public void testVerifySearchButtonFunctionality() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String searchKeyword = ExcelReader.getValue("SearchKeywordName");
		louisPhilippePage.verifySearchButtonFunctionality(driver, searchKeyword);
		louisPhilippePage.verifySearchButtonNavigationPage(driver);

	}

	// TC-19
	@Test(groups = "Module5")
	public void testVerifyErrorMessageForEmptySearchButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		String searchKeyword = ExcelReader.getValue("SearchKeywordName");
		louisPhilippePage.verifySearchButtonFunctionality(driver, searchKeyword);
		louisPhilippePage.verifyErrorMeassageForSearchButton(driver);

	}

	// TC-20
	@Test(groups = "Module5")
	public void testVerifyErrorMessageForInvalidKeyword() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyErrorMessageForInvalidKeyword(driver);

	}

	// TC-21
	@Test(groups = "Module5")
	public void testClickOnCartButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.clickOnCartButton(driver);

	}

	// TC-22
	@Test(groups = "Module5")
	public void testVerifyMegaMenuLabelInLouisPhilippePages() throws Exception {
		LoginPage loginPage = new LoginPage();
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		louisPhilippePage.verifyMegaMenuLabelInLouisPhilippePages(driver);
	}

	// TC-23
	@Test(groups = "Module5")
	public void testVerifySubCategoryNavigationPage() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		louisPhilippePage.verifySubCategoryNavigationPage(driver);
	}

	// TC-26
	@Test(groups = "Module5")
	public void testSelectBrandAndVerify() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		String searchKeyword = ExcelReader.getValue("SearchKeywordName");
		louisPhilippePage.verifySearchButtonFunctionality(driver, searchKeyword);
		louisPhilippePage.selectLeftNavigation(driver);
		louisPhilippePage.selectBrandAndVerify(driver);

	}

	// TC-28 p
	@Test(groups = "Module5")
	public void testVerifyForBuyNowFuctionality() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		EndToEnd endToEnd = new EndToEnd();
		LoginPage loginPage = new LoginPage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		String searchKeyword = ExcelReader.getValue("SearchKeywordName");
		louisPhilippePage.verifySearchButtonFunctionality(driver, searchKeyword);
		louisPhilippePage.selectLeftNavigation(driver);
		louisPhilippePage.selectBrandAndVerify(driver);
		categoryModulePage.clickOnProductCategory(driver);
		louisPhilippePage.verifyProductPage(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnBuyNow();
		driver.navigate().back();
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		loginPage.verifyForTopButton(driver);
		louisPhilippePage.verifyCartValue(driver);
	}

	// TC-27
	@Test(groups = "Module5")
	public void testVerifyForBuyNowInQuickViewFuctionality() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		LoginPage loginPage = new LoginPage();
		EndToEnd endToEnd = new EndToEnd();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		String searchKeyword = ExcelReader.getValue("SearchKeywordName");
		louisPhilippePage.verifySearchButtonFunctionality(driver, searchKeyword);
		louisPhilippePage.selectLeftNavigation(driver);
		louisPhilippePage.selectBrandAndVerify(driver);
		louisPhilippePage.clickOnQuickViewAndVerifyPage(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnBuyNow();
		driver.switchTo().defaultContent();
		driver.navigate().back();
		louisPhilippePage.clickOnQuickViewAndVerifyPage(driver);
		loginPage.clickOnProductSize(driver);
		endToEnd.clickOnAddToBagLink(driver);
		driver.switchTo().defaultContent();
		louisPhilippePage.verifyCartValue(driver);
	}

	// TC-29 p
	@Test(groups = "Module")
	public void testVerifyForLouisPhilippeBrandLogo() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		louisPhilippePage.verifyForLouisPhilippeBrandLogo(driver);
	}

	// TC-31 p
	@Test(groups = "Module")
	public void testVerifyTopButton() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		louisPhilippePage.verifyTopButton(driver);
	}

	// TC-32 p
	@Test(groups = "Module")
	public void testVerifyFooterLinks() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		louisPhilippePage.verifyFooterLinks(driver);
	}

	// TC-25
	@Test(groups = "Module5")
	public void testVerifyForViewMoreProducts() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		louisPhilippePage.clickOnMegaMenuBar(driver);
		louisPhilippePage.selectLeftNavigation(driver);
		louisPhilippePage.selectCategoriesOptionAndVerify(driver);
		louisPhilippePage.verifyForViewMoreProducts(driver);

	}

	// TC-24
	/*@Test(groups = "Module1")
	public void testVerifyGridsFuctionality() throws Exception {
		LouisPhilippePage louisPhilippePage = new LouisPhilippePage();
		louisPhilippePage.clickOnShopByBrands(driver);
		louisPhilippePage.clickOnShopByBrandOptionAndVerify(driver);
		louisPhilippePage.verifyGridsFuctionality(driver);
 
	}*/
}