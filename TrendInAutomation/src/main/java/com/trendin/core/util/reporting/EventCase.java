package com.trendin.core.util.reporting;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggingEvent;
import com.trendin.core.util.fileio.FileTools;

/**
 * Transfers data from data sheet to HTML table and logs success/failure, color
 * codes them, and returns test case comments
 * 
 * @author Neo
 */
@SuppressWarnings("unused")
public class EventCase {
	// Static variable for colors
	final private static String SUCCESS = "#00FF00";
	final private static String FAIL = "#FF0000";
	final private static String WARN = "#FFFF00";
	final private static String START = "#CCCCCC";
	final private static String KWSTART = "#EEEEEE";

	private Logger logger = Logger.getRootLogger();
	private Logger testLogger = Logger.getLogger("testLog");
	private Logger exceptionLogger = Logger.getLogger("exceptionLog");

	private FileAppender mainApd;
	private FileAppender exceptionApd;
	private String exceptionBaseFileName;
	private int exceptionCount = 0;
	private String exceptionFileDate;
	public FileAppender testApd;
	private String appName;
	private String loggingDir;
	private boolean debugToMainLog = true;
	private String reportFile = "";
	private String logFile = "";
	public static String scenario = "";
	private String fileDate = "";

	public boolean screenshot = true;

	public static final String TEST_PATH = System.getProperty("user.dir");
	public static boolean preconditionInfoMessage = false; 
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HHmmssZ");

	/**
	 * @param appName
	 * @param loggingDir
	 */
	public EventCase(String appName, String loggingDir) {
		this.appName = appName;
		this.loggingDir = loggingDir;

		// Set up logging configuration from property file.
		InputStream io = EventCase.class.getResourceAsStream("logging.properties");
		PropertyConfigurator.configure(io);

		// Get the current date and time.
		fileDate = getDateTime();

		// Get the main log appender and override the log file name w/ the
		// detailed name.
		mainApd = (FileAppender) logger.getAppender("main");
		logFile = loggingDir + "debug//" + fileDate + "_" + appName + "_" + mainApd.getFile();
		mainApd.setFile(logFile);
		mainApd.activateOptions();

		// Get the exception log appender base file name for use when logging
		// exceptions.
		exceptionApd = (FileAppender) exceptionLogger.getAppender("exception");
		exceptionBaseFileName = exceptionApd.getFile();

		// Disable exception log additivity.
		exceptionLogger.setAdditivity(false);

		// Disable selenium's crap-ton of debug messages
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");

		// Get the test log appender and override the log file name w/ the detailed name.
		testApd = (FileAppender) testLogger.getAppender("test");
		reportFile = loggingDir + appName + "_" + fileDate + "_" + testApd.getFile();
		testApd.setFile(reportFile);
		testApd.activateOptions();
		// Disable test log additivity.
		testLogger.setAdditivity(false);
	}

	public void closeLoggers() {
		mainApd.close();
		exceptionApd.close();
		testApd.close();

		// delete extraneous files
		try {
			File f = new File("TestLog.html");
			f.delete();
			f = new File("ExceptionLog.log");
			f.delete();
			f = new File("Debug.log");
			f.delete();
		} catch (Exception e) {
		}
	}

	public String convertStackToString(Throwable t) {
		StringWriter stringWritter = new StringWriter();
		PrintWriter printWritter = new PrintWriter(stringWritter, true);

		t.printStackTrace(printWritter);
		printWritter.flush();
		stringWritter.flush();

		return stringWritter.toString();
	}

	public void debug(String message) {
		logger.debug(message);

		if (debugToMainLog) {
			String msg = "<td>.</td><td>DEBUG</td><td>DEBUG MESSAGE</td><td>" + message + "</td><td></td>" + "<td></td><td></td>";
			LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
			log.setProperty("event", "debug");
			testLogger.callAppenders(log);
		}
	}

	public void addComment(String comment) {
		String msg = "<td>.</td><td></td><td></td><td>" + comment + "</td><td></td>" + "<td></td><td></td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "comment");
		testLogger.callAppenders(log);
	}

