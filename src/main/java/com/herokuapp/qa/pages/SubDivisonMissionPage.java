package com.herokuapp.qa.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class SubDivisonMissionPage extends Base{
	
	@FindBy(css="#main-menu-navigation > li:nth-child(1) > a")
	WebElement HoverMission_managment;
	
	
	//By department wise mission xpath
	@FindBy(css=".dropdown.dropdown-submenu")
	WebElement Bydepartment;

	//Add the mission as sub department 
	@FindBy(xpath="//*[contains(@class, 'btn-round')]//font [contains(text(),'Testing Department')]")
	WebElement Addmission_bydepartment;
	
	public SubDivisonMissionPage() {
		PageFactory.initElements(driver, this);
	}
public void By_department(String submenutext) throws InterruptedException {
		
	new Actions(driver).moveToElement(HoverMission_managment).build().perform();
			Thread.sleep(1000);
			new Actions(driver).moveToElement(Bydepartment).build().perform();
			Thread.sleep(1000);
			WebElement sunmenu=driver.findElement(By.xpath("//a[contains(@class, 'dropdown-item')][contains(text(),'"+submenutext+"')]"));
			sunmenu.getText();
			Thread.sleep(1000);
			sunmenu.click();
			Thread.sleep(1000);
		
}


public void  By_submission_cta(String submenutext) throws InterruptedException {

WebElement AddMisionsubtype=driver.findElement(By.xpath("//button[contains(@class, 'btn-round')][contains(text(),'Ajouter une mission "+submenutext+"')]"));
 String submission=AddMisionsubtype.getText();
 assertTrue(true, submission);
 

			
			
		
	
		
	}
}
