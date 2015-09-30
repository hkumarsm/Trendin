package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.LoginPage;
import com.trendin.pages.MyAddressPage;

public class TestMyAddressPage extends TrendInTestSuite {
	
	/*
	 * TC_TrendIN_My Address_001
	 */
	@Test(groups = "ModuleAddress" ,priority = 1)
	public void testVerifyMyAddressPage() throws Exception {
		MyAddressPage addressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		addressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		addressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		addressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		addressPage.verifyMyAddressPage(driver, addressName);
	}
	
	/*
	 * TC_TrendIN_My Address_002
	 */
	@Test(groups = "ModuleAddress",priority = 2)
	public void testVerifyAddAnAddressPage() throws Exception {
		MyAddressPage addressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		addressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		addressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		addressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		addressPage.verifyMyAddressPage(driver, addressName);
		addressPage.clickOnAddAddress(driver);
		addressPage.verifyAddAddressPopUp(driver);
		
	}
	/*
	 * TC_TrendIN_My Address_003
	 */
	@Test(groups = "ModuleAddress",priority = 3)
	public void testVerifyPostalCodePopUp() throws Exception {
		MyAddressPage addressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		addressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		addressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		addressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		addressPage.verifyMyAddressPage(driver, addressName);
		addressPage.clickOnAddAddress(driver);
		addressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		addressPage.enterZip(driver, zipCode);
		addressPage.clickOnCheck(driver);
		addressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
	}
	/*
	 * TC_TrendIN_My Address_004
	 */
	@Test(groups = "ModuleAddress",priority = 4)
	public void testVerifySaveAddressErrorMessages() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		myAddressPage.clickOnSaveMyAddress(driver);
		String firstNameStatus = ExcelReader.getValue("FirstNameStatus");
		String lastNameStatus = ExcelReader.getValue("LastNameStatus");
		String addressLine1Status = ExcelReader.getValue("AddressLine1Status");
		String addressLine2Status = ExcelReader.getValue("AddressLine2Status");
		String addressLine3Status = ExcelReader.getValue("AddressLine3Status");
		String addressLandMarkStatus = ExcelReader.getValue("AddressLandMarkStatus");
		String cityStatus = ExcelReader.getValue("CityStatus");
		String mobileNumberStatus = ExcelReader.getValue("MobileNumberStatus");
		String saveAddressAsStatus = ExcelReader.getValue("SaveAddressAsStatus");
		
