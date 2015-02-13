package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import com.example.utils.SortedListOf;

import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends BaseForTests {
@Test(dataProvider ="randomValidContactGenerator")
public void modifySomeContact(ContactData contact){
	//save old state
	SortedListOf<ContactData> oldList = app.getModel().getContacts();
	
	if (oldList.size()!=0){	
	//actions
	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size());
	app.getContactHelper().modifyContact(contact, index);
		
	//save new state
	SortedListOf<ContactData> newList = app.getModel().getContacts();

	//compare states	    
	assertThat(newList, equalTo(oldList.without(index).withAdded(contact))); 
	
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
}




