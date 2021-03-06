package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.AccountHelper;
import com.example.fw.ApplicationManager;
import com.example.fw.JamesHelper;

public class BaseForTests {
	
 protected static ApplicationManager app;	
 private int checkFrequency;
 private int checkCounter;
 public JamesHelper james;
 public AccountHelper accHelper;

 @BeforeTest
 public void setUp() throws Exception {
	 String configFile = System.getProperty("configFile","application.properties"); // required by user, default
	 Properties properties =  new Properties();
	 properties.load(new FileReader(new File(configFile)));
	 app = new ApplicationManager(properties);	 
	 checkCounter = 0;
	 checkFrequency = Integer.parseInt(properties.getProperty("check.frequency","0"));
	 james = app.getJamesHelper();
	 accHelper = app.getAccountHelper();
	 }
 
 protected boolean wantToCheck(){
	 checkCounter++;
	 if (checkCounter > checkFrequency)
	 {checkCounter = 0;
	 	return true;
	 }else{
		return false;
	 }
 }
 
 @AfterTest
 public void tearDown() throws Exception {
	    app.stop();		
	  }

}
 

