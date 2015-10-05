package com.trendin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.Utility;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class ChangePasswordPage extends TrendInTestSuite {
	final String curApp = "ChangePasswordPage";
	ElementOperation eo = new ElementOperation(curApp);
	
	
	/**
	 * 
	 * <p>
	 * <b>Method Name:</b> validateChangePasswordPage
	 * </p>
	 * <p>
	 * <b>Description:</b> Used to validate all the Web elements of the 'Change Password' page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Launch >> Login >> My Accounts >> gotoChangePasswordPage
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>driver: </b> Webdriver object</li>
	 * <li><b>mailIdToVerify: </b> Expected mail id to verify with UI displayed User mail id  </li>
	 * </ul>
	 * </p>
	 * 
	 * @author Manasa M G
	 * 
	 */
	public void gotoChangePasswordPageAndValidate(WebDriver driver, String mailIdToVerify) throws Exception {
		// To click on change password on left side of 'Account & Information' page
		eo.clickElement(driver, "XPath", "changePasswordButtonXpath");
		addComment("Successfully clicked on 'Change Password' option");
		
		Utility.waitUntilClickable(driver, "XPath", "submitButtonXpath", curApp, "60");
		// Verify the H1 header label - 'Change Password'
		boolean h1HeaderLabelStatus = eo.verifyElementIsDisplayed(driver, "XPath", "changePasswordH1LabelXpath");
		assertTrue(h1HeaderLabelStatus, "'Change Password' header label is displayed.", "'Change Password' header label is not displayed.");
		
		// Verify the 'E-mail Address:' label
		boolean emailAddressLabel = eo.verifyElementIsDisplayed(driver, "XPath", "changePasswordEmailLabelXpath");
		assertTrue(emailAddressLabel, "'E-mail Address:' label is displayed.", "'E-mail Address:' label is not displayed.");
		
		// verify the 'E-mail address' of the user is as expected
		String uiEmailIdText = eo.getText(driver, "cssSelector", "changePasswordEmailCss");
		addComment("User E-mail id displayed in UI: "+ uiEmailIdText);
		assertEquals(uiEmailIdText, mailIdToVerify, "User E-mail id is as expected.", "User E-mail id is not as expected.");
		
		// Verify the change password Labels  and text box are present.
		String changePasswordExpLabels [] = {"Old Password:","New Password:","Confirm Password:"};
		String changePasswordLabelsXpath = GetElementIdentifier.getProperty("changePasswordLabelsXpath", curApp);
		String tempXpath = "";
		boolean labelDisplayed = false;
		for(int labels=0; labels<changePasswordExpLabels.length; labels++) {
			tempXpath = changePasswordLabelsXpath.replace("{labelName}", changePasswordExpLabels[labels]);
			labelDisplayed = driver.findElement(By.xpath(tempXpath)).isDisplayed();
			assertTrue(labelDisplayed, "Label and text box for: "+ changePasswordExpLabels[labels] + ", is displayed successfully.", "Label and text box for: "+ changePasswordExpLabels[labels] + ", is not displayed in UI.");
		}
		
		// Verify the 'Submit' button is displayed
		boolean submitButtonStatus = eo.verifyElementIsDisplayed(driver, "XPath", "submitButtonXpath");
		assertTrue(submitButtonStatus, "'Submit' button is displayed in UI.", "'Submit' button is not displayed in UI.");
	}

	/**
	 * 
	 * <p>
	 * <b>Method Name:</b> verifyChangePasswordFunctionality
	 * </p>
	 * <p>
	 * <b>Description:</b> This method is used to verify the functionality of 'Change Password' (changing password)
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Lanuch >> Login >> My Account >> Change Password
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>driver: </b> Webdriver object  </li>
	 * <li><b>oldPassword: </b> Old password value  </li>
	 * <li><b>newPassword: </b>  New Password value to be changed </li>
	 * <li><b>confirmPassword: </b> Confirm the new password to be changed  </li>
	 * </ul>
	 * </p>
	 * 
	 * @author Manasa M G
	 * 
*/
	public void verifyChangePasswordFunctionality(WebDriver driver, String oldPassword, String newPassword, String confirmPassword, String expSuccessMess) throws Exception {

		// To enter the data in old password textfield
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password: "+ oldPassword);

		// To enter the data in the new password textfield
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password: "+ newPassword);

		// To enter the data in the confirm password textfield
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmPassword);
		addComment("Successfully enterd the confirm password: "+ confirmPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
		
		// wait and verify the Change Password success message
		Utility.waitUntilExists(driver, "XPath", "changePasswordSuccessLabelXpath", curApp);
		boolean successMessageInUI = eo.verifyElementIsDisplayed(driver, "XPath", "changePasswordSuccessLabelXpath");
		assertTrue(successMessageInUI, "Password Changed success message displayed in UI.", "Password Changed success message is not displayed in UI.");
		
		// close the succcess message label
		eo.clickElement(driver, "XPath", "closePasswordSuccessMessXpath");
		addComment("Successfully clicked on the 'Close' option of the Password changed success message");
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
	public void validateErrorMessageForChangePassword(WebDriver driver, String oldPassword, String newPassword, String confirmPassword, String ... messages) throws Exception {
		// To enter the data in the Old password textfield
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clicked on the submit button");

		// Split the Error messages..
		String errorMessagesXpath = GetElementIdentifier.getProperty("errorMessagesXpath", curApp);
		String tempXpath = "";
		for(int i=0; i<messages.length; i++) {
			tempXpath = errorMessagesXpath.replace("{errorMessage}", messages[i]);
			try {
				if(driver.findElement(By.xpath(tempXpath)).isDisplayed()){
					addComment("Successfully verified the Error message: "+ messages[i]);
				}
			} catch(Exception e1) {
				String oldPassMismatchErrorMessXpath = GetElementIdentifier.getProperty("oldPassMismatchErrorMessXpath", curApp);
				oldPassMismatchErrorMessXpath = oldPassMismatchErrorMessXpath.replace("{errorMessage}", messages[i]);
				try {
					if(driver.findElement(By.xpath(oldPassMismatchErrorMessXpath)).isDisplayed()){
						addComment("Successfully verified the Error message: "+ messages[i]);
					}
				} catch(Exception e2){
					throw new POMMethodExecException("Not able to verify the Password Error message: "+ messages[i], e2);
				}
			}
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue2");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");

		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "XPath", "confirmNewPasswordErrorMessageXpath");
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");

		// To verify the error message for empty password textfield
		String errorMesssageOldPassword = eo.getText(driver, "XPath", "oldPasswordErrorMessageXpath");
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
		String errorMesssageForNewPassword = eo.getText(driver, "XPath", "newPasswordMessageXpath");
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
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "XPath", "confirmNewPasswordErrorMessageXpath");
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: "+ oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: "+ newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: "+ confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");

		// To verify the error message for empty password textfield
		String errorMesssageOldPassword = eo.getText(driver, "XPath", "oldPasswordAlertErrorMessageXpath");
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
		
		
		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "XPath", "confirmNewPasswordErrorMessageXpath");
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
		
		
		// To verify the error message for empty value in password textfield
		String errorMesssageForConfirmNewPassword = eo.getText(driver, "XPath", "confirmNewPasswordErrorMessageXpath");
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
		
		
		// To verify the error message for empty value in password textfield
				String errorMesssageForNewPassword = eo.getText(driver, "XPath", "newPasswordMessageXpath");
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
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
		eo.enterText(driver, "XPath", "oldPasswordTextFieldXpath", oldPassword);
		addComment("Successfully entered the old password:: " + oldPassword);

		// To enter the data in the new password textfield
		String newPassword = ExcelReader.getValue("NewPasswordValue");
		eo.enterText(driver, "XPath", "newPasswordTextfieldXpath", newPassword);
		addComment("Successfully entered the new password:: " + newPassword);

		// To enter the data in the confirm password textfield
		String confirmNewPassword = ExcelReader.getValue("NewPasswordValue1");
		eo.enterText(driver, "XPath", "confirmNewPasswordTextfield", confirmNewPassword);
		addComment("Successfully enterd the confirm password:: " + confirmNewPassword);

		// To click on the submit button
		eo.clickElement(driver, "XPath", "submitButtonXpath");
		addComment("Successfully clickd on the submit button");
	
}
}
