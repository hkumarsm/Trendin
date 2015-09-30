package com.trendin.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.trendin.core.util.datadriver.DataDriver;
import com.trendin.core.util.datadriver.DataDriverFactory;
import com.trendin.core.util.datadriver.DataRow;

public class TestParams {
	
	private HashMap<String, HashMap<String, LinkedList<HashMap<String, String>>>> allParams;
	public static final String TC_HEAD = "Test Case";
	
	@SuppressWarnings("unchecked")
	public Object[][] getParamList(String operation, String test)
	{
		Map<String, String>[][] paramsArray;
		try {
			System.out.println("Loading " + operation + "." + test);
			LinkedList<HashMap<String, String>> testParams = allParams.get(operation).get(test);
			paramsArray = new Map[testParams.size()][1];
			for(int i = 0; i < testParams.size(); i++)
			{
				paramsArray[i][0] = testParams.get(i);
			}
		} catch (NullPointerException e)
		{
			paramsArray = new Map[0][1];
		}
		return paramsArray;
	}
	
	public TestParams(File f) throws FileNotFoundException 
	{

		allParams = new HashMap<String, HashMap<String, LinkedList<HashMap<String, String>>>>();
		
		// Check if file exists
		if(!f.exists())
		{
			// Try .xls instead
			String filePath = f.getAbsolutePath().substring(0, f.getAbsolutePath().length() - 1);
			f = new File(filePath);
			if(!f.exists())
			{
				// No file found
				throw new FileNotFoundException(filePath);
			}
		}
		
		// Create Data driver
		String absPath = f.getAbsolutePath();
		DataDriver dd = DataDriverFactory.create(absPath, true, null);
		String sheet;
		do {
			 sheet = dd.getSheetName();
			 HashMap<String, LinkedList<HashMap<String, String>>> testList = new HashMap<String, LinkedList<HashMap<String, String>>>();
			 DataRow dr;
			 while(dd.hasNext())
			 {
				 dr = dd.nextRow();
				 String method = dr.getItem(TC_HEAD);
				 
				 LinkedList<HashMap<String, String>> param;
				 if(testList.containsKey(method))
				 {
					 param = testList.get(method);
					 
				 }
				 else
				 {
					 param = new LinkedList<HashMap<String, String>>();
					 testList.put(method, param);
					 
				 }
				 
				 HashMap<String, String> paramSet = new HashMap<String, String>();
				 
				 for(String head : dr.getHeaders())
				 {
					 paramSet.put(head, dr.getItem(head));
				 }
				 
				 param.add(paramSet);				 
			 }
			 
			 allParams.put(sheet, testList);
			 
		} while(dd.nextSheet());
				
	}
	
	public TestParams(String service) throws FileNotFoundException
	{
		System.out.println(System.getProperty("user.dir"));
		// Path to test file
		String filePath = System.getProperty("user.dir") + "\\resources\\" + service + ".xlsx";
		
		// Check if it exists
		File f = new File(filePath);
		if(!f.exists())
		{
			// Try .xls instead
			filePath = filePath.substring(0, filePath.length() - 1);
			f = new File(filePath);
			if(!f.exists())
			{
				// No file found
				throw new FileNotFoundException(filePath);
			}
		}
		
		allParams = new HashMap<String, HashMap<String, LinkedList<HashMap<String, String>>>>();
		
		// Create Data driver
		DataDriver dd = DataDriverFactory.create(filePath, true, null);
		String sheet;
		do {
			 sheet = dd.getSheetName();
			 HashMap<String, LinkedList<HashMap<String, String>>> testList = new HashMap<String, LinkedList<HashMap<String, String>>>();
			 DataRow dr;
			 while(dd.hasNext())
			 {
				 dr = dd.nextRow();
				 String method = dr.getItem(TC_HEAD);
				 
				 LinkedList<HashMap<String, String>> param;
				 if(testList.containsKey(method))
				 {
					 param = testList.get(method);
					 
				 }
				 else
				 {
					 param = new LinkedList<HashMap<String, String>>();
					 testList.put(method, param);
					 
				 }
				 
				 HashMap<String, String> paramSet = new HashMap<String, String>();
				 
				 for(String head : dr.getHeaders())
				 {
					 paramSet.put(head, dr.getItem(head));
				 }
				 
				 param.add(paramSet);				 
			 }
			 
			 allParams.put(sheet, testList);
			 
		} while(dd.nextSheet());
				
	}


}
