package com.example.tests;


import org.testng.annotations.Test;

public class GroupCreationTests extends BaseForTests {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupCreation();
    
    GroupData group = new GroupData();//local var, is viewable only in this method
    group.name = "group111";
    group.header = "header111";
    group.footer = "footer111";
    
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupCreation();
    
    GroupData group = new GroupData();//local var, is viewable only in this method
    group.name = "";
    group.header = "";
    group.footer = "";
    fillGroupForm(group);
    
    submitGroupCreation();
    returnToGroupsPage();
  }
}
