package com.trendin.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class LouisPhilippePage extends TrendInTestSuite {
	final String curApp = "LouisPhilippePage";
	ElementOperation eo = new ElementOperation(curApp);

	/**
	 * <p>
	 * <b>Method Name:</b> verifyBrandLouisPhilippe
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify for Brand Louis Philippe home page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author : Kavya
	 * 
	 */
	public void verifyBrandLouisPhilippe(WebDriver driver) throws Exception {

		String linksToVerify = ExcelReader.getValue("LinksToVerify");
		String linksToVerifySplit[] = linksToVerify.split(";");

		int count = 0;
		String allElementsInUI = "";
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "louisphilippeHeaderPageXpath");
			if (pageStatus) {
				addComment("Louis Philippe page is displayed ");
				break;
			}
		}
		if (!pageStatus) {
			throw new POMMethodExecException("Louis Philippe page is not displayed");
		}

		// To verify for tiny header
		eo.verifyElementIsDisplayed(driver, "XPath", "tinyHeaderXpath");
		addComment("Tiny header is dispalyed");

		// To verify for login link
		eo.verifyElementIsDisplayed(driver, "XPath", "loginIconXpath");
		addComment("Login/Register link is dispalyed");

		// To verify for trendin logo
		eo.verifyElementIsDisplayed(driver, "XPath", "trendInLogoXpath");
		addComment("Trendin logo is dispalyed");

		// To veriy the links in tiny header
		int count1 = 0;
		try {
		for (int i = 0; i < linksToVerifySplit.length; i++) {
			String tinyLinksXpath = GetElementIdentifier.getProperty("tinyLinksXpath", curApp);
			tinyLinksXpath = tinyLinksXpath.replace("{replace}", linksToVerifySplit[count1]);
			pageStatus = driver.findElement(By.xpath(tinyLinksXpath)).isDisplayed();
			if (pageStatus) {
				addComment(linksToVerifySplit[count1] + " is displayed");
				count1++;
			} else {
				throw new POMMethodExecException(linksToVerifySplit[count] + " is not displayed");
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException(linksToVerifySplit[count] + " is not displayed" , e);
		}
		// To verify for search Drop Down
		eo.verifyElementIsDisplayed(driver, "XPath", "searchDropDown");
		addComment("Search Drop down is dispalyed");

		// To verify for louis philippe Header Link
		eo.verifyElementIsDisplayed(driver, "XPath", "louisphilippeHeaderPageLinkXpath");
		addComment("Louis philippe Header Link is dispalyed");

		// To verify for shopping Cart Icon
		eo.verifyElementIsDisplayed(driver, "XPath", "shoppingCartIconXpath");
		addComment("Shopping Cart Icon is dispalyed");

		// To verify mega menu bars
		try {
		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("megaMenuBarsXpath", curApp)));
		if (allElements1.size() <= 0) {
			throw new POMMethodExecException("No menu bars are present to display");
		}
		for (WebElement element : allElements1) {
			allElementsInUI = element.getText();
			addComment("Menu available is :" + allElementsInUI);
		} 
		} catch(Exception e){
			throw new POMMethodExecException("Mega menu bar is not displayed" ,e);
		}

		// To verify sub brands
		try {
		List<WebElement> allElements2 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("subBrandsXpath", curApp)));
		addComment("Number of sub brands present :" + allElements2.size());
		if (allElements2.size() <= 0) {
			throw new POMMethodExecException("No menu bars are present to display");
		}

		String subBrandsInUI = "";
		for (WebElement element : allElements2) {
			boolean allElementsDisplay = element.isDisplayed();
			if (allElementsDisplay) {
				subBrandsInUI = element.getAttribute("role");
				addComment("Sub brand " + subBrandsInUI + " is displayed");
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Sub brands are not displayed" ,e);
		}
		eo.verifyElementIsDisplayed(driver, "XPath", "adityaBirlaImageXpath");
		addComment("Aditya birla image is dispalyed");
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("adityaBirlaImageXpath", curApp)));
		action.moveToElement(ele).build().perform();

		// To verify top button
		eo.verifyElementIsDisplayed(driver, "Xpath", "topButtonXpath");
		addComment("Top button is displayed");

		// To verify footers link
		eo.verifyElementIsDisplayed(driver, "Xpath", "footersLinkXpath");
		addComment("Footers link and social sites are displayed");

		// To verify copy link
		eo.verifyElementIsDisplayed(driver, "Xpath", "copyRightXpath");
		addComment("Copy right is displayed");

	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnShopByBrands
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click On ShopByBrands
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author : Kavya
	 * 
	 */
	public void clickOnShopByBrands(WebDriver driver) throws Exception {

		// To click on Shop by brands
		eo.clickElement(driver, "XPath", "shopByBrandsXpath");
		addComment("Successfully clicked on shop by brands tab");
		eo.wait(3000);
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnShopByBrandOptionAndVerify
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify for Brand home page when user clicks on any
	 * brand
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author : Kavya
	 * 
	 */
	public void clickOnShopByBrandOptionAndVerify(WebDriver driver) throws Exception {

		String brandToClick = ExcelReader.getValue("BrandToClick");
		String brandToVerify = ExcelReader.getValue("BrandToVerify");
		String brands = ExcelReader.getValue("Brands");
		String allBrands[] = brands.split(";");

		List<WebElement> allElements ;
		try{
		allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("brandsXpath", curApp)));
		addComment("Number of brands present :" + allElements.size());
		if (allElements.size() <= 0) {
			throw new POMMethodExecException("No brands are present to display");
		}

		int count = 0;
		String allElementsInUI1 = "";
		for (WebElement element : allElements) {
			allElementsInUI1 = element.getAttribute("alt");
			if (allBrands[count].equalsIgnoreCase(allElementsInUI1)) {
				addComment("Brand available is :" + allBrands[count]);
				count++;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Brand is not displayed" ,e);
		}
		
		String allElementsInUI[] = new String[allElements.size()];
		int count1 = 0;
		for (WebElement element : allElements) {
			allElementsInUI[count1] = element.getAttribute("alt");
			if (allElementsInUI[count1].equalsIgnoreCase(brandToClick)) {
				// To click on brand
				element.click();
				addComment("Successfully clicked on brand :" + brandToClick);
				break;
			}
		}
		
		String allBrandsXpath = GetElementIdentifier.getProperty("allBrandsXpath", curApp);
		allBrandsXpath = allBrandsXpath.replace("{brandName}", brandToVerify);
		boolean pageStatus  = false;
		try {
		for (int i = 0; i <= 5000; i++) {
			 pageStatus = driver.findElement(By.xpath(allBrandsXpath)).isDisplayed();
			if (pageStatus) {
				addComment(brandToClick + " Home page is displayed ");
				break;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Brand home page is not displayed" ,e);
		}
		if(!pageStatus){
			throw new POMMethodExecException("Brand home page is not displayed");
		}
		
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForAllBrandLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify For All Brands Link
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author : Kavya
	 * 
	 */
	public void verifyForAllBrandLink(WebDriver driver) throws Exception {

		// To click on all brands link
		eo.clickElement(driver, "XPath", "allBrandLinkXpath");
		addComment("Successfully clicked on all brands link");

		try {
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "homePageLogo");
			if (pageStatus) {
				addComment("Trend In Home page is displayed ");
				break;
			}
		}
		if(!pageStatus){
			throw new POMMethodExecException("Could not verify home page logo");
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not verify home page logo" ,e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCloseShopByBrands
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify For Close ShopByBrands
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author : Kavya
	 * 
	 */
	public void clickOnCloseShopByBrands(WebDriver driver) throws Exception {
		
		// To click on close
		eo.clickElement(driver, "XPath", "closeIconXpath");
		addComment("Successfully clicked on close");

	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnTrendInLogo
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click On TrendIn Logo and verify
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author : Kavya
	 * 
	 */
	public void clickOnTrendInLogo(WebDriver driver) throws Exception {

		// To click on logo
		eo.clickElement(driver, "XPath", "homePageLogo");
		addComment("Successfully clicked on TrendIn logo");

		try{
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "homePageLogo");
			if (pageStatus) {
				addComment("Trend In Home page is displayed ");
				break;
			}
		}
		if(!pageStatus){
			throw new POMMethodExecException("Home page logo is not displayed");
		}
		} catch(Exception e){
			throw new POMMethodExecException("Home page logo is not displayed" ,e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> guestUserRegistrationAndVerify
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> guest User Registration
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
	public void verifyGuestUserRegistration(WebDriver driver) throws Exception {
		String mobileNumber = ExcelReader.getValue("MobileNumber");
		String yourName = ExcelReader.getValue("YourName");
		String emailId = ExcelReader.getValue("EmailId");
		String password = ExcelReader.getValue("Password");
		String emailIdSplit[] = emailId.split("@");
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		emailId = emailIdSplit[0] + randomNumber;
		emailId = emailId +"@"+emailIdSplit[1];
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
			eo.enterText(driver, "Id", "mobileNumberXpath", mobileNumber);
			addComment("Successfully entered mobile number field :" + mobileNumber);
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
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "louisphilippeHeaderPageXpath");
			if (pageStatus) {
				addComment("Louis Philippe page is displayed ");
				break;
			}
		}
		if(!pageStatus){
			throw new POMMethodExecException("Louis Philippe page is not displayed");
		}
		
	}

	/**
	 * <p>
	 * <b>Method Name:</b> existingUserLoginAndVerify
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Login and verify for home page
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
	public void existingUserLoginPageLogoVerify(WebDriver driver) throws Exception {

		//To verify louis philippe home page
		try {
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "louisphilippeHeaderPageXpath");
			if (pageStatus) {
				addComment("Louis Philippe page is displayed ");
				break;
			}
		}
		if(!pageStatus){
			throw new POMMethodExecException("Louis Philippe page is not displayed ");
		}
		} catch(Exception e){
			throw new POMMethodExecException("Louis Philippe page is not displayed" ,e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyUserDropDown
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verify the DropDown of the user
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

	public void verifyUserDropDown(WebDriver driver) throws Exception {

		String dropDownValues = ExcelReader.getValue("DropDownValues");
		String allDropDownValues[] = dropDownValues.split(";");
		
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("userIconXpath", curApp)));
		action.moveToElement(ele).build().perform();

		//To verify drop downs
		try {
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("dropDownValueXpath", curApp)));
		String allElementsInUI = "";
		int count = 0;
		for (WebElement element : allElements) {
			allElementsInUI = element.getText();
			if(allElementsInUI.equals(allDropDownValues[count])){
			addComment("Drop down available is :" + allElementsInUI);
			count++;
			} else {
				throw new POMMethodExecException("Drop down value is not as expected:"+allElementsInUI);
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not verify the drop down" ,e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTinyUserNamePage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verify the navigation page after clickin on username
	 * in the login page
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

	public void verifyTinyUserNamePage(WebDriver driver) throws Exception {
		eo.verifyElementIsDisplayed(driver, "Xpath", "orderHistoryHeaderXpath");
		addComment("Successfully navigated to order history when user click on the username in the tiny header");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTinyStorePage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the store button and verify the navigated
	 * page
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

	public void verifyTinyStorePage(WebDriver driver) throws Exception {
		// To click on the store locator
		eo.clickElement(driver, "Xpath", "storeLocatorXpath");
		addComment("Successfullt clicked on the store locator button");
		// To verify the navigated page
		eo.verifyElementIsDisplayed(driver, "Xpath", "storeLocatorHeaderXpath");
		addComment("Successfully navigated to store locator when user click on the store locator icon in the tiny header");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTinyTrackOrderPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the Track Orderand verify the navigated
	 * page
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

	public void verifyTinyTrackOrderPage(WebDriver driver) throws Exception {
		// To click on the store locator
		eo.clickElement(driver, "Xpath", "trackOrderXpath");
		addComment("Successfullt clicked on the store locator button");
		// To verify the navigated page
		eo.verifyElementIsDisplayed(driver, "Xpath", "trackOrderHeaderXpath");
		addComment("Successfully navigated to track order when user click on the track order icon in the tiny header");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTinyContactUsPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the contact and verify the navigated page
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

	public void verifyTinyContactUsPage(WebDriver driver) throws Exception {
		// To click on the store locator
		eo.clickElement(driver, "Xpath", "contactUsXpath");
		addComment("Successfullt clicked on the store locator button");
		// To verify the navigated page
		eo.verifyElementIsDisplayed(driver, "Xpath", "contactUsHeaderXpath");
		addComment("Successfully navigated to contact us page when user click on the Contact Us icon in the tiny header");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyLogoPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click and verify the logo of the louis vphilippe
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

	public void verifyLogoPage(WebDriver driver) throws Exception {
		// To click on the logo
		eo.clickElement(driver, "Xpath", "louisphilippeHeaderPageXpath");
		addComment("Successfully clicked on the logo");

		// To verify it is navigating to home page only
		for (int i = 0; i <= 5000; i++) {
			boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "louisphilippeHeaderPageXpath");
			if (pageStatus) {
				addComment("Successfully navigated to the home page ");
				break;
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyDefaultSearchLabel
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the search label of louis philippe page
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

	public void verifyDefaultSearchLabel(WebDriver driver) throws Exception {
		// To verify the label
		String label = ExcelReader.getValue("LabelName");
		String getLabelValue = eo.getText(driver, "Xpath", "labelValueXpath");
		if (label.equalsIgnoreCase(getLabelValue)) {
			addComment("Successfully verified the label value " + label);
		} else {
			throw new POMMethodExecException("Unable to verify the error message");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnSearchButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the search button
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

	// To click on the search button
	public void clickOnSearchButton(WebDriver driver) throws Exception {
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifySearchButtonFunctionality
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter and verify the search textfield
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

	public void verifySearchButtonFunctionality(WebDriver driver, String searchKeyword) throws Exception {

		// To enter keyword in the search textfield
		eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", searchKeyword);
		addComment("Successfully enterd the keyword in the search textfield");
		// To click on the search button
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifySearchButtonNavigationPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter and verify the search textfield with
	 * different input
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

	public void verifySearchButtonNavigationPage(WebDriver driver) throws Exception {
		String searchKeyword = ExcelReader.getValue("SearchKeywordName");
		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allShirtLinkXpath", curApp)));

		String allElementsInUI1[] = new String[allElements1.size()];
		int count = 0;
		for (WebElement element : allElements1) {
			allElementsInUI1[count] = element.getAttribute("title");
			if (allElementsInUI1[count].contains(searchKeyword)) {
				addComment("Image " + count + " is displayed with slected category:" + searchKeyword);
				count++;
			}
		}

		// ///////////
		eo.cleardata(driver, "Xpath", "searchKeywordTextfieldXpath");
		addComment("Successfully cleared the search textfield");
		String searchKeyword1 = ExcelReader.getValue("SearchKeywordName1");
		eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", searchKeyword1);
		addComment("Successfully enterd the keyword in the search textfield");
		// To click on the search button
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");

		List<WebElement> allElements2 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allShirtLinkXpath", curApp)));

		String allElementsInUI2[] = new String[allElements1.size()];
		int count1 = 0;
		for (WebElement element : allElements2) {
			allElementsInUI2[count1] = element.getAttribute("title");
			if (allElementsInUI2[count1].contains(searchKeyword1)) {
				addComment("Image " + count1 + " is displayed with slected category:" + searchKeyword1);
				count++;
			}
		}

		// //
		eo.cleardata(driver, "Xpath", "searchKeywordTextfieldXpath");
		addComment("Successfully cleared the search textfield");
		String searchKeyword2 = ExcelReader.getValue("SearchKeywordName2");
		eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", searchKeyword2);
		addComment("Successfully enterd the keyword in the search textfield");
		// To click on the search button
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");

		List<WebElement> allElements3 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allShirtLinkXpath", curApp)));

		String allElementsInUI3[] = new String[allElements3.size()];
		int count2 = 0;
		for (WebElement element : allElements3) {
			allElementsInUI3[count2] = element.getAttribute("title");
			if (allElementsInUI3[count2].contains(searchKeyword2)) {
				addComment("Image " + count2 + " is displayed with slected category:" + searchKeyword2);
				count2++;
			}
		}

		// //
		eo.cleardata(driver, "Xpath", "searchKeywordTextfieldXpath");
		addComment("Successfully cleared the search textfield");
		String searchKeyword3 = ExcelReader.getValue("SearchKeywordName3");
		eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", searchKeyword3);
		addComment("Successfully enterd the keyword in the search textfield");
		// To click on the search button
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");

		List<WebElement> allElements4 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allShirtLinkXpath", curApp)));

		String allElementsInUI4[] = new String[allElements4.size()];
		int count3 = 0;
		for (WebElement element : allElements4) {
			allElementsInUI4[count3] = element.getAttribute("title");
			if (allElementsInUI4[count3].contains(searchKeyword3)) {
				addComment("Image " + count3 + " is displayed with slected category:" + searchKeyword3);
				count3++;
			}
		}

		// ///
		eo.cleardata(driver, "Xpath", "searchKeywordTextfieldXpath");
		addComment("Successfully cleared the search textfield");
		String searchKeyword4 = ExcelReader.getValue("SearchKeywordName4");
		eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", searchKeyword4);
		addComment("Successfully enterd the keyword in the search textfield");
		// To click on the search button
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");

		List<WebElement> allElements5 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allShirtLinkXpath", curApp)));

		String allElementsInUI5[] = new String[allElements5.size()];
		int count4 = 0;
		for (WebElement element : allElements5) {
			allElementsInUI5[count4] = element.getAttribute("title");
			if (allElementsInUI5[count4].contains(searchKeyword4)) {
				addComment("Image " + count4 + " is displayed with slected category:" + searchKeyword4);
				count4++;
			}
		}
		// /////
		eo.cleardata(driver, "Xpath", "searchKeywordTextfieldXpath");
		addComment("Successfully cleared the search textfield");
		String searchKeyword5 = ExcelReader.getValue("SearchKeywordName5");
		eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", searchKeyword5);
		addComment("Successfully enterd the keyword in the search textfield");
		// To click on the search button
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");

		List<WebElement> allElements6 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allShirtLinkXpath", curApp)));

		String allElementsInUI6[] = new String[allElements6.size()];
		int count5 = 0;
		for (WebElement element : allElements6) {
			allElementsInUI6[count5] = element.getAttribute("title");
			if (allElementsInUI6[count5].contains(searchKeyword5)) {
				addComment("Image " + count5 + " is displayed with slected category:" + searchKeyword5);
				count5++;
			}
		}
		eo.cleardata(driver, "Xpath", "searchKeywordTextfieldXpath");
		addComment("Successfully cleared the search textfield");
		String searchKeyword6 = ExcelReader.getValue("SearchKeywordName6");
		eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", searchKeyword6);
		addComment("Successfully enterd the keyword in the search textfield");
		// To click on the search button
		eo.clickElement(driver, "Xpath", "searchButtonXpath");
		addComment("Successfully clicked on the search button");

		List<WebElement> allElements7 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allShirtLinkXpath", curApp)));

		String allElementsInUI7[] = new String[allElements7.size()];
		int count6 = 0;
		for (WebElement element : allElements7) {
			allElementsInUI7[count6] = element.getAttribute("title");
			if (allElementsInUI5[count6].contains(searchKeyword6)) {
				addComment("Image " + count6 + " is displayed with slected category:" + searchKeyword6);
				count6++;
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMeassageForSearchButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message for search textfield
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

	public void verifyErrorMeassageForSearchButton(WebDriver driver) throws Exception {

		// To verify the error message for empty search textfield
		String errorMessageText = ExcelReader.getValue("ErrorMessageText");
		String getActualErrorMesssage = eo.getText(driver, "Xpath", "searchButtonErrorMessageXpath");
		if (errorMessageText.equalsIgnoreCase(getActualErrorMesssage)) {
			addComment("Successfully verified the error message for empty value in the search textfield::" + getActualErrorMesssage);
		} else {
			throw new POMMethodExecException("Unable to verify the error message for empty value in the search textfield");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyErrorMessageForInvalidKeyword
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the error message for search textfield with
	 * invalid keywords
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

	public void verifyErrorMessageForInvalidKeyword(WebDriver driver) throws Exception {

		// To verify the error message
		String searchKeyword = ExcelReader.getValue("SearchKeywordName");
		String allSearchKeyword[] = searchKeyword.split(";");
		int count = 0;
		for (int i = 0; i < allSearchKeyword.length; i++) {
			eo.enterText(driver, "Xpath", "searchKeywordTextfieldXpath", allSearchKeyword[i]);
			eo.clickElement(driver, "Xpath", "searchButtonXpath");
			String errorMessageText = ExcelReader.getValue("ErrorMessageText");
			String allErrorMessageText[] = errorMessageText.split(";");
			String getActualErrorMesssage = eo.getText(driver, "Xpath", "searchInvalidErrorMessageXpath");
			if (allErrorMessageText[count].equalsIgnoreCase(getActualErrorMesssage)) {
				addComment("Successfully verified the error message for invalid value in the search textfield ::" + getActualErrorMesssage);
				eo.cleardata(driver, "Xpath", "searchKeywordTextfieldXpath");
				count++;
			}
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCartButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click and verify the cart button
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
	public void clickOnCartButton(WebDriver driver) throws Exception {

		// To click on the category
		eo.clickElement(driver, "Xpath", "megaLabelXpath");
		addComment("Successfully clicked on the women category");

		// To click on the Trousers & Leggings label
		eo.clickElement(driver, "Xpath", "jeansLabelXpath");
		addComment("Successfully clicked on the trousersAndLeggings label");

		// To click on the product
		eo.clickElement(driver, "Xpath", "productXpath");
		addComment("Successfully clicked on the product");

		String sizeValue = ExcelReader.getValue("SizeValue");
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizesXpath", curApp)));
		String allElementsInUI1[] = new String[allElements.size()];
		int count1 = 0;
		for (WebElement element : allElements) {
			allElementsInUI1[count1] = element.getAttribute("value");
			if (allElementsInUI1[count1].equalsIgnoreCase(sizeValue)) {
				// To click on brand
				element.click();
				addComment("Successfully clicked on brand :" + sizeValue);
				break;
			}
		}

		// To verify that mycart icon is displayed
		eo.clickElement(driver, "Xpath", "addToMyBagXpath");
		addComment("Successfully clicked on the ad to my bag buton");

		// To check add to my cart
		eo.clickElement(driver, "Xpath", "myCartButonXpath");
		addComment("Successfully clicked on the my card button");

		// To verify the navgated page
		eo.verifyElementIsDisplayed(driver, "Xpath", "CheckOutHistoryXpath");
		addComment("Successfully navigated to the checkout summary");

		// To click on the cancel button
		eo.clickElement(driver, "Xpath", "deleteButtonXpath");
		addComment("Successfully clicked on the cancel button");

		// To navigate to back page
		driver.navigate().back();
		addComment("Successfully navigated to the main page");

		eo.clickElement(driver, "Xpath", "myCartButonXpath");
		addComment("Succesfully clicked on the cart button");

		eo.verifyElementIsDisplayed(driver, "Xpath", "noCartProductLabelXpath");
		addComment("Successfully verified the no my products in my cart label");

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyMegaMenuLabelInLouisPhilippePages
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the mega menu labels and categories
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

	public void verifyMegaMenuLabelInLouisPhilippePages(WebDriver driver) throws Exception {

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

		/*Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("newArrivalLabelXpath", curApp)));
		action.moveToElement(ele).build().perform();
		List<WebElement> allNewArrivalSubCategory = driver.findElements(By.xpath(GetElementIdentifier.getProperty("newArrivalsXpath", curApp)));
		for (WebElement element : allNewArrivalSubCategory) {
			addComment("Successfully verified the  new arival sub categories" + element.getText());
			eo.wait(5000);
		}

		Actions action1 = new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath(GetElementIdentifier.getProperty("menCategoryXpath", curApp)));
		action1.moveToElement(ele1).build().perform();
		List<WebElement> allMenSubCategory = driver.findElements(By.xpath(GetElementIdentifier.getProperty("menSubCategoryXpath", curApp)));
		for (WebElement element1 : allMenSubCategory) {
			addComment("Successfully verified the  men sub categories" + element1.getText());
			eo.wait(5000);
		}

		Actions action2 = new Actions(driver);
		WebElement ele2 = driver.findElement(By.xpath(GetElementIdentifier.getProperty("collectionLabelXpath", curApp)));
		action2.moveToElement(ele2).build().perform();
		List<WebElement> allCollectionCategory = driver.findElements(By.xpath(GetElementIdentifier.getProperty("collectionXpath", curApp)));
		for (WebElement element2 : allCollectionCategory) {
			addComment("Successfully verified the  collection sub categories" + element2.getText());
			eo.wait(5000);
		}

		Actions action3 = new Actions(driver);
		WebElement ele3 = driver.findElement(By.xpath(GetElementIdentifier.getProperty("brandStoryXpath", curApp)));
		action3.moveToElement(ele3).build().perform();
		List<WebElement> allBrandStorySubCategory = driver.findElements(By.xpath(GetElementIdentifier.getProperty("brandStorySubCategoryXpath", curApp)));
		for (WebElement element3 : allBrandStorySubCategory) {
			addComment("Successfully verified the  brand sub categories" + element3.getText());
			eo.wait(5000);
		}
		Actions action4 = new Actions(driver);
		WebElement ele4 = driver.findElement(By.xpath(GetElementIdentifier.getProperty("saleLabelXpath", curApp)));
		action4.moveToElement(ele4).build().perform();
		List<WebElement> allSaleLabelCategory = driver.findElements(By.xpath(GetElementIdentifier.getProperty("saleSubCategoryXpath", curApp)));
		for (WebElement element4 : allSaleLabelCategory) {
			addComment("Successfully verified the  sale sub categories" + element4.getText());
			eo.wait(5000);
		}*/

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifySubCategoryNavigationPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the mega menu labels and categories
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
	public void verifySubCategoryNavigationPage(WebDriver driver) throws Exception {
		/*String megaMenuLabelName = ExcelReader.getValue("MegaMenuLabelName");
		String megaMenuValue = GetElementIdentifier.getProperty("megaMenuXpath", curApp);
		megaMenuValue = megaMenuValue.replace("{replaceText}", megaMenuLabelName);
		WebElement element = driver.findElement(By.xpath(megaMenuValue));
		// To verify the
		String fontWeight = element.getCssValue("font-weight");
		String textdecoration = element.getCssValue("text-decoration");
		if (textdecoration.equals("underline") || fontWeight.equals("bold")) {
			addComment("Successfully verfied the label " + megaMenuLabelName);
		} else {
			throw new POMMethodExecException("Unable to verify the label");
		}*/
		// text-decoration: underline;
		// font-weight: bold;
		String megaMenuLabelName1 = ExcelReader.getValue("MegaMenuLabelName1");
		String megaMenuValue1 = GetElementIdentifier.getProperty("megaMenuXpath", curApp);
		megaMenuValue1 = megaMenuValue1.replace("{replaceText}", megaMenuLabelName1);
		// String tempSelectUserDropDownXpath =
		// GetElementIdentifier.getProperty("selectUserDropDownXpath",
		// "MyAddressPage");
		// String replaceTempSelectUserDropDownXpath =
		// tempSelectUserDropDownXpath.replace("{replace}", megaMenuLabelName1);
		WebElement option = driver.findElement(By.xpath(megaMenuValue1));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", option);
		addComment("Clicked on users drop down menu is: " + megaMenuLabelName1);

		WebElement element1 = driver.findElement(By.xpath(megaMenuValue1));
		String fontWeight1 = element1.getCssValue("font-weight");
		String textdecoration1 = element1.getCssValue("text-decoration");
		if (textdecoration1.equalsIgnoreCase("underline") || fontWeight1.equalsIgnoreCase("bold")) {
			addComment("Successfully verfied the label " + megaMenuLabelName1);
		} else {
			throw new POMMethodExecException("Unable to verify the label");
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> selectLeftNavigation
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to select the left navigation option in category
	 * page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * <p>
	 * <b>Arguments:</b> SortBy : Used to click on particular option
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */

	public void selectLeftNavigation(WebDriver driver) throws Exception {

		String sortBy = ExcelReader.getValue("SortBy");
		try {
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("leftNavigationXpath", curApp)));

		String allElementsInUI = "";
		for (WebElement element : allElements) {
			allElementsInUI = element.getText();
			if (allElementsInUI.equalsIgnoreCase(sortBy)) {
				element.click();
				addComment("Successfully clicked on " + sortBy);
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not click on "+sortBy ,e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> selectBrandAndVerify
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to select the Brand option page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * <p>
	 * <b>Arguments:</b> SelectBrand : Used to click on particular brand
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */

	public void selectBrandAndVerify(WebDriver driver) throws Exception {

		String selectBrand = ExcelReader.getValue("SelectBrand");
		String allElementsInUI = "";
		
		try {
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("selectBrandXpath", curApp)));
		for (WebElement element : allElements) {
			allElementsInUI = element.getText();
			if (allElementsInUI.contains(selectBrand)) {
				element.click();
				addComment("Successfully clicked on " + selectBrand);
				break;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not click on "+selectBrand,e);
		}
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			 pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "selectedBrandXpath");
			if (pageStatus) {
				String text = eo.getText(driver, "XPath", "selectedBrandXpath");
				if (text.contains(selectBrand)) {
					addComment("Louis Philippe page is displayed ");
					break;
				} else {
					throw new POMMethodExecException("Selected brand is not displayed");
				}
			}
		}
		if(!pageStatus){
			throw new POMMethodExecException("Could not veri the brand selected");
		}

		try {
		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allBrandXpath", curApp)));

		int count1 = 0;
		for (WebElement element : allElements1) {
			allElementsInUI = element.getText();
			if (allElementsInUI.equalsIgnoreCase(selectBrand)) {
				addComment("Image " + count1 + " is displayed with slected brand:" + selectBrand);
				count1++;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not verify selected brand"+selectBrand,e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForBuyNowFuctionality
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to verify the buy now functionality page
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
	
	
	public void verifyProductPage (WebDriver driver) throws Exception {
		eo.verifyElementIsDisplayed(driver, "XPath", "detailedViewXpath");
		addComment("Detailed View is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "fronBackViewXpath");
		addComment("front Back View is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "productHeaderXpath");
		addComment("Product header is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "brandLogoXpath");
		addComment("Brand logo is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "colorOptionXpath");
		addComment("Color Option is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "sizeOptionXpath");
		addComment("Size Option is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "productPrice");
		addComment("Product Price is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "returnXpath");
		addComment("30 days return link is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "freeShippingXpath");
		addComment("All India FREE Shipping link is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "productDescriptionXpath");
		addComment("Product Description is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "buyNowButtonXpath");
		addComment("Buy Now Button is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "addToBagXpath");
		addComment("Add to my Bag Button is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "closeButtonXpath");
		addComment("Close icon is displayed");

//		eo.verifyElementIsDisplayed(driver, "XPath", "recomendedProductsXpath");
//		addComment("Recomended Products is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "similarProductsXpath");
		addComment("Similar Products are displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "productFeatureXpath");
		addComment("Product Feature is displayed");

	}

//	public void verifyForBuyNowFuctionality(WebDriver driver) throws Exception {
//
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "detailedViewXpath");
//		addComment("Detailed View is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "fronBackViewXpath");
//		addComment("front Back View is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "productHeaderXpath");
//		addComment("Product header is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "brandLogoXpath");
//		addComment("Brand logo is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "colorOptionXpath");
//		addComment("Color Option is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "sizeOptionXpath");
//		addComment("Size Option is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "Id", "productPrice");
//		addComment("Product Price is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "returnXpath");
//		addComment("30 days return link is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "freeShippingXpath");
//		addComment("All India FREE Shipping link is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "productDescriptionXpath");
//		addComment("Product Description is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "Id", "buyNowButtonXpath");
//		addComment("Buy Now Button is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "Id", "addToBagXpath");
//		addComment("Add to my Bag Button is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "closeButtonXpath");
//		addComment("Close icon is displayed");
//
////		eo.verifyElementIsDisplayed(driver, "XPath", "recomendedProductsXpath");
////		addComment("Recomended Products is displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "similarProductsXpath");
//		addComment("Similar Products are displayed");
//
//		eo.verifyElementIsDisplayed(driver, "XPath", "productFeatureXpath");
//		addComment("Product Feature is displayed");
//
//		
//		try {
//		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizesXpath", curApp)));
//
//		String allElementsInUI = "";
//		for (WebElement element : allElements) {
//			allElementsInUI = element.getAttribute("value");
//			element.click();
//			addComment("Successfully clicked on size :" + allElementsInUI);
//			break;
//		}
//		} catch(Exception e){
//			throw new POMMethodExecException("Could not click on size",e);
//		}
//		
//		String selectedSizeMessage = "piece(s) available";
//		String text = eo.getText(driver, "Id", "lastStockXpath");
//		if (text.contains(selectedSizeMessage)) {
//			addComment("Stock available message is displayed: " + text);
//		} else {
//			throw new POMMethodExecException("Stock message is not displayed");
//		}
//
//		eo.clickElement(driver, "Id", "buyNowButtonXpath");
//		addComment("Buy Now Button is clicked");
//		eo.wait(4000);
//		eo.verifyElementIsDisplayed(driver, "XPath", "yourShoppingBagXpath");
//		addComment("your Shopping Bag page is displayed ");
//
//		driver.navigate().back();
//
//		try {
//		List<WebElement> allElements2 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizesXpath", curApp)));
//
//		String allElementsInUI2 = "";
//		for (WebElement element : allElements2) {
//			allElementsInUI2 = element.getAttribute("value");
//			element.click();
//			addComment("Successfully clicked on size :" + allElementsInUI2);
//			break;
//		}
//		} catch(Exception e){
//			throw new POMMethodExecException("Could not click on size",e);
//		}
//		eo.clickElement(driver, "Id", "addToBagXpath");
//		addComment("Add to my Bag Button is clicked");
//
//		String text2 = eo.getText(driver, "XPath", "cartValueXpath");
//		addComment("Cart value is :" + text2);
//
//	}
	
	
	public void verifyCartValue(WebDriver driver) throws Exception {
		
		String actualCartValue = eo.getText(driver, "XPath", "cartValueXpath");
		addComment("Cart value after add to bag :" + actualCartValue);
		int cartValue = Integer.parseInt(actualCartValue);
		if (cartValue > 0) {
			addComment("Cart value is increased after added to the bag");
		} else {
			throw new POMMethodExecException("Cart value is not increased");
		}
//		String text2 = eo.getText(driver, "XPath", "cartValueXpath");
//		addComment("Cart value is :" + text2);
		
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForLouisPhilippeBrandLogo
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to verify the brand logo page
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

	public void verifyForLouisPhilippeBrandLogo(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		try{
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("adityaBirlaImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		} catch(Exception e){
			throw new POMMethodExecException("Could not verify the aditya birla image",e);
		}
		eo.verifyElementIsDisplayed(driver, "XPath", "louisBrandLogoXPath");
		addComment("Louis Brand Logo is diaplayed instead of Shop by brand");
		

	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyTopButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to click top button page
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

	public void verifyTopButton(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		try{
			eo.wait(2000);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("adityaBirlaImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		} catch(Exception e){
			throw new POMMethodExecException("Could not verify the aditya birla image",e);
		}

		// To verify top button
		eo.clickElement(driver, "Xpath", "topButtonXpath");
		addComment("Top button is clicked");

		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			 pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "louisphilippeHeaderPageXpath");
			if (pageStatus) {
				addComment("Louis Philippe page is displayed ");
				break;
			}
		}
		if(!pageStatus){
			throw new POMMethodExecException("Could not verify the louis home page");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyFooterLinks
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to verify the footer link page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * <p>
	 * <b>Arguments:</b> LinkToClick : Used to click on particular link
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */

	public void verifyFooterLinks(WebDriver driver) throws Exception {

		String linkToClick = ExcelReader.getValue("LinkToClick");
		eo.wait(5000);
		try {
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("footerLinkXpath", curApp)));
		String allElementsInUI = "";
		for (WebElement element : allElements) {
			allElementsInUI = element.getText();
			if (allElementsInUI.contains(linkToClick)) {
				element.click();
				addComment("Successfully clicked on link :" + linkToClick);
				break;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not click on footer link",e);
		}
		String windowTitle = driver.getTitle();
		addComment("Successfully navigated to " + windowTitle + " page");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForBuyNowInQuickViewFuctionality
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to verify the buy now fuctionality in Quick view
	 * page
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

	public void clickOnQuickViewAndVerifyPage(WebDriver driver) throws Exception {

		Random random = new Random();
		int randomNumber = random.nextInt(1);
		randomNumber = randomNumber + 1;
		try {
		eo.wait(3000);
		List<WebElement> allElements3 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allBrandXpath", curApp)));
		for (int i = 0; i < allElements3.size();) {
			String brandXpath = GetElementIdentifier.getProperty("brandXpath", curApp);
			brandXpath = brandXpath.replace("{i}", String.valueOf(randomNumber));
			Actions action = new Actions(driver);
			eo.wait(5000);
			String quickViewXpath1 = GetElementIdentifier.getProperty("quickViewXpath1", curApp);
			quickViewXpath1 = quickViewXpath1.replace("{i}", String.valueOf(randomNumber));
			System.out.println("The xpath: " + quickViewXpath1);
			WebElement mouseElement = driver.findElement(By.xpath(quickViewXpath1));
			action.moveToElement(mouseElement).build().perform();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", mouseElement);
			break;
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not click on product",e);
		}

		driver.switchTo().frame(0);
		eo.wait(3000);
		eo.verifyElementIsDisplayed(driver, "Id", "detailedViewInQuick");
		addComment("Detailed View is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "productHeaderXpath");
		addComment("Product header is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "brandLogoXpath");
		addComment("Brand logo is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "colorOptionXpath");
		addComment("Color Option is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "sizeOptionXpath");
		addComment("Size Option is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "productPrice");
		addComment("Product Price is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "returnXpath");
		addComment("30 days return link is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "freeShippingXpath");
		addComment("All India FREE Shipping link is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "buyNowButtonXpath");
		addComment("Buy Now Button is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "addToBagXpath");
		addComment("Add to my Bag Button is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "rightlink");
		addComment("Right navigation is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "viewDetailsLinkXpath");
		addComment("View more details link is displayed");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnMegaMenuBar
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to click on mega menu bars page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * <p>
	 * <b>Arguments:</b> MegaMenuBarsToClick : Used to click on particular mega
	 * menu
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */

	public void clickOnMegaMenuBar(WebDriver driver) throws Exception {

		String megaMenuBarsToClick = ExcelReader.getValue("MegaMenuBarsToClick");
		try{
		List<WebElement> allAddresses = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allMenuMegaBarXpath", curApp)));
		for (WebElement element : allAddresses) {
			String allElementsUI = element.getText();
			if (allElementsUI.contains(megaMenuBarsToClick)) {
				element.click();
				addComment("Successfully clciked on " + megaMenuBarsToClick);
				break;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not click on mega menu",e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> selectCategoriesOptionAndVerify
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to select the category option product page page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <li>SelectCategory : Used to select the category</li>
	 * <li>Brand : Used to verify the label</li>
	 * <li>Brand1 : Used to verify the label</li>
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */

	public void selectCategoriesOptionAndVerify(WebDriver driver) throws Exception {

		String selectCategory = ExcelReader.getValue("SelectCategory");
		String brand = ExcelReader.getValue("Brand");
		String brand1 = ExcelReader.getValue("Brand1");
		try {
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("categoriesXpath", curApp)));

		String allElementsInUI[] = new String[allElements.size()];
		int count = 0;
		for (WebElement element : allElements) {
			allElementsInUI[count] = element.getText();
			if (allElementsInUI[count].contains(selectCategory)) {
				element.click();
				addComment("Successfully clicked on " + selectCategory);
				break;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not click on category",e);
		}

		for (int i = 0; i <= 5000; i++) {
			boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "subCategorySelectedXpath");
			if (pageStatus) {
				String text = eo.getText(driver, "XPath", "subCategorySelectedXpath");
				if (text.equalsIgnoreCase(selectCategory)) {
					addComment("Category page is displayed ");
					break;
				} else {
					throw new POMMethodExecException("Selected Category is not displayed");
				}
			}
		}
		
		try {
		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("brandLabelXpath", curApp)));

		String allElementsInUI1[] = new String[allElements1.size()];
		int count1 = 0;
		for (WebElement element : allElements1) {
			allElementsInUI1[count1] = element.getText();
			if (allElementsInUI1[count1].equalsIgnoreCase(brand) || allElementsInUI1[count1].contains(brand1)) {
				addComment("Image " + count1 + " is displayed with brand:" + allElementsInUI1[count1]);
				count1++;
			}
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not verify the brand label",e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyForViewMoreProducts
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Used to verify view more products functionality page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <li>Brand : Used to verify the label</li>
	 * <li>Brand1 : Used to verify the label</li>
	 * </p>
	 * 
	 * @author :Kavya p
	 *
	 * 
	 */

	public void verifyForViewMoreProducts(WebDriver driver) throws Exception {

		String brand1 = ExcelReader.getValue("Brand1");
		String brand2 = ExcelReader.getValue("Brand2");

		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allBrandXpath", curApp)));

		int allElementsInUI = allElements.size();
		addComment("Brands before clicking on view more produts :" + allElementsInUI);

		eo.clickElement(driver, "XPath", "viewMoreProductsXpath");
		addComment("Successfully clicked on view more products");
		eo.wait(2000);

		try {
		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allBrandXpath", curApp)));

		int allElementsInUI1 = allElements1.size();
		List<WebElement> allElements3 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("brandLabelXpath", curApp)));
		addComment("Brands after clicking on view more produts :" + allElements3.size());
		if (allElementsInUI1 > allElementsInUI) {
			String allElementsInUI3 = "";
			int count1 = 0;
			for (WebElement element : allElements3) {
				allElementsInUI3 = element.getText();
				if (allElementsInUI3.equalsIgnoreCase(brand1) || allElementsInUI3.contains(brand2)) {
					addComment("Image " + count1 + " is displayed with brand:" + allElementsInUI3);
					count1++;
				}
			}
		} else {
			throw new POMMethodExecException("View more products is not displaying the more products");
		}
		} catch(Exception e){
			throw new POMMethodExecException("Could not verify the brand label",e);
		}

	}

	/**
	  * <p>
	  * <b>Method Name:</b> verifyGridsFuctionality
	  * </p>
	  * 
	  * <p>
	  * <b>Description:</b> Used to verify Grids Fuctionality page
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

	 public void verifyGridsFuctionality(WebDriver driver) throws Exception {

	  eo.clickElement(driver, "Xpath", "searchKeywordTextfieldXpath");
	  eo.wait(2000);
	  
	  eo.clickElement(driver, "Xpath", "grid1Xpath");
	  addComment("Successfully clicked on the grid1");
	  
	  List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("grid2Xpath", curApp)));

	  for (WebElement element : allElements) {
	   element.click();
	   addComment("Successfully clicked on grid 2");
	   break;
	  }

	  eo.verifyElementIsDisplayed(driver, "XPath", "grid3Xpath");
	  addComment("Successfully verified for grid 3");

	  eo.clickElement(driver, "XPath", "grid3Xpath");
	  addComment("Successfully clicked on grid 3");

	  eo.wait(2000);
	  /*pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "selectedBrandXpath");
	  if (pageStatus) {
	   String text = eo.getText(driver, "XPath", "selectedBrandXpath");
	   addComment("Successfully navigated to the brand page :" + text);
	  }
	  if(!pageStatus){
	   throw new POMMethodExecException("Brand selected is not displayed");
	  }*/

	  driver.navigate().back();

	  eo.clickElement(driver, "XPath", "grid4Xpath");
	  addComment("Successfully clicked on grid 4");

	  String oldTab = driver.getWindowHandle();
	  ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	  newTab.remove(oldTab);
	  String title = driver.switchTo().window(newTab.get(0)).getTitle();

	  if (title.contains("Label")) {
	   addComment("Successfully navigated to Third party page");
	  } else {
	   throw new POMMethodExecException("Could not navigated to Third party page");
	  }
	 }
}
