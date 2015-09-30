package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.LoginPage;
import com.trendin.pages.TrackOrderPage;

public class TestTrackOrder extends TrendInTestSuite {
	
	//To verify track order icon is displayed
	/*
	 * TC_TrendIN_Track order_001
	 */
	@Test(groups = "Module1")
	public void testTrackOrderPopUp() throws Exception {
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
	}
	
	/*
	 * TC_TrendIN_Track order_002
	 */
	@Test(groups = "Module1")
	public void testTrack() throws Exception {
		String emailId = ExcelReader.getValue("EmailId");
		String orderNo = ExcelReader.getValue("OrderNumber");
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		trackOrderPage.enterTrackOrderDetails(driver, emailId, orderNo);
		trackOrderPage.verifyTrackOrderDetails(driver);
	}
	
	/*
	 * TC_TrendIN_Track order_003
	 */
	@Test(groups = "Module1")
	public void verifySignUpPageWhenClickOnLoginForMore() throws Exception {
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		trackOrderPage.clickOnLoginForMore(driver, wait);
		trackOrderPage.verifySignUpPage(driver, wait);
	}
	
	/*
	 * TC_TrendIN_Track order_004
	 */
	@Test(groups = "Module1")
	public void verifyErrorMsgForMailOrderNo() throws Exception {
		//Provide email-id and order number value as True for Correct value, False for incorrect value and character for character and special character.
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		String emailIdStatus = ExcelReader.getValue("EmailIdStatus"); //"true" 
		String orderNoStatus = ExcelReader.getValue("OrderNumberStatus"); //="False";
		String emailId = ExcelReader.getValue("EmailId");
		String orderNumber = ExcelReader.getValue("OrderNumber");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus, emailId, orderNumber);
		