	/**
	 * This will create a new time stamped filename for each exception thrown.
	 * Each exception file will be closed off when the logging is finished.
	 * These individual files can be linked into the test log.
	 * 
	 * @param message
	 * @param exception
	 * @return
	 */
	public String error(String message, String exception) {
		// Reset the exception log appender w/ the detailed date-time name.
		String fileDate = getDateTime();
		String exceptionApdFileName;

		// Check if this specific filename has already been used... if so,
		// update the
		// Exception count and add it to the file name. If not, reset the
		// exception count,
		// do not use it, and update the file date.
		if (fileDate.equals(exceptionFileDate)) {
			exceptionCount++;
			exceptionApdFileName = fileDate + "_" + exceptionCount + "_" + appName + "_" + exceptionBaseFileName;
		} else {
			exceptionApdFileName = fileDate + "_" + appName + "_" + exceptionBaseFileName;
			exceptionFileDate = fileDate;
			exceptionCount = 0;
		}

		exceptionApd = (FileAppender) exceptionLogger.getAppender("exception");

		exceptionApd.setFile(loggingDir + "exceptions//" + exceptionApdFileName);
		exceptionApd.activateOptions();

		// Log exception
		exceptionLogger.error(message + " - " + exception);

		return exceptionApdFileName;
	}

