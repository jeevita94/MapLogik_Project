package maplogik_scenario2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maplogik_scenario.Base_class;

public class StudentLogin_page extends Base_class{
	 //student
		@FindBy(xpath="//input[@id='login-student-id']")
		public static WebElement studentusername;
		
		@FindBy(xpath="//input[@id='login-mobile']")
		public static WebElement studentpassword;
		
		@FindBy(xpath="//p[@id='test_otp']")
		public static WebElement otpxpath;
		
		@FindBy(xpath="//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light' and contains(text(),'Log in')]")
		public static WebElement studentlogin;
		
		@FindBy(xpath="//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light' and contains(text(), 'Submit')]")
		public static WebElement studentsubmit;
		
		@FindBy(xpath="//input[@id='login-otp']")
		public static WebElement otpfield;
		
		
		public StudentLogin_page() {
			PageFactory.initElements(driver, this);
		}

		public static void otp() throws IOException, InterruptedException
		{
			WebElement otpElement = driver.findElement(By.xpath("//p[@id='test_otp']"));
			Thread.sleep(5000);
			String otpvalue = otpElement.getText();
			System.out.println(otpvalue);
			otpfield.sendKeys(otpvalue);
			
			File file = new File("I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario2\\Scenerio 2excelwrite.xlsx");
			file.createNewFile();
			FileInputStream input = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			{	//String otpvalue=otpxpath.getText();
				Row row0 = sheet.createRow(0);
				Cell cell1=row0.createCell(0);
				cell1.setCellValue("otp");
				Cell cell4=row0.createCell(1);
				cell4.setCellValue("Date And Time");
				
			Row row = sheet.createRow(1);
			
			Cell cell2=row.createCell(0);
			cell2.setCellValue(otpvalue);
			
			 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			 //get current date time with Date()
			 Date date = new Date();
			 
			 // Now format the date
			 String date1= dateFormat.format(date);

			 // Print the Date
			 System.out.println("Current date and time is " +date1);
			 Cell cell3=row.createCell(1);
				cell3.setCellValue(date1);
			 
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			workbook.close();
			System.out.println("END OF WRITING DATA IN EXCEL");
			studentsubmit.click();
		}
		public void userids() throws IOException, InterruptedException
		{
			File file = new File("I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario2\\credentialforAdminandStudent.xlsx");
			file.createNewFile();
			FileInputStream input = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();// to format the cell
			
			Row row = sheet.getRow(3);//0th row valkue
			Cell cell =row.getCell(0);//0throw and 0th col
			Cell cell1 =row.getCell(1);//0throw and 0th col
			String c  = formatter.formatCellValue(cell);
			String c1  = formatter.formatCellValue(cell1);
			
			studentusername.sendKeys(c);
			studentpassword.sendKeys(c1);
			Thread.sleep(2000);
			studentlogin.click();
			
			WebElement otpElement = driver.findElement(By.xpath("//p[@id='test_otp']"));
			Thread.sleep(5000);
			String otpvalue = otpElement.getText();
			System.out.println(otpvalue);
			otpfield.sendKeys(otpvalue);
			studentsubmit.click();
		}
			
		public static void useridsecondlogin() throws IOException, InterruptedException
		{
			File file = new File("I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario2\\credentialforAdminandStudent.xlsx");
			file.createNewFile();
			FileInputStream input = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();// to format the cell
			
			
			Row row = sheet.getRow(3);//0th row valkue
			Cell cell =row.getCell(0);//0throw and 0th col
			Cell cell1 =row.getCell(1);//0throw and 0th col
			String c  = formatter.formatCellValue(cell);
			String c1  = formatter.formatCellValue(cell1);
			studentusername.sendKeys(c);
			studentpassword.sendKeys(c1);
			studentlogin.click();
			otp();
		
		}
		
		
		
}
