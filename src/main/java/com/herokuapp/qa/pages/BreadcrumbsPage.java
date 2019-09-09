package com.herokuapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;
public class BreadcrumbsPage extends Base{


@FindBy(css=".breadcrumb-item:nth-child(2)>a")
WebElement Breadcum_mission;


public BreadcrumbsPage() {
	PageFactory.initElements(driver, this);
}


public HomePage Landingpage() {
	Breadcum_mission.click();
	return new HomePage();
	
}
}
