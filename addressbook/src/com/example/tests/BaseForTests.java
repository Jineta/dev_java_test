package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXMLFile;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class BaseForTests {
	
 protected static ApplicationManager app;	/*we need static app in order to run several classes in one test in testsuite "�����, �� ������ ������� � ��� ������� ��������� ������, ������� ��� ������ ��� ���������� ������� �����
 ��� ������� ��������� ������ �������� ����� ������ (������� ������) -- � � ��� ������ �� ApplicationManager ��� ����� �� ����������������"*/
 private int checkFrequency;
 private int checkCounter;
 
 @BeforeTest
 public void setUp() throws Exception {
	 String configFile = System.getProperty("configFile","application.properties"); // required by user, default
	 Properties properties =  new Properties();
	 properties.load(new FileReader(new File(configFile)));
	 app = new ApplicationManager(properties);	 
	 checkCounter = 0;
	 checkFrequency = Integer.parseInt(properties.getProperty("check.frequency","0"));
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

@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {	 		
	 	return wrapGroupsForDataProvider(loadGroupsFromXMLFile(new File("groups.xml"))).iterator();
	}

@DataProvider
 public Iterator<Object[]> randomValidGroupGenerator(){ 
	return wrapGroupsForDataProvider(generateRandomGroups(1)).iterator();
}
	
@DataProvider
 public Iterator<Object[]> randomValidContactGenerator(){ 
	return wrapContactsForDataProvider(generateRandomContacts(1)).iterator();
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

public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
 	List<Object[]> list = new ArrayList<Object[]>();
 	for (ContactData contact: contacts) {
		list.add(new Object[]{contact});
 	}
	return list;
}

}
 

