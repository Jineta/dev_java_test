package com.example.tests;

public class GroupData implements Comparable<GroupData>{ //there is an opportunity to compare GroupData objects
	private String id;
	private String name;
	private String header;
	private String footer;

	public GroupData() {
		 name = null;
		 header = null;
		 footer = null;
	}
	
public GroupData withId(String id) {
		this.id = id;
		return this;
}

public GroupData withName(String name) {
	this.name = name;
	return this;
}

public GroupData withHeader(String header) {
	this.header = header;
	return this;
}

public GroupData withFooter(String footer) {
	this.footer = footer;
	return this;
}
public void setId(String id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setHeader(String header) {
	this.header = header;
}

public void setFooter(String footer) {
	this.footer = footer;
}

public String getId() {
	return id;
}

public String getName() {
	return name;
}

public String getHeader() {
	return header;
}

public String getFooter() {
	return footer;
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
	return "GroupData [name=" + name + ", header=" + header + ", footer="
			+ footer + "]";
}

@Override   //compares objects
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	GroupData other = (GroupData) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

@Override  // a.compareTo( b ) -- ���� ������������� �����, ������ a <b, ���� ���� -- �����, ���� ������������� �� a > b
//���, boolean ������������. ��� ��� ������ equals, ������� ������ ������� "����� ��� �� �����" 
//� ����� compareTo ������� "������, ����� ��� ������"
public int compareTo(GroupData other) {

return this.name.toLowerCase().compareTo(other.name.toLowerCase());
}

/*public int compareTo(GroupData other) {
	int result = 2;
	if ((other.name != null)&&(this.name != null)) {
	result = this.name.toLowerCase().compareTo(other.name.toLowerCase());
	} else if ((this.name == null)&&(other.name != null)){
      result =  -1;
	} else if ((this.name != null)&&(other.name == null)){
	  result = 1;
		} else if ((this.name == null)&&(other.name == null)){
		  result = 0;
	}
	return result;
	}*/
}




