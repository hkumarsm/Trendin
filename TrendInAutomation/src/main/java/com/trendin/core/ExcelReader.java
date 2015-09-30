package com.trendin.core;



import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.trendin.core.util.datadriver.DataDriver;
import com.trendin.core.util.datadriver.DataDriverFactory;
import com.trendin.core.util.datadriver.DataRow;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 
 * This is a utility class created to read the excel test data file before
 * performing the test steps.
 * 
 * This class loads the excel file and
 * 
 * reads its column entries.
 *
 * 
 * 
 */

public class ExcelReader {
	static Utility utility = new Utility();
	/**
	 * 
	 * The worksheet to read in Excel file
	 * 
	 */

	public static Sheet wrksheet;

	/**
	 * 
	 * The Excel file to read
	 * 
	 */

	public static Workbook wrkbook = null;

	/**
	 * 
	 * Store the column data
	 * 
	 */

	public static Hashtable<String, Integer> dict = new Hashtable<String, Integer>();

	/**
	 * 
	 * Create a Constructor
	 *
	 * 
	 * 
	 * @param ExcelSheetPath
	 * 
	 * @throws BiffException
	 * 
	 * @throws WeblivException
	 * 
	 */

	public ExcelReader(String excelSheetPath, String baseSheetColumnName, String testCaseName) throws IOException, BiffException {
		String sheetName = "";
		try {
			wrkbook = Workbook.getWorkbook(new File(excelSheetPath));
			wrksheet = wrkbook.getSheet(baseSheetColumnName);
			try {
				sheetName = getTestCaseSheetNameBasedOnTestCaseName(excelSheetPath, baseSheetColumnName, testCaseName);
			} catch (Exception e) {
				throw new IOException();
			}
			wrksheet = wrkbook.getSheet(sheetName);
		} catch (IOException e) {
			throw new IOException();
		}
	}

	public String getTestCaseSheetNameBasedOnTestCaseName(String filePath, String baseSheetColumnName, String testCaseName) throws Exception {
		String testSheetName = "";
		DataDriver testfile = DataDriverFactory.create(filePath, baseSheetColumnName);
		// Load test cases
		DataRow testCaseRow;

		while (testfile.hasNext()) {
			testCaseRow = testfile.nextRow();
			String testCase = testCaseRow.getItem(baseSheetColumnName);
			// Parse log level

			if(testCase.trim().equals(testCaseName)){
				String dataSrc = testCaseRow.getItem("Test Data Sheet");

				// Create test case
				if (dataSrc == null || dataSrc.equals("NA")) {
					testSheetName = "NA";
				} else {
					testSheetName = dataSrc;
				}
				break;
			}
		}
		return testSheetName;
	}

	/**
	 * 
	 * Returns the Number of Rows
	 *
	 * 
	 * 
	 * @return Rows
	 * 
	 */

	public static int RowCount() {
		return wrksheet.getRows();
	}

	/**
	 * 
	 * Returns the Cell value by taking row and Column values as argument
	 *
	 * 
	 * 
	 * @param column
	 * 
	 * @param row
	 * 
	 * @return Cell contents
	 * 
	 */

	public static String ReadCell(int column, int row) {
		return wrksheet.getCell(column, row).getContents();
	}

	/**
	 * 
	 * Create Column Dictionary to hold all the Column Names
	 * 
	 */

	public void columnDictionary() {
		// Iterate through all the columns in the Excel sheet and store the
		// value in Hashtable
		for (int col = 0; col < wrksheet.getColumns(); col++) {
			dict.put(ReadCell(col, 0), col);
			System.out.println("Contents of the set are: "+ dict.get(ReadCell(col, 0)));
		}

	}

	/**
	 * 
	 * Read Column Names
	 *
	 * 
	 * 
	 * @param colName
	 * 
	 * @return value
	 * 
	 */

	public static int GetCell(String colName) {
		try {
			int value;
			value = dict.get(colName).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);
		}

	}

	public static String getValue(String colName) {
		// int value = GetCell(colName);
		colName = utility.readExcelData(colName);
		return colName;
	}

}
