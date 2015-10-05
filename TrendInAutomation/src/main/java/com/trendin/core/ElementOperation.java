package com.trendin.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.trendin.core.util.exceptions.POMException;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class ElementOperation {
	private String CUR_APP;

	public ElementOperation(String app) {
		CUR_APP = app;
	}
	
	/**
	 * Double clicks on the element (using Actions class)
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void doubleClickElement (WebDriver driver, String property, String keyValue) throws Exception {
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
		// Now double click on the web Element
		try {
			action.doubleClick().build().perform();
		} catch (Exception e) {
			throw new POMMethodExecException("Could not Double Click the element: "+ keyValue + ", for the locator: "+ property, e);
		}
	}
	
	/**
	 * Clicks on the element 
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return void
	 * @author Hemanth Kumar S M
	 */
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
	
	/**
	 * Enters the text in the text box by replacing the existing text (clearing the old data)
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @param data >> The value to be entered into the text box
	 * @return void
	 * @author Hemanth Kumar S M
	 */
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
	
	
	/**
	 * Used to execute the Javascript in the current page
	 * @param driver >> Webdriver element
	 * @param jsIdentifier >> Jscript code to be executed, taken from the .properties file
	 * @return void
	 * @author Hemanth Kumar S M
	 */
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
	
	/**
	 * Used to get the text value from the webelement
	 * @param driver >> Webdriver element
	 * @param locator >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return Extracted text from the webelement
	 * @author Hemanth Kumar S M
	 */
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
			throw new POMMethodExecException("Could not the webElement to get the Text", e);
		}
	}
	
	/**
	 * Used to get the Webelement checkbox value is Checked or not
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return true if element is Selected, false otherwise
	 * @author Hemanth Kumar S M
	 */
	public boolean verifyElementIsSelected(WebDriver driver, String property, String keyValue) throws Exception {
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			WebElement ele = getWebElement(driver, property, eleIdentifier);
			boolean status = ele.isSelected();
			return status;
		} catch (Exception e) {
			throw new POMMethodExecException("Could not the checkbox webElement", e);
		}
	}
	
	/**
	 * Used to get the Webelement display status in the current web page
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return true if element is Displayed, false otherwise
	 * @author Hemanth Kumar S M
	 */
	public boolean verifyElementIsDisplayed(WebDriver driver, String property, String keyValue) throws Exception {
		try {
			boolean elementPresent = false;
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			WebElement ele = getWebElement(driver, property, eleIdentifier);
			elementPresent = ele.isDisplayed();
			System.out.println(elementPresent);
			return elementPresent;
		} catch (Exception e) {
			throw new POMMethodExecException("Could not find the webElement", e);
		}
	}
	
	/**
	 * Used to get the Webelement (with the combination of the 'locator' and 'identifier' params)
	 * @param driver >> Webdriver element
	 * @param locator >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return Webelement if it is located, null if not
	 * @author Hemanth Kumar S M
	 */
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

	/**
	 * Used to Clear the text box value
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void clearData(WebDriver driver, String property, String keyValue) throws POMMethodExecException {

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

	/**
	 * Used to Select the Check box (check)
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void checkChkBox(WebDriver driver, String property, String keyValue) throws POMMethodExecException {
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
		} catch (POMException e) {
			throw new POMMethodExecException("Could not check the CheckBox.", e);
		}
	}

	/**
	 * Used to Select the UnCheck box 
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void uncheckChkBox(WebDriver driver, String property, String keyValue) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
		} catch (POMException e) {
			throw new POMMethodExecException("Could not Uncheck the CheckBox.", e);
		}
	}


	/**
	 * Used to Select the Combobox value by the 'Visible text' option.
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @param selectvalue >> Value to be selected from the Combobox
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void selectComboBoxByVisibleText(WebDriver driver, String property, String keyValue, String selectvalue) throws POMMethodExecException {
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			Select obj = new Select(getWebElement(driver, property, eleIdentifier));
			obj.selectByVisibleText(selectvalue);
		} catch (Exception e) {
			throw new POMMethodExecException("Could not select the value in the Combo box.", e);
		}
	}

	/**
	 * Used to Select the Combobox value by the 'Index' option (on the basis of appearance in the option tag).
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @param index >> Index value to be selected from the Combobox
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void selectComboBoxByIndex(WebDriver driver, String property, String keyValue, int index) throws POMMethodExecException {

		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			Select obj = new Select(getWebElement(driver, property, eleIdentifier));
			obj.selectByIndex(index);
		} catch (Exception e) {
			throw new POMMethodExecException("Could not select the value in the Combo box.", e);
		}
	}
	
	/**
	 * Used to provide static wait for the specified time
	 * @param time >> Time value to make the execution pause
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to Accept the Alert window (clicks on OK button in the Alert window)
	 * @param driver >> Webdriver element
	 * @return void
	 * @author Hemanth Kumar S M
	 */
	public void acceptTheAlertWindow(WebDriver driver) throws POMMethodExecException {
		driver.switchTo().alert().accept();
	}

	/**
	 * Designed to retrieve the Window Title from the current active window
	 * @param driver >> Webdriver element
	 * @return Window title value 
	 * @author Hemanth Kumar S M
	 */
	public String getWindowTitle(WebDriver driver) throws Exception {
		String windowTitle = "";
		try {
			windowTitle = driver.getTitle();
		} catch(Exception e){
			throw new POMMethodExecException("Could not get the window title ", e);
		}
		if(windowTitle.length() == 0){
			throw new POMMethodExecException("The window title is not present for the current window.");
		}
		return windowTitle;
	}
	
	/**
	 * Designed for select. Returns all options' texts as a String[]. 
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return All options' texts as a String[].
	 * @author Hemanth Kumar S M
	 */
	protected String[] getOptionsTexts(WebDriver driver, String property, String keyValue) throws Exception {
		String[] options = null;
		try {
			String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
			System.out.println(eleIdentifier);
			WebElement ele;
			ele = getWebElement(driver, property, eleIdentifier);
			WebElement[] e = getOptions(ele);
			options = new String[e.length];
			for (int i = 0; i < options.length; i++)
				options[i] = e[i].getText();
		}
		catch (Exception e) {
			options = null;
			throw new POMMethodExecException("Could not get all the Options of the Combobox", e);
		}
		return options;
	}
	
	/**
	 * Designed for select. Returns all options of this select as WebElement[].
	 * @param webElemet
	 * @return All options as WebElement[]
	 * @author Hemanth Kumar S M
	 */
	protected WebElement[] getOptions(WebElement webElemet) throws Exception {
		WebElement[] options = null;
		try {
			List <WebElement> e  = new Select(webElemet).getOptions();
			options = new WebElement[e.size()];
			e.toArray(options);
		}
		catch (Exception e) {
			options = null;
			throw new POMMethodExecException("Could not get all the Options of the Combobox", e);
		}
		return options;
	}
	
	/**
	 * Moves the mouse to the middle of the element and holds it there for 500 milliseconds.
	 * @param driver >> Webdriver element
	 * @param property >> Webelement locator type 
	 * @param keyValue >> Property name to be picked
	 * @return true if successful, false otherwise
	 * @author Hemanth Kumar S M
	 */
	public boolean hover(WebDriver driver, String property, String keyValue) throws Exception {
		String eleIdentifier = GetElementIdentifier.getProperty(keyValue, CUR_APP);
		System.out.println(eleIdentifier);
		WebElement ele;
		try {
			ele = getWebElement(driver, property, eleIdentifier);
		} catch(Exception e){
			throw new POMMethodExecException("Could not find the webElement", e);
		}
		return hover(driver, ele, "", "");
	}
	
	/**
	 * Moves the mouse to the middle of the element, or moves it to an offset
	 * from the top left corner, and holds it there for
	 * 500 milliseconds.
	 * @param driver >> Webdriver element
	 * @param element >> WebElement object on which the mouse hover should be done
	 * @param xOffset Offset from the top-left corner. A negative value means coordinates left from the element.
	 * @param yOffset Offset from the top-left corner. A negative value means coordinates above the element.
	 * @return true if successful, false otherwise
	 * @author Hemanth Kumar S M
	 */
	public boolean hover(WebDriver driver, WebElement element, String xOffset, String yOffset){
		boolean status = true;
		try {
			if (xOffset.equals("") || yOffset.equals(""))
				new Actions(driver).moveToElement(element).perform();
			else
				new Actions(driver).moveToElement(element,
						Integer.parseInt(xOffset),
						Integer.parseInt(yOffset)).perform();

			wait(5000);
		}
		catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	
	
}