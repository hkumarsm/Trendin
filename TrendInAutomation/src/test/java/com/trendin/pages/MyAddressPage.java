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

public class MyAddressPage extends TrendInTestSuite {
	final String curApp = "MyAddressPage";
	ElementOperation eo = new ElementOperation(curApp);
	
	//Mouse hover on User Name.
	public void mouseHoverOnUserName(WebDriver driver) throws Exception {
		
		try {
			Thread.sleep(2000);
			Actions action = new Actions(driver);			
			WebElement ele = driver.findElement(By.xpath(GetElementIdentifier.getProperty("dropDownOfUsersXpath", "MyAddressPage")));
			action.moveToElement(ele).build().perform();
			
			List<WebElement> allUsersDropDownMenuList = driver.findElements(By.xpath(GetElementIdentifier.getProperty("usersAllDropDownMenuXpath", "MyAddressPage")));
			int count = 0;
			String tempuUersDropDownMenuXpath = GetElementIdentifier.getProperty("usersDropDownMenuXpath", "MyAddressPage");
			for(int i = 0 ; i < allUsersDropDownMenuList.size(); i++) {
				String replaceTempuUersDropDownMenuXpath = tempuUersDropDownMenuXpath.replace("'{replaceI}'", String.valueOf(i+1));
				boolean usersDropDownListDispalyStatus = driver.findElement(By.xpath(replaceTempuUersDropDownMenuXpath)).isDisplayed();
				if(usersDropDownListDispalyStatus) {
					String getUserDropDownName = driver.findElement(By.xpath(replaceTempuUersDropDownMenuXpath)).getText();
					addComment("Users Drop down  displayed Menu is: "+getUserDropDownName);
					count++;
				} else {
					throw new POMMethodExecException("Users Drop down Menu is not displaed.");
				}
				
			}
			
			if(count == allUsersDropDownMenuList.size()) {
				addComment("All Users drop down  menu items are displayed.");
			} else {
				throw new POMMethodExecException("All Users drop down  menu items are not displayed.");
			}
			
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to hover mouse on UserName");
		}
		
	}
	
	//To click on particular drop down menu item.
	public void clickDropDownUsersMenuItem(WebDriver driver, String userDropDownName) throws Exception { 
		
		
		try{
//			Thread.sleep(2000);
		    String tempSelectUserDropDownXpath = GetElementIdentifier.getProperty("selectUserDropDownXpath", "MyAddressPage");
			String replaceTempSelectUserDropDownXpath = tempSelectUserDropDownXpath.replace("{replace}", userDropDownName);
			WebElement option = driver.findElement(By.xpath(replaceTempSelectUserDropDownXpath));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", option);
		    addComment("Clicked on users drop down menu is: "+userDropDownName);

		   } catch(Exception e) {
		    throw new POMMethodExecException("Unable to click on users drop down particular menu list.",e);
		   }
		
		/*try {
			String winHandleBefore = driver.getWindowHandle();
			driver.switchTo().window(winHandleBefore);
			String tempSelectUserDropDownXpath = GetElementIdentifier.getProperty("selectUserDropDownXpath", "MyAddressPage");
			String replaceTempSelectUserDropDownXpath = tempSelectUserDropDownXpath.replace("{replace}", userDropDownName);
			driver.findElement(By.xpath(replaceTempSelectUserDropDownXpath)).click();
			addComment("Clicked on users drop down menu is: "+userDropDownName);
			
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to click on users drop down particular menu list.",e);
		}*/
	}
	
	//To click on left hand side links.
	public void clickOnLeftHandSideUILinks(WebDriver driver, String leftSideLinkName) throws Exception { 
		try {
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			String tempLeftSideLinksXpath = GetElementIdentifier.getProperty("leftSideLinksXpath", "MyAddressPage");
			String replaceTempLeftSideLinksXpath = tempLeftSideLinksXpath.replace("{replaceLeftHandSideLinks}", leftSideLinkName);
			WebElement ele = driver.findElement(By.xpath(replaceTempLeftSideLinksXpath));
			action.moveToElement(ele).build().perform();
			driver.findElement(By.xpath(replaceTempLeftSideLinksXpath)).click();
			driver.findElement(By.xpath(replaceTempLeftSideLinksXpath)).click();
			addComment("Clicked on Left hand side link is: "+leftSideLinkName);
			
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to click on Left hand side link.");
		}
	}
	
