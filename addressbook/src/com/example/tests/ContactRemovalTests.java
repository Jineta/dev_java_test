package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends BaseForTests {

	@Test
public void deleteSomeGroup(){
		app.getNavigationHelper().openMainPage();	
		//app.getContactHelper().editContact(1);
		//app.getContactHelper().deleteContact(1);
		app.getNavigationHelper().returnToMainPageFromContact();
	}
}

