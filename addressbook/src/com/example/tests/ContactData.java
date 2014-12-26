package com.example.tests;

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
		firstname=null;
		lastname=null;
		address=null;
		telHome=null;
		telMobile=null;
		telWork=null;
		email1=null;
		email2=null;
		birthDay=null;
		birthMonth=null;
		birthYear=null;
		relatedGroup=null;
		adressSecondary=null;
		telSecondary=null;	
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