package com.trendin.core.util.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.w3c.dom.*;

import  com.trendin.core.util.exceptions.POMMethodExecException;
import com.trendin.core.util.datadriver.DataDriver;
import com.trendin.core.util.datadriver.DataDriverFactory;
import com.trendin.core.util.datadriver.DataRow;
import com.google.common.io.Files;

import au.com.bytecode.opencsv.*;

/**
 * Methods for opening and saving different types of files.
 * 
 * @author Matthew Swircenski
 *
 */
public final class FileTools {
	
	// Private constructor to block instantiation
	private FileTools(){}
	
	/**
	 * File extension enumerator. Denotes valid file extensions, for use in comparisons and such.
	 *  
	 * @author Matthew Swircenski
	 */
	public enum FileExt{
		XLS,	// Excel '97
		XLSX,	// Excel '07
		CSV,	// Comma-separated value
		XML,	// XML
		TXT,	// Text
		LOG,	// Log
//		DB,		// Database (curr. unsupported)
		SQL,	// SQL query files
		HTML,	// HTML
		JAR,	// JAR files
		ERR;	// Unsupported/invalid extension
	}
    
    // Excel

    /**
     * Opens an Excel workbook.
     * 
     * @param filePath Path of the file to open.
     * @return Workbook object representing the Excel file
     * @throws IOException
     */
    public static CloseableWorkbook openExcel(String filePath) throws IOException
    {
    	FileInputStream f = new FileInputStream(filePath);
    	Workbook wb = null;
    	NPOIFSFileSystem npoifs = null;
    	OPCPackage pkg = null;

    	try {	    		    	
	        if(getFileExt(filePath) == FileExt.XLS)
	        {
	        	npoifs = new NPOIFSFileSystem(f);
	            wb = WorkbookFactory.create(npoifs);
	            return new CloseableWorkbook(wb, npoifs);
	        } 
	        else if (getFileExt(filePath) == FileExt.XLSX)
	    	{
	        	pkg = OPCPackage.open(f);
	            wb = WorkbookFactory.create(pkg);
	            return new CloseableWorkbook(wb, pkg);
	    	} else throw new IOException(filePath + " (Invalid file extension)");
    	} 
    	catch(IOException io) 
    	{
    		if (npoifs != null) { npoifs.close(); }
	        if (pkg != null) { pkg.close(); }
    		throw io;
    	}
    	catch(Exception e) 
    	{
    		if (npoifs != null) { npoifs.close(); }
	        if (pkg != null) { pkg.close(); }
    		throw new IOException(e.getMessage());
    	}    	
    }
    
    /**
     * Saves an Excel workbook.
     * 
     * @param wb The workbook file to save.
     * @param filePath The path to save the file to.
     * @throws IOException
     */
    public static void saveExcel(Workbook wb, String filePath) throws IOException
    {
    	if(wb instanceof CloseableWorkbook)
    	{
    		//((CloseableWorkbook) wb).close();
    		wb = ((CloseableWorkbook) wb).getWorkbook();
    	}
        if(getFileExt(filePath) == FileExt.XLS && wb instanceof HSSFWorkbook || 
           getFileExt(filePath) == FileExt.XLSX && wb instanceof XSSFWorkbook)
        {
        	try
        	{
        		// temp copy the original
        		if(new File(filePath).exists())
        		{
        			copyFile(filePath, filePath + "_tmp");
        		}
	            FileOutputStream fileOut = new FileOutputStream(filePath);
	            wb.write(fileOut);
	            fileOut.close();
	            // delete temp
	            File tmp = new File(filePath + "_tmp");
	            if(tmp.exists())
	            {
	            	tmp.delete();
	            }
        	} catch (java.io.FileNotFoundException e)
        	{
        		// File probably open, suppress exception.
        	}
        } else throw new IOException(filePath + " (Invalid file extension)");
    }
    
    /**
     * Creates a new workbook of the appropriate type (xls or xlsx) based on the given file path.
     * 
     * @param fileExt Extension of the workbook file to create.
     * @return Workbook, or null if extension inappropriate.
     */
    public static Workbook createWorkbook(FileExt fileExt)
    {
    	if(fileExt == FileExt.XLS)
    	{
    		return new HSSFWorkbook();
    	}
    	else if (fileExt == FileExt.XLSX)
    	{
    		return new XSSFWorkbook();
    	}
    	else return null;
    }
    
