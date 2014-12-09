package com.example.tests;

import org.testng.annotations.Test;
import java.util.regex.Pattern;

import org.testng.annotations.Test;


public class ContactCreationTests  extends BaseForTests {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();

	initContactCreation();
	ContactData contact = new ContactData();
	contact.setFirstname("Inna");
	contact.setLastname("Domanchuk");
	contact.setAddress("address");
	contact.setTelHome("tel home");
	contact.setTelMobile("tel mob");
	contact.setTelWork("tel work");
	contact.setEmail1("jineta@ukr.net");
	contact.setEmail2("jineta2@ukr.net");
	contact.setBirthDay("30");
	contact.setBirthMonth("May");
	contact.setBirthYear("1985");
	contact.setRelatedGroup("group111");
	contact.setAdressSecondary("address secondary");
	contact.setTelSecondary("home");
	
	fillContactForm(contact);
    submitContactCreation();
    returnToMainPageFromContact();
  }
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
	initContactCreation();
	ContactData contact = new ContactData();	
	fillContactForm(contact);
    submitContactCreation();
    returnToMainPageFromContact();
  }
}
