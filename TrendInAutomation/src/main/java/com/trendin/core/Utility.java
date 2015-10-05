package com.trendin.core;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.trendin.core.util.exceptions.POMMethodExecException;

public abstract class Utility extends TrendInTestSuite {
	public static boolean runningTestInLocal = true;
	public static String sleepBetweenPollsMillis = "30";
	public static String maxWaitTimeSeconds = "60";
	
	/**
	 * Read the test data from excel file column values
	 * @param colValue
	 * @return The initial column value (row 1 value of the particular column)
	 * @author Hemanth Kumar S M
	 * @return 
	 */
	public static String readExcelData(String colValue) {
		ArrayList<String> values = new ArrayList<String>();
		// Get the data from excel file
		values.add(ExcelReader.ReadCell(ExcelReader.GetCell(colValue), 1));
		return values.get(0);
	}
	
	/**
	 * Waits until a given element exists or does not exist.
	 * @param driver
	 * @param byLocator 
	 * @param identifier
	 * @param expected >> True/False based on the Element should exists or not
	 * @param locatorApp
	 * @return true if successful, false if expectation never happens.
	 * @author Hemanth Kumar S M
	 * @return 
	 */
	public static boolean waitUntilExists(WebDriver driver, String byLocator, String identifier, String expected, String locatorApp) throws Exception {
		boolean status = false;
		WebElement element = null;
		ElementOperation elementOperation = new ElementOperation(locatorApp);
		try {
			double timeBetween = Double.parseDouble(sleepBetweenPollsMillis) / 1000;
			long tries = Math.round(Long.parseLong(maxWaitTimeSeconds) / timeBetween);
			String eleIdentifier = "";
			for (int i = 0; i < tries; i++) {
				try {
					eleIdentifier = GetElementIdentifier.getProperty(identifier, locatorApp);
					System.out.println(eleIdentifier);
					element = elementOperation.getWebElement(driver, byLocator, eleIdentifier);
					if(element.isDisplayed()) {
						status = true;
					}
				}
				catch (Exception e) {
					status = false;
					throw new POMMethodExecException("Not able to locate the webelement.", e);
				}
				if (expected.equalsIgnoreCase("FALSE"))
					status = !status;
				if (status)
					break;
				else
					sleep(timeBetween);
			}
		}
		catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	/**
	 * Waits until a given element exists or does not exist.
	 * @param driver
	 * @param byLocator 
	 * @param identifier
	 * @param locatorApp
	 * @return true if successful, false if expectation never happens.
	 * @author Hemanth Kumar S M
	 * @return True/False
	 */
	public static boolean waitUntilExists(WebDriver driver, String byLocator, String identifier, String locatorApp) throws Exception {
		boolean status = false;
		WebElement element = null;
		Actions actions = new Actions(driver);
		ElementOperation elementOperation = new ElementOperation(locatorApp);
		String expected = "TRUE";
		try {
			double timeBetween = Double.parseDouble(sleepBetweenPollsMillis) / 1000;
			long tries = Math.round(Long.parseLong(maxWaitTimeSeconds) / timeBetween);
			String eleIdentifier = "";
			for (int i = 0; i < tries; i++) {
				try {
					eleIdentifier = GetElementIdentifier.getProperty(identifier, locatorApp);
					System.out.println(eleIdentifier);
					element = elementOperation.getWebElement(driver, byLocator, eleIdentifier);
					actions.moveToElement(element).build().perform();
					if(element.isDisplayed()) {
						status = true;
					}
				}
				catch (Exception e) {
					status = false;
					throw new POMMethodExecException("Not able to locate the webelement.", e);
				}
				if (expected.equalsIgnoreCase("FALSE"))
					status = !status;
				if (status || i>=50)
					break;
				else
					sleep(timeBetween);
			}
		}
		catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	/**
	 * Sleep execution for a given amount of time in seconds.
	 * @param seconds The time to wait in seconds.
	 * @author Hemanth Kumar S M
	 */
	protected static void sleep(double seconds) {
		try {
			Thread.sleep((long)(seconds * 1000));
		}
		catch (Exception e) {}
	}
	
	/**
	 * Wait until the given element is clickable.
	 * @param driver
	 * @param byLocator 
	 * @param identifier
	 * @param locatorApp
	 * @param maxWaitTimeSeconds The max amount of time in seconds to wait.
	 * @return true once done, false if time expires.
	 * @author Hemanth Kumar S M
	 */
	public static boolean waitUntilClickable(WebDriver driver, String byLocator, String identifier, String locatorApp, String maxWaitTimeSeconds) 
		throws Exception {
		boolean status = true;
		WebElement element = null;
		ElementOperation elementOperation = new ElementOperation(locatorApp);
		String eleIdentifier = "";
		try {
			eleIdentifier = GetElementIdentifier.getProperty(identifier, locatorApp);
			System.out.println(eleIdentifier);
			element = elementOperation.getWebElement(driver, byLocator, eleIdentifier);
		} catch(Exception e){
			status = false;
			throw new POMMethodExecException("Not able to locate the webelement.", e);
		}
		try {
			if (maxWaitTimeSeconds != null && !maxWaitTimeSeconds.trim().equals(""))
				setTempWaiterTimes(Long.parseLong(maxWaitTimeSeconds), Long.parseLong(sleepBetweenPollsMillis));
				getWaiter().until(ExpectedConditions.elementToBeClickable(element));
			if (maxWaitTimeSeconds != null && !maxWaitTimeSeconds.trim().equals(""))
				setTempWaiterTimes(Long.parseLong(Utility.maxWaitTimeSeconds), Long.parseLong(sleepBetweenPollsMillis));
		}
		catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	/**
	 * Sets the waiter with the given max wait time in seconds and sleep
	 * between polls in milliseconds, but does not set the global values,
	 * allowing the waiter to be returned to the global values.
	 * @param maxWaitTimeSeconds Max wait time in seconds for the waiter.
	 * @param sleepBetweenPollsMillis Sleep time in milliseconds for the waiter.
	 * @return true if successful, false if bad input.
	 * @author Hemanth Kumar S M
	 */
	private static boolean setTempWaiterTimes(long maxWaitTimeSeconds, long sleepBetweenPollsMillis) {
		boolean status = true;
		try {
			if (driver != null)
				setDefaultTimes(maxWaitTimeSeconds, sleepBetweenPollsMillis);
		}
		catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	/**
	 * Wait until the given element is invisible. This wait does not use the baseElement feature. 
	 * It always searches for the Element from the browser.
	 * @param driver
	 * @param byLocator 
	 * @param identifier
	 * @param locatorApp
	 * @param maxWaitTimeSeconds The max amount of time in seconds to wait.
	 * @return true once done, false if time expires.
	 * @author Hemanth Kumar S M
	 */
	public static boolean waitUntilInvisible(WebDriver driver, String byLocator, String identifier, String locatorApp, String maxWaitTimeSeconds) throws Exception {
		ElementOperation elementOperation = new ElementOperation(locatorApp);
		String eleIdentifier = "";
		WebElement element = null;
		try {
			eleIdentifier = GetElementIdentifier.getProperty(identifier, locatorApp);
			System.out.println(eleIdentifier);
			element = elementOperation.getWebElement(driver, byLocator, eleIdentifier);
		} catch(Exception e){
			throw new POMMethodExecException("Not able to locate the webelement.", e);
		}
		return waitUntilInvisible(element, maxWaitTimeSeconds);
	}
	
	/**
	 * Wait until the given element is invisible. This wait does not use the
	 * baseElement feature. It always searches for the Element from the browser.
	 * >> (An expectation for checking that an element is either invisible or not present on the DOM)
	 * @param friendlyName
	 * @param maxWaitTimeSeconds The max amount of time in seconds to wait.
	 * @param skip
	 * @return true once done, false if time expires.
	 * @author Hemanth Kumar S M
	 */
	public static boolean waitUntilInvisible(WebElement element, String maxWaitTimeSeconds) {
		boolean ans = true;
		try {
			if (maxWaitTimeSeconds != null && !maxWaitTimeSeconds.trim().equals(""))
				setTempWaiterTimes(Long.parseLong(maxWaitTimeSeconds), Long.parseLong(sleepBetweenPollsMillis));
			getWaiter().until(
					ExpectedConditions.invisibilityOfElementLocated((By) element));
			if (maxWaitTimeSeconds != null && !maxWaitTimeSeconds.trim().equals(""))
				setTempWaiterTimes(Long.parseLong(Utility.maxWaitTimeSeconds), Long.parseLong(sleepBetweenPollsMillis));
		}
		catch (Exception e) {
			ans = false;
		}
		return ans;
	}
	
	
	/**
	 * Wait until the given element is visible.
	 * @param byLocator 
	 * @param identifier
	 * @param locatorApp
	 * @param maxWaitTimeSeconds The max amount of time in seconds to wait.
	 * @return true once done, false if time expires.
	 * @author Hemanth Kumar S M
	 */
	public boolean waitUntilVisible(WebDriver driver, String byLocator, String identifier, String locatorApp, String maxWaitTimeSeconds) throws Exception {
		ElementOperation elementOperation = new ElementOperation(locatorApp);
		String eleIdentifier = "";
		WebElement element = null;
		try {
			eleIdentifier = GetElementIdentifier.getProperty(identifier, locatorApp);
			System.out.println(eleIdentifier);
			element = elementOperation.getWebElement(driver, byLocator, eleIdentifier);
		} catch(Exception e){
			throw new POMMethodExecException("Not able to locate the webelement.", e);
		}
		return waitUntilVisible(element, maxWaitTimeSeconds);
	}
	
	
	/**
	 * Wait until the given element is visible.
	 * @param friendlyName
	 * @param maxWaitTimeSeconds The max amount of time in seconds to wait.
	 * @param skip
	 * @return true once done, false if time expires.
	 * @author Hemanth Kumar S M
	 */
	public static boolean waitUntilVisible(WebElement element, String maxWaitTimeSeconds) {
		boolean ans = true;
		try {
			if (maxWaitTimeSeconds != null && !maxWaitTimeSeconds.trim().equals(""))
				setTempWaiterTimes(Long.parseLong(maxWaitTimeSeconds), Long.parseLong(sleepBetweenPollsMillis));
			getWaiter().until(
					ExpectedConditions.visibilityOf(element));
			if (maxWaitTimeSeconds != null && !maxWaitTimeSeconds.trim().equals(""))
				setTempWaiterTimes(Long.parseLong(Utility.maxWaitTimeSeconds), Long.parseLong(sleepBetweenPollsMillis));
		}
		catch (Exception e) {
			ans = false;
		}
		return ans;
	}
}
