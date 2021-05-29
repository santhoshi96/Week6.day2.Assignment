package week6.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginForService extends BaseForService {
	
	@Given ("Launch Chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
	
	@When ("Load URL {string}")
	public void loadUrl(String URL) {
		driver.get(URL);
	}
	
	@And ("Type username as {string}")
	public void typeUserName(String username) {
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys(username);
	}
	
	@And ("Type password as {string}")
	public void typePassword(String password) {
		driver.findElement(By.id("user_password")).sendKeys(password);
	}
	
	@And ("click Login Button")
	public void clickLogin() {
		driver.findElement(By.id("sysverb_login")).click();
	}
	
	@And ("click filter")
	public void filterclick() {
		driver.findElement(By.id("filter")).click();
	}
	
	@When ("type filter as (.*)$")
	public void typeFliteras(String filterNav) {
		driver.findElement(By.id("filter")).sendKeys(filterNav);
	}
	
	@And ("click create New")
	public void clickcreate() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
	}
	@And ("click create New change")
	public void clickCreateNewChange() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
	}
	
	@And ("click Normal")
	public void clickNormal() throws InterruptedException{
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='ITIL Mode 1 Normal Change']")).click();
	}
	
	@And ("get incident number")
	public void getIN() {
		driver.switchTo().frame(0);
		incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident Number is:"+incidentNumber);

}
}
