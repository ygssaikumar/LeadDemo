package Healthcare.com.Healthcare.Core;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class WriteXLS {
	  @Test
	  public void main() throws Exception {
			FileInputStream fis = new FileInputStream("E:\\Exel Files\\EmployeeSheetWritable.xls");
			HSSFWorkbook readable_workbook = new HSSFWorkbook(fis);
			HSSFSheet readable_sheet = readable_workbook.getSheet("Sheet2");
			//create first row
			//r1c1=readable_sheet.createRow(0).createCell(0).setcellValue("EmpID");
			HSSFRow R1=readable_sheet.createRow(0);
			HSSFCell r1c1=R1.createCell(0);
			r1c1.setCellValue("Emp ID");
			
			HSSFCell r1c2= R1.createCell(1);
			r1c2.setCellValue("Name");
			
			HSSFCell r1c3=R1.createCell(2);
			r1c3.setCellValue("Age");
			
			//create second row
			HSSFRow R2=readable_sheet.createRow(1);
			HSSFCell r2c1=R2.createCell(0);
			r2c1.setCellValue("1");
			
			HSSFCell r2c2 =R2.createCell(1);
			r2c2.setCellValue("Sai");
			
			HSSFCell r2c3= R2.createCell(2);
			r2c3.setCellValue("28");
			
			//create third row
			HSSFRow R3 = readable_sheet.createRow(2);
			HSSFCell r3c1=R3.createCell(0);
			r3c1.setCellValue("2");
			
			HSSFCell r3c2= R3.createCell(1);
			r3c2.setCellValue("Ramya");
			
			HSSFCell r3c3 = R3.createCell(2);
			r3c3.setCellValue("26");
			
			FileOutputStream writable_Excel = new FileOutputStream("E:\\Exel Files\\EmployeeSheetWritable.xls");
			readable_workbook.write(writable_Excel);
			System.out.println("save the readable workbook into writable excel");

		}

		  
 
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Before the entry of excel sheet");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("after the current code");
	  }}

