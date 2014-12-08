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
	contact.firstname ="Inna";
	contact.lastname= "Domanchuk";
	contact.address="address";
	contact.telHome="tel home";
	contact.telMobile="tel mob";
	contact.telWork="tel work";
	contact.email1="jineta@ukr.net";
	contact.email2="jineta2@ukr.net";
	contact.birthDay="30";
	contact.birthMonth="May";
	contact.birthYear="1985";
	contact.relatedGroup = "group111";
	contact.adressSecondary="address secondary";
	contact.telSecondary="home";
	
	fillContactForm(contact);
    submitContactCreation();
    returnToMainPageFromContact();
  }
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();

	initContactCreation();
	ContactData contact = new ContactData();
	contact.firstname ="";
	contact.lastname= "";
	contact.address="";
	contact.telHome="";
	contact.telMobile="";
	contact.telWork="";
	contact.email1="";
	contact.email2="";
	contact.birthDay="-";
	contact.birthMonth="-";
	contact.birthYear="";
	contact.relatedGroup = "";
	contact.adressSecondary="";
	contact.telSecondary="";
	
	fillContactForm(contact);
    submitContactCreation();
    returnToMainPageFromContact();
  }
}
