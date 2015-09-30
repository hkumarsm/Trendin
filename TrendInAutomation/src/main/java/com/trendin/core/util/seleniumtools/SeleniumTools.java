package com.trendin.core.util.seleniumtools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumTools {
	
	
	/**
	 * A Comparator implementation for use with WebElements. By default, it is set
	 * up to sort WebElements by their position on the containing page/frame (either
	 * horizontally or vertically), but public int compare(WebElement a, WebElement b)
	 * may be overridden anonymously for a different implementation.
	 * 
	 * @author Brian Van Stone
	 *
	 */
	public static class WebElementComparator implements Comparator<WebElement> {

		@Override
		public int compare(WebElement a, WebElement b) {
			return (a.getLocation().x + a.getLocation().y) - (b.getLocation().x + b.getLocation().y);
		}
	}
	
	/**
	 * Sorts a Collection of WebElements based on their position on the screen, 
	 * either horizontally or vertically.
	 * 
	 * @param elements The Collection of WebElements to sort
	 * @return A sorted List of the WebElements
	 * 
	 * @author Brian Van Stone
	 */
	public static List<WebElement> sortWebElements(Collection<WebElement> elements) {
		return sortWebElements(elements, new WebElementComparator());
	}
	
	/**
	 * Sorts a Collection of WebElements based on the comparator passed as an argument
	 * 
	 * @param elements The Collection of elements to sort
	 * @param comparator The Comparator instance by which they are sorted
	 * @return A sorted List of the WebElements
	 * 
	 * @author Brian Van Stone
	 */
	public static List<WebElement> sortWebElements(Collection<WebElement> elements, Comparator<WebElement> comparator) {
		List<WebElement> sortedList = new ArrayList<WebElement>(elements);
		Collections.sort(sortedList, comparator);
		return sortedList;
		
	}
	
	/**
	 * Sorts a array of WebElements based on their position on the screen, 
	 * either horizontally or vertically.
	 * 
	 * @param elements The array of elements to sort
	 * @return A sorted List of the WebElements
	 * 
	 * @author Brian Van Stone
	 */
	public static List<WebElement> sortWebElements(WebElement[] elements) {
		return sortWebElements(elements, new WebElementComparator());
	}
	
	/**
	 * Sorts an array of WebElements based on the comparator passed as an argument
	 * 
	 * @param elements The Collection of elements to sort
	 * @param comparator The Comparator instance by which they are sorted
	 * @return A sorted List of the WebElements
	 * 
	 * @author Brian Van Stone
	 */
	public static List<WebElement> sortWebElements(WebElement[] elements, Comparator<WebElement> comparator) {
		List<WebElement> sortedList = Arrays.asList(elements);
		Collections.sort(sortedList, comparator);
		return sortedList;
	}
	
	/**
	 * Allows for translation of two strings to a By instance. The first
	 * parameter, <i>String expression</i>, is the parameter passed to the static
	 * By creator methods. The second parameter, <i>String by</i>, is used to determine
	 * which By creator method to invoke.
	 * 
	 * @param expression the expression used to construct the By instance
	 * @param by the type of By instance to create
	 * @return a By instance for the requested WebElement
	 */
	public static By getWebElementIdentifier(String expression, String by) {
		switch(by.toLowerCase()) {
			case "classname":
			    return By.className(expression);
			case "cssselector":
			case "csspath":
			    return By.cssSelector(expression);
			case "id":
			    return By.id(expression);
			case "linktext":
			    return By.linkText(expression);
			case "name":
			    return By.name(expression);
			case "partiallinktext":
			    return By.partialLinkText(expression);
			case "tagname":
			    return By.tagName(expression);
			case "xpath":
			    return By.xpath(expression);
			default:
				throw new IllegalArgumentException("Illegal value of " + by + " passed as 'by' arg to getWebElementIdentifier");
		}
	}
}
