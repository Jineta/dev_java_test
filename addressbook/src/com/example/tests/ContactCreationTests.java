package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import com.example.utils.SortedListOf;

import org.testng.annotations.Test;

public class ContactCreationTests  extends BaseForTests {
  @Test(dataProvider ="randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {	
	 //save old state
	 SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions
	app.getContactHelper().createContact(contact);
 
    //save new state
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

    //compare states   
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  } 
}

