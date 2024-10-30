package Healthcare.com.Healthcare.Core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class NewTest{

	Properties config;
	Properties OR;
	WebDriver driver;

@BeforeClass
public void intialize() throws IOException
{

	config = new Properties();
	FileInputStream fis = new FileInputStream("D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\src\\main\\java\\Healthcare\\com\\Healthcare\\Core\\config.properties");
	config.load(fis);

	OR = new Properties();
	FileInputStream fiss = new FileInputStream("D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\src\\main\\java\\Healthcare\\com\\Healthcare\\Core\\OR.properties");
	OR.load(fiss);

	if(config.getProperty("browser").equals("Firefox"))
	{
		
		 
		driver = new FirefoxDriver(); 
	}
	else
	{
		System.out.println("Unable to launch firefox browser");
	}
}


@Test
public void login()
{
	


	driver.get(config.getProperty("TestSiteName"));
	driver.findElement(By.xpath(OR.getProperty("Login_userID"))).sendKeys("selenium");
	driver.findElement(By.xpath(OR.getProperty("Login_password"))).sendKeys("selenium");
	driver.findElement(By.xpath(OR.getProperty("Login_button"))).click();
	
	
}

@AfterClass
public void closeBrowser()
{
	driver.close();
}}
