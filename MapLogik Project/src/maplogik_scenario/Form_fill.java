package maplogik_scenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Form_fill extends Base_class{
	
	public static Properties properties;
	
	@FindBy(xpath="//div//input[@id='course_name']")
	public static  WebElement NewcollegeName;

	@FindBy(xpath="//div//input[@id='logo']")
	public static WebElement collegelogo;

	@FindBy(xpath="//div//input[@id='address']")
	public static WebElement Address;

	@FindBy(xpath="//div//select[@name='location']")
	public static WebElement district;

	@FindBy(xpath="//div//select[@name='affliation']")
	public static WebElement affiliation;
	
	@FindBy(xpath="//div//select[@name='affliated_to']")
	public static WebElement affiationTo;

	@FindBy(xpath="//div//select[@name='college_type']")
	public static WebElement typeOfCollege;
	
	@FindBy(xpath="//select[@id='bootstrap-duallistbox-nonselected-list_course[]']")
	public static WebElement ugcourse;
	
	
	@FindBy(xpath="//div//input[@id='cnt_name']")
	public static WebElement generalAdminName;
	
	@FindBy(xpath="//div//input[@id='cnt_number']")
	public static WebElement generalAdminNumber;
	
	@FindBy(xpath="//div//input[@id='cnt_email']")
	public static WebElement generalAdminEmailid;
	
	@FindBy(xpath="//div//input[@id='cnt_name_plc']")
	public static WebElement placementpersonname;
	
	@FindBy(xpath="//div//input[@id='cnt_number_plc']")
	public static WebElement placementpersonNumber;
	
	@FindBy(xpath="//div//input[@id='course_email_plc']")
	public static WebElement placementpersonEmailId;
	
	@FindBy(xpath="//div//button[@id='submitbtn']")
	public static WebElement submitbutton;
	
	
	
	public Form_fill() {
		PageFactory.initElements(driver, this);
	}
	
		public void logoupload() throws AWTException
	{
		WebElement logo =	driver.findElement(By.xpath("//div//input[@id='logo']"));//logo
		logo.sendKeys("I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario\\images.jpg");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void selectlocation()
	{
		WebElement district=driver.findElement(By.xpath("//div//select[@name='location']"));
		Select select1 = new Select(district);
		select1.selectByVisibleText("Chennai");
	}
	public void selectaffiliation()
	{
		WebElement affiliation = driver.findElement(By.xpath("//div//select[@name='affliation']"));
		Select select2= new Select(affiliation); 
		select2.selectByVisibleText("Deemed to be University");
	}
	
	public void selectaffiationto()
	{
		WebElement affiationTo= driver.findElement(By.xpath("//div//select[@name='affliated_to']"));
		Select select3= new Select(affiationTo);
		select3.selectByVisibleText("Anna University");
	}
	
	public void selecttypeofcollege()
	{
		WebElement typeOfCollege= driver.findElement(By.xpath("//div//select[@name='college_type']"));
		Select select4= new Select(typeOfCollege);
		select4.selectByVisibleText("Professional");
		
	}
	
	public void ugcourse()
	{
		WebElement ug= driver.findElement(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_course[]']"));
		Select select5= new Select(ug);
		select5.selectByVisibleText("B.E Civil Engineering");
		
	}
	public void submitbutton()
	{
	WebElement sub=driver.findElement(By.xpath("//div//button[@id='submitbtn']"));
	sub.sendKeys(Keys.ENTER);
	}
	 public void collegename() throws IOException, AWTException
	 {
		 properties =new Properties();
		 FileReader reader= new FileReader("I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario\\collegedetail.properties");
		 properties.load(reader);
		 NewcollegeName.sendKeys(properties.getProperty("newcollegeName"));	 
		 logoupload();
		 Address.sendKeys(properties.getProperty("Address"));
		 selectlocation();
		 selectaffiliation();
		 selectaffiationto();
		 selecttypeofcollege();
		 ugcourse();
		 generalAdminName.sendKeys(properties.getProperty("generalAdminName"));
		 generalAdminNumber.sendKeys(properties.getProperty("generalAdminNumber"));
		 generalAdminEmailid.sendKeys(properties.getProperty("generalAdminEmailid"));
		 placementpersonname.sendKeys(properties.getProperty("placementpersonname"));
		 placementpersonNumber.sendKeys(properties.getProperty("placementpersonNumber"));
		 placementpersonEmailId.sendKeys(properties.getProperty("placementpersonEmailId"));
		 submitbutton();
		 
	 }
}
