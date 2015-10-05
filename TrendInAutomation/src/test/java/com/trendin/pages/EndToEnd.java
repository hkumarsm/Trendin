package com.trendin.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.trendin.core.ElementOperation;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class EndToEnd extends TrendInTestSuite {
	final String curApp = "EndToEnd";
	ElementOperation eo = new ElementOperation(curApp);
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnMegaMenuCategory
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the particular mega menu category.
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnMegaMenuCategory(WebDriver driver, String megaMenuName, String megaMenuCategoryName) throws Exception {
		try {
			Thread.sleep(2000);
			//To move Cursor on the particular Mega menu. 
			String tempMegaMenuLinksXpath = GetElementIdentifier.getProperty("megaMenuLinksXpath", curApp);
			String replaceTempMegaMenuLinksXpath = tempMegaMenuLinksXpath.replace("{replaceHeaderLinkName}", megaMenuName);
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(replaceTempMegaMenuLinksXpath));
			act.moveToElement(ele).build().perform();
			addComment("Cursor moved to the perticular Mega menu: " + megaMenuName);
			
			//To click on mega menu particular category.
			String tempMegaMenuCategoryXpath = GetElementIdentifier.getProperty("megaMenuCategoryXpath", curApp);
			String replaceTempMegaMenuCategoryXpath = tempMegaMenuCategoryXpath.replace("{replaceMegaMenuName}", megaMenuName);
			replaceTempMegaMenuCategoryXpath = replaceTempMegaMenuCategoryXpath.replace("{replacecategoryType}", megaMenuCategoryName);
			WebElement option = driver.findElement(By.xpath(replaceTempMegaMenuCategoryXpath));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", option);
			addComment("Clicked on mega menu category is : "+megaMenuCategoryName);
			Thread.sleep(2000);
			eo.clickElement(driver,"Id","searchId");

		} catch (Exception e) {
			throw new POMMethodExecException("Unable to select mega menu category type: ", e);
		}
	}
	
	
	
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnQuickView
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on Quick view of products randomly.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > Category page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	
	public void clickOnQuickView(WebDriver driver) throws Exception {
		
		try{
		Random random = new Random();
		  int randomNumber = random.nextInt(1);
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
		   WebElement mouseElement1 = driver.findElement(By.xpath(brandXpath));
		   action.moveToElement(mouseElement1).build().perform(); 
		   WebElement mouseElement = driver.findElement(By.xpath(quickViewXpath1));
		   action.moveToElement(mouseElement).build().perform();
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", mouseElement);
		   driver.switchTo().frame(0);
		   break;
		  }
		 
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on quick view of a product category.", e);
		}
	}
	
	public void switchToDefault(WebDriver driver) throws Exception {
		 driver.switchTo().defaultContent();
	}
	/**
	 * <p>
	 * <b>Method Name:</b> clickAddToBag
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on add to bag but.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnAddToBagLink(WebDriver driver) throws Exception {
		eo.clickElement(driver, "Id", "addToBagXpath");
		addComment("Add to my Bag Button is clicked");
		Thread.sleep(2000);
	}
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCartLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on cart icon.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnCartLink(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		String windowHandler = driver.getWindowHandle();
		driver.switchTo().window(windowHandler);
		eo.clickElement(driver, "xpath", "clickOnCartIconXpath");
		addComment("Clicked on cart symbol");
	}
	/**
	 * <p>
	 * <b>Method Name:</b> verifySummaryPageIsDisplayed
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify summary page is displayed.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void verifySummaryPageIsDisplayed(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		boolean summaryPageDisplay = eo.verifyElementIsDisplayed(driver, "xpath", "summaryPageXpath");
		assertTrue(summaryPageDisplay, "Summary page is displayed.", "Summary page is not displayed.");
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> verifySuccessMsg
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify success message is displayed.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void verifySuccessMsg(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		boolean successMsgDisplay = eo.verifyElementIsDisplayed(driver, "xpath", "successMsgXpath");
		assertTrue(successMsgDisplay, "Success message is displayed.", "Success message is not displayed.");
	}
	/**
	 * <p>
	 * <b>Method Name:</b> verifyOrderNumber
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify the order number in order history page.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > order history page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void verifyOrderNumber(WebDriver driver) throws Exception {
		//To get order number
		String orderNumber = eo.getText(driver, "xpath", "orderNumberClickXpath");
		addComment("Order number is : "+orderNumber);
		
		//To click on order number
		eo.clickElement(driver, "xpath", "orderNumberClickXpath");
		addComment("Clicked on Order number.");
		
		Thread.sleep(2000);
		//To verify order history is displayed.
		boolean orderHistoryDisplay = eo.verifyElementIsDisplayed(driver, "xpath", "orderHistoryXpath");
		assertTrue(orderHistoryDisplay, "Verified page is navigated to order history page.", "Verified page is not navigated to order history page.");
		
		//To verify order number is displayed in order history page.
		String tempVerifyOrderNumberXpath = GetElementIdentifier.getProperty("verifyOrderNumberXpath", curApp);
		String replaceTempVerifyOrderNumberXpath = tempVerifyOrderNumberXpath.replace("{replaceOrderNumber}", orderNumber);
		boolean orderNumberDisplayStatus = driver.findElement(By.xpath(replaceTempVerifyOrderNumberXpath)).isDisplayed();
		if(orderNumberDisplayStatus) {
			addComment("Order nUmber is displayed in order page.");
		} else {
			throw new POMMethodExecException("Order number is not displayed in order page.");
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> enterEmailId
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Enter email-id.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > Address page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void enterEmailId(WebDriver driver, String emailId, String password) throws Exception {
		Thread.sleep(2000);
		//To enter email id.
		eo.enterText(driver, "xpath", "emailIdXpath", emailId);
		addComment("Entered email id is: "+emailId);
		
		//To click on continue button.
		eo.clickElement(driver, "xpath", "continueBtnXpath");
		addComment("Clicked on continue button.");
		Thread.sleep(2000);
		//To enter password.
		eo.enterText(driver, "xpath", "passwordTxtXpath", password);
		addComment("Entered Password is: "+password);
		
		// To click on submit button.
		eo.clickElement(driver, "xpath", "submitBtnXpath");
		addComment("Clicked on submit button.");
		Thread.sleep(2000);
	}
	/**
	 * <p>
	 * <b>Method Name:</b> continueToPaymentButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To Enter email-id.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > Address page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnContinueToPaymentButton(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "continueToPaymentXpath");
		addComment("Clicked on continue To Payment button.");
	}
	/**
	 * <p>
	 * <b>Method Name:</b> selectRadioButtonForAddress
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To select radio button for address.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > Address page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void selectRadioButtonForAddress(WebDriver driver, String addressName) throws Exception {
		Thread.sleep(2000);
		String tempSelectRadioBtnXpath = GetElementIdentifier.getProperty("selectRadioBtnXpath", curApp);
		String replaceTempSelectRadioBtnXpath = tempSelectRadioBtnXpath.replace("{replaceAddress}", addressName );
		driver.findElement(By.xpath(replaceTempSelectRadioBtnXpath)).click();
		addComment("Selected radio button for address is: "+addressName);
		Thread.sleep(2000);
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> selectFilterType
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To select particular filter and filter vale.()
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void selectFilterType(WebDriver driver, String filterTypeName, String selectFilterValue) throws Exception {
		try {
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			String[] splitFilterTypeName = filterTypeName.split(";");
			String[] splitSelectFilterValue = selectFilterValue.split(";");
			if(splitFilterTypeName.length == splitSelectFilterValue.length) {
				String tempSelectFilterTypeXpath = GetElementIdentifier.getProperty("selectFilterTypeXpath", curApp);
				for(int i = 0; i < splitFilterTypeName.length; i++) {
					String replaceTempSelectFilterTypeXpath = tempSelectFilterTypeXpath.replace("{replaceFilter}", splitFilterTypeName[i]);
					driver.findElement(By.xpath(replaceTempSelectFilterTypeXpath)).click();
					addComment("Clicked on filter type is: "+splitFilterTypeName[i]);
					for (int j = i; j < splitFilterTypeName.length; j++) {
						if (splitFilterTypeName[j].equalsIgnoreCase("DISCOUNT")) {
							String tempSelectDiscountXpath = GetElementIdentifier.getProperty("selectDiscountXpath", curApp);
							String replaceTempSelectDiscountXpath = tempSelectDiscountXpath.replace("{replaceDiscount}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectDiscountXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectDiscountXpath)).click();
							addComment("Selected discount value is: "+splitSelectFilterValue[j]);
							break;
						}

						if (splitFilterTypeName[j].equalsIgnoreCase("BRAND")) {
							String tempSelectBrandXpath = GetElementIdentifier.getProperty("selectBrandXpath", curApp);
							String replaceTempSelectBrandXpath = tempSelectBrandXpath.replace("{replaceBrand}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectBrandXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectBrandXpath)).click();
							addComment("Selected Brand is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("OCCASION")) {
							String tempSelectOccassionXpath = GetElementIdentifier.getProperty("selectOccassionXpath", curApp);
							String replaceTempSelectOccassionXpath = tempSelectOccassionXpath.replace("{replaceOccasionType}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectOccassionXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectOccassionXpath)).click();
							addComment("Selected occasion type is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("SIZES")) {
							String tempSelectSizeXpath = GetElementIdentifier.getProperty("selectSizeXpath", curApp);
							String replaceTempSelectSizeXpath = tempSelectSizeXpath.replace("{replaceSize}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectSizeXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectSizeXpath)).click();
							addComment("Selected size is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("PRICE")) {
							String tempSelectPriceXpath = GetElementIdentifier.getProperty("selectPriceXpath", curApp);
							String replaceTempSelectPriceXpath = tempSelectPriceXpath.replace("{replacePrice}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectPriceXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectPriceXpath)).click();
							addComment("Selected price  is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("COLOR")) {
							String tempSelectColorXpath = GetElementIdentifier.getProperty("selectColorXpath", curApp);
							String replaceTempSelectColorXpath = tempSelectColorXpath.replace("{replaceColor}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectColorXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectColorXpath)).click();
							addComment("Selected color is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("FIT")) {
							String tempSelectFitXpath = GetElementIdentifier.getProperty("selectFitXpath", curApp);
							String replaceTempSelectFitXpath = tempSelectFitXpath.replace("{replaceFit}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectFitXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectFitXpath)).click();
							addComment("Selected Fit is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("SLEEVES")) {
							String tempSelectSlevesXpath = GetElementIdentifier.getProperty("selectSlevesXpath", curApp);
							String replaceTempSelectSlevesXpath = tempSelectSlevesXpath.replace("{replaceSleves}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectSlevesXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectSlevesXpath)).click();
							addComment("Selected sleeves is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("PATTERN")) {
							String tempSelectPatternXpath = GetElementIdentifier.getProperty("selectPatternXpath", curApp);
							String replaceTempSelectPatternXpath = tempSelectPatternXpath.replace("{replacePattern}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectPatternXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectPatternXpath)).click();
							addComment("Selected pattern is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("NECK")) {
							String tempSelectNeckXpath = GetElementIdentifier.getProperty("selectNeckXpath", curApp);
							String replaceTempSelectNeckXpath = tempSelectNeckXpath.replace("{replaceNeck}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectNeckXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectNeckXpath)).click();
							addComment("Selected Neck type is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("COLLAR")) {
							String tempSelectCollarXpath = GetElementIdentifier.getProperty("selectCollarXpath", curApp);
							String replaceTempSelectCollarXpath = tempSelectCollarXpath.replace("{replaceCollar}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectCollarXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectCollarXpath)).click();
							addComment("Selected collar type is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("CUFFS")) {
							String tempSelectCuffsXpath = GetElementIdentifier.getProperty("selectCuffsXpath", curApp);
							String replaceTempSelectCuffsXpath = tempSelectCuffsXpath.replace("{replaceCuffs}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectCuffsXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectCuffsXpath)).click();
							addComment("Selected Cuffs type is: "+splitSelectFilterValue[j]);
							break;
						}
						if (splitFilterTypeName[j].equalsIgnoreCase("HOOD")) {
							String tempSelectHoodXpath = GetElementIdentifier.getProperty("selectHoodXpath", curApp);
							String replaceTempSelectHoodXpath = tempSelectHoodXpath.replace("{replaceHood}", splitSelectFilterValue[j]);
							WebElement ele = driver.findElement(By.xpath(replaceTempSelectHoodXpath));
							action.moveToElement(ele).build().perform();
							driver.findElement(By.xpath(replaceTempSelectHoodXpath)).click();
							addComment("Selected Hood type is: "+splitSelectFilterValue[j]);
							break;
						}

					}
				} 
				
				
			} else {
				throw new POMMethodExecException("Filter type name length must be equl's to select filter value length.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to select filter and filter value ",e);
		}
		
		
	} 
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnBuyNow
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on buy now button.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnBuyNow() throws Exception {
		eo.wait(2000);
		eo.clickElement(driver, "xpath", "buyNowXpath");
		addComment("Clicked on Buy now button.");
		eo.wait(5000);
	}	
	
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnPlaceOrder
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on place order button.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnPlaceOrder() throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "placeOrderButtonXpath");
		addComment("Clicked on placed order button.");
	}	
	/**
	 * <p>
	 * <b>Method Name:</b> enterZipForShippingAddress
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter zip code for the shipping address.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void enterZipForShippingAddress(WebDriver driver,String zipCode) throws Exception {
		//Enter zip code.
		try {
			Thread.sleep(2000);
			eo.enterText(driver, "xpath", "enterZipCodeShippingAddressXpath", zipCode);
			addComment("Entered zip code is : "+zipCode);
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to Enter zip code for shipping address page.");
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCheckShippingAddressButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter click on check button for shipping address page.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnCheckShippingAddressButton(WebDriver driver) throws Exception {
		//Click on check Button.
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("checkShippingAddressXpath", curApp))).click();
			// eo.clickElement(driver, "xPath", "checkButtonXpath");
			addComment("clicked on Check button for shipping address page.");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on check button.", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCheckShippingAddressButton
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To enter click on check button for shipping address page.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void enteraAdressDetailsForShippingAddressPage(WebDriver driver, String firstName, String lastName, String addressLine1, String addressLine2, String addressLine3, String addressLandMark,String mobileNumber) throws Exception {
		Thread.sleep(1000);
		//enter first name.
		try {
			if(firstName.length() > 0 ) {
				eo.enterText(driver, "xpath", "firstnameShippingAddressXpath", firstName);
				addComment("Entered first name is: "+firstName);
			} else {
				throw new POMMethodExecException("Unable to Enter First Name.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to Enter First Name.",e);
		}
		
		// enter Last name.
		try {
			if (lastName.length() > 0) {
				eo.enterText(driver, "xpath", "lastNameShippingAddressXpath", lastName);
				addComment("Entered Last name is: " + lastName);
			} else {
				throw new POMMethodExecException("Unable to Enter Last Name.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to Enter Last Name.", e);
		}
		
		// Enter Address Line1
		try {
			if (addressLine1.length() > 0 && addressLine1.length() < 80) {
				eo.enterText(driver, "xpath", "addressLine1ShippingAddressXpath", addressLine1);
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
				eo.enterText(driver, "xpath", "addressLine2ShippingAddressXpath", addressLine2);
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
				eo.enterText(driver, "xpath", "addressLine3ShippingAddressXpath", addressLine3);
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
				eo.enterText(driver, "xpath", "addressLandMarkShippingAddressXpath", addressLandMark);
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
				eo.enterText(driver, "xpath", "mobileNumberShippingAddressXpath", mobileNumber);
				addComment("Entered Mobile number is: " + mobileNumber);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Mobile number length must be 10 and should not start with 0.", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnSaveAndContinue
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
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnSaveAndContinue(WebDriver driver) throws Exception {
		// Click on save and continue.
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("saveAndContinueXpath", curApp))).click();
			// eo.clickElement(driver, "xPath", "checkButtonXpath");
			addComment("clicked on save and continue for shipping address page.");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on save and continue for shipping address page.", e);
		}
	}
	/**
	 * <p>
	 * <b>Method Name:</b> verifyCaptchaForPaymentOption
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verifies the captcha on payment option page.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page - > Payment option page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void verifyCaptchaForPaymentOption(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		String expectedMsgForCaptcha = "Account verified.";
		String captchaCode = eo.getText(driver, "xpath", "getCaptchaCodeXpath");
		addComment("Captcha code is : "+captchaCode);
		eo.enterText(driver, "xpath", "enterCaptchaForPaymentXpath", captchaCode);
		addComment("Entered captcha code is : "+captchaCode);
		//To click on verify.
		eo.clickElement(driver, "xpath", "verifyCaptchaForPaymentPageXpath");
		String actualMsgForCaptcha = eo.getText(driver, "xpath", "verifyMsxForCaptchaXpath");
		if(expectedMsgForCaptcha.equalsIgnoreCase(actualMsgForCaptcha)) {
			addComment("Actual message is same as expected message: "+actualMsgForCaptcha);
		} else {
			throw new POMMethodExecException("Actual message is not same as expected message: "+actualMsgForCaptcha);
		}
		
		
	}
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnCashAndDelivery
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on cash and delivery radio button.
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page - > Payment option page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnCashAndDelivery(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "cashOnDeliveryXpath");
		addComment("Clicked on cash and delivery radio button.");
	}
	public void clickOnCoupnsAndVochersButton(WebDriver driver)throws Exception{
		Thread.sleep(5000);
		eo.clickElement(driver, "Xpath", "coupnLabelXpath");
		addComment("Successfully clicked on the coupns button");
	}
	
	/**
	  * <p>
	  * <b>Method Name:</b> enterRandomEmail
	  * </p>
	  * 
	  * <p>
	  * <b>Description:</b> To enter Random Email Id.
	  * </p>
	  * 
	  * <p>
	  * <b>Dependencies:</b> Browser.Launch - > Home page - > category page - > shipping address page 
	  * </p>
	  * 
	  * @author :Sowmya H M
	  *
	  */
	 public void enterRandomEmail(WebDriver driver) throws Exception {

	  String emailId = java.util.UUID.randomUUID().toString().replaceAll("-", "").concat("@gmail.com");
	  eo.enterText(driver, "xpath", "emailIdXpath", emailId);
	  addComment("Entered email id is: "+emailId);

	  //To click on Continue button
	  eo.clickElement(driver, "XPath", "continueBtnXpath");
	  addComment("Successfully clicked on Continue Button");

	 }
}
