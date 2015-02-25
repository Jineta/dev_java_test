package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.testng.annotations.Test;

public class PrintPhoneCompareTests extends BaseForTests{
	
	@Test
	public void comparePrintphonesWithDb() { 
		 
		//get lists 
		List<ContactData> dbContactList = app.getHibernateHelper().listContactsSortedByQuery();
//							System.out.println("!!!!dbContactList!!!!");
//							System.out.println(dbContactList);
	 
		List<String> printList = app.getPrintPhoneHelper().getUiPrintPhones();			
//						 	System.out.println("!!!!printList!!!!");
//							System.out.println(printList);
	 	// actions
	 	if (dbContactList.size()==printList.size()) {		
	 		for (int i = 0; i < dbContactList.size(); i++) { 
	 			System.out.println("\n"+i+": printList");
				System.out.println(printList.get(i));
	 			assertThat(0,equalTo(app.getPrintPhoneHelper().getDbContactString(dbContactList.get(i)).compareTo(printList.get(i))));	
	 		} 		
	 	}
	}
}

