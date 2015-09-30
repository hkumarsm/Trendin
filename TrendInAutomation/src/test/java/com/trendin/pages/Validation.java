package com.trendin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.trendin.core.ElementOperation;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;

public class Validation extends TrendInTestSuite {
	
	
	static String curApp = "Validation";
	
	ElementOperation eo = new ElementOperation(curApp);
	
	public void ValidateMobileNumberField(WebDriver driver) throws Exception {
		try {
			eo.clickElement(driver, "XPath", "loginTextXpath");
			addComment("Successfully clicked on ligin/register link");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("yourNameXpath", "Validation"))).sendKeys("suresh");
			addComment("Successfully entered name field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("emailXpath", "Validation"))).sendKeys("babu@yahoo.in");
			addComment("Successfully entered email field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("passwordXpath", "Validation"))).sendKeys("1234567 ");
			addComment("Successfully entered password field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).sendKeys("qwertyu");
			addComment("Successfully entered mobile number field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("btnLoginForHimXpath", "Validation"))).click();
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).isDisplayed();
			String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).getText();	
			if(text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")){
			addComment("Successfully error message is displayed when only alphabets mobile number is entered :" +text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		
		driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).clear();
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).sendKeys(")(*&^%$#@!");
			addComment("Successfully entered mobile number field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("btnLoginForHimXpath", "Validation"))).click();
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).isDisplayed();
			String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).getText();	
			if(text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")){
			addComment("Successfully error message is displayed when only only special characters mobile number is entered :" +text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		
		
		driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).clear();
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).sendKeys("!@#$%abcdef");
			addComment("Successfully entered mobile number field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("btnLoginForHimXpath", "Validation"))).click();
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).isDisplayed();
			String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).getText();	
			if(text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")){
			addComment("Successfully error message is displayed when  combination of special characters and alphabets mobile number is entered :" +text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		
		driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).clear();
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).sendKeys("fghij67890");
			addComment("Successfully entered mobile number field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("btnLoginForHimXpath", "Validation"))).click();
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).isDisplayed();
			String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).getText();	
			
			if(text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")){
			addComment("Successfully error message is displayed when Alphanumeric characters mobile number is entered : " +text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		

		driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).clear();
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).sendKeys("ab12!@cd12");
			addComment("Successfully entered mobile number field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("btnLoginForHimXpath", "Validation"))).click();
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).isDisplayed();
			String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).getText();	
			if(text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")){
			addComment("Successfully error message is displayed when combination of special characters and alphanumeric characters mobile number is entered :" +text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		
		driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).clear();
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("mobileNumberXpath", "Validation"))).sendKeys(" ");
			addComment("Successfully entered mobile number field");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.id(GetElementIdentifier.getProperty("btnLoginForHimXpath", "Validation"))).click();
			addComment("Successfully clicked on for him link");
		} catch (Exception e) {
			throw new Exception();
		}
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).isDisplayed();
			String text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberValidationXpath", "Validation"))).getText();	
			if(text.equalsIgnoreCase("Please enter a valid 10 digit mobile number.")){
			addComment("Successfully error message is displayed when MOBILE NUMBER Field is Blank :" +text);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}
	

}
