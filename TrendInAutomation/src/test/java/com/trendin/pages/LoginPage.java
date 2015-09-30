package com.trendin.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class LoginPage extends TrendInTestSuite {
	
	final String curApp = "LoginPage";
	ElementOperation eo = new ElementOperation(curApp);

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTinyLoginIcon
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the login icon is displayed or not
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To verify Login/Register icon displays[TC_01]
	public void verifyTinyLoginIcon(WebDriver driver) throws Exception {
		eo.wait(3000);
		// To verify Login/Register icon displays
			boolean logoDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "loginIconXpath");
			assertTrue(logoDisplayed, "Login/Register icon is displayed", "Login/Register icon is not displayed");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> loginOrRegister
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the login or register icon
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To click on Login or Register button.
	public void loginOrRegister(WebDriver driver) throws Exception {
		// To click on Login or Register button.
		eo.wait(2000);
		boolean pageStatus = false;
		eo.clickElement(driver, "XPath", "loginIconXpath");
		addComment("Clicked on Login or Register Button.");
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "verifyLoginPageXpath");
			if (pageStatus) {
				addComment("Login/Register page is displayed");
				break;
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickLoginOrRegister
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on login or register button
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */

	// To click on Login or Register button.
	public void clickLoginOrRegister(WebDriver driver) throws Exception {
		// To click on Login or Register button.
			eo.clickElement(driver, "XPath", "loginregisterLinkXpath");
			addComment("Clicked on Login or Register Button.");
		eo.wait(2000);
		// To validate the Login or Register page
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "verifyLoginPageXpath");
		assertTrue(pageStatus, "Login/Register page is displayed", "Login/Register page is not displayed");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyLoginPageDetails
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the Sign up page values are displayed(Text
	 * box, labels and buttons are displayed)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	public void verifyLoginPageDetails(WebDriver driver) throws Exception {
		// To verify Login/Register header is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginTextXpath");
			addComment("Login/Register header is displayed");
		// To verify 'Sign Up' title is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginSignUpXpath");
			addComment("Sign up text is displayed");
		// To verify 'Your Name' label is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "yourNameLabelXpath");
			addComment("Your Name label is displayed");
		// To verify 'Your Name' text box is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginFirstNameXpath");
			addComment("Name Text box is displayed");
		// To verify 'Email Address' label is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "emailLabelXpath");
			addComment("Email Address label is displayed");
		// To verify 'Email Address' text box is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginEmailXpath");
			addComment("Email Address text box is displayed");
		// To verify 'password' label is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "passwordLabelXpath");
			addComment("Password label is displayed");
		// To verify 'password' text box is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginPasswordXpath");
			addComment("Password text box is displayed");
		// To verify 'Mobile number' label is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "mobileNumberLabelXpath");
			addComment("Mobile number label is displayed");
		// To verify 'Mobile number' text box is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginMobileNumberXpath");
			addComment("Mobile number text is displayed");
		// To verify 'Terms and Policy' label is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "termsPolicyLabelXpath");
			addComment("Terms and policy text is displayed");
		// To verify 'For Him' button is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginForHimXpath");
			addComment("For him button is displayed");
		// To verify 'For Her' button is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "loginForHerXpath");
			addComment("For her button is displayed");
		// To verify 'Sign up with Google' button is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "signInWithgoogleXpath");
			addComment("Sign up with Google button is displayed");
		// To verify 'Sign up with Facebook' button is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "signInWithFacebookXpath");
			addComment("Sign up with Facebook button is displayed");
		// To verify 'Already Registered Link' is displayed
			eo.verifyElementIsDisplayed(driver, "XPath", "alreadyRegisteredXpath");
			addComment("Already Registered Link is displayed");
	}

	// To Click on 'Already Registered Link'.
	public void clickAlreadyRegisteredLink(WebDriver driver) throws Exception {
		// To click on 'Already Registered Link'
			eo.wait(2000);
			eo.clickElement(driver, "XPath", "alreadyRegisteredXpath");
			addComment("Already registered link is clicked");
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "existingUserPageXpath");
		assertTrue(pageStatus, "Existing user page is displayed", "Existing User page is not displayed");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyExistingPageDisplayDetails
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify existing user page details(Text box, labels
	 * and buttons are displayed)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	public void verifyExistingPageDisplayDetails(WebDriver driver) throws Exception {

		// To verify 'Existing User' title

		boolean existingUserLabel = eo.verifyElementIsDisplayed(driver, "XPath", "existingUserLabelXpath");
			if (existingUserLabel) {
				addComment("Existing User label is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Existing User label");
			}

		// To verify 'Email Address' label

		boolean emailLabel = eo.verifyElementIsDisplayed(driver, "XPath", "emailExistingUserXpath");
			if (emailLabel) {
				addComment("Email Address label is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Email Address label");
			}
		// To verify 'Email Address' text box

		boolean emailTextBox = eo.verifyElementIsDisplayed(driver, "XPath", "existingEmailXpath");
			if (emailTextBox) {
				addComment("Email Address text is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Email Address text");
			}
		// To verify 'Password' label

		boolean passwordLabel = eo.verifyElementIsDisplayed(driver, "XPath", "passwordExistingXpath");
			if (passwordLabel) {
				addComment("Password label is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Password label");
			}
		// To verify 'Password' text box

		boolean passwordText = eo.verifyElementIsDisplayed(driver, "XPath", "existingPasswordXpath");
			if (passwordText) {
				addComment("Password Text is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Password Text");
			}
		// To verify 'Login' button is displayed

		boolean loginButton = eo.verifyElementIsDisplayed(driver, "XPath", "existingLoginButtonXpath");
			if (loginButton) {
				addComment("Login button is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Login button");
			}

		// To verify 'Forgot Password Link' is displayed

		boolean forgotPasswordLink = eo.verifyElementIsDisplayed(driver, "CssSelector", "forgotPasswordLinkCss");
			if (forgotPasswordLink) {
				addComment("Forgot password link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Forgot password link");
			}

		// To verify 'New TrendIn Link' is displayed

		boolean newTrendInLink = eo.verifyElementIsDisplayed(driver, "CssSelector", "newToTrendInCss");
			if (newTrendInLink) {
				addComment("New to trend in link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the New to trend in link");
			}

		// To verify 'Sign in with google' button is displayed

		boolean signInGoogle = eo.verifyElementIsDisplayed(driver, "XPath", "signInWithgoogleXpath");
			if (signInGoogle) {
				addComment("Sign in with Google button is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Sign in with Google button");
			}

		// To verify 'Sign in with facebook' button is displayed

		boolean signInFacebook = eo.verifyElementIsDisplayed(driver, "XPath", "signInWithFacebookXpath");
			if (signInFacebook) {
				addComment("Sign in with Facebook button is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Sign in with Facebook button");
			}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> existingUser
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter valid email and password for existing user
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	public void verifyExistingUserLogin(WebDriver driver, String userName, String password) throws Exception {
		// To verify the title
		boolean textDisplayedStatus = eo.verifyElementIsDisplayed(driver, "XPath", "existingUserLabelXpath");
			if (textDisplayedStatus) {
				addComment("Existing User Label is verified");
			} else {
				throw new POMMethodExecException("Not able to verify the Existing User Label");
			}
		// To enter email address
			eo.enterText(driver, "XPath", "existingEmailXpath", userName);
			addComment("Successfully entered the email: " + userName);
		// To enter password
			eo.enterText(driver, "XPath", "existingPasswordXpath", password);
			// driver.findElement(By.xpath(GetElementIdentifier.getProperty("existingPasswordXpath",
			// curApp))).sendKeys(password);
			addComment("Successfully entered the password: " + password);
		// To click on submit button
			eo.clickElement(driver, "XPath", "existingLoginButtonXpath");
			addComment("Successfully clicked on the submit button");
			Thread.sleep(5000);
		// implement the validation for logged in (verify the user name after
		// logging in)

	}

	// To click on forgot password
	public void clickForgotPasswordLink(WebDriver driver) throws Exception {
		// To click on 'Forgot Password' link
			eo.clickElement(driver, "CssSelector", "forgotPasswordLinkCss");
			addComment("Successfully clicked on Forgot Password link");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForgotPasswordPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on forgot password when user log in using
	 * existing user
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	public void verifyForgotPasswordPage(WebDriver driver) throws Exception {

		// To verify 'Forgot password' label is displayed
		eo.wait(3000);
		boolean forgotPasswordLabel = eo.verifyElementIsDisplayed(driver, "Xpath", "forgotPasswordLabelXpath");
			if (forgotPasswordLabel) {
				addComment("Forgot Password label is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Forgot Password label ");
			}
		// To verify 'Email Address' label is displayed

		boolean forgotPasswordEmailLabel = eo.verifyElementIsDisplayed(driver, "Xpath", "forgotPasswordEmailLabel");
			if (forgotPasswordEmailLabel) {
				addComment("Email label is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Email label ");
			}
		// To verify 'Email Address' text box is displayed

		boolean forgotPasswordEmailText = eo.verifyElementIsDisplayed(driver, "id", "forgotPasswordEmailText");
			if (forgotPasswordEmailText) {
				addComment("Email text is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Email text ");
			}
		// To verify 'Captcha code' is displayed

		boolean captchaCodeNumber = eo.verifyElementIsDisplayed(driver, "Xpath", "captureNumberXpath");
			if (captchaCodeNumber) {
				addComment("Captcha code is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Captcha code ");
			}
		// To verify 'Refresh button' is displayed

		boolean refreshButton = driver.findElement(By.xpath(GetElementIdentifier.getProperty("refreshButtonXpath", curApp))).isDisplayed();
			if (refreshButton) {
				addComment("Refresh button is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Refresh button ");
			}

		// To verify 'Captcha' text box is displayed

		boolean captchaTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "captureTextXpath");
			if (captchaTextBox) {
				addComment("Captcha text box is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Captcha text box ");
			}
		// To verify 'Forgot Password' button is displayed

		boolean forgotPasswordButton = eo.verifyElementIsDisplayed(driver, "Xpath", "forgotPasswordButton");
			if (forgotPasswordButton) {
				addComment("'Forgot your Password' button is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the 'Forgot your Password' button ");
			}
	}

	// To click close on login/register pop up and forgot password pop up
	public void clickClose(WebDriver driver) throws Exception {
			eo.clickElement(driver, "Xpath", "clickCloseXpath");
			addComment("Successfully clicked on close button");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickLogoutTrendIn
	 * 
	 * <p>
	 * <b>Description:</b> To Logout from the trendIn.com
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */

	// To logout from the application
	public void clickLogoutTrendIn(WebDriver driver) throws Exception {
		Actions act = new Actions(driver);
		try{
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutClickCss", curApp)));
		act.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutButtonCss", curApp)));
		act.click(ele1).build().perform();
		addComment("Clicked on logout");
		} catch (Exception e){
			throw new POMMethodExecException("Could not click on logout" ,e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyMyAccount
	 * 
	 * <p>
	 * <b>Description:</b> To click on 'My Account' link from tiny header
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To click on 'My Account' link from tiny header (TC-014)
	public void verifyMyAccount(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		try {
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutClickCss", curApp)));
		act.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath(GetElementIdentifier.getProperty("myAccountLogoutClick", curApp)));
		act.click(ele1).build().perform();
		addComment("Clicked on My Account");
		} catch (Exception e){
			throw new POMMethodExecException("Could not click on my account ",e);
		}
		// To verify personal information header is displayed

		boolean personalInfoHeader = eo.verifyElementIsDisplayed(driver, "Xpath", "personalInfoTitleCss");
			if (personalInfoHeader) {
				addComment("Personal information header is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Personal information header ");
			}

		// To verify 'Please be sure' title
		// eo.verifyElementIsDisplayed(driver, "cssSelector", "beSuretitleCss");
		// boolean pleaseBeSureTitle = eo.verifyElementIsDisplayed(driver,
		// "cssSelector", "beSuretitleCss");
		/*
		 * try { if (pleaseBeSureTitle) { addComment(
		 * "'Please be sure to update your personal information if it has changed' title is displayed"
		 * ); } else { throw new POMMethodExecException(
		 * "Not able to verify the 'Please be sure to update your personal information if it has changed' title"
		 * ); } } catch (Exception e) { throw new POMMethodExecException(
		 * "Not able to verify the 'Please be sure to update your personal information if it has changed' title"
		 * , e); }
		 */

		// To verify 'Required' text is displayed

		// driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("beSuretitleCss",
		// curApp))).isDisplayed();
		/*
		 * boolean requiredText = eo.verifyElementIsDisplayed(driver,
		 * "cssSelector", "beSuretitleCss"); try { if (requiredText) {
		 * addComment("Required text is displayed"); } else { throw new
		 * POMMethodExecException("Not able to verify the Required text"); } }
		 * catch (Exception e) { throw new POMMethodExecException(
		 * "Not able to verify the Required text", e); }
		 */

		// To verify 'Radio title' text is displayed

		boolean radioTitle = eo.verifyElementIsDisplayed(driver, "Xpath", "radioTitleXpath");
			if (radioTitle) {
				addComment("Radio title text is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Radio title text");
			}

		// To verify 'Radio button' is displayed

		boolean radioButton = eo.verifyElementIsDisplayed(driver, "Xpath", "radioButtonXpath");
			if (radioButton) {
				addComment("Radio button is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Radio button");
			}

		// To verify 'FirstName' text box is displayed

		boolean firstNameTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "firstNameXpath");
			if (firstNameTextBox) {
				addComment("First name is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the First name");
			}

		// To verify 'Email' text box is displayed

		boolean emailTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "emailAccontXpath");
			if (emailTextBox) {
				addComment("Email text box is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Email text box");
			}

		// To verify 'Mobile Number' text box is displayed

		boolean mobileNumberTextbox = eo.verifyElementIsDisplayed(driver, "Xpath", "mobileNumberAccountXpath");
			if (mobileNumberTextbox) {
				addComment("Mobile number text box is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the mobile number text");
			}

		// To verify 'Date of Birth' text box is displayed

		boolean dateOfBirthTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "dateOfBirthXpath");
			if (dateOfBirthTextBox) {
				addComment("Date of birth text box is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Date of birth text");
			}

		// To verify 'Save' button is displayed

		boolean saveButton = eo.verifyElementIsDisplayed(driver, "Xpath", "dateOfBirthXpath");
			if (saveButton) {
				addComment("Save button is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Date of Save button");
			}

		// To verify 'Order history link' is displayed
		boolean orderHistoryLink = eo.verifyElementIsDisplayed(driver, "Xpath", "orderHistoryXpath");
			if (orderHistoryLink) {
				addComment("Order history link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the order history link");
			}

		// To verify 'TrendIn credits' link is displayed

		boolean creditLink = eo.verifyElementIsDisplayed(driver, "Xpath", "orderHistoryXpath");
			if (creditLink) {
				addComment("TrendIn credits link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the trendIn credits link");
			}

		// To verify 'Coupon' link is displayed

		boolean couponLink = eo.verifyElementIsDisplayed(driver, "Xpath", "couponsXpath");
			if (couponLink) {
				addComment("Coupon link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the coupon link");
			}

		// To verify 'Account Information' link is displayed

		boolean informationLink = eo.verifyElementIsDisplayed(driver, "Xpath", "accountInfoXpath");
			if (informationLink) {
				addComment("Account Information link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the account Information link");
			}

		// To verify 'My Addresses' link is displayed

		boolean addressLink = eo.verifyElementIsDisplayed(driver, "Xpath", "myAddressXpath");
			if (addressLink) {
				addComment("My Address link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the My Address link");
			}

		// To verify 'Change Password' link is displayed

		boolean changePasswordLink = eo.verifyElementIsDisplayed(driver, "Xpath", "changePasswordButtonXpath");
			if (changePasswordLink) {
				addComment("Change Password link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the change Password link");
			}

		// To verify 'Logout' link is displayed

		boolean logoutLink = eo.verifyElementIsDisplayed(driver, "Xpath", "logoutButtonXpath");
			if (logoutLink) {
				addComment("Logout link is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the logout link");
			}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> refreshButtonClick
	 * 
	 * <p>
	 * <b>Description:</b> To click on refresh button in forgot password pop up
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To click on refresh button in forgot password pop up (TC - 07)
	public void refreshButtonClick(WebDriver driver) throws Exception {

		String actualText = eo.getText(driver, "Xpath", "captureNumberXpath");
		eo.clickElement(driver, "xpath", "refreshButtonXpath");
		addComment("Successfully clicked on refresh button");
		String changedText = eo.getText(driver, "Xpath", "captureNumberXpath");
		if (actualText.equals(changedText)) {
			addComment("Captcha code is not same after clicking on refresh button");
		} else {
			throw new POMMethodExecException("Captcha code is same after clicking on refresh button");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForgotPasswordFunctionality
	 * 
	 * <p>
	 * <b>Description:</b> To perform operation in Forgot Password Page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To perform operation in Forgot Password Page
	public void verifyForgotPasswordFunctionality(WebDriver driver) throws Exception {
		String inputEmailValue = null, inputCaptchaValue = null;
		String captureText = "";
		// verify for empty email id

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			eo.enterText(driver, "XPath", "captureTextXpath", captureText);
			addComment("Successfully entered the captcha text ");
		// To click on 'Forgot your password' link
		try {
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		} catch (Exception e) {
			throw new POMMethodExecException("Could not click on forgot password link", e);
		}
		// To verify success message

		boolean successMessageStatus1 = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus1, "'Enter email id' is not displayed");
		addComment("Successfully verified for empty email id field and valid captcha field");

		eo.cleardata(driver, "XPath", "captureTextXpath");

		// verify for empty email id and captcha
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message

		boolean successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified for empty email id and empty captcha field");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for empty email id and blank spaces in captcha field
		// To enter 'captured text'
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			captureText = ExcelReader.getValue("CaptureText");
			eo.enterText(driver, "XPath", "captureTextXpath", captureText);
			addComment("Successfully entered the captured text :");
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified for empty email id and blank spaces in captcha field");

		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCapchaErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter captcha code' is not displayed");
		addComment("Successfully verified for empty email id and blank spaces in captcha field");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for empty email id and special characters in captcha field
		// To enter 'captured text'
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for empty email id and numbers in captcha field
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue1");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for empty email id and alphanumerics in captcha field

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue2");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for empty email id and all combinations in captcha field

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue3");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for empty email id and less than 5 values in captcha field

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue4");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");

		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for blank space email id and valid captcha in captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			 captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = captureText;
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for blank space email id and empty in captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message

		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified for blank space email id and empty in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify blank spaces in email id and captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified blank spaces in email id and captcha field");
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCapchaErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter captcha code' is not displayed");
		addComment("Successfully verified blank spaces in email id and captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify blank in email id field and special characters in captcha
		// field
			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified blank in email id field and special characters in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// Verify for blank in email id field and numbers in captcha field

			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue7");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified for blank in email id field and numbers in captcha field.");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for blank email id and alpha numeric in captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue8");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified for blank email id and alpha numeric in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify blank spaces in email id and alpha numeric in captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue3");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified blank spaces in email id and alpha numeric in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for blank spaces in email id and less than 5 value in captcha
		// field
			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue6");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterEmailIdErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Enter email id' is not displayed");
		addComment("Successfully verified for blank spaces in email id and less than 5 value in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and valid captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = captureText;
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment(" Successfully verified for special character in email id and valid captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and empty in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for special character in email id and empty in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and blank spaces in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment(" Successfully verified for special character in email id and blank spaces in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and special character in
		// captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for special character in email id and special character in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and numbers in captcha

			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue7");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for special character in email id and numbers in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and alpha numerics in
		// captcha

			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue8");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for special character in email id and alpha numerics in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and all combinations in
		// captcha

			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue3");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for special character in email id and all combinations in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for special character in email id and less than 5 value in
		// captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue1");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue5");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for special character in email id and less than 5 value in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and valid captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = captureText;
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and valid captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and empty in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and empty in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and blank spaces in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			 captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and blank spaces in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and specials characters in captcha

			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and specials characters in captcha ");

		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and numbers in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue7");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and numbers in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and alpha numerics in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue8");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and alpha numerics in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and alpha numerics in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue3");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and alpha numerics in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for numbers in email id and less than 5 values in captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue2");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue5");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for numbers in email id and less than 5 values in captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and valid captcha

			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = captureText;
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for alpha numeric in email id field and valid captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and empty captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for alpha numeric in email id field and empty captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and blank spaces in
		// captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for alpha numeric in email id field and blank spaces in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and special character in
		// captcha field

			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for alpha numeric in email id field and special character in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and numbers in captcha
		// field
			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue7");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for alpha numeric in email id field and numbers in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and alpha numerics in
		// captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue8");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified  for alpha numeric in email id field and alpha numerics in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and all combinations in
		// captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue3");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for alpha numeric in email id field and all combinations in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for alpha numeric in email id field and less than 5 value in
		// captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue4");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue5");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for alpha numeric in email id field and less than 5 value in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and valid captcha
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = captureText;
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for all combinations in email id field and valid captcha");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and empty in captcha
		// field
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for all combinations in email id field and empty in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and blank spaces in
		// captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment(" Successfully verified for all combinations in email id field and blank spaces in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and special characters
		// in captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for all combinations in email id field and special characters in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and numbers in captcha
		// field
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue7");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for all combinations in email id field and numbers in captcha field.");

		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and alpha numerics in
		// captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue8");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for all combinations in email id field and alpha numerics in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and all combinations in
		// captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = "ABC!@# 123";
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for all combinations in email id field and all combinations in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for all combinations in email id field and less than 5 value
		// in captcha field
			inputEmailValue = ExcelReader.getValue("InputEmailValue3");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue5");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterCorrectEmailErrorXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid email id' is not displayed");
		addComment("Successfully verified for all combinations in email id field and less than 5 value in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");

		// verify valid email id and empty captcha field

			inputEmailValue = ExcelReader.getValue("InputEmailVal");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message

		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterValidCaptchXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter  captcha' is not displayed");
		addComment("Successfully verified valid email id and empty captcha field ");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify valid email id and blank spaces in captcha field

			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterValidCaptchXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter captcha' is not displayed");
		addComment("Successfully verified for valid email id and blank spaces in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify valid email id and special characters in captcha field

			inputEmailValue = ExcelReader.getValue("InputEmailValue");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterValidCaptchXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid captcha' is not displayed");
		addComment("Successfully verified for valid email id and special characters in captcha field ");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify valid email id and numbers in captcha field

			inputEmailValue = ExcelReader.getValue("InputEmailVal");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = "12345657";
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterValidCaptchXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid captcha' is not displayed");
		addComment("Successfully verified for valid email id and numbers in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify valid email id and alpha numerics in captcha field
		eo.wait(5000);
			inputEmailValue = ExcelReader.getValue("InputEmailVal");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue8");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterValidCaptchXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid captcha' is not displayed");
		addComment("Successfully verified for valid email id and alpha numerics in captcha field");
		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify valid email id and all combinations in captcha field
		eo.wait(5000);
			inputEmailValue = ExcelReader.getValue("InputEmailVal");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = "ABC!@# 123";
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterValidCaptchXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid captcha' is not displayed");
		addComment("Successfully verified for valid email id and all combinations in captcha field");

		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify valid email id and less than 5 value in captcha field
		eo.wait(5000);
			inputEmailValue = ExcelReader.getValue("InputEmailVal");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);

			 captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			inputCaptchaValue = ExcelReader.getValue("InputCaptchaValue5");
			eo.enterText(driver, "XPath", "captureTextXpath", inputCaptchaValue);
			addComment("Successfully entered the captured text :" + inputCaptchaValue);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
		// To verify success message
		eo.wait(4000);
		successMessageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "enterValidCaptchXpath");
		Assert.assertTrue(successMessageStatus, "'Please Enter valid captcha' is not displayed");
		addComment("Successfully verified for valid email id and less than 5 value in captcha field");

		eo.cleardata(driver, "Id", "forgotPasswordEmailText");
		eo.cleardata(driver, "XPath", "captureTextXpath");
		// verify for valid email id and valid capcha
		// To enter email in 'Forgot Password' pop up
		eo.wait(6000);
		eo.clickElement(driver, "xpath", "refreshcaptchaXpath");
			inputEmailValue = ExcelReader.getValue("InputEmailVal");
			eo.enterText(driver, "Id", "forgotPasswordEmailText", inputEmailValue);
			addComment("Successfully entered the email :" + inputEmailValue);
		// To enter 'captured text'
			captureText = eo.getText(driver, "XPath", "captureNumberXpath");
			eo.enterText(driver, "xpath", "captureTextXpath", captureText);
			addComment("Successfully entered the captured text :" + captureText);

		// To click on 'Forgot your password' link
			eo.clickElement(driver, "XPath", "forgotPasswordButton");
			addComment("successfully clicked on 'Forgot your Password' link");
			eo.wait(6000);
		// To verify success message

		successMessageStatus = eo.verifyElementIsDisplayed(driver, "CssSelector", "forgotPasswordSuccessMessageCss");
		Assert.assertTrue(successMessageStatus, "'Link to reset your password has been sent to your Mail ID !!' is not displayed");
		addComment("Successfully verified for valid email id and valid captcha");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyDropDownUserName
	 * 
	 * <p>
	 * <b>Description:</b> To verify drop down option in user name
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To verify drop down option in user name
	public void verifyDropDownUserName(WebDriver driver) throws Exception {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutClickCss", curApp)));
		act.moveToElement(ele).build().perform();
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "myAccountxpath");
			addComment("Successfully my account is displayed");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the my account", e);
		}
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "myOrdersXpath");
			addComment("Successfully my orders is displayed");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the my orders", e);
		}
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "returnsXpath");
			addComment("Successfully returns is displayed");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the returns", e);
		}
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "logoutLabelXpath");
			addComment("Successfully logout is displayed");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the logout", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> signInWithFacebook
	 * 
	 * <p>
	 * <b>Description:</b> Navigate to facebook account by clicking on
	 * signInWithFacebook button
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// Sign in with Facebook.
	public void signInWithFacebook(WebDriver driver) throws Exception {
		String expextedFacebookText = "Facebook Login";
		// To click on sign in with facebook link.
		eo.clickElement(driver, "Xpath", "signInWithFacebookXpath");
		Thread.sleep(1000);
		addComment("Clicked on sign In with Facebook link.");
		// To get facebook text.

		String actualFaceBookText = eo.getText(driver, "Xpath", "faceBookLoginTextXpath").trim();
		if (actualFaceBookText.equalsIgnoreCase(expextedFacebookText)) {
			addComment("Expected text is: " + expextedFacebookText + " same as Actual text: " + actualFaceBookText);
			addComment("Page navigated to Facebook Login Page.");
		}
		// To enter email address
		try {
			String userName = ExcelReader.getValue("UserName");
			eo.enterText(driver, "CssSelector", "facebookEmailCss", userName);
			addComment("Successfully entered the facebook email");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the facebook email", e);
		}
		// To enter password
		try {
			String password = ExcelReader.getValue("Password");
			eo.enterText(driver, "CssSelector", "facebookPasswordCss", password);
			addComment("Successfully entered the  facebook password");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the facebook password", e);
		}
		// To click on submit button
		try {
			eo.clickElement(driver, "CssSelector", "facebookLoginCss");
			addComment("Successfully clicked on the submit button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the submit button", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> signInWithGoogle
	 * 
	 * <p>
	 * <b>Description:</b> Navigate to facebook account by clicking on
	 * signInWithGoogle button
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// Sign in with Google.
	public void signInWithGoogle(WebDriver driver) throws Exception {

		// To click on sign in with Google link.
		try {
			Thread.sleep(500);
			eo.clickElement(driver, "Xpath", "signInWithGoogleInLoginPageXpath");
			addComment("Clicked on sign In with google link.");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to click on sign up with google", e);
		}
		Thread.sleep(2000);
		boolean googleLogo = eo.verifyElementIsDisplayed(driver, "CssSelector", "googleLogoCss");
		try {
			if (googleLogo) {
				addComment("Google logo is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Google logo");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Google logo", e);
		}
		// To enter email address
		try {
			String userName = ExcelReader.getValue("UserName");
			eo.enterText(driver, "CssSelector", "googleEmailCss", userName);
			addComment("Successfully entered the facebook email");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the facebook email", e);
		}
		// To click on Next button
		try {
			eo.clickElement(driver, "CssSelector", "googleNextCss");
			addComment("Successfully clicked on the Next button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the next button", e);
		}
		// To enter password
		try {
			eo.wait(2000);
			String password = ExcelReader.getValue("Password");
			eo.enterText(driver, "CssSelector", "googlePasswordCss", password);
			addComment("Successfully entered the google password");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the google password", e);
		}
		// To click on submit button
		try {
			eo.clickElement(driver, "CssSelector", "googleSignIn");
			addComment("Successfully clicked on the submit button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the submit button", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> newToTrendInButton
	 * 
	 * <p>
	 * <b>Description:</b> //To click on new To Trend In Button
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// New to trend in click [TC-11]
	public void newToTrendInButton(WebDriver driver) throws Exception {
		// To click on new to trend in link.
		try {
			eo.clickElement(driver, "cssSelector", "newToTrendInCss");
			addComment("Clicked on new to trend in link.");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click new to trend in link", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyMyOrder
	 * 
	 * <p>
	 * <b>Description:</b> //To click on verify my order
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To click on 'My Order'
	public void verifyMyOrder(WebDriver driver) throws Exception {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutClickCss", curApp)));
		action.moveToElement(ele).build().perform();
		// To click on returns
		eo.clickElement(driver, "XPath", "myOrdersXpath");
		addComment("Clicked on My Order.");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyReturn
	 * 
	 * <p>
	 * <b>Description:</b> //To click on Return button
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To verify 'Returns'
	public void verifyReturn(WebDriver driver) throws Exception {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutClickCss", curApp)));
		action.moveToElement(ele).build().perform();
		// To click on returns
		eo.clickElement(driver, "XPath", "returnsXpath");
		addComment("Clicked on Retuns.");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> userNameClick
	 * 
	 * <p>
	 * <b>Description:</b> //To click on user name tiny header
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To click on 'User name' in tiny header
	public void userNameClick(WebDriver driver) throws Exception {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("usernameClickXpath", curApp)));
		act.moveToElement(ele).build().perform();
		act.click(ele).build().perform();
		addComment("Successfully clicked on user name");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyOrderReturn
	 * 
	 * <p>
	 * <b>Description:</b> //To verify My order or return label
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To verify 'My oders' or 'Returns'
	public void verifyOrderReturn(WebDriver driver) throws Exception {

		// To verify Order History is displayed.
		try {

			boolean orderHistoryStatus = eo.verifyElementIsDisplayed(driver, "XPath", "orderHistoryTextXpath");
			if (orderHistoryStatus) {
				addComment("Order History is displayed.");
			} else {
				addComment("Order History is not displayed.");
				throw new POMMethodExecException("Not able to verify the order history");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the order history ", e);
		}

		// To verify Recent order Tab is displayed.
		try {
			boolean recentOrderTabStatus = eo.verifyElementIsDisplayed(driver, "XPath", "recentOrderTabXpath");
			if (recentOrderTabStatus) {
				addComment("Recent order tab is displayed.");
			} else {
				throw new POMMethodExecException("Not able to verify the Recent order tab ");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Recent order tab ", e);
		}

		// To verify past order Tab is displayed.
		try {

			boolean pastOrderTabStatus = eo.verifyElementIsDisplayed(driver, "XPath", "pastOrderTabXpath");
			if (pastOrderTabStatus) {
				addComment("Past order tab is displayed.");
			} else {
				throw new POMMethodExecException("Not able to verify the Past order tab ");

			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Past order tab ", e);
		}

		// To verify All the links are displayed left side of the UI Return
		// page.
		try {
			int noOfLinksCount = 0;
			List<WebElement> allRetunsUiLinks = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allReturnsLinksXpath", curApp)));
			addComment("No of Links are: " + allRetunsUiLinks.size());
			String tempReturnsLinksXpath = GetElementIdentifier.getProperty("returnsLinksXpath", curApp);
			for (int i = 0; i < allRetunsUiLinks.size(); i++) {
				String tempReturnsLinksXpathReplace = tempReturnsLinksXpath.replace("{replaceI}", String.valueOf(i + 1));
				String linksText = driver.findElement(By.xpath(tempReturnsLinksXpathReplace)).getText().trim();
				if (driver.findElement(By.xpath(tempReturnsLinksXpathReplace)).isDisplayed()) {
					addComment("Retun Link is dispalyed : " + linksText);
					noOfLinksCount++;
				}
			}
			if (noOfLinksCount == allRetunsUiLinks.size()) {
				addComment("All the links are displayed.");

			} else {
				throw new POMMethodExecException("Not able to verify the All the links ");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the All the links ");
		}
	}

	// validation for mobile number
	/**
	 * <p>
	 * <b>Method Name:</b> ValidateMobileNumberField
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the mobile number textfield by giving
	 * different inputs(TC__008)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validateMobileNumberField(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		String mobileNumberInputValue = " ";
		String yourName = ExcelReader.getValue("YourName");
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		// To enter the username
		try {
			eo.enterText(driver, "Id", "yourNameXpath", yourName);
			addComment("Successfully entered name field :" + yourName);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the name", e);
		}
		// To enter the email id
		try {
			eo.enterText(driver, "Id", "emailXpath", emailId);
			addComment("Successfully entered email field :" + emailId);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}
		// To enter the password
		try {
			eo.enterText(driver, "Id", "passwordFieldXpath", password);
			addComment("Successfully entered password field :" + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To enter the mobile number
		try {
			mobileNumberInputValue = ExcelReader.getValue("MobileNumber");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumberInputValue);
			addComment("Successfully entered mobile number field :" + mobileNumberInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the mobile number", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to click on the for him link", e);
		}
		// To verify the error message
		try {
			Thread.sleep(2000);
			eo.verifyElementIsDisplayed(driver, "XPath", "mobileNumberValidationXpath");
			String text = eo.getText(driver, "XPath", "mobileNumberValidationXpath");
			if (text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")) {
				addComment("Successfully error message is displayed when only alphabets mobile number is entered :" + text);
			} else {
				throw new POMMethodExecException("Not able to verify the error message for alphabets mobile number ");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for alphabets mobile number ", e);
		}
		// To clear the mobile number text field
		eo.cleardata(driver, "id", "mobileNumberXpath");
		try {
			mobileNumberInputValue = ExcelReader.getValue("MobileNumber1");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumberInputValue);
			addComment("Successfully entered mobile number field :" + mobileNumberInputValue);
		} catch (Exception e) {
			throw new Exception();
		}
		// To click on the for him button
		try {
			Thread.sleep(500);
			eo.clickElement(driver, "id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		Thread.sleep(1000);
		// To verify the error message
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "mobileNumberValidationXpath");
			String text = eo.getText(driver, "XPath", "mobileNumberValidationXpath");
			if (text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")) {
				addComment("Successfully error message is displayed when only only special characters mobile number is entered :" + text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		// To clear the mobile number text field
		eo.cleardata(driver, "id", "mobileNumberXpath");
		// To enter the mobile number
		try {
			mobileNumberInputValue = ExcelReader.getValue("MobileNumber2");
			eo.enterText(driver, "id", "mobileNumberXpath", mobileNumberInputValue);
			addComment("Successfully entered mobile number field :" + mobileNumberInputValue);
		} catch (Exception e) {
			throw new Exception();
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		Thread.sleep(1000);
		// To verify the error message
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "mobileNumberValidationXpath");
			String text = eo.getText(driver, "XPath", "mobileNumberValidationXpath");
			if (text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")) {
				addComment("Successfully error message is displayed when  combination of special characters and alphabets mobile number is entered :" + text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		// To clear the mobile number text field
		eo.cleardata(driver, "id", "mobileNumberXpath");
		// To enter the mobile number
		try {
			mobileNumberInputValue = ExcelReader.getValue("MobileNumber3");
			eo.enterText(driver, "id", "mobileNumberXpath", mobileNumberInputValue);
			addComment("Successfully entered mobile number field :" + mobileNumberInputValue);
		} catch (Exception e) {
			throw new Exception();
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		Thread.sleep(1000);
		// To verify the error message
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "mobileNumberValidationXpath");
			String text = eo.getText(driver, "XPath", "mobileNumberValidationXpath");

			if (text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")) {
				addComment("Successfully error message is displayed when Alphanumeric characters mobile number is entered : " + text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		// To clear the mobile number text field
		eo.cleardata(driver, "id", "mobileNumberXpath");
		// To enter the mobile number
		try {
			mobileNumberInputValue = ExcelReader.getValue("MobileNumber4");
			eo.enterText(driver, "id", "mobileNumberXpath", mobileNumberInputValue);
			addComment("Successfully entered mobile number field :" + mobileNumberInputValue);
		} catch (Exception e) {
			throw new Exception();
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		Thread.sleep(1000);
		// To verify the error message
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "mobileNumberValidationXpath");
			String text = eo.getText(driver, "XPath", "mobileNumberValidationXpath");
			if (text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")) {
				addComment("Successfully error message is displayed when combination of special characters and alphanumeric characters mobile number is entered :" + text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		// To clear the mobile number text field
		eo.cleardata(driver, "id", "mobileNumberXpath");
		// To enter the mobile number
		try {
			mobileNumberInputValue = ExcelReader.getValue("MobileNumber5");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumberInputValue);
			addComment("Successfully entered mobile number field :" + mobileNumberInputValue);
		} catch (Exception e) {
			throw new Exception();
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		Thread.sleep(4000);
		// To verify the error message
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "mobileNumberValidationXpath");
			String text = eo.getText(driver, "XPath", "mobileNumberValidationXpath");
			if (text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")) {
				addComment("Successfully error message is displayed when MOBILE NUMBER Field is Blank :" + text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> validateTermsAndConditionsLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the terms and conditions link (TC__009)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validateTermsAndConditionsLink(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String oldTab = driver.getWindowHandle();
		// To click on the terms of use link xpath
		try {
			eo.clickElement(driver, "Xpath", "termsOfUseLinkXpath");
			addComment("Successfully clicked on terms Of Use link");
		} catch (Exception e) {
			throw new Exception();
		}
		Thread.sleep(2000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		// To verify the terms of use is opened in new tab
		try {
			boolean termsAndCondition = eo.verifyElementIsDisplayed(driver, "Xpath", "termsAndConditionHeaderXpath");
			if (termsAndCondition) {
				addComment("Successfully terms of use is opened in new tab");
			} else {
				throw new POMMethodExecException("Not able to poen the terms of use in the new tab");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to poen the terms of use in the new tab", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> validatePrivacyPolicyLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the Privacy Policy link (TC__010)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validatePrivacyPolicyLink(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		String oldTab = driver.getWindowHandle();
		try {
			eo.clickElement(driver, "Xpath", "privacyPolicyXpath");
			addComment("Successfully clicked on privacy Policy link");
		} catch (Exception e) {
			throw new Exception();
		}
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		Thread.sleep(2000);
		try {
			boolean privacyPolicy = eo.verifyElementIsDisplayed(driver, "Xpath", "privacyPolicyHeaderXpath");
			if (privacyPolicy) {
				addComment("Successfully privacy Policy is opened in new tab");
			} else {
				throw new POMMethodExecException("Not able to open the privacy policy in the new tab");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to open the privacy policy in the new tab", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> validateEmptyFieldsInLoginPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the blank fields in login page (TC__011)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validateEmptyFieldsInLoginPage(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		// To click on the for him button
		try {
			eo.clickElement(driver, "Id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the for him button", e);
		}
		// To verify your name field field
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "firstNameErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "firstNameErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter first name.")) {
				addComment("Successfully error message is displayed when first name field is Blank :" + text);
			} else {
				throw new POMMethodExecException("Error message is not displayed when first name is blank");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Error message is not displayed when first name is blank", e);
		}
		// To verify email id field field
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailErrorXpath");
			String text = eo.getText(driver, "Xpath", "emailErrorXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully error message is displayed when email id field is Blank :" + text);
			} else {
				throw new POMMethodExecException("Eror message is not displayed when email id is blank");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Eror message is not displayed when email id is blank", e);
		}
		// To verify password field field
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordErrorXpath");
			String text = eo.getText(driver, "Xpath", "passwordErrorXpath");
			if (text.equalsIgnoreCase("Please enter password.")) {
				addComment("Successfully error message is displayed when password field is Blank :" + text);
			} else {
				throw new POMMethodExecException("Error message is not displayed when password is blank ");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Error message is not displayed when password is blank ", e);
		}
		// To verify mobile number field field
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "mobileNumberValidationXpath");
			String text = eo.getText(driver, "Xpath", "mobileNumberValidationXpath");
			if (text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")) {
				addComment("Successfully error message is displayed when Mobile number field is Blank :" + text);
			} else {
				throw new POMMethodExecException("Error message is not displayed when mobile number is blank");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Error message is not displayed when mobile number is blank", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> ValidateIAgreeCheckBox
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the I agree check box in login page
	 * (TC__012)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validateIAgreeCheckBox(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		String inputValue = null;
		String yourName = ExcelReader.getValue("YourName");
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		// To enter the username
		try {
			eo.enterText(driver, "Id", "yourNameXpath", yourName);
			addComment("Successfully entered name field :" + yourName);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the name", e);
		}
		// To enter the email id
		try {
			eo.enterText(driver, "Id", "emailXpath", emailId);
			addComment("Successfully entered email field :" + emailId);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email id", e);
		}
		// To enter the password
		try {
			eo.enterText(driver, "Id", "passwordFieldXpath", password);
			addComment("Successfully entered password field :" + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To enter the mobile number
		try {
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered mobile number field :" + mobileNumber);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the mobile number", e);
		}
		// To click on the i agree checkbox
		try {
			eo.clickElement(driver, "Id", "iAgreeCheckBoxId");
			addComment("Successfully unchecked the achek box 'I agree to the Trendin.com '");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to uncheck the acheckbox 'I agree to the Trendin.com'", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Id", "btnLoginForHimXpath");
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		// To verify the error message
		eo.wait(2000);
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "iAgreeCheckBoxErrorMessageXpath");
			String text = eo.getText(driver, "XPath", "iAgreeCheckBoxErrorMessageXpath");
			if (text.equalsIgnoreCase("Please agree to our Terms and Conditions.")) {
				addComment("Successfully error message is displayed when I agree to the Trendin.com is unchecked :" + text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> ValidateExistingUserLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the Already registered link (TC__013)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validateExistingUserLink(WebDriver driver) throws Exception {

		// To verfiy the existing user header label
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "existingUserHeaderXpath");
			String text = eo.getText(driver, "XPath", "existingUserHeaderXpath");
			if (text.equalsIgnoreCase("Existing users, Sign in")) {
				addComment("Existing user page successfully displayed :" + text);
			} else {
				throw new POMMethodExecException("existing user header is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("existing user header is not displayed", e);
		}
		// To verify the email id textbox
		try {

			boolean ele = eo.verifyElementIsDisplayed(driver, "Id", "emailIdExistingUserXpath");
			if (ele) {
				addComment("Email id text box is displayed");
			} else {
				throw new POMMethodExecException("Email id field is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Email id field is not displayed", e);
		}
		// To verify the password textbox
		try {

			boolean ele = eo.verifyElementIsDisplayed(driver, "Id", "passwordExistingUserXpath");
			if (ele) {
				addComment("Password text box is displayed");
			} else {
				throw new POMMethodExecException("Password field is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Password field is not displayed", e);
		}
		// To verify the login button dispalyed
		try {

			boolean ele = eo.verifyElementIsDisplayed(driver, "Id", "loginButtonInExistingUserXpath");
			if (ele) {
				addComment("login button is displayed");
			} else {
				throw new POMMethodExecException("login button is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("login button is not displayed", e);
		}
		// To verify the forgot password link
		try {

			boolean ele = eo.verifyElementIsDisplayed(driver, "Id", "forgotPasswordLinkInExistingUserXPath");
			if (ele) {
				addComment("Forgot password link is displayed");
			} else {
				throw new POMMethodExecException("Forgot password link is not displayed");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Forgot password link is not displayed", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> validateSignUpWithGoogleButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the sign up with google in existing user
	 * page(TC__014)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validateSignInWithGoogleButton(WebDriver driver) throws Exception {

		String currentWindow = driver.getWindowHandle();
		// To click on sign in with google button
		try {
			eo.clickElement(driver, "XPath", "signInWithgoogleXpath");
			addComment("Sign in With google button is clicked");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the google sign in button");
		}
		Set<String> availableWindows = driver.getWindowHandles();
		for (String windowId : availableWindows) {
			String switchedWindowTitle = driver.switchTo().window(windowId).getTitle();
			if ((switchedWindowTitle.equals("Sign in - Google Accounts")) || (switchedWindowTitle.contains("Sign in - Google Accounts"))) {
				addComment("Successfully navigated to google account");
			} else {
				throw new POMMethodExecException("Could not navigated to google account");
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> existingUserEmailAndPasswordTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> //To verify the Negative scenario of existing user
	 * emailId and password textfield
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 * 
	 */

	public void existingUserEmailAndPasswordTextfield(WebDriver driver) throws Exception {
		String inputValue = "";

		// To enter data in the existing email textfield
		try {
			String emailId = ExcelReader.getValue("EmailId");
			eo.enterText(driver, "Xpath", "existingEmailXpath", emailId);
			addComment("Successfully entered the email " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			String password = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the login button in the already registered page ", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "passwordErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter password.")) {
				addComment("Successfully verified the error message for EMPTY FIELD in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Unable to verify the error message for EMPTY FIELD in the password textfield ");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify the error message", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			String password = ExcelReader.getValue("Password2");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "passwordErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter password.")) {
				addComment("Successfully verified the error message for BLANK SPACES in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Unable to verify the error message");
			}

		} catch (Exception e) {
			throw new Exception("Unable to verify the error message", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			String password = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Coudn't click on the login button");
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordAlertMessageXpath");
			String text = eo.getText(driver, "Xpath", "passwordAlertMessageXpath");
			if (text.equalsIgnoreCase("Given password does not match.")) {
				addComment("Successfully verified the error message for SPL CHARACTERS in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Unable to verify the error message");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify the error message", e);
		}
		// To clear the password textfield
		eo.clickElement(driver, "Xpath", "passwordAlertCloseButtonXpath");
		Thread.sleep(500);
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			String password = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Ccouln't click on the password button", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordAlertMessageXpath");
			String text = eo.getText(driver, "Xpath", "passwordAlertMessageXpath");
			if (text.equalsIgnoreCase("Given password does not match.")) {
				addComment("Successfully verified the error message for NUMERICS in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Unable to verify the error message");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify the error message", e);
		}
		// To clear the password textfield
		eo.clickElement(driver, "Xpath", "passwordAlertCloseButtonXpath");
		Thread.sleep(500);
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			String password = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button");
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordAlertMessageXpath");
			String text = eo.getText(driver, "Xpath", "passwordAlertMessageXpath");
			if (text.equalsIgnoreCase("Given password does not match.")) {
				addComment("Successfully verified the error message for ALPHA NUMERICS in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Unable to verify the error message");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify the error message", e);
		}
		// To clear the password textfield
		eo.clickElement(driver, "Xpath", "passwordAlertCloseButtonXpath");
		Thread.sleep(500);
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			String password = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "passwordErrorMessageXpath");
			if (text.equalsIgnoreCase("Password should be of minimum 6 characters.")) {
				addComment("Successfully verified the error message for ALL COMBINATIONS in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Unable to verify the error message");
			}

		} catch (Exception e) {
			throw new Exception("Unable to verify the error message", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the login buton", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "passwordAlertMessageXpath");
			String text = eo.getText(driver, "Xpath", "passwordAlertMessageXpath");
			if (text.equalsIgnoreCase("Given password does not match.")) {
				addComment("Successfully verified the error message for LESS THAN 6 VALUES in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Unable to verify te error message");
			}

		} catch (Exception e) {
			throw new Exception("Unable to verify te error message", e);
		}
		eo.clickElement(driver, "Xpath", "passwordAlertCloseButtonXpath");
		Thread.sleep(500);
		// To clear both password and email textfield
		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// ##########################TD-2
		// To enter data in the existing email textfield
		try {
			inputValue = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingEmailXpath", inputValue);
			addComment("Successfully entered the email");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the email", e);
		}

		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't click on the login button in the already registered page ", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for EMPTY FIELD in the email textfield :: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}
		try {
			inputValue = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the error message for EMPTY FIELD in the password textfield ::" + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password2");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for EMPTY FIELD in the email textfield :: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for EMPTY FIELD in the email textfield :: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for EMPTY FIELD in the email textfield :: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for EMPTY FIELD in the email textfield :: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for EMPTY FIELD in the email textfield :: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for EMPTY FIELD in the email textfield :: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}

		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// #####################TD-3
		// To enter data in the existing email textfield
		try {
			inputValue = ExcelReader.getValue("Password2");
			eo.enterText(driver, "Xpath", "existingEmailXpath", inputValue);
			addComment("Successfully entered the email " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			inputValue = ExcelReader.getValue("Password7");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for EMPTY FIELD in the empty textfield", e);
		}
		try {
			inputValue = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password2");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACESin the empty textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {

			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message forBLANK SPACES in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield", e);
		}
		// To clear the password textfieldeo.cleardata(driver, "Xpath",
		// "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password8");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the  error message for BLANK SPACES in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for BLANK SPACES in the empty textfield", e);
		}
		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// ################TD-4
		// To enter data in the existing email textfield
		try {
			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingEmailXpath", inputValue);
			addComment("Successfully entered the email " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			inputValue = ExcelReader.getValue("Password7");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}
		try {
			inputValue = ExcelReader.getValue("Password1");
			inputValue = "";
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = "         ";
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully verified the error message for email textfield");
		} catch (Exception e) {
			throw new Exception();
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password8");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for SPL CHARACTERS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for SPL CHARACTERS in the email textfield", e);
		}

		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// ###############TD-5
		// To enter data in the existing email textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingEmailXpath", inputValue);
			addComment("Successfully entered the email " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			inputValue = ExcelReader.getValue("Password7");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}
		try {
			inputValue = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = "         ";
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password8");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for NUMERICS in the email textfield", e);
		}
		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// ###########TD-6
		// To enter data in the existing email textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingEmailXpath", inputValue);
			addComment("Successfully entered the email " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			inputValue = ExcelReader.getValue("Password7");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}
		try {
			inputValue = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = "         ";
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password8");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALPHA NUMERICS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALPHA NUMERICS in the email textfield", e);
		}
		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");
		// ################TD-7
		// To enter data in the existing email textfield
		try {
			inputValue = "ABC!@#  123 ";
			eo.enterText(driver, "Xpath", "existingEmailXpath", inputValue);
			addComment("Successfully entered the email " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			inputValue = ExcelReader.getValue("Password7");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		try {
			inputValue = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = "         ";
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {

			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {

				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password8");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}

		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// ###########TD-6
		// To enter data in the existing email textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingEmailXpath", inputValue);
			addComment("Successfully entered the email");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			inputValue = ExcelReader.getValue("Password7");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		try {
			inputValue = ExcelReader.getValue("Password1");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}

		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}

		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = "         ";
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password3");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click oh the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password4");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't enter the password");
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn,t click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password5");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn,t click on the login button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password6");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("unable to click on the login button");
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		// To clear the password textfield

		eo.cleardata(driver, "Xpath", "existingPasswordXpath");

		// To enter data in the existing password textfield
		try {
			inputValue = ExcelReader.getValue("Password8");
			eo.enterText(driver, "Xpath", "existingPasswordXpath", inputValue);
			addComment("Successfully entered the password " + inputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "existingLoginButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("unable to click on the login button");
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "emailAddressErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "emailAddressErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the  error message for ALL COMBINATIONS in the email textfield:: " + text);
			} else {
				throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't verify the error message for ALL COMBINATIONS in the email textfield", e);
		}
		eo.cleardata(driver, "Xpath", "existingEmailXpath");
		eo.cleardata(driver, "Xpath", "existingPasswordXpath");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> validateSignInWithFacebookButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the sign in with facebook in existing user
	 * page(TC__015)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void validateSignInWithFacebookButton(WebDriver driver) throws Exception {

		String currentWindow = driver.getWindowHandle();
		// To click on sign in with facebook button
		try {
			eo.clickElement(driver, "XPath", "signInWithFacebookXpath");
			addComment("SignIn With facebook button is clicked");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the facebook button", e);
		}
		Set<String> availableWindows = driver.getWindowHandles();
		for (String windowId : availableWindows) {
			String switchedWindowTitle = driver.switchTo().window(windowId).getTitle();
			if ((switchedWindowTitle.equals("Log in to Facebook | Facebook")) || (switchedWindowTitle.contains("Log in to Facebook | Facebook"))) {
				addComment("Successfully navigated to facebook account");
			} else {
				throw new POMMethodExecException("Could not navigated to facebook account");
			}

		}

	}

	// ///////////////////////////////////////////////////////////////////////[8-26-2015]

	/**
	 * <p>
	 * <b>Method Name:</b> enterKeywordsInSignUpTextFields
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the sign up page textfields page(TC__015)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 * 
	 */

	// To enter keywords in the the sign up textfields
	public void enterKeywordsInSignUpTextFields(WebDriver driver) throws Exception {
		// To enter the username
		try {
			String username = ExcelReader.getValue("Username");
			eo.enterText(driver, "Xpath", "nameXpath", username);
			addComment("Successfully entered the name " + username);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the name", e);
		}
		// To enter the email id
		try {
			String emailId = ExcelReader.getValue("EmailId");
			eo.enterText(driver, "Id", "emailXpath", emailId);
			addComment("Successfully entered the email " + emailId);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the email", e);
		}
		// To enter the password
		try {
			String password = ExcelReader.getValue("Password");
			eo.enterText(driver, "Id", "passwordFieldXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter the mobile number
		try {
			String mobileNumber = ExcelReader.getValue("MobileNumber");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered the name " + mobileNumber);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the name", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> enterKeywordsInSignUpTextFields
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on for him button(TC__015)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	// To click on the him labeled button
	public void himLabelButton(WebDriver driver) throws Exception {
		// To click on the him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the Him labeled button ");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> enterKeywordsInSignUpTextFields
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on for her button page(TC__015)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	// To click on the her labeled button
	public void herLabelButton(WebDriver driver) throws Exception {
		try {
			eo.clickElement(driver, "Xpath", "herLabelButtonXpath");
			addComment("Successfully clicked on the Her labeled button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the her labeled button", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifySignUpYourNameTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> //To verify the yourname textfield by giving
	 * different inputs(TC__003)[8-25-2015]
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 * 
	 */

	public void verifySignUpYourNameTextfield(WebDriver driver) throws Exception {

		// To enter data in your name textfield
		try {
			String yourNameinputValue = ExcelReader.getValue("YourNameinputValue");
			eo.enterText(driver, "Id", "yourNameXpath", yourNameinputValue);
			addComment("Successfully entered the name " + yourNameinputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the username", e);

		}
		// To enter data in email textfield
		try {
			String mailId = ExcelReader.getValue("MailId");
			eo.enterText(driver, "Id", "emailXpath", mailId);
			addComment("Successfully entered the email " + mailId);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in password textfield
		try {
			String password = ExcelReader.getValue("Password");
			eo.enterText(driver, "Id", "passwordFieldXpath", password);
			addComment("Successfully entered the email " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in mobile number textfield
		try {
			String mobileNumber = ExcelReader.getValue("MobileNumber");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered the mobile number " + mobileNumber);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the mobile number", e);
		}

		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validErrorMessageXpath");
			eo.getText(driver, "Xpath", "validErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid first name. Allowed characters (a-z).")) {
				addComment("Successfully verified the error message for invalid name in the your name textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for invalid name in the your name textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for invalid name in the your name textfield", e);
		}
		// To clear the data in the name textfield
		eo.cleardata(driver, "Id", "yourNameXpath");
		try {
			String yourNameinputValue = ExcelReader.getValue("YourNameinputValue1");
			eo.enterText(driver, "Id", "yourNameXpath", yourNameinputValue);
			addComment("Successfully entered the name " + yourNameinputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the first name", e);
		}
		// To click on for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validErrorMessageXpath");
			eo.getText(driver, "Xpath", "validErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid first name. Allowed characters (a-z).")) {
				addComment("Successfully verified the error message for 'combination of special characters and numbers' in the your name textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'combination of special characters and numbers' in the your name textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for 'combination of special characters and numbers' in the your name textfield", e);
		}
		// To clear the data in the name textfield
		eo.cleardata(driver, "Id", "yourNameXpath");
		// To enter the data in the your name textfield
		try {
			String yourNameinputValue = ExcelReader.getValue("YourNameinputValue2");
			eo.enterText(driver, "Id", "yourNameXpath", yourNameinputValue);
			addComment("Successfully entered the name " + yourNameinputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the first name", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validErrorMessageXpath");
			eo.getText(driver, "Xpath", "validErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid first name. Allowed characters (a-z).")) {
				addComment("Successfully verified the error message for 'Alphanumeric characters' in the your name textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'Alphanumeric characters' in the your name textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for 'Alphanumeric characters' in the your name textfield", e);
		}
		// To clear the data in the name textfield
		eo.cleardata(driver, "Id", "yourNameXpath");
		// To enter the data in the your name textfield
		try {
			String yourNameinputValue = ExcelReader.getValue("YourNameinputValue3");
			eo.enterText(driver, "Id", "yourNameXpath", yourNameinputValue);
			addComment("Successfully entered the name " + yourNameinputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the first name", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter first name.")) {
				addComment("Successfully verified the error message for empty in the your name textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'Spaces' in the your name textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for 'Spaces' in the your name textfield", e);
		}
		// To clear the data in the name textfield
		eo.cleardata(driver, "Id", "yourNameXpath");
		// To enter the data in the name textfield
		try {
			String yourNameinputValue = ExcelReader.getValue("YourNameinputValue4");
			eo.enterText(driver, "Id", "yourNameXpath", yourNameinputValue);
			addComment("Successfully entered the name " + yourNameinputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the first name", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validErrorMessageXpath");
			eo.getText(driver, "Xpath", "validErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid first name. Allowed characters (a-z).")) {
				addComment("Successfully verified the error message for invalid name in the your name textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for invalid name in the your name textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for invalid name in the your name textfield", e);
		}
		// To clear the data in the your name textfield
		eo.cleardata(driver, "Id", "yourNameXpath");
		// To enter the data in the your name textfield
		try {
			String yourNameinputValue = ExcelReader.getValue("YourNameinputValue5");
			eo.enterText(driver, "Id", "yourNameXpath", yourNameinputValue);
			addComment("Successfully entered the name " + yourNameinputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the first name", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validErrorMessageXpath");
			eo.getText(driver, "Xpath", "validErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid first name. Allowed characters (a-z).")) {
				addComment("Successfully verified the error message for 'only special characters' in the your name textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'only special characters' in the your name textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for 'only special characters' in the your name textfield", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifySignUpEmailAddressTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> //To verfiy the email textfield by giving different
	 * inputs(TC_005)
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 * 
	 */

	public void verifySignUpEmailAddressTextfield(WebDriver driver) throws Exception {
		String emailIdInputValue = "";
		Thread.sleep(1000);
		// To enter data in your name textfield
		try {
			String userName = ExcelReader.getValue("UserName");
			eo.enterText(driver, "Id", "yourNameXpath", userName);
			addComment("Successfully entered the name " + userName);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the username", e);

		}
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in password textfield
		try {
			String password = ExcelReader.getValue("Password");
			eo.enterText(driver, "Id", "passwordFieldXpath", password);
			addComment("Successfully entered the Password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in mobile number textfield
		try {
			String mobileNumber = ExcelReader.getValue("MobileNumber");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered the mobile number " + mobileNumber);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the mobile number", e);
		}

		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			Thread.sleep(2000);
			String text = "";
			boolean errorMessage1 = eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageXpath");
			boolean errorMessage2 = eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageAlertXpath");
			if (errorMessage1) {
				text = eo.getText(driver, "Xpath", "validEmailErrorMessageXpath");
			} else {
				text = eo.getText(driver, "Xpath", "validEmailErrorMessageAlertXpath");
				eo.clickElement(driver, "Xpath", "closeAlertXpath");
			}
			if (text.equalsIgnoreCase("Email already registered. Please click Forgot Your Password link to reset password.") || text.equalsIgnoreCase("An account already exists with this e-mail. Please login.")) {
				addComment("Successfully verified the error message for 'already registered mail-id' in the Email address textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'already registered mail-id' in the Email address textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for 'already registered mail-id' in the Email address textfield", e);
		}
		// To clear the email textfield
		eo.cleardata(driver, "Id", "emailXpath");
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue1");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "XPath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			String text = "";
			boolean errorMessage1 = eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageXpath");
			boolean errorMessage2 = eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageAlertXpath");
			if (errorMessage1) {
				text = eo.getText(driver, "Xpath", "validEmailErrorMessageXpath");
			} else {
				text = eo.getText(driver, "Xpath", "validEmailErrorMessageAlertXpath");
				eo.clickElement(driver, "Xpath", "closeAlertXpath");
			}
			if (text.equalsIgnoreCase("Email already registered. Please click Forgot Your Password link to reset password.") || text.equalsIgnoreCase("An account already exists with this e-mail. Please login.")) {
				addComment("Successfully verified the error message for 'already registered mail-id' in the Email address textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'already registered mail-id' in the Email address textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for'already registered mail-id' in the Email address textfield", e);
		}
		// To clear the data in the email textfield
		eo.cleardata(driver, "Id", "emailXpath");
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue2");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the for him button
		try {
			String text = "";
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
			// To verify error message
			// boolean errorMessage1 = eo.verifyElementIsDisplayed(driver,
			// "Xpath", "validEmailErrorMessageXpath");
			// boolean errorMessage2 = eo.verifyElementIsDisplayed(driver,
			// "Xpath", "validEmailErrorMessageAlertXpath");
			// if (errorMessage1) {
			// text = eo.getText(driver, "Xpath",
			// "validEmailErrorMessageXpath");
			// } else {
			// text = eo.getText(driver, "Xpath",
			// "validEmailErrorMessageAlertXpath");
			// eo.clickElement(driver, "Xpath", "closeAlertXpath");
			// }
			//
			// if (text.equalsIgnoreCase("Email already registered. Please click
			// Forgot Your Password link to reset password.") ||
			// text.equalsIgnoreCase("An account already exists with this
			// e-mail. Please login.")) {
			// addComment("Successfully verified the error message for 'already
			// registered mail-id' in the Email address textfield");
			// } else {
			// throw new POMMethodExecException("Not able to verify the error
			// message for 'already registered mail-id' in the Email address
			// textfield");
			// }

		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> signUpEmailIdsTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> //Top verify the email id text field by giving
	 * already registered mai id's
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 * 
	 */

	public void signUpEmailIdsTextfield(WebDriver driver) throws Exception {
		String emailIdInputValue = "";
		// To enter data in your name textfield
		try {
			String userName = ExcelReader.getValue("UserName");
			eo.enterText(driver, "Id", "yourNameXpath", userName);
			addComment("Successfully entered the name " + userName);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the username", e);

		}
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue3");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in password textfield
		try {
			String password = ExcelReader.getValue("Password");
			eo.enterText(driver, "Id", "passwordFieldXpath", password);
			addComment("Successfully entered the email " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in mobile number textfield
		try {
			String mobileNumber = ExcelReader.getValue("MobileNumber");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered the mobile number " + mobileNumber);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the mobile number", e);
		}

		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			Thread.sleep(2000);
			eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validEmailErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the error message for invalid email-id in the Email address textfield");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for invalid email-id in the Email address textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for invalid email-id in the Email address textfield", e);
		}
		// To clear the data in the name textfield
		eo.cleardata(driver, "Id", "emailXpath");
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue4");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the email", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			Thread.sleep(2000);
			eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validEmailErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the error message for special character email-id in the email id field");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for special character email-id in the Email address textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for special character email-id in the Email address textfield", e);
		}
		// To clear the data in the name textfield
		eo.cleardata(driver, "Id", "emailXpath");
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue5");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the email", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validEmailErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter valid E-mail.")) {
				addComment("Successfully verified the error message for '7Spaces' in the email id field");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for'7Spaces' in the Email address textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for '7Spaces' in the Email address textfield", e);
		}
		// To clear the data in the name textfield

		eo.cleardata(driver, "Id", "emailXpath");
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue6");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the email", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			Thread.sleep(1000);
			eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageXpath");
			String text = eo.getText(driver, "Xpath", "validEmailErrorMessageXpath");
			if (text.equalsIgnoreCase("Please enter email.")) {
				addComment("Successfully verified the error message for 'spaces' in the email id field");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'spaces' in the Email address textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for 'spaces' in the Email address textfield", e);
		}
		// To clear the data in the name textfield

		eo.cleardata(driver, "Id", "emailXpath");
		// To enter data in email textfield
		try {
			emailIdInputValue = ExcelReader.getValue("EmailIdInputValue7");
			eo.enterText(driver, "Id", "emailXpath", emailIdInputValue);
			addComment("Successfully entered the email " + emailIdInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the email", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			Thread.sleep(2000);
			String text = "";
			boolean errorMessage1 = eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageXpath");
			boolean errorMessage2 = eo.verifyElementIsDisplayed(driver, "Xpath", "validEmailErrorMessageAlertXpath");
			if (errorMessage1) {
				text = eo.getText(driver, "Xpath", "validEmailErrorMessageXpath");
			} else {
				text = eo.getText(driver, "Xpath", "validEmailErrorMessageAlertXpath");
			}
			if (text.equalsIgnoreCase("Email already registered. Please click Forgot Your Password link to reset password.") || text.equalsIgnoreCase("An account already exists with this e-mail. Please login.")) {
				addComment("Successfully verified the error message for 'already registered mail-id' in the email id field");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for 'already registered mail-id' in the Email address textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for 'already registered mail-id' in the Email address textfield", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifySignUpPasswordTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> //To verify the password text field
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 * 
	 */

	public void verifySignUpPasswordTextfield(WebDriver driver) throws Exception {
		String passwordInputValue = "";
		// To enter data in your name textfield
		try {
			String userName = ExcelReader.getValue("UserName");
			eo.enterText(driver, "Id", "yourNameXpath", userName);
			addComment("Successfully entered the name " + userName);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the username", e);

		}
		// To enter data in email textfield
		try {
			String emailId = ExcelReader.getValue("EmailId");
			eo.enterText(driver, "Id", "emailXpath", emailId);
			addComment("Successfully entered the email " + emailId);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in password textfield
		try {
			passwordInputValue = ExcelReader.getValue("Password");
			eo.enterText(driver, "Id", "passwordFieldXpath", passwordInputValue);
			addComment("Successfully entered the email " + passwordInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To enter data in mobile number textfield
		try {
			String mobileNumber = ExcelReader.getValue("MobileNumber");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered the mobile number " + mobileNumber);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the mobile number", e);
		}

		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			eo.verifyElementIsDisplayed(driver, "Xpath", "validPasswordMessageXpath");
			String text = eo.getText(driver, "Xpath", "validPasswordMessageXpath");
			if (text.equalsIgnoreCase("Password should be of minimum 6 characters.")) {
				addComment("Successfully verified the error message for invalid password in the password textfield");
			} else {
				throw new POMMethodExecException("Unable to verify the error message for 'invalid password' in the passwors textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify the error message for 'invalid password' in the passwors textfield", e);
		}
		// To clear the data in the password textfield
		eo.cleardata(driver, "Id", "passwordFieldXpath");
		// To enter the password
		try {
			passwordInputValue = ExcelReader.getValue("PasswordInputValue1");
			eo.enterText(driver, "Id", "passwordFieldXpath", passwordInputValue);
			addComment("Successfully entered the email " + passwordInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			Thread.sleep(1000);
			eo.verifyElementIsDisplayed(driver, "Xpath", "validPasswordMessageXpath");
			String text = eo.getText(driver, "Xpath", "validPasswordMessageXpath");
			if (text.equalsIgnoreCase("Please enter password.")) {
				addComment("Successfully verified the error message for invalid password in the password field");
			} else {
				throw new POMMethodExecException("Not able to verify the error message for invalid password in the password textfield");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the error message for invalid Password in the password textfield", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifySignUpPasswordfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> //To verify password textfield by giving space in the
	 * textfield
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 * 
	 */

	public void verifySignUpPasswordfield(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		// To enter data in your name textfield
		try {
			String yourName = ExcelReader.getValue("YourName");
			eo.enterText(driver, "Id", "yourNameXpath", yourName);
			addComment("Successfully entered the name " + yourName);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the name", e);
		}
		// To enter data in email textfield
		try {
			String emailId = ExcelReader.getValue("EmailId");
			eo.enterText(driver, "Id", "emailXpath", emailId);
			addComment("Successfully entered the email " + emailId);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}
		// To enter data in password textfield
		try {
			String passwordInputValue = ExcelReader.getValue("PasswordInputValue");
			eo.enterText(driver, "Id", "passwordFieldXpath", passwordInputValue);
			addComment("Successfully entered the password " + passwordInputValue);
		} catch (Exception e) {
			throw new POMMethodExecException("Successfully entered the password", e);
		}
		// To enter data in mobile number textfield
		try {
			String mobileNumber = ExcelReader.getValue("MobileNumber");
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered the mobile number " + mobileNumber);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the phone number", e);
		}

		// To click on the for him button
		try {
			eo.clickElement(driver, "Xpath", "himLabelButtonXpath");
			addComment("Successfully clicked on the for him button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the him button", e);
		}
		// To verify error message
		try {
			Thread.sleep(1000);
			eo.verifyElementIsDisplayed(driver, "Xpath", "validPasswordMessageXpath");
			String text = eo.getText(driver, "Xpath", "validPasswordMessageXpath");
			if (text.equalsIgnoreCase("Please enter password.")) {
				addComment("Successfully verified the error message for empty input in the password textfield");
			} else {
				throw new POMMethodExecException("NOt able to verify the error message");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("NOt able to verify the error message", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForSignInWithFacebookInLoginPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the sign in with facebook in login page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void verifyForSignInWithFacebookInLoginPage(WebDriver driver) throws Exception {

		String currentWindow = driver.getWindowHandle();
		// To click on sign in with facebook button
		try {
			eo.clickElement(driver, "XPath", "signInWithFacebookInLoginPageXpath");
			addComment("SignIn With facebook button is clicked");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the facebook button", e);
		}
		Thread.sleep(5000);
		Set<String> availableWindows = driver.getWindowHandles();
		for (String windowId : availableWindows) {
			String switchedWindowTitle = driver.switchTo().window(windowId).getTitle();
			if ((switchedWindowTitle.equals("Log in to Facebook | Facebook")) || (switchedWindowTitle.contains("Log in to Facebook | Facebook"))) {
				addComment("Successfully navigated to facebook account");
			} else {
				throw new POMMethodExecException("Could not navigated to facebook account");
			}

		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForSignInWithGoogleInLoginPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the sign up with google in login page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void verifyForSignInWithGoogleInLoginPage(WebDriver driver) throws Exception {

		String currentWindow = driver.getWindowHandle();
		// To click on sign in with google button
		try {
			eo.clickElement(driver, "XPath", "signInWithGoogleInLoginPageXpath");
			addComment("Sign in With goggle button is clicked");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the google button", e);
		}
		Thread.sleep(5000);
		Set<String> availableWindows = driver.getWindowHandles();
		for (String windowId : availableWindows) {
			String switchedWindowTitle = driver.switchTo().window(windowId).getTitle();
			if ((switchedWindowTitle.equals("Sign in - Google Accounts")) || (switchedWindowTitle.contains("Sign in - Google Accounts"))) {
				addComment("Successfully navigated to google account");
			} else {
				throw new POMMethodExecException("Could not navigated to google account");
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyNewToTrendinLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify New To Trendin Link
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */
	public void verifyNewToTrendinLink(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		// To click on new To Trend Link
		try {
			eo.clickElement(driver, "XPath", "newToTrendLinkXpath");
			addComment("Successfully clicked on New to trendin link");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on teh new to trend in button", e);
		}
		// To verify login/register page is displayed
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "verifyLoginPageXpath");
			if (pageStatus) {
				addComment("Login/Register page is displayed");
				break;
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyBrandLogosOnTheLoginPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify logos of the different brands on the
	 * login/register page
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 * 
	 */
	public void verifyBrandLogosOnTheLoginPage(WebDriver driver) throws Exception {

		// To verify the logos
		eo.verifyElementIsDisplayed(driver, "Xpath", "allBrandLogoXpath");
		addComment("Successfully verified the all brand logos in the login page");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyMouseOverActionOnGoogleButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify logos of the different brands on the
	 * login/register page
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */
	public void verifyColorChangeOnMouseOverGoogleButton(WebDriver driver) throws Exception {

		try {
			eo.wait(1000);
			String orangeColorHexaValue = "#DF4A32".toLowerCase();
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("signInGoggleXPath", curApp)));
			eo.wait(2000);
			act.moveToElement(ele).build().perform();
			String color = ele.getCssValue("background-color");
			String color1 = ele.getCssValue("background");
			eo.wait(5000);
			// String color = ele.getCssValue("background-color").toLowerCase();
			addComment(color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String hex = Integer.toHexString(hexValue1);
			String hex1 = Integer.toHexString(hexValue2);
			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3).toLowerCase();
			addComment(actualColor);
			if (orangeColorHexaValue.equals(actualColor)) {
				addComment("Successfully verified the color");
			} else {
				throw new POMMethodExecException("Not matching the color Hexa deciamal value.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not matching the color Hexa deciamal value.", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyGmailPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the gmail page labels and logos
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */

	public void verifyGmailPage(WebDriver driver) throws Exception {
		// To click on sign in with Google link.
		try {
			eo.clickElement(driver, "Xpath", "signInWithGoogleInLoginPageXpath");
			addComment("Clicked on sign In with google link.");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to click on sign up with google", e);
		}
		// To verify the google logo
		boolean googleLogo = eo.verifyElementIsDisplayed(driver, "CssSelector", "googleLogoCss");
		try {
			if (googleLogo) {
				addComment("Google logo is displayed " + googleLogo);
			} else {
				throw new POMMethodExecException("Not able to verify the Google logo");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Google logo", e);
		}

		// To verify the header of the google page
		boolean headerInGoogleLoginPage = eo.verifyElementIsDisplayed(driver, "Xpath", "bannerTextXpath");
		try {
			if (headerInGoogleLoginPage) {
				addComment("Google Header is displayed " + headerInGoogleLoginPage);
			} else {
				throw new POMMethodExecException("Not able to verify the Google header");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Google header", e);
		}
		// To verify the need help
		boolean needHelpLabel = eo.verifyElementIsDisplayed(driver, "Xpath", "needHelpTextXpath");
		try {
			if (needHelpLabel) {
				addComment("Need Help Label displayed " + needHelpLabel);
			} else {
				throw new POMMethodExecException("Not able to verify the needhelp label");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need  help label", e);
		}

		// To verify the header of the google page
		boolean createAccountHelp = eo.verifyElementIsDisplayed(driver, "Xpath", "createAccountXpath");
		try {
			if (createAccountHelp) {
				addComment("Create account Label displayed " + createAccountHelp);
			} else {
				throw new POMMethodExecException("Not able to verify the Create");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need  create account", e);

		}
		// To verify the header of the google page
		boolean tagLineText = eo.verifyElementIsDisplayed(driver, "Xpath", "tagLineXpath");
		try {
			if (tagLineText) {
				addComment("Create account Label displayed " + tagLineText);
			} else {
				throw new POMMethodExecException("Not able to verify the Create");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need  create account", e);

		}
		// To verify the tag line of the google page
		boolean logoStirp = eo.verifyElementIsDisplayed(driver, "Xpath", "logoStripXpath");
		try {
			if (logoStirp) {
				addComment("logoS trip Label displayed " + logoStirp);
			} else {
				throw new POMMethodExecException("Not able to verify the Create");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need  create account", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyErorMessageOnEmptyEmailTextField
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message on empty textfields
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */

	public void verifyErorMessageOnEmptyEmailTextField(WebDriver driver) throws Exception {

		// To enter email address
		try {
			String userName = ExcelReader.getValue("UserName1");
			eo.enterText(driver, "CssSelector", "googleEmailCss", userName);
			addComment("Successfully entered the gmail email");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the gmail id", e);
		}
		// To click on Next button
		try {
			eo.clickElement(driver, "CssSelector", "googleNextCss");
			addComment("Successfully clicked on the Next button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the next button", e);
		}
		eo.wait(2000);
		boolean element = eo.verifyElementIsDisplayed(driver, "Xpath", "errorMessageXpath");
		if (element) {
			String text = eo.getText(driver, "Xpath", "errorMessageXpath");
			if (text.equalsIgnoreCase("Please enter a valid email address.") | text.equalsIgnoreCase("Please enter your email.")) {
				addComment("Successfully verified the message :" + text);
			} else {
				throw new POMMethodExecException("Could not verify email Error message");
			}

		}
		// To enter email address
		try {
			String userName = ExcelReader.getValue("UserName");
			eo.enterText(driver, "CssSelector", "googleEmailCss", userName);
			addComment("Successfully entered the facebook email");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the google email", e);
		}
		// To click on Next button
		try {
			eo.clickElement(driver, "CssSelector", "googleNextCss");
			addComment("Successfully clicked on the Next button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the next button", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMessageOnPasswordTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message on password textfields
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */

	public void verifyErrorMessageOnPasswordTextfield(WebDriver driver) throws Exception {
		// To enter password
		try {
			String password = ExcelReader.getValue("Password1");
			eo.enterText(driver, "CssSelector", "googlePasswordCss", password);
			addComment("Successfully entered the google password");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the google password", e);
		}
		// To click on submit button
		try {
			eo.clickElement(driver, "CssSelector", "googleSignIn");
			addComment("Successfully clicked on the submit button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the submit button", e);
		}
		try {
			String password = ExcelReader.getValue("Password");
			eo.enterText(driver, "CssSelector", "googlePasswordCss", password);
			addComment("Successfully entered the google password");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the google password", e);
		}
		eo.wait(2000);
		boolean element = eo.verifyElementIsDisplayed(driver, "Xpath", "errorPasswordMessageXpath");
		if (element) {
			String text = eo.getText(driver, "Xpath", "errorPasswordMessageXpath");
			if (text.equalsIgnoreCase("Please enter your password.")) {
				addComment("Successfully verified the message :" + text);
			} else {
				throw new POMMethodExecException("Could not verify password Error message");
			}

		}
		// To click on submit button
		try {
			eo.clickElement(driver, "CssSelector", "googleSignIn");
			addComment("Successfully clicked on the submit button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the submit button", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnDenyButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the deny button
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */
	public void clickOnDenyButton(WebDriver driver) throws Exception {
		eo.wait(5000);
		// To click on deny
		eo.clickElement(driver, "Xpath", "denyButtonXpath");
		addComment("Successfully clicked on the deny button");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> trendInAuthenticationPageTextfields
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the trend in authentication page textfields
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */
	public void trendInAuthenticationPageTextfields(WebDriver driver) throws Exception {
		eo.wait(5000);
		// To enter the email
		try {
			String userName = ExcelReader.getValue("ExistingUserName");
			eo.enterText(driver, "Xpath", "gmailExistingUserXpath", userName);
			addComment("Successfully entered the email " + userName);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the email", e);
		}

		try {
			String password = ExcelReader.getValue("ExistingUserPassword");
			eo.enterText(driver, "Xpath", "gmailExistingPasswordXpath", password);
			addComment("Successfully entered the password " + password);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter the password", e);
		}
		// To click on the existing user login button
		try {
			eo.clickElement(driver, "Xpath", "userSubmitButtonXpath");
			Thread.sleep(1000);
			addComment("Successfully clicked on the existing user login button");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the login button in the already registered page ", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyUserNameInHomePage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the user name that is on the home page of
	 * trendin after signed in from the gmail account
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */

	public void verifyUserNameInHomePage(WebDriver driver) throws Exception {
		eo.wait(3000);
		String userName = ExcelReader.getValue("UserNameText");
		String getUserName = eo.getText(driver, "CssSelector", "usernameClickXpath");
		if (userName.equalsIgnoreCase(getUserName)) {
			addComment("Successfully verified the usernames " + userName);
		} else {
			throw new POMMethodExecException("Unable tp verify the usernames");
		}

	}

	public void verifyHomePageDetailsInOtherPages(WebDriver driver) throws Exception {

		// To verify shop by brand
		eo.verifyElementIsDisplayed(driver, "XPath", "shopByBrandsXpath");
		addComment("Shop by brands tab is dispalyed");

		// To verify store locator icon
		eo.verifyElementIsDisplayed(driver, "Xpath", "storeLocatorXpath");
		addComment("Store locator icon is dispalyed");

		// To verify Track order icon
		eo.verifyElementIsDisplayed(driver, "Xpath", "trackOrderXpath");
		addComment("Track order icon is dispalyed");

		// To verify contact us icon
		eo.verifyElementIsDisplayed(driver, "Xpath", "contactUsXpath");
		addComment("Contact Us icon is dispalyed");

		// To verify search drop down
		eo.verifyElementIsDisplayed(driver, "Xpath", "searchDropDown");
		addComment("Search Drop Down is dispalyed");

		// To verify mega menu bars
		List<WebElement> allAddresses = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allMenuMegaLabelXpath", curApp)));
		for (WebElement element : allAddresses) {
			String allElementsUI = element.getText();
			int count = 0;
			String allMegaMenuLabels[] = allElementsUI.split(";");
			String megaMenuValue = GetElementIdentifier.getProperty("megaMenuXpath", curApp);
			megaMenuValue = megaMenuValue.replace("{replaceText}", allMegaMenuLabels[count]);
			if (allElementsUI.equalsIgnoreCase(allMegaMenuLabels[count])) {
				addComment("Successfully verified Mega Menu Label is " + allMegaMenuLabels[count]);
			}
		}

	}

	public void verifyMyAccountPage(WebDriver driver) throws Exception {

		// To verify new user radio button
		eo.verifyElementIsDisplayed(driver, "XPath", "newUserXPath");
		addComment("New user radio button is displayed");

		// To verify existing user radio button
		eo.verifyElementIsDisplayed(driver, "XPath", "existingUserXpath");
		addComment("Existing user radio button is displayed");

		// To verify log in label
		eo.verifyElementIsDisplayed(driver, "XPath", "loginPageXpath");
		addComment("Successfully verified login page");

		// To verify existing user label
		eo.verifyElementIsDisplayed(driver, "XPath", "exixtingUserLableXpath");
		addComment("Existing user label is displayed");

		// To verify email id text box
		eo.verifyElementIsDisplayed(driver, "Id", "emailIdXpath");
		addComment("Email id field is displayed");

		// To verify password text box
		eo.verifyElementIsDisplayed(driver, "XPath", "passwordFieldExistingUserXpath");
		addComment("Password field is displayed");

		// To verify submit button
		eo.verifyElementIsDisplayed(driver, "Id", "submitInExistingUSerXPath");
		addComment("Submit button is displayed");

		// To verify forgot password link
		eo.verifyElementIsDisplayed(driver, "XPath", "forgotPasswordLinkExistingUSerXpath");
		addComment("Forgot password link is displayed");

		eo.clickElement(driver, "XPath", "newUserXPath");
		addComment("Successfully clicked on new user radio button");

	}

	public void verifyMyAccountNewUserPage(WebDriver driver) throws Exception {

		String facebookValidate = ExcelReader.getValue("FacebookValidate");
		String googleValidation = ExcelReader.getValue("GoogleValidation");

		eo.verifyElementIsDisplayed(driver, "XPath", "loginPageXpath");
		addComment("Successfully verified login page");

		eo.verifyElementIsDisplayed(driver, "XPath", "newUserLabelXpath");
		addComment("New User Label is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "firstNameInNewUserXpath");
		addComment("First name text field is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "emailIdNewUserXPath");
		addComment("Email id text field is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "passwordNewUserXPath");
		addComment("Password text field is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "mobileNumberNewUserXpath");
		addComment("Mobile number text field is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "iAgreeCheckBoxXpath");
		addComment("I agree with terms of use and privacy policy is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "registerButtonNewUserXpath");
		addComment("Register button is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "newUserSignInWithGoogleXPath");
		addComment("Sign in with google button is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "connectWithFaceBookXpath");
		addComment("Connect using facebook button is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "signUpWithLabelXPath");
		addComment("Sign up with label is displayed");

		if (facebookValidate.equalsIgnoreCase("True")) {

			eo.clickElement(driver, "XPath", "connectWithFaceBookXpath");
			addComment("Connect using facebook button is clicked");

			String title = driver.getTitle();
			if (title.equalsIgnoreCase("Log in to Facebook | Facebook")) {
				addComment("Successfully navigated to facebook page :" + title);
			} else {
				throw new POMMethodExecException("Could not navigate to facebook page");
			}
		}

		if (googleValidation.equalsIgnoreCase("True")) {

			eo.clickElement(driver, "XPath", "newUserSignInWithGoogleXPath");
			addComment("Google button is clicked");

			String title = driver.getTitle();
			if (title.equalsIgnoreCase("Sign in - Google Accounts")) {
				addComment("Successfully navigated to google page :" + title);
			} else {
				throw new POMMethodExecException("Could not navigate to google page");
			}

		}

	}

	public void verifyFacebookPage(WebDriver driver) throws Exception {
		// To verify the facebook logo
		boolean googleLogo = eo.verifyElementIsDisplayed(driver, "CssSelector", "facebookLogoXpath");
		try {
			if (googleLogo) {
				addComment("Facebook logo is displayed " + googleLogo);
			} else {
				throw new POMMethodExecException("Not able to verify the facebook logo");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the facebook logo", e);
		}

		// To verify the email or phone textbox
		eo.verifyElementIsDisplayed(driver, "Xpath", "facebookEmailOrPhoneTextBox");
		addComment("Successfully verified the email or phone textbox");

		// To verify the password textbox
		eo.verifyElementIsDisplayed(driver, "Xpath", "facebookPasswordTextBox");
		addComment("Successfully verified the password textbox");

		// To verify the keep me logged in checkbox
		eo.verifyElementIsDisplayed(driver, "Xpath", "keepMeLoggedInLabel");
		addComment("Successfully verified the keep me logged in checkbox");

		// To verify the forgot password link
		eo.verifyElementIsDisplayed(driver, "Xpath", "forgotPasswordLinkXpath");
		addComment("Successfully verified the forgot password link");

		// To verify the login button
		eo.verifyElementIsDisplayed(driver, "Xpath", "logInButonXpath");
		addComment("Successfully verified the login button");

	}

	public void verifyLoginToFacebook(WebDriver driver) throws Exception {

		String emailOrPhone = ExcelReader.getValue("EmailOrPhone");
		String password = ExcelReader.getValue("Password");
		String invalidEmailOrPhone = ExcelReader.getValue("InvalidEmailOrPhone");
		String invalidPassword = ExcelReader.getValue("InvalidPassword");
		String validCredentials = ExcelReader.getValue("ValidCredentials");
		String invalidValidCredentials = ExcelReader.getValue("InvalidValidCredentials");

		if (invalidValidCredentials.equalsIgnoreCase("True")) {

			eo.enterText(driver, "Xpath", "facebookEmailOrPhoneTextBox", invalidEmailOrPhone);
			addComment("Successfully Enetered in Email Or Phone text field :" + invalidEmailOrPhone);

			eo.enterText(driver, "Xpath", "facebookPasswordTextBox", password);
			addComment("Successfully Enetered in password text field :" + password);

			// To verify the login button
			eo.clickElement(driver, "Xpath", "logInButonXpath");
			addComment("Successfully clicked on login button");

			boolean error = eo.verifyElementIsDisplayed(driver, "XPath", "errorFacebookMessageEmailPasswordXpath");
			if (error) {
				String text = eo.getText(driver, "XPath", "errorFacebookMessageEmailPasswordXpath");
				addComment("Error message is displayed foe empty email id field :" + text);
			} else {
				throw new POMMethodExecException("Error message is not displayed");
			}

			eo.cleardata(driver, "Xpath", "facebookPasswordTextBox");

			eo.enterText(driver, "Xpath", "facebookEmailOrPhoneTextBox", emailOrPhone);
			addComment("Successfully Enetered in Email Or Phone text field :" + emailOrPhone);

			eo.enterText(driver, "Xpath", "facebookPasswordTextBox", invalidPassword);
			addComment("Successfully Enetered in password text field :" + invalidPassword);

			// To verify the login button
			eo.clickElement(driver, "Xpath", "logInButonXpath");
			addComment("Successfully clicked on login button");

			boolean error1 = eo.verifyElementIsDisplayed(driver, "XPath", "errorFacebookMessageEmailPasswordXpath");
			if (error1) {
				String text = eo.getText(driver, "XPath", "errorFacebookMessageEmailPasswordXpath");
				addComment("Error message is displayed foe empty email id field :" + text);
			} else {
				throw new POMMethodExecException("Error message is not displayed");
			}

			eo.cleardata(driver, "Xpath", "facebookEmailOrPhoneTextBox");

		}

		if (validCredentials.equalsIgnoreCase("True")) {
			eo.enterText(driver, "Xpath", "facebookEmailOrPhoneTextBox", emailOrPhone);
			addComment("Successfully Enetered in Email Or Phone text field :" + emailOrPhone);

			eo.enterText(driver, "Xpath", "facebookPasswordTextBox", password);
			addComment("Successfully Enetered in password text field :" + password);

			// To verify the login button
			eo.clickElement(driver, "Xpath", "logInButonXpath");
			addComment("Successfully clicked on login button");

			eo.wait(9000);

		}

	}

	public void verifyPersonalInformationPageInMyAccountPage(WebDriver driver) throws Exception {

		String email = ExcelReader.getValue("EmailOrPhone");
		// To verify personal information header is displayed

		boolean personalInfoHeader = eo.verifyElementIsDisplayed(driver, "Xpath", "personalInfoTitleCss");
		try {
			if (personalInfoHeader) {
				addComment("Personal information header is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Personal information header ");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Personal information header ", e);
		}

		// To verify 'FirstName' text box is displayed

		boolean firstNameTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "firstNameXpath");
		try {
			if (firstNameTextBox) {
				addComment("First name is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the First name");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the First name", e);
		}

		// To verify 'Email' text box is displayed

		boolean emailTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "emailAccontXpath");
		try {
			if (emailTextBox) {
				String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("emailAccontXpath", curApp))).getAttribute("value");
				addComment("Email text box is displayed :" + text);
				if (text.equalsIgnoreCase(email)) {
					addComment("Successfully logged in through facebook");
				} else {
					throw new POMMethodExecException("Could not loggin through facebook");
				}

			} else {
				throw new POMMethodExecException("Not able to verify the Email text box");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Email text box", e);
		}

	}

	public void verifyColorChangeOnMouseOverFacebookButton(WebDriver driver) throws Exception {
		try {

			String orangeColorHexaValue = "#2a567a".toLowerCase();
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("facebookButtonXpath", curApp)));
			eo.wait(2000);
			act.moveToElement(ele).build().perform();
			String color = ele.getCssValue("background-color");
			String color1 = ele.getCssValue("background-color");
			eo.wait(5000);
			// String color = ele.getCssValue("background-color").toLowerCase();
			addComment(color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String hex = Integer.toHexString(hexValue1);
			String hex1 = Integer.toHexString(hexValue2);
			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3).toLowerCase();
			addComment(actualColor);
			if (orangeColorHexaValue.equals(actualColor)) {
				addComment("Successfully verified the color");
			} else {
				throw new POMMethodExecException("Not matching the color Hexa deciamal value.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not matching the color Hexa deciamal value.", e);
		}
	}

	public void verifyColorchangeOnMouseHoverOnConnectWithFacebookButton(WebDriver driver) throws Exception {
		try {
			eo.wait(1000);
			String blueColorHexaValue = "#2A567A".toLowerCase();
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("connectWithFaceBookXpath", curApp)));
			eo.wait(2000);
			act.moveToElement(ele).build().perform();
			String color = ele.getCssValue("background-color");
			String color1 = ele.getCssValue("background");
			eo.wait(5000);
			addComment(color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String hex = Integer.toHexString(hexValue1);
			String hex1 = Integer.toHexString(hexValue2);
			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3).toLowerCase();
			addComment(actualColor);
			if (blueColorHexaValue.equals(actualColor)) {
				addComment("Successfully verified the color of facebook button");
			} else {
				throw new POMMethodExecException("Not matching the color Hexa deciamal value.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not matching the color Hexa deciamal value.", e);
		}

	}

	public void verifyColorChangeOnMouseOverGoogleButtonInNewUser(WebDriver driver) throws Exception {

		try {

			String orangeColorHexaValue = "#DF4A32".toLowerCase();
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("newUserSignInWithGoogleXPath", curApp)));
			eo.wait(2000);
			act.moveToElement(ele).build().perform();
			String color = ele.getCssValue("background-color");
			String color1 = ele.getCssValue("background");
			eo.wait(5000);
			// String color = ele.getCssValue("background-color").toLowerCase();
			addComment(color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);

			String hex = Integer.toHexString(hexValue1);
			String hex1 = Integer.toHexString(hexValue2);
			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3).toLowerCase();
			addComment(actualColor);
			if (orangeColorHexaValue.equals(actualColor)) {
				addComment("Successfully verified the color of google button");
			} else {
				throw new POMMethodExecException("Not matching the color Hexa deciamal value.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not matching the color Hexa deciamal value.", e);
		}

	}

	public void verifyGmailPageLogos(WebDriver driver) throws Exception {

		// To verify the google logo
		boolean googleLogo = eo.verifyElementIsDisplayed(driver, "CssSelector", "googleLogoCss");
		try {
			if (googleLogo) {
				addComment("Google logo is displayed " + googleLogo);
			} else {
				throw new POMMethodExecException("Not able to verify the Google logo");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Google logo", e);
		}

		// To verify the header of the google page
		boolean headerInGoogleLoginPage = eo.verifyElementIsDisplayed(driver, "Xpath", "bannerTextXpath");
		try {
			if (headerInGoogleLoginPage) {
				addComment("Google Header is displayed " + headerInGoogleLoginPage);
			} else {
				throw new POMMethodExecException("Not able to verify the Google header");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Google header", e);
		}
		// To verify the need help
		boolean needHelpLabel = eo.verifyElementIsDisplayed(driver, "Xpath", "needHelpTextXpath");
		try {
			if (needHelpLabel) {
				addComment("Need Help Label displayed " + needHelpLabel);
			} else {
				throw new POMMethodExecException("Not able to verify the needhelp label");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need  help label", e);
		}

		// To verify the header of the google page
		boolean createAccountHelp = eo.verifyElementIsDisplayed(driver, "Xpath", "createAccountXpath");
		try {
			if (createAccountHelp) {
				addComment("Create account Label displayed " + createAccountHelp);
			} else {
				throw new POMMethodExecException("Not able to verify the Create");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need  create account", e);

		}
		// To verify the header of the google page
		boolean tagLineText = eo.verifyElementIsDisplayed(driver, "Xpath", "tagLineXpath");
		try {
			if (tagLineText) {
				addComment("Tag line displayed " + tagLineText);
			} else {
				throw new POMMethodExecException("Not able to verify the Tag line");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need Tag line", e);

		}
		// To verify the tag line of the google page
		boolean logoStirp = eo.verifyElementIsDisplayed(driver, "Xpath", "logoStripXpath");
		try {
			if (logoStirp) {
				addComment("Logo strip Label displayed " + logoStirp);
			} else {
				throw new POMMethodExecException("Not able to verify the logo strip ");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the need logo strip ", e);
		}

	}

	public void verifyAboutUsOptions(WebDriver driver) throws Exception {

		String aboutUsOptions = ExcelReader.getValue("AboutUsOptions");
		String allAboutUsOptions[] = aboutUsOptions.split(";");
		int count = 0;
		List<WebElement> allAddresses = driver.findElements(By.xpath(GetElementIdentifier.getProperty("aboutUsOptionXpath", curApp)));
		for (WebElement element : allAddresses) {
			String allElementsUI = element.getText();
			if (allElementsUI.equalsIgnoreCase(allAboutUsOptions[count])) {
				addComment("Successfully verified about us options in footer " + allAboutUsOptions[count]);
				count++;
			}
		}

	}

	public void verifyGroupSitesOptions(WebDriver driver) throws Exception {

		String groupSitesOptions = ExcelReader.getValue("GroupSitesOptions");
		String allGroupSitesOptions[] = groupSitesOptions.split(";");
		int count = 0;
		List<WebElement> allAddresses = driver.findElements(By.xpath(GetElementIdentifier.getProperty("groupAndSitesXpath", curApp)));
		for (WebElement element : allAddresses) {
			String allElementsUI = element.getText();
			if (allElementsUI.equalsIgnoreCase(allGroupSitesOptions[count])) {
				addComment("Successfully verified about us options in footer " + allGroupSitesOptions[count]);
				count++;
			}
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b>
	 * verifyPersonalInformationPageInMyAccountPageAfterNavigateFromGoogle
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify personal information present in the my
	 * account page
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */
	public void verifyPersonalInformationPageInMyAccountPageAfterNavigateFromGoogle(WebDriver driver) throws Exception {

		String username = ExcelReader.getValue("UserName");
		// To verify personal information header is displayed

		boolean personalInfoHeader = eo.verifyElementIsDisplayed(driver, "Xpath", "personalInfoTitleCss");
		try {
			if (personalInfoHeader) {
				addComment("Personal information header is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Personal information header ");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Personal information header ", e);
		}

		// To verify 'FirstName' text box is displayed

		boolean firstNameTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "firstNameXpath");
		try {
			if (firstNameTextBox) {
				addComment("First name is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the First name");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the First name", e);
		}

		// To verify 'Email' text box is displayed

		boolean emailTextBox = eo.verifyElementIsDisplayed(driver, "Xpath", "emailAccontXpath");
		try {
			if (emailTextBox) {
				String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("emailAccontXpath", curApp))).getAttribute("value");
				addComment("Email text box is displayed :" + text);
				if (text.equalsIgnoreCase(username)) {
					addComment("Successfully logged in through gmail");
				} else {
					throw new POMMethodExecException("Could not loggin through gmail");
				}

			} else {
				throw new POMMethodExecException("Not able to verify the Email text box");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Email text box", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyOnContactUsOptionsInFooterLinks
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify contact us options
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */
	public void verifyOnMyAccountsOptionsInFooterLinks(WebDriver driver) throws Exception {

		// To verify mega menu bars
		String myAccountOptions = ExcelReader.getValue("MyAccountOptionValue");
		String allMyAccountFootersLabels[] = myAccountOptions.split(";");
		int count = 0;
		List<WebElement> allMyAccountOptionFooters = driver.findElements(By.xpath(GetElementIdentifier.getProperty("myAccountOptionsXpath", curApp)));
		for (WebElement element : allMyAccountOptionFooters) {
			String allMyAccountDropUI = element.getText();

			if (allMyAccountDropUI.equalsIgnoreCase(allMyAccountFootersLabels[count])) {
				addComment("Successfully verified Mega Menu Label is " + allMyAccountFootersLabels[count]);
				count++;
			}

		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyOnContactUsOptionsInFooterLinks
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify options of the contact us options
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */

	public void verifyOnContactUsOptionsInFooterLinks(WebDriver driver) throws Exception {

		// To verify mega menu bars
		String contactUsOptions = ExcelReader.getValue("ContactUs");
		String allContactUsOptionsFootersLabels[] = contactUsOptions.split(";");
		int count = 0;
		List<WebElement> allContactOptionFooters = driver.findElements(By.xpath(GetElementIdentifier.getProperty("contactUsOptionsXpath", curApp)));
		for (WebElement element : allContactOptionFooters) {
			String allContactOptionUI = element.getText();

			if (allContactOptionUI.equalsIgnoreCase(allContactUsOptionsFootersLabels[count])) {
				addComment("Successfully verified Mega Menu Label is " + allContactUsOptionsFootersLabels[count]);
				count++;
			}

		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnMyOrderInTheFooterLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the my account page
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Manasa M G
	 *
	 */

	public void clickOnMyOrderInTheFooterLink(WebDriver driver) throws Exception {
		eo.clickElement(driver, "Xpath", "myAccountOptionMyOrderLinkXpath");
		addComment("Successfully clicked on the my order footer link");
		eo.wait(5000);
	}

	public void validateSignInWithFacebookButtonInLoginPage(WebDriver driver) throws Exception {

		String currentWindow = driver.getWindowHandle();
		// To click on sign in with facebook button
		try {
			eo.clickElement(driver, "XPath", "facebookButtonXpath");
			addComment("SignIn With facebook button is clicked");
		} catch (Exception e) {
			throw new POMMethodExecException("Couldn't click on the facebook button", e);
		}
		Set<String> availableWindows = driver.getWindowHandles();
		for (String windowId : availableWindows) {
			String switchedWindowTitle = driver.switchTo().window(windowId).getTitle();
			if ((switchedWindowTitle.equals("Log in to Facebook | Facebook")) || (switchedWindowTitle.contains("Log in to Facebook | Facebook"))) {
				addComment("Successfully navigated to facebook account");
			} else {
				throw new POMMethodExecException("Could not navigated to facebook account");
			}

		}

	}

	public void VerifyValidCrendentialsToLoginPageTextFields(WebDriver driver, String yourName, String emailId, String password, String mobileNumberInputValue) throws Exception {
		Thread.sleep(2000);
		// To enter the username

		eo.enterText(driver, "Id", "yourNameXpath", yourName);
		addComment("Successfully entered name field :" + yourName);

		// To enter the email id

		eo.enterText(driver, "Id", "emailXpath", emailId);
		addComment("Successfully entered email field :" + emailId);

		// To enter the password

		eo.enterText(driver, "Id", "passwordFieldXpath", password);
		addComment("Successfully entered password field :" + password);

		// To enter the mobile number

		eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumberInputValue);
		addComment("Successfully entered mobile number field :" + mobileNumberInputValue);

		// To click on for him button
		eo.clickElement(driver, "id", "btnLoginForHimXpath");
		addComment("Successfully clicked on for him link");

	}

	public String orderNumber = "";

	public void verifyForAddCartPlaceOrderFuctionality(WebDriver driver) throws Exception {

		String paymentOption = ExcelReader.getValue("PaymentOption");
		eo.clickElement(driver, "Id", "addToBagXpath");
		addComment("Add to my Bag Button is clicked");
		eo.wait(5000);
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("adityaBirlaImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		eo.wait(5000);
		// To verify top button
		eo.clickElement(driver, "Xpath", "topButtonXpath");
		addComment("Top button is clicked");
		eo.wait(5000);
		eo.clickElement(driver, "XPath", "cartValueXpath");
		addComment("Successfully clicked on cart symbol");

		String title = driver.getTitle();
		if (title.equalsIgnoreCase("Checkout Summary")) {
			addComment("Successfully navigated to summary page:" + title);
		} else {
			throw new POMMethodExecException("Could not navigate to summary page");
		}

		eo.clickElement(driver, "XPath", "placeOrderButtonXpath");
		addComment("Place order buton is clicked");

		boolean pageElement = false;
		for (int i = 0; i <= 5000; i++) {
			pageElement = eo.verifyElementIsDisplayed(driver, "XPath", "headerAddressPageXpath");
			if (pageElement) {
				addComment("Address page is displayed");
				break;
			}
		}
		if (!pageElement) {
			throw new POMMethodExecException("Address page is not displayed");
		}

		eo.clickElement(driver, "Id", "addressRadioButtonId");
		addComment("Successfully selected the address radio button");

		eo.wait(5000);
		eo.clickElement(driver, "Id", "continueToCheckOutId");
		addComment("Successfully clicked on continue to check out button");

		String title1 = driver.getTitle();
		if (title1.equalsIgnoreCase("Checkout Payment")) {
			addComment("Successfully navigated to payment page:" + title1);
		} else {
			throw new POMMethodExecException("Could not navigate to summary page");
		}

		List<WebElement> allPaymentsOption = driver.findElements(By.xpath(GetElementIdentifier.getProperty("paymentOptionsRadioButtonsXpath", curApp)));
		addComment("No of payment options  available are: " + allPaymentsOption.size());
		for (WebElement element1 : allPaymentsOption) {
			String option = element1.getAttribute("role");
			if (option.equalsIgnoreCase(paymentOption)) {
				element1.click();
				addComment("Successfully clicked on " + paymentOption);
				break;
			}
		}

		boolean verifyText3 = false;
		verifyText3 = eo.verifyElementIsDisplayed(driver, "Id", "verifyAccountVerifiedTextId");
		if (verifyText3) {
			String text = eo.getText(driver, "Id", "verifyAccountVerifiedTextId");
			if (text.equalsIgnoreCase("You are already verified, Please click PLACE ORDER to proceed.")) {
				addComment("Successfully Displayed :" + text);
			} else {
				throw new POMMethodExecException("could not verify the text");
			}
		} else {
			String captchaValue = eo.getText(driver, "Id", "captchaImageId");
			eo.enterText(driver, "Id", "captchaTextBoxId", captchaValue);
			addComment("Successfully entered captcha value");
			eo.clickElement(driver, "Id", "verifyButtonId");

			boolean verifyText = false;

			for (int i = 0; i <= 5000; i++) {
				verifyText = eo.verifyElementIsDisplayed(driver, "Id", "verifiedAccountMessageId");

				if (verifyText) {
					String text = eo.getText(driver, "Id", "verifiedAccountMessageId");
					addComment("Successfully Displayed :" + text);
					break;
				}
			}
			if (!verifyText) {
				throw new POMMethodExecException("Could not verify the text");
			}
		}
		eo.clickElement(driver, "XPath", "placeOrderButtonXpath");
		addComment("Successfully clicked on place Order button");

		String title2 = driver.getTitle();
		if (title2.equalsIgnoreCase("Order Confirmation")) {
			addComment("Successfully navigated to order confirmation page");
		} else {
			throw new POMMethodExecException("Could not navigate to order confirmation page");
		}

		orderNumber = eo.getText(driver, "XPath", "orderNumLinkXpath");
		eo.clickElement(driver, "XPath", "orderNumLinkXpath");
		addComment("Successfully Clicked on order number :" + orderNumber);

		boolean verifyText1 = false;
		for (int i = 0; i <= 5000; i++) {
			verifyText1 = eo.verifyElementIsDisplayed(driver, "XPath", "orderHistoryHeaderXpath");
			if (verifyText1) {
				addComment("Successfully Order history page is displayed :");
				break;
			}
		}
		if (!verifyText1) {
			throw new POMMethodExecException("Could not verify the Order history page");
		}

		List<WebElement> allRecentOrder = driver.findElements(By.xpath(GetElementIdentifier.getProperty("recentOrdersXpath", curApp)));
		for (WebElement element2 : allRecentOrder) {
			String placedOrderNumber = element2.getText();
			if (orderNumber.equalsIgnoreCase(placedOrderNumber)) {
				addComment("Recent order has been dispalyed in order history" + orderNumber);
				break;
			}
		}

	}

	public void clickOnCancelOrder(WebDriver driver) throws Exception {
		List<WebElement> allCancelOrder = driver.findElements(By.xpath(GetElementIdentifier.getProperty("closeButtonXpath", curApp)));
		for (WebElement element : allCancelOrder) {
			String allElementsUI = element.getAttribute("id");
			String allElement[] = allElementsUI.split("_");
			addComment(allElement[1]);
			if (allElement[1].contains(orderNumber)) {
				eo.clickElement(driver, "Xpath", "closeButtonXpath");
				addComment("Successfully clicked on the cancel order button");
				eo.wait(2000);
				String errormessage = eo.getText(driver, "Xpath", "headerTextInThePopUpPage");
				addComment("Successfully verified the pop up " + errormessage);
				eo.clickElement(driver, "Xpath", "popUpCloseButtonXpath");
				addComment("Successfully clicked on the pop up close button");
				break;
			}

		}
		eo.wait(5000);
		String reOrderButtonXpath = GetElementIdentifier.getProperty("reOrderButtonXpath", curApp);
		reOrderButtonXpath = reOrderButtonXpath.replace("{OrderNo}", orderNumber);
		boolean pageElement = driver.findElement(By.xpath(reOrderButtonXpath)).isDisplayed();
		if (pageElement) {
			addComment("Successfully verified the ReorderButton");
		} else {
			throw new POMMethodExecException("Reorder button is not displayed");
		}
	}

	public void clickOnTheHomeBanner(WebDriver driver) throws Exception {
		
		String homeBannerLabelXpath = GetElementIdentifier.getProperty("homeBannerLabelXpath", curApp);
		WebElement option = driver.findElement(By.xpath(homeBannerLabelXpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", option);
		addComment("Successfully clicked on the homwbanner");
		
	}

	public void selectColorAndVerify(WebDriver driver) throws Exception {

		String selectColor = ExcelReader.getValue("SelectColor");
		eo.wait(2000);
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("selectColorXpath", curApp)));

		String allElementsInUI[] = new String[allElements.size()];
		int count = 0;
		for (WebElement element : allElements) {
			allElementsInUI[count] = element.getText();
			if (allElementsInUI[count].contains(selectColor)) {
				element.click();
				addComment("Successfully clicked on " + selectColor);
				break;
			}
		}

	}

	/*
	 * // To click on the random product category image. public void
	 * clickOnProductCategory(WebDriver driver) throws Exception { try { Random
	 * random = new Random(); int randomNumber = random.nextInt(2); randomNumber
	 * = randomNumber + 1; List<WebElement> allElements1 =
	 * driver.findElements(By.xpath(GetElementIdentifier.getProperty(
	 * "allBrandXpath", curApp))); for (int i = 0; i < allElements1.size(); i++)
	 * { String brandXpath = GetElementIdentifier.getProperty("brandImageXpath",
	 * curApp); brandXpath = brandXpath.replace("{i}",
	 * String.valueOf(randomNumber));
	 * driver.findElement(By.xpath(brandXpath)).click(); break; } } catch
	 * (Exception e) { throw new POMMethodExecException(
	 * "Unable to select random product category.", e); } }
	 */

	public void clickOnProductSize(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizesXpath", curApp)));

		String allElementsInUI[] = new String[allElements.size()];
		int count = 0;
		for (WebElement element : allElements) {
			allElementsInUI[count] = element.getAttribute("value");
			element.click();
			addComment("Successfully clicked on size :" + allElementsInUI[count]);
			break;
		}
	}

	// To click on my account link
	public void clickOnMyAccountLink(WebDriver driver) throws Exception {
		eo.wait(5000);
		WebElement element = driver.findElement(By.xpath(GetElementIdentifier.getProperty("myAccountLabel", curApp)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		// eo.clickElement(driver, "Xpath", "myAccountLabel");
		addComment("Succesfully clicked on the my accout");
		eo.wait(6000);
	}

	public void clickOnLeftPanelSelectedMenu(WebDriver driver) throws Exception {
		eo.wait(5000);
		String linkToClick = ExcelReader.getValue("LabelName");
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allReturnsLinksXpath", curApp)));
		String allElementsInUI1 = "";
		for (WebElement element : allElements) {
			allElementsInUI1 = element.getText();
			if (allElementsInUI1.contains(linkToClick)) {
				element.click();
				addComment("Successfully clicked on link :" + linkToClick);
				break;
			}
		}
		eo.wait(5000);

	}

	public void clickOnMyAccountOptionLabels(WebDriver driver) throws Exception {
		// To verify mega menu bars
		eo.wait(6000);
		String myAccountOptions = ExcelReader.getValue("MyAccountOptionValue");
		List<WebElement> allMyAccountOptionFooters = driver.findElements(By.xpath(GetElementIdentifier.getProperty("myAccountOptionsXpath", curApp)));
		for (WebElement element : allMyAccountOptionFooters) {
			String allMyAccountDropUI = element.getText();
			if (allMyAccountDropUI.equalsIgnoreCase(myAccountOptions)) {
				element.click();
				eo.wait(5000);
				addComment("Successfully clicked on the " + myAccountOptions + " Option");
				break;
			}

		}
	}

	// To verify top navigation button in page
	public void verifyForTopButton(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		eo.wait(5000);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("adityaBirlaImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		eo.wait(5000);
		// To verify top button
		eo.clickElement(driver, "Xpath", "topButtonXpath");
		addComment("Top button is clicked");
		eo.wait(5000);
//		eo.clickElement(driver, "Xpath", "searchKeywordTextfieldXpath");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyOrderHistoryPage
	 * 
	 * <p>
	 * <b>Description:</b> //To verify My order history page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author
	 * 
	 */
	// To verify 'My oders' or 'Returns'
	public void verifyOrderHistoryPage(WebDriver driver) throws Exception {

		// To verify Order History is displayed.
		boolean orderHistoryStatus = eo.verifyElementIsDisplayed(driver, "XPath", "orderHistoryTextXpath");
		if (orderHistoryStatus) {
			addComment("Order History is displayed.");
		} else {
			addComment("Order History is not displayed.");
			throw new POMMethodExecException("Not able to verify the order history");
		}

		// To verify Recent order Tab is displayed.
		boolean recentOrderTabStatus = eo.verifyElementIsDisplayed(driver, "XPath", "recentOrderTabXpath");
		if (recentOrderTabStatus) {
			addComment("Recent order tab is displayed.");
		} else {
			throw new POMMethodExecException("Not able to verify the Recent order tab ");
		}

		// To verify past order Tab is displayed.
		boolean pastOrderTabStatus = eo.verifyElementIsDisplayed(driver, "XPath", "pastOrderTabXpath");
		if (pastOrderTabStatus) {
			addComment("Past order tab is displayed.");
		} else {
			throw new POMMethodExecException("Not able to verify the Past order tab ");

		}

		// To verify All the links are displayed left side of the UI Return
		// page.
		int noOfLinksCount = 0;
		List<WebElement> allRetunsUiLinks = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allReturnsLinksXpath", curApp)));
		addComment("No of Links are: " + allRetunsUiLinks.size());
		String tempReturnsLinksXpath = GetElementIdentifier.getProperty("returnsLinksXpath", curApp);
		for (int i = 0; i < allRetunsUiLinks.size(); i++) {
			String tempReturnsLinksXpathReplace = tempReturnsLinksXpath.replace("{replaceI}", String.valueOf(i + 1));
			String linksText = driver.findElement(By.xpath(tempReturnsLinksXpathReplace)).getText().trim();
			if (driver.findElement(By.xpath(tempReturnsLinksXpathReplace)).isDisplayed()) {
				addComment("Retun Link is dispalyed : " + linksText);
				noOfLinksCount++;
			}
		}
		if (noOfLinksCount == allRetunsUiLinks.size()) {
			addComment("All the links are displayed.");

		} else {
			throw new POMMethodExecException("Not able to verify the All the links ");
		}

		boolean allReturnsLinkStatus = eo.verifyElementIsDisplayed(driver, "XPath", "allReturnsLinkXpath");
		if (allReturnsLinkStatus) {
			String returnLinkInUI = eo.getText(driver, "XPath", "allReturnsLinkXpath");
			addComment(returnLinkInUI + " is displayed");
		} else {
			throw new POMMethodExecException("Not able to verify the element ");
		}

		eo.clickElement(driver, "XPath", "pastOrderTabXpath");
		addComment("Successfully clicked on past order");

		boolean showOrderLabelStatus = eo.verifyElementIsDisplayed(driver, "XPath", "showOrderPlacedXpath");
		if (showOrderLabelStatus) {
			String showOrderLabelInUI = eo.getText(driver, "XPath", "showOrderPlacedXpath");
			addComment(showOrderLabelInUI + " is displayed");
		} else {
			throw new POMMethodExecException("Not able to verify the element ");
		}

		boolean dateTextBoxStatus = eo.verifyElementIsDisplayed(driver, "XPath", "dateTextBoxXpath");
		if (dateTextBoxStatus) {
			addComment("Date text box is displayed");
		} else {
			throw new POMMethodExecException("Not able to verify the date text box ");
		}

		boolean updateButtonStatus = eo.verifyElementIsDisplayed(driver, "XPath", "updateButtonInOrderHistoryXpath");
		if (updateButtonStatus) {
			addComment("Update button is displayed");
		} else {
			throw new POMMethodExecException("Not able to verify the Update button ");
		}

	}

	public void verifyMyAddressesPage(WebDriver driver) throws Exception {

		String expectedTitle = "My Addresses";
		String expectedText = "Please configure your default shipping address when" + " placing an order. You may also add additional addresses, which can be useful for sending gifts or receiving an order at your office.";
		boolean verifyTitle = false;
		// To verify the title
		for (int i = 0; i <= 5000; i++) {
			verifyTitle = eo.verifyElementIsDisplayed(driver, "XPath", "myAddressTitleXpath");
			if (verifyTitle) {
				String titleInUI = eo.getText(driver, "XPath", "myAddressTitleXpath");
				if (expectedTitle.equalsIgnoreCase(titleInUI)) {
					addComment("Successfully My Addresses page is displayed :" + titleInUI);
					break;
				} else {
					throw new POMMethodExecException("Could not verify the title:" + titleInUI);
				}

			}
		}
		if (!verifyTitle) {
			throw new POMMethodExecException("Could not verify the My Addresses page");
		}

		// To verify text in my addresses page
		boolean verifyText = false;
		for (int i = 0; i <= 5000; i++) {
			verifyText = eo.verifyElementIsDisplayed(driver, "XPath", "textInMyAddressPageXpath");
			if (verifyText) {
				String titleInUI = eo.getText(driver, "XPath", "textInMyAddressPageXpath");
				if (expectedText.equalsIgnoreCase(titleInUI)) {
					addComment("Successfully My Addresses page text is displayed :" + titleInUI);
					break;
				} else {
					throw new POMMethodExecException("Could not verify the text:" + titleInUI);
				}
			}
		}
		if (!verifyText) {
			throw new POMMethodExecException("Could not verify the My Addresses page text");
		}

		// To verify add first address button is displayed or not
		eo.verifyElementIsDisplayed(driver, "XPath", "addFirstAddressButtonXpath");
		addComment("Add first address button is displayed");
	}
}