    // XML
    /**
     * Opens an XML file
     * 
     * @param filePath Path of the file to open.
     * @return Document object representing the XML file.
     * @throws IOException
     */
    public static Document openXML(String filePath) throws IOException
    {
        if(getFileExt(filePath) == FileExt.XML)
        {
            try {
                File fXmlFile = new File(filePath);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                return doc;
            } catch (IOException e) {
                throw e;
            } catch(Exception e) {
                // Simplify exception throwing
                throw new IOException(e.getMessage());
            }        
        } else throw new IOException(filePath + " (Invalid file extension)");
    }
    
    // CSV
    
    /**
     * Opens a CSV file reader.
     * @param filePath Path of the file to open.
     * @return CSVReader object representing the CSV file.
     * @throws IOException
     */
    public static CSVReader openCSV(String filePath) throws IOException
    {
        if(getFileExt(filePath) == FileExt.CSV)
        {
            return new CSVReader(new FileReader(filePath));
        } else throw new IOException(filePath + " (Invalid file extension)");
    }
    
    // txt
    /**
     * Opens a text (txt, log, sql, html) file for reading.
     * @param filePath Path of the file to open.
     * @return FileReader object representing the text file.
     * @throws IOException
     */
    public static BufferedReader openTxt(String filePath) throws IOException
    {
    	/*switch(getFileExt(filePath))
    	{
	    	case TXT:
	    	case LOG:
	    	case SQL:    	
	    	case HTML:
	    		return new BufferedReader(new FileReader(filePath));
	    		//return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-16"));
	    	default:
	    		throw new IOException(filePath + " (Invalid file extension)");
    	}*/
    	return new BufferedReader(new FileReader(filePath));
    }
    
    /**
     * Writes a line to a txt file.
     * @param data The string to write to the file.
     * @param filePath The path of the file to write.
     * @throws IOException
     */
    public static void writeTxtLine(String data, String filePath) throws IOException
    {
    	FileExt ext = getFileExt(filePath);
    	if(ext == FileExt.TXT ||
    	   ext == FileExt.LOG || 
    	   ext == FileExt.HTML
    	   )
    	{
    		PrintWriter pw = new PrintWriter(filePath);
    		pw.println(data);
    		pw.close();
    	} else throw new IOException(filePath + " (Invalid file extension)");
    }
    
    public static void writeFile(String filePath, String... data) throws IOException
    {
    	PrintWriter pw = new PrintWriter(filePath);
    	for(String s : data)
    	{    		
    		pw.println(s);
    	}
    	pw.close();
    }
    
    public static String readerToString(BufferedReader reader, boolean closeReader)
    {
    	StringBuffer sb = new StringBuffer();
    	String line;
		try {
			line = reader.readLine();		
	    	while(line != null)
	    	{
	    		sb.append(line);
	    		sb.append("\n");
	    		line = reader.readLine();
	    	}
		} catch (IOException e) {
			line = null;
		} finally {
			if (closeReader) {
				IOUtils.closeQuietly(reader);
			}
		}
    	return sb.toString();
    }
    
    public static String readerToString(BufferedReader reader) {
    	return readerToString(reader, false);
    }
    
    public static String[] readerToStringArray(BufferedReader reader, boolean closeReader)
    {
    	LinkedList<String> lls = new LinkedList<String>();
    	String line;
		try {
			line = reader.readLine();		
	    	while(line != null)
	    	{
	    		lls.add(line);
	    		line = reader.readLine();
	    	}
		} catch (IOException e) {
			line = null;
		} finally {
			if (closeReader) {
				IOUtils.closeQuietly(reader);
			}
		}
    	return lls.toArray(new String[0]);
    }
    
    public static String[] readerToStringArray(BufferedReader reader) {
    	return readerToStringArray(reader, false);
    }
    
    // Useful functions
    
