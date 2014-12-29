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
 	List<Object[]> list = new ArrayList<Object[]>();//Object[] произвольный массив объектов - двумерный. будет потом передаваться, как набор
 	//параметров (могут иметь произвольные типы). В нашем случае - список наборов из одного элемента
 	//iterator должен сгенерировать список наборов из произвольных объектов в количестве, необходимом тестовому методу
 	for (int i = 0;i<5;i++) {
 		GroupData group = new GroupData();
 		group.name = generateRandomString();
 		group.header= generateRandomString();
 		group.footer= generateRandomString();	 
 		list.add(new Object[]{group});
 	}
 	return list.iterator();
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
}