		myAddressPage.verifyAddressTextFieldErrorMessages(driver, firstNameStatus, lastNameStatus, addressLine1Status, addressLine2Status, addressLine3Status, addressLandMarkStatus, cityStatus, mobileNumberStatus, saveAddressAsStatus);
	}
	/*
	 * TC_TrendIN_My Address_005
	 */
	@Test(groups = "ModuleAddress",priority = 5)
	public void testVerifySaveAddress() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		myAddressPage.clickOnSaveMyAddress(driver);
		myAddressPage.verifyAddressIsadded(driver);
	}
	/*
	 * TC_TrendIN_My Address_006
	 */
	@Test(groups = "ModuleAddress",priority = 6)
	public void testVerifyErrorMessageForTextFields() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		myAddressPage.clickOnSaveMyAddress(driver);
		String firstNameStatus = ExcelReader.getValue("FirstNameStatus");
		String lastNameStatus = ExcelReader.getValue("LastNameStatus");
		String addressLine1Status = ExcelReader.getValue("AddressLine1Status");
		String addressLine2Status = ExcelReader.getValue("AddressLine2Status");
		String addressLine3Status = ExcelReader.getValue("AddressLine3Status");
		String addressLandMarkStatus = ExcelReader.getValue("AddressLandMarkStatus");
		String cityStatus = ExcelReader.getValue("CityStatus");
		String mobileNumberStatus = ExcelReader.getValue("MobileNumberStatus");
		String saveAddressAsStatus = ExcelReader.getValue("SaveAddressAsStatus");
		
		myAddressPage.verifyAddressTextFieldErrorMessages(driver, firstNameStatus, lastNameStatus, addressLine1Status, addressLine2Status, addressLine3Status, addressLandMarkStatus, cityStatus, mobileNumberStatus, saveAddressAsStatus);
	}
	/*
	 * TC_TrendIN_My Address_007
	 */
	@Test(groups = "ModuleAddress",priority = 7)
	public void testVerifyIsCountryAndStateTextBoxIsDisabled() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		myAddressPage.verifyIsCountryAndStateTextBoxAreDisabled(driver);
	}
	/*
	 * TC_TrendIN_My Address_008 enters city
	 */
	@Test(groups = "ModuleAddress",priority = 8)
	public void verifyTextBoxEntersCity() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String city = ExcelReader.getValue("City");
		myAddressPage.enterCityToAddAddressPopUp(driver, city);
	}
	
	/*
	 * TC_TrendIN_My Address_009 enters city with invalid data
	 */
	@Test(groups = "ModuleAddress",priority = 9)
	public void verifyTextBoxEntersCityWithInvalidData() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		String city = ExcelReader.getValue("City");
		myAddressPage.enterCityToAddAddressPopUp(driver, city);
		myAddressPage.clickOnSaveMyAddress(driver);
		String firstNameStatus = ExcelReader.getValue("FirstNameStatus");
		String lastNameStatus = ExcelReader.getValue("LastNameStatus");
		String addressLine1Status = ExcelReader.getValue("AddressLine1Status");
		String addressLine2Status = ExcelReader.getValue("AddressLine2Status");
		String addressLine3Status = ExcelReader.getValue("AddressLine3Status");
		String addressLandMarkStatus = ExcelReader.getValue("AddressLandMarkStatus");
		String cityStatus = ExcelReader.getValue("CityStatus");
		String mobileNumberStatus = ExcelReader.getValue("MobileNumberStatus");
		String saveAddressAsStatus = ExcelReader.getValue("SaveAddressAsStatus");
		
		myAddressPage.verifyAddressTextFieldErrorMessages(driver, firstNameStatus, lastNameStatus, addressLine1Status, addressLine2Status, addressLine3Status, addressLandMarkStatus, cityStatus, mobileNumberStatus, saveAddressAsStatus);
	}
	/*
	 * TC_TrendIN_My Address_010 enters city with invalid data
	 */
	@Test(groups = "ModuleAddress",priority = 10)
	public void testVerifyErrorMsgForInvalidMobileNumberStartWithZero() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		myAddressPage.clickOnSaveMyAddress(driver);
		String firstNameStatus = ExcelReader.getValue("FirstNameStatus");
		String lastNameStatus = ExcelReader.getValue("LastNameStatus");
		String addressLine1Status = ExcelReader.getValue("AddressLine1Status");
		String addressLine2Status = ExcelReader.getValue("AddressLine2Status");
		String addressLine3Status = ExcelReader.getValue("AddressLine3Status");
		String addressLandMarkStatus = ExcelReader.getValue("AddressLandMarkStatus");
		String cityStatus = ExcelReader.getValue("CityStatus");
		String mobileNumberStatus = ExcelReader.getValue("MobileNumberStatus");
		String saveAddressAsStatus = ExcelReader.getValue("SaveAddressAsStatus");
		
		myAddressPage.verifyAddressTextFieldErrorMessages(driver, firstNameStatus, lastNameStatus, addressLine1Status, addressLine2Status, addressLine3Status, addressLandMarkStatus, cityStatus, mobileNumberStatus, saveAddressAsStatus);
	}
	/*
	 * TC_TrendIN_My Address_011 enters city with invalid data
	 */
	@Test(groups = "ModuleAddress",priority = 11)
	public void testVerifyAliasTextBoxAcceptsValidInput() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		myAddressPage.clickOnSaveMyAddress(driver);
		myAddressPage.verifyAddressIsadded(driver);
	}
	/*
	 * TC_TrendIN_My Address_012
	 */
	@Test(groups = "ModuleAddress",priority=13)
	public void verifySaveAddressAsErrorMessage() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		myAddressPage.clickOnSaveMyAddress(driver);
		String firstNameStatus = ExcelReader.getValue("FirstNameStatus");
		String lastNameStatus = ExcelReader.getValue("LastNameStatus");
		String addressLine1Status = ExcelReader.getValue("AddressLine1Status");
		String addressLine2Status = ExcelReader.getValue("AddressLine2Status");
		String addressLine3Status = ExcelReader.getValue("AddressLine3Status");
		String addressLandMarkStatus = ExcelReader.getValue("AddressLandMarkStatus");
		String cityStatus = ExcelReader.getValue("CityStatus");
		String mobileNumberStatus = ExcelReader.getValue("MobileNumberStatus");
		String saveAddressAsStatus = ExcelReader.getValue("SaveAddressAsStatus");
		
		myAddressPage.verifyAddressTextFieldErrorMessages(driver, firstNameStatus, lastNameStatus, addressLine1Status, addressLine2Status, addressLine3Status, addressLandMarkStatus, cityStatus, mobileNumberStatus, saveAddressAsStatus);
	}
	/*
	 * TC_TrendIN_My Address_013
	 */
	@Test(groups = "",priority=14)
	public void verifyLeftAndRightCarousel() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		myAddressPage.clickOnSaveMyAddress(driver);
		myAddressPage.verifyAddressIsadded(driver);
		//Add 2nd address
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode1 = ExcelReader.getValue("ZipCode1");
		myAddressPage.enterZip(driver, zipCode1);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName1 = ExcelReader.getValue("FirstName1");
		String lastName1 = ExcelReader.getValue("LastName1");
		String addressLine11 = ExcelReader.getValue("AddressLine11");
		String addressLine21 = ExcelReader.getValue("AddressLine21");
		String addressLine31 = ExcelReader.getValue("AddressLine31");
		String addressLandMark1 = ExcelReader.getValue("AddressLandMark1");
		String mobileNumber1 = ExcelReader.getValue("MobileNumber1");
		String saveAddressAs1 = ExcelReader.getValue("SaveAddressAs1");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName1, lastName1, addressLine11, addressLine21, addressLine31, addressLandMark1, mobileNumber1, saveAddressAs1);
		myAddressPage.clickOnSaveMyAddress(driver);
		myAddressPage.verifyAddressIsadded(driver);
		//Add 3Rd address
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode2 = ExcelReader.getValue("ZipCode2");
		myAddressPage.enterZip(driver, zipCode2);
		myAddressPage.clickOnCheck(driver);
		myAddressPage.verifyNewAddressPopUpAfterClickOnCheck(driver);
		String firstName2 = ExcelReader.getValue("FirstName2");
		String lastName2 = ExcelReader.getValue("LastName2");
		String addressLine12 = ExcelReader.getValue("AddressLine12");
		String addressLine22 = ExcelReader.getValue("AddressLine22");
		String addressLine32 = ExcelReader.getValue("AddressLine32");
		String addressLandMark2 = ExcelReader.getValue("AddressLandMark2");
		String mobileNumber2 = ExcelReader.getValue("MobileNumber2");
		String saveAddressAs2 = ExcelReader.getValue("SaveAddressAs2");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName2, lastName2, addressLine12, addressLine22, addressLine32, addressLandMark2, mobileNumber2, saveAddressAs2);
		myAddressPage.clickOnSaveMyAddress(driver);
		myAddressPage.verifyAddressIsadded(driver);
		String rightOrLeftcarousel = ExcelReader.getValue("RightOrLeftcarousel");
		String addresses = ExcelReader.getValue("Addresses");
		myAddressPage.verifyAddedAddressesAreDisplayed(driver, addresses, rightOrLeftcarousel);
	}
	/*
	 * TC_TrendIN_My Address_014
	 */
	@Test(groups = "")
	public void testVerifyIsAddressIsEdited() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnEditAddressIcon(driver, addressName);
		String firstName = ExcelReader.getValue("FirstName");
		String lastName = ExcelReader.getValue("LastName");
		String addressLine1 = ExcelReader.getValue("AddressLine1");
		String addressLine2 = ExcelReader.getValue("AddressLine2");
		String addressLine3 = ExcelReader.getValue("AddressLine3");
		String addressLandMark = ExcelReader.getValue("AddressLandMark");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String saveAddressAs = ExcelReader.getValue("SaveAddressAs");
		myAddressPage.enterDataToAddMyaddressPopUp(driver, firstName, lastName, addressLine1, addressLine2, addressLine3, addressLandMark, mobileNumber, saveAddressAs);
		myAddressPage.clickOnSaveMyAddress(driver);
		myAddressPage.verifyAddressIsEdited(driver);
	}
	/*
	 * TC_TrendIN_My Address_015
	 */
	@Test(groups = "ModuleAddress",priority=12)
	public void testVerifyFunctionalityOfCloseIcon() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.clickOnEditAddressIcon(driver, addressName);
		myAddressPage.clickOnCloseIcon(driver);
	}
	/*
	 * TC_TrendIN_My Address_016
	 */
	@Test(groups = "")
	public void testVerifyAddressIsDeleted() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.clickOnDeleteAddressIcon(driver, addressName);
		myAddressPage.clickOnOkButton(driver);
		myAddressPage.verifyIsAddressDeleted(driver);
	}
	/*
	 * TC_TrendIN_My Address_017
	 */
	@Test(groups = "ModuleAddress",priority=14)
	public void testVerifyZipCodeErrorMessage() throws Exception {
		MyAddressPage myAddressPage = new MyAddressPage();
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, emailId, password);
		Thread.sleep(2000);
		myAddressPage.mouseHoverOnUserName(driver);
		String userDropDownName = ExcelReader.getValue("UserDropDownName");
		myAddressPage.clickDropDownUsersMenuItem(driver, userDropDownName);
		String leftSideLinkName = ExcelReader.getValue("LeftSideLinkName");
		myAddressPage.clickOnLeftHandSideUILinks(driver, leftSideLinkName);
		String addressName = ExcelReader.getValue("AddressName");
		myAddressPage.verifyMyAddressPage(driver, addressName);
		myAddressPage.clickOnAddAddress(driver);
		myAddressPage.verifyAddAddressPopUp(driver);
		String zipCode = ExcelReader.getValue("ZipCode");
		myAddressPage.enterZip(driver, zipCode);
		String zipCodeType = ExcelReader.getValue("ZipCodeType");
		myAddressPage.verifyErrorMessageForZipOrPostalCode(driver, zipCodeType);
	}
}
