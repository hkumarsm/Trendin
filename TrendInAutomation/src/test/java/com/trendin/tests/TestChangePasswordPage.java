package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.ExcelReader;
import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.ChangePasswordPage;
import com.trendin.pages.LoginPage;

public class TestChangePasswordPage extends TrendInTestSuite {

	// To enter labels of change password textfields [TC-01] [Pass]
	@Test(groups = "Module4",priority=1)
	public void testChangePasswordAccountPage() throws Exception {
		// >>>>>> Data Provider <<<<<<<< //
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		
		// >>>>>> Methods <<<<<<< //
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
	}
	//To verify the valid values for change password textfields[TC-02][Pass]
	@Test(groups = "Module4",priority=2)
	public void testModifyOldPassword() throws Exception {
		// >>>>>> Data Provider <<<<<<<< //
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		String confirmPassword = ExcelReader.getValue("ConfirmPassword");
		String passwordChangeSuccessMessage = "Password Successfully Changed !!";
		
		// >>>>>> Methods <<<<<<< //
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.verifyChangePasswordFunctionality(driver, oldPassword, newPassword, confirmPassword, passwordChangeSuccessMessage);
	}
	//To verfiy the validation message when user enter invalid data in new and confirm password textfield[TC-4]
	@Test(groups = "Module4",priority=4)
	public void testValidateErrorMessageForPasswordTextfieldsBothNull() throws Exception {
		// >>>>>> Data Provider <<<<<<<< //
		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		String newPassword = ExcelReader.getValue("NewPasswordValue_Null");
		String confirmPassword = ExcelReader.getValue("ConfirmPassword_Null");
		String newPasswordErrorWhenNull = ExcelReader.getValue("NewPasswordValue_Null_Error");
		String confirmPasswordErrorWhenNull = ExcelReader.getValue("ConfirmPassword_Null_Error");
		String errorMessages [] = {newPasswordErrorWhenNull,confirmPasswordErrorWhenNull};
		
		// >>>>>> Methods <<<<<<< //
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateErrorMessageForChangePassword(driver, oldPassword, newPassword, confirmPassword, errorMessages);
	}
	
	//To verfiy the validation message when user enter invalid data in confirm  password textfield[TC-3]
	@Test(groups = "Module4",priority=3)
	public void testValidateErrorMessageForNewAndConfirmPasswordMismatchWithValidOldPass() throws Exception {
		// >>>>>> Data Provider <<<<<<<< //
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");  
		String oldPassword = ExcelReader.getValue("OldPasswordValue_Valid");
		String newPassword = ExcelReader.getValue("NewPasswordValue_Valid");
		String confirmPassword = ExcelReader.getValue("ConfirmPassword_NotMatch");
		String newPasswordsMismatch = ExcelReader.getValue("NewAndConfirmPassword_Mismatch_Error");
		String errorMessages [] = {newPasswordsMismatch};
		
		// >>>>>> Methods <<<<<<< //
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateErrorMessageForChangePassword(driver, oldPassword, newPassword, confirmPassword, errorMessages);
	}
	
	
	//To verfiy the validation message when user enter invalid data in all the textfield of change password page[TC-5]
	@Test(groups = "Module4",priority=5)
	public void testValidateErrorMessageForAllFieldsBlankValues() throws Exception {
		// >>>>>> Data Provider <<<<<<<< //
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");  
		String oldPassword = ExcelReader.getValue("OldPasswordValue_Blank");
		String newPassword = ExcelReader.getValue("NewPasswordValue_Blank");
		String confirmPassword = ExcelReader.getValue("ConfirmPassword_Blank");
		String oldPasswordBlank = ExcelReader.getValue("OldPassword_Blank_Error");
		String newPasswordBlank = ExcelReader.getValue("NewPassword_Blank_Error");
		String confirmPassBlank = ExcelReader.getValue("ConfirmPassword_Blank_Error");
		String errorMessages [] = {oldPasswordBlank, newPasswordBlank, confirmPassBlank};
		
		// >>>>>> Methods <<<<<<< //
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateErrorMessageForChangePassword(driver, oldPassword, newPassword, confirmPassword, errorMessages);
	}
	
//To verify that user should not be allowed when user enters the invalid values in old and confirm password textfields[TC-6]
	@Test(groups = "Module4",priority=6)
	public void testValidateInvalidOldPassword() throws Exception {
		// >>>>>> Data Provider <<<<<<<< //
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");  
		String oldPassword = ExcelReader.getValue("OldPasswordValue_Wrong");
		String newPassword = ExcelReader.getValue("NewPasswordValue_Valid");
		String confirmPassword = ExcelReader.getValue("ConfirmPassword_Valid");
		String oldPasswordBlank = ExcelReader.getValue("OldPassword_Wrong_Error");
		String errorMessages [] = {oldPasswordBlank};
		
		// >>>>>> Methods <<<<<<< //
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateErrorMessageForChangePassword(driver, oldPassword, newPassword, confirmPassword, errorMessages);
	}
	
