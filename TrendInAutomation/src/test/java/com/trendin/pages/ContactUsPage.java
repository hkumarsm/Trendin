package com.trendin.pages;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.EphemeralPortRangeDetector;
import org.testng.Assert;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.Utility;
import com.trendin.core.util.exceptions.POMMethodExecException;

import bsh.util.Util;
import net.sourceforge.htmlunit.corejs.javascript.commonjs.module.provider.StrongCachingModuleScriptProvider;

public class ContactUsPage extends TrendInTestSuite {

	final String curApp = "ContactUsPage";
	ElementOperation eo = new ElementOperation(curApp);

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnFaqsAndVerify
	 * 
	 * <p>
	 * <b>Description:</b> To verify FAQ's is display
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */
	public void clickOnFaqsAndVerify(WebDriver driver, String elementsToVerifyInFAQsPage) throws Exception {
		boolean promotionAndVoucherPage = false, shippingAndDeliveryPage = false, returnsAndRefundsPage = false;
		// To click on FAQs link
		eo.clickElement(driver, "XPath", "faqsLinkXpath");
		addComment("Successfully clicked on FAQs Link");
		Utility.waitUntilExists(driver, "XPath", "faqsHeaderXpath", curApp);
		
		// To verify FAQs header label
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "faqsHeaderXpath");
		assertTrue(pageStatus, "FAQs page header label is displayed", "FAQ's page header label is not displayed");
		
		// Verify the 'Home' bread crumb in FAQs page
		boolean homeBreadCrumb = eo.verifyElementIsDisplayed(driver, "XPath", "homeBreadCrumbLink");
		assertTrue(homeBreadCrumb, "'Home' Breadcrumb link is dislayed in FAQs page.", "'Home' Breadcrumb link is not dislayed in FAQs page.");
		
		// Verify the 'FAQs' bread crumb in FAQs page
		boolean faqBreadCrumb = eo.verifyElementIsDisplayed(driver, "XPath", "faqBreadCrumb");
		assertTrue(faqBreadCrumb, "'FAQs' Breadcrumb link is dislayed in FAQs page.", "'FAQs' Breadcrumb link is not dislayed in FAQs page.");
		
		String allElementsToVerify[] = elementsToVerifyInFAQsPage.split(";");
		int count = 0;

		// To verify tabs are displayed are or not
		String headerElementsXpath = GetElementIdentifier.getProperty("faqHeaderElementsXpath", curApp);
		String tempXpath = "";
		boolean elementStatus = false;
		for (int i = 0; i < allElementsToVerify.length; i++) {
			tempXpath = headerElementsXpath.replace("{replace}", allElementsToVerify[count]);
			elementStatus = driver.findElement(By.xpath(tempXpath)).isDisplayed();
			if (elementStatus) {
				addComment(allElementsToVerify[count] + " is displayed");
				count++;
			} else {
				throw new POMMethodExecException(allElementsToVerify[count] + " is not displayed");
			}
		}

		// To click on promotions And Voucher Tab
		eo.clickElement(driver, "XPath", "promotionsAndVoucherTabXpath");
		addComment("Successfully clicked on 'Promotions And Voucher' Tab");
		// Verify the Functionality of the Promotions & Vouchers Redemption page..
		addComment("--------------------------------------");
		promotionAndVoucherPage = validateThePromotionsAndVouchersPage(driver);
		addComment("--------------------------------------");
		
		// To click on shipping and delivery tab
		eo.clickElement(driver, "XPath", "shippingAndDeliveryTabXpath");
		addComment("Successfully clicked on 'Shipping And Delivery' Tab");
		// Verify the Functionality of the Shipping And Delivery page..
		addComment("--------------------------------------");
		shippingAndDeliveryPage = validateTheShippingAndDeliveryPage(driver);
		addComment("--------------------------------------");
		