	//Verify My address page.
	public void verifyMyAddressPage(WebDriver driver, String addressName) throws Exception {
		//To verify My address is displayed.
		Thread.sleep(2000);
		try {
			boolean myAddressDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("myAddressXpath", "MyAddressPage"))).isDisplayed();
			if(myAddressDisplayStatus) {
				addComment("My address is displayed.");
			} else {
				throw new POMMethodExecException("My address is not displayed.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("My address is not displayed.");
		}
		
		//To verify Add an address is displayed.
		try {
			eo.wait(2000);
			boolean addAnAddressDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("addAdressXpath", "MyAddressPage"))).isDisplayed();
			if(addAnAddressDisplayStatus) {
				addComment("Add an address is displayed.");
			} else {
				throw new POMMethodExecException("Add an address is not displayed.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Add an address is not displayed.",e);
		}
		//To verify Edit icon is displayed.
		try {
			String tempEditAddressIconXpath = GetElementIdentifier.getProperty("editAddressIconXpath", "MyAddressPage");
			String replaceTempEditAddressIconXpath = tempEditAddressIconXpath.replace("{replaceAddress}", addressName);
			boolean editIconDisplayStatus= driver.findElement(By.xpath(replaceTempEditAddressIconXpath)).isDisplayed();
			if(editIconDisplayStatus) {
				addComment("Edit Icon is displayed.");
			} else {
				throw new POMMethodExecException("Edit Icon is not displayed.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Edit Icon is not displayed.", e);
		}
		//To verify delete Icon is displayed.
		try {
			String tempDeleteAddressIconXpath = GetElementIdentifier.getProperty("deleteAddressIconXpath", "MyAddressPage");
			String replaceTempDeleteAddressIconXpath = tempDeleteAddressIconXpath.replace("{replaceAddress}", addressName);
			boolean deleteIconDisplayStatus= driver.findElement(By.xpath(replaceTempDeleteAddressIconXpath)).isDisplayed();
			if(deleteIconDisplayStatus) {
				addComment("Delete Icon is displayed.");
			} else {
				throw new POMMethodExecException("Delete Icon is not displayed.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Delete Icon is not displayed.", e);
		}
		//To verify Name, Address and Phone no. is displayed.
		try {
			
			String[] uiElements = {"Mobile No","Name","Address"};
			String tempUiElementsofMyAddressPageXpath = GetElementIdentifier.getProperty("uiElementsofMyAddressPageXpath", "MyAddressPage");
			String replaceTempUiElementsofMyAddressPageXpath = tempUiElementsofMyAddressPageXpath.replace("{replaceaddressName}", addressName);
			for(int i = 0; i < uiElements.length; i++ ) {
				String replaceWithUiElement = replaceTempUiElementsofMyAddressPageXpath.replace("{replaceUiElementName}", uiElements[i]);
				boolean uiElementDisplayStatus= driver.findElement(By.xpath(replaceWithUiElement)).isDisplayed();
				if(uiElementDisplayStatus) {
					addComment("Address Page Ui element is displayed i.e: "+uiElements[i]);
				} else {
					throw new POMMethodExecException("Address Page Ui element is not displayed i.e: "+uiElements[i]);
				}
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Address Page Ui element is not displayed ", e);
		}
		
	}
	
	//To click on Add Address.
	public void clickOnAddAddress(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "addAdressXpath");
		addComment("Clicked on Add Address link.");
	}
	
	//Verify Add address pop up.
	public void verifyAddAddressPopUp(WebDriver driver) throws Exception {
		try {
			Thread.sleep(2000);
			String expectedNewAddressText = "New Address";
			String actualNewAddressText = eo.getText(driver, "xPath", "newAddAddressTextXpath");
			//verify new address text.
			assertEqualsIgnoreCase(expectedNewAddressText, actualNewAddressText, "Expected new address text is : "+expectedNewAddressText+ " same as actual new address text: "+actualNewAddressText+ "Pop-Up is displayed.",
					"Expected new address text is not same as Actual new address text.");
			//Check zip/postal is displayed.
			boolean zipPostalDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("zipPostalCodeXpath", "MyAddressPage"))).isDisplayed();
			if(zipPostalDisplayStatus) {
				addComment("Zip/postal code Displayed in Ui.");
			} else {
				throw new POMMethodExecException("Zip/postal code is not Displayed in Ui.");
			}
			//Check check butoon is displayed.
			boolean checkButtonDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("checkButtonXpath", "MyAddressPage"))).isDisplayed();
			if(checkButtonDisplayStatus) {
				addComment("Check button is Displayed in Ui.");
			} else {
				throw new POMMethodExecException("Check button is not Displayed in Ui.");
			}
			
			//check * Required field is displayed.
			boolean requiredFieldDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("requiredFieldXpath", "MyAddressPage"))).isDisplayed();
			if(requiredFieldDisplayStatus) {
				addComment("* required field is displayed in Ui.");
			} else {
				throw new POMMethodExecException("* required field is displayed in Ui.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to verify Add Address pop-up.",e);
		}
		
	}
	
	//To enter zip/postal code.
	public void enterZip(WebDriver driver,String zipCode) throws Exception {
		//Enter zip code.
		try {
			Thread.sleep(2000);
			eo.enterText(driver, "xpath", "enterZipCodeXpath", zipCode);
			addComment("Entered zip code is : "+zipCode);
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to Enter zip code.");
		}
	}
	//
	public void clickOnCheck(WebDriver driver) throws Exception {
		//Click on check Button.
		try {
			driver.findElement(By.xpath(GetElementIdentifier.getProperty("checkButtonXpath", curApp))).click();
			// eo.clickElement(driver, "xPath", "checkButtonXpath");
			addComment("clicked on Check button.");
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on check button.", e);
		}
	}
	//Verify new address pop-up after click on zip-code check.
	public void verifyNewAddressPopUpAfterClickOnCheck(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		try {
			int uiElementsCount = 0;
			List<WebElement> allUiElementsOfAddAddress = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allUiElementsXpath", "MyAddressPage")));
			String tempAddAddressUiElementXpath = GetElementIdentifier.getProperty("addAddressUiElementXpath", "MyAddressPage");
			for(int i=0; i < allUiElementsOfAddAddress.size(); i++){
				String replaceTempAddAddressUiElementXpath = tempAddAddressUiElementXpath.replace("'{replaceI}'", String.valueOf(i+1));
				boolean uiElementDisplayStatus = driver.findElement(By.xpath(replaceTempAddAddressUiElementXpath)).isDisplayed();
				if(uiElementDisplayStatus) {
					String getUiElementText = driver.findElement(By.xpath(replaceTempAddAddressUiElementXpath)).getText();
					addComment("Ui element is diaplayed i.e : "+getUiElementText);
					uiElementsCount++;
				} else {
					throw new POMMethodExecException("Ui elemnt is not displayed.");
				}
				
			} 
			if(uiElementsCount == allUiElementsOfAddAddress.size()) {
				addComment("Add address pop up's All UI elements are displayed.");
			} else {
				throw new POMMethodExecException("Add address pop up's All UI elements are not displayed.");
			}
			//To verify Reset form and save my address buttons are displayed.
			boolean resetFormDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("resetFormButtonXpath", "MyAddressPage"))).isDisplayed();
			boolean	saveMyAddressDisplayStatus = driver.findElement(By.xpath(GetElementIdentifier.getProperty("resetFormButtonXpath", "MyAddressPage"))).isDisplayed();
			
			if(resetFormDisplayStatus && saveMyAddressDisplayStatus) {
				addComment("Reset form and save my address buttons are displayed.");
			} else {
				throw new POMMethodExecException("Reset form and save my address buttons are not displayed.");
			}
			
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to verify check zip code New Address Pop-up.");
		}
		
	}
	
	//To click on save my address.
	public void clickOnSaveMyAddress(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "saveMyAddressButtonXpath");
		addComment("Clicked on Save my Address.");
	}
	
	//Verify * mandatory field error messages of add address.
	public void verifyFieldsErrorMessageOfAddMyAddress(WebDriver driver) throws Exception {
		//To verify mandatory field error message of first name.
		Thread.sleep(2000);
		//To verify first name error message.
		try {
			String getfirstNameText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("firstnameXpath", "MyAddressPage"))).getText().trim();
			if(getfirstNameText.length() < 1) {
				String expectedErrorMsg = "The firstname is required";
				String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("firstNameErrorMsgXpath", "MyAddressPage"))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("First name actual error message is: "+actualErrorMsg+" same as expected error message "+expectedErrorMsg);
				} else {
					throw new POMMethodExecException("First name actual error message is: "+actualErrorMsg+" not same as expected error message "+expectedErrorMsg);
				}
			} 
		} catch(Exception e) {
			throw new POMMethodExecException("First name actual error message is not same as expected error message",e);
		}
		
		//To verify Address1 error message.
		try {
			String getAddress1Text = driver.findElement(By.xpath(GetElementIdentifier.getProperty("addressLine1Xpath", "MyAddressPage"))).getText().trim();
			if(getAddress1Text.length() < 1) {
				String expectedErrorMsg = "The address is required";
				String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("address1ErrorMsgXpath", "MyAddressPage"))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("Address1 actual error message is: "+actualErrorMsg+" same as expected error message "+expectedErrorMsg);
				} else {
					throw new POMMethodExecException("Address1 actual error message is: "+actualErrorMsg+" not same as expected error message "+expectedErrorMsg);
				}
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Address1 actual error message is not same as expected error message",e);
		}
		//To verify Mobile number error message.
		try {
			String getMobileNumberText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNumberXpath", "MyAddressPage"))).getText().trim();
			if(getMobileNumberText.length() < 1) {
				String expectedErrorMsg = "Mobile number is required";
				String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("mobileNoErrorMsgXpath", "MyAddressPage"))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("Mobile number actual error message is: "+actualErrorMsg+" same as expected error message "+expectedErrorMsg);
				} else {
					throw new POMMethodExecException("Mobile number actual error message is: "+actualErrorMsg+" not same as expected error message "+expectedErrorMsg);
				}
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Mobile number actual error message is not same as expected error message",e);
		}
		
		//To verify address save as error message.
		try {
			String getSaveAddressAsText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("saveAddressasXpath", "MyAddressPage"))).getText().trim();
			if(getSaveAddressAsText.length() < 1) {
				String expectedErrorMsg = "The alias is required";
				String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("alasErrorMsgXpath", "MyAddressPage"))).getText().trim();
				if(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
					addComment("Save address's actual error message is: "+actualErrorMsg+" same as expected error message "+expectedErrorMsg);
				} else {
					throw new POMMethodExecException("Save address's actual error message is: "+actualErrorMsg+" not same as expected error message "+expectedErrorMsg);
				}
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Save address's actual error message is not same as expected error message",e);
		}
	}
	
	//Enter data to text fields of add address pop-up. 
	public void enterDataToAddMyaddressPopUp(WebDriver driver, String firstName, String lastName, String addressLine1, String addressLine2, String addressLine3, String addressLandMark,String mobileNumber, String saveAddressAs) throws Exception {
		Thread.sleep(1000);
		//enter first name.
		try {
			if(firstName.length() > 0 ) {
				eo.enterText(driver, "xpath", "firstnameXpath", firstName);
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
				eo.enterText(driver, "xpath", "lastNameXpath", lastName);
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
				eo.enterText(driver, "xpath", "addressLine1Xpath", addressLine1);
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
				eo.enterText(driver, "xpath", "addressLine2Xpath", addressLine2);
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
				eo.enterText(driver, "xpath", "addressLine3Xpath", addressLine3);
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
				eo.enterText(driver, "xpath", "addressLandMarkXpath", addressLandMark);
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
				eo.enterText(driver, "xpath", "mobileNumberXpath", mobileNumber);
				addComment("Entered Mobile number is: " + mobileNumber);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Mobile number length must be 10 and should not start with 0.", e);
		}
		
		// Enter save address as.
//		 Random random = new Random();
//		 int randomNumber = random.nextInt(100);
//		 saveAddressAs = saveAddressAs + randomNumber;
		try {
			if (saveAddressAs.length() > 0) {
				eo.enterText(driver, "xpath", "saveAddressasXpath", saveAddressAs);
				addComment("Entered Save Address is: " + saveAddressAs);
			} else {
				throw new POMMethodExecException("Unable to enter Save address as.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter Save address as.", e);
		}
	}
	
	//Verify address is added.
	public void verifyAddressIsadded(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		String expectedAddedAddressText = "Address Added !!.";
		String actualAddedAddressText = eo.getText(driver, "xPath", "addressAddedDeletedXpath");
		assertContains(actualAddedAddressText, expectedAddedAddressText, "Verified Expected added address text is: "+expectedAddedAddressText+" is same as Actual added address text: "+actualAddedAddressText, 
												"Verified Expected added address text is: "+expectedAddedAddressText+" is same as Actual added address text: "+actualAddedAddressText);
	}
	//Verify address is Edited.
		public void verifyAddressIsEdited(WebDriver driver) throws Exception {
			Thread.sleep(1000);
			String expectedAddedAddressText = "Address Edited !!.";
			String actualAddedAddressText = eo.getText(driver, "xPath", "addressAddedDeletedXpath");
			assertContains(actualAddedAddressText, expectedAddedAddressText, "Verified Expected text is: "+expectedAddedAddressText+" is same as Actual text: "+actualAddedAddressText, 
													"Verified Expected text is: "+expectedAddedAddressText+" is same as Actual text: "+actualAddedAddressText);
		}
	//Verify address is deleted.
	public void verifyIsAddressDeleted(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String expectedAddedAddressText = "Address Deleted !!.";
		String actualAddedAddressText = eo.getText(driver, "xPath", "addressAddedDeletedXpath");
		assertContains(actualAddedAddressText, expectedAddedAddressText, "Verified Expected added address text is: "+expectedAddedAddressText+" is same as Actual added address text: "+actualAddedAddressText, 
												"Verified Expected added address text is: "+expectedAddedAddressText+" is same as Actual added address text: "+actualAddedAddressText);
		addComment("Address is deleted.");
	}
	//Enter City
	public void enterCityToAddAddressPopUp(WebDriver driver, String city) throws Exception {
		try {
			if (city.length() > 0 && city.length() < 50) {
				eo.enterText(driver, "xpath", "cityXpath", city);
				addComment("City is entered successfully, Entered City is: " + city);
			} else {
				throw new POMMethodExecException("City length should be greater than 0 and less than 50.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("City length should be greater than 0 and less than 50.", e);
		}
		
	}
	//Verify City text box error message.
	public void verifyCityTextBoxErrorMessage(WebDriver driver) throws Exception {
		try {
			/*String getCityText = driver.findElement(By.xpath(GetElementIdentifier.getProperty("cityXpath", "MyAddressPage"))).getText().trim();
			if(getCityText.length() < 1) {
				String expectedErrorMsg = "The city is required";
				String actualErrorMsg = eo.getText(driver, "xPath", "cityErrorMsgXpath1");
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified city error message is same: "+actualErrorMsg, "Verified city error message is same: "+actualErrorMsg);
				
			} else {
				String expectedErrorMsg = "The city can only consist of alphabets!!";
				String actualErrorMsg = eo.getText(driver, "xPath", "cityErrorMsgXpath");
				assertEquals(expectedErrorMsg.equalsIgnoreCase(actualErrorMsg), "Verified city error message is same: "+actualErrorMsg, "Verified city error message is same: "+actualErrorMsg);
				
			}*/
			Thread.sleep(2000);
			String expectedErrorMsg = "The city can only consist of alphabets!!";
			String actualErrorMsg = eo.getText(driver, "xPath", "cityErrorMsgXpath");
			assertEqualsIgnoreCase(expectedErrorMsg, actualErrorMsg, "Verified city error message is same: "+actualErrorMsg, "Verified city error message is same: "+actualErrorMsg);
		} catch(Exception e) {
			throw new POMMethodExecException("Cities actual error message is not same as expected error message",e);
		}
		
	}
	//Click on Edit Address icon.
	public void clickOnEditAddressIcon(WebDriver driver, String addressName) throws Exception {
		String tempEditAddressIconXpath = GetElementIdentifier.getProperty("editAddressIconXpath", "MyAddressPage");
		String replaceTempEditAddressIconXpath = tempEditAddressIconXpath.replace("{replaceAddress}", addressName);
		driver.findElement(By.xpath(replaceTempEditAddressIconXpath)).click();
		addComment("Clicked on Edit Address Icon of: "+addressName);
	}
	
	//Click on Close icon.
	public void clickOnCloseIcon(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "closeIconXpath");
		addComment("Clicked on Close Icon.");
	}
	
	//Click on Delete Address icon.
		public void clickOnDeleteAddressIcon(WebDriver driver, String addressName) throws Exception {
			Thread.sleep(2000);
			String tempDeleteAddressIconXpath = GetElementIdentifier.getProperty("deleteAddressIconXpath", "MyAddressPage");
			String replaceTempDeleteAddressIconXpath = tempDeleteAddressIconXpath.replace("{replaceAddress}", addressName);
			driver.findElement(By.xpath(replaceTempDeleteAddressIconXpath)).click();
			//eo.clickElement(driver, "xpath", replaceTempDeleteAddressIconXpath);
			addComment("Clicked on Delete Address Icon of:"+addressName);
		}
		
	//Click on Ok button.
	public void clickOnOkButton(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		eo.clickElement(driver, "xpath", "okButtonXpath");
		addComment("Clicked on OK Button.");
	}
	
	//Verify zip/postal code.
	public void verifyErrorMessageForZipOrPostalCode(WebDriver driver, String zipCode) throws Exception {
		try {
			Thread.sleep(2000);
			if(zipCode.equalsIgnoreCase("false")) {
				String expectedErrorMsg = "length should be 6";
				String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("zipCodeErrorMsgXpath", "MyAddressPage"))).getText().trim();
				if(actualErrorMsg.equalsIgnoreCase(expectedErrorMsg)) {
					addComment("Actual error message is: "+actualErrorMsg+ " same as Expected Error Message "+expectedErrorMsg);
				} else {
					throw new POMMethodExecException("Actual error message is not same as Expected Error message."+actualErrorMsg);
				}
			} else if(zipCode.equalsIgnoreCase("character")) {
				String expectedErrorMsg = "The value is not an integer";
				String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("zipCodeErrorMsgXpath1", "MyAddressPage"))).getText().trim();
				if(actualErrorMsg.equalsIgnoreCase(expectedErrorMsg)) {
					addComment("Actual error message is: "+actualErrorMsg+ " same as Expected Error Message "+expectedErrorMsg);
				} else {
					throw new POMMethodExecException("Actual error message is not same as Expected Error message."+actualErrorMsg);
				}
			} else if(zipCode.equalsIgnoreCase("true")) {
				String expectedErrorMsg = "We deliver to";
				String actualErrorMsg = driver.findElement(By.xpath(GetElementIdentifier.getProperty("zipCodeErrorMsgXpath1", "MyAddressPage"))).getText().trim();
				if(actualErrorMsg.contains(expectedErrorMsg)) {
					addComment("Zip/Postal code is verified its a valid Postal code, Page is navigated to New Address.");
				} else {
					throw new POMMethodExecException("Zip/Postal code is verified its not a valid Postal code, Page is not navigated to New Address Page.");
				}
			} else {
				throw new POMMethodExecException("Unable to verify Zip code error message.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to verify Zip code error message.",e);
		}
		
		
	}
	// Enter Mobile number.
	public void enterMobileNumber(WebDriver driver, String mobileNumber) throws Exception {

		try {
			Thread.sleep(2000);
			if (mobileNumber.length() < 10) {
				throw new POMMethodExecException("Unable to enter mobile number, Mobile number length must be 10");
			} else {
				eo.enterText(driver, "xpath", "mobileNumberXpath", mobileNumber);
				addComment("Entered Mobile number is: " + mobileNumber);
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter mobile number, Mobile number length must be 10", e);
		}
	}
	
	//Verify mobile number text box error message.
	public void verifyMobileNumberErrorMessage(WebDriver driver) throws Exception {
		try {
			String expectedErrorMessage = "Mobile Number should not start with 0";
			String actualErrorMessage = eo.getText(driver, "xPath", "mobileNoErrorMsgZeroXpath");
			assertEqualsIgnoreCase(expectedErrorMessage, actualErrorMessage, "Verified Expected Error message is same as Actual Error message: "+actualErrorMessage, "Verified Expected Error message is not same as Actual Error message: "+actualErrorMessage);
		} catch(Exception e) {
			throw new POMMethodExecException("Verified Expected error message is not same Actual error message.",e);
		}
	}
	//Enter Save address as.
	public void enterSaveAddressAs(WebDriver driver, String saveAddressAs) throws Exception {
		// Enter save address as.
		try {
			Thread.sleep(2000);
			if (saveAddressAs.length() > 1) {
				eo.enterText(driver, "xpath", "saveAddressasXpath", saveAddressAs);
				addComment("Entered Save Address is: " + saveAddressAs);
			} else {
				throw new POMMethodExecException("Unable to enter save address as.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to enter save address as.", e);
		}
	}
	//Verify save address as error message.
	public void verifySaveAddressAsErrorMesage(WebDriver driver) throws Exception {
		try {
			Thread.sleep(2000);
			String expectedErrorMessage = "Alias must be between 5 to 15 characters";
			String actualErrorMessage = eo.getText(driver, "xPath", "aliasErrorMsgLessCharctersXpath");
			assertEqualsIgnoreCase(expectedErrorMessage, actualErrorMessage, "Verified Expected Error message is same as Actual Error message: "+actualErrorMessage, "Verified Expected Error message is not same as Actual Error message: "+actualErrorMessage);
		} catch(Exception e) {
			throw new POMMethodExecException("Verified Expected error message is not same Actual error message.",e);
		}
	}
	
	//Verify Country and State text box's are disabled.
	public void verifyIsCountryAndStateTextBoxAreDisabled(WebDriver driver) throws Exception {
		String expectedValue = "true";
		//Verify country text box is disabled.
		try {
			Thread.sleep(2000);
			String actualCountryCodeValue = driver.findElement(By.xpath(GetElementIdentifier.getProperty("countryTextXpath", "MyAddressPage"))).getAttribute("disabled");
			if(actualCountryCodeValue.equalsIgnoreCase(expectedValue)) {
				addComment("Verified Country code text box is disabled, We cannot edit.");
			} else {
				addComment("Verified Country code text box is Enabled, We can edit.");
			}
		} catch(Exception e) {
			//do nothing.
		}
		//Verify country text box is disabled.
		try {
			String actualStateCodeValue = driver.findElement(By.xpath(GetElementIdentifier.getProperty("stateTextXpath", "MyAddressPage"))).getAttribute("disabled");
			if(actualStateCodeValue.equalsIgnoreCase(expectedValue)) {
				addComment("Verified State code text box is disabled, We cannot edit.");
			} else {
				throw new POMMethodExecException("Verified State code text box is disabled, We cannot edit.");
			}
		} catch (Exception e) {
			//do nothing.
		}
	}
	//Click on Left and Right carousel-control.
	public void clickOnLeftOrRightCarousel(WebDriver driver, String rightOrLeftcarousel) throws Exception {
		// click on Right or Left carousel-control.
		try {
			Thread.sleep(2000);
			if (rightOrLeftcarousel.equalsIgnoreCase("Right")) {
				eo.clickElement(driver, "Xpath", "rightCarouselXpath");
				addComment("Clicked on Right carousel-control.");
			} else {
				eo.clickElement(driver, "Xpath", "leftCarouselXpath");
				addComment("Clicked on Left carousel-control.");
			}

		} catch (Exception e) {
			throw new POMMethodExecException("Unable to click on Right or Left Carousel-control.", e);
		}
	}
	//Verify added address are displayed.
	public void verifyAddedAddressesAreDisplayed(WebDriver driver, String addresses, String rightOrLeftcarousel) throws Exception {
		try {
			Thread.sleep(2000);
			String[] splitAddresses = addresses.split(";");
			int noOfAddress = 0;
			List<WebElement> allAddresses = driver.findElements(By.xpath(GetElementIdentifier.getProperty("uiSavedAllAddressesXpath", "MyAddressPage")));
			String tempUiAddressXpath = GetElementIdentifier.getProperty("uiAddressXpath", "MyAddressPage");
			for (int i = 0; i < allAddresses.size(); i++) {
				String replaceTempUiAddressXpath = tempUiAddressXpath.replace("{replaceAddress}", splitAddresses[noOfAddress]);
				boolean uiAddressDisplayStatus = driver.findElement(By.xpath(replaceTempUiAddressXpath)).isDisplayed();
				if (!uiAddressDisplayStatus) {
					// click on Right or Left carousel-control.
					try {
						if (rightOrLeftcarousel.equalsIgnoreCase("Right")) {
							eo.clickElement(driver, "xPath", "rightCarouselXpath");
							addComment("Clicked on Right carousel-control.");
						} else {
							eo.clickElement(driver, "Xpath", "leftCarouselXpath");
							addComment("Clicked on Left carousel-control.");
						}

					} catch (Exception e) {
						throw new POMMethodExecException("Unable to click on Right or Left Carousel-control.", e);
					}
				} else {
					addComment("Displayed Ui address is: " + splitAddresses[noOfAddress]);
					noOfAddress++;
				}
				if (noOfAddress == splitAddresses.length) {
					break;
				} 
			}
			if (noOfAddress == splitAddresses.length) {
				addComment("Added all addresses are displayed in Ui. ");
			} else {
				throw new POMMethodExecException("Added all addresses are not displayed in Ui.");
			}
			
		} catch (Exception e) {
			throw new POMMethodExecException("Added all addresses are not displayed In Ui", e);
		}

	}
	//Verify Error message for all the text fields.
	public void verifyAddressTextFieldErrorMessages(WebDriver driver, String firstNameStatus, String lastNameStatus, String addressLine1Status, String addressLine2Status, String addressLine3Status, String addressLandMarkStatus, String cityStatus, String mobileNumberStatus, String saveAddressAsStatus) throws Exception {
		Thread.sleep(2000);
		//To verify First name error message.
		try {
			if(firstNameStatus.equalsIgnoreCase("false")) {
				String firstNameErrorMsg = eo.getText(driver, "xPath", "firstNameErrorMessagegXpath");
				if(firstNameErrorMsg.equalsIgnoreCase("The firstname is required")) {
					addComment("The first name is required.");
				} else if(firstNameErrorMsg.equalsIgnoreCase("The first name should only contain alphabets and spaces only")) {
					addComment("The first name should only contain alphabets and spaces only");
				} else if(firstNameErrorMsg.equalsIgnoreCase("firstname must be less than 80 characters")) {
					addComment("Firstname must be less than 80 characters");
				} else {
					throw new POMMethodExecException("First name error message is not matched.");
					}
			} else {
				addComment("First name is valid input.");
			}
		} catch(Exception e) {
			throw new Exception("First name is an Invalid input.",e);
		}
		
		//To verify Last name error message.
		try {
			if (lastNameStatus.equalsIgnoreCase("false")) {
				String lastNameErrorMsg = eo.getText(driver, "xPath", "lastNameErrorMessageXpath");
				if (lastNameErrorMsg.equalsIgnoreCase("The lastname must be less than 80 characters")) {
					addComment("The lastname must be less than 80 characters.");
				} else if (lastNameErrorMsg.equalsIgnoreCase("The last name should only contain alphabets and spaces only")) {
					addComment("The last name should only contain alphabets and spaces only.");
				} else {
					throw new POMMethodExecException("Last name error message is not matched.");
				}
			} else {
				addComment("Last name is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("Last name is an Invalid input.", e);
		}
		
		//To verify Address line1 error message.
		try {
			if (addressLine1Status.equalsIgnoreCase("false")) {
				String addressLine1ErrorMsg = eo.getText(driver, "xPath", "addressLine1ErrorMessageXpath");
				if (addressLine1ErrorMsg.equalsIgnoreCase("The address is required")) {
					addComment("The address is required.");
				} else if (addressLine1ErrorMsg.equalsIgnoreCase("The address must be less than 80 characters")) {
					addComment("The address must be less than 80 characters.");
				} else if(addressLine1ErrorMsg.equalsIgnoreCase("Allowed special characteres /.:#,-' .")) {
					addComment("Allowed special characteres /.:#,-' .");
				} else {
					throw new POMMethodExecException("Address line1 error message is not matched.");
				}
			} else {
				addComment("Address line1 is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("Address line1 is an Invalid input.", e);
		}
		
		//To verify Address line2 error message.
		try {
			if (addressLine2Status.equalsIgnoreCase("false")) {
				String addressLine2ErrorMsg = eo.getText(driver, "xPath", "addressLine2ErrorMessageXpath");
				if (addressLine2ErrorMsg.equalsIgnoreCase("The address must be less than 80 characters")) {
					addComment("The address must be less than 80 characters.");
				} else if (addressLine2ErrorMsg.equalsIgnoreCase("Allowed special characteres /.:#,-' .")) {
					addComment("Allowed special characteres /.:#,-' .");
				} else {
					throw new POMMethodExecException("Address line2 error message is not matched.");
				}
			} else {
				addComment("Address line2 is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("Address line2 is an Invalid input.", e);
		}
		
		//To verify Address line3 error message.
		try {
			if (addressLine3Status.equalsIgnoreCase("false")) {
				String addressLine3ErrorMsg = eo.getText(driver, "xPath", "addressLine3ErrorMessageXpath");
				if (addressLine3ErrorMsg.equalsIgnoreCase("The address must be less than 80 characters")) {
					addComment("The address must be less than 80 characters.");
				} else if (addressLine3ErrorMsg.equalsIgnoreCase("Allowed special characteres /.:#,-' .")) {
					addComment("Allowed special characteres /.:#,-' .");
				} else {
					throw new POMMethodExecException("Address line3 error message is not matched.");
				}
			} else {
				addComment("Address line3 is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("Address line3 is an Invalid input.", e);
		}
		
		// To verify Address land mark error message.
		try {
			if (addressLandMarkStatus.equalsIgnoreCase("false")) {
				String addressLandMarkErrorMsg = eo.getText(driver, "xPath", "addressLandMarkerrorMessageXpath");
				if (addressLandMarkErrorMsg.equalsIgnoreCase("The address must be less than 80 characters")) {
					addComment("The address must be less than 80 characters.");
				} else if (addressLandMarkErrorMsg.equalsIgnoreCase("Allowed special characteres /.:#,-' .")) {
					addComment("Allowed special characteres /.:#,-' .");
				} else {
					throw new POMMethodExecException("Address land mark error message is not matched.");
				}
			} else {
				addComment("Address land mark is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("Address land mark is an Invalid input.", e);
		}
		
		// To verify City error message.
		try {
			if (cityStatus.equalsIgnoreCase("false")) {
				String cityErrorMsg = eo.getText(driver, "xPath", "cityErrorMessageXpath");
				if (cityErrorMsg.equalsIgnoreCase("The city is required")) {
					addComment("The city is required.");
				} else if (cityErrorMsg.equalsIgnoreCase("city must be less than 50 characters")) {
					addComment("city must be less than 50 characters.");
				} else if (cityErrorMsg.equalsIgnoreCase("The city can only consist of alphabets!!")) {
					addComment("The city can only consist of alphabets!!");
				} else {
					throw new POMMethodExecException("City error message is not matched.");
				}
			} else {
				addComment("City is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("City is an Invalid input.", e);
		}
		
		// To verify Mobile number error message.
		try {
			if (mobileNumberStatus.equalsIgnoreCase("false")) {
				String mobileNumberErrorMsg = eo.getText(driver, "xPath", "mobileNumberErrorMessageXpath");
				if (mobileNumberErrorMsg.equalsIgnoreCase("Mobile number is required")) {
					addComment("Mobile number is required.");
				} else if (mobileNumberErrorMsg.equalsIgnoreCase("Mobile Number should not start with 0")) {
					addComment("Mobile Number should not start with 0.");
				} else if (mobileNumberErrorMsg.equalsIgnoreCase("The mobile number should be 10 digit long")) {
					addComment("The mobile number should be 10 digit long.");
				} else {
					throw new POMMethodExecException("Mobile number error message is not matched.");
				}
			} else {
				addComment("Mobile number is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("Mobile number is an Invalid input.", e);
		}
		
		// To verify Save address as error message.
		try {
			if (saveAddressAsStatus.equalsIgnoreCase("false")) {
				String saveAddressErrorMsg = eo.getText(driver, "xPath", "saveAddressAsErrorXpath");
				if (saveAddressErrorMsg.equalsIgnoreCase("The alias is required")) {
					addComment("The alias is required.");
				} else if (saveAddressErrorMsg.equalsIgnoreCase("Alias must be between 5 to 15 characters")) {
					addComment("Alias must be between 5 to 15 characters.");
				} else if (saveAddressErrorMsg.equalsIgnoreCase("The alias can only consist of alphabet,number and -")) {
					addComment("The alias can only consist of alphabet,number and -.");
				} else if (saveAddressErrorMsg.equalsIgnoreCase("The alias already exist in your account")) {
					addComment("The alias already exist in your account.");
				} else {
					throw new POMMethodExecException("Save address as error message is not matched.");
				}
			} else {
				addComment("Save address as is valid input.");
			}
		} catch (Exception e) {
			throw new Exception("Save address as is an Invalid input.", e);
		}
	}
}
























