package com.trendin.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.trendin.core.ElementOperation;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.Utility;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class CategoryModulePage extends TrendInTestSuite {
	final String curApp = "CategoryModulePage";
	ElementOperation eo = new ElementOperation(curApp);

	/**
	 * <p>
	 * <b>Method Name:</b> selectMainCategoryLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> This method is used to Select the Main Category Link
	 * (Header link)
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page.
	 * </p>
	 * <p>
	 * <b>Parameters: </b> <b> driver: Webdriver object </b> <b> categoryName:
	 * Main category name to select </b>
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void selectMainCategoryLink(WebDriver driver, String categoryName) throws Exception {
		try {
			String tempHeaderLinksXpath = GetElementIdentifier.getProperty("headerLinksXpath", curApp);
			String replaceTempHeaderLinksXpath = tempHeaderLinksXpath.replace("{replaceHeaderLinkName}", categoryName);
			driver.findElement(By.xpath(replaceTempHeaderLinksXpath)).click();
			addComment("Successfully selected the Main Category link : " + categoryName);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to select the Main Category link: " + categoryName, e);
		}
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> selectLevel2CategoryLink
	 * </p>
	 * <p>
	 * <b>Description:</b> This method is used to Select the Level 2 Category Link (Sub category link)
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page. >> Selecte the Main category link
	 * </p>
	 * <p>
	 * <b>Parameters: </b> 
	 * <b> driver: Webdriver object </b> 
	 * <b> level2CategoryName: Sub category name to select </b>
	 * </p>
	 * @author : Sowmya H M
	 *
	 */
	public void selectLevel2CategoryLink(WebDriver driver, String level2CategoryName) throws Exception {
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("itemsXpath", curApp)));
		String allElementsInUI[] = new String[allElements.size()];
		int count1 = 0;
		for (WebElement element : allElements) {
			try {
				allElementsInUI[count1] = element.getText();
				if (allElementsInUI[count1].equalsIgnoreCase(level2CategoryName)) {
					element.click();
					addComment("Successfully clicked on Item :" + level2CategoryName);
					break;
				}
			} catch (Exception e) {
				throw new POMMethodExecException("Not able to select the Level 2 Category link: " + level2CategoryName, e);
			}
		}
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnProductCategory
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on particular product category randomly.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public String clickOnProductCategory(WebDriver driver) throws Exception {
		String selectedProductTitle = "";
		Utility.waitUntilExists(driver, "XPath", "sortOrderLabelXpath", curApp);
		// To generate random number.
		Random random = new Random();
		int randomNumber = random.nextInt(1);
		randomNumber = randomNumber + 1;
		addComment("Generated random number is : " + randomNumber);
		List<WebElement> allProductItems = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allProductCategoryXpath", curApp)));
		addComment("List of all product elements size is : " + allProductItems.size());
		String tempProductCategoryXpath = GetElementIdentifier.getProperty("productCategoryXpath", curApp);
		for (int i = 0; i < allProductItems.size(); i++) {
			if (randomNumber <= allProductItems.size()) {
				tempProductCategoryXpath = tempProductCategoryXpath.replace("{i}", String.valueOf(randomNumber));
				try {
					selectedProductTitle = driver.findElement(By.xpath(tempProductCategoryXpath)).getAttribute("title");
					driver.findElement(By.xpath(tempProductCategoryXpath)).click();
					addComment("Clicked on Particular product category.");
					break;
				} catch (Exception e) {
					throw new POMMethodExecException("Unable to select random product category.", e);
				}
			}
		}
		return selectedProductTitle;
	}
	
	
	/**
	 * 
	 * <p>
	 * <b>Method Name:</b> verifySubCategoriesOptions
	 * </p>
	 * <p>
	 * <b>Description:</b> Used to Verify the Sub-categories options
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Any main category should be selected
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>driver:</b> Webdriver object</li>
	 * <li><b>subCategoriesName:</b> All sub-categories to verify, seperated by
	 * ';' if more than one</li>
	 * </ul>
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void verifySubCategoriesOptions(WebDriver driver, String subCategoriesName) throws Exception {
		String[] splitSubCategoriesName = subCategoriesName.split(";");
		List<WebElement> allSubCategories = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allCategoryXpath", curApp)));
		addComment("Number of sub-Categories: " + allSubCategories.size());
		if (allSubCategories.size() >= 1) {
			String tempMenCategoriesXpath = GetElementIdentifier.getProperty("categoryTypesXpath", curApp);
			String replaceTempMenCategoriesXpath = "";
			boolean subCategoryDisplayStatus = false;
			for (int i = 0; i < allSubCategories.size(); i++) {
				replaceTempMenCategoriesXpath = tempMenCategoriesXpath.replace("{ReplaceCategory}", splitSubCategoriesName[i]);
				try {
					subCategoryDisplayStatus = driver.findElement(By.xpath(replaceTempMenCategoriesXpath)).isDisplayed();
				} catch (Exception e) {
					throw new POMMethodExecException("Not able get the Sub-Category option webelement: " + splitSubCategoriesName[i], e);
				}
				assertTrue(subCategoryDisplayStatus, "Displayed sub-category : " + splitSubCategoriesName[i], "Didn't Displayed sub-category : " + splitSubCategoriesName[i]);
			}
			addComment("All Sub categories are displayed.");
		} else {
			throw new POMMethodExecException("Sub-categories are not displayed.! ");
		}
	}


	// To verify order history page.
	public void verifyOrderHistoryPage(WebDriver driver, String orderHistoryTabs) throws Exception {
		List<WebElement> allOrderHistoryTab = driver.findElements(By.xpath(GetElementIdentifier.getProperty("orderHistoryTabsXpath", curApp)));
		String[] splitOrderHistoryTabs = orderHistoryTabs.split(";");
		for (int i = 0; i < allOrderHistoryTab.size(); i++) {
			if (splitOrderHistoryTabs[i].equalsIgnoreCase("")) {

			}
		}
	}

	/**
	 * 
	 * <p>
	 * <b>Method Name: mouseHoverOnHeaderLinksType</b>
	 * </p>
	 * <p>
	 * <b>Description: To hover the mouse and get the desired category
	 * overlay</b>
	 * </p>
	 * <p>
	 * <b>Dependencies: Browser.Launch - > Home page.</b>
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>driver: </b> Webdriver object</li>
	 * <li><b>categoryName: </b> Category name (option) on which mouse hover
	 * should be done</li>
	 * </ul>
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void mouseHoverOnHeaderLinksType(WebDriver driver, String categoryName) throws Exception {
		try {
			String tempHeaderLinksXpath = GetElementIdentifier.getProperty("headerLinksXpath", curApp);
			String replaceTempHeaderLinksXpath = tempHeaderLinksXpath.replace("{replaceHeaderLinkName}", categoryName);
			Actions action = new Actions(driver);
			// Waits until the 'Secure Payment' header page is loaded
			Utility.waitUntilExists(driver, "XPath", "trendInMainLogoXpath", curApp);
			WebElement mouseElement = driver.findElement(By.xpath(replaceTempHeaderLinksXpath));
			action.moveToElement(mouseElement).build().perform();
			addComment("Mouse Hover on Header link type : " + categoryName);
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to perform mouse hover  on Header Link types.", e);
		}
	}

	// To Click on Secure Payment Icon
	/**
	 * 
	 * <p>
	 * <b>Method Name:</b> selectBusinessOptionsInMainCategoryOverlay
	 * </p>
	 * <p>
	 * <b>Description:</b> Used to select the Business repated options under the
	 * Main Category overlay, Ex: Easy Returns, 24*7 Support, Free Shipping etc
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Mouse hover on any one of the main Category
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>driver: </b> Webdriver object</li>
	 * <li><b>mainCategoryName: </b> Main category name on which mouse hover is
	 * done</li>
	 * <li><b>businessOptionToSelect: </b> Option to be selected in the overlay
	 * (any one option)</li>
	 * </ul>
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void selectBusinessOptionsInMainCategoryOverlay(WebDriver driver, String mainCategoryName, String businessOptionToSelect) throws Exception {
		String securePaymentIconXpath = GetElementIdentifier.getProperty("businessIconXpath", curApp);
		securePaymentIconXpath = securePaymentIconXpath.replace("{categoryName}", mainCategoryName);
		securePaymentIconXpath = securePaymentIconXpath.replace("{optionName}", businessOptionToSelect);
		try {
			driver.findElement(By.xpath(securePaymentIconXpath)).click();
			addComment("Successfully clicked on the option: " + businessOptionToSelect + ", of the Category: " + mainCategoryName);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to click the Option: " + businessOptionToSelect, e);
		}

	}

	// To Verify Secure Payment Icon under New Arrival menu
	/**
	 * <p>
	 * <b>Method Name:</b> verifySecurePaymentSection
	 * </p>
	 * <p>
	 * <b>Description:</b> To verify 'Secure Payment' section
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page.
	 * </p>
	 * 
	 * @author :Sowmya H M.
	 *
	 */
	public void verifySecurePaymentSection(WebDriver driver) throws Exception {
		// Waits until the 'Secure Payment' header page is loaded
		Utility.waitUntilExists(driver, "XPath", "securePaymentHeaderXpath", curApp);

		// Verifies the 'Secure Payment' header text in the Why Trendin? page
		String securePaymentHeader = eo.getText(driver, "Xpath", "securePaymentHeaderXpath");
		addComment("Secure payment text displayed in UI: " + securePaymentHeader);
		assertTrue(securePaymentHeader.equalsIgnoreCase("Secure Payment") == true, "Successfully verified the header : " + securePaymentHeader, "Not able to verify the Header");

		// Verify the Cards information is provided
		String cardsInfoHrefText[] = { "visa.jpg", "master.jpg", "statebank.jpg", "hdfc.jpg", "icici.jpg" };
		String srcValueOfImage = "";
		String cardsInfoImagesXpath = GetElementIdentifier.getProperty("cardsInfoImagesXpath", curApp);
		String tempXpath = "";
		for (int cards = 0; cards < cardsInfoHrefText.length; cards++) {
			tempXpath = cardsInfoImagesXpath.replace("{count}", String.valueOf(cards + 1));
			try {
				srcValueOfImage = driver.findElement(By.xpath(tempXpath)).getAttribute("src");
			} catch (Exception e) {
				throw new POMMethodExecException("Not able to get the SRC attribute of the payment image: " + cardsInfoHrefText[cards], e);
			}
			assertTrue(srcValueOfImage.trim().contains(cardsInfoHrefText[cards]), "Card: " + cardsInfoHrefText[cards] + ", is displayed", "Card: " + cardsInfoHrefText[cards] + ", is not displayed");
		}
		addComment("All the Transaction Payment cards are displayed in Secure Payment section.");
	}

	// To Verify Alteration Page display
	/**
	 * <p>
	 * <b>Method Name:</b> verifyAlterationPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Alteration Page display and other Elements
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page.
	 * </p>
	 * 
	 * @author :Sowmya H M.
	 *
	 */
	public void verifyAlterationPage(WebDriver driver) throws Exception {

		// Waits until the 'Alteration' bread crumb element is loaded
		Utility.waitUntilExists(driver, "XPath", "alterationBreadCrumbTextXpath", curApp);

		// To verify the title of Alterations page
		String pageTitle = "";
		try {
			pageTitle = driver.getTitle();
			addComment("Alteration page Title displayed in UI: " + pageTitle);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to get the Alteration page title", e);
		}
		assertTrue(pageTitle.trim().equals("Alteration"), "'Alteration' page title is as expected.", "'Alteration' page title is not as expected.");

		// Verify the 'HOME' bread crumb is displayed in the page
		boolean homeBreadCrumb = eo.verifyElementIsDisplayed(driver, "XPath", "homeBreadCrumbTextXpath");
		assertTrue(homeBreadCrumb, "'HOME' bread crumb is displayed", "'HOME' bread crumb is not displayed");

		// Verify the H3 text - "Get FREE TROUSER LENGTH ALTERATIONS ON
		// TRENDIN.COM" is displayed
		boolean h3TextDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "h3LabelInAlterationPageXpath");
		assertTrue(h3TextDisplayed, "H3 label- 'Get FREE TROUSER LENGTH ALTERATIONS ON TRENDIN.COM' is displayed", "H3 label-'Get FREE TROUSER LENGTH ALTERATIONS ON TRENDIN.COM' is not displayed");

		// Verify the 'Find your Nearest Store:' label
		boolean findYourNearestLabel = eo.verifyElementIsDisplayed(driver, "XPath", "findYourNearestStoreTextXpath");
		assertTrue(findYourNearestLabel, "'Find your Nearest Store:' label is displayed", "'Find your Nearest Store:' label is not displayed");

		// verify the 'State' selection drop down menu is displayed
		boolean selectStateDropDown = eo.verifyElementIsDisplayed(driver, "XPath", "selectStateDropDownXpath");
		assertTrue(selectStateDropDown, "Select State drop down is displayed", "Select State drop down is not displayed");

		// verify the 'City' selection drop down menu is displayed
		boolean selectCityDropDown = eo.verifyElementIsDisplayed(driver, "XPath", "selectCityDropDownXpath");
		assertTrue(selectCityDropDown, "Select City drop down is displayed", "Select city drop down is not displayed");

		// verify the 'Locate Store' button is displayed
		boolean locateStoreBtn = eo.verifyElementIsDisplayed(driver, "XPath", "locateStoreBtnXpath");
		assertTrue(locateStoreBtn, "Locate Store Button is displayed", "Locate Store Button is not displayed");
	}

	// To Verify select State and select city drop down and Locate store button
	// in Alteration Page
	/**
	 * <p>
	 * <b>Method Name:</b> verifyelementsInAlterationPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify select State and select city drop down and
	 * Locate store button in Alteration Page
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page.
	 * </p>
	 * 
	 * @author :Sowmya H M.
	 *
	 */
	public void verifyelementsInAlterationPage(WebDriver driver) throws Exception {

		eo.wait(3000);
		boolean selectStateDropDown = eo.verifyElementIsDisplayed(driver, "XPath", "selectStateDropDownXpath");
		assertTrue(selectStateDropDown, "Select State drop down is displayed", "Select State drop down is not displayed");

		boolean selectCityDropDown = eo.verifyElementIsDisplayed(driver, "XPath", "selectCityDropDownXpath");
		assertTrue(selectCityDropDown, "Select City drop down is displayed", "Select city drop down is not displayed");

		boolean locateStoreBtn = eo.verifyElementIsDisplayed(driver, "XPath", "locateStoreBtnXpath");
		assertTrue(locateStoreBtn, "Locate Store Button is displayed", "Locate Store Button is not displayed");
	}

	// To Select State from select State drop down in Alteration Page
	/**
	 * <p>
	 * <b>Method Name:</b> selectStateFromSelectStateDropDown
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Select State from select State drop down in
	 * Alteration Page
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page -> Alteration Page
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyFunctionalityOfStoreLocator(WebDriver driver, String state, String city) throws Exception {

		// Waits until the 'Alteration' bread crumb element is loaded
		Utility.waitUntilExists(driver, "XPath", "alterationBreadCrumbTextXpath", curApp);

		// Select the State
		try {
			WebElement element = driver.findElement(By.xpath(GetElementIdentifier.getProperty("aboutUsFooterLinkXpath", curApp)));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			eo.selectComboBoxByVisibleText(driver, "XPath", "selectStateDropDownXpath", state);
			addComment("Successfully selected State : " + state);
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to Select state from select state drop down", e);
		}

		// Waits until the Locate Store button is displayed..
		Utility.waitUntilExists(driver, "XPath", "locateStoreBtnXpath", curApp);

		// Select the City drop down
		eo.selectComboBoxByVisibleText(driver, "XPath", "selectCityDropDownXpath", city);
		addComment("Successfully selected City : " + city);

		// Waits until the Locate Store button is displayed..
		Utility.waitUntilExists(driver, "XPath", "locateStoreBtnXpath", curApp);

		// Click on the 'Locate Store' button
		eo.clickElement(driver, "XPath", "locateStoreBtnXpath");
		addComment("Clicked on Locate Store button.");

		// Waits until the 'We found the following stores near you:' label is
		// displayed..
		Utility.waitUntilExists(driver, "XPath", "storesFoundLabelXpath", curApp);

		// Validate the Result after State and city is selected..
		List<WebElement> stores = driver.findElements(By.xpath(GetElementIdentifier.getProperty("storesAddressXpath", curApp)));
		addComment("Number of Stores located for the State: " + state + " , and City: " + city + " are: " + stores.size());
		if (stores.size() <= 0) {
			throw new POMMethodExecException("No Stores found for the State: " + state + " , and City: " + city);
		}
	}
	

}
