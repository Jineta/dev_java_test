package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager pManager) {
		super(pManager);	
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter()); 
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void deleteGroup(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
		click(By.name("delete"));		
	}
	
	public int[] deleteSeveralGroups(int amount) {// later i would like to randomize selection of checkboxes
		int[] indexes = new int[amount];
		for (int i = 0; i < amount; i++) {			
			click(By.xpath("//input[@name='selected[]']["+(i+1)+"]"));	
		    indexes[i] = i; // it will be useful when i implement  randomization of parameter i
		}
		click(By.name("delete"));		
	return indexes;
	}
	
	
	public void initModifyGroup(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
		click(By.name("edit"));		
	}

	public void submitGroupModification() {
		click(By.name("update"));
		
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();//implementation of List type
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));//method findElements returns all elements which correspond selected locator
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name= title.substring("Select (".length(), title.length()-1);
			groups.add(new GroupData().withName(name));
		}	
		
		return groups;
	}
}
