package com.trendin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.trendin.core.*;

public class HomePage extends TrendInTestSuite {
	
	
	final String curApp = "HomePage";
	ElementOperation eo = new ElementOperation(curApp);
	
	
	/**
	 * 
	 * <p>
	 * <b>Method Name:</b> clickHeaderContactIcon
	 * </p>
	 * <p>
	 * <b>Description:</b> Used to click on the 'Contact Us' tiny icon (Telephone)
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Launch >> Goto Url
	 * </p>
	 * <p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>webdriver:</b> WebDriver object  </li>
	 * </ul>
	 * </p>
	 * 
	 * @author Kavya
	 * 
	 */
	public void clickHeaderContactIcon(WebDriver driver) throws Exception {
		Utility.waitUntilExists(driver, "XPath", "tinyContactUsXpath", curApp);
		eo.clickElement(driver, "XPath", "tinyContactUsXpath");
		addComment("Successfully clicked on the header 'Telephone' icon (Contact Us).");
		Utility.waitUntilExists(driver, "XPath", "contactUsHeaderXpath", curApp);
		//Wait until the Contact Us header label is displayed 
		Utility.waitUntilExists(driver, "XPath", "contactUsHeaderXpath", curApp);
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "contactUsHeaderXpath");
		assertTrue(pageStatus, "Contact us page is displayed", "Contact us page is not displayed");
	}
	
	
	/**
	 * <p>
	 * <b>Method Name:</b> clickContactUsIcon
	 * <p>
	 * <b>Description:</b> Click on the 'Contact Us' icon from the footer link
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch
	 * </p>
	 * @author Kavya
	 */

	// To login to TrendIn contact us icon
	public void clickFooterContactUsIcon(WebDriver driver) throws Exception {
		Utility.waitUntilExists(driver, "XPath", "contactUsXpath", curApp);
		// To click on contact us icon
		eo.clickElement(driver, "Xpath", "contactUsXpath");
		addComment("Successfully clicked on contact us icon");
		//Wait until the Contact Us header label is displayed 
		Utility.waitUntilExists(driver, "XPath", "contactUsHeaderXpath", curApp);
		boolean pageStatus = eo.verifyElementIsDisplayed(driver, "XPath", "contactUsHeaderXpath");
		assertTrue(pageStatus, "Contact us page is displayed", "Contact us page is not displayed");
	}

	
	// Method used to verify the presence of the Logo in Home page (TrendIn logo)
	public void verifyHomePageLogo(WebDriver driver) throws Exception {
		boolean logoDisplayedStatus = driver.findElement(By.xpath("//a/img[contains(@src,'logo_v3.jpg')]")).isDisplayed();
		assertTrue(logoDisplayedStatus, "Logo in Home is displayed", "Logo in Home is not displayed");	
	}

	// To verify MyAccount and Click on mY account.
	public void verifyMyAccount(WebDriver driver) throws Exception {
		boolean myAccountStatus = driver.findElement(By.xpath("//a[contains(.,'MY ACCOUNT')]")).isDisplayed();

		try {
			if (myAccountStatus) {
				addComment("My Account tab is Displayed.");
				driver.findElement(By.xpath("//a[contains(.,'MY ACCOUNT')]")).click();
				addComment("Clicked on My Account tab.");
			} else {
				addComment("My account tab is not displayed.");
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

	

	// To verify Bottom Contact Us link.
	public void verifyContactUsBottomLink(WebDriver driver) throws Exception {
		String contactsLinks = "Be sure to check;Check Delivery time & COD availability;Email us;Call us;Current Promotions";
		String[] splitContactsLinks = contactsLinks.split(";");
		boolean contactUsStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("contactUsXpath", curApp))).isDisplayed();

		try {
			if (contactUsStatus) {
				addComment("Contact Us tab is Displayed.");
				driver.findElement(By.xpath(GetElementIdentifier.getProperty("contactUsXpath", curApp))).click();
				addComment("Clicked on Contact Us tab.");
				String expectedContactUsText = "Contact us";
				// String expected
				String actualContactUsText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("contactUsXpath", curApp))).getText();
				if (expectedContactUsText.equalsIgnoreCase(actualContactUsText)) {
					addComment("Verified expected contact us text is :" + expectedContactUsText + " same as actual contact us text: " + actualContactUsText);
				} else {
					throw new Exception();
				}

				// To check all the links are displayed.
				List<WebElement> allTheLinks = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allContactUsLinksXpath", curApp)));
				int count = 0;
				String tempAllRelativeContactUsLinksXpath = GetElementIdentifier.getProperty("allRelativeContactUsLinksXpath", curApp);
				for (int i = 0; i < allTheLinks.size(); i++) {
					String replaceAllRelativeContactUsLinksXpath = tempAllRelativeContactUsLinksXpath.replace("{replaceText}", splitContactsLinks[i]);
					boolean linksStatus = driver.findElement(By.xpath(replaceAllRelativeContactUsLinksXpath)).isDisplayed();
					if (linksStatus) {
						addComment("contact links is displayed : " + splitContactsLinks[i]);
						count++;
					} else {
						throw new Exception();
					}
				}

				if (count == allTheLinks.size()) {
					addComment("All the contact's Links are displayed.");
				} else {
					addComment("All the contact's Links are not displayed.");
					throw new Exception();
				}
			} else {
				addComment("Contact Us tab is not displayed.");
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
}
