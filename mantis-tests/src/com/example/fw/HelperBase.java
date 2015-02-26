package com.example.fw;

import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
	protected ApplicationManager manager;

	public HelperBase(ApplicationManager pManager) {		
		this.manager = pManager;//data inside object. ссілка на поле. речь идет о манагере, кот часть єтого обїекта, поле єтого обїекта

		}
	
	protected void pause(int pause) {
		try {
			Thread.sleep(pause);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
