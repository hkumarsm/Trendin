package com.trendin.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.trendin.core.ElementOperation;
import com.trendin.core.ExcelReader;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class PaymentPage extends TrendInTestSuite {
	final String curApp = "PaymentPage";
	ElementOperation eo = new ElementOperation(curApp);

	public void clickOnDifferntLabels(WebDriver driver) throws Exception {
		// To click on the category
		eo.clickElement(driver, "Xpath", "megaLabelXpath");
		addComment("Successfully clicked on the women category");

		// To click on the Trousers & Leggings label
		eo.clickElement(driver, "Xpath", "trousersAndLeggingsXpath");
		addComment("Successfully clicked on the trousersAndLeggings label");

		// To click on the product
		eo.clickElement(driver, "Xpath", "productXpath");
		addComment("Successfully clicked on the product");
	}

	public void verifyMyCartPage(WebDriver driver) throws Exception {

		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allViewXpath", curApp)));
		addComment("Number of views :" + allElements.size());
		if (allElements.size() <= 0) {
			throw new POMMethodExecException("None of the vies are displayed");
		}
		for (WebElement element : allElements) {
			boolean allElementsDisplay = element.isDisplayed();

			if (allElementsDisplay) {
				addComment("all views are dispalyed");
			}
		}
		eo.verifyElementIsDisplayed(driver, "Xpath", "addToCrtXpath");
		addComment("Successfully verified the add to cart button");
	}

	public void verifyProducDetailsPage(WebDriver driver) throws Exception {

		String sizeValue = ExcelReader.getValue("SizeValue");
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizeXpath", curApp)));
		String allElementsInUI1[] = new String[allElements.size()];
		int count1 = 0;
		for (WebElement element : allElements) {
			allElementsInUI1[count1] = element.getAttribute("value");
			if (allElementsInUI1[count1].equalsIgnoreCase(sizeValue)) {
				// To click on brand
				element.click();
				addComment("Successfully clicked on brand :" + sizeValue);
				break;
			}
		}

		// To click on buy now button
		eo.clickElement(driver, "Xpath", "buyNowButtonXpath");
		addComment("Successfully clicked on the buy now button");
		eo.wait(3000);

		// To click on the product link
		eo.clickElement(driver, "Xpath", "productLineLinkXpath");
		addComment("Successfully clicked on the product link");

		// get window handlers as list
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(browserTabs.get(1));

		for (int i = 0; i <= 5000; i++) {
			boolean pageStatus = eo.verifyElementIsDisplayed(driver, "Xpath", "newTabProductDescriptionXpath");
			if (pageStatus) {
				addComment("Successfully verified the product description");
				break;
			}
			driver.close();
			driver.switchTo().window(browserTabs.get(0));
		}

	}
	public void verifyEditSizeMyCartPage(WebDriver driver)  throws Exception{
		String sizeValue = ExcelReader.getValue("SizeValue");
		List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizeXpath", curApp)));
		String allElementsInUI1[] = new String[allElements.size()];
		int count1 = 0;
		for (WebElement element : allElements) {
			allElementsInUI1[count1] = element.getAttribute("value");
			if (allElementsInUI1[count1].equalsIgnoreCase(sizeValue)) {
				// To click on brand
				element.click();
				addComment("Successfully clicked on brand :" + sizeValue);
				break;
			}
		}

		// To click on buy now button
		eo.clickElement(driver, "Xpath", "buyNowButtonXpath");
		addComment("Successfully clicked on the buy now button");
		eo.wait(3000);
		
		//To edit size
		eo.clickElement(driver, "Xpath", "editButtonXpath");
		addComment("Successfully clicked on the edit button");
		
		//To select the size
		eo.clickElement(driver, "Xpath", "sizeComboBoxXpath");
		addComment("Successfully clicked on the combo box");
		
		//To verify the different sizes\
		List<WebElement> allElements1 = driver.findElements(By.xpath(GetElementIdentifier.getProperty("selectDropdownXpath", curApp)));
		  if (allElements1.size() <= 0) {
		   throw new POMMethodExecException("No values present in dropdown to display");
		  }
		  String allElementsInUI2[] = new String[allElements1.size()];
		  int count2 = 0;
		  for (WebElement element : allElements1) {
		   allElementsInUI2[count2] = element.getText();
		   addComment("Size available is :" + allElementsInUI2[count2]);
		   count2++;
		  }
	}
		public void saveSelectedDropDownSize(WebDriver driver)throws Exception{
			String sizeValue = ExcelReader.getValue("SizeValue");
			List<WebElement> allElements = driver.findElements(By.xpath(GetElementIdentifier.getProperty("sizeXpath", curApp)));
			String allElementsInUI1[] = new String[allElements.size()];
			int count1 = 0;
			for (WebElement element : allElements) {
				allElementsInUI1[count1] = element.getAttribute("value");
				if (allElementsInUI1[count1].equalsIgnoreCase(sizeValue)) {
					// To click on brand
					element.click();
					addComment("Successfully clicked on brand :" + sizeValue);
					break;
				}
			}

			// To click on buy now button
			eo.clickElement(driver, "Xpath", "buyNowButtonXpath");
			addComment("Successfully clicked on the buy now button");
			eo.wait(3000);
			
			//To edit size
			eo.clickElement(driver, "Xpath", "editButtonXpath");
			addComment("Successfully clicked on the edit button");
			
			//To select the size
			eo.clickElement(driver, "Xpath", "sizeComboBoxXpath");
			addComment("Successfully clicked on the combo box");
			
			//To select value from combobox
			String sizeValue1 = ExcelReader.getValue("SizeValue1");
			eo.selectComboBoxByVisibleText(driver, "Xpath", "sizeComboBoxXpath", sizeValue1);
			
			//To click on the save buttom
			eo.clickElement(driver, "Xpath", "saveButtonXpath");
			addComment("Successfully clicked on the save button");
			eo.wait(5000);
			
			//To verify the modeifed value
			String modifiedSize=eo.getText(driver, "Xpath", "modifiedSizeXpath");
			if(modifiedSize.equals(sizeValue1)){
				addComment("Successfully modified the size");
			}
			else
			{
				throw new POMMethodExecException("Couldn't modify the size");
			}
		
		
		
		
	}

}
