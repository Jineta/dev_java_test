package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;

public class GroupRemovalTests extends BaseForTests {

@Test
public void deleteSomeGroup(){
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
		
	   //save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
	    app.getGroupHelper().deleteGroup(index);		
		app.getNavigationHelper().returnToGroupsPage();
		
		//save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	   
	    //compare states	    
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}


@Test
public void deleteNotAllGroups(){
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
	
   //save old state
	List<GroupData> oldList = app.getGroupHelper().getGroups();    
    // actions
	Random rnd = new Random();
	//if		
	int amount = rnd.nextInt(oldList.size()-1); //amount of groups to delete
	if (amount == 0){
	amount++;
	}
	
	int[] indexes = new int[amount]; // array of deleted group indexes 
	indexes = app.getGroupHelper().deleteSeveralGroups(amount);
	app.getNavigationHelper().returnToGroupsPage();

	for (int  i = amount-1; i>=0; i--) {
	oldList.remove(indexes[i]);			
	}
	
	//save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
   
    //compare states	     
    Collections.sort(oldList);
    assertEquals(newList, oldList);
}

@Test
	public void deleteAllGroups(){
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
		
	   //save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
	    int oldListSize= oldList.size();
	    
	    // actions
		int[] indexes = new int[oldListSize];
		indexes = app.getGroupHelper().deleteSeveralGroups(oldListSize);
		app.getNavigationHelper().returnToGroupsPage();
		
		for (int  i = oldListSize-1; i>=0; i--) {
		oldList.remove(indexes[i]);			
		}		
		//save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	   
	    //compare states	     
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	

}

