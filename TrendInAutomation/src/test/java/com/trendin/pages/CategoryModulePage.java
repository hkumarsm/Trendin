package com.trendin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class CategoryModulePage extends TrendInTestSuite {
	final String curApp = "CategoryModulePage";
	ElementOperation eo = new ElementOperation(curApp);

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnHeaderLinksType
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the header links like new arrivals, men, women etc. 
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
	public void clickOnHeaderLinksType(WebDriver driver, String linkTypeName) throws Exception {
		try {
			String tempHeaderLinksXpath = GetElementIdentifier.getProperty("headerLinksXpath", curApp);
			String replaceTempHeaderLinksXpath = tempHeaderLinksXpath.replace("{replaceHeaderLinkName}", linkTypeName);
			driver.findElement(By.xpath(replaceTempHeaderLinksXpath)).click();
			addComment("Clicked on Header link type : "+linkTypeName);

		} catch(Exception e) {
			throw new POMMethodExecException("Unable to click on Header Link types.", e);
		}
	}

	//To verify Men category.
	public void veriyMenCategory(WebDriver driver, String menCategoriesName) throws Exception {
		try {
			int noOfMenCategories = 0; 
			String[] splitMenCategoriesName = menCategoriesName.split(";");
			List<WebElement> allMenCategories = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allCategoryXpath", curApp)));
			String tempMenCategoriesXpath = GetElementIdentifier.getProperty("categoryTypesXpath", curApp);
			for(int i = 0; i < allMenCategories.size(); i++ ) {
				String replaceTempMenCategoriesXpath = tempMenCategoriesXpath.replace("{ReplaceCategory}", splitMenCategoriesName[i]);
				boolean menCategoryDisplayStatus = driver.findElement(By.xpath(replaceTempMenCategoriesXpath)).isDisplayed();
				assertTrue(menCategoryDisplayStatus, "Displayed Men category : "+splitMenCategoriesName[i], "Didn't Displayed Men category : "+splitMenCategoriesName[i]);
				noOfMenCategories++;
			}
			if(noOfMenCategories == allMenCategories.size()) {
				addComment("All men categories are displayed.");
			} else {
				throw new POMMethodExecException("All men categories are not displayed.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to verify Men categories.",e);
		}		
	}

	// To verify Women category.
	public void veriyWomenCategory(WebDriver driver, String womenCategoriesName) throws Exception {
		try {
			int noOfwomenCategories = 0;
			String[] splitWomenCategoriesName = womenCategoriesName.split(";");
			List<WebElement> allWomenCategories = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allCategoryXpath", curApp)));
			String tempMenCategoriesXpath = GetElementIdentifier.getProperty("categoryTypesXpath", curApp);
			for (int i = 0; i < allWomenCategories.size(); i++) {
				String replaceTempWomenCategoriesXpath = tempMenCategoriesXpath.replace("{ReplaceCategory}", splitWomenCategoriesName[i]);
				boolean womenCategoryDisplayStatus = driver.findElement(By.xpath(replaceTempWomenCategoriesXpath)).isDisplayed();
				assertTrue(womenCategoryDisplayStatus, "Displayed women category : " + splitWomenCategoriesName[i], "Didn't Displayed women category : " + splitWomenCategoriesName[i]);
				noOfwomenCategories++;
			}
			if (noOfwomenCategories == allWomenCategories.size()) {
				addComment("All women categories are displayed.");
			} else {
				throw new POMMethodExecException("All women categories are not displayed.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify women categories.", e);
		}
	}
	//To verify order history page.
	public void verifyOrderHistoryPage(WebDriver driver, String orderHistoryTabs) throws Exception {
		List<WebElement> allOrderHistoryTab = driver.findElements(By.xpath(GetElementIdentifier.getProperty("orderHistoryTabsXpath", curApp)));
		String[] splitOrderHistoryTabs = orderHistoryTabs.split(";");
		for(int i = 0; i < allOrderHistoryTab.size(); i++) {
			if(splitOrderHistoryTabs[i].equalsIgnoreCase("")) {

			}
		}
	}


	///////////////////////////////////////SOWMYA////////////////////////////////////////////////////////
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnHeaderLinksType
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on the header links like new arrivals, men, women etc. 
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Home page.
	 * </p>
	 * 
	 * @author :Sowmya H M
	 *
	 */
	public void mouseHoverOnHeaderLinksType(WebDriver driver, String linkTypeName) throws Exception {
		try {
			String tempHeaderLinksXpath = GetElementIdentifier.getProperty("headerLinksXpath", curApp);
			String replaceTempHeaderLinksXpath = tempHeaderLinksXpath.replace("{replaceHeaderLinkName}", linkTypeName);
			Actions action = new Actions(driver);
			eo.wait(5000);
			WebElement mouseElement = driver.findElement(By.xpath(replaceTempHeaderLinksXpath));
			action.moveToElement(mouseElement).build().perform();
			addComment("Mouse Hover on Header link type : "+linkTypeName);
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to click on Header Link types.", e);
		}
	}
	
	//To Click on Secure Payment Icon 
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnSecurePaymentIcon
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify Secure Payment Icon under New Arrival menu 
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
	public void clickOnSecurePaymentIcon(WebDriver driver) throws Exception {

		String megaMenuBarName = ExcelReader.getValue("MegaMenuBarName");
		String allMegaMenuValue[] = megaMenuBarName.split(";");
		String securePaymentIconXpath = GetElementIdentifier.getProperty("securePaymentIconXpath", curApp);
		for(int i = 0;i<allMegaMenuValue.length;i++){
			securePaymentIconXpath = securePaymentIconXpath.replace("{replace}", allMegaMenuValue[i]);
			driver.findElement(By.xpath(securePaymentIconXpath)).click();
		}
	}

	//To Verify Secure Payment Icon under New Arrival menu 
	/**
	 * <p>
	 * <b>Method Name:</b> verifySecurePaymentIcon
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify Secure Payment Icon under New Arrival menu 
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
	public void verifySecurePaymentHeader(WebDriver driver) throws Exception {

		eo.wait(3000);
		String securePaymentHeader = eo.getText(driver, "Xpath", "securePaymentHeaderXpath");
		assertTrue(securePaymentHeader.equalsIgnoreCase("Secure Payment")==true, "Successfully verified the header : " + securePaymentHeader, 
				"Not able to verify the Header");
	}

	//To Click on Free Alteration Icon 
		/**
		 * <p>
		 * <b>Method Name:</b> clickOnFreeAlterationIcon
		 * </p>
		 * 
		 * <p>
		 * <b>Description:</b> To verify Free Alteration Icon 
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
	public void clickOnFreeAlterationIcon(WebDriver driver) throws Exception {
		
		String megaMenuBarName = ExcelReader.getValue("MegaMenuBarName");
		String allMegaMenuValue[] = megaMenuBarName.split(";");
		String freeAlterationIconXpath = GetElementIdentifier.getProperty("freeAlterationIconXpath", curApp);
		for(int i = 0;i<allMegaMenuValue.length;i++){
			freeAlterationIconXpath = freeAlterationIconXpath.replace("{replace}", allMegaMenuValue[i]);
			driver.findElement(By.xpath(freeAlterationIconXpath)).click();
		}	
	}
	
	//To Verify Alteration Page display
			/**
			 * <p>
			 * <b>Method Name:</b> verifyAlterationPageTitle
			 * </p>
			 * 
			 * <p>
			 * <b>Description:</b> To Verify Alteration Page display
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
		public void verifyAlterationPageTitle(WebDriver driver) throws Exception {
			eo.wait(3000);
			// To verify the title of Alterations page
			String pageTitle = driver.getTitle();
			System.out.println("Page title is   " + pageTitle);
			if (pageTitle.equalsIgnoreCase("Alteration")) {
				addComment("Successfully navigated to Alteration page :" + pageTitle);
			} else {
				throw new POMMethodExecException("Could not navigate to Alteration page");
			}
		}	

		//To Verify select State and select city drop down and Locate store button in Alteration Page 
		/**
		 * <p>
		 * <b>Method Name:</b> verifyelementsInAlterationPage
		 * </p>
		 * 
		 * <p>
		 * <b>Description:</b> To Verify select State and select city drop down and Locate store button in Alteration Page
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

		//To Select State  from select State drop down in Alteration Page
		/**
		 * <p>
		 * <b>Method Name:</b> selectStateFromSelectStateDropDown
		 * </p>
		 * 
		 * <p>
		 * <b>Description:</b>To Select State  from select State drop down in Alteration Page
		 * </p>
		 * <p>
		 * <b>Dependencies:</b>  Browser.Launch - > Home page -> Alteration Page
		 * </p>
		 * 
		 * @author Sowmya H M
		 * 
		 */

		public void selectStateFromSelectStateDropDown(WebDriver driver) throws Exception {

			String state = ExcelReader.getValue("State");
			try {	
				WebElement element = driver.findElement(By.xpath(GetElementIdentifier.getProperty("selectStateDropDownXpath", curApp)));
				Actions action = new Actions(driver);
				eo.wait(5000);
				action.moveToElement(element).build().perform();
				eo.SelectComboBoxByVisibleText(driver, "XPath", "selectStateDropDownXpath", state); 
				addComment("Successfully selected state : " + state);
			}catch (Exception e) {
				throw new POMMethodExecException("Not able to Select state from select state drop down", e);
			}

		}
		//To Click on Locate Store Button
		/**
		 * <p>
		 * <b>Method Name:</b> clickOnLocateStoreBtn
		 * </p>
		 * 
		 * <p>
		 * <b>Description:</b> To Click on Locate Store Button
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
		public void clickOnLocateStoreBtn(WebDriver driver) throws Exception {
			
			eo.wait(3000);
			eo.clickElement(driver, "xpath", "locateStoreBtnXpath");
			addComment("Clicked on Locate Store button.");
		}
}
