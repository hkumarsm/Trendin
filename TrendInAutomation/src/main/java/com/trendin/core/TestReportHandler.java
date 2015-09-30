package com.trendin.core;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class TestReportHandler {
	// These values will be inherited from the TrendInTestSuite class
	static int allExecutedTCs = TrendInTestSuite.allExecutedTCs;
	static int allPassedTCs = TrendInTestSuite.allPassedTCs;
	static int allFailedTCs = TrendInTestSuite.allFailedTCs;
	static int allWarningTCs = TrendInTestSuite.allWarningTCs;
	static int allSkippedTCs = TrendInTestSuite.allSkippedTCs;
	static String inputDataFileUsed = TrendInTestSuite.inputDataFileUsed;

	private static Logger logger = Logger.getLogger("com.trendin.core");

	private static int totalSuccessTestCases = 0;
	private static int totalTestCases = 0;

	public static void generateReport() throws Exception {

		try {
			String testSummaryHtmlFile = File.separator + "detailed_reports" + File.separator + "TestSummary.html";
			StringBuffer testSummaryContent = new StringBuffer();
			// Now append the Report Title
			String htmlReportTitle = "Qualitest Automation Testing - Test Summary";
			testSummaryContent.append("<!doctype html><head><meta charset=\"ASCII\"><title>" + htmlReportTitle + "</title>");
			testSummaryContent.append("<style type=\"text/css\">");
			testSummaryContent.append("<BR");
			// Now append the Report column values to the report
			String tableRowsForAllTetsCasesValues = "<table> <tbody> <th>No of Test Cases Executed: " + allExecutedTCs + "  </th> </tbody> </table>";
			testSummaryContent.append(tableRowsForAllTetsCasesValues);
			testSummaryContent.append("<BR");
			String tableRowsForAllTetsCasesPassedValues = "<table> <tbody> <th>No of Test Cases Passed: <a> " + allPassedTCs + " </a> </th> </tbody> </table>";
			testSummaryContent.append(tableRowsForAllTetsCasesPassedValues);
			testSummaryContent.append("<BR");
			String tableRowsForAllTetsCasesFailedValues = "<table> <tbody> <th>No of Test Cases Failed: <a> " + allFailedTCs + " </a> </th> </tbody> </table>";
			testSummaryContent.append(tableRowsForAllTetsCasesFailedValues);
			testSummaryContent.append("<BR");
			String tableRowsForAllTetsCasesWarningsValues = "<table> <tbody> <th>No of Test Cases Warnings: <a> " + allWarningTCs + " </a> </th> </tbody> </table>";
			testSummaryContent.append(tableRowsForAllTetsCasesWarningsValues);
			testSummaryContent.append("<BR");
			String tableRowsForAllTetsCasesSkippedValues = "<table> <tbody> <th>No of Test Cases Skipped: <a> " + allSkippedTCs + " </a> </th> </tbody> </table>";
			testSummaryContent.append(tableRowsForAllTetsCasesSkippedValues);
			testSummaryContent.append("<BR");
			String tableRowsForTheTestFileUsed = "<table> <tbody> <th>No of Test Cases Skipped:  " + inputDataFileUsed + "  </th> </tbody> </table>";
			testSummaryContent.append(tableRowsForTheTestFileUsed);
			testSummaryContent.append("<BR");
			HtmlHandler.beginHeaderRow(testSummaryContent);

			// Print the Test Summary here of the rest of the Test cases (all) here.

			testSummaryContent.append("table{border-width: 1px 1px 1px 1px; border-spacing: 0;border-collapse: collapse; border-style: solid; border-color: #0000FF;}");
			testSummaryContent.append("tr,th,td{margin: 0; padding: 4px; border-width: 1px 1px 1px 1px; border-style: solid; border-color: #0000FF;}");
			testSummaryContent.append("</style>");
			testSummaryContent.append("</head><body style=\"font-family:Calibri,Georgia,Serif; background-color: #FFFFFF;\">");

			testSummaryContent.append("<TABLE width=\"100%\"><TR bgcolor=\"#4998c9\" style=\" height : 40px;\">");
			testSummaryContent.append("<TH style=\"FONT-SIZE: 18px; color: #ffffff;vertical-align: middle;\">" + htmlReportTitle + "</TH></TR></TABLE>");

			testSummaryContent.append("<BR><BR>");
			testSummaryContent.append("<TABLE id=\"executionSummary\" class=\"static\" ALIGN=\"CENTER\" width=\"100%\" ><TR ALIGN=\"CENTER\" bgcolor=\"#4998c9\">");

			testSummaryContent.append("<TH colspan = '12' style=\"FONT-SIZE: 18px; color: #ffffff\" >Execution Summary</TH></TR><TR ALIGN=\"CENTER\" bgcolor=\"#4998c9\" style=\"FONT-SIZE: 14px; color: #ffffff\"><TH>Test Run Id</TH>");
			testSummaryContent
					.append("<TH>Test Execution Account</TH><TH>Test Suite Name</TH><TH>Test Plan Parameter</TH><TH>Test Group Parameter</TH><TH>App Module Parameter</TH><TH>Test Category Parameter</TH><TH>Test Sub Category Parameter</TH><TH>Test Case Parameter</TH><TH>Start Time</TH>");
			testSummaryContent.append("<TH>End Time</TH><TH>Duration</TH></TR>");

			HtmlHandler.beginHeaderRow(testSummaryContent);
			HtmlHandler.endRow(testSummaryContent);
			testSummaryContent.append("</TABLE>");

			testSummaryContent.append("<BR><BR>");

			testSummaryContent.append("<TABLE id=\"resultsSummary\" class=\"dynamic\" ALIGN=\"CENTER\" width=\"75%\"><TR ALIGN=\"CENTER\">");
			testSummaryContent.append("<TR ALIGN=\"CENTER\" bgcolor=\"#4998c9\">");
			testSummaryContent.append("<TH colspan = '7' class=\"header\" style=\"FONT-SIZE: 18px; color: #ffffff\">Results Summary</TH></TR>");

			testSummaryContent.append("<TR ALIGN=\"CENTER\" bgcolor=\"#4998c9\" style=\"FONT-SIZE: 14px; color: #ffffff\">" + "<TH>Test Type</TH><TH>Total</TH><TH>Executed</TH><TH>Execution % </TH><TH>Success</TH>"
					+ "<TH>Success %</TH><TH>Failure</TH></TR>");

			testSummaryContent.append("<TR ALIGN=\"CENTER\" onClick=\"window.open('ETLSummary.html','_self');" + "\" style=\"text-decoration:underline;cursor: pointer;\">" + "<TD ALIGN=\"LEFT\" style=\"padding-left: 10px\">ETL</TD>");

			testSummaryContent.append("</body></html>");
			HtmlHandler.endHTMLDoc(testSummaryContent);

		} catch (Exception e) {
			logger.fatal("Error occurred while generating test results report", e);
		}
	}

	private static double getCoveragePercentage(int numberOfExecuted, int totalNumber) {
		if (totalNumber == 0) {
			return 0;
		}
		double coveragePercentage = (float) (numberOfExecuted * 100.0) / totalNumber;
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(coveragePercentage));
	}

	private static String getDateString(Date date) {
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return dateformat.format(date);
	}

	private static String getTimeString(long time) {

		double sec = 1.0 * time / 1000;
		double mins = 1.0 * sec / 60;
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		String timeString = null;
		if (sec > 3600) {
			timeString = "" + (int) (mins / 60) + " hr " + (int) (mins % 60) + " min " + (int) (1.0 * sec % 60) + " sec";
		} else if (sec > 60) {
			timeString = "" + (int) (mins % 60) + " min " + (int) (sec % 60) + " sec";
		} else {
			timeString = "" + Double.valueOf(twoDForm.format(sec)) + " sec";
		}

		return timeString;
	}


















	private static String arrayToString(List<String> strings) {
		StringBuilder sb = new StringBuilder();
		for (String n : strings) {
			if (sb.length() > 0)
				sb.append(',');
			sb.append("").append(n).append("");
		}
		return sb.toString();
	}




}
