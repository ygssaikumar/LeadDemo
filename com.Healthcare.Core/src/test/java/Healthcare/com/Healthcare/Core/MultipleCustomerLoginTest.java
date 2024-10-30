package Healthcare.com.Healthcare.Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleCustomerLoginTest extends TestBaseClass {
	
	

	

	// here loginTest() method is called and executed when we call it

	public void loginTest() throws Exception {

		// Navigate the Application Url

		driver.get(config.getProperty("TestSiteName"));

		// Now access the Excel file

		FileInputStream fi = new FileInputStream(
				"D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\src\\main\\java\\Healthcare\\com\\TestData\\ReqSheet.xls");

		// Get the workbook from Excel

		HSSFWorkbook workbook = new HSSFWorkbook(fi);

		// Get the sheet from Workbook

		HSSFSheet sheet = workbook.getSheet("Sheet1");

		// As you know,some times we need to perform same action with multiple
		// times at that time we need to follow - forloop

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

			// read the data from excel sheet

			String userID = sheet.getRow(i).getCell(1).getStringCellValue();

			// Read the password from excel sheet and store into password
			// variable

			String password = sheet.getRow(i).getCell(2).getStringCellValue();

			// If already exits a value into input field then we need to clear
			// first

			getObject("Login_userID").clear();

			// Enter the username

			getObject("Login_userID").sendKeys(userID);

			// If already exits a value into input field then we need to clear
			// first
			getObject("Login_password").clear();

			// Enter the password

			getObject("Login_password").sendKeys(password);

			// Click on Login

			getObject("Login_button").click();

			// wait 5sec
			Thread.sleep(5000);
			/*
			 * How to handle Exception in selenium ?
			 * 
			 * a) By using try - catch block to handle Exception
			 * 
			 * 1. If try block pass then exit from try - catch block
			 * 
			 * 2.If try block fail then through the error to the catch block and take the
			 * screenshot
			 */

			try {

				// Identify Dashboard text and get the text and store into
				// displaysuccess variable

				String title = driver.getTitle();

				// verify welcome page(Dashboard text)
				System.out.println("Actual title is : "+title);

				Assert.assertEquals(title,"OrangeHRM");

				// here createCell will create column

				// and setCellvalue will set the value

				// Attach pass text to writable_Sheet through addCell method ,In
				// which position we have to add column as 3 and row as i.

				sheet.getRow(i).createCell(3).setCellValue("pass");

				// Click on logout

				getObject("Logout_link").click();

				// wait 5sec

				Thread.sleep(5000);

				System.out.println("Login pass");

			} catch (AssertionError e) {
				

				System.out.println("invalid credential....");

				// wait 5sec

				Thread.sleep(5000);

				// here createCell will create column

				// and setCellvalue will set the value

				// Attach fail text to writable_Sheet through addCell method ,In
				// which position we have to add column as 3 and row as i.

				sheet.getRow(i).createCell(3).setCellValue("fail");

				// call to takeScreenShot Re-usable function to take the
				// screenshot

				takeScreenShot(userID);

			}//try catch block is clock
		}//for loop close

		// We need to specify where you want to save excel file

		FileOutputStream Excel_File = new FileOutputStream(
				"D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\src\\main\\java\\Healthcare\\com\\TestData\\ReqSheet.xls");

		// write the data into excel sheet using writable_workbook

		workbook.write(Excel_File);

		Excel_File.close();

	}

	@Test(description="Test MultipleCustomerLoginTest")
	public void loginTest_TC1() throws Exception {

		// create the object for that class
  
		MultipleCustomerLoginTest MCLT = new MultipleCustomerLoginTest();

		MCLT.loginTest();// call the loginTest()
	}
	@Test(description="Test selectDropDownValues")
	public void selectDropDownValues() throws Exception {
		//navigate the url
		driver.get(config.getProperty("TestSiteName"));
		//now access the Excel file
		FileInputStream f=new FileInputStream("D:\\23-8-24\\Saved Projects\\com.Healthcare.Core\\src\\main\\java\\Healthcare\\com\\TestData\\ReqSheet.xls");
		HSSFWorkbook w =new HSSFWorkbook(f);
		HSSFSheet sheet =w.getSheet("Sheet2");
		
	}

}
