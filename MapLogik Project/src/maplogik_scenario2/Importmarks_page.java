package maplogik_scenario2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import maplogik_scenario.Base_class;

public class Importmarks_page extends Base_class{
	
	@FindBy(xpath = "//div//button[@id='submitbtn']")
	public static WebElement import_pagesubmit;
	
	public Importmarks_page() {
		PageFactory.initElements(driver, this);
	}
	
	public void type()
	{
		WebElement type=driver.findElement(By.xpath("//div//select[@id='course_type']"));
		Select typeofcour=new Select(type);
		typeofcour.selectByVisibleText("UG");
		
	}
	
	public void course()
	{
		WebElement course=driver.findElement(By.xpath("//div//select[@id='course_name']"));
		Select coursename=new Select(course);
		coursename.selectByVisibleText("B.E Civil Engineering");
	}
	public void semester()
	{
		WebElement semester=driver.findElement(By.xpath("//div//select[@name='semester']"));
		Select semester7=new Select(semester);
		semester7.selectByVisibleText("Semester 1");
		
	}
	 public void upload() throws AWTException, InterruptedException {
		
		WebElement upload =	driver.findElement(By.xpath("//div//input[@id='import_file']"));
		upload.sendKeys("I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario2\\semester_1.csv"); //need to change the loaction of upload file
		import_pagesubmit.click();
}
	
}
