package com.example.tests;

import java.util.Random;

public class GeneratorHelper {
	
	 public static String generateRandomString(){
			Random rnd = new Random();		
			if(rnd.nextInt(4)==0){
				return "";	
			} else{
				 return "text"+rnd.nextInt();
				}
			}
	 
	 public static String generateRandomDay(){
		 Random rnd = new Random();		
		 int day = rnd.nextInt(32);	
	     if (day ==0) {
	     return "-";
	     } else {
	     return Integer.toString(day);
	     }
	 }
	 
	 public static String generateValidBYear(){
			Random rnd = new Random();		
			String year = "19";
			int r = rnd.nextInt(9);
			if(r<4){
				r=r+4;
				return year+r+rnd.nextInt(9);	
			} else{			
				return year+r+rnd.nextInt(9);
				}
			}
	 
	 public static String generateRandomMonth(){
		 String[] month = {"-","January","February","March","April","May","June","July","August","September","October","November","December"};
		 Random rnd = new Random();		
		 int index = rnd.nextInt(13);	
	     return month[index];
}
}