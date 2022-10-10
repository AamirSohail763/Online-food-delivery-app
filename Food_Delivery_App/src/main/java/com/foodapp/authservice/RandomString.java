package com.foodapp.authservice;

import java.util.Random;

public class RandomString {
	
	public static String getRandomString() {
	   
	    Random rn = new Random();
	    int number = rn.nextInt(999999);

	    return String.format("%06d", number);
	}

}
