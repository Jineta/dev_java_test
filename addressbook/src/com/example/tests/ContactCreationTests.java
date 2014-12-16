package com.example.tests;

import org.testng.annotations.Test;
import java.util.regex.Pattern;
import com.example.fw.ApplicationManager;


public class ContactCreationTests  extends BaseForTests {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.navigationHelper.openMainPage();

	app.contactHelper.initContactCreation();
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
	
	app.contactHelper.fillContactForm(contact);
    app.contactHelper.submitContactCreation();
    app.navigationHelper.returnToMainPageFromContact();
  }
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.navigationHelper.openMainPage();
	app.contactHelper.initContactCreation();
	ContactData contact = new ContactData();	
	app.contactHelper.fillContactForm(contact);
    app.contactHelper.submitContactCreation();
    app.navigationHelper.returnToMainPageFromContact();
  }
}
