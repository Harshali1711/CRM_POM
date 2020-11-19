package com.CRM.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.Pages.TasksPage;
import com.CRM.TestBase.TestBase;
import com.CRM.TestUtils.TestUtils;

public class TasksPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TasksPage taskspage;

	public TasksPageTest()
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
		taskspage=new TasksPage();	
		TestUtils.SwitchToFrame();

	}

	@Test(priority = 1,enabled=false)
	public void ValidateNewTask() throws InterruptedException
	{
		homepage.ClickOnNewTasksLink();
		taskspage.CreateNewTask("Mr.", "Extend deadline by 1 day", "Open","30", "Delivery", "High");
		Thread.sleep(8000);
	}

	//Dataprovider method
	@DataProvider
	public Object[][] GetTasksData()
	{
		Object data[][]=TestUtils.getTestData("Tasks");
		return data;
	}

	@Test(priority = 2,dataProvider = "GetTasksData")
	public void ValidateNewTasksDDT(String title,String AutoExtent,String Status,String CompletionPerCentage,String Type,String Priority)
	{
		homepage.ClickOnNewTasksLink();
		taskspage.CreateNewTask(title, AutoExtent, Status, CompletionPerCentage, Type, Priority);
	}


	@AfterMethod 
	public void tearDown() 
	{ 
		driver.quit(); 
	}

}
