package com.CRM.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.TestBase.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory : Object Repository
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement LoginButton;
	
	@FindBy(xpath="//body/div[2]/div[1]/div[1]/a[1]/img[1]")
	WebElement CRMLogo;
	
	//Inintialize the Page Factory --Construtor
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods - Features of the Page

	public String ValidateLoginTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateLoginLogo() 
	{
		return CRMLogo.isDisplayed();
	}
	
	public HomePage Login(String user,String pwd)
	{
		Username.sendKeys(user);
		Password.sendKeys(pwd);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", LoginButton);
		
		return new HomePage();		
	}
	
	
}
