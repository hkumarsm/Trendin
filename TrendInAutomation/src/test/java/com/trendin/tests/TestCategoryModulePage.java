package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.CategoryModulePage;
import com.trendin.pages.HomePage;

public class TestCategoryModulePage extends TrendInTestSuite {
	/*
	 * TC_001-MF&L-TrendIN-Categories
	 */
	@Test 
	public void verifyHomePage() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		
	}
	
	@Test 
	public void verifyAll() throws Exception {
		HomePage homePage = new HomePage();
		homePage.verifyHomePageLogo(driver);
		CategoryModulePage categoryModulePage = new CategoryModulePage();
		String linkTypeName = "New Arrivals";
		categoryModulePage.clickOnHeaderLinksType(driver, linkTypeName);
	}
}
