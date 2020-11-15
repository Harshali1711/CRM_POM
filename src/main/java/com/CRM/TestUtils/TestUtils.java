package com.CRM.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CRM.TestBase.TestBase;

public class TestUtils extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITELY_WAIT=10;
	
	static Workbook book;
	static Sheet sheet;
	
	//Switch to frame method
	
	public static void SwitchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

	//Get data Method
	
	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream file=null;
		try
		{
			file=new FileInputStream("C:\\Users\\dpkBhatt\\eclipse-workspace\\CRM_POM\\src\\main\\java\\com\\CRM\\TestData\\POMProject.xlsx");			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	//Screenshot method
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String cuurentdir=System.getProperty("user.dir");
		FileUtils.copyDirectory(srcfile, new File(cuurentdir+"/Screenshots/"+System.currentTimeMillis()+".png"));
	}
	
	
}
