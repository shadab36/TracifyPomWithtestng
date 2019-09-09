package com.herokuapp.qa.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class MissionTable_ExpandPage extends Base {
	
	@FindBy(xpath="(//i[@class='icon-minus4'] | //i[@class='icon-plus4'])[2]")
	WebElement Expand;
	
	
	
	public MissionTable_ExpandPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ExpandTable() throws InterruptedException {
		Expand.click();

			Thread.sleep(2000);
	
	
		WebElement min=driver.findElement(By.xpath("//span[text()='CSV']"));
		
		if(!min.isDisplayed()) {
			Expand.click();
			
				Thread.sleep(2000);
				
				 WebElement table = driver.findElement(By.xpath("//table/tbody")); 

				    List<WebElement> allRows = table.findElements(By.tagName("tr"));
				    System.err.println(allRows.size());
				    int number=10;
				    assertEquals((allRows.size()), number,"tablesize is not match");
			
	}

	}}
