package com.trendin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.trendin.core.ElementOperation;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class SignInWithSocialLoginPage extends TrendInTestSuite {
	final String curApp = "SignInWithSocialLoginPage";
	ElementOperation eo = new ElementOperation(curApp);

	/**
	 * <p>
	 * <b>Method Name:</b> verifySocialNetworkButtonsAreDisplayed
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify social login networks links are displayed.
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Login page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void verifySocialNetworkButtonsAreDisplayed(WebDriver driver, String socialNetworkButtonNames) throws Exception {
		try {
			String[] splitSocialNetworkButtonNames = socialNetworkButtonNames.split(";");
			String tempSocialNetworkButtonsXpath = GetElementIdentifier.getProperty("socialNetworkButtonsXpath", curApp);
			for (int i = 0; i < splitSocialNetworkButtonNames.length; i++) {
				String replaceTempSocialNetworkButtonsXpath = tempSocialNetworkButtonsXpath.replace("{replaceSocialNetworkButtonNames}", splitSocialNetworkButtonNames[i]);
				boolean socialNetworkButtonsDisplayStatus = driver.findElement(By.xpath(replaceTempSocialNetworkButtonsXpath)).isDisplayed();
				assertTrue(socialNetworkButtonsDisplayStatus, "Social Network login button is displayed i.e : " + splitSocialNetworkButtonNames[i], "Social Network login button is not displayed i.e : " + splitSocialNetworkButtonNames[i]);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify social network Login buttons", e);
		}

	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickGoogleLinkLogin
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on social login link google.
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch - > Login page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickGoogleLinkLogin(WebDriver driver) throws Exception {
		eo.clickElement(driver, "xPath", "googleLinkSignInPageXpath");
		addComment("Clicked on google login link on Existing user sign in page.");
		boolean googleLogoDisplayStatus = eo.verifyElementIsDisplayed(driver, "xPath", "googleLogoXpath");
		if (googleLogoDisplayStatus) {
			addComment("Google logo is displayed, Page navigated to Gmail.");
		} else {
			throw new POMMethodExecException("Goole logo is not displayed, Page is didnot navigated to Gmail.");
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnBack
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on back for browser.
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnBack(WebDriver driver) throws Exception {
		driver.navigate().back();
		addComment("Clicked on Back arrow");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> clickOnForward
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To click on Forward for browser.
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void clickOnForward(WebDriver driver) throws Exception {
		driver.navigate().forward();
		addComment("Clicked on Forward arrow.");
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyGoogleLoginLinkColor
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify social network google login link color.
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch. - > Login page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void verifyGoogleLoginLinkColor(WebDriver driver) throws Exception {
		try {

			String orangeColorHexaValue = "#DF4A32".toLowerCase();
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("signInWithGoogleColorXPath", curApp)));
			eo.wait(2000);
			act.moveToElement(ele).build().perform();
			String color = ele.getCssValue("background-color");
			eo.wait(5000);
			addComment(color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);
			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3).toLowerCase();
			addComment(actualColor);
			if (orangeColorHexaValue.equals(actualColor)) {
				addComment("Successfully verified the color");
			} else {
				throw new POMMethodExecException("Not matching the color Hexa deciamal value.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not matching the color Hexa deciamal value.", e);
		}
	}

	/**
	 * <p>
	 * <b>Method Name:</b> verifyFaceBookLoginLinkColor
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verify social network facebook login link color.
	 * 
	 * </p>
	 * 
	 * <p>
	 * <b>Dependencies:</b> Browser.Launch. - > Login page.
	 * </p>
	 * 
	 * @author :Ravichandra Gudda.
	 *
	 */
	public void verifyFaceBookLoginLinkColor(WebDriver driver) throws Exception {
		try {

			String orangeColorHexaValue = "#2a567a".toLowerCase();
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("signInWithFaceBookColorXpath", curApp)));
			eo.wait(2000);
			act.moveToElement(ele).build().perform();
			String color = ele.getCssValue("background-color");
			addComment(color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
			int hexValue1 = Integer.parseInt(hexValue[0]);
			hexValue[1] = hexValue[1].trim();
			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();
			int hexValue3 = Integer.parseInt(hexValue[2]);
			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3).toLowerCase();
			addComment(actualColor);
			if (orangeColorHexaValue.equals(actualColor)) {
				addComment("Successfully verified the color");
			} else {
				throw new POMMethodExecException("Not matching the color Hexa deciamal value.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not matching the color Hexa deciamal value.", e);
		}
	}
}
