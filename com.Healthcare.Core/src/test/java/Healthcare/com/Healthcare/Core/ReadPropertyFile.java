package Healthcare.com.Healthcare.Core;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadPropertyFile {
	// @BeforeClass defines this Test has to run before every @Test methods in
	// the current class/program
	static Properties config;
	
	static Properties OR;
	static WebDriver driver;

	@BeforeClass
	public void intilize() throws IOException {
		// create the Properties object for that config.properties file

		 config = new Properties();
		FileInputStream fis = new FileInputStream(
				"E:\\SeleniumJavaProject\\com.Healthcare.Core\\src\\main\\java\\Healthcare\\com\\Healthcare\\Core\\config.properties");
		config.load(fis);

		// //create Properties object for that OR.properties file

		 OR = new Properties();
		FileInputStream fiss = new FileInputStream(
				"E:\\SeleniumJavaProject\\com.Healthcare.Core\\src\\main\\java\\Healthcare\\com\\Healthcare\\Core\\OR.properties");
		OR.load(fiss);

		if (config.getProperty("browser").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\HOME\\Downloads\\geckodriver.exe");

			 driver = new FirefoxDriver();

		} else {
			
			driver.get(config.getProperty("TestSiteName"));
			System.out.println("Unable to launch the Firefox browser");
		}
	}

	@Test
	public void Login() throws Exception {
		driver.get(config.getProperty("TestSiteName"));
		driver.findElement(By.name(OR.getProperty("username"))).sendKeys("selenium");
		driver.findElement(By.name(OR.getProperty("password"))).sendKeys("selenium");

		driver.findElement(By.name(OR.getProperty("login"))).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(OR.getProperty("logout"))).click();

	}

	@AfterClass
	public void closebrowser() {
		driver.close();

	}

}
  