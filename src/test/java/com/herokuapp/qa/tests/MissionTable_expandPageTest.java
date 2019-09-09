package com.herokuapp.qa.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.pages.MissionTable_ExpandPage;

public class MissionTable_expandPageTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	 MissionTable_ExpandPage Mission_Expand;
	
	public MissionTable_expandPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		Mission_Expand=new MissionTable_ExpandPage();
	}

	
@Test(priority=13,description="Validation the Exapand table option")
public void expand_table() throws Exception {
	log = extent.createTest("Validation expand table option (+) plus icon");
	Mission_Expand.ExpandTable();

	logger.info("Expand the mission table");
	log = extent.createTest("Expand the mission table list");
}

}

