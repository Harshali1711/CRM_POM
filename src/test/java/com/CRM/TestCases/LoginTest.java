package com.CRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.TestBase.TestBase;

public class LoginTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority = 1)
	public void VerifyLoginTitle()
	{
		String LoginTitle=loginpage.ValidateLoginTitle();
		Assert.assertEquals(LoginTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		System.out.println("Title matched");
	}
	
	@Test(priority = 2)
	public void VerifyLoginLogo()
	{
		boolean flag=loginpage.ValidateLoginLogo();
		Assert.assertTrue(flag);
		System.out.println("Logo is present on webpage");
	}
	
	@Test(priority = 3)
	public void LoginTestMethod()
	{
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
