package com.trendin.core.util.exceptions;

/**
 * Keyword initialization exception.
 * @author Matthew Swircenski
 *
 */
public class POMMethodInitException extends POMException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -834448688136235218L;

	public POMMethodInitException(String message) {
		super(message);
	}
	
	public POMMethodInitException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	@Override
	public POMMethodInitException noEscape()
	{
		return (POMMethodInitException) super.noEscape();
	}
}
