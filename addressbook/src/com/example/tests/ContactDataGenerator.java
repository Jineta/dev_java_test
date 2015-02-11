package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.tests.GeneratorHelper.*;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {
//main method to generate specified amount of groups, save them to the file with specified name and type 
	public static void main(String[] args) throws IOException {
	
	if (args.length<3){
	System.out.println("Please, spesify all expected parametrs (amount of test data, file, format)");
	return;
	}
	int amount = Integer.parseInt(args[0]);
	File file = new File(args[1]);
	String format = args[2];
	if(file.exists()){
	System.out.println("File exists, please remove it manually: " + file);
	return;
	}
	
	List<ContactData> contacts = generateRandomContacts(amount);
	if ("csv".equals(format)){
		saveContactsToCsvFile(contacts,file);
	} else if (("xml".equals(format))){
		saveContactsToXMLFile(contacts,file);
		} else {
			System.out.println("Invalid format parametr. Please try again");
			return;
		}
		}
	
//Methods to WORK WITH FILES
	// ... XML	
	private static void saveContactsToXMLFile(List<ContactData> contacts, File file) throws IOException {
	XStream xstream = new XStream();
	xstream.alias("contact", ContactData.class);
	String xml = xstream.toXML(contacts);
	FileWriter writer = new FileWriter(file);
	writer.write(xml);
	writer.close();
	}
	
	public static List<ContactData> loadContactsFromXMLFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>)xstream.fromXML(file);
	}
	
	// ... CSV	
	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname()+","
						+contact.getLastname()+","
						+contact.getAddress()+","
						+contact.getTelHome()+","
						+contact.getTelMobile()+","
						+contact.getTelWork()+","
						+contact.getBirthDay()+","
						+contact.getBirthMonth()+","
						+contact.getBirthYear()+","
						+contact.getEmail1()+","
						+contact.getEmail2()+","
						+contact.getAddress()+","
						+contact.getAddressSecondary()+","
						+contact.getTelSecondary()+",!"+"\n");
			}
		writer.close();
		}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader); 		
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(part[0])
			.withLastName(part[1])
			.withAddress(part[2])
			.withTelHome(part[3])
			.withTelMobile(part[4])
			.withTelWork(part[5])
			.withBirthDay(part[6])
			.withBirthMonth(part[7])
			.withBirthYear(part[8])
			.withEmail1(part[9])
			.withEmail2(part[10])
			.withAddress(part[11])
			.withAddressSecondary(part[12])
			.withTelSecondary(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();		
		}
		bufferedReader.close();
		return list;
	}
	
//GENERATOR
	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
	 	for (int i = 0;i<amount;i++) {
	 		ContactData contact = new ContactData()
	 			.withFirstName(generateRandomString())// в лекциях всегда стремимся сделать "меньше букв в коде", и я понимаю, что запись длинная. Не понимаю, как испраить
	 			.withLastName(generateRandomString())
	 			.withAddress(generateRandomString())
	 			.withTelHome(generateRandomString())
	 			.withTelMobile(generateRandomString())
	 			.withTelWork(generateRandomString())
	 			.withEmail1(generateRandomString())
	 			.withEmail2(generateRandomString())
	 			.withBirthDay(generateRandomDay())
	 			.withBirthMonth(generateRandomMonth())
	 			.withBirthYear(generateValidBYear())
	 		 	.withAddressSecondary(generateRandomString())
	 			.withTelSecondary(generateRandomString()); 		
	 		//contact.relatedGroup = selectRandomGroup();  
	 		list.add(contact);
	 		 }
	 	return list;
	}
}	



