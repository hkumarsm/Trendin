package com.trendin.core.util.exceptions;

/**
 * Exception occurred during parsing of an input file.
 * @author Matthew Swircenski
 *
 */
public class POMParseException extends POMException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1453644504566705086L;

	public POMParseException(String message) {
		super(message);
	}
	
	public POMParseException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	@Override
	public POMParseException noEscape()
	{
		return (POMParseException) super.noEscape();
	}

}
