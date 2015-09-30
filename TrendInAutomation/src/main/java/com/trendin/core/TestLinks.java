package com.trendin.core;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLinks {

	static WebDriver driver;
	static String browser = "Firefox";
	static List<String> mainLoginPageLinks;
	static List<String> checkedLinks;
	static List<String> level2LinksUrls = new ArrayList<>();
	static List<String> level3LinksUrls = new ArrayList<>();
	static List<String> level4LinksUrls = new ArrayList<>();
	
	static List<String> error404Links = new ArrayList<>();
	static int checkLinksCount = 0;
	static String level1Url = "";
	static String level2Url = "";
	static String level3Url = "";
	static String level4Url = "";
	

	@BeforeTest(alwaysRun = true)
	public void setup() throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
			maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			maximize();
		}
		// Now go to the application Base URL
		driver.get("http://www.three.co.uk");
		Thread.sleep(5000);
		loginToApplication("07402958720", "uattest1");
	}

	public static void maximize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(), (int) toolkit.getScreenSize().getHeight());
		driver.manage().window().setSize(screenResolution);
	}

	// login to the 3 uk application
	public void loginToApplication(String userName, String password) throws Exception {
		driver.findElement(By.xpath("//a[.='Login.' and contains(@href,'/My3Account')]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='globalButton' and @title='Next']")).click();
		Thread.sleep(5000);
	}

	@Test
	public void beginTest() throws Exception {
		System.out.println("logged in.");
		String verify404ErrorMessageCode = "";
		List<WebElement> allMailPageLinks = driver.findElements(By.xpath("//a"));
		System.out.println("Number of links: " + allMailPageLinks.size());
		mainLoginPageLinks = new ArrayList<>();
		checkedLinks = new ArrayList<>();
		for (WebElement elements : allMailPageLinks) {
			if(elements.getAttribute("href").contains("http") && elements.getAttribute("href").contains("/New_My3/")) {
				mainLoginPageLinks.add(elements.getAttribute("href"));
			}
		}
		// Links go in the mail page..
		// mail pages links..
		level1Url = driver.getCurrentUrl();
		checkedLinks.add(level1Url);
		for (int mainLinks = 0; mainLinks < mainLoginPageLinks.size(); mainLinks++) {
			try {
				// Level 1..
				driver.get(mainLoginPageLinks.get(mainLinks)); 
				// check whether no 404, 300 errors are present in the page
				verify404ErrorMessageCode = driver.getPageSource();
				if(verify404ErrorMessageCode.contains("404 ")){
					error404Links.add(mainLoginPageLinks.get(mainLinks));
				}
				// after verifying store the verified URL for reference
				checkedLinks.add(mainLoginPageLinks.get(mainLinks));
				List<WebElement> level2Links = driver.findElements(By.xpath("//a"));
				System.out.println("Number of level2 links: " + level2Links.size());
				int secondLevelLinks = 0;
				for (WebElement secondLevelElements : level2Links) {
					if(secondLevelElements.getAttribute("href").contains("http") && secondLevelElements.getAttribute("href").contains("/New_My3/")) {
						level2LinksUrls.add(secondLevelElements.getAttribute("href"));
						secondLevelLinks++;
					}
				}
				// Check for the second level links..
				for (int second = 0; second < secondLevelLinks; second++) {
					boolean secondLevelFound = false;
					try {
						for (int checkLinks = 0; checkLinks < checkedLinks.size(); checkLinks++) {
							if (level2LinksUrls.get(second).contains(checkedLinks.get(checkLinks))) {
								secondLevelFound = true;
								break;
							}
						}
						level2Url = driver.getCurrentUrl();
						if (!secondLevelFound) {
							driver.get(level2LinksUrls.get(second));
							checkedLinks.add(level2LinksUrls.get(second));
							verify404ErrorMessageCode = driver.getPageSource();
							if(verify404ErrorMessageCode.contains("404 ")){
								error404Links.add(mainLoginPageLinks.get(mainLinks));
							}
							// Verify for the level 3 links here..
							List<WebElement> level3Links = driver.findElements(By.xpath("//a"));
							System.out.println("Number of level3 links: " + level3Links.size());
							int thirdLevelLinks = 0;
							for (WebElement thirdLevelElements : level3Links) {
								if(thirdLevelElements.getAttribute("href").contains("http") && thirdLevelElements.getAttribute("href").contains("/New_My3/")) {
									level3LinksUrls.add(thirdLevelElements.getAttribute("href"));
									thirdLevelLinks++;
								}
							}
							// Check for the third level links..
							for(int third=0; third<thirdLevelLinks; third++) {
								boolean thirdLevelFound = false;
								try {
									for (int checkLinks = 0; checkLinks < checkedLinks.size(); checkLinks++) {
										if (level3LinksUrls.get(third).contains(checkedLinks.get(checkLinks))) {
											thirdLevelFound = true;
											break;
										}
									}
									level3Url = driver.getCurrentUrl();
									if(!thirdLevelFound) {
										driver.get(level3LinksUrls.get(third));
										checkedLinks.add(level3LinksUrls.get(third));
										verify404ErrorMessageCode = driver.getPageSource();
										if(verify404ErrorMessageCode.contains("404 ")){
											error404Links.add(mainLoginPageLinks.get(mainLinks));
										}
									}
								} catch(Exception e){
									System.out.println("Error in third level links verification");
									e.printStackTrace();
								}
							}
							// end of third level links verification
						}
					} catch (Exception e) {
						System.out.println("Exception in level 2 thread link.");
					}
				}
				System.out.println("........End of level 2 links.....");
			} catch (Exception e) {
				System.out.println("Do not throw any exception here.");
			}
		}
		System.out.println("........End of level 1 links.....");
		driver.get(level1Url);
		writeExtractedDataToExcel("D:\\Qualitest\\TrendInHemanth\\","checkedLinks.xls", checkedLinks);
		if(error404Links.size() >= 1){
			writeExtractedDataToExcel("D:\\Qualitest\\TrendInHemanth\\","errorLinksFile.xls", error404Links);
		}
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}

	public static String readFromExcelSheet(String filePath, String fileName, String columnName) throws Exception {
		String configPath = "", expRowValues = "";
		String allRowValues = "";
		String fileVar = "", fileSend = "";
		// To get canonical path..
		try {
			configPath = StringUtils.stripEnd(filePath, "/\\");
			configPath = (new File(filePath)).getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		fileVar = configPath + "\\";
		fileSend = fileVar + fileName;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(fileSend));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// Create Workbook instance holding reference to .xlsx file
		org.apache.poi.ss.usermodel.Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Iterate through each rows one by one
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		List<String> rowValues = new ArrayList<String>(200);
		String rowValue = "";
		// while (rowIterator.hasNext()) {
		Row row = rowIterator.next();
		// For each row, iterate through all the columns
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			// Check the cell type and format accordingly
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				rowValue = String.valueOf(cell.getNumericCellValue());
				if (rowValue.length() >= 1) {
					rowValues.add(rowValue);
				}
				System.out.println("Temp1: " + rowValue);
				//
				// System.out.print(cell.getNumericCellValue() + "t");
				break;
			case Cell.CELL_TYPE_STRING:
				rowValue = cell.getStringCellValue();
				if (rowValue.length() >= 1) {
					rowValues.add(rowValue);
				}
				System.out.println("Temp2: " + rowValue);
				// rowValues.add(temp);
				// System.out.print(cell.getStringCellValue() + "t");
				break;
			}
		}
		System.out.println(""); // gets one complete row
		// }
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int value = 1;
		value = rowValues.indexOf(columnName);
		sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator1 = sheet.iterator();

		String rowValue1 = "";

		if (rowIterator1.hasNext())
			rowIterator1.next();
		boolean saveValue = false;
		try {
			while (rowIterator1.hasNext()) {
				Row row1 = rowIterator1.next();
				// For each row, iterate through all the columns

				Cell cell = row1.getCell(value);
				// Check the cell type and format accordingly
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					rowValue1 = String.valueOf(cell.getNumericCellValue());
					if (rowValue1.length() >= 1) {
						expRowValues = rowValue1;
					}
					System.out.println("Temp1: " + rowValue1);
					saveValue = true;
					// System.out.print(cell.getNumericCellValue() + "t");
					break;
				case Cell.CELL_TYPE_STRING:
					rowValue1 = cell.getStringCellValue();
					if (rowValue1.length() >= 1) {
						expRowValues = rowValue1;
					}
					System.out.println("Temp2: " + rowValue1);
					saveValue = true;
					// rowValues.add(temp);
					// System.out.print(cell.getStringCellValue() + "t");
					break;
				case Cell.CELL_TYPE_BLANK:
					rowValue1 = cell.getStringCellValue();
					if (rowValue1.length() >= 1) {
						expRowValues = rowValue1;
					}
					System.out.println("Temp2: " + rowValue1);
					saveValue = false;
					// rowValues.add(temp);
					// System.out.print(cell.getStringCellValue() + "t");
					break;
				}
				if (saveValue) {
					allRowValues = allRowValues + expRowValues.trim() + ";";
				}

			}
		} catch (Exception e) {
			// no exception
		}
		String moreValuesString[] = allRowValues.split(";");
		System.out.println("Length of the String: " + moreValuesString.length);
		if (moreValuesString.length <= 1) {
			allRowValues = moreValuesString[0];
		}
		return allRowValues;
	}

	private void writeExtractedDataToExcel(String filePath, String fileName, List<String> teamRulesTableDataRowWise) throws Exception {
		String configPath = "", fileVar = "", fileSend = "";

		// To get canonical path..
		try {
			configPath = StringUtils.stripEnd(filePath, "/\\");
			configPath = (new File(filePath)).getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new Exception();
		}

		fileVar = configPath + "\\";
		fileSend = fileVar + fileName;
		FileInputStream file = null;

		try {
			file = new FileInputStream(new File(fileSend));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			throw new Exception();
		}

		// Create Workbook instance holding reference to .xls file
		org.apache.poi.ss.usermodel.Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
			throw new Exception();
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new Exception();
		}

		int sheetCount = workbook.getActiveSheetIndex();
		Sheet sheet = workbook.getSheetAt(sheetCount);
		int rowCount2 = sheet.getLastRowNum();
		for (int i = 0; i <= rowCount2; i++) {
			removeRow(sheet, i);
		}
		int rowCount = 0;
		// get the first sheet in workbook and create a row and fill up the cell
		// values
		Sheet sheet2 = workbook.getSheetAt(0);
		for (String data : teamRulesTableDataRowWise) {
			Row r = sheet2.createRow(rowCount);
			int cellCount = 0;
			for (String celldata : data.split(";")) {
				Cell cellVal = r.createCell(cellCount);
				cellVal.setCellValue(celldata);
				cellCount++;
			}
			rowCount++;
		}

		try {
			FileOutputStream out = new FileOutputStream(new File(fileSend));
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeRow(Sheet sheet, int rowIndex) {
		int lastRowNum = sheet.getLastRowNum();
		if (rowIndex >= 0 && rowIndex < lastRowNum) {
			sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
		}
		if (rowIndex == lastRowNum) {
			Row removingRow = sheet.getRow(rowIndex);
			if (removingRow != null) {
				sheet.removeRow(removingRow);
			}
		}
	}
	
	public String getAllLinks(WebDriver driver) throws Exception {
		String urls = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(urls="function getalllinks($url){"
						+"links = array();"
						+"if ($fp = fopen($url, 'r')) {"
						+"$content = '';"
						+"while ($line = fread($fp, 1024)) {"
						+"$content .= $line;"
						+"}"
						+"}"
						+"$textLen = strlen($content);" 
						+"if ( $textLen > 10){"
						+"$startPos = 0;"
						+"$valid = true;"
						+"while ($valid){"
						+"$spos  = strpos($content,'<a ',$startPos);"
						+"if ($spos < $startPos) $valid = false;"
						+"$spos     = strpos($content,'href',$spos);"
						+"$spos     = strpos($content,'\"',$spos)+1;"
						+"$epos     = strpos($content,'\"',$spos);"
						+"$startPos = $epos;"
						+"$link = substr($content,$spos,$epos-$spos);"
						+"if (strpos($link,'http://') !== false) $links[] = $link;"
						+"}"
						+"}"
						+"return $links;"
						+"}", "");
		return urls;
	}
	
}
