package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends BaseForTests {

	@Test
public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
		
	    app.getGroupHelper().initModifyGroup(1);
	    GroupData group = new GroupData();  
	    group.name = "modified name_first";
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupModification();	    
		app.getNavigationHelper().returnToGroupsPage();
	}
}
