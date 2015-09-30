package com.trendin.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trendin.core.util.exceptions.POMException;
import com.trendin.core.util.exceptions.POMMethodExecException;
import com.trendin.core.GetElementIdentifier;

public class ElementOperation {
	private String CUR_APP;

	public ElementOperation(String app) {
		CUR_APP = app;
	}

	public void clickElement(WebDriver driver, String property, String keyValue) throws Exception {
		WebElement element = null;
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			element = getWebElement(driver, property, eleIdentifier);
			if (element == null) {
				throw new POMMethodExecException("Not found the element: " + keyValue + ", for the Locator: " + property);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Not able to get the Element", e);
		}
		// first move to the element in the web page
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		// Now click on the web Element
		try {
			element.click();
		} catch (Exception e) {
			throw new POMMethodExecException("Could not Click the element: "+ keyValue + ", for the locator: "+ property, e);
		}
	}

	public void enterText (WebDriver driver, String property, String keyValue, String data) throws Exception {
		WebElement element = null;
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			element = getWebElement(driver, property, eleIdentifier);
			if (element == null) {
				throw new POMMethodExecException("Not found the element: " + keyValue + ", for the Locator: " + property);
			}
		} catch (POMException e) {
			throw new POMMethodExecException("Not found the element: " + keyValue + ", for the Locator: " + property);
		}
		// first move to the element in the web page
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		try {
			element.click();
			element.sendKeys(Keys.END);
			element.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
			element.sendKeys(Keys.DELETE);
			element.sendKeys(data);
		} catch(Exception e){
			throw new POMMethodExecException("Not able to enter the text in the field: " + keyValue + ", for the Locator: " + property);
		}
	}
	
	

	public void executeJScript(WebDriver driver, String jsIdentifier) throws Exception {
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(jsIdentifier, CUR_APP);
			System.out.println(eleIdentifier);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(eleIdentifier);
		} catch (Exception e) {
			throw new POMMethodExecException("Could not execute Java Script method", e);
		}
	}

	public String getText(WebDriver driver, String locator, String keyValue) throws Exception {
		String returnText = null;
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println("eleIdentifier: " + eleIdentifier);
			WebElement ele = getWebElement(driver, locator, eleIdentifier);
			returnText = ele.getText();
			System.out.println("Return text for identifier: " + eleIdentifier + ", is: " + returnText);
			return returnText;
		} catch (Exception e) {
			throw new POMMethodExecException("Could find the webElement to get the Text", e);
		}
	}

	public boolean verifyElementIsSelected(WebDriver driver, String property, String keyValue) throws Exception {
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			WebElement ele = getWebElement(driver, property, eleIdentifier);
			boolean status = ele.isSelected();
			return status;
		} catch (Exception e) {
			throw new POMMethodExecException("Could find the checkbox webElement", e);
		}
	}

	public boolean verifyElementIsDisplayed(WebDriver driver, String property, String keyValue) throws Exception {
		try {
			boolean elementPresent = false;
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(elementPresent);
			WebElement ele = getWebElement(driver, property, eleIdentifier);
			elementPresent = ele.isDisplayed();
			return elementPresent;
		} catch (Exception e) {
			throw new POMMethodExecException("Could find the webElement", e);
		}
	}

	public WebElement getWebElement(WebDriver driver, String locator, String identifier) throws Exception {
		try {
			if (locator.toLowerCase().contains("linktext")) {
				return driver.findElement(By.linkText(identifier));
			} else if (locator.toLowerCase().contains("id")) {
				return driver.findElement(By.id(identifier));
			} else if (locator.toLowerCase().contains("name")) {
				return driver.findElement(By.name(identifier));
			} else if (locator.toLowerCase().contains("xpath")) {
				return driver.findElement(By.xpath("" + identifier + ""));
			} else if (locator.toLowerCase().contains("cssselector")) {
				return driver.findElement(By.cssSelector(identifier));
			} else if (locator.toLowerCase().contains("partiallinktext")) {
				return driver.findElement(By.partialLinkText(identifier));
			} else if (locator.toLowerCase().contains("classname")) {
				return driver.findElement(By.className(identifier));
			} else if (locator.toLowerCase().contains("tagname")) {
				return driver.findElement(By.tagName(identifier));
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Could not find the matching element", e);
		}
		return null;

	}

	// To enter the data on the object present in the POPUP Window
	public void cleardata(WebDriver driver, String property, String keyValue) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			WebElement ele;
			ele = getWebElement(driver, property, eleIdentifier);
			ele.clear();
		} catch (Exception e) {
			throw new POMMethodExecException("Could not clear the data.", e);
		}
	}

	// To Check a check box
	public void CheckChkBox(WebDriver driver, String property, String keyValue) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
		} catch (POMException e) {
			throw new POMMethodExecException("Could not check the CheckBox.", e);
		}
	}

	// To UnCheck a check box
	public void UncheckChkBox(WebDriver driver, String property, String keyValue) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
		} catch (POMException e) {
			throw new POMMethodExecException("Could not Uncheck the CheckBox.", e);
		}
	}


	// To Select the combo box option by passing the value
	public void SelectComboBoxByVisibleText(WebDriver driver, String property, String keyValue, String selectvalue) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			Select obj = new Select(getWebElement(driver, property, eleIdentifier));
			obj.selectByVisibleText(selectvalue);
		} catch (Exception e) {
			throw new POMMethodExecException("Could not select the value in the Combo box.", e);
		}
	}

	// To Select the combo box option by passing the value
	public void SelectComboBoxByIndex(WebDriver driver, String property, String keyValue, int index) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			Select obj = new Select(getWebElement(driver, property, eleIdentifier));
			obj.selectByIndex(index);
		} catch (Exception e) {
			throw new POMMethodExecException("Could not select the value in the Combo box.", e);
		}
	}

	// To Web Element text comparison
	public void verifyScreenText(WebDriver driver, String property, String keyValue, String verifyExpString) throws POMMethodExecException {

		WebElement ele;
		String actualText = "";
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			ele = getWebElement(driver, property, eleIdentifier);
			actualText = ele.getText();
		} catch (Exception e) {
			throw new POMMethodExecException("Could not extract the String.", e);
		}
		if (!actualText.trim().toLowerCase().contains(verifyExpString.trim().toLowerCase())) {
			throw new POMMethodExecException("The Expected value: " + verifyExpString + " and Actual Value: " + actualText + "dosenot match");
		}
	}


	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void acceptTheAlertWindow(WebDriver driver) throws POMMethodExecException {
		driver.switchTo().alert().accept();
	}

	public void clickElement(WebDriver driver, String property, String keyValue, long sec) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			// Keyword kw;
			WebDriverWait wait = new WebDriverWait(driver, sec);
			By ele;
			ele = getWebElementWait(driver, property, eleIdentifier);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
			element.click();
		} catch (Exception e) {
			// new
			throw new POMMethodExecException("Could not Click the button.", e);
		}
	}

	public void enterText(WebDriver driver, String property, String keyValue, String data, long sec) throws POMMethodExecException {

		WebDriverWait wait = new WebDriverWait(driver, sec);
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			By ele;
			ele = getWebElementWait(driver, property, eleIdentifier);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			element.sendKeys(data);
		} catch (Exception e) {
			throw new POMMethodExecException("Could not enter the text.", e);
		}
	}

	public By getWebElementWait(WebDriver driver, String locator, String identifier) throws Exception {
		try {
			if (locator.toLowerCase().contains("linktext")) {
				return By.linkText(identifier);
			} else if (locator.toLowerCase().contains("id")) {
				return By.id(identifier);
			} else if (locator.toLowerCase().contains("xpath")) {
				return By.xpath("" + identifier + "");
			} else if (locator.toLowerCase().contains("name")) {
				return By.name(identifier);
			} else if (locator.toLowerCase().contains("xpath")) {
				return By.xpath("" + identifier + "");
			} else if (locator.toLowerCase().contains("cssselector")) {
				return By.cssSelector(identifier);
			} else if (locator.toLowerCase().contains("partiallinktext")) {
				return By.partialLinkText(identifier);
			} else if (locator.toLowerCase().contains("classname")) {
				return By.className(identifier);
			} else if (locator.toLowerCase().contains("tagname")) {
				return By.tagName(identifier);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Could not fine the matching element", e);
		}
		return null;
	}

	public void SelectListBoxByVisibleText(WebDriver driver, String property, String keyValue, String selectvalue) throws POMMethodExecException {
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			Select obj = new Select(getWebElement(driver, property, eleIdentifier));
			obj.deselectAll();
			obj.selectByVisibleText(selectvalue);
		} catch (Exception e) {
			throw new POMMethodExecException("Could not select the value in the Combo box.", e);
		}
	}

	public void actionClick(WebDriver driver, String property, String keyValue) throws POMMethodExecException {
		Actions builder = new Actions(driver);
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			// Keyword kw;
			WebElement ele;
			ele = getWebElement(driver, property, eleIdentifier);
			builder.moveToElement(ele).click(ele).perform();
		} catch (Exception e) {
			// new
			throw new POMMethodExecException("Could not Click the button.", e);
		}
	}

	public void refreshTheBrowser(WebDriver driver, int waitTime) throws POMMethodExecException {
		driver.navigate().refresh();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// do not throw anything here.
		}
		wait(waitTime);
	}
}