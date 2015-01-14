package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager pManager) {
		super(pManager);	
	}
	
	private SortedListOf<GroupData> cachedGroups;
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return new SortedListOf<GroupData>(cachedGroups);
		//return cachedGroups;		
	}
	
	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>();//implementation of List type
	
		manager.navigateTo().groupsPage();	
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));//method findElements returns all elements which correspond selected locator
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name= title.substring("Select (".length(), title.length()-1);
			cachedGroups.add(new GroupData().withName(name));
		}		
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		manager.navigateTo().returnToGroupsPage();
		rebuildCache();
		return this;
	}

	public GroupHelper modifyGroup(GroupData group, int index) {
		manager.navigateTo().groupsPage();
  		selectGroupByIndex(index);
  		initGroupModification(); 
  		fillGroupForm(group);
  		submitGroupModification();	    
	    manager.navigateTo().returnToGroupsPage();
	    rebuildCache();
	    return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();	
	    manager.navigateTo().returnToGroupsPage();
	    rebuildCache();
		return this;
	}

	public int[] deleteSeveralGroups(int amount) {// later i would like to randomize selection of checkboxes
		manager.navigateTo().groupsPage();		
		int[] indexes = new int[amount];
		for (int i = 0; i < amount; i++) {			
			selectGroupByIndex(i);	
		    indexes[i] = i; // it will be useful when i implement  randomization of parameter i
		}
		submitGroupDeletion();
	    manager.navigateTo().returnToGroupsPage();
		rebuildCache();
	return indexes;
	}
	
//----------------------------------------------------------------------------------------------------------
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter()); 
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups=null;
		return this;
	}

	public GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
		return this;
	}

	public void initGroupModification() {
		click(By.name("edit"));
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups=null;
		return this;
	}

	public void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups=null;
	}


}
