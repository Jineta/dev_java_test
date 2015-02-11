package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXMLFile;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import com.example.utils.SortedListOf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests  extends BaseForTests {
  @DataProvider
		public Iterator<Object[]> contactsFromFile() throws IOException {	 		
		 	return wrapContactsForDataProvider(loadContactsFromXMLFile(new File("contacts.xml"))).iterator();
		}
		
  @Test(dataProvider ="contactsFromFile")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {	
	 //save old state
	  	// SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	SortedListOf<ContactData> oldList = app.getModel().getContacts();
    
	// actions
	app.getContactHelper().createContact(contact);
 
    //save new state
			//SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	SortedListOf<ContactData> newList = app.getModel().getContacts();
   
	//compare states   
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    
   //compare model to implementation
    if (wantToCheck()){   
     if ("yes".equals(app.getProperty("check.db"))){
     	assertThat(app.getModel().getContacts(),equalTo(app.getHibernateHelper().listContacts()));
     	}    
     if ("yes".equals(app.getProperty("check.ui"))){
     	 assertThat(app.getModel().getContacts(),equalTo(app.getContactHelper().getUiContacts()));
         }
     }
  } 
}