		String orderNoStatus1 = ExcelReader.getValue("OrderNumberStatus1"); //Character
		String orderNumber1 = ExcelReader.getValue("OrderNumber1"); //false
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus1, emailId, orderNumber1 );
		
		String emailIdStatus1 = ExcelReader.getValue("EmailIdStatus1"); //"false"
		String orderNoStatus2 = ExcelReader.getValue("OrderNumberStatus2"); //="True";
		String emailId1 = ExcelReader.getValue("EmailId1");
		String orderNumber2 = ExcelReader.getValue("OrderNumber2");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait,  emailIdStatus1, orderNoStatus2, emailId1, orderNumber2 );
		
		String emailIdStatus2 = ExcelReader.getValue("EmailIdStatus2"); //"Character"
		String emailId2 = ExcelReader.getValue("EmailId2");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus2, orderNoStatus2, emailId2, orderNumber2  );
		
		
	}
	/*
	 * TC_TrendIN_Track order_005
	 */
	@Test(groups = "Module1")
	public void verifyErrorMsgForEmptyMailIdAndOrderNo() throws Exception {
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		
		String emailIdStatus = ExcelReader.getValue("EmailIdStatus"); //"Empty" 
		String orderNoStatus = ExcelReader.getValue("OrderNumberStatus"); //"Empty";
		String emailId = ExcelReader.getValue("EmailId");
		String orderNumber = ExcelReader.getValue("OrderNumber");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait,  emailIdStatus, orderNoStatus, emailId, orderNumber);
		
		String orderNoStatus1 = ExcelReader.getValue("OrderNumberStatus1"); //"true";
		String orderNumber1 = ExcelReader.getValue("OrderNumber1");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus1, emailId, orderNumber1);
		
		String emailIdStatus1 = ExcelReader.getValue("EmailIdStatus1"); //"true"
		String emailId1 = ExcelReader.getValue("EmailId1");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus1, orderNoStatus, emailId1, orderNumber);
		
		
	}
	
	/*
	 * TC_TrendIN_Track order_006
	 */
	@Test(groups = "Module1")
	public void verifyErrorMsgForOthersEmailIdAndOrderNo() throws Exception {
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		String emailIdStatus = ExcelReader.getValue("EmailIdStatus"); //"False" 
		String orderNoStatus = ExcelReader.getValue("OrderNumberStatus"); //"False";
		String emailId = ExcelReader.getValue("EmailId");
		String orderNumber = ExcelReader.getValue("OrderNumber");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus, emailId, orderNumber);
		
		String emailIdStatus1 = ExcelReader.getValue("EmailIdStatus1"); //"True" 
		String emailId1 = ExcelReader.getValue("EmailId1");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus1, orderNoStatus, emailId1, orderNumber);
		
		String orderNoStatus1 = ExcelReader.getValue("OrderNumberStatus1"); //"False";
		String orderNumber1 = ExcelReader.getValue("OrderNumber1");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus1, emailId, orderNumber1);
	}
	
	
	/*
	 * TC_TrendIN_Track order_007
	 */
	@Test(groups = "Module1")
	public void verifyTrackOrderForRegisterUser() throws Exception {
		//Provide email-id and order number value as True for Correct value, False for incorrect value and character for character and special character.
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		String emailId1 = ExcelReader.getValue("EmailId1");
		String orderNumber = ExcelReader.getValue("OrderNumber");
		trackOrderPage.enterTrackOrderDetails(driver, emailId1, orderNumber);
		trackOrderPage.verifyTrackOrderDetails(driver);
	}
	
	/*
	 * TC_TrendIN_Track order_008
	 */
	@Test(groups = "Module1")
	public void verifyTrackOrderForRegisterUserInvalidOrderNumber() throws Exception {
		//Provide email-id and order number value as True for Correct value, False for incorrect value and character for character and special character.
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		String emailIdStatus = ExcelReader.getValue("EmailIdStatus"); //"true" 
		String orderNoStatus = ExcelReader.getValue("OrderNumberStatus"); //="False";
		String emailId1 = ExcelReader.getValue("EmailId1");
		String orderNumber = ExcelReader.getValue("OrderNumber");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus, emailId1, orderNumber);
		
		String orderNoStatus1 = ExcelReader.getValue("OrderNumberStatus1"); //="Character";
		String orderNumber1 = ExcelReader.getValue("OrderNumber1");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus1, emailId1, orderNumber1);
	}
	
	/*
	 * TC_TrendIN_Track order_009
	 */
	@Test(groups = "Module1")
	public void verifyTrackOrderMsgForRegisterUserEmptyOrderNumber() throws Exception {
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		String emailIdStatus = ExcelReader.getValue("EmailIdStatus"); //"true" 
		String orderNoStatus = ExcelReader.getValue("OrderNumberStatus"); //="empty";
		String emailId1 = ExcelReader.getValue("EmailId1");
		String orderNumber = ExcelReader.getValue("OrderNumber");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus, emailId1, orderNumber);
	}
	
	/*
	 * TC_TrendIN_Track order_010
	 */
	@Test(groups = "Module1")
	public void verifyEmailIdTextBox() throws Exception {
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		trackOrderPage.verifyEmailIdTextBoxValue(driver, emailId);
	}
	
	
	/*
	 * TC_TrendIN_Track order_011
	 */
	@Test(groups = "Module1")
	public void verifyTrackOrderMsgForRegisterUserOthersOrderNumber() throws Exception {
		TrackOrderPage trackOrderPage = new TrackOrderPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		trackOrderPage.verifyTrackOrderIconDisplayStatus(driver);
		trackOrderPage.clickOnTrackOrderIcon(driver);
		String wait = ExcelReader.getValue("Wait");
		trackOrderPage.verifyTrackOrderLinkPopUp(driver, wait);
		String emailIdStatus = ExcelReader.getValue("EmailIdStatus"); //"true" 
		String orderNoStatus = ExcelReader.getValue("OrderNumberStatus"); //"false";
		String emailId1 = ExcelReader.getValue("EmailId1");
		String orderNumber = ExcelReader.getValue("OrderNumber");
		trackOrderPage.verifyErrorMessageForInvalidMailIdOrderNo(driver, wait, emailIdStatus, orderNoStatus, emailId1, orderNumber);
	}
	
}
