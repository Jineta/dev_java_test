package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.fw.User;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SignupTest extends BaseForTests {
 public  User user = new User().setLogin("testuser5")
		 .setPassword("123456")
		 .setEmail("testuser5@localhost");

 @BeforeTest
 public void createMailUser(){
	 if (!james.doesUserExist(user.login)){
		  james.createUser(user.login,user.password);
	 } 
 }
 
@Test
 public void newUserShouldSignup(){
    accHelper.signup(user); 
    accHelper.login(user);
	 assertThat(accHelper.loggedUser(),equalTo(user.login));
 }
 
//@Test
 public void existedUserShouldNotSignup(){
	try{
    accHelper.signup(user);
	} catch (Exception e){
		assertThat(e.getMessage(), containsString("That username is already being used"));
		return;
	}
	fail("Exception expected");
 }
 
@AfterTest
 public void deleteMailUser(){
	 System.out.println("after begin");
	 if (james.doesUserExist(user.login)){
		 james.deleteUser(user.login);
	 }

 }
 
 }