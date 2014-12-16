package com.example.tests;


import org.testng.annotations.Test;

public class GroupCreationTests extends BaseForTests {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.navigationHelper.openMainPage();
    app.navigationHelper.gotoGroupPage();
    app.groupHelper.initGroupCreation();
  
    GroupData group = new GroupData();
    group.setName("group111");
    group.setHeader("header111");
    group.setFooter("footer111");
    
    app.groupHelper.fillGroupForm(group);
    app.groupHelper.submitGroupCreation();
    app.navigationHelper.returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.navigationHelper.openMainPage();
    app.navigationHelper.gotoGroupPage();
    app.groupHelper.initGroupCreation();    
    GroupData group = new GroupData();
    app.groupHelper.fillGroupForm(group);    
    app.groupHelper.submitGroupCreation();
    app.navigationHelper.returnToGroupsPage();
  }
}

