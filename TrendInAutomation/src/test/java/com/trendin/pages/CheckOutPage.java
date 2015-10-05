package com.trendin.pages;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Dimension;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver; 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.Utility;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class CheckOutPage extends TrendInTestSuite {
	final String curApp = "CheckOutPage";
	ElementOperation eo = new ElementOperation(curApp);	

	/*//To Click on any available product image
	 *//**
	 * <p>
	 * <b>Method Name:</b> clickOnProductImage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on any available product image
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 **//*
	public void clickOnProductImage(WebDriver driver) throws Exception {

		Random random = new Random();
		int randomNumber = random.nextInt(1);
		randomNumber = randomNumber + 1;
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allBrandXpath", curApp)));
		for (int i = 0; i < allElements.size();) {
			String brandXpath = GetElementIdentifier.getProperty("brandXpath", curApp);
			brandXpath = brandXpath.replace("{i}", String.valueOf(randomNumber));
			driver.findElement(By.xpath(brandXpath)).click();
			Actions action = new Actions(driver);
			eo.wait(5000);
			String productImageXpath = GetElementIdentifier.getProperty("productImageXpath", curApp);
			productImageXpath = productImageXpath.replace("{i}", String.valueOf(randomNumber));
			System.out.println("The xpath: " + productImageXpath);
			WebElement mouseElement = driver.findElement(By.xpath(productImageXpath));
			action.moveToElement(mouseElement).build().perform();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", mouseElement);
			break;
		}
		eo.wait(5000);
		eo.verifyElementIsDisplayed(driver, "XPath", "productDescriptionXpath");
		addComment("Product Description page is displayed");
	}
	  */
	//To Click on Cart Icon
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCartIcon
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on Cart icon
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnCartIcon(WebDriver driver) throws Exception {
		driver.switchTo().defaultContent();

		// Waits until the Locate Store button is displayed..
		Utility.waitUntilExists(driver, "XPath", "cartIconXpath", curApp);
		//To Click on Cart Icon
		eo.clickElement(driver, "XPath", "cartIconXpath");
		addComment("Successfully clicked on Cart Icon");
	}

	//To enter invalid Zip/Postal Code
	/**
	 * <p>
	 * <b>Method Name:</b> enterZipCodeAndClickOnCheckBtn
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter Invalid Zip/Postal code and click on Check button
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void enterZipCodeAndClickOnCheckBtn(WebDriver driver) throws Exception {

		String zip = ExcelReader.getValue("ZipCode");

		eo.enterText(driver, "XPath", "zipTextBoxXpath", zip);
		addComment("Successfully entered the zip/Postal Code");

		// Waits until the Check button is loaded
		Utility.waitUntilExists(driver, "XPath", "checkBtnXpath", curApp);
		//To click on Check button
		eo.clickElement(driver, "XPath", "checkBtnXpath");
		addComment("Successfully clicked on Check Button");
	}	

	//To verify error message when invalid Zip/Postal Code  entered
	/**
	 * <p>
	 * <b>Method Name:</b> verifyZipCodeErrMsg
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify error message when invalid Zip/Postal code is entered 
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyZipCodeErrMsg(WebDriver driver) throws Exception {

		eo.wait(3000);
		String actualZipCodeErrMessageDisplayed = eo.getText(driver, "XPath", "zipCodeErrMsgXpath");
		addComment("The message "  + actualZipCodeErrMessageDisplayed + " is displayed ");
		String expectedMsg = "Please enter valid pincode of 6 digits.";
		if (actualZipCodeErrMessageDisplayed.equals(expectedMsg)) {
			addComment("'Please enter valid pincode of 6 digits' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to display message");
		}
	}	

	//To Click on Continue To Payment
	/**
	 * <p>
	 * <b>Method Name:</b> clickContinueToPayment
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on Continue To Payment
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnContinueToPayment(WebDriver driver)  throws Exception {

		// Waits until the  'Continue to payment' is displayed
		Utility.waitUntilExists(driver, "XPath", "continueToPaymentBtnXpath", curApp);
		//To click on 'Continue to payment' button
		eo.clickElement(driver, "XPath", "continueToPaymentBtnXpath");
		addComment("Successfully clicked on Continue To Payment Button");

	}
	//To Verify Address Messages
	/**
	 * <p>
	 * <b>Method Name:</b> verifyAddressMsgs
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Address Messages
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyErrMsgsOnClickingContinueToPaymentBtn(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify message "Please enter first name"
		String actualFnameErrMessageDisplayed = eo.getText(driver, "XPath", "fnameErrMsgXpath");
		addComment("The message "  + actualFnameErrMessageDisplayed + " is displayed ");
		String expectedFnameMsg = "Please enter first name";
		if (actualFnameErrMessageDisplayed.equals(expectedFnameMsg)) {
			addComment("'Please enter first name' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to Verify first name Error message");
		}

		//To Verify message "Please Enter Address"
		String actualAddressErrMessageDisplayed = eo.getText(driver, "XPath", "addressErrMsgXpath");
		addComment("The message "  + actualAddressErrMessageDisplayed + " is displayed ");
		String expectedAddressMsg = "Please enter address";
		if (actualAddressErrMessageDisplayed.equals(expectedAddressMsg)) {
			addComment("'Please Enter Address' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to Verify Address Error message");
		}

		//To Verify message "Please Enter Valid Mobile Number"

		String actualMobileErrMessageDisplayed = eo.getText(driver, "XPath", "mobErrMsgXpath");
		addComment("The message "  + actualMobileErrMessageDisplayed + " is displayed ");
		String expectedMobMsg = "Please Enter Valid Mobile Number";
		if (actualMobileErrMessageDisplayed.equals(expectedMobMsg)) {
			addComment("'Please Enter Valid Mobile Number' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to Verify Address Error message");
		}

	}

	//To enter invalid First Name
	/**
	 * <p>
	 * <b>Method Name:</b> enterFirstname
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter invalid First Name
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void enterFirstname(WebDriver driver) throws Exception {

		String fname = ExcelReader.getValue("Fname");

		// Waits until the Address' page is loaded
		Utility.waitUntilExists(driver, "XPath", "fNameTextBoxXpath", curApp);
		//To enter First name field
		eo.enterText(driver, "XPath", "fNameTextBoxXpath", fname);
		addComment("Successfully entered the First Name");

	}

	//To Verify First Name Error message
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorFnameMsg
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify First Name Error message
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyFnameErrMsg(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify msg "Please enter valid first name. Allowed characters (a-z)."

		String firstNameErrMsg = eo.getText(driver, "Xpath", "fnameErrMsgXpath");
		addComment("First name Error message displayed in UI: " + firstNameErrMsg);
		assertTrue(firstNameErrMsg.equalsIgnoreCase("Please enter valid first name. Allowed characters (a-z).") == true, "Successfully verified the Error Message : " + firstNameErrMsg, "Not able to verify the Error Message");
	}

	//To enter Last Name
	/**
	 * <p>
	 * <b>Method Name:</b> enterInvalidLname
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter invalid Last Name
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void enterLastname(WebDriver driver) throws Exception {
		eo.wait(3000);
		String lname = ExcelReader.getValue("Lname");
		try {
			eo.enterText(driver, "XPath", "lNameTextBoxXpath", lname);
			addComment("Successfully entered the Last Name");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the Last Name", e);
		}	

	}

	//To Verify Last Name Error message
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMsgForLnameField
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Last Name Error message
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyErrorMsgForLnameField(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify message "Please enter valid Last name. Allowed characters (a-z)."		
		String actualLNameErrMsg = eo.getText(driver, "XPath", "lnameErrMsgXpath");
		addComment("The message "  + actualLNameErrMsg + " is displayed ");
		String expectedLNameErrMsg = "Please enter valid last name. Allowed characters (a-z).";
		if (actualLNameErrMsg.equals(expectedLNameErrMsg)) {
			addComment("'Please enter valid first name. Allowed characters (a-z).' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to Verify Last Name Error message");
		}
	}

	//To enter Address line 1
	/**
	 * <p>
	 * <b>Method Name:</b> enterAddressLine1
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter Address line 1
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void enterAddressLine1(WebDriver driver) throws Exception {
		eo.wait(3000);
		String addLine1 = ExcelReader.getValue("AddLine1");
		
			eo.enterText(driver, "XPath", "addLine1TextBoxXpath", addLine1);
			addComment("Successfully entered the Address Line1");
	}

	//To Verify Address line1 Error message
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMsgForAddressLine1Field
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Address line1 Error message
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyErrorMsgForAddressLine1Field(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify  Error message.	
		
		String addressLine1ErrMsg = eo.getText(driver, "Xpath", "addLine1ErrMsgXpath");
		addComment("Address line 1 Error message displayed in UI: " + addressLine1ErrMsg);
		assertTrue(addressLine1ErrMsg.equalsIgnoreCase("Allowed special characteres /.:#,-' .") == true, "Successfully verified the Error Message : " + addressLine1ErrMsg, "Not able to verify the Error Message");
		
	}

	//To enter Address line 2
	/**
	 * <p>
	 * <b>Method Name:</b> enterAddressLine2
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter Address line 2
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void enterAddressLine2(WebDriver driver) throws Exception {
		eo.wait(3000);
		String addLine2 = ExcelReader.getValue("AddLine2");
		try {
			eo.enterText(driver, "XPath", "addLine2TextBoxXpath", addLine2);
			addComment("Successfully entered the Address Line2");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the Address Line2", e);
		}
		
	}
	//To Verify Address line2 Error message
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMsgForAddressLine2Field
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Address line2 Error message
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyErrorMsgForAddressLine2Field(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify Error message 
		
		String addressLine2ErrMsg = eo.getText(driver, "Xpath", "addLine2ErrMsgXpath");
		addComment("Address line 1 Error message displayed in UI: " + addressLine2ErrMsg);
		assertTrue(addressLine2ErrMsg.equalsIgnoreCase("Allowed special characteres /.:#,-' .") == true, "Successfully verified the Error Message : " + addressLine2ErrMsg, "Not able to verify the Error Message");

	}
	//To enter Address line 3
	/**
	 * <p>
	 * <b>Method Name:</b> enterAddressLine3
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter Address line 3
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void enterAddressLine3(WebDriver driver) throws Exception {

		String addLine3 = ExcelReader.getValue("AddLine3");

		Utility.waitUntilExists(driver, "XPath", "addLine3TextBoxXpath", curApp);

		eo.enterText(driver, "XPath", "addLine3TextBoxXpath", addLine3);
		addComment("Successfully entered the Address Line3");

	}
	//To Verify Address line3 Error message
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMsgForAddressLine3Field
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Address line3 Error message
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyErrorMsgForAddressLine3Field(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify Error message 
		
		String addressLine3 = eo.getText(driver, "Xpath", "addLine3ErrMsgXpath");
		addComment("Address line 3 Error message displayed in UI: " + addressLine3);
		assertTrue(addressLine3.equalsIgnoreCase("Allowed special characteres /.:#,-' .") == true, "Successfully verified the Error message : " + addressLine3, "Not able to verify the Error Message");
	}
	//To enter Landmark
	/**
	 * <p>
	 * <b>Method Name:</b> enterLandMark
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter Land Mark
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void enterLandMark(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "landMarkTextBoxXpath", curApp);
		String landMark = ExcelReader.getValue("LandMark");
		
			eo.enterText(driver, "XPath", "landMarkTextBoxXpath", landMark);
			addComment("Successfully entered the Address Land mark");
	}

	//To Verify Address Land Mark Error message
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMsgForLandMarkField
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify Address Land Mark Error message
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyErrorMsgForLandMarkField(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify Error message
		String landMarkErrMsg = eo.getText(driver, "Xpath", "landMarkErrMsgXpath");
		addComment("Land mark Error message displayed in UI: " + landMarkErrMsg);
		assertTrue(landMarkErrMsg.equalsIgnoreCase("Allowed special characteres /.:#,-' .") == true, "Successfully verified the Error Message : " + landMarkErrMsg, "Not able to verify the Error Message");
		
	}
	//To enter Mobile Number
	/**
	 * <p>
	 * <b>Method Name:</b> enterMobNum
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter Land Mark
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void enterMobNum(WebDriver driver) throws Exception {

		eo.wait(3000);
		String mobNum = ExcelReader.getValue("MobNum");
		try {
			eo.enterText(driver, "XPath", "mobNumTextBoxXpath", mobNum);
			addComment("Successfully entered the Mobile Number");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the Mobile number", e);
		}	
	}
	//To Verify Mobile Number Error message
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMsgForMobNum
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify Mobile Number Error message
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyErrorMsgForMobNum(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		//To Verify Error message 
		String actualMobNumErrMsg = eo.getText(driver, "XPath", "mobNumErrMsgXpath");
		addComment("The message "  + actualMobNumErrMsg + " is displayed ");
		String expectedMobNumErrMsg = "Please enter 10 digit mobile number.";
		if (actualMobNumErrMsg.equals(expectedMobNumErrMsg)) {
			addComment("Please enter 10 digit mobile number.' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to Verify Mobile Number Error message");
		}
	}

	//To click on product image in summary page and verify Product details page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnProductAndVerifyProductDesc
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on product image in summary page and verify Product details page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page.
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnProductAndVerifyProductDesc(WebDriver driver) throws Exception {

		String oldTab = driver.getWindowHandle();
		eo.clickElement(driver, "XPath", "productXpath");
		addComment("Successfully clicked on Product.");

		eo.wait(4000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));	

		//To verify Product Description
		eo.verifyElementIsDisplayed(driver, "XPath", "productDescriptionXpath");
		addComment("Product Description is dispalyed.");

		//To verify Product Features
		eo.verifyElementIsDisplayed(driver, "XPath", "ProductFeatureXpath");
		addComment("Product Features is dispalyed.");

	}

	//To click on Clear Form Button
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnClearFormBtn
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on Clear Form Button
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnClearFormBtn(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();

		// Waits until the 'Address page'  is loaded
		Utility.waitUntilExists(driver, "XPath", "clearFormBtnXpath", curApp);
		//To Click on Clear Form Button
		eo.clickElement(driver, "XPath", "clearFormBtnXpath");
		addComment("Successfully clicked on Clear Form Button.");
	}

	//To click on Edit Link in Checkout summary page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnEditLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on Edit Link in Checkout summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnEditLink(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "editLinkXpath", curApp);
		//To Click on Edit Link
		eo.clickElement(driver, "XPath", "editLinkXpath");
		addComment("Successfully clicked on Edit link.");
	}

	//To Verify Select Size list is displayed on clicking Edit link in check out summary page
	/**
	 * <p>
	 * <b>Method Name:</b> verifySelectSizeList
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify Select Size list is displayed on clicking Edit link in check out summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifySelectSizeListIsDisplayed(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "selectSizeListXpath", curApp);

		boolean selectSizeListDisplay = eo.verifyElementIsDisplayed(driver, "xpath", "selectSizeListXpath");
		assertTrue(selectSizeListDisplay, "Select Size List is displayed.", "Select Size List is not displayed.");	
	}	
	//To Select Size  from select size drop down in Check out summary page
	/**
	 * <p>
	 * <b>Method Name:</b> selectSizeFromSizeDropDown
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Select Size  from select size drop down in Check out summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void selectSizeFromSizeDropDown(WebDriver driver) throws Exception {

		String size = ExcelReader.getValue("Size");
		try {
			WebElement element = driver.findElement(By.id(GetElementIdentifier.getProperty("sizeOptionXpath", curApp)));
			Select sizeOption=new Select(element);
			sizeOption.selectByVisibleText(size);  
			addComment("Successfully selected size : " + size);
		}catch (Exception e) {
			throw new POMMethodExecException("Not able to Select size from drop down", e);
		}

	}

	//To click on Save Button in Checkout summary page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnSaveButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on Save Button in Checkout summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnSaveButton(WebDriver driver) throws Exception {
		eo.wait(3000);
		//To Click on Save Button
		eo.clickElement(driver, "XPath", "saveButtonXpath");
		addComment("Successfully clicked on Save Button.");
	}	

	//To Verify edited size is saved in Checkout summary page
	/**
	 * <p>
	 * <b>Method Name:</b> verifyEditedSizeIsSaved
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify edited size is saved in Checkout summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyEditedSizeIsSaved(WebDriver driver) throws Exception {

		eo.wait(5000);
		String actualSize = eo.getText(driver, "XPath", "sizeOptionSelectedXpath");
		addComment("The Actual Size given is : " + actualSize);
		String size = ExcelReader.getValue("Size");
		if (actualSize.equals(size)) {
			addComment("Successfully verified size is saved");
		} else {
			throw new POMMethodExecException("Not able to verify edited size is saved");
		}
	}	

	//To verify size is not changed after clicking on Cancel link in Checkout summary page
	/**
	 * <p>
	 * <b>Method Name:</b> verifySizeIsNotChangedAfterClickingCancel
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To verify size is not changed after clicking on Cancel link in Checkout summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifySizeIsNotChangedAfterClickingCancel(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "sizeOptionSelectedXpath", curApp);
		String actualSize = eo.getText(driver, "XPath", "sizeOptionSelectedXpath");
		addComment("The Actual Size is : " + actualSize);

		Utility.waitUntilExists(driver, "XPath", "editLinkXpath", curApp);
		//To Click on Edit Link
		eo.clickElement(driver, "XPath", "editLinkXpath");
		addComment("Successfully clicked on Edit link.");
	
		String size = ExcelReader.getValue("Size");
		
		try {
			WebElement element = driver.findElement(By.id(GetElementIdentifier.getProperty("sizeOptionXpath", curApp)));
			Select sizeOption=new Select(element);
			sizeOption.selectByVisibleText(size);  
			addComment("Size is Edited Successfully : " + size);
		}catch (Exception e) {
			throw new POMMethodExecException("Not able to Edit size from drop down", e);
		}

		Utility.waitUntilExists(driver, "XPath", "cancelBtnXpath", curApp);
		//To Click on Cancel link
		eo.clickElement(driver, "XPath", "cancelBtnXpath");
		addComment("Successfully clicked on Cancel link.");

		Utility.waitUntilExists(driver, "XPath", "cancelBtnXpath", curApp);
		//To verify Edited size is not saved after clicking Cancel button
		if (actualSize != size){
			addComment("Edited Size is not saved");
		}else{
			throw new POMMethodExecException("Not able to verify that Edited size is saved");
		}
	}

	//To click on Delete Icon in Checkout summary page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnDeleteIcon
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on Delete Icon in Checkout summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnDeleteIcon(WebDriver driver) throws Exception {

		//To Click on Delete Icon
		eo.clickElement(driver, "XPath", "deleteIconXpath");
		addComment("Successfully clicked on Delete Icon.");
	}


	//To Click On Coupons And TrendIn Credits in Checkout summary page
	/**
	 * <p>
	 * <b>Method Name:</b> ClickOnCouponsAndTrendInCredits
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Click On Coupons And TrendIn Credits in Checkout summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void ClickOnCouponsAndTrendInCredits(WebDriver driver) throws Exception {

		driver.switchTo().defaultContent();
		Utility.waitUntilExists(driver, "XPath", "couponsXpath", curApp);
		//To Click on Coupons And TrendIn Credits
		eo.clickElement(driver, "XPath", "couponsXpath");
		addComment("Successfully clicked on Coupons And TrendIn Credits.");
	}

	//To Verify Discount Coupons / vouchers you can use screen
	/**
	 * <p>
	 * <b>Method Name:</b> verifyDiscountCouponsPageHeader
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify Discount Coupons / vouchers you can use screen 
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyDiscountCouponsPageHeader(WebDriver driver) throws Exception {

		// To verify 'Discount Coupons / vouchers you can use' header is displayed
		String pageHeader = eo.getText(driver, "Xpath", "discountCouponsHeaderXpath");
		assertTrue(pageHeader.equalsIgnoreCase("Discount Coupons / vouchers you can use")==true, "Successfully verified the Page Header : " + pageHeader, 
				"Not able to verify the Page header");

		driver.switchTo().frame(0);
		String couponDetailLabel = eo.getText(driver, "Xpath", "couponDetailLabelXpath");
		assertTrue(couponDetailLabel.equalsIgnoreCase("Enter Coupon Details")==true, "Successfully verified the text : " + couponDetailLabel, 
				"Not able to verify the text");

		//To verify 'Available Offers' is displayed
		String availableOffersText = eo.getText(driver, "Xpath", "availableOffersTextXpath");
		assertTrue(availableOffersText.equalsIgnoreCase("AVAILABLE OFFERS")==true, "Successfully verified the text : " + availableOffersText, 
				"Not able to verify the text");

		//To verify 'Your Order Summary' pagination is displayed
		String yourOrderSummaryPagination = eo.getText(driver, "Xpath", "yourOrderSummaryXpath");
		assertTrue(yourOrderSummaryPagination.equalsIgnoreCase("Your Order Summary")==true, "Successfully verified the Page Header : " + yourOrderSummaryPagination, 
				"Not able to verify the Page header");

	}

	/*//To Verify Discount Coupons Page header for non registered User
	 *//**
	 * <p>
	 * <b>Method Name:</b> verifyDiscountPageHeaderForNonRegisteredUser
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify Discount Coupons Page header for non registered User 
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 *//*
	public void verifyDiscountPageHeaderForNonRegisteredUser(WebDriver driver) throws Exception {

		eo.wait(3000);
		driver.switchTo().frame(0);
		String discountPageHeader = eo.getText(driver, "Xpath", "discountPageHeaderXpath");
		assertTrue(discountPageHeader.equals("Sign in / Sign up to view vouchers specific to your account") == true, "Successfully verified the error message : " + discountPageHeader, 
				"Not able to verify the error message");

	}*/

	//To click on Available offers link in Discount Coupons / vouchers you can use screen
	/**
	 * <p>
	 * <b>Method Name:</b> verifyDiscountCouponsPageHeader
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on Available offers link in Discount Coupons / vouchers you can use screen
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnAvailableOfferLink(WebDriver driver) throws Exception {

		eo.clickElement(driver, "XPath", "availableOffersTextXpath");
		addComment("Successfully clicked on Available Offers link");

	}

	//To verify Available offers in Discount Coupons / vouchers you can use screen
	/**
	 * <p>
	 * <b>Method Name:</b> verifyDiscountCouponsPageHeader
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To verify Available offers in Discount Coupons / vouchers you can use screen
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyAvailableOffersList(WebDriver driver) throws Exception {

		List<WebElement> allOffers = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allOffersXpath", curApp)));
		addComment("No of Offers are: " + allOffers.size());
		if (allOffers.size() <= 0) {
			throw new POMMethodExecException("No offers are present to display");
		}
		String allOffersInUI = new String();
		for (WebElement element : allOffers) {
			allOffersInUI= element.getText();
			if (allOffers.equals(allOffersInUI)) {
				addComment("offers available are :" + allOffers);
			}
		}
	}

	//To click on Apply Button in Discount Coupons / vouchers you can use screen
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnApplyBtn
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on Apply Button in Discount Coupons / vouchers you can use screen
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnApplyBtn(WebDriver driver) throws Exception {
		
		Utility.waitUntilExists(driver, "XPath", "applyBtnXpath", curApp);
		eo.clickElement(driver, "XPath", "applyBtnXpath");
		addComment("Successfully clicked on Apply Button");
	}

	//To enter voucher code in Discount Coupons / vouchers you can use screen
	/**
	 * <p>
	 * <b>Method Name:</b> enterVoucherCode
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To enter voucher code in Discount Coupons / vouchers you can use screen
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void enterVoucherCode(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "couponDetailTextBoxXpath", curApp);
		String voucherCode = ExcelReader.getValue("VoucherCode");
			eo.enterText(driver, "XPath", "couponDetailTextBoxXpath", voucherCode);
			addComment("Successfully entered the Voucher Code");
	}

	//To Verify error message when invalid voucher code is entered in Discount Coupons / vouchers screen
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrMsgForInvaldVoucherCode
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify error message when invalid voucher code is entered in Discount Coupons / vouchers screen
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyErrMsgForInvalidVoucherCode(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "voucherCodeErrMsg", curApp);
		
		String voucherCodeErrMsgText = eo.getText(driver, "Xpath", "voucherCodeErrMsg");
		assertTrue(voucherCodeErrMsgText.equals("Voucher not exists. Please enter valid code.") == true, "Successfully verified the error message : " + voucherCodeErrMsgText, 
				"Not able to verify the error message");

	}

	//To Verify Apply button id disabled in Discount Coupons / vouchers screen
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrMsgForInvaldVoucherCode
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Verify Apply button id disabled in Discount Coupons / vouchers screen
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyApplyBtnIsDisabled(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "applyBtnXpath", curApp);
		driver.switchTo().frame(0);

		try {

			WebElement applyBtn = driver.findElement(By.xpath(GetElementIdentifier.getProperty("applyBtnXpath", curApp)));
			if(applyBtn.isEnabled()) {
				addComment("Successfully verified Button is enabled");
			} else {
				addComment("Successfully verified Button is Disabled");
			}
		}catch (Exception e) {
			throw new POMMethodExecException("Not able verify Apply button is disabled", e);
		}
	}

	//To clickk on Discount in Discount Coupons / vouchers screen
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnDiscountCode
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To clickk on Discount in Discount Coupons / vouchers screen
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page 
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnDiscountCode(WebDriver driver) throws Exception {

		eo.wait(3000);
		driver.switchTo().frame(1);
		eo.clickElement(driver, "XPath", "");
		addComment("Successfully clicked on Discount radio button");


	}	

	/**
	 * <p>
	 * <b>Method Name:</b> clickAndVerifyTheGiftWrapThisOrderCheckBox
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click and verify the gift wrap page 
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch 
	 * </p>
	 * 
	 * @author Manasa M G
	 * 
	 */
	public void clickAndVerifyTheGiftWrapThisOrderCheckBox(WebDriver driver) throws Exception {

		// To click on the checkbox of gift wrap
		eo.clickElement(driver, "Xpath", "giftWrapCheckBoxXpath");
		addComment("Successfully clicked on the checkbox");

		// To verify the message
		try {
			for (int i = 0; i <= 5000; i++) {
				String actualTitle = "Gift Wrap Message";
				String expectedTitle = eo.getText(driver, "Xpath", "giftWrapHeaderXpath");
				if (actualTitle.equalsIgnoreCase(expectedTitle)) {
					addComment("Successfully 'Gift Wrap Message'Page is displayed :" + expectedTitle);
					break;

				}
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify the Page", e);
		}

	}
	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMessgaForEmptyFieldINGiftWrapPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To verify the error message for empty textfield
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch 
	 * </p>
	 * 
	 * @author Manasa M G
	 * 
	 */

	public void verifyErrorMessgaForEmptyFieldINGiftWrapPage(WebDriver driver) throws Exception {

		// To verify the errror message
		String actualTitle = "Please enter gift wrap message";
		String expectedTitle = eo.getText(driver, "Xpath", "errorMesageInGiftWrapXpath");
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			addComment("Successfully verified the error message" + expectedTitle);
		} else {
			throw new POMMethodExecException("Unable to verify the error messgae");
		}

	}
	/**
	 * <p>
	 * <b>Method Name:</b> enterTextInTheTextAreaOfWrapText
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To enter the text in the gift wrap text area
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch 
	 * </p>
	 * 
	 * @author Manasa M G
	 * 
	 */

	public void enterTextInTheTextAreaOfWrapText(WebDriver driver) throws Exception {
		// To enter text
		String text = ExcelReader.getValue("Text");
		eo.enterText(driver, "Xpath", "enterTextFieldInWrapTextXpath", text);
		addComment("Successfully enterd the text");

	}

	public void verifyCheckBoxIsSelectedOrNot(WebDriver driver) throws Exception {
		String giftWrapValue = driver.findElement(By.xpath(GetElementIdentifier.getProperty("checkBoxXpath", curApp))).getAttribute("gift");
		// To verify the checkboc is selected or not
		if (Integer.parseInt(giftWrapValue) == 0) {
			addComment("checkbox is not selected ");
		} else if (giftWrapValue == Integer.toString(1)) {
			addComment("checkbox is selected");
		}

	}

	public void clickOnSubmitButtonInGiftWrapPage(WebDriver driver) throws Exception {
		// To click on the submit button
		eo.clickElement(driver, "Xpath", "submitButtonInGiftWrapPageXpath");
		addComment("Successfully clicked on the submit button");

	}

	public void clickOnCancelButton(WebDriver driver) throws Exception {

		// To click on cancel button
		eo.clickElement(driver, "Xpath", "closeButtonInGiftWrapPageXpath");
		addComment("Successfully clicked on the cancel button");

	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnTheEditButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on the adit button
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch 
	 * </p>
	 * 
	 * @author Manasa M G
	 * 
	 */
	public void clickOnTheEditButton(WebDriver driver) throws Exception {
		// To click on the edit button
		eo.clickElement(driver, "Xpath", "editButtonXpathInCheckOutPage");
		addComment("Successfully clicked on the edit button");
		// To verify the message
		try {
			for (int i = 0; i <= 5000; i++) {
				String actualTitle = "Gift Wrap Message";
				String expectedTitle = eo.getText(driver, "Xpath", "giftWrapHeaderXpath");
				if (actualTitle.equalsIgnoreCase(expectedTitle)) {
					addComment("Successfully 'Gift Wrap Message'Page is displayed :" + expectedTitle);
					break;

				}
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify the Page", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnTheAddMoreProductsButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on the add more products button
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch 
	 * </p>
	 * 
	 * @author Manasa M G
	 * 
	 */

	public void clickOnTheAddMoreProductsButton(WebDriver driver) throws Exception {
		// To click on the add more products
		eo.clickElement(driver, "Xpath", "addMoreProductsXpath");
		addComment("Successfully clicked on the add more products");

	}
	/////////////////////////////////////////30/09/2015///////////////////////////////////////
	//To Verify Shipping Address page header
	/**
	 * <p>
	 * <b>Method Name:</b> verifyShippingAddressPageHeader
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Shipping Address page header
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyShippingAddressPageHeader(WebDriver driver) throws Exception {

		// To verify 'Shipping Address' header is displayed
		String pageHeader = eo.getText(driver, "Xpath", "shippingAddressHeaderXpath");
		assertTrue(pageHeader.equalsIgnoreCase("SHIPPING ADDRESS")==true, "Successfully verified the Shipping Address Page Header : " + pageHeader, 
				"Not able to verify the shipping address Page header");
	}

	// To check Ship to a new address CheckBox
	/**
	 * <p>
	 * <b>Method Name:</b> checkOnShipNewAddressCheckBox
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To check Ship to a new address CheckBox
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void checkOnShipNewAddressCheckBox(WebDriver driver) throws Exception {
		// To check Ship to a new address CheckBox
		eo.clickElement(driver, "Xpath", "shipNewAddressCheckBoxXpath");
		addComment("Successfully checked Ship to a new address CheckBox");

	}

	// To verify Your Shipping address Header
	/**
	 * <p>
	 * <b>Method Name:</b> verifyYourShippingAddressHeader
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify Your Shipping address Header
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyYourShippingAddressHeader(WebDriver driver) throws Exception {

		// To verify 'Your Shipping Address' header is displayed
		String pageHeader = eo.getText(driver, "Xpath", "yourShippingAddressHeaderXpath");
		assertTrue(pageHeader.equalsIgnoreCase("YOUR SHIPPING ADDRESS")==true, "Successfully verified the Your Shipping Address Header : " + pageHeader, 
				"Not able to verify the Your shipping address header");

	}

	// To verify 'Select from previously shipped address' text is displayed
	/**
	 * <p>
	 * <b>Method Name:</b> verifyPreviouslyShippedAddressText
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify 'Select from previously shipped address' text is displayed
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyPreviouslyShippedAddressText(WebDriver driver)throws Exception {

		// To verify 'Select from previously shipped address' text is displayed
		String previouslyShippedAddressText = eo.getText(driver, "Xpath", "previouslyShippedAddressTextXpath");
		assertTrue(previouslyShippedAddressText.equalsIgnoreCase("Select from previously shipped address")==true, "Successfully verified the Mmessage : " + previouslyShippedAddressText, 
				"Not able to verify the Message");

	}

	// To click on edit link in Shipping address page for registered user
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnEditLinkInShippinghAddrsPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on edit link in Shipping address page for registered user
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnEditLinkInShippingAddrsPage(WebDriver driver) throws Exception {

		// Waits until the 'Edit link' element is loaded
		Utility.waitUntilExists(driver, "XPath", "shipingAddressEditLinkXpath", curApp);

		// To click on edit link
		eo.clickElement(driver, "Xpath", "shipingAddressEditLinkXpath");
		addComment("Successfully clicked on edit link");
	}

	// To verify Modify address page is displayed
	/**
	 * <p>
	 * <b>Method Name:</b> verifyEditAddressPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify Modify address page is displayed
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyEditAddressPage(WebDriver driver) throws Exception {

		// Waits until the 'Edit Address' page header  is loaded
		Utility.waitUntilExists(driver, "XPath", "editAdressHeaderXpath", curApp);

		String actualEditAddressHeader = eo.getText(driver, "XPath", "editAdressHeaderXpath");
		addComment("The message "  + actualEditAddressHeader + " is displayed ");

		String ExpectedEditAddressHeader[] =  actualEditAddressHeader.split(":");
		addComment("Expected Edit Address Header is : " +ExpectedEditAddressHeader[0]);

		assertTrue(ExpectedEditAddressHeader[0].equalsIgnoreCase("Edit Address")==true, "Successfully verified the Header : " +ExpectedEditAddressHeader[0] , 
				"Not able to verify the Header");
	}

	// To click on Back Button in address page for registered user
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnBackBtn
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on Back Button in address page for registered user
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnBackBtn(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "backBtnXpath", curApp);
		eo.clickElement(driver, "Xpath", "backBtnXpath");
		addComment("Successfully clicked on Back Button");
	}

	// To click on No. Of Items Link in address page for registered user
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnNoOfItemsLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on No. Of Items Link in address page for registered user
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnNoOfItemsLink(WebDriver driver) throws Exception {

		eo.clickElement(driver, "Xpath", "noOfItemsLinkXpath");
		addComment("Successfully clicked on No. Of Items link");

		// Waits until the 'CART SUMMARY' header page is loaded
		Utility.waitUntilExists(driver, "XPath", "cartSummaryHeaderXpath", curApp);

		// To verify 'CART SUMMARY' header is displayed
		String cartSummaryHeader = eo.getText(driver, "Xpath", "cartSummaryHeaderXpath");
		assertTrue(cartSummaryHeader.equalsIgnoreCase("CART SUMMARY")==true, "Successfully verified the header : " + cartSummaryHeader, 
				"Not able to verify the Header");
	}

	// To click on continue Button in Cart summary page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnContinueBtnInCartSummaryPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on continue Button in Cart summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnContinueBtnInCartSummaryPage(WebDriver driver) throws Exception {

		eo.clickElement(driver, "Xpath", "continueBtnInCartSummaryPageXpath");
		addComment("Successfully clicked on Continue button");

	}

	// To click on cancel Icon in Cart summary page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCancelIconInCartSummaryPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on cancel Icon in Cart summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnCancelIconInCartSummaryPage(WebDriver driver) throws Exception {

		// Waits until the 'Cancel Icon' is displayed
		Utility.waitUntilExists(driver, "XPath", "cancelIconInCartSummaryPageXpath", curApp);

		try {
			driver.switchTo().defaultContent();
			Actions action = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("cancelIconInCartSummaryPageXpath", curApp)));
			action.moveToElement(ele).build().perform();
			ele.click();
			addComment("Successfully clicked on Cancel Icon");	
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to Click On Cancel Icon", e);
		}
	}		

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnContactUsInCheckOutSummaryPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click and verify the checkout summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Manasa M G
	 * @Date [9-30-2015]
	 */
	public void clickOnContactUsInCheckOutSummaryPage(WebDriver driver) throws Exception {

		// To click on contact us
		eo.clickElement(driver, "Xpath", "contactUsXpath");
		addComment("Successfully clicked on the contact us ");
		// To verify the title of contact us page
		String title = driver.getTitle();
		System.out.println("title is   " + title);
		if (title.equalsIgnoreCase("Checkout Summary")) {
			addComment("Successfully navigated to checkout page :" + title);
		} else {
			throw new POMMethodExecException("Could not navigate to checkout page");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnPlaceOrderIncheckOutSummaryPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To click on the place order in check out summary page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Manasa M G
	 * @Date [9-30-2015]
	 */
	public void clickOnPlaceOrderIncheckOutSummaryPage(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "placeOrderButtonXpath");
		addComment("Clicked on placed order button.");
		// To verify the title of contact us page
		String title = driver.getTitle();
		System.out.println("title is   " + title);
		if (title.equalsIgnoreCase("TRENDIN - Checkout Authentication")) {
			addComment("Successfully navigated to Place order page :" + title);
		} else {
			throw new POMMethodExecException("Could not navigate to place page");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyToEnterMaiLIdInTheMailIdTextFieldInCheckOutPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To enter the mail id and click on the submit button
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Manasa M G
	 * @Date [9-30-2015]
	 */
	public void verifyToEnterMaiLIdInTheMailIdTextFieldInCheckOutPage(WebDriver driver, String emailId) throws Exception {
		// To enter the email
		eo.enterText(driver, "Xpath", "emailIdTextFieldXpath", emailId);
		addComment("Successfully enterd the mail");
		// To click on the submit button
		eo.clickElement(driver, "Xpath", "continueButtonXpath");
		addComment("Successfully clicked on the submit button");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMessageForInvalidMailIdInCheckoutPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To verify the error message for invalid mail id in
	 * checkout page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Manasa M G
	 * @Date [9-30-2015]
	 */
	public void verifyErrorMessageForInvalidMailIdInCheckoutPage(WebDriver driver) throws Exception {
		String expectedTitle = "Please enter valid E-mail.";
		String actualTitle = eo.getText(driver, "Xpath", "errorEmailIdMessageXpath");
		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			addComment("Successfully verified the error messsage for invalid mail id" + expectedTitle);
		} else {
			throw new POMMethodExecException("Unable to verify the error message");

		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyAlreadyRegisteredMailIdMessage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To verify message that displays when we enter the
	 * already registered mail id
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Manasa M G
	 * @Date [9-30-2015]
	 */
	public void verifyAlreadyRegisteredMailIdMessage(WebDriver driver) throws Exception {
		String expectedMessage = "An account already exists with this e-mail. Please login.";
		String actualMessage = eo.getText(driver, "Xpath", "");
		if (expectedMessage.equalsIgnoreCase(actualMessage)) {
			addComment("Successfully verified the error messsage for invalid mail id" + actualMessage);
		} else {
			throw new POMMethodExecException("Unable to verify the error message");

		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> toEnterPinCodeInTheZipCodeTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To enter the pin code in the zip code textfield
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Manasa M G
	 * @Date [9-30-2015]
	 */
	public void toEnterPinCodeInTheZipCodeTextfield(WebDriver driver, String pinCode) throws Exception {

		// To enter the code in the zip code textfield
		eo.enterText(driver, "Xpath", "guestShippingPinCodeXpath", pinCode);
		addComment("Successfully entered the pin code");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMessageForInvalidPinCodeTextfield
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To verify the error message for invalid pin code
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Manasa M G
	 * @Date [9-30-2015]
	 */
	public void verifyErrorMessageForInvalidPinCodeTextfield(WebDriver driver, String pinCode) throws Exception {
		String pinCodeNumbers = pinCode;
		if (pinCodeNumbers.length() <= 6) {
			pinCodeNumbers = "1234567";
		}
		addComment("Length of the pin code number before Entering into text box : " + "<br>" + pinCodeNumbers.length() + "</b>");
		try {
			eo.clearData(driver, "Xpath", "guestShippingPinCodeXpath");
			eo.enterText(driver, "Xpath", "guestShippingPinCodeXpath", pinCodeNumbers);
			String pinCodeField = driver.findElement(By.xpath(GetElementIdentifier.getProperty("guestShippingPinCodeXpath", curApp))).getAttribute("maxlength");
			// pinCodeField.length();
			addComment("Batch Name after entering into the Zip code text box: " + pinCodeField);
			if (pinCodeField.equalsIgnoreCase("6")) {
				addComment("Entered the Max char limit into the Zip code  : 6 Characters");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Failed to enter the data for 'Zip code'", e);
		}
	}

	// To verify Payment page is displayed
	/**
	 * <p>
	 * <b>Method Name:</b> verifyPaymentPageDisplay
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify Payment page is displayed
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyPaymentPageDisplay(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "paymentPageHeaderXpath", curApp);

		String paymentPageHeader = eo.getText(driver, "Xpath", "paymentPageHeaderXpath");
		assertTrue(paymentPageHeader.equalsIgnoreCase("SECURE PAYMENT OPTIONS")==true, "Successfully verified the header : " + paymentPageHeader, 
				"Not able to verify the Header");

	}

	// To verify Cash On Delivery Option is displayed
	/**
	 * <p>
	 * <b>Method Name:</b> verifyPaymentPageDisplay
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify Cash On Delivery Option is displayed
	 * </p>
	 * <p>
	 * <b>Dependencies:</b>  Browser.Launch - > Home page - > category page -> Checkout summary Page -> Shipping address Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void verifyCashOnDeliveryOptionIsDisplayed(WebDriver driver) throws Exception {

		Utility.waitUntilExists(driver, "XPath", "cashOnDeliveryOptionXpath", curApp);

		String cashOnDeliveryOption = eo.getText(driver, "Xpath", "cashOnDeliveryOptionXpath");
		assertTrue(cashOnDeliveryOption.equalsIgnoreCase("Cash on Delivery (COD)")==true, "Successfully verified the  Option : " + cashOnDeliveryOption, 
				"Not able to verify the COD OPtion");
	}

}