		// To click on 'Returns & Refunds' tab
		eo.clickElement(driver, "XPath", "returnsRefundsTabXpath");
		addComment("Successfully clicked on 'Returns & Refunds' Tab");
		// Verify the Functionality of the 'Returns & Refunds' page..
		addComment("--------------------------------------");
		returnsAndRefundsPage = validateTheReturnsAndRefundsPage(driver);
		addComment("--------------------------------------");
		
		
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> validateTheReturnsAndRefundsPage
	 * 
	 * <p>
	 * <b>Description:</b> Validate the Functionality of the 'Returns & Refunds' page..
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch >> Click on Contact Us >> Click on FAQs link >> Click on 'Returns & Refunds'
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */
	public boolean validateTheReturnsAndRefundsPage(WebDriver driver) {
		boolean succssfullyVerified = false;
		
		return succssfullyVerified;
	}

	/**
	 * <p>
	 * <b>Method Name:</b> validateTheShippingAndDeliveryPage
	 * 
	 * <p>
	 * <b>Description:</b> Validate the Functionality of the Shipping And Delivery page..
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch >> Click on Contact Us >> Click on FAQs link >> Click on Shipping & Delivery
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */
	public boolean validateTheShippingAndDeliveryPage(WebDriver driver) {
		boolean succssfullyVerified = false;
		
		return succssfullyVerified;
	}


	/**
	 * <p>
	 * <b>Method Name:</b> validateThePromotionsAndVouchersPage
	 * 
	 * <p>
	 * <b>Description:</b> Validate the Functionality of the Promotions & Vouchers Redemption page..
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch >> Click on Contact Us >> Click on FAQs link >> Click on Promotions & Vouchers Redemption
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */
	public boolean validateThePromotionsAndVouchersPage(WebDriver driver) throws Exception {
		boolean succssfullyVerified = false;
		// To verify the FAQ's
		int noOfQuestionsCount = 0;
		List<WebElement> allQuestionsCount = driver.findElements(By.xpath(GetElementIdentifier.getProperty("promoAndVouchersTabAllFAQsXpath", curApp)));
		addComment("No of questions are: " + allQuestionsCount.size());
		String promoAndVouchersTabFAQsXpath = GetElementIdentifier.getProperty("promoAndVouchersTabFAQsXpath", curApp);
		for (int i = 0; i < allQuestionsCount.size(); i++) {
			String replaceFaqsQuestionsXpath = promoAndVouchersTabFAQsXpath.replace("{i}", String.valueOf(i + 1));
			try {
				String linksText = driver.findElement(By.xpath(replaceFaqsQuestionsXpath)).getText().trim();
				assertTrue(linksText.length() > 1, "Question is : " + linksText, "Question is : " + linksText);
				noOfQuestionsCount++;
			} catch (Exception e) {
				throw new POMMethodExecException("Not able to verify the All the questions", e);
			}
		}
		if (noOfQuestionsCount == allQuestionsCount.size()) {
			addComment("All the questions are displayed.");
		} else {
			throw new POMMethodExecException("Not able to verify the All the questions ");
		}

		// Verify all the Questions are in Collapsed position at the beginning..
		List<WebElement> allCollapsedQuestionsCount = driver.findElements(By.xpath(GetElementIdentifier.getProperty("promoAndVouchersTabFAQsCollapsedXpath", curApp)));
		addComment("No of Collapsed questions are: " + allCollapsedQuestionsCount.size());
		assertTrue(allQuestionsCount.size() == allCollapsedQuestionsCount.size(), "All the Questions are in Collapsed state", "Not all the Questions are in collapsed state");

		// To click on show all link
		eo.clickElement(driver, "XPath", "showAllXpath");
		addComment("Successfully clicked on show All link");

		int noOfanswersCount = 0;
		allQuestionsCount = driver.findElements(By.xpath(GetElementIdentifier.getProperty("promoAndVouchersTabFAQsCollapsedXpath", curApp)));
		addComment("No of answers are: " + allQuestionsCount.size());
		String answersXpath = GetElementIdentifier.getProperty("answersXpath", curApp);
		for (int i = 0; i < allQuestionsCount.size(); i++) {
			String replaceFaqsquestionsXpath = answersXpath.replace("{i}", String.valueOf(i + 1));
			try {
				boolean ele = driver.findElement(By.xpath(replaceFaqsquestionsXpath)).isDisplayed();
				if (ele) {
					noOfanswersCount++;
				}
			} catch (Exception e) {
				throw new POMMethodExecException("Not able to verify the All the answers ");
			}
		}

		if (noOfanswersCount == allQuestionsCount.size()) {
			addComment("All the answers are displayed.");
		} else {
			throw new POMMethodExecException("Not able to verify the All the answers ");
		}

		// To click on hide all link
		eo.clickElement(driver, "XPath", "hideAllXpath");
		addComment("Successfully clicked on hide All");

		// To click on returns and refunds tab
		eo.clickElement(driver, "XPath", "returnsRefundsTabXpath");
		addComment("Successfully clicked on returns & Refunds Tab");

		noOfQuestionsCount = 0;
		allQuestionsCount = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allreturnXpath", curApp)));
		addComment("No of questions are: " + allQuestionsCount.size());
		String faqsquestionsXpath = GetElementIdentifier.getProperty("returnXpath", curApp);
		for (int i = 0; i < allQuestionsCount.size(); i++) {
			try {
				String replaceFaqsquestionsXpath = faqsquestionsXpath.replace("{i}", String.valueOf(i + 1));
				String linksText = driver.findElement(By.xpath(replaceFaqsquestionsXpath)).getText().trim();
				addComment("Question is : " + linksText);
				noOfQuestionsCount++;
			} catch (Exception e) {
				throw new POMMethodExecException("Not able to verify the All the questions ");
			}
		}
		if (noOfQuestionsCount == allQuestionsCount.size()) {
			addComment("All the questions are displayed.");

		} else {
			throw new POMMethodExecException("Not able to verify the All the questions ");
		}
		return succssfullyVerified;
	}


