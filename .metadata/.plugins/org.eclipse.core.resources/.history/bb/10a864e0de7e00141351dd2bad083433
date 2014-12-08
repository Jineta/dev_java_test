package com.example.tests;

import java.util.regex.Pattern;

//import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
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
