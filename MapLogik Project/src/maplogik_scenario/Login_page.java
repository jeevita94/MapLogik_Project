package maplogik_scenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page extends Base_class{
	@FindBy(id="login-email")
	public static WebElement username;
	
	@FindBy(id="login-password")
	public static WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light' and @tabindex='4']")
	public static WebElement submit;
	
	
	public Login_page() {
		PageFactory.initElements(driver, this);
	}

	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
		
	public static void userids() throws IOException
	{
		File file = new File("I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario\\AdminCredential.xlsx");
		file.createNewFile();
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		Row row = sheet.getRow(1);//0th row valkue
		Cell cell =row.getCell(0);//0throw and 0th col
		Cell cell1 =row.getCell(1);//0throw and 0th col
		String c=cell.getStringCellValue(); //oth row col value
		String c1=cell1.getStringCellValue();
		username.sendKeys(c);
		password.sendKeys(c1);
		submit.click();
		
		
	}
}

