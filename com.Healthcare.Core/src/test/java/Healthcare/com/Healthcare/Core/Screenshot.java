package Healthcare.com.Healthcare.Core;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// Open the firefox browser
		 System.setProperty("webdriver.gecko.driver", "D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		// Navigate the AppUrl
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");

//Create file object for where our screenshots need to generate
		File desired_location = new File("D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\Screensorts");
		//convert driver object into screenshot
		//call the screen as method to take screenshot file and specify that the output should come in file formate
		File copy_screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(copy_screenshot,desired_location);
		//FileHandler.copy(copy_screenshot,desired_location);	
		//FileHandler.copy(copy_screenshot,desired_location);	
	    
		   System.out.println("screenshot taken");
			}

	}


