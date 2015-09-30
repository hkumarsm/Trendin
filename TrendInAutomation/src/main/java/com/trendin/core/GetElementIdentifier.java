package com.trendin.core;

import java.io.InputStream;
import java.util.Properties;

import com.trendin.core.util.exceptions.POMMethodExecException;

public abstract class GetElementIdentifier {
	 
		public static String getProperty(String propertyName,String application) throws POMMethodExecException{
			Properties property = new Properties();
			InputStream input = null;
			String propertyValue = null ;
			application = application.toLowerCase();
			try {
				input = GetElementIdentifier.class.getResourceAsStream("/com/trendin/pages/"+application+".properties");
				property.load(input);
				propertyValue = property.getProperty(propertyName);
			} catch (Exception e) {
				throw new POMMethodExecException("The Property of the element "+ propertyName +" is not present for the Application "+application+".", e) ;
			}
			return propertyValue;
		}
}
