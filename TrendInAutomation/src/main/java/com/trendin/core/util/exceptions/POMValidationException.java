package com.trendin.core.util.exceptions;

public class POMValidationException extends POMMethodExecException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public POMValidationException(String message) {
		super(message);
	}
	
	public POMValidationException(String message, Throwable e) {
		super(message, e);
	}

	@Override
	public POMValidationException noEscape()
	{
		return (POMValidationException) super.noEscape();
	}
}
