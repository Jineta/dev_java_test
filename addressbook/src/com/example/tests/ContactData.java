package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String telHome;
	public String telMobile;
	public String telWork;
	public String email1;
	public String email2;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String relatedGroup;
	public String adressSecondary;
	public String telSecondary;

	public ContactData(){
		firstname="";
		lastname="";
		address="";
		telHome="";
		telMobile="";
		telWork="";
		email1="";
		email2="";
		birthDay="-";
		birthMonth="-";
		birthYear="";
		relatedGroup="";
		adressSecondary="";
		telSecondary="";	
	}; 
	//SET methods
	public void setFirstname(String pFirstname){
		firstname= pFirstname;	
		}
	public void setLastname(String pLastname){
		lastname= pLastname;	
		}
	public void setAddress(String pAddress){
		address= pAddress;	
		}
	public void setTelHome(String pTelHome){
		telHome= pTelHome;	
		}
	public void setTelMobile(String pTelMobile){
		telMobile= pTelMobile;	
		}
	public void setTelWork(String pTelWork){
		telWork= pTelWork;	
		}
	public void setEmail1(String pEmail1){
		email1= pEmail1;	
		}
	public void setEmail2(String pEmail2){
		email1= pEmail2;	
		}
	public void setBirthDay(String pBirthDay){
		birthDay= pBirthDay;	
		}
	public void setBirthMonth(String pBirthMonth){
		birthMonth= pBirthMonth;	
		}
	public void setBirthYear(String pBirthYear){
		birthYear= pBirthYear;	
		}
	public void setRelatedGroup(String pRelatedGroup){
		relatedGroup= pRelatedGroup;	
		}
	public void setAdressSecondary(String pAdressSecondary){
		adressSecondary= pAdressSecondary;	
		}
	public void setTelSecondary(String pTelSecondary){
		telSecondary= pTelSecondary;	
		}
	
	
}