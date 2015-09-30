package com.trendin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class ChangePasswordPage extends TrendInTestSuite {
	final String curApp = "ChangePasswordPage";
	ElementOperation eo = new ElementOperation(curApp);
	
	/**
	 * <p>
	 * <b>Method Name:</b> changePasswordAccountPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the password account page textfield labels

	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */

	public void changePasswordAccountPage(WebDriver driver) throws Exception {
		
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutClickCss", "ChangePasswordPage")));
		act.moveToElement(ele).build().perform();
		WebElement ele1 = driver.findElement(By.xpath(GetElementIdentifier.getProperty("myAccountxpath", "ChangePasswordPage")));
		act.click(ele1).build().perform();
		System.out.println("Successfully clicked on 'My Account'");

		// To click on change password on left side of 'Account & Information'
		// page
		eo.clickElement(driver, "Xpath", "changePasswordButtonXpath");
		addComment("Successfully clicked on 'Change Password' option");

		// To verify 'Email Address' label is displayed
		boolean emailAddressLabel = eo.verifyElementIsDisplayed(driver, "CssSelector", "changePasswordEmailLabelCss");
		try {
			if (emailAddressLabel) {
				addComment("'Email Address' label is displayed:: "+ emailAddressLabel);
			} else {
				throw new POMMethodExecException("'Email Address' label is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("'Email Address' label is not displayed");
		}

		// To verify 'Email Address' text is displayed
		boolean emailAddressText = eo.verifyElementIsDisplayed(driver, "CssSelector", "changePasswordEmailCss");
		try {
			if (emailAddressText) {
				addComment("'Email Address' text is displayed:: "+ emailAddressText);
			} else {
				throw new POMMethodExecException("'Email Address' text is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("'Email Address' text is not displayed", e);
		}

		// To verify 'Old Password' text box is displayed
		boolean oldPasswordText = eo.verifyElementIsDisplayed(driver, "CssSelector", "oldPasswordCss");
		try {
			if (oldPasswordText) {
				addComment("'Old Password' text box is displayed:: "+ oldPasswordText);
			} else {
				throw new POMMethodExecException("'Old Password' text box is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("'Old Password' text box is not displayed", e);
		}

		// To verify 'New Password' text box is displayed
		boolean newPasswordText = eo.verifyElementIsDisplayed(driver, "CssSelector", "newPasswordCss");
		try {
			if (newPasswordText) {
				addComment("'New Password' text box is displayed:: "+ newPasswordText);
			} else {
				throw new POMMethodExecException("'New Password' text box is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("'New Password' text box is not displayed", e);
		}

		// To verify 'Submit' button is displayed
		boolean submitButton = eo.verifyElementIsDisplayed(driver, "Xpath", "submitButtonXpath");
		try {
			if (submitButton) {
				addComment("'Submit' button is displayed:: "+ submitButton);
			} else {
				throw new POMMethodExecException("'Submit' button is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("'Submit' button is not displayed", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> validateChangePasswordMyAccountPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the change password  functionality.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateChangePasswordMyAccountPage(WebDriver driver) throws Exception {

		// To enter the data in old password textfield
		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");

	}
	/**
	 * <p>
	 * <b>Method Name:</b> validateErrorMessageForPasswordTextfields
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message for invalid values in the confirm and new password textfields
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateErrorMessageForPasswordTextfields(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue1");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clicked on the submit button");

		// To verify the error message for empty value in password textfield
		String errorMesssageForNewPassword = eo.getText(driver, "Xpath", "newPasswordErrorMessageXpath");
		try {
			if (errorMesssageForNewPassword.equalsIgnoreCase("Please enter New Password")) {
				addComment("Successfully verified the error message:: "+ errorMesssageForNewPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the new password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the new password textfield", e);
		}

		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "Xpath", "confirmNewPasswordMessageXpath");
		try {
			if (errorMesssageForConfirmNewPassword.equalsIgnoreCase("Please enter Confirm Password")) {
				addComment("Successfully verified the error message:: "+ errorMesssageForConfirmNewPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm new password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm  new password textfield", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> validateErrorMessageForPasswordTextfields
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message for invalid values in theconfirm  password textfields

	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */

	public void validateErrorMessageForPassword(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue1");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue2");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");

		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "Xpath", "confirmNewPasswordErrorMessageXpath");
		try {
			if (errorMesssageForConfirmNewPassword.equalsIgnoreCase("New Password and Confirm Password mismatch.")) {
				addComment("Successfully verified the error message:: "+ errorMesssageForConfirmNewPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm new password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm  new password textfield", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> validateChangePasswordPageFields
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify error message for empty values in all textfields of the change password page.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateChangePasswordPageFields(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");

		// To verify the error message for empty password textfield
		String errorMesssageOldPassword = eo.getText(driver, "Xpath", "oldPasswordErrorMessageXpath");
		try {
			if (errorMesssageOldPassword.equalsIgnoreCase("Please enter your Old Password.")) {
				addComment("Successfully verified the error message:: "+ errorMesssageOldPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the old password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the old password textfield", e);
		}
		// To verify the error message for empty value in password textfield
		String errorMesssageForNewPassword = eo.getText(driver, "Xpath", "newPasswordMessageXpath");
		try {
			if (errorMesssageForNewPassword.equalsIgnoreCase("Password should be minimum 6 characters.")) {
				addComment("Successfully verified the error message:: "+ errorMesssageForNewPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the new password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the new password textfield", e);
		}

		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "Xpath", "confirmNewPasswordErrorMessageXpath");
		try {
			if (errorMesssageForConfirmNewPassword.equalsIgnoreCase("New Password and Confirm Password mismatch.")) {
				addComment("Successfully verified the error message:: "+ errorMesssageForConfirmNewPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm new password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm  new password textfield", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> validateInvalidOldPassword
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the old password functionality
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateInvalidOldPassword(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");

		// To verify the error message for empty password textfield
		String errorMesssageOldPassword = eo.getText(driver, "Xpath", "oldPasswordAlertErrorMessageXpath");
		try {
			if (errorMesssageOldPassword.contains("Old Password Mismatch !!")) {
				addComment("Successfully verified the error message:: "+ errorMesssageOldPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the old password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the old password textfield", e);
		}
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> validateInvalidMismatchNewAndCofirmPassword
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To verify the error message for mismatch values in confirmand new  password
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateInvalidMismatchNewAndCofirmPassword(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
		
		
		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "Xpath", "confirmNewPasswordErrorMessageXpath");
		try {
			if (errorMesssageForConfirmNewPassword.equalsIgnoreCase("New Password and Confirm Password mismatch.")) {
				addComment("Successfully verified the error message:: " + errorMesssageForConfirmNewPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm new password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm  new password textfield", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> validateInvalidCofirmPassword
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message for invalid values in confirm password.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateInvalidCofirmPassword(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
		
		
		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "Xpath", "confirmNewPasswordErrorMessageXpath");
		try {
			if (errorMesssageForConfirmNewPassword.equalsIgnoreCase("New Password and Confirm Password mismatch.")) {
				addComment("Successfully verified the error message:: " + errorMesssageForConfirmNewPassword);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm new password textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for empty value in the confirm  new password textfield", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> validateInvalidNewPasswordTextField
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message for new password textfield
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateInvalidNewPasswordTextField(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
		
		
		// To verify the error message for empty value in password textfield
				String errorMesssageForNewPassword = eo.getText(driver, "Xpath", "newPasswordMessageXpath");
				try {
					if (errorMesssageForNewPassword.equalsIgnoreCase("Password should be minimum 6 characters.")) {
						addComment("Successfully verified the error message:: "+ errorMesssageForNewPassword);
					} else {
						throw new POMMethodExecException("Not able to verify the error message for empty value in the new password textfield");
					}
				} catch (Exception e) {
					throw new POMMethodExecException("Not able to verify the error message for empty value in the new password textfield", e);
				}
}
	
	/**
	 * <p>
	 * <b>Method Name:</b> validateNewPasswordTextField
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the new password textfield by giving less than 6 character
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateNewPasswordTextField(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
	
}
	/**
	 * <p>
	 * <b>Method Name:</b> validateNewPasswordField
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message when we enter the invalid values in new password textfield
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author:: Manasa M G
	 * 
	 */
	public void validateNewPasswordField(WebDriver driver) throws Exception {

		String oldPassword = ExcelReader.getValue("OldPasswordValue");
		eo.enterText(driver, "Xpath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "Xpath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "Xpath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
	
}
}
