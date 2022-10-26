package maplogik_scenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import maplogik_scenario2.Importmarks_page;

public class CollegeActivation_page extends Base_class{
	
	@FindBy(xpath="//span[contains(text(),'Add New')]")
	public static WebElement addnew;
	
	@FindBy(xpath="//tr//td[text()='College of Engineering']//preceding-sibling::td")
	public static WebElement logo;

	@FindBy(xpath="//tr//td[text()='College of Engineering']")
	public static WebElement collegename;

	@FindBy(xpath="//tr//td[text()='College of Engineering']/following-sibling::td[1]")
	public static WebElement location;

	@FindBy(xpath="//tr//td[text()='College of Engineering']/following-sibling::td[2]//a[2]")
	public static WebElement deteleIcon;

	@FindBy(xpath="//tr//td[text()='College of Engineering']/following-sibling::td[2]//a[3]")
	public static WebElement importStudentIcon;
	
	@FindBy(xpath="//tr//td[text()='College of Engineering']/following-sibling::td[2]//a[4]")
	public static WebElement importStudentmarksIcon;
	
	@FindBy(xpath="//tr//td[text()='PSG college of Technology']/following-sibling::td[2]//a[4]")
	public static WebElement psgimportStudentmarksIcon;


	public CollegeActivation_page() {
		PageFactory.initElements(driver, this);
	}
	public Form_fill clickonaddnew() {
		addnew.click();
		return new Form_fill();
	}
	
	public boolean validatelogo()
	{
		return logo.isDisplayed();
	}
	
	public boolean validatecollegename()
	{
		return collegename.isDisplayed();
	}
	public boolean validatelocation()
	{
		return location.isDisplayed();
	}
	public boolean validatedeleteicon()
	{
		return deteleIcon.isDisplayed();
	}
	public boolean validateimportstudenticon()
	{
		return importStudentIcon.isDisplayed();
	}
	public boolean validateimportstudentmarksicon()
	{
		return importStudentmarksIcon.isDisplayed();
	}
	
	public void deletecollege()
	{
		deteleIcon.click();
	}
	
	public void alert()
	{
	Alert alert= driver.switchTo().alert();
	alert.accept();
	
	}
	public Importmarks_page importmarks()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", psgimportStudentmarksIcon);
	//	psgimportStudentmarksIcon.click();
		return new Importmarks_page();
	}
	
}
