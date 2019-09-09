package com.herokuapp.qa.pages;



import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.herokuapp.qa.base.Base;

public class CreateMissionsPage extends Base{
	Actions ac=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(css="#main-menu-navigation > li:nth-child(1) > a")
	WebElement HoverMission_managment;
	
	@FindBy(css="#main-menu-navigation > li:nth-child(1) > ul > li:nth-child(1) >a")
	WebElement All_departments;
	
	
	
	
	
	
	@FindBy(css="body > div.app-content > div > div:nth-child(1) > div:nth-child(2) > a > button")
	WebElement Addmission;
	
	
	@FindBy(css="body div.row > div:nth-child(1) > div:nth-child(1) span.select2-selection__arrow")
	WebElement department;
	
	
	@FindBy(css="body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement 	search_department_name;
	
	
	@FindBy(css="body form div.row > div:nth-child(1) > div:nth-child(2) span.select2-selection__arrow")
	WebElement category;
	
	
	@FindBy(css="body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement search_catégorie_name;
	
	
	
	@FindBy(css="body > div.container.mb-3  div.row > div:nth-child(2) > div:nth-child(1)  span.select2-selection__arrow")
	WebElement 	client;
	
	
	@FindBy(css="body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement search_Client_name;
	
	
	@FindBy(css="body > div.container.mb-3  form div.row > div:nth-child(2) > div:nth-child(2) span.select2-selection__arrow")
	WebElement responsible;
	
	@FindBy(css="body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement search_responsible;
	
	@FindBy(css="body > div.container.mb-3  div:nth-child(3) > span > span.selection > span > ul>li>input")
	WebElement projectManager;
	
	@FindBy(css="body > div.container.mb-3  div.row > div:nth-child(3) > div:nth-child(1)  span.select2-selection__arrow")
	WebElement type_de_deadline;
	
	
	@FindBy(css="body > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement Search_Type_of_deadline;
	
	
	@FindBy(id="id_date_deadline")
	WebElement date;


	
	public CreateMissionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Select_all_department() {
		
		ac.moveToElement(HoverMission_managment).build().perform();
		All_departments.click();

	
		
		    
	}
	
	public void Bydepartment() {
		
	}
	
public void Add_mission() {
	Addmission.click();
	
}

public String Select_Département(String Department) {
	department.click();
	search_department_name.sendKeys(Department);
	WebElement dep_name = driver.findElement(By.xpath("//li[contains(text(),'" + Department + "')]"));
	dep_name.click();
	return null;
}
public void Select_Catégorie(String Catégoriename) {
	category.click();
	search_catégorie_name.sendKeys(Catégoriename);
	WebElement catégorie_name = driver.findElement(By.xpath("//li[contains(text(),'" + Catégoriename + "')]"));
	catégorie_name.click();
}

public void Select_client(String clientname) {
	client.click();
	search_department_name.sendKeys(clientname);
	WebElement client_name = driver.findElement(By.xpath("//li[contains(text(),'" + clientname + "')]"));
	client_name.click();
}

public void Select_responsible(String responsibleName) {
	responsible.click();
	search_responsible.sendKeys(responsibleName);
	WebElement responsible_name = driver.findElement(By.xpath("//li[contains(text(),'" + responsibleName + "')]"));
	responsible_name.click();
}

public void Select_projectManager(String projectManagerName) {
	projectManager.click();
	projectManager.sendKeys(projectManagerName);
	WebElement responsible_name = driver.findElement(By.xpath("//li[contains(text(),'" + projectManagerName + "')]"));
	responsible_name.click();
}

public void Deadline(String deadline) {
	type_de_deadline.click();
	Search_Type_of_deadline.sendKeys(deadline);
	WebElement select_deadline= driver.findElement(By.xpath("//li[contains(text(),'" + deadline + "')]"));
	select_deadline.click();
}
public void Select_date() {
	date.click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	try {
		//If the current day is Sunday
		Calendar c = Calendar.getInstance();
		if(c.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY) {
		    System.out.println("SUNDAY!");
		 
		    js.executeScript(
					"return document.getElementsByClassName('picker__day--highlighted')[0].parentNode.parentNode.nextElementSibling.getElementsByClassName('picker__day picker__day--infocus')[0].click();");
			Thread.sleep(1000); 
			System.out.println("next day");					
			
		}
	else {	
		try {
	
			js.executeScript("return document.getElementsByClassName('picker__day--highlighted')[0].parentNode.nextElementSibling.getElementsByClassName('picker__day picker__day--infocus')[0].click();");
			Thread.sleep(1000); 
	
	
		}catch(Exception e) {
			js.executeScript(
					"return	document.getElementsByClassName('picker__day--highlighted')[0].parentNode.nextElementSibling.getElementsByClassName('picker__day picker__day--outfocus')[0].click();");
			System.out.println("next day");	
		}
	}
		
	} catch (Exception exe) {
		
	}
}
public void Save_mission()throws Throwable       {
	js.executeScript("return document.getElementsByClassName('btn-success')[0].click();");
	Thread.sleep(2000);
}


}
	

