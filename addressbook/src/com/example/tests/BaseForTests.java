package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


public class BaseForTests {
	
 protected ApplicationManager app;	

 @BeforeTest
 public void setUp() throws Exception {
	    app = new ApplicationManager();
	  }
 
 @AfterTest
 public void tearDown() throws Exception {
	    app.stop();		
	  }
	
 @DataProvider
 public Iterator<Object[]> randomValidGroupGenerator(){ 
 	List<Object[]> list = new ArrayList<Object[]>();//Object[] ������������ ������ �������� - ���������. ����� ����� ������������, ��� �����
 	//���������� (����� ����� ������������ ����). � ����� ������ - ������ ������� �� ������ ��������
 	//iterator ������ ������������� ������ ������� �� ������������ �������� � ����������, ����������� ��������� ������
 	for (int i = 0;i<5;i++) {
 		GroupData group = new GroupData()
 			.withName(generateRandomString())
 			.withHeader(generateRandomString())
 			.withFooter(generateRandomString());
 		list.add(new Object[]{group});
 	}
 	return list.iterator();
	
}

@DataProvider
 public Iterator<Object[]> randomValidContactGenerator(){ 
 	List<Object[]> list1 = new ArrayList<Object[]>();//Object[] ������������ ������ �������� - ���������. ����� ����� ������������, ��� �����
 	//���������� (����� ����� ������������ ����). � ����� ������ - ������ ������� �� ������ ��������
 	//iterator ������ ������������� ������ ������� �� ������������ �������� � ����������, ����������� ��������� ������
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();
 	
 	for (int i = 0;i<3;i++) {
 		ContactData contact = new ContactData();
 		contact.firstname = generateRandomString();
 		contact.lastname= generateRandomString();
 		contact.address = generateRandomString();
 		contact.telHome= generateRandomString();
 		contact.telMobile= generateRandomString();
 		contact.telWork= generateRandomString();
 		contact.email1 = generateRandomString();
 		contact.email2= generateRandomString();
 		contact.birthDay= selectValidBDay();
 		contact.birthMonth= selectValidBMonth();
 		contact.birthYear= generateValidBYear();
 		//contact.relatedGroup = selectRandomGroup();
 		contact.adressSecondary= generateRandomString();
 		contact.telSecondary= generateRandomString();
 		list1.add(new Object[]{contact});   
 	}
 	
 	return list1.iterator();
 }

 


/*public String generateRandomString(){
	Random rnd = new Random();	
	int r = rnd.nextInt(4); 	
	if(r==0){
		return "";	
	}else if(r==1){
	   return null;
     }   else{
		 return "text"+rnd.nextInt();
		}
	}
*/	
 public String generateRandomString(){
		Random rnd = new Random();		
		if(rnd.nextInt(4)==0){
			return "";	
		} else{
			 return "text"+rnd.nextInt();
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

 public String selectValidBMonth(){
	 Random rnd = new Random();
	 int r=rnd.nextInt(app.getContactHelper().getMonths().length-1);
	 return app.getContactHelper().getMonths()[r];	
	}
 
 public String selectValidBDay(){
	 Random rnd = new Random();
	 int r=rnd.nextInt(app.getContactHelper().getDays().length-1);
	 return app.getContactHelper().getDays()[r];	

	} 
}

