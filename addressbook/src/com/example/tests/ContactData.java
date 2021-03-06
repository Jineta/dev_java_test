package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String id;
	private String firstname;
	private String lastname;
	private String address;
	private String telHome;
	private String telMobile;
	private String telWork;
	private String email1;
	private String email2;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
 	private String relatedGroup;
	private String addressSecondary;
	private String telSecondary;


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
		addressSecondary=null;
		telSecondary=null;	
	} 
	
	//WITH methods
	public ContactData withId(String id) {
		this.id = id;
		return this;
	}
	
	public ContactData withFirstName(String firstName) {
		this.firstname = firstName;
		return this;
	}
	
	public ContactData withLastName(String lastName) {
		this.lastname = lastName;
		return this;
	}
	
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withTelHome(String telHome) {
		this.telHome = telHome;
		return this;
	}	
	
	public ContactData withTelMobile(String telMobile) {
		this.telMobile = telMobile;
		return this;
	}
	
	public ContactData withTelWork(String telWork) {
		this.telWork = telWork;
		return this;
	}
	
	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}	
	
	public ContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}	
	
	public ContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}
	
	public ContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}
	
	public ContactData withAddressSecondary(String addressSecondary) {
		this.addressSecondary = addressSecondary;
		return this;
	}
	
	public ContactData withTelSecondary(String telSecondary) {
		this.telSecondary = telSecondary;
		return this;
	}	
	//SETTERS
	public void setId(String id) {
		this.id = id;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}
	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}
	public void setTelWork(String telWork) {
		this.telWork = telWork;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public void setRelatedGroup(String relatedGroup) {
		this.relatedGroup = relatedGroup;
	}
	public void setAddressSecondary(String addressSecondary) {
		this.addressSecondary = addressSecondary;
	}
	public void setTelSecondary(String telSecondary) {
		this.telSecondary = telSecondary;
	}
	//GETTERS
	public String getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getTelHome() {
		return telHome;
	}
	public String getTelMobile() {
		return telMobile;
	}
	public String getTelWork() {
		return telWork;
	}
	public String getEmail1() {
		return email1;
	}
	public String getEmail2() {
		return email2;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public String getRelatedGroup() {
		return relatedGroup;
	}
	public String getAddressSecondary() {
		return addressSecondary;
	}
	public String getTelSecondary() {
		return telSecondary;
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