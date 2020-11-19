package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.TestBase.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory : Object Repository
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement UserLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Task')]")
	WebElement NewTaskLink;
	
	//Initialize the pagefactory --constructor
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods --Features
	public String ValidateHomeTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateHomePageLabel()
	{
		return UserLabel.isDisplayed();
	}
	
	public ContactsPage ClickOnContactsLink()
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public void ClickOnNewContactLinks()
	{
		Actions act=new Actions(driver);
		act.moveToElement(ContactsLink).build().perform();
		NewContactLink.click();
		
	}
	
	public DealsPage ClickOnDealsLink()
	{
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickTasksLink()
	{
		TasksLink.click();
		return new TasksPage();
	}
	
	public void  ClickOnNewTasksLink()
	{
		Actions act=new Actions(driver);
		act.moveToElement(TasksLink).build().perform();
		NewTaskLink.click();
	}
	
	
	

}
