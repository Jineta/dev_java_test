package com.example.tests;

//import java.util.Collections;
//import java.util.List;
//import java.util.ArrayList;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class GroupCreationTests extends BaseForTests {
		 
 @Test(dataProvider ="randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
  
    //save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
   
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
   
    //compare states   
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);    
  }
}

