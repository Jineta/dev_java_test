package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends BaseForTests {

@Test
public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
			
		//actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);		
		app.getContactHelper().initEditContact(index);		
		app.getContactHelper().submitContactRemoval();
		app.getNavigationHelper().returnToMainPageFromContact();
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		//compare states	    
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
		}
	}



