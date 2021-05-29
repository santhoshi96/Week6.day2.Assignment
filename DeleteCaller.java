package week6.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeleteCaller extends BaseForService {

	@And ("click on Caller")
	public void clickOnCall() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
	}
	
	@And ("set lastname in search dropdown")
	public void setfDD() {
		driver.switchTo().frame(0);
		WebElement fDD = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(fDD).selectByVisibleText("Last name"); 
	}
	
	@And ("enter lastname in search box {string}")
	public void lastSB(String lName)
	{
		WebElement sBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		sBox.click();
		sBox.sendKeys(lName);
		sBox.sendKeys(Keys.ENTER);
	}
	
	@And ("click firstOption")
	public void clickFO() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}
	
	@And ("click delete button")
	public void clickDele() throws InterruptedException {
		driver.findElement(By.id("sysverb_delete")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ok_button")).click();
	}
	
	@Then ("Print caller is deleted")
	public void calDeleted() {
		
		System.out.println("Caller is Deleted");

	}
	
	
}
