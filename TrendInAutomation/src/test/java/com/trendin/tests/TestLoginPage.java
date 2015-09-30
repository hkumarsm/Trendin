package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.HomePage;
import com.trendin.pages.LoginPage;
import com.trendin.pages.LouisPhilippePage;

public class TestLoginPage extends TrendInTestSuite {

	// To verify 'Login/Register' link is displayed on the tiny header across
	// the website (TC-001 and TC-018)
	/*
	 * This Test script verifies the functionality of the TCs:
	 */
	// To verify Login/Register icon displays[TC_01][Pass]
	@Test(groups = "Module1", priority = 3)
	public void testVerifyLoginPageIconIsDisplayed() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
	}

	// To verify Login/Register icon displays[TC_18][Pass]
	@Test(groups = "Module1", priority = 4)
	public void testVerifyLoginPageIsDisplayed() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
	}

	// To verify 'Sign Up' pop up is displayed with the text boxes, button and
	// labels (TC-02)[pass]
	@Test(groups = "Module1", priority = 5)
	public void testVerifyRegisterPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
	}

	// To verify 'EXISTING USERS SIGN IN' pop up is displayed with the text
	// boxes, button and labels (TC-003)[Pass]
	@Test(groups = "Module1", priority = 6)
	public void testVerifyExistingPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.verifyExistingPageDisplayDetails(driver);
	}

	// To enter Invalid email and password for existing user (TC-004) [Pass]
	@Test(groups = "Module1", priority = 1)
	public void testExistingUserTextFields() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.existingUserEmailAndPasswordTextfield(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);

	}

	// To click on forgot password link and verify the labels, text box and
	// button (TC-005)[Pass]
	@Test(groups = "Module1", priority = 7)
	public void testForgotPasswordClick() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.clickForgotPasswordLink(driver);
		loginPage.verifyForgotPasswordPage(driver);
	}

	// To verify 'Forgot Password' page and perform operations (TC-006)[pass]
	@Test(groups = "Module1", priority = 2)
	public void testVerifyForgotPasswordFunctio() throws Exception {

		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.clickForgotPasswordLink(driver);
		loginPage.verifyForgotPasswordFunctionality(driver);
	}

	// To click refresh button in forgot password pop up (TC-07)[Pass]
	@Test(groups = "Module1", priority = 8)
	public void testRefreshButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.clickForgotPasswordLink(driver);
		loginPage.refreshButtonClick(driver);
	}

	// To click close on login/register pop up and forgot password pop up
	// (TC-008) [Pass]
	@Test(groups = "Module1", priority = 9)
	public void testCloseButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickClose(driver);
	}

	// (TC-012)
	@Test(groups = "Module1", priority = 10)
	public void testCloseButtonForgotPassword() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickClose(driver);
	}

	// To click on 'Sign in with Google' (TC-009) [Except Color][Pass]
	@Test(groups = "Module1", priority = 11)
	public void testVerifySignUpGoogle() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.signInWithGoogle(driver);
	}

	// To click on 'Sign in with Facebook' (TC-010) [Except Color][Pass]
	@Test(groups = "Module1", priority = 12)
	public void testverifySignUpFacebook() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.verifyExistingPageDisplayDetails(driver);
		loginPage.signInWithFacebook(driver);
	}

	// To click on 'New To TrendIn' (TC-011)[fail]
	@Test(groups = "Module1", priority = 13)
	public void testClickNewTrendIn() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyLoginPageDetails(driver);
	}

	// To click on my account link from tiny header (TC-014)[pass]
	@Test(groups = "Module1", priority = 14)
	public void testMyAccountClick() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		loginPage.verifyMyAccount(driver);
	}

	// To verify 'My order' [TC-015][pass]
	@Test(groups = "Module1", priority = 15)
	public void testMyOrder() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		loginPage.verifyMyOrder(driver);
		loginPage.verifyOrderReturn(driver);
	}

	// To verify 'Returns' [TC-016][Pass]
	@Test(groups = "Module1", priority = 16)
	public void testReturn() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		loginPage.verifyReturn(driver);
		loginPage.verifyOrderReturn(driver);
	}

	// To verify 'My order' [TC-015] - Step 2[Pass]
	@Test(groups = "Module1", priority = 17)
	public void testUserName() throws Exception {
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		loginPage.userNameClick(driver);
		loginPage.verifyOrderReturn(driver);

	}

	// To logout from TrendIn (TC-017)
	@Test(groups = "Module1", priority = 18)
	public void testVerifyLogoutFunctionality() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		loginPage.clickLogoutTrendIn(driver);
	}

	// To verify drop down (TC-013) [Step 1] [Pass]
	@Test(groups = "Module1", priority = 19)
	public void testDropDownUserName() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyTinyLoginIcon(driver);
		loginPage.clickLoginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		loginPage.verifyDropDownUserName(driver);
	}

	// To click on 'Already Registered link'
	@Test
	public void registerLinkClick() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickAlreadyRegisteredLink(driver);
	}

	// ////////////////////////////////////////////////////////
	// To validate the mobile number field[TC8][Pass]..
	@Test(groups = "Module2", priority = 1)
	public void testValidationMobileNumber() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.validateMobileNumberField(driver);
	}

	// To verify the Password text field in the sign up page by giving empty
	// input[Pass][TC7]
	@Test(groups = "Module2", priority = 2)
	public void testSignUpPasswordField() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.verifySignUpPasswordfield(driver);

	}

	// To click on 'Login/Register' linK[TC01]
	@Test(groups = "Module2", priority = 3)
	public void testLoginPageIconClick() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
	}

	// To verify the sign up page textfields[TC2][Pass]
	@Test(groups = "Module2", priority = 4)
	public void testValidateSignUpPageFunctionality() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.enterKeywordsInSignUpTextFields(driver);
		loginPage.himLabelButton(driver);
	}

	// To validate the username textfield in the sign up page[TC3][Pass]
	@Test(groups = "Module2", priority = 5)
	public void testValidateUsernameTextfield() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.verifySignUpYourNameTextfield(driver);
	}

	// To verify the mail id textfield [TC4][Fail]
	@Test(groups = "Module2", priority = 6)
	public void testValidateMailIdTextfield() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.verifySignUpEmailAddressTextfield(driver);
	}

	// To verify the mail id textfield[Fail][TC5]
	@Test(groups = "Module2", priority = 7)
	public void testValidateMailIdField() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.signUpEmailIdsTextfield(driver);
	}

	// To verify the password textfield[Pass][TC6]
	@Test(groups = "Module2", priority = 8)
	public void testValidatePasswordField() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickLoginOrRegister(driver);
		loginPage.verifySignUpPasswordTextfield(driver);
	}

	// To validate the Terms of use link[TC9][Pass]
	@Test(groups = "Module2", priority = 9)
	public void testValidationTermsOfUse() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.validateTermsAndConditionsLink(driver);
	}

	// To validate the privacy policy link[TC10][Pass]
	@Test(groups = "Module2", priority = 10)
	public void testValidationPrivacyPolicy() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.validatePrivacyPolicyLink(driver);
	}

	// To validate the Blank fields i n login page [TC-11] [Pass]
	@Test(groups = "Module2", priority = 11)
	public void testValidationBlankFieldsInLoginPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.validateEmptyFieldsInLoginPage(driver);
	}

	// To validate the I agree Checkbox[TC12][Pass]..
	@Test(groups = "Module2", priority = 12)
	public void testValidationIAgreeTermsCheckB() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.validateIAgreeCheckBox(driver);
	}

	// To validate the Already registered link[TC13][Pass]
	@Test(groups = "Module2", priority = 13)
	public void testValidationExistingUserLoginPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.validateExistingUserLink(driver);
	}

	// To validate the sign up with google[TC-14][Pass]
	@Test(groups = "Module2", priority = 14)
	public void testValidateSignInWithGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.validateSignInWithGoogleButton(driver);
	}

	// To validate the sign in with facebook[TC-15][pass]
	@Test(groups = "Module2", priority = 15)
	public void testValidateSignInWithFacebookButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.validateSignInWithFacebookButton(driver);
	}

	// To validate the google button in login page [TC-16]
	@Test(groups = "Module2", priority = 16)
	public void testVerifyForSignInWithGoogleInLoginPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyForSignInWithGoogleInLoginPage(driver);
	}

	// To validate the facebook button in login page [TC-17]
	@Test(groups = "Module2", priority = 17)
	public void testVerifyForSignInWithFacebookInLoginPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyForSignInWithFacebookInLoginPage(driver);
	}

	// To validate the NewToTrendin Link [TC-18]
	@Test(groups = "Module2", priority = 18)
	public void testVerifyNewToTrendinLink() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.verifyNewToTrendinLink(driver);
	}

	// ################ Social Elements module ############
	// [TC001]
	@Test(groups = "Module7")
	public void testVerifyLoginPagePopUp() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.verifyBrandLogosOnTheLoginPage(driver);
	}

	// [TC002]
	@Test(groups = "Module7")
	public void testNewToTrendInPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyLoginPageDetails(driver);

	}

	// [TC003]
	@Test(groups = "Module7")
	public void testNewToTrendInSignUpPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyLoginPageDetails(driver);

	}

	// [TC004]
	@Test(groups = "Module7")
	public void testVerifyMouseOverActionOnGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
	}

	// [TC005]
	@Test(groups = "Module7")
	public void testVerifyClickOnGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.signInWithGoogle(driver);
	}

	// [TC-006]
	@Test(groups = "Module7")
	public void testVerifyColorChangeOnMouseOverGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.verifyGmailPage(driver);
	}

	// [TC-007]
	@Test(groups = "Module7")
	public void testverifyErorMessageOnEmptyEmailTextField() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.verifyGmailPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
	}

	// [TC-008]
	@Test(groups = "Module7")
	public void testErrorPasswordEmptyTextfield() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.verifyGmailPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
	}

	// [TC-009]
	@Test(groups = "Module7")
	public void testEmailAndPasswordTextfield() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.verifyGmailPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
	}

	// [TC-010]
	@Test(groups = "Module7")
	public void testGmailUsernameInHomePage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.verifyGmailPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
		loginPage.verifyUserNameInHomePage(driver);
	}

	// [TC-11]
	@Test(groups = "Module7")
	public void testLoginOrRegisterPageAgain() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.verifyBrandLogosOnTheLoginPage(driver);

	}

	// [TC-12]
	@Test(groups = "Module7")
	public void testVerifyNewToTrendInButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.verifyBrandLogosOnTheLoginPage(driver);

	}

	// [TC-13]
	@Test(groups = "Module7")
	public void testVerifyNewToTrendInSignUpPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyLoginPageDetails(driver);

	}

	// [TC014]
	@Test(groups = "Module7")
	public void testVerifyMouseOverActionOnSignInWithGoogle() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
	}

	// [TC015]
	@Test(groups = "Module7")
	public void testVerifyClickOnSignInWithGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButton(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.signInWithGoogle(driver);
	}

	// [TC016]
	@Test(groups = "Module7")
	public void testVerifyClickOnSignInFacebookButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverFacebookButton(driver);
		loginPage.validateSignInWithFacebookButtonInLoginPage(driver);
		loginPage.verifyFacebookPage(driver);

	}

	// [TC017]
	@Test(groups = "Module7")
	public void testVerifyFacebookEmailAndPasswordTextFields() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverFacebookButton(driver);
		loginPage.validateSignInWithFacebookButtonInLoginPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);

	}

	// [TC018]
	@Test(groups = "Module7")
	public void testVerifyLoginToTrendInWithFaceBookAccount() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.loginOrRegister(driver);
		loginPage.verifyLoginPageDetails(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.newToTrendInButton(driver);
		loginPage.verifyColorChangeOnMouseOverFacebookButton(driver);
		loginPage.validateSignInWithFacebookButtonInLoginPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);
		loginPage.verifyUserNameInHomePage(driver);

	}

	// [TC019]
	@Test(groups = "Module7")
	public void testVerifyNewUserRadioButtonInMyAccountPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC020]
	@Test(groups = "Module7")
	public void testVerifyFacebookButtonInmYAccountPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);

	}

	////////////////////////////////////
	// [TC021]
	@Test(groups = "Module7")
	public void testVerifyMyAccountExistingUserAndNewUserPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC022]
	@Test(groups = "Module7")
	public void testVerifyMyAccountNewUserPageConnectFaceBookPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);

	}

	// [TC023]
	@Test(groups = "Module7")
	public void testVerifyLoginToFacebook() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);

	}

	// [TC024]
	@Test(groups = "Module7")
	public void testVerifyLoginToFacebookAtVerifyPersonalInformation() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyPersonalInformationPageInMyAccountPage(driver);

	}

	// [TC025]
	@Test(groups = "Module7")
	public void testVerifyMyAccountPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
	}

	// [TC026]
	@Test(groups = "Module7")
	public void testVerifyMyAccountNewUserPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC027]
	@Test(groups = "Module7")
	public void testVerifyMyAccountNewUserGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC028]
	@Test(groups = "Module7")
	public void testVerifyMyAccountNewUserGooglePage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC029]
	@Test(groups = "Module7")
	public void testVerifyMyAccountNewUserGooglePageLogos() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyGmailPageLogos(driver);

	}

	// [TC030]
	@Test(groups = "Module7")
	public void testVerifyMyAccountNewUserGooglePageFields() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyGmailPageLogos(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);

	}

	// [TC031]
	@Test(groups = "Module7")
	public void testVerifyGooglePageEmailAndPasswordTextfields() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyPersonalInformationPageInMyAccountPageAfterNavigateFromGoogle(driver);
	}

	// [TC032]
	@Test(groups = "Module7")
	public void testMyAccountMyOrderPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyOnContactUsOptionsInFooterLinks(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);

	}

	// [TC033]
	@Test(groups = "Module7")
	public void testMyAccountMyOrderNewUserPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyOnContactUsOptionsInFooterLinks(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC034]
	@Test(groups = "Module7")
	public void testMyAccountMyOrderNewUserPageGoogleColorChangeOnGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyOnContactUsOptionsInFooterLinks(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);

	}

	// [TC035]
	@Test(groups = "Module7")
	public void testMyAccountMyOrderNewUserPageGoogleColorChangeOnFacebookButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyOnContactUsOptionsInFooterLinks(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC036]
	@Test(groups = "Module7")
	public void testMyAccountMyOrderNewUserPageGoogleClickOnFacebookButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);

	}

	// [TC037]
	@Test(groups = "Module7")
	public void testMyAccountMyOrderNewUserPageFacebookButtonPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);
	}

	// [TC038]
	@Test(groups = "Module7")
	public void testMyAccountMyOrderNewUserValidCredentialsOnGoogle() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyPersonalInformationPageInMyAccountPageAfterNavigateFromGoogle(driver);
		loginPage.clickOnLeftPanelSelectedMenu(driver);
		loginPage.verifyOrderReturn(driver);

	}

	// [TC039]
	@Test(groups = "Module7")
	public void testVerifyClickOnMyOrder() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
	}

	// [TC040]
	@Test(groups = "Module7")
	public void testVerifyMyAccountMyOrder() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.verifyOnMyAccountsOptionsInFooterLinks(driver);
		loginPage.verifyAboutUsOptions(driver);
		loginPage.verifyGroupSitesOptions(driver);
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);

	}

	// [TC041]
	@Test(groups = "Module7")
	public void testVerifyMyAccountMyOrderLinkNewUser() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC042]
	@Test(groups = "Module7")
	public void testVerifyMyAccountMyOrderLinkNewUserMouseOverOnGoogle() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
	}

	// [TC043]
	@Test(groups = "Module7")
	public void testVerifyMyAccountMyOrderLinkNewUserPageClickOnGmailButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
	}

	// [TC044]
	@Test(groups = "Module7")
	public void testVerifyMyAccountMyOrderNewUserGmailPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC045]
	@Test(groups = "Module7")
	public void testVerifyMyAccountMyOrderNewUserLogIntoGmail() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
	}

	// [TC046]
	@Test(groups = "Module7")
	public void testVerifyMyAccountMyOrderNewUserLogInToGmailTextFields() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyOrderInTheFooterLink(driver);
		loginPage.verifyTinyLoginIcon(driver);
		homePage.verifyHomePageLogo(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
		loginPage.clickOnMyAccountLink(driver);
		loginPage.verifyPersonalInformationPageInMyAccountPageAfterNavigateFromGoogle(driver);

	}

	// [TC048]
	@Test(groups = "Module7")
	public void testVeifyReturnsOrRefundsPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);

	}

	// [TC049]
	@Test(groups = "Module7")
	public void testVerifyReturnsOrRefundsNewUserPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
	}

	// [TC050]
	@Test(groups = "Module7")
	public void testVerifyReturnsOrRefundsNewUserPageMouseOverOnGoogle() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);

	}

	// [TC051]
	@Test(groups = "Module7")
	public void testVerifyReturnsAndRefundsNewUserPageClickOnFacebookButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}

	// [TC052]
	@Test(groups = "Module7")
	public void testVerifyReturnsAndRefundsNewUserPageVerifyFacebookPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);
	}

	// [TC053]
	@Test(groups = "Module7")
	public void testVerifyReturnsAndRefundsNewUserPageVerifyFacebookPageTextFields() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);

	}

	// [TC054]
	@Test(groups = "")
	public void testVerifyReturnsAndRefundsNewUserPageVerifyOrderHistoryPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyOrderHistoryPage(driver);

	}

	// [TC057]
	@Test(groups = "")
	public void testVerifyReturnsAndRefundsNewUserPageClickOnGoogleButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
	}

	// [TC058]
	@Test(groups = "")
	public void testverifyReturnsAndRefundsNewUserPageVerifyGooglePage() throws Exception {
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyFacebookPage(driver);
		loginPage.verifyLoginToFacebook(driver);

	}

	// [TC061]
	@Test(groups = "Module7")
	public void testVerifyReturnsRefundsPersonalInformationWhenlogsIntoGoogleAccount() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyForTopButton(driver);
		loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyGmailPageLogos(driver);
		loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
		loginPage.verifyErrorMessageOnPasswordTextfield(driver);
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyOrderHistoryPage(driver);

	}

	// [TC062]
	@Test(groups = "Module7")
	public void testVerifyMyAddressExistingUserPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyForTopButton(driver);
	}

	// [TC063]
	@Test(groups = "Module7")
	public void testVerifyMyAddressNewUserPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyForTopButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
	}

	// [TC064]
	@Test(groups = "Module7")
	public void testVerifyMyAddressNewUserFaceBookButton() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyForTopButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
	}

	// [TC065]
	@Test(groups = "Module7")
	public void testVerifyMyAddressNewUserFaceBookPage() throws Exception {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnMyAccountOptionLabels(driver);
		loginPage.verifyHomePageDetailsInOtherPages(driver);
		loginPage.verifyMyAccountPage(driver);
		loginPage.verifyForTopButton(driver);
		loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
		loginPage.verifyMyAccountNewUserPage(driver);

	}
	
	// [TC066]
		@Test(groups = "Module7")
		public void testVerifyMyAddressNewUserFaceBookPageLogos() throws Exception {
			LoginPage loginPage = new LoginPage();
			loginPage.clickOnMyAccountOptionLabels(driver);
			loginPage.verifyHomePageDetailsInOtherPages(driver);
			loginPage.verifyMyAccountPage(driver);
			loginPage.verifyForTopButton(driver);
			loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
			loginPage.verifyMyAccountNewUserPage(driver);
			loginPage.verifyFacebookPage(driver);
		}
		
		// [TC067]
				@Test(groups = "Module7")
				public void testVerifyMyAddressNewUserFaceBookLogin() throws Exception {
					LoginPage loginPage = new LoginPage();
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyHomePageDetailsInOtherPages(driver);
					loginPage.verifyMyAccountPage(driver);
					loginPage.verifyForTopButton(driver);
					loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
					loginPage.verifyMyAccountNewUserPage(driver);
					loginPage.verifyFacebookPage(driver);
					loginPage.verifyLoginToFacebook(driver);
				}
				
				// [TC068]
				@Test(groups = "Module7")
				public void testVerifyNewUserFaceBookLoginMyAddressPage() throws Exception {
					LoginPage loginPage = new LoginPage();
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyHomePageDetailsInOtherPages(driver);
					loginPage.verifyMyAccountPage(driver);
					loginPage.verifyForTopButton(driver);
					loginPage.verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(driver);
					loginPage.verifyMyAccountNewUserPage(driver);
					loginPage.verifyFacebookPage(driver);
					loginPage.verifyLoginToFacebook(driver);
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyMyAddressesPage(driver);
				}
				
				// [TC070]
				@Test(groups = "Module7")
				public void testVerifyMyAddressNewUserGoogleButton() throws Exception {
					LoginPage loginPage = new LoginPage();
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyHomePageDetailsInOtherPages(driver);
					loginPage.verifyMyAccountPage(driver);
					loginPage.verifyForTopButton(driver);
					loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
					loginPage.verifyMyAccountNewUserPage(driver);

				}
				
				// [TC071]
				@Test(groups = "Module7")
				public void testVerifyMyAddressNewUserGooglePage() throws Exception {
					LoginPage loginPage = new LoginPage();
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyHomePageDetailsInOtherPages(driver);
					loginPage.verifyMyAccountPage(driver);
					loginPage.verifyForTopButton(driver);
					loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
					loginPage.verifyMyAccountNewUserPage(driver);
					loginPage.verifyGmailPageLogos(driver);
				}
				
				// [TC072]
				@Test(groups = "")
				public void testVerifyMyAddressNewUserGoogleLogin() throws Exception {
					LoginPage loginPage = new LoginPage();
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyHomePageDetailsInOtherPages(driver);
					loginPage.verifyMyAccountPage(driver);
					loginPage.verifyForTopButton(driver);
					loginPage.verifyColorChangeOnMouseOverGoogleButtonInNewUser(driver);
					loginPage.verifyMyAccountNewUserPage(driver);
					loginPage.verifyGmailPageLogos(driver);
					loginPage.verifyErorMessageOnEmptyEmailTextField(driver);
					loginPage.verifyErrorMessageOnPasswordTextfield(driver);

				}
				
				// [TC073]
				@Test(groups = "")
				public void testVerifyMyPersonalInfoExistingUserPage() throws Exception {
					LoginPage loginPage = new LoginPage();
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyHomePageDetailsInOtherPages(driver);
					loginPage.verifyMyAccountPage(driver);
					loginPage.verifyForTopButton(driver);

				}
				
				// [TC074]
				@Test(groups = "")
				public void testVerifyMyPersonalInfoNewUserPage() throws Exception {
					LoginPage loginPage = new LoginPage();
					loginPage.clickOnMyAccountOptionLabels(driver);
					loginPage.verifyHomePageDetailsInOtherPages(driver);
					loginPage.verifyMyAccountPage(driver);
					loginPage.verifyForTopButton(driver);
					loginPage.verifyMyAccountNewUserPage(driver);
				}


}
