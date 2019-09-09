package com.herokuapp.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.herokuapp.qa.base.Base;

public class WebEventListener extends Base implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to:'" + url + "'");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigate to:'" + url + "'");

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("value of the:" + element.toString() + "before any changes mode");

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to:" + element.toString());

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("trying to click:" + element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on:" + element.toString());

	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}
	
	
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	
	
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	
	public void onException(Throwable error,WebDriver driver) {
		System.out.println("Exception occured :"+error);
	}
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element by :"+by.toString());
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element by :"+by.toString());
	}
	
	
	
	public void beforeScript(String arg0, WebDriver arg1) {

	}
	
	public void afterScript(String arg0, WebDriver arg1) {

	}
	
	public void beforeAlertAccept(WebDriver arg0) {

	}
	
	public void afterAlertAccept(WebDriver arg0) {

	}

	
	
	
	
	
	
	
	
	public void afterAlertDismiss(WebDriver arg0) {

	}

	

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {

	}





	public void afterNavigateRefresh(WebDriver arg0) {

	}



	public void afterSwitchToWindow(String arg0, WebDriver arg1) {

	}

	

	public void beforeAlertDismiss(WebDriver arg0) {

	}

	

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {

	}

	
	public void beforeNavigateRefresh(WebDriver arg0) {

	}

	

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {

	}




	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {

	}

	

}
