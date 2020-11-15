package com.CRM.TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.TestBase.TestBase;
import com.CRM.TestUtils.TestUtils;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=new HomePage();
	}
	
	@Test
	public void VerifyHomePageTitle()
	{
		String HomeTitle=homepage.ValidateHomeTitle();
		Assert.assertEquals(HomeTitle, "CRMPRO");
		System.out.println("Title matched");
	}
	
	@Test
	public void VerifyHomePageLabel()
	{
		TestUtils.SwitchToFrame();
		boolean flag=homepage.validateHomePageLabel();
		Assert.assertTrue(flag);
		System.out.println("Verified the User label");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
