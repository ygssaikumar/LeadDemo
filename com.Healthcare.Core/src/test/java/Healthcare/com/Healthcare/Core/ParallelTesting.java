package Healthcare.com.Healthcare.Core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ParallelTesting { 
	public WebDriver driver;
	
  @Test
  public void verify_Title() {
		String title =driver.getTitle();
		System.out.println("Actual title " +title);
		Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
		System.out.println("Title is fine");
  }
  @Parameters({"browser"})
  @BeforeClass
  public void setUp(String browser) {
	  switch(browser) {
	  case "FFX":
		  System.setProperty("webdriver.gecko.driver", "D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  break;
	  case "CRM":
		  System.setProperty("webdriver.chrome.driver","D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\chromedriver.exe ");
		  driver=new ChromeDriver();
		  break;
	  case "IE":
		  System.out.println("IE");
		  
	  default :
		  System.out.println("Invalid browser of choice");
	  }
	  
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  

}
