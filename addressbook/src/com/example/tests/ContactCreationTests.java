package com.example.tests;

import org.testng.annotations.Test;
import java.util.regex.Pattern;
import com.example.fw.ApplicationManager;


public class ContactCreationTests  extends BaseForTests {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();

	app.getContactHelper().initContactCreation();
	
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
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToMainPageFromContact();
  }
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();
	ContactData contact = new ContactData();
	contact.setFirstname("");
	contact.setLastname("");
	contact.setAddress("");
	contact.setTelHome("");
	contact.setTelMobile("");
	contact.setTelWork("");
	contact.setEmail1("");
	contact.setEmail2("");
	contact.setBirthDay("-");
	contact.setBirthMonth("-");
	contact.setBirthYear("");
	contact.setRelatedGroup("");
	contact.setAdressSecondary("");
	contact.setTelSecondary("");
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToMainPageFromContact();
  }
}