    /**
     * Gets the file extension from a string representing a file path. 
     * 
     * @param filePath
     * @return The file extension.
     */
    public static FileExt getFileExt(String filePath)
    {
    	
        // Split path based on either '/' (*nix) or '\' (Windows)
        String[] dirSplit = filePath.split("/");
        if(dirSplit.length <= 1)
        {
            dirSplit = filePath.split("\\\\"); // One doubly-escaped (string + regex) backslash
        }
        String fileName = dirSplit[dirSplit.length - 1];
    	
    	
        // Split by '.' to get file extension
        String[] fileSplit = fileName.split("\\.");
        
        // Disregard files without extensions
        if(fileSplit.length <= 1)
        {
        	return FileExt.ERR;
        }
        
        // Determine and return proper extension
        String ext = fileSplit[fileSplit.length - 1];        
        for(FileExt x : FileExt.values())
        {
        	if(x.toString().equals(ext.toUpperCase()))
        		return x;
        }
        
        return FileExt.ERR;
    }
    
    /**
     * Returns the name (without the file extension) of a file.
     * @param filePath
     * @return
     */
    public static String getFileName(String filePath)
    {
    	// Split path based on either '/' (*nix) or '\' (Windows)
        String[] dirSplit = filePath.split("/");
        if(dirSplit.length <= 1)
        {
            dirSplit = filePath.split("\\\\"); // One doubly-escaped (string + regex) backslash
        }
        String fileName = dirSplit[dirSplit.length - 1];
    	
    	
        // Split by '.' to get file extension
        String[] fileSplit = fileName.split("\\.");
        
        
        if(fileSplit.length == 0)
        {
        	return "";
        }
        
        String ret = fileSplit[0];
        
        for(int i = 1; i < fileSplit.length - 1; i++)
        {
        	ret += "." + fileSplit[i];
        }
        
        return ret;
    }
    
    /**
     * Returns the full path of a file, without it's extension.
     * @param filePath
     * @return
     */
    public static String getFilePathNoExt(String filePath)
    {
    	
    	/*// Split path based on either '/' (*nix) or '\' (Windows)
        String[] dirSplit = filePath.split("/");
        if(dirSplit.length <= 1)
        {
            dirSplit = filePath.split("\\\\"); // One doubly-escaped (string + regex) backslash
        }
        String fileName = dirSplit[dirSplit.length - 1];
    	
    	*/
    	
        // Split by '.' to get file extension
        String[] fileSplit = filePath.split("\\.");
        
        
        if(fileSplit.length == 0)
        {
        	return "";
        }
        
        String ret = fileSplit[0];
        for(int i = 1; i < fileSplit.length - 1; i++)
        {
        	ret += "." + fileSplit[i];
        }
        
        return ret;
    }
    
    /**
     * Saves a sheet from one format to another, as specified by the given paths.
     * 
     * @param srcPath The path of the source file.
     * @param destPath The destination path
     * @return True if the file was saved successfully.
     */
    public static boolean convertSheet(String srcPath, String destPath)
    {
    	// Check for valid file extensions
    	FileExt srcExt = getFileExt(srcPath);
    	
    	switch(srcExt)
    	{
    		case XLS:
    		case XLSX:
    		case CSV:
    			// Good
    			break;
    		default:
    			// Bad
    			return false;
    	}
    	DataDriver dd = DataDriverFactory.create(srcPath);

    	return saveDataDriver(dd, destPath);
    }
    
