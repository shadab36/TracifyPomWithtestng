package com.herokuapp.qa.tests;



import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.CreateMissionsPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.pages.SubDivisonMissionPage;
import com.herokuapp.qa.util.TestUtil;

public class SubDivisonMissionPageTest extends Base{
	String sheetName="create_mission";
	LoginPage loginpage;
	HomePage  homepage;
	CreateMissionsPage createmission;
	SubDivisonMissionPage submisssion;
	public SubDivisonMissionPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		createmission=new CreateMissionsPage();
		submisssion=new SubDivisonMissionPage();
	}
	@DataProvider
	public Object[][] Tracifysubmission() {
	Object data[][]=TestUtil.getTestData(sheetName);	
	 return data;	
	
	}
	
@Test(priority=11,dataProvider="Tracifysubmission", description="verify add mission button with sub departement")
public  void  verifyaddmision_as_subdepart(String Department, String Category,String Customer,String Responsible,String ProjectManager,String Typeofdeadline) throws InterruptedException  {
	log=extent.createTest("verify the subdivison mission");
	submisssion.By_department(Department);
	submisssion.By_submission_cta(Department);
}

	
}





