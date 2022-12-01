package com.rmgyantra.GenericLibrary;

import java.util.Random;

public  class JavaUtility {

	public static int getRandomNumber()
	{
		Random r=new Random();
		int ran=r.nextInt(2000);
		return ran;
	
}
	
}
