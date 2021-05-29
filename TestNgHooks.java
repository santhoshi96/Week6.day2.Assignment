package week6.day2.Assignment.Hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgHooks {

public static ChromeDriver driver;
public static String IncidentNumber;
public static String chatqueueentrynumber;
public static String KnowledgeNumber;
    
	@BeforeMethod
	public void intial() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	
	}
	
	public static void switchToFrame0() {
		driver.switchTo().frame(0);
		
	}
}