    /**
     * Saves a DataDriver to a file. The file type can be Excel (.xls/.xlsx) or CSV (.csv)
     * 
     * @param dd The DataDriver to save.
     * @param destPath The path to save to.
     * @return Save was successful.
     */
    public static boolean saveDataDriver(DataDriver dd, String destPath)
    {
    	FileExt destExt = getFileExt(destPath);
    	try 
    	{
	    	switch(destExt)
	    	{
	    		case XLS:    			
	    		case XLSX:
	    			Workbook wb = createWorkbook(destExt);
	    			Sheet sheet = wb.createSheet();
//	    			String[] dataRow;
//	    			for(int r = 0; dd.hasNext(); r++)
//	    			{
//	    				dataRow = dd.next();
//	    				Row row = sheet.createRow(r);
//		    			for(int c = 0; c < dataRow.length; c++)
//		    			{
//		    				row.createCell(c).setCellValue(dataRow[c]);
//		    			}
//	    			}
	    			DataRow dataRow;
	    			Row row = sheet.createRow(0);
	    			for(int c = 0; c < dd.getHeaders().toArray().length; c++)
	    			{
	    				row.createCell(c).setCellValue(dd.getHeaders().toArray()[c]);
	    			}
	    			for(int r = 1; dd.hasNext(); r++)
	    			{
	    				dataRow = dd.nextRow();
	    				row = sheet.createRow(r);
		    			for(int c = 0; c < dataRow.length; c++)
		    			{
		    				row.createCell(c).setCellValue(dataRow.getItem(dataRow.getHeaders().toArray()[c]));
		    			}
	    			}
	    			saveExcel(wb, destPath);
	    			break;
	    		case CSV:
	    			CSVWriter csv = new CSVWriter(new FileWriter(destPath));
	    			LinkedList<String[]> rows = new LinkedList<String[]>();
	    			rows.add(dd.getHeaders().toArray());
	        		while(dd.hasNext())
	        		{
	        			rows.add(dd.next());
	        		}
	        		csv.writeAll(rows);
	        		csv.close();
	    			break;
	    		default:
	    			// Bad
	    			return false;
	    	}
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    	return true;
    }
    
    /**
     * Saves a ResultSet to a file. The file type can be Excel (.xls/.xlsx) or CSV (.csv)
     * 
     * @param rs The ResultSet to save.
     * @param filePath The path to save to.
     * @return Save was successful
     */
    public static boolean saveResultSet(ResultSet rs, String filePath)
    {
    	if (getFileExt(filePath) != FileExt.CSV) {
    		DataDriver dd = DataDriverFactory.create(rs);
    		return FileTools.saveDataDriver(dd, filePath); 
    	}
    	
    	try {
    		CSVWriter writer = new CSVWriter(new FileWriter(filePath));
    		List<String[]> rows = new LinkedList<String[]>();
    		
    		ResultSetMetaData rsmd = rs.getMetaData();
    		int colCount = rsmd.getColumnCount();
    		String[] headers = new String[colCount];
    		
    		for (int i = 1; i <= colCount; i++) {
    			headers[i-1] = rsmd.getColumnName(i);
    		}
    		rows.add(headers);
    		
    		while (rs.next()) {
    			String[] row = new String[colCount];
    			for (int i = 1; i <= colCount; i++) {
    				int type = rsmd.getColumnType(i);
    				String value = rs.getString(i);
    				
    				if (value != null) {
    				switch (type) {
	    				case java.sql.Types.CHAR:
	    					value = value.trim();
	    				/*case java.sql.Types.VARCHAR:
	    				case java.sql.Types.LONGVARCHAR:
	    				case java.sql.Types.NCHAR:
	    					value = "'" + value + "'";*/
	    					break;
	    				case java.sql.Types.DATE:
	    					String date = rs.getString(i);
	    					value = com.trendin.core.util.DateUtil.reformatDate(date, "yyyy-MM-dd HH:mm:ss");
	    					break;
	    				case java.sql.Types.TIMESTAMP:
	    					String ts = rs.getString(i);
	    					value = com.trendin.core.util.DateUtil.reformatDate(ts, "yyyy-MM-dd HH:mm:ss");
	    					break;
	    				case java.sql.Types.CLOB:
	    					java.sql.Clob clob = rs.getClob(i);
	    					
    						StringBuilder sb = new StringBuilder((int) clob.length());
    						Reader r = clob.getCharacterStream();
    						char[] buf = new char[2048];
    						int n;
    						while ((n = r.read(buf, 0, buf.length)) != -1) {
    							sb.append(buf, 0, n);
    						}
    						value =  new String(sb);
	    					
	    					break;
	    				/*case java.sql.Types.NUMERIC:
	    				case java.sql.Types.DECIMAL:
	    				case java.sql.Types.BIT:
	    				case java.sql.Types.TINYINT:
	    				case java.sql.Types.SMALLINT:
	    				case java.sql.Types.INTEGER:
	    				case java.sql.Types.BIGINT:
	    				case java.sql.Types.REAL:
	    				case java.sql.Types.FLOAT:
	    				case java.sql.Types.DOUBLE:*/
	    				}
    				} 
    				else {
    					value = "null";
    				}
    				row[i-1] = value;
    			}
    			rows.add(row);
    		}
    		writer.writeAll(rows);
    		writer.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;    	
    }
    
    /**
     * Copies a file to another location.
     * 
     * @param sourcePath The file to copy.
     * @param destPath The destination. Can be either a directory, or a new file name.
     * @throws IOException
     */
    public static void copyFile(String sourcePath, String destPath) throws IOException
    {
    	File sourceFile = new File(sourcePath).getAbsoluteFile();    
    	File destFile = new File(destPath).getAbsoluteFile();
    	// Check if destination folder exists
    	if(!destFile.getParentFile().exists())
    	{
    		destFile.getParentFile().mkdirs();    		
    	}
    	// Check if destination is a directory
    	if(getFilePathNoExt(destPath).equals(destPath))
		{
			destFile.mkdir();
			destFile = new File(destFile.getAbsolutePath() + "/" + sourceFile.getName());
		}
	
		// Copy the file
		if(!sourceFile.isFile())
			throw new IOException("Source is not a file.");
		
		Files.copy(sourceFile, destFile);
    }
        
    
    // Move/Rename file from one directory to another
    public static void AppendFileName(String oldPath, String newPath) throws SQLException, IOException{

    	    	
    	File file = new File(oldPath);
		       
		String fileName = file.getName();        
		String ext = FilenameUtils.getExtension(fileName);
		
		// checking if ext is null
		if(ext.isEmpty())
			//if ext is null throw expt
			throw new IOException (fileName + " (Please add file with extention)");
			
			
        String fileNameWithOutExt = FilenameUtils.removeExtension(fileName);
		File newFile = new File(newPath+ "\\/" + fileNameWithOutExt+"."+ext);

		
		if(file.renameTo(newFile)){
    		System.out.println("File is moved successful!");
    	   }else{
    		System.out.println("File is failed to move!");
    	   }
    }
   
	
	/**
	 * Converts a string representation of a number to an integer.
	 * @param toInt The String representing the integer. Accepts valid double notation,
	 * such as "123", "1.23", and "-8.56e3". Numbers with decimals are rounded
	 * to the nearest value.
	 * @return integer value of toInt. If the value cannot be converted to an integer,
	 * 0 is returned instead. If the value would be greater than 2147483647 or less 
	 * than -2147483648, those values are returned instead.
	 * is returned instead.
	 */
	public static int getSafeInt(String toInt)
	{
		if(toInt == null || toInt.equals(""))
		{
			return 0;
		}
		else
		{
			try {
				// Parse to double, then cast to int
				// (Excel returns all numbers as floats)
				double d = Double.parseDouble(toInt);
				return (int) Math.round(d);
			} catch(NumberFormatException e)
			{
				return 0;
			}
		}
	}
	
	
	// Moved from MGTConsole
	/**
	 * <p>
	 * <b>Method Name:</b> ReadFromExcelSheet
	 * </p>
	 * <p>
	 * <b>Description:</b>This Method reads the value stored in specified column name. 
	 * </p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>FileName:</b>(Required) The name of the file to which the value has to be stored.</li>
	 * <li><b>FilePath:</b>(Required) The absolute path of the file provided in the 'FileName' argument.</li>
	 * <li><b>ColumnName:</b>(Required) The name of the column from which the value has to be retrevied which is previously stored using the method WriteDataToExcelFile.</li>
	 * <li>
	 * </ul>
	 * </p>
	 **/

	public static String readFromExcelSheet(String filePath, String fileName, String columnName) throws POMMethodExecException {
		String configPath = "", expRowValues = "";
		String allRowValues = "";
		String fileVar = "", fileSend = "";
		// To get canonical path..
		try {
			configPath = StringUtils.stripEnd(filePath, "/\\");
			configPath = (new File(filePath)).getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException("Error in config path assigning. ", e1);
		}
		fileVar = configPath + "\\";
		fileSend = fileVar + fileName;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(fileSend));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException("File not found with the given path: " + fileSend);
		}
		// Create Workbook instance holding reference to .xlsx file
		org.apache.poi.ss.usermodel.Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException(": " + fileSend);
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException("Not able to Create the file in the given path. : " + fileSend);
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
				if(saveValue){
					allRowValues = allRowValues + expRowValues.trim() + ";";
				}
				
			}
		} catch(Exception e){
			// no exception 
		}
		String moreValuesString [] = allRowValues.split(";");
		System.out.println("Length of the String: "+ moreValuesString.length);
		if(moreValuesString.length <= 1){
			allRowValues = moreValuesString[0];
		}
		return allRowValues;
	}
	 // MOved from MGTConsole
	/**
	 * <p>
	 * <b>Method Name:</b> WriteDataToExcelFile
	 * </p>
	 * <p>
	 * <b>Description:</b>This Method writes the value to a particular column in Excel sheet.
	 * </p>
	 * <b>Arguments:</b>
	 * <ul>
	 * <li><b>FileName:</b>(Required) The name of the file to which the value has to be stored.</li>
	 * <li><b>FilePath:</b>(Required) The absolute path of the file provided in the 'FileName' argument.</li>
	 * <li><b>ColumnName:</b>(Required) The name of the column to which the value has to be stored.</li>
	 * <li><b>ColumnValue:</b>(Required) The value to be stored under ColumnName argument.</li>
	 * <li>
	 * </ul>
	 * </p>
	 * 
	 * @author  Hemanth
	 *
	 */

	public static void WriteDataToExcelFile(String filePath,String fileName,String columnName,String columnValue, String overWriteSheetValues) throws POMMethodExecException {
		int columnCountOfValues = 0;
		String configPath = "";
		String fileVar = "", fileSend = "";
		// To get canonical path..
		try {
			configPath = StringUtils.stripEnd(filePath, "/\\");
			configPath = (new File(filePath)).getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException("Error in config path assigning. ", e1);
		}
		fileVar = configPath + "\\";
		fileSend = fileVar + fileName;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File(fileSend));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException("File not found with the given path: " + fileSend);
		}
		// Create Workbook instance holding reference to .xlsx file
		org.apache.poi.ss.usermodel.Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException(": " + fileSend);
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new POMMethodExecException("Not able to Create the file in the given path. : " + fileSend);
		}

		// First write the column names 
		int gRowCount = 0;
		int colCount = 0;
		String colNames [] = columnName.split(";");
		String colValues [] = columnValue.split(";");
		Sheet sheet = workbook.getSheetAt(0);
		if(overWriteSheetValues.equalsIgnoreCase("False") || overWriteSheetValues.equalsIgnoreCase("No")) {
			try {
				columnCountOfValues = sheet.getRow(gRowCount).getLastCellNum();
			} catch(NullPointerException e) {
				System.out.println("Exception : " + e);
			}
		}
		Row r;
		if(columnCountOfValues <= 0) {
			r = sheet.createRow(gRowCount);
		} else {
			r = sheet.getRow(gRowCount);
		}

		// here get the count of the cell untill its NULL (if any previous values is present then it should add at the end)

		colCount = columnCountOfValues;
		for(int i=0; i<colNames.length; i++) {
			Cell cell =  r.createCell(colCount);
			cell.setCellValue(colNames[i]);
			colCount++;
			/*try {
				FileOutputStream out = new FileOutputStream(new File(fileSend));
				workbook.write(out);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		}
		// Now write the Values of the column (respectively)
		gRowCount++;
		colCount = columnCountOfValues;
		if(columnCountOfValues <= 0){
			r = sheet.createRow(gRowCount);
		} else {
			r = sheet.getRow(gRowCount);
		}
		for(int i=0; i<colValues.length; i++) {
			Cell cell = r.createCell(colCount);
			cell.setCellValue(colValues[i]);
			colCount++;
		}

		try {
			FileOutputStream out = new FileOutputStream(new File(fileSend));
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	    
	
}
