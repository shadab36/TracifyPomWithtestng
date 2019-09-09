package com.herokuapp.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class EditProfilePage extends Base {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy (id="id_city")
	WebElement Citname;
	
	
	@FindBy (xpath="//button[@type='submit']")
		WebElement Save;
	
	@FindBy(xpath="//h2[contains(text(),'Modifié !')]")
	WebElement sucess;
	
	public EditProfilePage() {
		PageFactory.initElements(driver, this);
	}
	

	public void enterCity(String Cityname) {
		js.executeScript("window.scrollTo(0,600)");
		Citname.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Citname.clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Citname.sendKeys(Cityname);
	}
	
	public void SaveProfile() {
		Save.click();
		
	}
	public String verifySuccess() {
		return sucess.getText();

		
	}
		
	public String VerifyCityname() {
		
		js.executeScript("window.scrollTo(0,600)");
	 return Citname.getAttribute("value");
	}
	
	}
	
