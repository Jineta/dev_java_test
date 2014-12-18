package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends BaseForTests {

	@Test
public void deleteSomeGroup(){
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
		
	    app.getGroupHelper().deleteGroup(1);
		
		app.getNavigationHelper().returnToGroupsPage();
	}
}

