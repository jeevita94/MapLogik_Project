package scenario_1testcase;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import maplogik_scenario.Base_class;
import maplogik_scenario.CollegeActivation_page;
import maplogik_scenario.Home_page;
import maplogik_scenario.Login_page;
import maplogik_scenario2.AcademicInfo_pag;
import maplogik_scenario2.Importmarks_page;
import maplogik_scenario2.StudentHome_page;
import maplogik_scenario2.StudentLogin_page;
import maplogik_scenario2.Test_Util;

public class scenario2testcase extends Base_class{
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;
	Login_page login;
	StudentLogin_page stdloginpage;
	StudentHome_page stdhmpage;
	AcademicInfo_pag acadmicinfo;
	Home_page adminhomepage;
	CollegeActivation_page admincolactivation;
	Importmarks_page importstudmark;
	//Test_Util testutil;
	@BeforeTest
	public void report()
	{
		//comment added 3
		extent = new ExtentReports();
		 
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Maplogik_scenario2_ExtentReport.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "Jeevita");
		         extent.setSystemInfo("Environment", "Testing");
		extent.setSystemInfo("User Name", "Jeevi");
		spark.config().setDocumentTitle("Title of the Report Comes here ");
		                // Name of the report
		spark.config().setReportName("Name of the Report Comes here ");
		                // Dark Theme
		spark.config().setTheme(Theme.STANDARD);
		}
		//This method is to capture the screenshot and return the path of the screenshot.
		public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots2/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
		@BeforeMethod
		public  void setup()
		{
			initialisation();
		}
	@Test(priority = 1)
	public void beforeupdatestudentmarks() throws IOException, InterruptedException {
		logger = extent.createTest("Before Updating Marks screenshot");
		
		Studenturl();
		stdloginpage=new StudentLogin_page();
		stdloginpage.userids();
		stdhmpage=new StudentHome_page();
		stdhmpage.clickonacademiclink();
		//beforescreenshot();
		Test_Util.beforescreenshot();
		acadmicinfo= new AcademicInfo_pag();
		AcademicInfo_pag.studentprofilelogout();
		//driver.quit();
		}

	@Test(priority = 2)
	public void adminupdatestudentmarks() throws IOException, AWTException, InterruptedException
	{
		logger = extent.createTest("Admin updating marks");
		//initialisation();//driver initialisation
		url();
		login=new Login_page();
		login.userids();//udernamepassword
		adminhomepage= new Home_page();
		adminhomepage.clickoncollegeactivationlink();
		admincolactivation= new CollegeActivation_page();
		
		admincolactivation.importmarks();
		importstudmark= new Importmarks_page();
		importstudmark.type();
		importstudmark.course();
		importstudmark.semester();
		importstudmark.upload();
		adminhomepage.applogout();
		//driver.quit();
	}
	@Test(priority = 3,dependsOnMethods ={"adminupdatestudentmarks" })
	public void afterstudentmarksupdate() throws IOException, InterruptedException
	{
		logger = extent.createTest("After updating Marks screenshot");
		//initialisation();
		Studenturl();
		stdloginpage=new StudentLogin_page();
		StudentLogin_page.useridsecondlogin();
		stdhmpage=new StudentHome_page();
		stdhmpage.clickonacademiclink();
		Test_Util.Afterscreenshot();
		//screendhot of updated
		acadmicinfo= new AcademicInfo_pag();
		AcademicInfo_pag.studentprofilelogout();
	
	}
	@AfterMethod
	public void result(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
			//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = getScreenShot(driver, result.getName());
			//To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
			}
			else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			}
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			}
		driver.quit();
		
	}
	@AfterTest
	public void endReport() {
	extent.flush();

}
}
	
	
	