	//To verify that user should not be allowed when user enters the invalid values in old and confirm password textfields[TC-7]
	@Test(groups = "Module4", priority=7)
	public void testvalidateInvalidMismatchNewAndCofirmPasswordWithInvalidOldPass() throws Exception {
		// >>>>>> Data Provider <<<<<<<< //
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");  
		String oldPassword = ExcelReader.getValue("OldPasswordValue_InValid");
		String newPassword = ExcelReader.getValue("NewPasswordValue_Valid");
		String confirmPassword = ExcelReader.getValue("ConfirmPassword_NotMatch");
		String newPasswordsMismatch = ExcelReader.getValue("NewAndConfirmPassword_Mismatch_Error");
		String errorMessages [] = {newPasswordsMismatch};
		
		// >>>>>> Methods <<<<<<< //
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateErrorMessageForChangePassword(driver, oldPassword, newPassword, confirmPassword, errorMessages);
	}
	
	/*//To verify that user should not be allowed when user enters the invalid values in old and new password textfields[TC-8]
	@Test(groups = "Module4",priority=8)
	public void testValidateInvalidCofirmPassword() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateInvalidCofirmPassword(driver);
	}*/
	
	
	/*//To verify that user should not be allowed when user enters the invalid values in old and new password textfields[TC-9]
	@Test(groups = "Module4",priority=9)
	public void testValidateInvalidNewPasswordTextField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateInvalidNewPasswordTextField(driver);
	}*/
	
	
	/*//To verify that application is able to display a error message when user enters less than 6 character[TC-10]
	@Test(groups = "Module4" ,priority=10)
	public void testValidateNewPasswordTextField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateNewPasswordTextField(driver);
	}
	//To verify that application is able to accept only 6 character in new password textfield[TC-11]
	@Test(groups = "Module4",priority=11)
	public void testValidateNewPasswordField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changePassword = new ChangePasswordPage();
		loginPage.gotoLoginOrRegisterMenu(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.loginToTrendInAccount(driver, userName, passWord);
		loginPage.gotoMyAccountPage(driver);
		changePassword.gotoChangePasswordPageAndValidate(driver, userName);
		changePassword.validateNewPasswordField(driver);
	}*/
	
	/*@Test(groups = "Module4",priority=12)
	 public void testModifyOldPasswordPreRequisite() throws Exception {
	  LoginPage loginPage = new LoginPage();
	  ChangePasswordPage changePassword = new ChangePasswordPage();
	  loginPage.gotoLoginOrRegisterMenu(driver);
	  loginPage.clickAlreadyRegisteredLink(driver);
	  String userName = ExcelReader.getValue("UserName");
	  String passWord = ExcelReader.getValue("Password");
	  loginPage.loginToTrendInAccount(driver, userName, passWord);
	  loginPage.gotoMyAccountPage(driver);
	  changePassword.gotoChangePasswordPageAndValidate(driver, userName);
	  changePassword.validateChangePasswordMyAccountPage(driver);
	 }*/
}
