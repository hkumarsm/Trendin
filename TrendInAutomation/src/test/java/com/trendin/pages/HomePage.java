package com.trendin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.trendin.core.*;

public class HomePage extends TrendInTestSuite {
	
	private Logger log = new Logger();
	
	public void verifyHomePageLogo(WebDriver driver) throws Exception {
		boolean logoDisplayedStatus = driver.findElement(By.xpath("//a/img[contains(@src,'logo_v3.jpg')]")).isDisplayed();
		try {
			if (logoDisplayedStatus) {
				Assert.assertTrue(logoDisplayedStatus, "Logo in Home is not displayed");
			} else {
				addComment("Home Page Logo not verified.");
			}
		} catch (Exception e) {
			throw new Exception();
		}
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

	// To verify Tiny header contact us.
	public void verifyTinyContactUsLink(WebDriver driver) throws Exception {
		boolean contactUsStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("tinyContactUsXpath", "HomePage"))).isDisplayed();
		String contactsLinks = "Be sure to check;Check Delivery time & COD availability;Email us;Call us;Current Promotions";
		String[] splitContactsLinks = contactsLinks.split(";");
		try {
			if (contactUsStatus) {
				addComment("Contact Us tab is Displayed.");
				driver.findElement(By.xpath(GetElementIdentifier.getProperty("tinyContactUsXpath", "HomePage"))).click();
				addComment("Clicked on Contact Us tab.");
				String expectedContactUsText = "Contact us";
				String actualContactUsText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("contactUsXpath", "HomePage"))).getText();
				if (expectedContactUsText.equalsIgnoreCase(actualContactUsText)) {
					addComment("Verified expected contact us text is :" + expectedContactUsText + " same as actual contact us text: " + actualContactUsText);
				} else {
					throw new Exception();
				}
				// To check all the links are displayed.
				List<WebElement> allTheLinks = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allContactUsLinksXpath", "HomePage")));
				int count = 0;
				String tempAllRelativeContactUsLinksXpath = GetElementIdentifier.getProperty("allRelativeContactUsLinksXpath", "HomePage");
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

	// To verify Bottom Contact Us link.
	public void verifyContactUsBottomLink(WebDriver driver) throws Exception {
		String contactsLinks = "Be sure to check;Check Delivery time & COD availability;Email us;Call us;Current Promotions";
		String[] splitContactsLinks = contactsLinks.split(";");
		boolean contactUsStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("contactUsXpath", "HomePage"))).isDisplayed();

		try {
			if (contactUsStatus) {
				addComment("Contact Us tab is Displayed.");
				driver.findElement(By.xpath(GetElementIdentifier.getProperty("contactUsXpath", "HomePage"))).click();
				addComment("Clicked on Contact Us tab.");
				String expectedContactUsText = "Contact us";
				// String expected
				String actualContactUsText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("contactUsXpath", "HomePage"))).getText();
				if (expectedContactUsText.equalsIgnoreCase(actualContactUsText)) {
					addComment("Verified expected contact us text is :" + expectedContactUsText + " same as actual contact us text: " + actualContactUsText);
				} else {
					throw new Exception();
				}

				// To check all the links are displayed.
				List<WebElement> allTheLinks = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allContactUsLinksXpath", "HomePage")));
				int count = 0;
				String tempAllRelativeContactUsLinksXpath = GetElementIdentifier.getProperty("allRelativeContactUsLinksXpath", "HomePage");
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
