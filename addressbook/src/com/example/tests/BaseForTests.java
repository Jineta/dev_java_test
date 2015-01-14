package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
public class BaseForTests {
	
 protected ApplicationManager app;	

 @BeforeTest
 public void setUp() throws Exception {
	 String configFile = System.getProperty("configFile","application.properties"); // required by user, default
	 Properties properties =  new Properties();
	 properties.load(new FileReader(new File(configFile)));
	 app = new ApplicationManager(properties);
	 }
 
 @AfterTest
 public void tearDown() throws Exception {
	    app.stop();		
	  }
	
 @DataProvider
 public Iterator<Object[]> randomValidGroupGenerator(){ 
	return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
}

public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
 	List<Object[]> list = new ArrayList<Object[]>();//Object[] ������������ ������ �������� - ���������. ����� ����� ������������, ��� �����
 	//���������� (����� ����� ������������ ����). � ����� ������ - ������ ������� �� ������ ��������
 	//iterator ������ ������������� ������ ������� �� ������������ �������� � ����������, ����������� ��������� ������
 	
 	for (GroupData group: groups) {
		list.add(new Object[]{group});
 	}
	return list;
}

@DataProvider
 public Iterator<Object[]> randomValidContactGenerator(){ 
 	List<Object[]> list = new ArrayList<Object[]>();//Object[] ������������ ������ �������� - ���������. ����� ����� ������������, ��� �����
 	//���������� (����� ����� ������������ ����). � ����� ������ - ������ ������� �� ������ ��������
 	//iterator ������ ������������� ������ ������� �� ������������ �������� � ����������, ����������� ��������� ������	
 	for (int i = 0;i<3;i++) {
 		ContactData contact = new ContactData()
 			.withFirstName(generateRandomString())
 			.withLastName(generateRandomString())
 			.withAddress(generateRandomString())
 			.withTelHome(generateRandomString())
 			.withTelMobile(generateRandomString())
 			.withTelWork(generateRandomString())
 			.withEmail1(generateRandomString())
 			.withEmail2(generateRandomString())
 			.withBirthDay(generateRandomDay())
 			.withBirthMonth(generateRandomMonth())
 			.withBirthYear(generateValidBYear())
 		 	.withAddressSecondary(generateRandomString())
 			.withTelSecondary(generateRandomString()); 		
 		//contact.relatedGroup = selectRandomGroup();
 		list.add(new Object[]{contact});   
 	}	
 	return list.iterator();
 }
//remove this methods after editing contacts
 public String generateRandomString(){
		Random rnd = new Random();		
		if(rnd.nextInt(4)==0){
			return "";	
		} else{
			 return "text"+rnd.nextInt();
			}
		}
 
 public String generateRandomMonth(){
	 String[] month = {"-","January","February","March","April","May","June","July","August","September","October","November","December"};
	 Random rnd = new Random();		
	 int index = rnd.nextInt(13);	
     return month[index];
 }
 
 public String generateRandomDay(){
	 Random rnd = new Random();		
	 int day = rnd.nextInt(32);	
     if (day ==0) {
     return "-";
     } else {
     return Integer.toString(day);
     }
 }
 public String generateValidBYear(){
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
}