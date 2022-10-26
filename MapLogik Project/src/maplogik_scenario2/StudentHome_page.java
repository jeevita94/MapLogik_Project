package maplogik_scenario2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maplogik_scenario.Base_class;

public class StudentHome_page extends Base_class {
	
	@FindBy(xpath="//li//a//span[@class='menu-title text-truncate' and contains(text(),'Academic Info')]")
	public static WebElement academicinfo;
	public StudentHome_page() {
		PageFactory.initElements(driver, this);
	}
	
	public AcademicInfo_pag clickonacademiclink()
	{
	academicinfo.click();
	return new AcademicInfo_pag();
	}
	

}
