package week6.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateCaller extends BaseForService{

	@And ("click Caller")
	public void clickcaller() {
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
	}
	
	@And ("click New button to create caller")
	public void clickNB() {
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();
	}
	
	@And ("type firstname as (.*)$")
	public void typefName(String firstName) {
		driver.findElement(By.id("sys_user.first_name")).sendKeys(firstName);
	}
	
	@And ("get firstname")
	public void getFirstName( ) {
		sysuserfirstname = driver.findElement(By.id("sys_user.first_name")).getText();
		System.out.println("Entered firstname is:"+sysuserfirstname);
	}
	
	@And ("type lastname as (.*)$")
	public void typelName(String lastName) {
		driver.findElement(By.id("sys_user.last_name")).sendKeys(lastName);
	}
	
	@And ("type Email as (.*)$")
	public void typeEiD(String emailId) {
		driver.findElement(By.id("sys_user.email")).sendKeys(emailId);
	}
	
	@And ("tick Submit")
	public void tickSub() {
		driver.findElement(By.id("sysverb_insert")).click();
	}
	
	@Then ("verify caller Created")
	public void calcreated() {
		WebElement forTextLastNameFirst = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextLastNameFirst).selectByVisibleText("First name"); 
		WebElement firstN = driver.findElement(By.xpath("//input[@class='form-control']"));
		firstN.click();
		firstN.sendKeys(sysuserfirstname);
		firstN.sendKeys(Keys.ENTER);

		String result = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
		
		if (result.equalsIgnoreCase(sysuserfirstname)) {
			System.out.println("Caller created");
			driver.quit();

		} else {
			System.err.println("Caller is not created");
		}

	}
	
}
