package com.trendin.pages;
import org.openqa.selenium.Dimension;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver; 

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class QuickViewPage extends TrendInTestSuite {
	final String curApp = "QuickViewPage";
	ElementOperation eo = new ElementOperation(curApp);	



	/**
	 * <p>
	 * <b>Method Name:</b> clickOnMegaMenuAndSelectItem
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on mega menu and to select item
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnMegaMenuAndSelectCategory(WebDriver driver) throws Exception {
		try {
			//To Click on Mega menu bars
			String megaMenuBarsToClick = ExcelReader.getValue("MegaMenuBarsToClick");
			List<WebElement> allAddresses = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allMenuMegaBarXpath", curApp)));
			for (WebElement element : allAddresses) {
				String allElementsUI = element.getText();
				if (allElementsUI.contains(megaMenuBarsToClick)) {
					element.click();
					addComment("Successfully clicked on " + megaMenuBarsToClick);
					break;
				}
			}

			//To Click on Item
			String itemToClick = ExcelReader.getValue("ItemToClick");
			List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("itemsXpath", curApp)));
			String allElementsInUI[] = new String[allElements.size()];
			int count1 = 0;
			for (WebElement element : allElements) {
				allElementsInUI[count1] = element.getText();
				if (allElementsInUI[count1].equalsIgnoreCase(itemToClick)) {
					// To click on Item
					element.click();
					addComment("Successfully clicked on Item :" + itemToClick);
					break;
				}
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to select mega menu and Item: ", e);
		}
	}

	//To Click on Quick View Button and to verify the pop up page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnQuickViewAndVerifyPopUpPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>To Click on Quick View Button and to verify the pop up page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnQuickViewAndVerifyPopUpPage(WebDriver driver) throws Exception {
		Random random = new Random();
		int randomNumber = random.nextInt(2);
		randomNumber = randomNumber + 1;
		List<WebElement> allElements3 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allBrandXpath", curApp)));
		for (int i = 0; i < allElements3.size();) {
			String brandXpath = GetElementIdentifier.getProperty("brandXpath", curApp);
			brandXpath = brandXpath.replace("{i}", String.valueOf(randomNumber));
			driver.findElement(By.xpath(brandXpath)).click();
			System.out.println("Moved");
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

		//To verify Quick view pop up page

		driver.switchTo().frame(0);
		eo.wait(3000);		

	/*	eo.verifyElementIsDisplayed(driver, "XPath", "productHeaderXpath");
		addComment("Product header is displayed");*/

		eo.verifyElementIsDisplayed(driver, "XPath", "brandLogoXpath");
		addComment("Brand logo is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "colorOptionXpath");
		addComment("Color Option is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "sizeOptionXpath");
		addComment("Size Option is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "productPrice");
		addComment("Product Price is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "30DaysReturnsLinkXpath");
		addComment("30 days return link is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "freeShippingXpath");
		addComment("All India FREE Shipping link is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "buyNowButtonXpath");
		addComment("Buy Now Button is displayed");

		eo.verifyElementIsDisplayed(driver, "Id", "addToBagXpath");
		addComment("Add to my Bag Button is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "viewDetailsLinkXpath");
		addComment("View more details link is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "sizeGuideTextLinkXpath");
		addComment("Size Guide Text Link is Displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "productImageXpath");
		addComment("Product image is dispalyed");

		eo.verifyElementIsDisplayed(driver, "Id", "nextBtnXpath");
		addComment("Next Button is displayed");		
	}
	
	//To Click on Next button in  "Quick View" pop-up page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnNextButtonAndVerifyPopUp
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on Next button in  "Quick View" pop-up page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnNextButtonAndVerifyPopUp(WebDriver driver) throws Exception {

		// To Click on Next Button
		try{
			eo.clickElement(driver, "Id", "nextBtnXpath");
			addComment("Successfully clicked on Next Button");
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to click on Next button.", e);
		}

		// To verify Quick View Pop Up Page
		driver.switchTo().defaultContent();
		eo.wait(3000);		

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

		eo.verifyElementIsDisplayed(driver, "XPath", "viewDetailsLinkXpath");
		addComment("View more details link is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "sizeGuideTextLinkXpath");
		addComment("Size Guide Text Link is Displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "productImageXpath");
		addComment("Product image is dispalyed");

		eo.verifyElementIsDisplayed(driver, "Id", "nextBtnXpath");
		addComment("Next Button is displayed");	

	}

	//To Click on Previous button in  "Quick View" pop-up page
	/**
	 * <p>
	 * <b>Method Name:</b> clickPreviousButtonAndVerifyPopUp
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on Previous button in  "Quick View" pop-up page
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickPreviousButtonAndVerifyPopUp(WebDriver driver) throws Exception {

		//To Click on Previous Button
		try{
			eo.clickElement(driver, "Id", "previousBtnXpath");
			addComment("Successfully clicked on Previous Button");
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to click on Previoust button.", e);
		}

		// To verify Quick View Pop Up Page
		driver.switchTo().defaultContent();
		eo.wait(3000);		

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

		eo.verifyElementIsDisplayed(driver, "XPath", "viewDetailsLinkXpath");
		addComment("View more details link is displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "sizeGuideTextLinkXpath");
		addComment("Size Guide Text Link is Displayed");

		eo.verifyElementIsDisplayed(driver, "XPath", "productImageXpath");
		addComment("Product image is dispalyed");

		eo.verifyElementIsDisplayed(driver, "Id", "nextBtnXpath");
		addComment("Next Button is displayed");	


	}

	//To hover the mouse on “Back View” image in "Quick View" pop-up.

	/**
	 * <p>
	 * <b>Method Name:</b> backViewImage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To hover the mouse on “Back View” image in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void backViewImage(WebDriver driver) throws Exception {
		
		driver.switchTo().frame(0);
		List<WebElement> allImages = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allImagesXpath", curApp)));
		for (int i = 0; i < allImages.size(); i++) {
			String imageXpath = GetElementIdentifier.getProperty("imageXpath", curApp);
			i = i + 1;
			imageXpath = imageXpath.replace("{i}", String.valueOf(i));
			driver.findElement(By.xpath(imageXpath)).isDisplayed();
			System.out.println("Image "+i+" is displayed");
		}
		addComment("Back view of image is displayed");

	}

	//To hover the mouse on “Front View” image in "Quick View" pop-up.

	/**
	 * <p>
	 * <b>Method Name:</b> frontViewImage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To hover the mouse on “Front View” image in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void frontViewImage(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("frontViewImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		eo.verifyElementIsDisplayed(driver, "Xpath", "frontViewImageXpath");
		addComment("Product Front View image is dispalyed");

	}

	// To hover the mouse on “Side View” image in "Quick View" pop-up.

	/**
	 * <p>
	 * <b>Method Name:</b> sideViewImage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To hover the mouse on “Side View” image in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void sideViewImage(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("sideViewImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		eo.verifyElementIsDisplayed(driver, "Xpath", "sideViewImageXpath");
		addComment("Product Side View image is dispalyed");

	}

	// To hover the mouse on “Detail View” image in "Quick View" pop-up.

	/**
	 * <p>
	 * <b>Method Name:</b> detailViewImage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To hover the mouse on “Detail View” image in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void detailViewImage(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("detailViewImageXpath", curApp)));
		action.moveToElement(ele).build().perform();
		eo.verifyElementIsDisplayed(driver, "Xpath", "detailViewImageXpath");
		addComment("Product Detail View image is dispalyed");

	}

	// To click on View Details link in "Quick View" pop-up.

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnViewDetailsLinkInQuickViewPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on View Details link in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnViewDetailsLinkInQuickViewPage(WebDriver driver) throws Exception {

		eo.clickElement(driver, "XPath", "viewDetailsLinkXpath");
		addComment("Successfully clicked on View Details link");

		driver.switchTo().defaultContent();

		//To verify Product Description

		eo.verifyElementIsDisplayed(driver, "XPath", "productDescriptionXpath");
		addComment("Product Description is dispalyed");

		//To verify Product Features

		eo.verifyElementIsDisplayed(driver, "XPath", "ProductFeatureXpath");
		addComment("Product Features is dispalyed");

	}

	// To select size in "Quick View" pop-up.

	/**
	 * <p>
	 * <b>Method Name:</b> selectSizeAndVerifyNumOfPiecesAvailableMsg
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To select size in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void selectSizeAndVerifyNumOfPiecesAvailableMsg(WebDriver driver) throws Exception {

		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizesXpath", curApp)));

		String allElementsInUI1[] = new String[allElements1.size()];
		int count3 = 0;
		for (WebElement element : allElements1) {
			allElementsInUI1[count3] = element.getAttribute("value");
			element.click();
			addComment("Successfully clicked on size :" + allElementsInUI1[count3]);
			break;
		}

		//To verify display of No. of pieces text
		try {
			eo.verifyElementIsDisplayed(driver, "Id", "noOfPiecesXpath");
			addComment("No. of pieces Available text is dispalyed");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify No. of pieces available text", e);
		}
	}

	// To Click on 30 Days Returns link

	/**
	 * <p>
	 * <b>Method Name:</b> clickOn30DaysReturnsLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on 30 Days Returns link in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOn30DaysReturnsLink(WebDriver driver) throws Exception {

		eo.clickElement(driver, "XPath", "30DaysReturnsLinkXpath");
		addComment("Successfully clicked on  30 Days Returns link");

		//To verify Returns and Exchange Policy page

		boolean pageHeader = false;
		for (int i = 0; i <= 5000; i++) {
			pageHeader = eo.verifyElementIsDisplayed(driver, "XPath", "returnsPageHeaderXpath");
			if (pageHeader) {
				addComment("Returns and Exchange Policy Header is dispalyed");
				break;
			}
		}

	}

	// To Click on All India Free Shipping link

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnAllIndiaFreeShippingLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on All India Free Shipping link in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnAllIndiaFreeShippingLink(WebDriver driver) throws Exception {

		eo.clickElement(driver, "XPath", "freeShippingXpath");
		addComment("Successfully clicked on  All India Free Shipping link");

		//To verify Why TrendIn header
		boolean pageStatus = false;
		for (int i = 0; i <= 5000; i++) {
			pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "freeShippingPageHeaderXpath");
			if (pageStatus) {
				addComment(" Why TrendIn? Header is dispalyed");
				break;
			}
		}

	}

	// To Click on Add To My Bag button

	/**
	 * <p>
	 * <b>Method Name:</b> clickAddToMyBag
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on Add To My Bag Button in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickAddToMyBag(WebDriver driver) throws Exception {
		//To Click on Add To My Bag Button
		eo.clickElement(driver,"Id", "addToBagXpath");
		addComment("Successfully clicked on the Add to My Bag button");

	}	

	//To check cart value
	/**
	 * <p>
	 * <b>Method Name:</b> checkCartValue
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To check cart value after Add To My Bag Button in "Quick View" pop-up.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void checkCartValue(WebDriver driver) throws Exception {

		eo.wait(4000);

		driver.switchTo().defaultContent();
		String  cartValueInUI = eo.getText(driver, "XPath", "cartValueXpath");
		addComment("Cart value after add to bag button is clicked :" +  cartValueInUI);
		int cartValue = Integer.parseInt( cartValueInUI);
		if (cartValue > 0) {
			addComment("Cart value is increased");
		} else {
			throw new POMMethodExecException("Cart value is not increased");
		}
	}

	// To Verify message when Add To My Bag is clicked without selecting Size

	/**
	 * <p>
	 * <b>Method Name:</b> VerifyMsgDisplayedClickedOnAddToMyBag
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify message when Add To My Bag is clicked without selecting Size
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void VerifyMsgDisplayedClickedOnAddToMyBag(WebDriver driver) throws Exception {

		String actualMsgDisplayed = eo.getText(driver, "Id", "msgAddToBagXpath");
		addComment("The message "  + actualMsgDisplayed + " is displayed ");
		String expectedMsgDisplayed = "Please select size";
		if (actualMsgDisplayed.equals(expectedMsgDisplayed)) {
			addComment("'Please Select Size' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to display message");
		}

	}

	//Verify that the application opens "Checkout Summary Page" , when user selects the size and clicks on "Buy Now" Button

	/**
	 * <p>
	 * <b>Method Name:</b> VerifyCheckOutSummaryPageTitle
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify that the application opens "Checkout Summary Page" title
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void VerifyCheckOutSummaryPageTitle(WebDriver driver) throws Exception {

		eo.wait(5000);
		String actualPageTitle, expectedPageTitle;
		expectedPageTitle = driver.getTitle(); 
		actualPageTitle = "Checkout Summary";
		if (actualPageTitle.equals(expectedPageTitle)) {
			addComment(" Checkout Summary Page is displayed.");
		} else {
			throw new POMMethodExecException("Cannot display Checkout summary page");
		}
	}

	//Verify that the application displays the focus in orange color, when the user mouse hover on the available sizes 

	/**
	 * <p>
	 * <b>Method Name:</b> VerifyOrangeColor
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b>Verify that the application displays the focus in orange color, when the user mouse hover on the available sizes 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyOrangeColorOnMouseHoverSize(WebDriver driver) throws Exception {

		try {
			driver.switchTo().frame(0);
			eo.wait(1000);
			String orangeColorHexaValue = "#EC8722".toLowerCase();
			Actions act = new Actions(driver);
			List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizesXpath", curApp)));
			eo.wait(1000);
			String allElementsInUI[] = new String[allElements.size()];
			int count = 0;
			for (WebElement element : allElements){
			allElementsInUI[count] = element.getAttribute("value");
			act.moveToElement(element).build().perform();
			String color =element.getCssValue("background-color");
			eo.wait(5000);
			addComment(color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
			addComment("Successfully clicked on size :" + allElementsInUI[count]);
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
			break;
			}
			
		} catch (Exception e) {
			throw new POMMethodExecException("Not matching the color Hexa deciamal value.", e);
		}

	}

		

	// To Verify message when Add To My Bag is clicked without selecting Size

	/**
	 * <p>
	 * <b>Method Name:</b> VerifyMsgDisplayedClickingOnBuyNow
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify message when Buy Now is clicked without selecting Size
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void VerifyMsgDisplayedClickingOnBuyNow(WebDriver driver) throws Exception {

		/*eo.verifyElementIsDisplayed(driver, "Id", "msgBuyNowXpath");
		addComment("Please select size message is dispalyed");*/
		
		String actualMsgDisplayed = eo.getText(driver, "Id", "msgBuyNowXpath");
		addComment("The message "  + actualMsgDisplayed + " is displayed ");
		String expectedMsgDisplayed = "Please select size";
		if (actualMsgDisplayed.equals(expectedMsgDisplayed)) {
			addComment("'Please Select Size' message is displayed");
		} else {
			throw new POMMethodExecException("Not able to display message");
		}
	}


	//To Verify display of size guide screen when Clicked on Size Guide link in  "Quick View" pop-up page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnSizeGuideAndVerifyItsDisplay
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify display of size guide screen 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnSizeGuideAndVerifyItsDisplay(WebDriver driver) throws Exception {

		eo.wait(2000);
		eo.clickElement(driver,"XPath", "sizeGuideTextLinkXpath");
		addComment("Successfully clicked on Size Guide link");

		//To verify Size guide screen
		eo.verifyElementIsDisplayed(driver, "XPath", "sizeGuideScreenXpath");
		addComment("Size Guide screen is dispalyed");
	}


	//To Click on centimeters in  size guide screen
	/**
	 * <p>
	 * <b>Method Name:</b> clickCmsOnSizeGuideScreen
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on centimeters in size guide screen
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickCmsOnSizeGuideScreen(WebDriver driver) throws Exception {
		//To Click on centimeters
		eo.clickElement(driver,"XPath", "cmsXpath");
		addComment("Successfully clicked on Centimeters");

		try {
			String cmsMsrmtText= eo.getText(driver, "Xpath", "cmMsrmtTextXpath");
			addComment("Measurement Text is :" +cmsMsrmtText);						
		}catch (Exception e) {
			throw new POMMethodExecException("Not able to Verify text", e);
		}
	}

	//To Click on centimeters in  size guide screen
	/**
	 * <p>
	 * <b>Method Name:</b> clickInchesOnSizeGuideScreen
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on inches in size guide screen
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickInchesOnSizeGuideScreen(WebDriver driver) throws Exception {
		//To Click on Inches
		eo.clickElement(driver,"XPath", "inchXpath");
		addComment("Successfully clicked on Inches");

		try {
			String inchMsrmtText= eo.getText(driver, "Xpath", "inchMsrmtTextXpath");
			addComment("Measurement Text is :" +inchMsrmtText);					
		}catch (Exception e) {
			throw new POMMethodExecException("Not able to Verify text", e);
		}
	}

	//To Click on Close Icon in  size guide screen
	/**
	 * <p>
	 * <b>Method Name:</b> clickCloseIcon
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on Close icon in size guide screen
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickSizeGuideCloseIcon(WebDriver driver) throws Exception {
		//To Click on Close Icon
		try {
			eo.wait(3000);
			Actions action = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("sizeGuideCloseIconXpath", curApp)));
			action.moveToElement(ele).build().perform();
			ele.click();
			addComment("Successfully clicked on Close Icon of Size guide screen");
		}catch (Exception e) {
			throw new POMMethodExecException("Not able to Click on Close button of Size guide Screen.", e);
		}
		//To verify Quick view pop up page

		driver.switchTo().frame(0);
		eo.wait(3000);		

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

		eo.verifyElementIsDisplayed(driver, "XPath", "viewDetailsLinkXpath");
		addComment("View more details link is displayed");

	}

	//To Click on Close Icon in  Quick View screen
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCloseIconOfQuickView
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Click on Close icon in Quick View
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickOnCloseIconOfQuickView(WebDriver driver) throws Exception {

		try {
			driver.switchTo().defaultContent();
			eo.wait(3000);
			WebElement closeButton = driver.findElement(By.xpath(GetElementIdentifier.getProperty("closeButtonXpath", curApp)));
			closeButton.click();
			addComment("Successfully clicked on Close Button of Quick View Screen");	
		}catch (Exception e) {
			throw new POMMethodExecException("Not able to Click on Close button of Quick View Screen.", e);
		}
	}
	//TC027
	//To Verify that the application displays tool tips when user mouse hover on the color option box
	/**
	 * <p>
	 * <b>Method Name:</b> mouseHoverColorAndVerify
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify that the application displays tool tips when user mouse hover on the color option box
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void mouseHoverOnColorAndVerifyProdDesc(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("productColorXpath", curApp)));
		action.moveToElement(ele).build().perform();
		String tooltip = ele.getAttribute("title");
		addComment("Color of the product is : " +tooltip);
		//driver.switchTo().defaultContent();
	    String color = eo.getText(driver, "XPath","colorInProductDescXpath");
	    String colorSplit[] = color.split("Color : ");
	    if(tooltip.contains(colorSplit[1])){
		addComment("color of the product is same in product description : " +tooltip);
	    }
	}


	//TC026 
	//Verify that the application is responsive and alignment is not broken when user opens "Quick view" pop up and reduces the window size.
	/**
	 * <p>
	 * <b>Method Name:</b> minimizeAndVerify
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verify that the application is responsive and alignment is not broken when user opens "Quick view" pop up and reduces the window size.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void minimizeAndVerify(WebDriver driver) throws Exception {

		eo.wait(3000);
		System.out.println(driver.manage().window().getSize());
		WebDriver driver1 = new FirefoxDriver();  
		Dimension dimension=new Dimension(200, 200);  
		driver1.manage().window().setSize(dimension); 
		addComment("Window size is reduced successfully");    	    
	}


	//TC028 incomplete//////////////////step 1 --- Filter
	/**
	 * <p>
	 * <b>Method Name:</b> filterOneProduct
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void filterOneProduct(WebDriver driver) throws Exception {

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("sizeFilterXpath", curApp)));
		action.moveToElement(ele).build().perform();
		ele.click();

		// To check the checkbox 
		try {
			eo.clickElement(driver, "Xpath", "filterXpath");
			addComment("Successfully selected product");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to select the product",e);
		}
	}

	//Verify that the application does not display Next/Previous products icon in "Quick view" pop-up when there is only 1 product available
	/**
	 * <p>
	 * <b>Method Name:</b> verifyNextBtnIsNotPresent
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> Verify that the application does not display Next/Previous products icon when there is only 1 product available
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyNextBtnIsNotPresent(WebDriver driver) throws Exception {
		eo.wait(3000);
		try {
			List<WebElement> nextButton = driver.findElements(By.xpath(GetElementIdentifier.getProperty("nextBtnXpath", curApp)));
			if (nextButton.isEmpty()) 
				addComment("Next Button is not present");
			else 
				throw new POMMethodExecException("Not able to verify Next Button when only one product is available.");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify Next Button when only one product is available.", e);
		}
	}
	//To click on the product image 
	/**
	 * <p>
	 * <b>Method Name:</b> 
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the product image
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void clickProductImage(WebDriver driver) throws Exception {

		//To click on product image
		Actions action = new Actions(driver);
		eo.wait(5000);
		String productImageXpath1 = GetElementIdentifier.getProperty("productImageXpath1", curApp);
		WebElement mouseElement = driver.findElement(By.xpath(productImageXpath1));
		action.moveToElement(mouseElement).build().perform();
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", mouseElement);*/
		mouseElement.click();
		System.out.println("1st image is clicked");

		/*driver.navigate().back();

		eo.wait(5000);
		String productImageXpath2 = GetElementIdentifier.getProperty("productImageXpath2", curApp);
		WebElement mouseElement1 = driver.findElement(By.xpath(productImageXpath2));
		action.moveToElement(mouseElement1).build().perform();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", mouseElement1);
		mouseElement1.click();
		System.out.println("2nd image is clicked");

		driver.navigate().back();

		eo.wait(5000);
		String productImageXpath3 = GetElementIdentifier.getProperty("productImageXpath3", curApp);
		WebElement mouseElement2 = driver.findElement(By.xpath(productImageXpath3));
		action.moveToElement(mouseElement2).build().perform();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", mouseElement);
		mouseElement2.click();
		System.out.println("3rd image is clicked");

		eo.wait(5000);
		eo.verifyElementIsDisplayed(driver, "XPath", "productDescriptionXpath");
		addComment("Product Description page is displayed");
		 */
	}

	public void clickOnQuickViewForRecentlyViewedProduct(WebDriver driver) throws Exception {

		eo.wait(5000);

		//To Click on Quick View Button
		Random random1 = new Random();
		int randomNumber1 = random1.nextInt(2);
		randomNumber1 = randomNumber1 + 1;
		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allBrandXpath", curApp)));
		for (int i = 0; i < allElements1.size();) {
			String brandXpath = GetElementIdentifier.getProperty("brandXpath", curApp);
			brandXpath = brandXpath.replace("{i}", String.valueOf(randomNumber1));
			driver.findElement(By.xpath(brandXpath)).click();
			System.out.println("Moved");
			Actions action = new Actions(driver);
			eo.wait(5000);
			String quickViewXpath = GetElementIdentifier.getProperty("quickViewXpath", curApp);
			quickViewXpath = quickViewXpath.replace("{i}", String.valueOf(randomNumber1));

			WebElement mouseElement = driver.findElement(By.xpath(quickViewXpath));
			action.moveToElement(mouseElement).build().perform();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", mouseElement);
			break;
		}
		addComment("QuickView Pop up is displayed");
	}

	//To Verify Address Page is displayed with Email ID
	/**
	 * <p>
	 * <b>Method Name:</b> verifyAddressPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Verify Address Page is displayed with Email ID
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */

	public void verifyAddressPage(WebDriver driver) throws Exception {

		// To verify 'Email ID' field
		boolean emailId = eo.verifyElementIsDisplayed(driver, "XPath", "emailXpath");
		try {
			if (emailId) {
				addComment("Email Id field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Email Id field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Email Id field", e);
		}
	}		
	//To enter valid Email Address and click on Continue button

	/**
	 * <p>
	 * <b>Method Name:</b> enterValidEmailAndVerifyShippingAddressPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter valid Email Address and click on Continue button
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */


	public void enterValidEmailAndVerifyShippingAddressPage(WebDriver driver) throws Exception {

		String email = ExcelReader.getValue("Email");
		eo.enterText(driver, "XPath", "emailTextBoxXpath", email);
		addComment("Successfully entered the email");

		//To click on Continue button
		eo.clickElement(driver, "XPath", "continueBtnXpath");
		addComment("Successfully clicked on Continue Button");

		//To Verify Your Shipping Address text and Zip code field
		eo.wait(5000);
		try {
			String expectedShippingText = "YOUR SHIPPING ADDRESS";
			String actualShippingText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("shippingAdrsXpath", curApp))).getText();
			if (actualShippingText.equalsIgnoreCase(expectedShippingText)) {
				addComment("Expected shipping text: "+expectedShippingText+" is same as Actual shipping Text: "+actualShippingText);
			} else {
				throw new POMMethodExecException("Expected shipping text: "+expectedShippingText+" is not same as Actual shipping text: "+actualShippingText);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify Your shipping Address text", e);
		}

		//To verify Zip/Postal Code field is present
		boolean zip = eo.verifyElementIsDisplayed(driver, "XPath", "zipXpath");
		try {
			if (zip) {
				addComment("Zip/Postal code field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Zip/Postal code field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Zip/Postal code field", e);
		}
	}

	//To enter valid Zip/Postal Code
	/**
	 * <p>
	 * <b>Method Name:</b> enterValidZipCodeAndVerifyAddressPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter valid Zip/Postal code and click on Check button
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void enterValidZipCodeAndVerifyAddressPage(WebDriver driver) throws Exception {

		String zip = ExcelReader.getValue("Zip");
		try {
			eo.enterText(driver, "XPath", "zipTextBoxXpath", zip);
			addComment("Successfully entered the zip/Postal Code");
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to enter the Zip/Postal Code", e);
		}

		//To click on Check button
		eo.clickElement(driver, "XPath", "checkBtnXpath");
		addComment("Successfully clicked on Check Button");

		//To verify Message
		eo.wait(4000);

		driver.switchTo().defaultContent();

		String message = eo.getText(driver, "XPath", "msgXpath");
		addComment("The message"  + message + " is displayed ");

		//To Verify Title with "Mr./Ms." radio button
		try {
			eo.verifyElementIsDisplayed(driver, "XPath", "titleTextXpath");
			addComment("Title is displayed");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify Title", e);
		}
		//To Verify Mr Radio Button
		boolean mrRadioBtnDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "mrRadioXpath");
		assertTrue(mrRadioBtnDisplayed, "Mr Radio Button is displayed", "Mr Radio Button is not displayed");

		//To Verify Ms Radio Button
		boolean msRadioBtnDisplayed = eo.verifyElementIsDisplayed(driver, "XPath", "msRadioXpath");
		assertTrue(msRadioBtnDisplayed, "Ms Radio Button is displayed", "Ms Radio Button is not displayed");

		//To verify First name Field
		boolean fName = eo.verifyElementIsDisplayed(driver, "XPath", "fNameFieldXpath");
		try {
			if (fName) {
				addComment("First Name field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the First Name field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the First Name field", e);
		}

		//To verify Last name Field
		boolean lName = eo.verifyElementIsDisplayed(driver, "XPath", "lNameFieldXpath");
		try {
			if (lName) {
				addComment("Last Name field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Last Name field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Last Name field", e);
		}

		//To verify Address line 1 Field
		boolean addLine1 = eo.verifyElementIsDisplayed(driver, "XPath", "addLine1FieldXpath");
		try {
			if (addLine1) {
				addComment("Address line 1 field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Address Line 1 field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Address Line1 field", e);
		}

		//To verify Address line 2 Field
		boolean addLine2 = eo.verifyElementIsDisplayed(driver, "XPath", "addLine2FieldXpath");
		try {
			if (addLine2) {
				addComment("Address line 2 field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Address Line 2 field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Address Line 2 field", e);
		}

		//To verify Address line 3 Field
		boolean addLine3 = eo.verifyElementIsDisplayed(driver, "XPath", "addLine3FieldXpath");
		try {
			if (addLine3) {
				addComment("Address line 3 field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Address Line 3 field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Address Line 3 field", e);
		}

		//To verify Landmark Field
		boolean landMark = eo.verifyElementIsDisplayed(driver, "XPath", "landmarkFieldXpath");
		try {
			if (landMark) {
				addComment("LandMark field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the LandMark field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the LandMark field", e);
		}

		//To verify Mobile NUmber Field
		boolean mobile = eo.verifyElementIsDisplayed(driver, "XPath", "mobileFieldXpath");
		try {
			if (mobile) {
				addComment("Mobile number field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Mobile number field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Mobile Number field", e);
		}
		//To verify State Field
		boolean state = eo.verifyElementIsDisplayed(driver, "XPath", "stateFieldXpath");
		try {
			if (state) {
				addComment("State field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the State field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the State field", e);
		}

		//To verify City Field
		boolean city = eo.verifyElementIsDisplayed(driver, "XPath", "cityFieldXpath");
		try {
			if (city) {
				addComment("City field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the City field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the City field", e);
		}

		//To verify Country Field
		boolean country = eo.verifyElementIsDisplayed(driver, "XPath", "countryFieldXpath");
		try {
			if (country) {
				addComment("Country field is displayed");
			} else {
				throw new POMMethodExecException("Not able to verify the Country field");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to verify the Country field", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> enterAdressDetailsForNonRegisteredUser
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter Address details for non registered user
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page.
	 * </p>
	 * 
	 * @author :Sowmya H M.
	 *
	 */
	public void enterAdressDetailsForNonRegisteredUser(WebDriver driver, String fName, String lName, String addressLine1, String addressLine2, String addressLine3, String addressLandMark,String mobileNumber) throws Exception {

		Thread.sleep(1000);

		eo.clickElement(driver, "XPath", "msRadioXpath");
		addComment("Successfully clicked on MS. Radio button ");

		//enter first name.
		try {
			if(fName.length() > 0 ) {
				eo.enterText(driver, "xpath", "fnameXpath", fName);
				addComment("Entered first name is: "+fName);
			} else {
				throw new POMMethodExecException("Unable to Enter First Name.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to Enter First Name.",e);
		}

		// enter Last name.
		try {
			if (lName.length() > 0) {
				eo.enterText(driver, "xpath", "lnameXpath", lName);
				addComment("Entered Last name is: " + lName);
			} else {
				throw new POMMethodExecException("Unable to Enter Last Name.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to Enter Last Name.", e);
		}

		// Enter Address Line1
		try {
			if (addressLine1.length() > 0 && addressLine1.length() < 80) {
				eo.enterText(driver, "xpath", "addressLine1Xpath", addressLine1);
				addComment("Entered Address Line1 is: " + addressLine1);
			} else {
				throw new POMMethodExecException("Address Line1 length should be greater than 0 and less than 80.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Address Line1 length should be greater than 0 and less than 80.", e);
		}

		// Enter Address Line2
		try {
			if (addressLine2.length() > 0 && addressLine2.length() < 80) {
				eo.enterText(driver, "xpath", "addressLine2Xpath", addressLine2);
				addComment("Entered Address Line2 is: " + addressLine2);
			} else {
				throw new POMMethodExecException("Address Line2 length should be greater than 0 and less than 80.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Address Line2 length should be greater than 0 and less than 80.", e);
		}

		// Enter Address Line3
		try {
			if (addressLine3.length() > 0 && addressLine3.length() < 80) {
				eo.enterText(driver, "xpath", "addressLine3Xpath", addressLine3);
				addComment("Entered Address Line3 is: " + addressLine3);
			} else {
				throw new POMMethodExecException("Address Line3 length should be greater than 0 and less than 80.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Address Line3 length should be greater than 0 and less than 80.", e);
		}

		// Enter Address Land mark.
		try {
			if (addressLandMark.length() > 0 && addressLandMark.length() < 80) {
				eo.enterText(driver, "xpath", "addressLandMarkXpath", addressLandMark);
				addComment("Entered Address Land mark is: " + addressLandMark);
			} else {
				throw new POMMethodExecException("Address Land mark length should be greater than 0 and less than 80.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Address Land mark length should be greater than 0 and less than 80.", e);
		}

		// Enter Mobile number.
		try {
			if (mobileNumber.length() < 10) {
				throw new POMMethodExecException("Mobile number length must be 10 and should not start with 0.");
			} else {
				eo.enterText(driver, "xpath", "mobileNumberXpath", mobileNumber);
				addComment("Entered Mobile number is: " + mobileNumber);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Mobile number length must be 10 and should not start with 0.", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnSaveAndContinueBtn
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on save and continue button.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page.
	 * </p>
	 * 
	 * @author :Sowmya H M.
	 *
	 */
	public void clickOnSaveAndContinueBtn(WebDriver driver) throws Exception {
		// Click on save and continue.
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("saveAndContinueBtnXpath", curApp))).click();
			addComment("clicked on save and continue Button.");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on save and continue Button.", e);
		}
	}

	//To Click On Order Number
	/**
	 * <p>
	 * <b>Method Name:</b> clickOrderNum
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on order number
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnOrderNum(WebDriver driver) throws Exception {

		eo.clickElement(driver, "XPath", "orderNumXpath");
		addComment("Successfully clicked on Order Number");	

		Thread.sleep(2000);
		//To Verify user landed in Log In page
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "loginPageXpath");
		assertTrue(pageStatus, "Login page is displayed", "Login page is not displayed");	
	}

	//To Click On Place Order Button in Payment page
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnPlaceOrderInPaymentPage
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on order number
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * 
	 * @author Sowmya H M
	 * 
	 */
	public void clickOnPlaceOrderInPaymentPage(WebDriver driver) throws Exception {

		eo.clickElement(driver, "XPath", "placeOrderPayXpath");
		addComment("Successfully clicked on Place Order ");	

		Thread.sleep(2000);
		//To Verify Success order confirmation Page
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "orderConfirmPageXpath");
		assertTrue(pageStatus, "Order Confirmation page is displayed", "order confirmation page is not displayed");			
	}
	
	//To click on the product image 
		/**
		 * <p>
		 * <b>Method Name:</b> 
		 * </p>
		 * 
		 * <p>
		 * <b>Description:</b> To click on the product image
		 * </p>
		 * <p>
		 * <b>Dependencies:</b> Browser.Launch
		 * </p>
		 * 
		 * @author Sowmya H M
		 * 
		 */

		public void clickOnAnyProductImage(WebDriver driver) throws Exception {

			//To click on product image
			Actions action = new Actions(driver);
			eo.wait(5000);
			String productImageXpath1 = GetElementIdentifier.getProperty("productImageXpath1", curApp);
			WebElement mouseElement = driver.findElement(By.xpath(productImageXpath1));
			action.moveToElement(mouseElement).build().perform();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", mouseElement);
			mouseElement.click();
			addComment("Successfully clicked on Product Image");
		}
}