	/**
	 * <p>
	 * <b>Method Name:</b> verifyPinCodeField
	 * 
	 * <p>
	 * <b>Description:</b> To verify Pin code field
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */
	public void verifyPinCodeFieldValidationAndFunctionality(WebDriver driver, String inputPINValueAndMessages) throws Exception {
		String pinValuesAndMessages [] = inputPINValueAndMessages.split(";");
		String pinValues[] = new String[pinValuesAndMessages.length];
		String messages[] = new String[pinValuesAndMessages.length];
		for(int i=0; i<pinValuesAndMessages.length; i++) {
			String temp [] = pinValuesAndMessages[i].split("=");
			pinValues[i] = temp[0];
			messages[i] = temp[1];
		}
		
		// initially check without entering the PIN and click on the CHECK button and verify the error message
		eo.clickElement(driver, "XPath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");
		boolean elementDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "pincodeEmptyErrorXpath");
		if(elementDisplayed){
			String validationMessage = eo.getText(driver, "XPath", "pincodeEmptyErrorXpath");
			addComment("PIN validation messaged displayed in UI: "+ validationMessage);
			assertEquals(validationMessage.trim(), "Pincode is required", "'Pincode is required' message verified without any PIN input", "'Pincode is required' message not verified without any PIN input");
			//if invalid PIN number is entered, then verify the Wrong tick mark in the PIN text box..
			String attrib = driver.findElement(By.xpath(GetElementIdentifier.getProperty("tickMarkForPinCodeValidationXpath", curApp))).getAttribute("class");
			assertContains(attrib, "close", "Wrong tick mark is displayed when entered 6 digit PIN number", "Wrong tick mark is not displayed when entered 6 digit PIN number");
		}
		
