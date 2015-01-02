package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager pManager) {
		super(pManager);		
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}
	
	public void fillContactForm(ContactData contact) {
	    type(By.name("firstname"), contact.firstname);
	    type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.telHome);
	    type(By.name("mobile"), contact.telMobile);
	    type(By.name("work"), contact.telWork);
	    type(By.name("email"), contact.email1);
	    type(By.name("email2"), contact.email2);	    
	    
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);    
	   
	    //selectByText(By.name("new_group"), contact.relatedGroup);

	    type(By.name("address2"), contact.adressSecondary);
	    type(By.name("phone2"), contact.telSecondary);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initEditContact(int index) {
		if (index == 1) {
			index++;}
		click(By.xpath("//tr["+ (index+1) +"]/td[7]/a/img"));
	}
	
    public void submitContactModification() {
		click(By.xpath("//form[1]/input[11]"));
	}
		
	public void submitContactRemoval() {
		click(By.xpath("//form[2]/input[2]"));			
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();//implementation of List type
		List<WebElement> lines = driver.findElements(By.xpath("//table/tbody/tr[position()>1 and position()!=last()]"));// method findElements returns all elements which correspond selected locator
		for (WebElement line : lines) {
			ContactData contact = new ContactData();
			contact.firstname= line.findElement(By.xpath(".//td[3]")).getText();
			contact.lastname= line.findElement(By.xpath(".//td[2]")).getText();
			contact.email1=line.findElement(By.xpath(".//td[4]")).getText();
			contact.telHome=line.findElement(By.xpath(".//td[5]")).getText();
			
			contacts.add(contact);

     	}		
		return contacts;
	}

}