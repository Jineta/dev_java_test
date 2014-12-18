package com.example.tests;


import org.testng.annotations.Test;

public class GroupCreationTests extends BaseForTests {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
  
    GroupData group = new GroupData();
    group.setName("group111");
    group.setHeader("header111");
    group.setFooter("footer111");
    
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();    
    GroupData group = new GroupData();
    app.getGroupHelper().fillGroupForm(group);    
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupsPage();
  }
}

