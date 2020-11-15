package com.CRM.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRM.TestUtils.TestUtils;
import com.CRM.TestUtils.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	static WebEventListener eventlistener;
	
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\dpkBhatt\\eclipse-workspace\\CRM_POM\\src\\main\\java\\com\\CRM\\Config\\config.properties");
			prop.load(fis);			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
    public static void initialization()
    {
       String browsername=prop.getProperty("browser");
       if(browsername.equals("chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\dpkBhatt\\eclipse-workspace\\CRM_POM\\Drivers\\chromedriver.exe");
    	   driver=new ChromeDriver();
       }
       else if(browsername.equals("Firefox"))
       {
    	   System.setProperty("webdriver.gecko.driver", "C:\\Users\\dpkBhatt\\eclipse-workspace\\CRM_POM\\Drivers\\geckodriver.exe");
    	   driver=new FirefoxDriver();
       }
       
       //Web Event Listener
       e_driver=new EventFiringWebDriver(driver);
       //Now create the object of EventListenerHandler to register with the EventfiringWebDriver
       eventlistener=new WebEventListener();
       e_driver.register(eventlistener);
       driver=e_driver;
       
       
       //delete cookies
       driver.manage().deleteAllCookies(); 
       
       //maximize the web page
       driver.manage().window().maximize();
       
       //Page load timeout
       driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
       
       //Implicitely wait
       driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITELY_WAIT, TimeUnit.SECONDS);
      
       //Go tot the Application URL
       driver.get(prop.getProperty("url"));
    }
	
	
}
