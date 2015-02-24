package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class PrintPhoneHelper extends WebDriverHelperBase {
	

	public PrintPhoneHelper(ApplicationManager pManager) {
		super(pManager);	
	}

	public SortedListOf<String> getUiPrintPhones() {
		//List<String> printPhones = new ArrayList<String>();//implementation of List type
		SortedListOf<String> printPhones = new SortedListOf<String>();
		
		manager.navigateTo().printPhonesPage();
		List<WebElement> cells = driver.findElements(By.xpath("//table/tbody/tr/td"));// method findElements returns all elements which correspond selected locator
		
		for (WebElement cell : cells) {		
			String tempString= cell.getText();
	
			if 	(tempString.compareTo(".")!=0){ //delete all empty cells which were added in order to 
			printPhones.add(tempString);
			}
		}
		return printPhones;
	}

	public String getDbContactString(ContactData dbContact) {
		String dbContactString = "";
		
		if (dbContact.getFirstname().compareTo("")!=0) {
			dbContactString = dbContact.getFirstname().trim()+" ";	
		}
		
		if (dbContact.getLastname().compareTo("")!=0) {
			dbContactString = dbContactString+dbContact.getLastname().trim();	//i ignore addressbook bug with trimming 1 last space before :, my test removes all spaces before and after
		}
		
		dbContactString = dbContactString+":";
		
		if (dbContact.getTelHome().compareTo("")!=0) {
			dbContactString = dbContactString +"\n"+"H: "+dbContact.getTelHome().trim();	
		}
		
		
		
		if (dbContact.getTelMobile().compareTo("")!=0) {
			dbContactString = dbContactString +"\n"+"M: "+dbContact.getTelMobile().trim();	
		}		
		
		if (dbContact.getTelWork().compareTo("")!=0) {
			dbContactString = dbContactString +"\n"+"W: "+dbContact.getTelWork().trim();	
		}
		
		if ((dbContact.getBirthDay().compareTo("0")!=0)|(dbContact.getBirthMonth().compareTo("-")!=0)|(dbContact.getBirthYear().compareTo("")!=0)) {
			dbContactString = dbContactString +"\n"+"Birthday: ";	
		}
		
		if (dbContact.getBirthDay().compareTo("0")!=0) {
			dbContactString = dbContactString + dbContact.getBirthDay()+".";	
		}
		
		if (dbContact.getBirthMonth().compareTo("-")!=0) {
			dbContactString = dbContactString +" "+ dbContact.getBirthMonth();	
		}
		
		if (dbContact.getBirthYear().compareTo("")!=0) {
			dbContactString = dbContactString +" "+ dbContact.getBirthYear().trim();	
		}
		
		if (dbContact.getTelSecondary()!="") {
			dbContactString = dbContactString +"\n"+"P: "+dbContact.getTelSecondary().trim();	
		}
		
		System.out.println("dbContactString");
		System.out.println(dbContactString);
		
		return dbContactString;
	}

}
