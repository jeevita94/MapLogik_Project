package scenario_1testcase;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.Properties;
import org.etsi.uri.x01903.v13.QualifyingPropertiesReferenceType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.drawingml.x2006.chart.STPageSetupOrientation;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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
import maplogik_scenario.Form_fill;
import maplogik_scenario.Home_page;
import maplogik_scenario.Login_page;

import net.bytebuddy.implementation.bind.annotation.Super;

public class testcase extends Base_class {
	
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;
	Login_page login;
	Home_page homepage;
	CollegeActivation_page col_activate;
	Form_fill fillform;
	Alert alert;
	@BeforeTest
	public void report()
	{
		extent = new ExtentReports();
		 
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Maplogik_scenario_1_ExtentReport.html");
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
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	
	@BeforeMethod
	public void setup() throws IOException, AWTException
	{
		
		initialisation();//driver initialisation
		url();
		login=new Login_page();
		login.userids();//udernamepassword
		
	}
	@Test(priority = 1)
public void  collegelinkclicking() throws IOException, AWTException, InterruptedException
{
		logger = extent.createTest("To click on college activationlink");
	homepage= new Home_page();
	homepage.clickoncollegeactivationlink(); 
	col_activate=new CollegeActivation_page();
	Thread.sleep(5000);
	col_activate.clickonaddnew();
	fillform= new Form_fill();
	fillform.collegename();
	Thread.sleep(5000);
}

@Test(priority = 2)
public void validations()
{
	homepage= new Home_page();
	col_activate=new CollegeActivation_page();
	homepage.clickoncollegeactivationlink();
	
	logger = extent.createTest("To verify Logo");
	logger.createNode("logo is Present");
	boolean logopic=col_activate.validatelogo();
	Assert.assertEquals(logopic, true);
	
	logger = extent.createTest("To verify collegename");
	boolean collegenametitle=col_activate.validatecollegename();
	Assert.assertEquals(collegenametitle, true);
	
	logger = extent.createTest("To verify collegelocation");
	boolean collegelocation=col_activate.validatelocation();
	Assert.assertEquals(collegelocation, true);
	
	logger = extent.createTest("To verify deleteicon");
	boolean deleteicon=col_activate.validatedeleteicon();
	Assert.assertEquals(deleteicon, true);
	
	logger = extent.createTest("To verify importstudenticon");
	boolean studenticon=col_activate.validateimportstudenticon();
	Assert.assertEquals(studenticon, true);
	
	logger = extent.createTest("To verify importstudentmarksicon");
	boolean marksicon=col_activate.validateimportstudentmarksicon();
	Assert.assertEquals(marksicon, true);
}

@Test(dependsOnMethods = {"validations"})
public void delete()
{
	logger = extent.createTest("Deleted activated college");
	col_activate=new CollegeActivation_page();
	homepage= new Home_page();
	homepage.clickoncollegeactivationlink();
	col_activate.deletecollege();
	col_activate.alert();
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
	
	
	homepage.applogout();
	driver.quit();
	
}
@AfterTest
public void endReport() {
extent.flush();

}





}