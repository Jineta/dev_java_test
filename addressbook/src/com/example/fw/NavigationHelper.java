package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager pManager) {
		super(pManager); //��������� � �������� ������
	
	}

	public void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
		}

	public void returnToMainPageFromContact() {
		driver.findElement(By.linkText("home page")).click();
	}

	public void openMainPage() {
		manager.driver.get(manager.baseUrl + "/");
	}

	public void returnToGroupsPage() {
		manager.driver.findElement(By.linkText("group page")).click();
	}

}
