package Healthcare.com.Healthcare.Core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class Screenshot1 {
	WebDriver driver;
  @Test
  public void f() throws IOException {
	  driver.findElement(By.name("txtUserName")).sendKeys("selenium");
	  driver.findElement(By.name("txtPassword")).sendKeys("seleniumm");
	  driver.findElement(By.name("Submit")).click();
	//Create file object for where our screenshots need to generate
			File desired_location = new File("D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\Screensorts\\Files");
			//convert driver object into screenshot
			//call the screen as method to take screenshot file and specify that the output should come in file formate
			File copy_screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(copy_screenshot,desired_location);
			FileHandler.copy(copy_screenshot,desired_location);	
			
		    
			   System.out.println("screenshot taken");
  }
  @BeforeClass
  public void beforeClass() {
	// Open the firefox browser
			 System.setProperty("webdriver.gecko.driver", "D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\geckodriver.exe");
			
			 driver = new FirefoxDriver();
			// Navigate the AppUrl
			driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
