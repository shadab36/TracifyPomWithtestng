package com.herokuapp.qa.tests;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.CreateMissionsPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.util.TestUtil;



public class CreateMissionsPageTest extends Base{
	String sheetName="create_mission";
	LoginPage loginpage;
	HomePage  homepage;
	CreateMissionsPage createmission;
	public CreateMissionsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		createmission=new CreateMissionsPage();
	}
	@Test (priority=9,description="verify the the table list")
	public void verifyTableList(){
		log=extent.createTest("verify the the table list on page");
		createmission.Select_all_department();
	 WebElement table = driver.findElement(By.xpath("//table/tbody")); 

	    List<WebElement> allRows = table.findElements(By.tagName("tr"));
	    System.err.println(allRows.size());
	    int number=10;
	    assertEquals((allRows.size()), number,"tablesize is not match");
	}
	
	@DataProvider
	public Object[][] TracifyData() {
	Object data[][]=TestUtil.getTestData(sheetName);	
	 return data;	
	
	}
	
	@Test (priority=10, dataProvider="TracifyData", description="Fills the crate mission filed")
	public void verifymissionlabel(String Department, String Category,String Customer,String Responsible,String ProjectManager,String Typeofdeadline) {
		log=extent.createTest("create the new mission");
		createmission.Select_all_department();
		createmission.Add_mission();
		
		createmission.Select_Département(Department);	
		createmission.Select_Catégorie(Category);
		createmission.Select_client(Customer);	
		createmission.Select_responsible(Responsible);
		createmission.Select_projectManager(ProjectManager);
		createmission.Deadline(Typeofdeadline);	
		createmission.Select_date();
		try {
			createmission.Save_mission();
			logger.info("create the new mission");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	
}}
