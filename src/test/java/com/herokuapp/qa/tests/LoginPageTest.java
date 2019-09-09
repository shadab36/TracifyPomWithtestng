package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.qa.lib.TakeScreenshot;


public class LoginPageTest extends Base {
	public LoginPageTest() {
		super();
	}
	LoginPage loginPage;
	HomePage homepage;


	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		initialization();
		
		loginPage = new LoginPage();
	
	}
	
@Test(priority=1,description="Validation of Login page tile")
public void verifyloginpagetitle() throws Exception {
log = extent.createTest("Validation login Page");
	String Logintitle= LoginPage.verifyloginpage();
	assertEquals(Logintitle, "Tracify App - Login","Login Page Title does not match");	
	logger.info("Tracify Customer Page Title Validation is Sucesfull");
	TakeScreenshot.captuerScreenshot(driver, "tracifylogin");
}
	@Test(priority = 2,description="Tracify user login Page")
	public void login() throws Exception {
	log = extent.createTest("Validation of Tracify customer Login");
		homepage = loginPage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		logger.info("Tracify Customer Login Validation is Sucesfull");
		//TakeScreenshot.captuerScreenshot(driver, "MissionPage");
	}

	

}



