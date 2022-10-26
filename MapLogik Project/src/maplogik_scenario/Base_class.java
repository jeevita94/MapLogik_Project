package maplogik_scenario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_class {

	public static WebDriver driver;
	
	
	public static void initialisation()
	{
		System.setProperty("webdriver.chrome.driver", "I:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	public static void url() throws IOException
	{
		String locationString="I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario\\url.txt";
		FileReader fReader= new FileReader(locationString);
		BufferedReader reader= new BufferedReader(fReader);
		String url=reader.readLine();
		reader.close();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void Studenturl() throws IOException
	{
		String locationString="I:\\Jeevi ADM\\Eclipse Workspace\\MapLogik Project\\src\\maplogik_scenario2\\studenturl.txt";
		FileReader fReader= new FileReader(locationString);
		BufferedReader reader= new BufferedReader(fReader);
		String url=reader.readLine();
		reader.close();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

}