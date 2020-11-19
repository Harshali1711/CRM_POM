package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.TestBase.TestBase;

public class TasksPage extends TestBase{
	
	//************************Page Factory********************************
	
	@FindBy(xpath="//input[@id='title']")
	WebElement Title;
	
	@FindBy(xpath="//input[@id='fieldId_deadline']")
	WebElement DeadLine;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]/select[1]")
	WebElement AutoExtent;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]/select[1]")
	WebElement Status;
	
	@FindBy(xpath="//input[@id='completion']")
	WebElement CompletionPerCentage;
	
	@FindBy(xpath="//tbody/tr[7]/td[2]/select[1]")
	WebElement Type;
	
	@FindBy(xpath="//tbody/tr[8]/td[2]/select[1]")
	WebElement Priority;
	
	@FindBy(xpath="//table/tbody/tr[1]/td/input[@type='submit' and @value='Save']")
	WebElement SaveButton;
	
	
	//***********************Constructor***********************************
	
	public TasksPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//************************Action Methods********************************
	
	public void CreateNewTask(String Title,String AutoExtent,String Status,String CompletionPerCentage,String Type,String Priority)
	{
		this.Title.sendKeys(Title);
		
		Select sel=new Select(this.AutoExtent);
		sel.selectByVisibleText(AutoExtent);
		
		Select sel2=new Select(this.Status);
		sel2.selectByVisibleText(Status);
		
		this.CompletionPerCentage.sendKeys(CompletionPerCentage);
		
		Select sel3=new Select(this.Type);
		sel3.selectByVisibleText(Type);
		
		Select sel4=new Select(this.Priority);
		sel4.selectByVisibleText(Priority);		
		
		SaveButton.click();
	}
	
	
	
	

}
