package com.trendin.core;

import java.util.ArrayList;

public class Utility {
	public static boolean runningTestInLocal = true;

	/**
	 * Read the test data from excel file
	 *
	 * @param data
	 *            The TestData data object
	 */

	public String readExcelData(String colValue) {

		ArrayList<String> values = new ArrayList<String>();

		// Get the data from excel file
	//	for (int rowCnt = 1; rowCnt < ExcelReader.RowCount(); rowCnt++) {
			values.add(ExcelReader.ReadCell(ExcelReader.GetCell(colValue), 1));
		//}
		return values.get(0);
	}

}
