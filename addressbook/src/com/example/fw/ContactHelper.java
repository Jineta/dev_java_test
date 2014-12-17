package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager pManager) {
		super(pManager);		
	}

	public void initContactCreation() {
		click(By.name("add new"));
	}
	
	public void fillContactForm(ContactData contact) {
	    type(By.name("firstname"), contact.firstname);
	    type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.telHome);
	    type(By.name("mobile"), contact.telMobile);
	    type(By.name("work"), contact.telWork);
	    type(By.name("email"), contact.email1);
	    type(By.name("emai2"), contact.email2);	    
	    
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);    
	   
	    selectByText(By.name("new_group"), contact.relatedGroup);

	    type(By.name("address2"), contact.adressSecondary);
	    type(By.name("phone2"), contact.telSecondary);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

}