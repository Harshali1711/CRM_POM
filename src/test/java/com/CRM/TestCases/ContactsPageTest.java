package com.CRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.Pages.ContactsPage;
import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.TestBase.TestBase;
import com.CRM.TestUtils.TestUtils;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public ContactsPageTest()
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
		contactspage=new ContactsPage();
		TestUtils.SwitchToFrame();
		contactspage=homepage.ClickOnContactsLink();		
	}
	
	@Test(priority = 1,enabled = false)
	public void VerifyContactsLabelTest()
	{		
		Assert.assertTrue(contactspage.VerifyContactsLabel(), "Contacts page missing on web page");
	}
	
	@Test(priority = 2)
	public void SelectContactsTest() throws InterruptedException
	{
		contactspage.SelectContactByName("aa bb");
		Thread.sleep(5000);
		System.out.println("Contact name selected");
	}
	
	@Test(priority = 3,enabled = false)
	public void ValidateNewContact() throws InterruptedException
	{
		homepage.ClickOnNewContactLinks();
		contactspage.CreateNewContact("Mr.", "Tom", "Peter", "Google", "Active");
		Thread.sleep(5000);
	}
	
	//DataProvider Method
	@DataProvider
	public Object[][] getCRMData()
	{
		Object data[][]=TestUtils.getTestData("Contacts");
		return data;
	}
	
	//Dataprovider Testcase
	@Test(priority = 4,dataProvider = "getCRMData",enabled = false)
	public void ValidateNewContactDDT(String title,String fname,String lname,String comp,String status)
	{
		homepage.ClickOnNewContactLinks();
		contactspage.CreateNewContact(title, fname, lname, comp, status);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
