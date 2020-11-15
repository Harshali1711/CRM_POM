package com.CRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.TestBase.TestBase;

public class ContactsPage extends TestBase{
	
	//************************Page Factory********************************
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactLabel;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement CompanyName;
	
	@FindBy(xpath="//body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/select[1]")
	WebElement Status;
	
	@FindBy(xpath="//body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[2]")
	WebElement SaveButton;
	
	//***********************Constructor***********************************
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//************************Action Methods********************************
	
	public boolean VerifyContactsLabel()
	{
		return ContactLabel.isDisplayed();
	}

	public void SelectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void CreateNewContact(String title,String fname,String lname,String comp,String status)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		CompanyName.sendKeys(comp);
		
		Select select2=new Select(Status);
		select2.selectByVisibleText(status);
		
		SaveButton.click();		
		
	}
	
	
	
}
