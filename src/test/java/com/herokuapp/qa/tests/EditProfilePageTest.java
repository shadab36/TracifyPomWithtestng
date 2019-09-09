package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.EditProfilePage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.util.TestUtil;

public class EditProfilePageTest extends Base{
	String Sheetname="EditPage";
	LoginPage loginpage;
	HomePage homepage;
	 EditProfilePage Profilepage;
	 public EditProfilePageTest() {
		 super();
	 }
	 
		
		@BeforeMethod
	 public void setup() throws MalformedURLException {
		 initialization();
			loginpage= new LoginPage();
			homepage=loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
			 Profilepage=homepage.hoverUsername();
		
			
	 }
	 
		@DataProvider
		public Object[][] profileupdate() {
		Object data[][]=TestUtil.getTestData(Sheetname);	
		 return data;		
		}
	 @Test(priority=6,dataProvider="profileupdate",description="Update the user profile")
	 public void update(String Cname) { 
			log=extent.createTest("verify the updated the profile");
		 Profilepage. enterCity(Cname);
	 Profilepage.SaveProfile();
	 logger.info("Update the profile");
	log=extent.createTest("Update the user profile");
	 String valmessage= Profilepage.verifySuccess();
		assertEquals(valmessage, "Modifié !","updated message is not matched");
		
	
		
}



@Test(priority=7,dataProvider="profileupdate",description="verify the edited profile data")	
public void verify_updated_data(String Cityname) {
	log=extent.createTest("verify the enter value on  the profile page");
	  String text= Profilepage.VerifyCityname();
	  System.err.println("hi"+text);
	  System.out.println(Cityname);
		assertEquals(text, Cityname,"name is not matched");
	
		
}
}