		String validationMessage = "";
		for(int pin=0; pin<pinValues.length; pin++){
			driver.navigate().refresh();
			// To enter the Text in the PIN values
			eo.enterText(driver, "XPath", "pincodeTextXpath", pinValues[pin]);
			addComment("Successfully entered pincode :" + pinValues[pin]);
			
			// To click on check button
			eo.clickElement(driver, "XPath", "checkButtonXpath");
			addComment("Successfully clicked on check Button");
			elementDisplayed = false;
			eo.wait(2000);
			try {
				elementDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "successCheckXpath");
				if(elementDisplayed){
					validationMessage = eo.getText(driver, "XPath", "successCheckXpath");
					validationMessage = validationMessage.replaceAll("[\n\r]", "");
					//if the valid 6 digit PIN number is entered, then verify the Correct tick mark in the PIN text box..
					String attrib = driver.findElement(By.xpath(GetElementIdentifier.getProperty("tickMarkForPinCodeValidationXpath", curApp))).getAttribute("class");
					assertContains(attrib, "check", "Correct tick mark is displayed when entered 6 digit PIN number", "Correct tick mark is not displayed when entered 6 digit PIN number");
				}
				if(!elementDisplayed){
					elementDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "pincodeEmptyErrorXpath");
					if(elementDisplayed){
						validationMessage = eo.getText(driver, "XPath", "pincodeEmptyErrorXpath");
						//if invalid PIN number is entered, then verify the Wrong tick mark in the PIN text box..
						String attrib = driver.findElement(By.xpath(GetElementIdentifier.getProperty("tickMarkForPinCodeValidationXpath", curApp))).getAttribute("class");
						assertContains(attrib, "close", "Wrong tick mark is displayed when entered 6 digit PIN number", "Wrong tick mark is not displayed when entered 6 digit PIN number");
					}
				}
				if(!elementDisplayed){
					elementDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "integerPincodeErrorXpath");
					if(elementDisplayed){
						validationMessage = eo.getText(driver, "XPath", "integerPincodeErrorXpath");
						//if invalid PIN number is entered, then verify the Wrong tick mark in the PIN text box..
						String attrib = driver.findElement(By.xpath(GetElementIdentifier.getProperty("tickMarkForPinCodeValidationXpath", curApp))).getAttribute("class");
						assertContains(attrib, "close", "Wrong tick mark is displayed when entered 6 digit PIN number", "Wrong tick mark is not displayed when entered 6 digit PIN number");
					}
				}
				if(!elementDisplayed){
					elementDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "pinCodeLengthErrorXpath");
					if(elementDisplayed){
						validationMessage = eo.getText(driver, "XPath", "pinCodeLengthErrorXpath");
						//if invalid PIN number is entered, then verify the Wrong tick mark in the PIN text box..
						String attrib = driver.findElement(By.xpath(GetElementIdentifier.getProperty("tickMarkForPinCodeValidationXpath", curApp))).getAttribute("class");
						assertContains(attrib, "close", "Wrong tick mark is displayed when entered 6 digit PIN number", "Wrong tick mark is not displayed when entered 6 digit PIN number");
					}
				}
			} catch(Exception e){
				throw new POMMethodExecException("Not able to get the PIN message status", e);
			}
			addComment("PIN validation messaged displayed in UI: "+ validationMessage);
			assertEquals(validationMessage.trim(), messages[pin].trim(), "PIN message verified for the input: "+ pinValues[pin], "PIN message not valid for the input: "+ pinValues[pin]);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyInvalidPinCodeField
	 * 
	 * <p>
	 * <b>Description:</b> To verify Pin code field for invalid value
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void verifyInvalidPinCodeField(WebDriver driver) throws Exception {

		String pinValue = ExcelReader.getValue("PinValue");
		String expectedErrorMessage = "length should be 6";

		// To enter pine code
		eo.enterText(driver, "XPath", "pincodeTextXpath", pinValue);
		addComment("Successfully entered pincode :" + pinValue);

		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tickMarkForPinCodeValidationXpath");
			if (pageStatus) {
				addComment("Cross mark is displayed");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Cross mark is not displayed for invalid pin code");
		}

		// To click on check button
		eo.clickElement(driver, "XPath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");

		// To verify the error message
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "pinCodeLengthErrorXpath");
			if (pageStatus) {
				String actualErrorMessage = eo.getText(driver, "XPath", "pinCodeLengthErrorXpath");
				if (actualErrorMessage.equalsIgnoreCase(expectedErrorMessage)) {
					addComment("Error Message is displayed for length of text: " + actualErrorMessage);
					break;
				} else {
					throw new POMMethodExecException("Error message is not as expected " + actualErrorMessage);
				}
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Error message for length is not displayed");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyBlankPinCodeField
	 * 
	 * <p>
	 * <b>Description:</b> To verify Pin code field for blank
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void verifyBlankPinCodeField(WebDriver driver) throws Exception {

		String pinValue1 = ExcelReader.getValue("PinValue1");
		String pinValue2 = ExcelReader.getValue("PinValue2");
		String expectedEmptyErrorMessage = "Pincode is required";
		String expectedIntegerErrorMessage = "Value is not an integer";

		// To enter pine code
		eo.enterText(driver, "XPath", "pincodeTextXpath", pinValue1);
		addComment("Successfully entered pincode :" + pinValue1);

		// To click on check button
		eo.clickElement(driver, "XPath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");

		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tickMarkForPinCodeValidationXpath");
			if (pageStatus) {
				addComment("Cross mark is dispalyed for validation of pin code");
				break;
			}
		}

		if (!pageStatus) {
			throw new POMMethodExecException("Cross mark is not dispalyed for validation of pin code");
		}

		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "pincodeEmptyErrorXpath");
			if (pageStatus) {
				String errorMessageInUI = eo.getText(driver, "XPath", "pincodeEmptyErrorXpath");
				if (errorMessageInUI.equalsIgnoreCase(expectedEmptyErrorMessage)) {
					addComment("Error Message is displayed empty pin code field: " + errorMessageInUI);
					break;
				} else {
					throw new POMMethodExecException("Error message is not displayed as expected "+errorMessageInUI);
				}
			}
		}

		if (!pageStatus) {
			throw new POMMethodExecException("Error message for empty pincode field is not displayed");
		}

		// To enter pin code
		eo.enterText(driver, "XPath", "pincodeTextXpath", pinValue2);
		addComment("Successfully entered pincode :" + pinValue2);

		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tickMarkForPinCodeValidationXpath");
			if (pageStatus) {
				addComment("Cross mark is dispalyed for validation of pin code");
				break;
			}
		}

		if (!pageStatus) {
			throw new POMMethodExecException("Cross mark is not dispalyed for validation of pin code");
		}

		// To click on check button
		eo.clickElement(driver, "XPath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");

		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "integerPincodeErrorXpath");
			if (pageStatus) {
				String errorMessageInUI = eo.getText(driver, "XPath", "integerPincodeErrorXpath");
				if (errorMessageInUI.equalsIgnoreCase(expectedIntegerErrorMessage)) {
					addComment("Error Message is displayed special character in pin code field: " + errorMessageInUI);
					break;
				} else {
					throw new POMMethodExecException("Error message is not displayed as expected "+errorMessageInUI);
				}

			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Error message for integer pincode field is not displayed");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForSendingMail
	 * 
	 * <p>
	 * <b>Description:</b> To verify for sending mail
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void verifyContactUsFunctionalityViaEMail(WebDriver driver, String userName, String password) throws Exception {
		String link = driver.findElement(By.xpath(GetElementIdentifier.getProperty("emailLinkXpath", curApp))).getAttribute("href");
		String link1[] = link.split(":");
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage generateMailMessage;

		addComment("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		addComment("Mail Server Properties have been setup successfully..");
		try {
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(link1[1]));
			generateMailMessage.setSubject("Qualitest Automation Testing - Mail");
			String emailBody = "Test email by Qualitest for Trendin.com. " + "<br><br> Regards, <br>Qualitest Trendin Team";
			generateMailMessage.setContent(emailBody, "text/html");
			addComment("Mail Session has been created successfully..");
			// Step3
			addComment("\n\n 3rd ===> Get Session and Send mail");
			Transport transport = getMailSession.getTransport("smtp");
			// Enter your correct gmail UserID and Password
			transport.connect("smtp.gmail.com", userName, password);
			Address[] receipents = generateMailMessage.getAllRecipients();
			transport.sendMessage(generateMailMessage, receipents);
			addComment("Mail has been sent successfully");
			transport.close();
		} catch(Exception e){
			throw new POMMethodExecException("Not able to send mail to the TrendIN Contact Us section.", e);
		}
		
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyCallUsDetails
	 * 
	 * <p>
	 * <b>Description:</b> To verify for Call Us section details
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void verifyCallUsDetails(WebDriver driver, String callUsDetails, String staticDetails ) throws Exception {
		// To verify call us details
		String callUsDetailsInUI = eo.getText(driver, "XPath", "callUsTextXpath");
		addComment("Call Us details displayed in UI: "+ callUsDetailsInUI);
		if (callUsDetailsInUI.equalsIgnoreCase(callUsDetails)) {
			addComment("Call us details are displayed " + callUsDetailsInUI);
		} else {
			throw new POMMethodExecException("Call us details are not displayed :"+ callUsDetails);
		}

		// To verify static text
		String staticTextDetailsInUI = eo.getText(driver, "XPath", "staticTextXpath");
		addComment("Static text (24 x 7 service) text in UI: "+ callUsDetailsInUI);
		if (staticTextDetailsInUI.equalsIgnoreCase(staticDetails)) {
			addComment("Static text (24 x 7 service) is displayed " + staticTextDetailsInUI);
		} else {
			throw new POMMethodExecException("Static details are not displayed (24 x 7 service)");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTCOffers
	 * 
	 * <p>
	 * <b>Description:</b> To verify for terms and conditions link
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void verifyTCOffers(WebDriver driver) throws Exception { 
		
		// To click on tcOffers
		eo.clickElement(driver, "XPath", "tcOffersXpath");
		addComment("Successfully clicked on t & c offers");
		Utility.waitUntilExists(driver, "XPath", "tcHeaderXpath", curApp);
		
		//To verify T&C header
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tcHeaderXpath");
		assertTrue(pageStatus, "T & C page is displayed", "T & C page is not displayed");
		
		// Verify the 'Home' bread crumb in 'T&C' page
		boolean homeBreadCrumb = eo.verifyElementIsDisplayed(driver, "XPath", "homeBreadCrumbLink");
		assertTrue(homeBreadCrumb, "'Home' Breadcrumb link is dislayed in 'T&C' page.", "'Home' Breadcrumb link is not dislayed in T&C' page.");
		
		// Verify the 'FAQs' bread crumb in 'T&C' page
		boolean faqBreadCrumb = eo.verifyElementIsDisplayed(driver, "XPath", "tAndCBreadCrumbXpath");
		assertTrue(faqBreadCrumb, "'T&C' Breadcrumb link is dislayed in T&C' page.", "T&C'' Breadcrumb link is not dislayed in T&C' page.");
				
		
		// To verify the offers available
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("offersListXpath", curApp)));
		addComment("Number of offers present :" + allElements.size());
		if (allElements.size() <= 0) {
			throw new POMMethodExecException("No Offers are available to display");
		}
		
		String allElementsInUI = "";
		for (WebElement element : allElements) {
			allElementsInUI = element.getText();
			addComment("Offer available is :" + allElementsInUI);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyAlterationImage
	 * 
	 * <p>
	 * <b>Description:</b> To verify for tailor shop message
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void gotoAlerrationPageFromContactUsPage(WebDriver driver) throws Exception {

		// To click on tcOffersge
		boolean pageElement = eo.verifyElementIsDisplayed(driver, "XPath", "tailorShopImageXpath");
		if (pageElement) {
			addComment("Tailor Shop Image is displayed");
			eo.clickElement(driver, "XPath", "tailorShopImageXpath");
			addComment("Successfully clicked on Tailor Shop Image");
		} else {
			throw new POMMethodExecException("Tailor Shop Image is not displayed");
		}
		
		Utility.waitUntilExists(driver, "XPath", "altrationHeaderXpath", curApp);
		// Verify for Alteration header displayed
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "altrationHeaderXpath");
		assertTrue(pageStatus, "Alteration page is displayed", "Alteration page is not displayed");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyPresenceOfTOPButtonAndClick
	 * 
	 * <p>
	 * <b>Description:</b> To verify the presence of the TOP icon is present and click it
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */
	public void verifyPresenceOfTOPButtonAndClick(WebDriver driver, boolean clickTopIcon) throws Exception {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("commonImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		Utility.waitUntilExists(driver, "XPath", "topButtonXpath", curApp);
		// To click on top button
		boolean pageElement = eo.verifyElementIsDisplayed(driver, "XPath", "topButtonXpath");
		if (pageElement) {
			addComment("Top button is displayed in the page: "+ driver.getTitle());
			// Click the TOP icon if 'clickTopIcon' parameter is TRUE
			if(clickTopIcon) {
				eo.clickElement(driver, "XPath", "topButtonXpath");
				addComment("Successfully clicked on top Button");
				Utility.waitUntilExists(driver, "XPath", "tinyContactUsXpath", curApp);
				boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tinyContactUsXpath");
				assertTrue(pageStatus, "Tiny Contact us icon is displayed as clicking the TOP button", "Tiny Contact us icon is not displayed as clicking the TOP button");
			}
		} else {
			throw new POMMethodExecException("Top button is not displayed");
		}
		
	}
	
	
	/**
	 * <p>
	 * <b>Method Name:</b> verifyContactUsPage
	 * </p>
	 * <p>
	 * <b>Description:</b> This method is used to Validate the 'Contact Us' Page.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Launch >> clickContactUsIcon 
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>webdriver:</b> WebDriver object</li>
	 * </ul>
	 * </p>
	 * @author Kavya
	 */
	public void verifyContactUsPage(WebDriver driver, String tabsToVerify) throws Exception {
		// Verify the 'Home' bread crumb
		boolean homeBreadCrumb = eo.verifyElementIsDisplayed(driver, "XPath", "homeBreadCrumbLink");
		assertTrue(homeBreadCrumb, "'Home' Breadcrumb link is dislayed.", "'Home' Breadcrumb link is not dislayed.");
		
		// Verify the 'Customer Support' bread crumb
		boolean custSupportBreadCrumb = eo.verifyElementIsDisplayed(driver, "XPath", "custSupportBreadCrumb");
		assertTrue(custSupportBreadCrumb, "'Customer Support' Breadcrumb link is dislayed.", "'Customer Support' Breadcrumb link is not dislayed.");
		
		String[] splitContactsLinks = tabsToVerify.split(";");
		// To check all the links are displayed.
		List <WebElement> allTheLinks = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allContactUsLinksXpath", curApp)));
		addComment("Number of 'Contact Us' ways present in UI: "+ allTheLinks.size());
		int count = 0;
		String tempAllRelativeContactUsLinksXpath = GetElementIdentifier.getProperty("allRelativeContactUsLinksXpath", curApp);
		String tempText = "";
		boolean linksStatus = false;
		for (int i = 0; i < allTheLinks.size(); i++) {
			tempText = tempAllRelativeContactUsLinksXpath.replace("{replaceText}", splitContactsLinks[i]);
			try {
				linksStatus = driver.findElement(By.xpath(tempText)).isDisplayed();
			} catch(Exception e){
				throw new POMMethodExecException("Not able to get the Contact element: "+ splitContactsLinks[i], e);
			}
			if (linksStatus) {
				addComment("contact links is displayed : " + splitContactsLinks[i]);
				count++;
			} else {
				throw new POMMethodExecException("Tab: "+ splitContactsLinks[i]+ " , in 'Contact Us' page is not displayed.");
			}
		}
		if (count == allTheLinks.size()) {
			addComment("All the Expected contact's Links are displayed.");
		} else {
			throw new POMMethodExecException("Expected contact's Links are not displayed.");
		}
	}
}
