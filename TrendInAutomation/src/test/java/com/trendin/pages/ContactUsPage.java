package com.trendin.pages;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class ContactUsPage extends TrendInTestSuite {

	final String curApp = "ContactUsPage";
	ElementOperation eo = new ElementOperation(curApp);

	/**
	 * <p>
	 * <b>Method Name:</b> clickContactUsIcon
	 * 
	 * <p>
	 * <b>Description:</b> To login to TrendIn contact us icon
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	// To login to TrendIn contact us icon
	public void clickContactUsIcon(WebDriver driver) throws Exception {

		String elementsToVerify = ExcelReader.getValue("ElementsToVerify");
		String allElementsToVerify[] = elementsToVerify.split(";");
		int count = 0;
		// To click on contact us icon
		eo.clickElement(driver, "Xpath", "contactUsIconXpath");
		addComment("Successfully clicked on contact us icon");

		// To verify contact us page is display
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "contactUsHeaderXpath");
			if (pageStatus) {
				addComment("Contact us page is displayed");
				break;
			}
		}

		if (!pageStatus) {
			throw new POMMethodExecException("Contact us page is not displayed");
		}

		// To verify tabs are displayed are or not
		for (int i = 0; i < allElementsToVerify.length; i++) {
			String headerElementsXpath = GetElementIdentifier.getProperty("headerElementsXpath", curApp);
			headerElementsXpath = headerElementsXpath.replace("{replace}", allElementsToVerify[count]);
			pageStatus = driver.findElement(By.xpath(headerElementsXpath)).isDisplayed();
			if (pageStatus) {
				addComment(allElementsToVerify[count] + " is displayed");
				count++;
			} else {
				throw new POMMethodExecException(allElementsToVerify[count] + " is not displayed");
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickContactUsFooter
	 * 
	 * <p>
	 * <b>Description:</b> To login to TrendIn contact us in footer
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */
	public void clickContactUsFooter(WebDriver driver) throws Exception {

		String elementsToVerify = ExcelReader.getValue("ElementsToVerify");
		String allElementsToVerify[] = elementsToVerify.split(";");
		int count = 0;
		// To click on contact us icon
		eo.clickElement(driver, "Xpath", "footerContactUsXpath");
		addComment("Successfully clicked on contact us in footer");

		boolean pageStatus = false;
		// To verify contact us page is display
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "contactUsHeaderXpath");
			if (pageStatus) {
				addComment("Contact us page is displayed");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Contact us page is not displayed");
		}

		// To verify tabs are displayed are or not
		for (int i = 0; i < allElementsToVerify.length; i++) {
			String headerElementsXpath = GetElementIdentifier.getProperty("headerElementsXpath", curApp);
			headerElementsXpath = headerElementsXpath.replace("{replace}", allElementsToVerify[count]);
			pageStatus = driver.findElement(By.xpath(headerElementsXpath)).isDisplayed();
			if (pageStatus) {
				addComment(allElementsToVerify[count] + " is displayed");
				count++;
			} else {
				throw new POMMethodExecException(allElementsToVerify[count] + " is not displayed");
			}
		}
	}

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

	// To verify FAQ's is display
	public void clickOnFaqsAndVerify(WebDriver driver) throws Exception {

		String elementsToVerifyInFaqPage = ExcelReader.getValue("ElementsToVerifyInFaqPage");
		String allElementsToVerify[] = elementsToVerifyInFaqPage.split(";");
		int count = 0;
		// To click on FAQs link
		eo.clickElement(driver, "Xpath", "faqsLinkXpath");
		addComment("Successfully clicked on FAQs Link");

		// To verify contact us page is display
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "faqsHeaderXpath");
			if (pageStatus) {
				addComment("FAQs page is displayed");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("FAQ's page is not displayed");
		}

		// To verify tabs are displayed are or not
		for (int i = 0; i < allElementsToVerify.length; i++) {
			String headerElementsXpath = GetElementIdentifier.getProperty("faqHeaderElementsXpath", curApp);
			headerElementsXpath = headerElementsXpath.replace("{replace}", allElementsToVerify[count]);
			pageStatus = driver.findElement(By.xpath(headerElementsXpath)).isDisplayed();
			if (pageStatus) {
				addComment(allElementsToVerify[count] + " is displayed");
				count++;
			} else {
				throw new POMMethodExecException(allElementsToVerify[count] + " is not displayed");
			}
		}

		// To click on promotions And Voucher Tab
		eo.clickElement(driver, "Xpath", "promotionsAndVoucherTabXpath");
		addComment("Successfully clicked on promotions And Voucher Tab");

		// To verify the FAQ's
		try {
			int noOfQuestionsCount = 0;
			List<WebElement> allQuestionsCount = driver.findElements(By.xpath(GetElementIdentifier.getProperty("faqspromotionsAndVoucherTabXpath", curApp)));
			addComment("No of questions are: " + allQuestionsCount.size());
			String faqsquestionsXpath = GetElementIdentifier.getProperty("faqsquestionsXpath", curApp);
			for (int i = 0; i < allQuestionsCount.size(); i++) {
				String replaceFaqsquestionsXpath = faqsquestionsXpath.replace("{i}", String.valueOf(i + 1));
				String linksText = driver.findElement(By.xpath(replaceFaqsquestionsXpath)).getText().trim();
				addComment("Question is : " + linksText);
				noOfQuestionsCount++;
			}

			if (noOfQuestionsCount == allQuestionsCount.size()) {
				addComment("All the questions are displayed.");
			} else {
				throw new POMMethodExecException("Not able to verify the All the questions ");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the All the questions ");
		}

		// To click on show all link
		eo.clickElement(driver, "Xpath", "showAllXpath");
		addComment("Successfully clicked on show All");

		try {
			int noOfanswersCount = 0;
			List<WebElement> allQuestionsCount = driver.findElements(By.xpath(GetElementIdentifier.getProperty("faqspromotionsAndVoucherTabXpath", curApp)));
			addComment("No of answers are: " + allQuestionsCount.size());
			String answersXpath = GetElementIdentifier.getProperty("answersXpath", curApp);
			for (int i = 0; i < allQuestionsCount.size(); i++) {
				String replaceFaqsquestionsXpath = answersXpath.replace("{i}", String.valueOf(i + 1));
				boolean ele = driver.findElement(By.xpath(replaceFaqsquestionsXpath)).isDisplayed();
				if (ele) {
					noOfanswersCount++;
				}
			}

			if (noOfanswersCount == allQuestionsCount.size()) {
				addComment("All the answers are displayed.");

			} else {
				throw new POMMethodExecException("Not able to verify the All the answers ");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the All the answers ");
		}

		// To click on hide all link
		eo.clickElement(driver, "Xpath", "hideAllXpath");
		addComment("Successfully clicked on hide All");

		// To click on returns and refunds tab
		eo.clickElement(driver, "Xpath", "returnsRefundsTabXpath");
		addComment("Successfully clicked on returns & Refunds Tab");

		try {
			int noOfQuestionsCount = 0;
			List<WebElement> allQuestionsCount = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allreturnXpath", curApp)));
			addComment("No of questions are: " + allQuestionsCount.size());
			String faqsquestionsXpath = GetElementIdentifier.getProperty("returnXpath", curApp);
			for (int i = 0; i < allQuestionsCount.size(); i++) {
				String replaceFaqsquestionsXpath = faqsquestionsXpath.replace("{i}", String.valueOf(i + 1));
				String linksText = driver.findElement(By.xpath(replaceFaqsquestionsXpath)).getText().trim();
				addComment("Question is : " + linksText);
				noOfQuestionsCount++;
			}
			if (noOfQuestionsCount == allQuestionsCount.size()) {
				addComment("All the questions are displayed.");

			} else {
				throw new POMMethodExecException("Not able to verify the All the questions ");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the All the questions ");
		}

		// To click on shipping and delivery tab
		eo.clickElement(driver, "Xpath", "shippingAndDeliveryTabXpath");
		addComment("Successfully clicked on shipping And Delivery Tab");

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

	public void verifyPinCodeField(WebDriver driver) throws Exception {

		String pinValue1 = ExcelReader.getValue("PinValue1");
		String pinValue2 = ExcelReader.getValue("PinValue2");
		String pinValue3 = ExcelReader.getValue("PinValue3");
		String validMessage1 = ExcelReader.getValue("ValidMessage1");
		String validMessage2 = ExcelReader.getValue("ValidMessage2");
		String invalidMessage = ExcelReader.getValue("InvalidMessage");

		// To enter pine code
		eo.enterText(driver, "Xpath", "pincodeTextXpath", pinValue1);
		addComment("Successfully entered pincode :" + pinValue1);

		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tickMarkForPinCodeValidationXpath");
			if (pageStatus) {
				addComment("Tick mark for correct pin code is displayed");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Tick mark for correct pin code is not displayed");
		}

		// To click on check button
		eo.clickElement(driver, "Xpath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");

		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "successCheckXpath");
			if (pageStatus) {
				String successMessageInUI = eo.getText(driver, "XPath", "successCheckXpath");
				validMessage1 = validMessage2 + pinValue1 + validMessage1;
				if (successMessageInUI.equalsIgnoreCase(validMessage1)) {
					addComment("Message is displayed : " + successMessageInUI);
					break;
				} else {
					throw new POMMethodExecException("Message is not as expected "+successMessageInUI);
				}
			}
		}

		if (!pageStatus) {
			throw new POMMethodExecException(validMessage1 + "Message is not displayed");
		}

		eo.wait(4000);
		// To enter pin code
		eo.enterText(driver, "Xpath", "pincodeTextXpath", pinValue2);
		addComment("Successfully entered pincode :" + pinValue2);

		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tickMarkForPinCodeValidationXpath");
			if (pageStatus) {
				addComment("Tick mark is displayed");
				break;
			}
		}

		if (!pageStatus) {
			throw new POMMethodExecException("Cross mark for correct pin code is not displayed");
		}

		// To click on check button
		eo.clickElement(driver, "Xpath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "successCheckXpath");
			if (pageStatus) {
				String successMessageInUI = eo.getText(driver, "Xpath", "successCheckXpath");
				invalidMessage = invalidMessage + pinValue2;
				if (successMessageInUI.equalsIgnoreCase(invalidMessage)) {
					addComment("Message is displayed : " + successMessageInUI);
					break;
				} else {
					throw new POMMethodExecException("Message is not as expected "+successMessageInUI);
				} 
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException(invalidMessage + "Message is not displayed ");
		}

		// To enter pin code
		eo.enterText(driver, "Xpath", "pincodeTextXpath", pinValue3);
		addComment("Successfully entered pincode :" + pinValue3);

		eo.wait(2000);

		String pincode = eo.getText(driver, "Xpath", "pincodeTextXpath");
		addComment("Pincode entered is :" + pincode);

		if (pincode.equals(pinValue3)) {
			throw new POMMethodExecException("Pin code is accepting more than 6 digits");
		} else {
			addComment("Pincode is not accepting more than 6 digits");
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
		eo.enterText(driver, "Xpath", "pincodeTextXpath", pinValue);
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
		eo.clickElement(driver, "Xpath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");

		// To verify the error message
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "pinCodeLengthErrorXpath");
			if (pageStatus) {
				String actualErrorMessage = eo.getText(driver, "xpath", "pinCodeLengthErrorXpath");
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
		eo.enterText(driver, "Xpath", "pincodeTextXpath", pinValue1);
		addComment("Successfully entered pincode :" + pinValue1);

		// To click on check button
		eo.clickElement(driver, "Xpath", "checkButtonXpath");
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
				String errorMessageInUI = eo.getText(driver, "xpath", "pincodeEmptyErrorXpath");
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
		eo.enterText(driver, "Xpath", "pincodeTextXpath", pinValue2);
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
		eo.clickElement(driver, "Xpath", "checkButtonXpath");
		addComment("Successfully clicked on check Button");

		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "integerPincodeErrorXpath");
			if (pageStatus) {
				String errorMessageInUI = eo.getText(driver, "xpath", "integerPincodeErrorXpath");
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

	public void verifyMailFunctionalityOfTrnedin(WebDriver driver) throws Exception {

		
		String userName = ExcelReader.getValue("UserName");
		String password = ExcelReader.getValue("Password");
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
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyCallUsDetails
	 * 
	 * <p>
	 * <b>Description:</b> To verify for call us details
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void verifyCallUsDetails(WebDriver driver) throws Exception {

		String callUsDetails = ExcelReader.getValue("CallUsDetails");
		String staticDetails = ExcelReader.getValue("StaticDetails");

		// To verify call us details
		String callUsDetailsInUI = eo.getText(driver, "xpath", "callUsTextXpath");
		if (callUsDetailsInUI.equalsIgnoreCase(callUsDetails)) {
			addComment("Call us details are displayed " + callUsDetailsInUI);
		} else {
			throw new POMMethodExecException("Call us details are not displayed :");
		}

		// To verify static text
		String staticTextDetailsInUI = eo.getText(driver, "xpath", "staticTextXpath");
		if (staticTextDetailsInUI.equalsIgnoreCase(staticDetails)) {
			addComment("static text is displayed " + staticTextDetailsInUI);
		} else {
			throw new POMMethodExecException("Static details are not displayed");
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
		eo.clickElement(driver, "Xpath", "tcOffersXpath");
		addComment("Successfully clicked on t & c offers");
		
		//To verify T&C header
		boolean pageStatus = false ;
		for (int i = 0; i <= 5000; i++) {
			 pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "tcHeaderXpath");
			if (pageStatus) {
				addComment("T & C page is displayed ");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("T & C page is not displayed");
		}

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

	public void verifyAlterationImage(WebDriver driver) throws Exception {

		// To click on tcOffersge
		boolean pageElement = eo.verifyElementIsDisplayed(driver, "XPath", "tailorShopImageXpath");
		if (pageElement) {
			addComment("Tailor Shop Image is displayed");
			eo.clickElement(driver, "Xpath", "tailorShopImageXpath");
			addComment("Successfully clicked on Tailor Shop Image");
		} else {
			throw new POMMethodExecException("Tailor Shop Image is not displayed");
		}

		// Verify for alteration page id displayed
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			 pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "altrationHeaderXpath");
			if (pageStatus) {
				addComment("Alteration page is displayed ");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Alteration page is not displayed");
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForTop
	 * 
	 * <p>
	 * <b>Description:</b> To verify for top button
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author :Kavya
	 * 
	 */

	public void verifyForTopButton(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("commonImageXpath", curApp)));
		action.moveToElement(ele).build().perform();

		// To click on top button
		boolean pageElement = eo.verifyElementIsDisplayed(driver, "Xpath", "topButtonXpath");
		if (pageElement) {
			addComment("Top button is displayed");
			eo.clickElement(driver, "Xpath", "topButtonXpath");
			addComment("Successfully clicked on top Button");
		} else {
			throw new POMMethodExecException("Top button is not displayed");
		}

		// To verify contact us page is display
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "contactUsHeaderXpath");
			if (pageStatus) {
				addComment("Contact us page is displayed");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Alteration page is not displayed");
		}
	}
}
