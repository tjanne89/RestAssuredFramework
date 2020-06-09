package com.uitilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilis
{

	public static String empname()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(1);
		return ("HANNAH"+generatedstring);
		
	}
	
	public static String empsalary()
	{
		String generatedstring=RandomStringUtils.randomNumeric(5);
		return (generatedstring);
		
	}
	
	public static String empage()
	{
		String generatedstring=RandomStringUtils.randomNumeric(5);
		return (generatedstring);
		
	}
}
