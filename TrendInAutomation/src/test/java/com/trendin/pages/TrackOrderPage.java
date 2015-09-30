package com.trendin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trendin.core.ElementOperation;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMException;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class TrackOrderPage extends TrendInTestSuite {
	final String curApp = "TrackOrderPage";
	ElementOperation eo = new ElementOperation(curApp);
	/**
	 * <p>
	 * <b>Method Name:</b> verifyTrackOrderIconDisplayStatus
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verifies the track order icon is displayed.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void verifyTrackOrderIconDisplayStatus(WebDriver driver) throws Exception {
		eo.verifyElementIsDisplayed(driver, "xpath", "trackOrderLinkXpath");
		addComment("Track order icon link is displayed.");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnTrackOrderIcon
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on track order icon.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void clickOnTrackOrderIcon(WebDriver driver) throws Exception {
		eo.clickElement(driver, "xpath", "trackOrderLinkXpath");
		addComment("Clicked on track order Icon link. ");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTrackOrderLinkPopUp
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verifies the track order pop up.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void verifyTrackOrderLinkPopUp(WebDriver driver, String wait) throws Exception {
			int sleep = Integer.parseInt(wait);
			eo.wait(sleep);
			eo.verifyElementIsDisplayed(driver, "xpath", "trackOrderPopUpXpath");
			addComment("Track order pop-up is displayed.");

	}

	/**
	 * <p>
	 * <b>Method Name:</b> enterTrackOrderDetails.
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Enters the track order details.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL -> Track order pop-up.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void enterTrackOrderDetails(WebDriver driver,String email, String orderNumber) throws Exception {
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(winHandleBefore);
		// To enter email-id.
		if(email.length() > 0) {
			eo.enterText(driver, "XPath", "emailIdXpath", email);
			addComment("Entered email_id is: " + email);
		}
		// To enter order-number.
		eo.enterText(driver, "XPath", "orderNumberXpath", orderNumber);
		addComment("Entered Order number is: " + orderNumber);
		// To click on Track order button.
		eo.clickElement(driver, "XPath", "trackOrderButtonXpath");
		addComment("Clicked on Track order Button.");
	}
	/**
	 * <p>
	 * <b>Method Name:</b> verifyTrackOrderDetails.
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verifies the track order details.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL -> Track order pop-up.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void verifyTrackOrderDetails(WebDriver driver) throws Exception {
		// To verify order details.
		try {
			int count = 0;
			String temporderDetailsXpath = GetElementIdentifier.getProperty("orderDetailsXpath", curApp);
			List<WebElement> allOrderDetails = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allOrderDetailsXpath", curApp)));
			System.out.println(allOrderDetails.size());
			for (int i = 0; i < allOrderDetails.size(); i++) {
				String replaceTemporderDetailsXpath = temporderDetailsXpath.replace("'{replaceI}'", String.valueOf(i + 1));
				driver.findElement(By.xpath(replaceTemporderDetailsXpath)).isDisplayed();
				String uiOrderElementName = driver.findElement(By.xpath(replaceTemporderDetailsXpath)).getText();
				addComment("Ui order element is displayed: " + uiOrderElementName);
				count++;
			}
			if (count == allOrderDetails.size()) {
				addComment("All order details Ui elements are displayed.");
			} else {
				throw new POMMethodExecException("All track order UI elements or not displayed.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("All track order UI elements or not displayed.", e);
		}

	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnLoginForMore.
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Clicks on login for more link and verifies the pop-up is displayed.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL -> Track order pop-up.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void clickOnLoginForMore(WebDriver driver, String wait) throws Exception {
		try {
			int val = Integer.parseInt(wait);
			eo.wait(val);
			boolean loginForMoreDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("loginForMoreButtonXpath", curApp))).isDisplayed();
			if (loginForMoreDisplayStatus) {
				addComment("Login for more link is displayed.");
				driver.findElement(By.xpath(GetElementIdentifier.getProperty("loginForMoreButtonXpath", curApp))).click();
				addComment("Clicked on Login for more Button. ");
				eo.wait(val);
				boolean loginRegisterPopUpDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("popUpLoginXpath", curApp))).isDisplayed();
				if (loginRegisterPopUpDisplayStatus) {
					addComment("Page navigated to Login/Register, Login/Register pop-up is displayed.");
					String expectedSignUpText = "Sign Up";
					String actualSignUpText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("signUpTextXpath", curApp))).getText().trim();
					if (actualSignUpText.equalsIgnoreCase(expectedSignUpText)) {
						addComment("Expected sign up text: " + expectedSignUpText + " is same as Actual sign up Text: " + actualSignUpText);
					} else {
						throw new POMMethodExecException("Expected sign up text: " + expectedSignUpText + " is not same as Actual sign up Text: " + actualSignUpText);
					}
				} else {
					throw new POMException("Unable to navigate to Login/Register page ");
				}
			} else {
				throw new POMMethodExecException("Login for more button is not displayed.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Login for more button is not displayed.");
		}

	}
	/**
	 * <p>
	 * <b>Method Name:</b> verifySignUpPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verifies the sign up page.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL -> Track order pop-up -> Click on login for more.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void verifySignUpPage(WebDriver driver, String wait) throws Exception {
		int val = Integer.parseInt(wait);
		eo.wait(val);
		try {
			int count = 0;
			List<WebElement> allUiElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allUiElementsOfSignUpPageXpath", curApp)));
			String tempUiElementsOfSignUpPageXpath = GetElementIdentifier.getProperty("uiElementsOfSignUpPageXpath", curApp);
			for(int i = 0; i < allUiElements.size(); i++ ) {
				String replaceTempUiElementsOfSignUpPageXpath = tempUiElementsOfSignUpPageXpath.replace("'{replaceI}'", String.valueOf(i+ 1));
				boolean uiElementDisplayStatus = driver.findElement(By.xpath(replaceTempUiElementsOfSignUpPageXpath)).isDisplayed();
				if(uiElementDisplayStatus) {
					addComment("Sign Up page Ui element is displayed.");
					count++;
				} else {
					throw new POMMethodExecException("Sign Up page Ui element is not displayed.");
				}
			}
			 if(count == allUiElements.size()) {
				 addComment("Sign Up page all Ui element are displayed.");
			 } else {
				 throw new POMMethodExecException("Sign Up page all Ui element are not displayed.");
			 }
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to verify Sign up page.");
		}
		
		
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> verifyEmailIdTextBoxValue
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verifies email-id.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL -> Track order pop-up -> Click on login for more.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void verifyEmailIdTextBoxValue(WebDriver driver, String emailId) throws Exception {
		//Verifies the email-id.
		String textBoxValue = driver.findElement(By.xpath(GetElementIdentifier.getProperty("emailTextXpath", curApp))).getAttribute("value");
		assertEquals(emailId.equalsIgnoreCase(textBoxValue), "Email-id is verified."+textBoxValue, "Email-id is not verified.");
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMessageForInvalidMailIdOrderNo
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verifies error message for invalid email-id and order number..
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Navigate to URL -> Track order pop-up.
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void verifyErrorMessageForInvalidMailIdOrderNo(WebDriver driver, String wait, String emailStatus, String orderNoStatus, String emailId, String orderNo) throws Exception { 
		try {
			int val = Integer.parseInt(wait);
			if(emailStatus.equalsIgnoreCase("true") && orderNoStatus.equalsIgnoreCase("false")) {
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsg = "Order no and email id is not matching.";
				String actualErrorMsg = eo.getText(driver, "xpath","errorMsgXpath"); 
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified Actual error message is same as Expected Error message "+actualErrorMsg, "Verified Actual error message is not same as Expected Error message ");
			}
			
			if(emailStatus.equalsIgnoreCase("false") && orderNoStatus.equalsIgnoreCase("false")) {
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsg = "Order no and email id is not matching.";
				String actualErrorMsg = eo.getText(driver, "xpath","errorMsgXpath"); 
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified Actual error message is same as Expected Error message "+actualErrorMsg, "Verified Actual error message is not same as Expected Error message ");
			}
			
			if(emailStatus.equalsIgnoreCase("true") && orderNoStatus.equalsIgnoreCase("Character")) {
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsg = "Please enter valid order no.";
				String actualErrorMsg = eo.getText(driver, "xpath","orderErrorMsgXpath"); 
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified Actual error message is same as Expected Error message "+actualErrorMsg, "Verified Actual error message is not same as Expected Error message ");
				/*String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("orderErrorMsgXpath", curApp))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("Verified Actual error message is same as Expected Error message "+actualErrorMsg);
				} else {
					throw new POMMethodExecException("Verified Actual error message is not same as Expected Error message ");
				}*/
			}
			
			if(emailStatus.equalsIgnoreCase("false") && orderNoStatus.equalsIgnoreCase("true")) {
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsg = "Order no and email id is not matching.";
				String actualErrorMsg = eo.getText(driver, "xpath","errorMsgXpath"); 
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified Actual error message is same as Expected Error message "+actualErrorMsg, "Verified Actual error message is not same as Expected Error message ");
				/*String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("errorMsgXpath", curApp))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("Verified Actual error message is same as Expected Error message "+actualErrorMsg);
				} else {
					throw new POMMethodExecException("Verified Actual error message is not same as Expected Error message ");
				}*/
			}
			
			if(emailStatus.equalsIgnoreCase("Character") && orderNoStatus.equalsIgnoreCase("true")) {
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsg = "Please enter valid Email.";
				String actualErrorMsg = eo.getText(driver, "xpath","emailErrorMsgXpath"); 
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified Actual error message is same as Expected Error message "+actualErrorMsg, "Verified Actual error message is not same as Expected Error message ");
				/*String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("emailErrorMsgXpath", "TrackOrderPage"))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("Verified Actual error message is same as Expected Error message "+actualErrorMsg);
				} else {
					throw new POMMethodExecException("Verified Actual error message is not same as Expected Error message ");
				}*/
			}
			
			if(emailStatus.equalsIgnoreCase("empty") && orderNoStatus.equalsIgnoreCase("empty")) {
				
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsgEmail = "Please enter valid Email.";
				String expectedErrorMsgOrderNo = "Please enter valid order no.";
				String actualErrorMsgEmail = driver.findElement(By.xpath(GetElementIdentifier.getProperty("emailErrorMsgXpath", "TrackOrderPage"))).getText().trim();
				String actualErrorMsgOrderNo = driver.findElement(By.xpath(GetElementIdentifier.getProperty("orderErrorMsgXpath", "TrackOrderPage"))).getText().trim();
				if(expectedErrorMsgEmail.equalsIgnoreCase(actualErrorMsgEmail) && expectedErrorMsgOrderNo.equalsIgnoreCase(actualErrorMsgOrderNo)) {
					addComment("Verified Actual error message is same as Expected Error message For email-id "+actualErrorMsgEmail+ " and Order no."+actualErrorMsgOrderNo);
				} else {
					throw new POMMethodExecException("Verified Actual error message is not same as Expected Error message ");
				}
			}
			
			if(emailStatus.equalsIgnoreCase("empty") && orderNoStatus.equalsIgnoreCase("true")) {
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsgEmail = "Please enter valid Email.";
				String actualErrorMsgEmail = eo.getText(driver, "xpath","emailErrorMsgXpath"); 
				assertEquals(expectedErrorMsgEmail.equalsIgnoreCase(actualErrorMsgEmail), "Verified Actual error message is same as Expected Error message "+actualErrorMsgEmail, "Verified Actual error message is not same as Expected Error message ");
				/*String actualErrorMsgEmail = driver.findElement(By.xpath(GetElementIdentifier.getProperty("emailErrorMsgXpath", "TrackOrderPage"))).getText().trim();
				if(expectedErrorMsgEmail.equalsIgnoreCase(actualErrorMsgEmail)) {
					addComment("Verified Actual error message is same as Expected Error message "+actualErrorMsgEmail);
				} else {
					throw new POMMethodExecException("Verified Actual error message is not same as Expected Error message ");
				}*/
			}
			
			if(emailStatus.equalsIgnoreCase("true") && orderNoStatus.equalsIgnoreCase("empty")) {
				enterTrackOrderDetails(driver, emailId, orderNo);
				eo.wait(val);
				String expectedErrorMsg = "Please enter valid order no.";
				String actualErrorMsg = eo.getText(driver, "xpath","orderErrorMsgXpath"); 
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified Actual error message is same as Expected Error message "+actualErrorMsg, "Verified Actual error message is not same as Expected Error message ");
				/*String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("orderErrorMsgXpath", "TrackOrderPage"))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("Verified Actual error message is same as Expected Error message "+actualErrorMsg);
				} else {
					throw new POMMethodExecException("Verified Actual error message is not same as Expected Error message ");
				}*/
			}
			
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to verify Error message for Invalid email-id and track order number.",e);
		}		
	}

}
