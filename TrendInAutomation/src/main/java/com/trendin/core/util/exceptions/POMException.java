package com.trendin.core.util.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * General exception class for KDT.
 * @author Matthew Swircenski
 *
 */
public class POMException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4989192725855339934L;
	
	public boolean escapeHtml = true;

	public POMException(String message)
	{
		super(message);
	}
	
	public POMException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public POMException()
	{
		super();
	}
	
	public String stringify()
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		this.printStackTrace(pw);
		if(escapeHtml)
		{
			return StringEscapeUtils.escapeHtml4(sw.toString());
		}
		else
		{
			return sw.toString();
		}
		
	}
	
	public POMException noEscape()
	{
		this.escapeHtml = false;
		return this;
	}
}
