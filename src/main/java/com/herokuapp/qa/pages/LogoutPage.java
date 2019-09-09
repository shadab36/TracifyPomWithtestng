package com.herokuapp.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;
import com.qa.lib.TakeScreenshot;

public class LogoutPage extends Base{
@FindBy(id="logout_accounts")
WebElement logout;

public LogoutPage() {
	PageFactory.initElements(driver, this);
}

public void  applogout() {
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].style.border='2px solid red'",logout);
	try {
		TakeScreenshot.captuerScreenshot(driver, "hoverUserfrofile");
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",logout);
	logout.click();
	
	
}

}