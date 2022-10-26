package maplogik_scenario;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page extends Base_class {
	
	@FindBy(xpath="//span[@class='menu-title text-truncate' and text()='College Activation']")
	public static WebElement collegeactivation;
	
	@FindBy(xpath="//li//a//span[contains(text(),'Log out')]")
	public static WebElement logoutElement;
	
	public Home_page() {
		PageFactory.initElements(driver, this);
	}
	public boolean validatelink()
	{
		return collegeactivation.isDisplayed();
	}
	
	public CollegeActivation_page clickoncollegeactivationlink()
	{
		 collegeactivation.click();
		 return new CollegeActivation_page();
		
	}
	
	
	public void applogout() {
		logoutElement.click();
	}
}
