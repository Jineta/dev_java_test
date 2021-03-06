package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
    public static boolean CREATION = true;
    public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager pManager) {
		super(pManager);		
	}
	
//	private SortedListOf<ContactData> cachedContacts;
//	public SortedListOf<ContactData> getContacts() {
//		if (cachedContacts==null){
//			rebuildCache();
//			}
//		return new SortedListOf<ContactData>(cachedContacts);
//		//return cachedContacts;
//		}
//		
//		private void rebuildCache() {
//		cachedContacts = new SortedListOf<ContactData>();
//		
//		manager.navigateTo().mainPage();
//		List<WebElement> lines = driver.findElements(By.xpath("//table/tbody/tr[position()>1 and position()!=last()]"));// method findElements returns all elements which correspond selected locator
//		for (WebElement line : lines) {		
//			String firstname= line.findElement(By.xpath(".//td[3]")).getText();
//			String lastname= line.findElement(By.xpath(".//td[2]")).getText();
//			String email1=line.findElement(By.xpath(".//td[4]")).getText();
//			String telHome=line.findElement(By.xpath(".//td[5]")).getText();
//			
//			cachedContacts.add(new ContactData()
//					.withFirstName(firstname)
//					.withLastName(lastname)
//					.withEmail1(email1)
//					.withTelHome(telHome));
//     	}		
//	}
	public SortedListOf<ContactData> getUiContacts() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();//implementation of List type
		manager.navigateTo().mainPage();
		List<WebElement> lines = driver.findElements(By.xpath("//table/tbody/tr[position()>1 and position()!=last()]"));// method findElements returns all elements which correspond selected locator
		for (WebElement line : lines) {		
			String firstname= line.findElement(By.xpath(".//td[3]")).getText();
			String lastname= line.findElement(By.xpath(".//td[2]")).getText();
			String email1=line.findElement(By.xpath(".//td[4]")).getText();
			String telHome=line.findElement(By.xpath(".//td[5]")).getText();
			
			contacts.add(new ContactData()
					.withFirstName(firstname)
					.withLastName(lastname)
					.withEmail1(email1)
					.withTelHome(telHome));
     	}
		return contacts;
	}
		
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
	    initContactCreation();
	    fillContactForm(contact,CREATION);
	    submitContactCreation();
	    manager.navigateTo().returnToMainPageFromContact();	
	    	//rebuildCache();
	    //update model
	  	manager.getModel().addContact(contact);
	    return this;
	}
	
	public ContactHelper modifyContact(ContactData contact,int index ) {
		manager.navigateTo().mainPage();
		initEditContact(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		manager.navigateTo().returnToMainPageFromContact();
			//rebuildCache();
		//update model
	  	manager.getModel().removeContact(index).addContact(contact);
		return this;
	}	
		
	public ContactHelper removeContact(int index) {
	    initEditContact(index);	
		submitContactRemoval();	
		manager.navigateTo().returnToMainPageFromContact();
			//rebuildCache();
		//update model
	  	manager.getModel().removeContact(index);
		return this;
	}
//---------------------------------------------------------------------------------------------------------	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
	    type(By.name("firstname"), contact.getFirstname());
	    type(By.name("lastname"), contact.getLastname());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getTelHome());
	    type(By.name("mobile"), contact.getTelMobile());
	    type(By.name("work"), contact.getTelWork());
	    type(By.name("email"), contact.getEmail1());
	    type(By.name("email2"), contact.getEmail2());	    	    
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());      
	    if (formType == CREATION){
	    //selectByText(By.name("new_group"), contact.relatedGroup);
	    	} else {
	    	/*if (driver.findElements(By.name("new_group")).size()!=0){
	    	throw new Error ("Group selector exists in contact modification form");
	    	}*/
	    	}
	    type(By.name("address2"), contact.getAddressSecondary());
	    type(By.name("phone2"), contact.getTelSecondary());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
			//cachedContacts=null;
		return this;
	}

	public ContactHelper initEditContact(int index) {
		click(By.xpath("//tr["+ (index+2) +"]/td[7]/a/img")); // +2 because we xPath enumeration begins from 1 and we should exclude first row with no contacts 
		return this;
	}
	
    public ContactHelper submitContactModification() {
        click(By.xpath("//form[1]/input[11]"));
        	//cachedContacts=null;
        return this;
	}
	public ContactHelper submitContactRemoval() {
		click(By.xpath("//form[2]/input[2]"));
			//cachedContacts=null;
		return this;
	}
}