package com.example.tests;

//import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends BaseForTests {


@Test(dataProvider ="groupsFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception { 
    //save old state
	 SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().createGroup(group);
   
    //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
   
    //compare states  
    assertThat(newList, equalTo(oldList.withAdded(group)));  
  }
}