	/**
	 * Fail event for test case
	 * 
	 * @param tcID
	 *            - test case ID
	 * @param tcDesc
	 *            - test case description
	 * @param tcSteps
	 *            - test case steps
	 * @param tcResults
	 *            - test case results
	 * @param comments
	 */
	public void failTC(String tcID, String tcDesc, String tcSteps, String tcResults, String comments) {
		String shot = screenshot ? " - <a href=\"screenshots/" + screenshot() + "\">Screen Shot</a>" : "";

		String msg = "<td>.</td><td>" + tcID + "</td><td>" + tcDesc + "</td><td>" + tcSteps + "</td><td>" + tcResults + "</td><td bgcolor=" + FAIL + ">FAIL</td><td>" + comments + shot + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "failTC");
		testLogger.callAppenders(log);
	}

	/**
	 * Fail event for scenario
	 * 
	 * @param scenarioID
	 * @param scenarioDesc
	 * @param scenarioSteps
	 * @param scenarioResults
	 * @param comments
	 */
	public void failScenario(String scenarioID, String scenarioDesc, String scenarioSteps, String scenarioResults, String comments) {

		String msg = "<td bgcolor=" + FAIL + ">.</td><td bgcolor=" + FAIL + ">" + scenarioID + "</td><td bgcolor=" + FAIL + ">" + scenarioDesc + "</td><td bgcolor=" + FAIL + ">" + scenarioSteps + "</td><td bgcolor=" + FAIL + ">" + scenarioResults
				+ "</td><td bgcolor=" + FAIL + ">FAIL</td><td bgcolor=" + FAIL + ">" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "failScenario");
		testLogger.callAppenders(log);
	}

	/**
	 * Fail event for use case
	 * 
	 * @param ucID
	 *            - use case ID
	 * @param ucDesc
	 *            - use case description
	 * @param comments
	 */
	public void failUC(String ucID, String ucDesc, String comments) {

		String msg = "<td colspan=\"2\">" + ucID + "</td><td colspan=\"3\">" + ucDesc + "<td bgcolor=" + FAIL + ">FAIL</td><td>" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "failUC");
		testLogger.callAppenders(log);
	}

	public String getFileName() {
		return reportFile;
	}

	public String getLogFile() {
		return logFile;
	}

	public void info(String infoType, String message) {
		if (preconditionInfoMessage) {
			testLogger.info("<td colspan=\"2\">INFO</td><td colspan=\"4\">" + infoType + "</td><td>" + message + "</td>");
		}
	}

	public void otherException(String message, String exception) {
		String exceptionFile = error(message, exception);

		String msg = "<td>.</td><td>NA</td><td>Non TC/UC Exception Occurred</td><td>.</td><td>.</td>" + "<td bgcolor=" + FAIL + ">FAIL</td><td><a href=\"exceptions/" + exceptionFile + "\">" + message + "</a></td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "otherException");
		testLogger.callAppenders(log);
	}

	/**
	 * Pass event for test case
	 * 
	 * @param tcID
	 *            - test case ID
	 * @param tcDesc
	 *            - test case description
	 * @param tcSteps
	 *            - test case steps
	 * @param tcResults
	 *            - test case results
	 * @param comments
	 */
	public void passTC(String tcID, String tcDesc, String tcSteps, String tcResults, String comments) {

		String msg = "<td>.</td><td>" + tcID + "</td><td>" + tcDesc + "</td><td>" + tcSteps + "</td><td>" + tcResults + "</td><td bgcolor=" + SUCCESS + ">PASS</td><td>" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "passTC");
		testLogger.callAppenders(log);
	}

	/**
	 * Pass event for scenario
	 * 
	 * @param scenarioID
	 * @param scenarioDesc
	 * @param scenarioSteps
	 * @param scenarioResults
	 * @param comments
	 */
	public void passScenario(String scenarioID, String scenarioDesc, String scenarioSteps, String scenarioResults, String comments) {
		String msg = "<td bgcolor=" + SUCCESS + ">.</td><td bgcolor=" + SUCCESS + ">" + scenarioID + "</td><td bgcolor=" + SUCCESS + ">" + scenarioDesc + "</td><td bgcolor=" + SUCCESS + ">" + scenarioSteps + "</td><td bgcolor=" + SUCCESS + ">"
				+ scenarioResults + "</td><td bgcolor=" + SUCCESS + ">PASS</td><td bgcolor=" + SUCCESS + ">" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "passScenario");
		testLogger.callAppenders(log);
	}

	/**
	 * Pass event for use case
	 * 
	 * @param ucID
	 *            - use case ID
	 * @param ucDesc
	 *            - use case description
	 * @param comments
	 */
	public void passUC(String ucID, String ucDesc, String comments) {
		String msg = "<td colspan=\"2\">" + ucID + "</td><td colspan=\"3\">" + ucDesc + "<td bgcolor=" + SUCCESS + ">PASS</td><td>" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "passUC");
		testLogger.callAppenders(log);
	}

	/**
	 * Captures and saves a screen shot at return
	 * 
	 * @return a screenshot
	 */
	public String screenshot() {
		if (!screenshot)
			return "";
		try {
			// Get the screen size...
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);

			// Get the image...
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(rectangle);

			// Setup the image path and name...
			String screenshotName = "shot_" + getDateTime() + ".jpg";

			// Create the file...
			File file = new File(loggingDir + "screenshots//" + screenshotName);
			file.getParentFile().mkdirs();
			ImageIO.write(image, "jpg", file);

			// Return the file name...
			return screenshotName;
		} catch (AWTException ae) {
			System.out.println(ae.getMessage());
			ae.printStackTrace();
			return "error";
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
			return "error";
		}
	}

	public void setDebugToMainLog(boolean set) {
		debugToMainLog = set;
	}

	/**
	 * Skip event for test case
	 * 
	 * @param tcID
	 *            - test case ID
	 * @param tcDesc
	 *            - test case description
	 * @param tcSteps
	 *            - test case steps
	 * @param tcResults
	 *            - test case results
	 * @param comments
	 */
	public void warnTC(String tcID, String tcDesc, String tcSteps, String tcResults, String comments) {
		String msg = "<td>.</td><td>" + tcID + "</td><td>" + tcDesc + "</td><td>" + tcSteps + "</td><td>" + tcResults + "</td><td bgcolor=" + WARN + ">WARNING</td><td>" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "warnTC");
		testLogger.callAppenders(log);

	}

	public void startTC(String tcID, String tcDesc, String tcSteps, String tcResults, String comments) {
		String msg = "<td bgcolor=" + KWSTART + ">.</td><td bgcolor=" + KWSTART + ">" + tcID + "</td><td bgcolor=" + KWSTART + ">" + tcDesc + "</td><td bgcolor=" + KWSTART + ">" + tcSteps + "</td><td bgcolor=" + KWSTART + ">" + tcResults
				+ "</td><td bgcolor=" + KWSTART + ">STARTED</td><td bgcolor=" + KWSTART + ">" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "startTC");
		testLogger.callAppenders(log);
	}

	/**
	 * Start event for use case
	 * 
	 * @param ucID
	 *            - use case ID
	 * @param ucDesc
	 *            - use case description
	 */
	public void startUC(String ucID, String ucDesc) {
		String msg = "<td colspan=\"2\">" + ucID + "</td><td colspan=\"3\">" + ucDesc + "</td><td></td><td>Test started.</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "startUC");
		testLogger.callAppenders(log);
	}

	/**
	 * Start event for scenario
	 * 
	 * @param scenarioID
	 * @param scenarioDesc
	 * @param scenarioSteps
	 * @param scenarioResults
	 * @param comments
	 */
	public void startScenario(String scenarioID, String scenarioDesc, String scenarioSteps, String scenarioResults, String comments) {

		String msg = "<td bgcolor=" + START + ">.</td><td bgcolor=" + START + ">" + scenarioID + "</td><td bgcolor=" + START + ">" + scenarioDesc + "</td><td bgcolor=" + START + ">" + scenarioSteps + "</td><td bgcolor=" + START + ">"
				+ scenarioResults + "</td><td bgcolor=" + START + ">STARTED</td><td bgcolor=" + START + ">" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "startScenario");
		testLogger.callAppenders(log);

		scenario = scenarioID;
	}

	/**
	 * Skipped event for scenario
	 * 
	 * @param scenarioID
	 * @param scenarioDesc
	 * @param scenarioSteps
	 * @param scenarioResults
	 * @param comments
	 */
	public void warnScenario(String scenarioID, String scenarioDesc, String scenarioSteps, String scenarioResults, String comments) {
		String msg = "<td bgcolor=" + WARN + ">.</td><td bgcolor=" + WARN + ">" + scenarioID + "</td><td bgcolor=" + WARN + ">" + scenarioDesc + "</td><td bgcolor=" + WARN + ">" + scenarioSteps + "</td><td bgcolor=" + WARN + ">" + scenarioResults
				+ "</td><td bgcolor=" + WARN + ">WARNING</td><td bgcolor=" + WARN + ">" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "warnScenario");
		testLogger.callAppenders(log);

		scenario = scenarioID;

	}

	/**
	 * Untestable event for test case
	 * 
	 * @param tcID
	 *            - test case ID
	 * @param tcDesc
	 *            - test case description
	 * @param tcSteps
	 *            - test case steps
	 * @param tcResults
	 *            - test case results
	 * @param comments
	 */
	public void untestableTC(String tcID, String tcDesc, String tcSteps, String tcResults, String comments) {
		/*
		 * testLogger.info("<td>.</td><td>" + tcID + "</td><td>" + tcDesc +
		 * "</td><td>" + tcSteps + "</td><td>" + tcResults + "</td><td bgcolor="
		 * + ORANGE + ">Not Executed</td><td>" + comments + "</td>");
		 */

		String msg = "<td>.</td><td>" + tcID + "</td><td>" + tcDesc + "</td><td>" + tcSteps + "</td><td>" + tcResults + "</td><td bgcolor=" + WARN + ">SKIPPED</td><td>" + comments + "</td>";
		LoggingEvent log = new LoggingEvent("org.apache.log4j.Logger", testLogger, Level.INFO, msg, null);
		log.setProperty("event", "untestableTC");
		testLogger.callAppenders(log);

	}

	public static String getDateTime() {
		// Set up detailed log file name.
		Calendar now = Calendar.getInstance();
		return df.format(now.getTime());
	}

	public boolean copyReport(String location) {
		try {
			FileTools.copyFile(reportFile, location);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean copyLog(String location) {
		try {
			FileTools.copyFile(logFile, location);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String getFileDate() {
		return fileDate;
	}

	public String getLoggingDir() {
		return loggingDir;
	}
}
