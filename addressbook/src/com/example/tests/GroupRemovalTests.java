package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupRemovalTests extends BaseForTests {

//@Test
public void deleteSomeGroup(){	
	   //save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		if ( oldList.size()!=0) {
	    // actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size());
	    app.getGroupHelper().deleteGroup(index);		
		
		//save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	   
	    //compare states	    
		assertThat(newList,equalTo(oldList.without(index)));
		}
	}

//@Test   
public void deleteNotAllGroups(){
	
   //save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();    
	if ( oldList.size()!=0) {
	// actions
	Random rnd = new Random();		
	int amount = rnd.nextInt(oldList.size()); //amount of groups to delete
	if (amount == 0){
	amount++;
	}
	
	int[] indexes = new int[amount]; // array of deleted group indexes 
	indexes = app.getGroupHelper().deleteSeveralGroups(amount);

	for (int  i = amount-1; i>=0; i--) {
	oldList.remove(indexes[i]);			
	}
	
	//save new state
	SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
   
    //compare states	     
    assertEquals(newList, oldList); //i just don't want to use here assertThat :)
	}
}

@Test
	public void deleteAllGroups(){		
	   //save old state
	    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    int oldListSize= oldList.size();

	    if ( oldListSize!=0) {
	    // actions
        app.getGroupHelper().deleteSeveralGroups(oldListSize);
		
		for (int  i = oldListSize-1; i>=0; i--) {
		oldList.remove(i);			
		}		
		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	   
	    //compare states	     
	   assertEquals(newList, oldList); //i just don't want to use here assertThat :)
	    }
	}
}

