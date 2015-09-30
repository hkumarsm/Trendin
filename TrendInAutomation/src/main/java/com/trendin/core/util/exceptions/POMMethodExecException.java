package com.trendin.core.util.exceptions;

/**
 * Keyword execution exception. 
 * @author Matthew Swircenski
 *
 */
public class POMMethodExecException extends POMException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7222674187043337611L;
	
	public POMMethodExecException(String message) {
		super(message);
	}
	
	public POMMethodExecException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	@Override
	public POMMethodExecException noEscape()
	{
		return (POMMethodExecException) super.noEscape();
	}
}
