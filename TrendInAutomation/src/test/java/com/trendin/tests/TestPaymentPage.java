package com.trendin.tests;
import org.testng.annotations.Test;

import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.PaymentPage;

public class TestPaymentPage extends TrendInTestSuite{

	@Test
	public void testVerifyMyCartPage() throws Exception{
		PaymentPage myCart = new PaymentPage();
		myCart.clickOnDifferntLabels(driver);
		myCart.verifyMyCartPage(driver);
		
	}
	
	@Test
	public void testVerifyProducDetailsPage() throws Exception{
		PaymentPage myCart = new PaymentPage();
		myCart.clickOnDifferntLabels(driver);
		myCart.verifyProducDetailsPage(driver);
		
	}
	
	@Test
	public void testVerifyEditSizeMyCartPage() throws Exception{
		PaymentPage myCart = new PaymentPage();
		myCart.clickOnDifferntLabels(driver);
		myCart.verifyEditSizeMyCartPage(driver);
		
	}
	
	@Test
	public void testSaveSelectedDropDownSize() throws Exception{
		PaymentPage myCart = new PaymentPage();
		myCart.clickOnDifferntLabels(driver);
		myCart.saveSelectedDropDownSize(driver);
		
	}
}
