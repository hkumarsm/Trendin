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
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
	}
	//To verify the valid values for change password textfields[TC-02][Pass]
	@Test(groups = "Module4",priority=2)
	public void testModifyOldPassword() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateChangePasswordMyAccountPage(driver);
	}
	//To verfiy the validation message when user enter invalid data in new and confirm password textfield[TC-4]
	@Test(groups = "Module4",priority=4)
	public void testvalidateErrorMessageForPasswordTextfields() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateErrorMessageForPasswordTextfields(driver);
	}
	//To verfiy the validation message when user enter invalid data in confirm  password textfield[TC-3]
	@Test(groups = "Module4",priority=3)
	public void testvalidateErrorMessageForPasswordField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateErrorMessageForPassword(driver);
	}
	//To verfiy the validation message when user enter invalid data in all the textfield of change password page[TC-5]
	@Test(groups = "Module4",priority=5)
	public void testvalidateErrorMessageForEmptyPasswordField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateChangePasswordPageFields(driver);
	}
//To verify that user should not be allowed when user enters the invalid values in old and confirm password textfields[TC-6]
	@Test(groups = "Module4",priority=6)
	public void testValidateInvalidOldPassword() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateInvalidOldPassword(driver);
	}
	//To verify that user should not be allowed when user enters the invalid values in old and confirm password textfields[TC-7]
	@Test(groups = "Module4",priority=7)
	public void testvalidateInvalidMismatchNewAndCofirmPassword() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateInvalidMismatchNewAndCofirmPassword(driver);
	}
	//To verify that user should not be allowed when user enters the invalid values in old and new password textfields[TC-8]
	@Test(groups = "Module4",priority=8)
	public void testValidateInvalidCofirmPassword() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateInvalidCofirmPassword(driver);
	}
	//To verify that user should not be allowed when user enters the invalid values in old and new password textfields[TC-9]
	@Test(groups = "Module4",priority=9)
	public void testValidateInvalidNewPasswordTextField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateInvalidNewPasswordTextField(driver);
	}
	//To verify that application is able to display a error message when user enters less than 6 character[TC-10]
	@Test(groups = "Module4" ,priority=10)
	public void testValidateNewPasswordTextField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateNewPasswordTextField(driver);
	}
	//To verify that application is able to accept only 6 character in new password textfield[TC-11]
	@Test(groups = "Module4",priority=11)
	public void testValidateNewPasswordField() throws Exception {
		LoginPage loginPage = new LoginPage();
		ChangePasswordPage changepassword = new ChangePasswordPage();
		loginPage.loginOrRegister(driver);
		loginPage.clickAlreadyRegisteredLink(driver);
		String userName = ExcelReader.getValue("UserName");
		String passWord = ExcelReader.getValue("Password");
		loginPage.verifyExistingUserLogin(driver, userName, passWord);
		changepassword.changePasswordAccountPage(driver);
		changepassword.validateNewPasswordField(driver);
	}
	@Test(groups = "Module4",priority=12)
	 public void testModifyOldPasswordPreRequisite() throws Exception {
	  LoginPage loginPage = new LoginPage();
	  ChangePasswordPage changepassword = new ChangePasswordPage();
	  loginPage.loginOrRegister(driver);
	  loginPage.clickAlreadyRegisteredLink(driver);
	  String userName = ExcelReader.getValue("UserName");
	  String passWord = ExcelReader.getValue("Password");
	  loginPage.verifyExistingUserLogin(driver, userName, passWord);
	  changepassword.changePasswordAccountPage(driver);
	  changepassword.validateChangePasswordMyAccountPage(driver);
	 }
}
