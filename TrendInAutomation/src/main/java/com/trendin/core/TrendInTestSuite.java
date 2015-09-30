package com.trendin.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.trendin.core.util.exceptions.POMValidationException;
import com.trendin.core.util.fileio.FileTools;
import com.trendin.core.util.logging.Logger;
import com.trendin.core.util.reporting.EventCase;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TrendInTestSuite {

	public static final String TC_HEAD = "Test Case";
	public static WebDriver driver;
	public static final String TIMEOUT;
	private static TestParams params;
	private static Properties props;
	private static boolean runningSuite = false;
	private static boolean browserInvoked = false;
	static EventCase ev = new EventCase("TrendIn", "./reports/");
	static Logger log = new Logger();
	String browser = GlobalConstants.BROWSER;
	static {
		try {
			props = new Properties();
			FileInputStream in = new FileInputStream("./resources/configuration.properties");
			props.load(in);
			in.close();
		} catch (IOException e) {
			System.err.println("Error loading properties:");
			e.printStackTrace();
		}

		TIMEOUT = props.getProperty("timeout", "25000");
		System.out.println("Timeout: " + TIMEOUT);
		ev.screenshot = true;
		System.setProperty("sun.net.client.defaultConnectTimeout", TIMEOUT);
		System.setProperty("sun.net.client.defaultReadTimeout", TIMEOUT);

	}

	private String suite;
	private String operation;
	public static String testMethodName;
	private String methodName;
	private static String comment;
	private static boolean failed = false;
	static int allExecutedTCs = 0;
	static int allPassedTCs = 0;
	static int allFailedTCs = 0;
	static int allWarningTCs = 0;
	static int allSkippedTCs = 0;
	static String inputDataFileUsed = "0";
	

	public void setComment(String newComment) {
		comment = newComment;
	}

	public void addComment(String comment) {
		TrendInTestSuite.comment += "<BR>" +  "<B>Step passed: </B>"  +comment;
	}

	public static void log(String message) {
		log.info(message);
	}

	public void err(String message) throws POMValidationException {
		log.error(message);
		assertFalse(true, message , message);
	}

	public void warn(String message) {
		log.warning(message);
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		suite = context.getSuite().getName();
		log("Starting suite " + suite);
		ev.startUC(suite, "");
		runningSuite = true;
	}
	

	
	
	
	@Parameters({ "sendEmail", "openReport" })
	@AfterSuite(alwaysRun = true)
	public void finishReport(@Optional("false") String sendEmail, @Optional("true") String openReport) {
		log("Ending suite " + suite);

		if (failed) {
			ev.failUC(suite, "", "");
		} else {
			ev.passUC(suite, "", "");
		}

		// email report
		String reportPath = (new File(ev.getFileName())).getAbsolutePath();
		if (Boolean.parseBoolean(sendEmail)) {
			sendEmail(reportPath);
		}

		// Open up report in web browser.
		if (Boolean.parseBoolean(openReport)) {
			try {
				String report = "file:///" + reportPath.replace('\\', '/').replace("./", "").replace(" ", "%20");
				java.awt.Desktop.getDesktop().browse(new java.net.URI(report));
			} catch (Exception e) {
				log("Couldn't open browser to view report: " + e.getMessage());
			}
		}

		ev.closeLoggers();
		runningSuite = false;
	}

	@BeforeTest(alwaysRun = true)
	public void starting(ITestContext context) throws Exception {
		ITestNGMethod[] tests = context.getAllTestMethods();
		String[] testNames = new String[tests.length];
		for (int i = 0; i < tests.length; i++) {
			testNames[i] = tests[i].getMethodName();
		}
		operation = context.getName();
		log("Starting test " + operation);
		try {
			if(!runningSuite) {
				setUp();
				System.out.println("Successfully launched the browser.");
			}
		} catch(Exception e) {
			System.out.println("Exception for opening the browser: "+ e);
		}
		ev.startScenario(operation, "", Arrays.toString(testNames), "", "");
	}
	
	
	public void setUp() throws Exception {
		System.out.println(this.getClass().getCanonicalName());
		System.out.println("---------------STARTED " + browser + "----------------------");
		System.out.println("-------------------------------------");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\TrnedInNewAutomation\\TrendInAutomation\\lib\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type"); 
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			/*FirefoxBinary fb = new FirefoxBinary();
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("dom.max_chrome_script_run_time", 0);
			fp.setPreference("dom.max_script_run_time", 0);*/
			driver = new FirefoxDriver(); //FirefoxDriver(fb, fp);
		} 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Now go to the application Base URL
		driver.manage().deleteAllCookies();
		driver.get(GlobalConstants.BASE_URL);
		Thread.sleep(5000);
		
	}
	

	@AfterTest(alwaysRun = true)
	public void ending(ITestContext context) throws Exception {
		log("Ending test " + operation);
		int pass = context.getPassedTests().size();
		int skip = context.getSkippedTests().size();
		int fail = context.getFailedTests().size();
		int total = pass + skip + fail;
		String count = ((pass > 0) ? "Pass: " + pass + "/" + total + "<BR>" : "") + ((skip > 0) ? "Skip: " + skip + "/" + total + "<BR>" : "") + ((fail > 0) ? "Fail: " + fail + "/" + total : "");
		for (ITestNGMethod meth : context.getSkippedTests().getAllMethods()) {
			ev.warnTC(operation, meth.getMethodName(), "", "", "skipped");
		}
		if (fail > 0) {
			ev.failScenario(operation, "", "", "", count);
			failed = true;
		} else {
			ev.passScenario(operation, "", "", "", count);
		}
		if(!runningSuite) {
			tearDown();
		}
	}
	
	public void tearDown() throws Exception {
		System.out.println("END : " + this.getClass().getSimpleName());
		System.out.println("---------------ENDED BROWSER----------------------");
		driver.quit();
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void start(java.lang.reflect.Method testMethod) throws Exception {
		testMethodName = testMethod.getName();
		comment = "";
		log("Starting test method: " + testMethodName);
		if(runningSuite){
			setUp();
		}
		String desc = "";
		{
			try {
				ExcelReader excelReaderObj;
				String workingDir = System.getProperty("user.dir");
				excelReaderObj = new ExcelReader(workingDir+"\\resources\\TDS_TrendIn.xls", "Test Cases", testMethodName);
				excelReaderObj.columnDictionary();
			} catch(Exception e) {
				System.out.println("No data sheet provider the TC: "+ testMethodName);
			}
			// Get the data from excel file
		}
		ev.startTC(operation, testMethodName, desc, "", comment);
	}

	@AfterMethod(alwaysRun = true)
	public void end(ITestResult result, Object[] parameters) throws Exception {
		log("Ending test method " + testMethodName);
		// Report result
		if (result.isSuccess()) {
			ev.passTC(operation, testMethodName, testMethodName, "", comment);
		} else {
			Throwable th = result.getThrowable();
			String message = th == null ? "No exception thrown" : th.toString();
			th = result.getThrowable().getCause();
			if(th == null){
				message = "<b> Exception: </b>" + message + ". <b> Cause: </b>";
			} else {
				message = "<b> Exception: </b>" + message + ". <b> Cause: </b>"+th.toString();
			}
			log.error(message);
			ev.failTC(operation, testMethodName, methodName, message, comment);
		}
		if(runningSuite) {
			tearDown();
		}
	}
/*
	@DataProvider(name = "LoginPageDataSheet")
	public Object[][] loadTestSheet(Method m) {

		if (params == null) {
			return new Object[][] { { new java.util.HashMap<String, String>() } };
		}

		return params.getParamList(operation, m.getName());
	}*/

	public static int getSafeInt(String s) {
		return FileTools.getSafeInt(s);
	}

	public void sendEmail(String filePath) {
		try {

			boolean result = Email.sendEmail(filePath);
			if (result) {
				log("Email sent successfully");
			} else {
				// Shouldn't ever get here
				log("Error sending email?????");
			}
		} catch (Exception e) {
			log("Error sending email: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public File getFile(String fileName) throws IOException {
		System.out.println("Getting file " + fileName);
		return new File(System.getProperty("user.dir") + "/resources/" + fileName);
	}
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
	public Object[][] testDataSource() throws BiffException, IOException {
		Object[][] arrayObject = getExcelData("D:\\TrnedInNewAutomation\\TrendInAutomation\\resources\\EndToEnd.xls", "");
		return arrayObject;
	}
	
	 public void assertTrue(boolean condition, String successMessage, String failMessage) throws POMValidationException {
		 if(condition == true) {
			 TrendInTestSuite.comment += "<BR>" + "<B>Validated: </B>"+successMessage;
		 } else {
			 throw new POMValidationException(failMessage);
		 }
	 }
	 
	 public void assertFalse(boolean condition, String successMessage, String failMessage) throws POMValidationException {
		 if(condition == false) {
			 TrendInTestSuite.comment += "<BR>" + "<B> Validated: </B>"+successMessage;
		 } else {
			 throw new POMValidationException(failMessage);
		 }
	 }
	 
	 public void assertEquals(boolean condition, String successMessage, String failMessage) throws POMValidationException {
		 if(condition == true) {
			 TrendInTestSuite.comment += "<BR>" + "<B> Validated: </B>"+successMessage;
		 } else {
			 throw new POMValidationException(failMessage);
		 }
	 }
	 
	 public void assertNotEquals(boolean condition, String successMessage, String failMessage) throws POMValidationException {
		 if(condition == false) {
			 TrendInTestSuite.comment += "<BR>" + "<B> Validated: </B>"+successMessage;
		 } else {
			 throw new POMValidationException(failMessage);
		 }
	 }
	 

}
