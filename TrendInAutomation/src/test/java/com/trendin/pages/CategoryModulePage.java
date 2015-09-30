package com.trendin.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trendin.core.ElementOperation;
import com.trendin.core.GetElementIdentifier;
import com.trendin.core.TrendInTestSuite;
import com.trendin.core.util.exceptions.POMMethodExecException;

public class CategoryModulePage extends TrendInTestSuite {
	final String curApp = "CategoryModulePage";
	ElementOperation eo = new ElementOperation(curApp);
	
	/**
	 * <p>
	 * <b>Method Name:</b> clickOnMegaMenuLink
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To clink on particular mega menu link. 
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	//To click on header Links.
	public void clickOnMegaMenuLink(WebDriver driver, String linkTypeName) throws Exception {
		try {
			String tempHeaderLinksXpath = GetElementIdentifier.getProperty("headerLinksXpath", curApp);
			String replaceTempHeaderLinksXpath = tempHeaderLinksXpath.replace("{replaceHeaderLinkName}", linkTypeName);
			driver.findElement(By.xpath(replaceTempHeaderLinksXpath)).click();
			addComment("Clicked Mega menu link is : "+linkTypeName);
			
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to click on Mega menu link", e);
		}
	}
	
	/**
	 * <p>
	 * <b>Method Name:</b> veriyMenCategory
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verifies the Men's sub categories items are listed.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Men
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void veriyMenCategory(WebDriver driver, String menCategoriesName) throws Exception {
		try {
			int noOfMenCategories = 0; 
			String[] splitMenCategoriesName = menCategoriesName.split(";");
			List<WebElement> allMenCategories = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allCategoryXpath", curApp)));
			String tempMenCategoriesXpath = GetElementIdentifier.getProperty("categoryTypesXpath", curApp);
			for(int i = 0; i < allMenCategories.size(); i++ ) {
				String replaceTempMenCategoriesXpath = tempMenCategoriesXpath.replace("{ReplaceCategory}", splitMenCategoriesName[i]);
				boolean menCategoryDisplayStatus = driver.findElement(By.xpath(replaceTempMenCategoriesXpath)).isDisplayed();
				assertTrue(menCategoryDisplayStatus, "Displayed Men category : "+splitMenCategoriesName[i], "Didn't Displayed Men category : "+splitMenCategoriesName[i]);
				noOfMenCategories++;
			}
			if(noOfMenCategories == allMenCategories.size()) {
				addComment("All men categories are displayed.");
			} else {
				throw new POMMethodExecException("All men categories are not displayed.");
			}
		} catch(Exception e) {
			throw new POMMethodExecException("Unable to verify Men categories.",e);
		}		
	}

	/**
	 * <p>
	 * <b>Method Name:</b> veriyWomenCategory
	 * </p>
	 * 
	 * <p>
	 * <b>Description:</b> To verifies the Women's sub categories items are listed.
	 * </p>
	 * <p>
	 * <b>Dependencies:</b> Browser Launch -> Women
	 * </p>
	 * 
	 * @author Ravichandra Gudda
	 * 
	 */
	public void veriyWomenCategory(WebDriver driver, String womenCategoriesName) throws Exception {
		try {
			int noOfwomenCategories = 0;
			String[] splitWomenCategoriesName = womenCategoriesName.split(";");
			List<WebElement> allWomenCategories = driver.findElements(By.xpath(GetElementIdentifier.getProperty("allCategoryXpath", curApp)));
			String tempMenCategoriesXpath = GetElementIdentifier.getProperty("categoryTypesXpath", curApp);
			for (int i = 0; i < allWomenCategories.size(); i++) {
				String replaceTempWomenCategoriesXpath = tempMenCategoriesXpath.replace("{ReplaceCategory}", splitWomenCategoriesName[i]);
				boolean womenCategoryDisplayStatus = driver.findElement(By.xpath(replaceTempWomenCategoriesXpath)).isDisplayed();
				assertTrue(womenCategoryDisplayStatus, "Displayed women category : " + splitWomenCategoriesName[i], "Didn't Displayed women category : " + splitWomenCategoriesName[i]);
				noOfwomenCategories++;
			}
			if (noOfwomenCategories == allWomenCategories.size()) {
				addComment("All women categories are displayed.");
			} else {
				throw new POMMethodExecException("All women categories are not displayed.");
			}
		} catch (Exception e) {
			throw new POMMethodExecException("Unable to verify women categories.", e);
		}
	}
}
