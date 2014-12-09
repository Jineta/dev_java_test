package com.example.tests;


import org.testng.annotations.Test;

public class GroupCreationTests extends BaseForTests {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupCreation();
  
    GroupData group = new GroupData();
    group.setName("group111");
    group.setHeader("header111");
    group.setFooter("footer111");
    
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initGroupCreation();    
    GroupData group = new GroupData();
    fillGroupForm(group);    
    submitGroupCreation();
    returnToGroupsPage();
  }
}
