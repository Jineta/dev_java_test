package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager pManager) {
		super(pManager); //��������� � �������� ������	
	}

	public void gotoGroupPage() {
		click(By.name("groups"));	
	}

	public void returnToMainPageFromContact() {
		click(By.name("home page"));
	}

	public void openMainPage() {
		manager.driver.get(manager.baseUrl + "/");
	}

	public void returnToGroupsPage() {
		click(By.name("group page"));
	}
}
