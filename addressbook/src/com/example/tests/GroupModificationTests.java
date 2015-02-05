package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends BaseForTests {

@Test(dataProvider ="generateRandomGroups")
public void modifySomeGroup(GroupData group){    
	    //save old state
	    SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
	    
	  	if (oldList.size()!=0){
	  	//actions
	  	Random rnd = new Random();
		int index = rnd.nextInt(oldList.size());
		app.getGroupHelper().modifyGroup(group, index);

		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
	   
	    //compare states	    
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));  
	  	}	
	}
}
