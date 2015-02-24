package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends WebDriverHelperBase {

	public NavigationHelper(ApplicationManager pManager) {
		super(pManager); //обращение к базовому классу	
	}

	public void mainPage() {
		if (! onMainPage()){
		click(By.linkText("home"));
		}
	}

	public void groupsPage() {
		if(! onGroupsPage()){
		click(By.linkText("groups"));	
		} 
	}
	
	public void printPhonesPage() {
		if(! onPrintPhonesPage()){
			click(By.linkText("print phones"));	
			} 
	}	
	private boolean onPrintPhonesPage() {
		if (driver.getCurrentUrl().contains("/view.php?all&print&phones")// подумать достаточно ли єтого
				&& driver.findElements(By.name("new")).size()>0)
			{return true;
			} else {
				return false;
			}
	}

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size()>0;
	}
	
	private boolean onGroupsPage() {
		if (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size()>0)
			{return true;
			} else {
				return false;
			}
	}

	public void returnToMainPageFromContact() {
		click(By.linkText("home page"));
	}


	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}


}
