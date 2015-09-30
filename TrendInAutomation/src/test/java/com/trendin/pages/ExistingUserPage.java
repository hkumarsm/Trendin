package com.trendin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.trendin.core.GetElementIdentifier;

public class ExistingUserPage {
	
	//To login to TrendIn application for existing user
	public void existingUser(WebDriver driver) throws Exception {
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("myAccountClickXpath", "ExistingUserPage"))).click();
			System.out.println("Clicked on My Account tab.");
		} catch (Exception e) {
			throw new Exception();
		}
		//To verify the title
		boolean textDisplayedStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("existingUserTextXpath", "ExistingUserPage"))).isDisplayed();
		try {
			if(textDisplayedStatus) {
				System.out.println("Title is verified");
			} else {
				System.out.println("Title not verified.");
			}
		} catch(Exception e) {
			throw new Exception();
		}
		//To enter email address
		try {
			driver.findElement(By.xpath("//input[@id='sleEmail' and @placeholder='Enter email']")).sendKeys("sampriya.raviraj@gmail.com");
			System.out.println("Successfully entered the email");
		} catch (Exception e) {
			throw new Exception();
		}
		//To enter password
		try {
			driver.findElement(By.xpath("//input[@id='slePassword' and @placeholder='Password']")).sendKeys("qwerty");
			System.out.println("Successfully entered the password");
		} catch (Exception e) {
			throw new Exception();
		}
		//To click on submit button
		try {
			driver.findElement(By.xpath("//button[@id='btnCustomerAuthLogin']")).click();
			System.out.println("Successfully clicked on the submit button");
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	//To logout from TrendIn application
	public void logoutTrendIn(WebDriver driver) throws Exception {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutClickCss", "ExistingUserPage")));
		act.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("logoutButtonCss","ExistingUserPage")));
		act.click(ele1).build().perform();
		System.out.println("Clicked on logout");
		
	}
	
	//To click on forgot password when user log in using existing user
	public void forgotPassword(WebDriver driver) throws Exception {
		//To click on 'My Account' link
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("myAccountClickXpath", "ExistingUserPage"))).click();
			System.out.println("Clicked on My Account tab.");
		} catch (Exception e) {
			throw new Exception();
		}
		//To click on 'Forgot Password' link
		try {
			driver.findElement(By.cssSelector(GetElementIdentifier.getProperty("forgotPasswordLinkCss", "ExistingUserPage"))).click();
			System.out.println("Successfully clicked on Forgot Password link");
		} catch (Exception e) {
			throw new Exception();
		}
		//To enter 'Email'
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("forgotEmailXpath", "ExistingUserPage"))).sendKeys("sampriya.raviraj@gmail.com");
			System.out.println("Successfully entered the email");
		} catch (Exception e) {
			throw new Exception();
		}
		//To capture the text(number) and enter the captured text
		try {
			String captureText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("captureNumberXpath","ExistingUserPage"))).getText();
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("captureTextXpath","ExistingUserPage"))).sendKeys(captureText);
			System.out.println("Successfully entered the captured text");
		} catch (Exception e) {
			throw new Exception();
		}
		//To click on 'Forgot Password' button
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("forgotPasswordButton","ExistingUserPage"))).click();
			System.out.println("successfully clicked on 'Forgot your Password' button");
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
