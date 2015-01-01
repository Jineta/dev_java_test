package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends BaseForTests {

	@Test
public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();	
		app.getContactHelper().initEditContact(1);
		
		ContactData contact = new ContactData();
		contact.setFirstname("Inna_Inna");
		contact.setLastname("Domanchuk_Domanchuk");
		app.getContactHelper().fillContactForm(contact);
		
		app.getContactHelper().submitContactModification();
		app.getNavigationHelper().returnToMainPageFromContact();
	}
}

