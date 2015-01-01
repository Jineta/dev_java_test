package com.example.tests;

public class ContactData implements Comparable<ContactData>{
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
		email2= pEmail2;	
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
	@Override // helps to optimize (if hashCodes aren't equal we stop compare). Else - goto equals method
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode()); //temporary comment
		return result;
	}

	@Override //automatically converts object GroupData to string - > good presentation of test results
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Override   //compares objects
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override  // a.compareTo( b ) -- ���� ������������� �����, ������ a <b, ���� ���� -- �����, ���� ������������� �� a > b
	//���, boolean ������������. ��� ��� ������ equals, ������� ������ ������� "����� ��� �� �����" 
	//� ����� compareTo ������� "������, ����� ��� ������"
	public int compareTo(ContactData other) {
	
		/*if (this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase())==0
		 && this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase())==0
		 && this.email1.toLowerCase().compareTo(other.email1.toLowerCase())==0
		 && this.telHome.toLowerCase().compareTo(other.telHome.toLowerCase())==0){
			return 0;
		 } else return -1;*/
	return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase()); 
	}
	
	
}