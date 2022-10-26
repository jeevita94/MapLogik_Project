package maplogik_scenario;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Maplogik_Collegeactivate {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://maplogik.com/index.php/admin/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("login-email")).sendKeys("admin@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light' and @tabindex='4']")).click();//submit
		driver.findElement(By.xpath("//span[@class='menu-title text-truncate' and text()='College Activation']")).click();//college activation
		driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();//addnew
		
		driver.findElement(By.xpath("//div//input[@id='course_name']")).sendKeys("xyz");//name textfield
		
		WebElement logo =	driver.findElement(By.xpath("//div//input[@id='logo']"));//logo
		logo.sendKeys("C:\\Users\\user\\Pictures\\Camera Roll\\images.jpg");
		//logo.sendKeys(Keys.ENTER);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//input[@id='address']")).sendKeys("address");//address
		
		WebElement district=driver.findElement(By.xpath("//div//select[@name='location']"));
		Select select1 = new Select(district);
		select1.selectByVisibleText("Chennai");
		
		WebElement affiliation = driver.findElement(By.xpath("//div//select[@name='affliation']"));
		Select select2= new Select(affiliation); 
		select2.selectByVisibleText("Deemed to be University");
 		
		WebElement affiationTo= driver.findElement(By.xpath("//div//select[@name='affliated_to']"));
		Select select3= new Select(affiationTo);
		select3.selectByVisibleText("Anna University");
		
		WebElement typeOfCollege= driver.findElement(By.xpath("//div//select[@name='college_type']"));
		Select select4= new Select(typeOfCollege);
		select4.selectByVisibleText("Professional");
		

		WebElement ug= driver.findElement(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_course[]']"));
		Select select5= new Select(ug);
		select5.selectByVisibleText("B.E Civil Engineering");
		
		
		
		driver.findElement(By.xpath("//div//input[@id='cnt_name']")).sendKeys("jeevita"); //contact person name general admin
		
		driver.findElement(By.xpath("//div//input[@id='cnt_number']")).sendKeys("9966778889"); // contact person number general admin
		driver.findElement(By.xpath("//div//input[@id='cnt_email']")).sendKeys("jeevi@gmail.com");//contact person email id
		driver.findElement(By.xpath("//div//input[@id='cnt_name_plc']")).sendKeys("sarathy");//contact person name for placement
		driver.findElement(By.xpath("//div//input[@id='cnt_number_plc']")).sendKeys("9966778866");//contact person number for placement
		driver.findElement(By.xpath("//div//input[@id='course_email_plc']")).sendKeys("sarathy@gmail.com");//contact person gmail for placement
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		WebElement sub=driver.findElement(By.xpath("//button[@id='submitbtn']"));
		sub.sendKeys(Keys.ENTER);
		System.out.println(sub.isEnabled());
		/*Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_ENTER); 
		*/
		
	
		//for deleting college
		/*driver.findElement(By.xpath("//tr//td[text()='College of Engineering']/following-sibling::td[2]//a[2]")).click(); //delete icon
		driver.findElement(By.xpath("//tr//td[text()='College of Engineering']/following-sibling::td[2]//a[3]")).click(); //import student icon
		driver.findElement(By.xpath("//tr//td[text()='College of Engineering']/following-sibling::td[2]//a[4]")).click(); //import marks icon
		
		driver.findElement(By.xpath("//tr//td[text()='College of Engineering']/following-sibling::td[1]"));//location xpath
		driver.findElement(By.xpath("//tr//td[text()='College of Engineering']")); //college name
		driver.findElement(By.xpath("//tr//td[text()='College of Engineering']//preceding-sibling::td")); // logo xpath
		*/
		
		
	}

}
