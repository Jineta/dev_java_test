package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager pManager) {
		super(pManager); //��������� � �������� ������	
	}

	public void gotoGroupPage() {
		click(By.linkText("groups"));	
	}

	public void returnToMainPageFromContact() {
		click(By.linkText("home page"));
	}

	public void openMainPage() {
		manager.driver.get(manager.baseUrl + "/");
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}
}
