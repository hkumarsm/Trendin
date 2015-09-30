package com.trendin.tests;

import org.testng.annotations.Test;

import com.trendin.core.TrendInTestSuite;
import com.trendin.pages.Validation;

public class TestValidation extends TrendInTestSuite {
	@Test
	public void testValidationMobileNumber() throws Exception {
		Validation validation = new Validation();
		validation.ValidateMobileNumberField(driver);
	}
	
	
}
