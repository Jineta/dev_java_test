package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

public class ContactRemovalTests extends BaseForTests {

@Test
public void deleteSomeContact(){
		//save old state
	   SortedListOf<ContactData> oldList = app.getContactHelper().getUiContacts();
	   if (oldList.size()!=0){	
		//actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size());		
		app.getContactHelper().removeContact(index);
		
		//save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();

		//compare states	    
		assertThat(newList,equalTo(oldList.without(index)));
		}
	}
	}



