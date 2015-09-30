package com.trendin.core.util.exceptions;

public class POMWarningException extends POMMethodExecException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522933439652259656L;

	public POMWarningException(String message) {
		super(message);
	}
	
	public POMWarningException(String message, Throwable cause)
	{
		super(message, cause);
	}


	@Override
	public POMWarningException noEscape()
	{
		return (POMWarningException) super.noEscape();
	}
}
