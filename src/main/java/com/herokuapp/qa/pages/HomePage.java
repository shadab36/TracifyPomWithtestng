package com.herokuapp.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class HomePage extends Base {
	

	@FindBy(id="userprofile_name")
	WebElement ProfileName;
	
	@FindBy(css=".dropdown-user-link")
	WebElement UserProLink;
	
	@FindBy(id="update_accounts")
	WebElement Udateaccount;
	
	
	public HomePage() {
	PageFactory.initElements(driver, this);	
	}
	
	
	
	public String VerifyHomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public String VerifyHomePageUrl() {
		
		return driver.getCurrentUrl();
		
	}
	
	public String username() {
		
		return ProfileName.getText(); 
		
	}
	public EditProfilePage hoverUsername() {
		new Actions(driver).moveToElement(UserProLink).build().perform();

		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Udateaccount.click();
		return new EditProfilePage() ;
	}
	
	public LogoutPage hoverUserfrofile() {
		new Actions(driver).moveToElement(UserProLink).build().perform();
		return new LogoutPage();
	}

	
}
