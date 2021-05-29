package week6.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateChange extends BaseForService{
	
	@And ("get change number")
	public void getCN() {
		changerequestnumber = driver.findElement(By.id("change_request.number")).getAttribute("value");
	System.out.println("change number is:"+changerequestnumber);
	}
    
	@And ("Enter Short Description as {string}")
	public void enterSD(String SD) {
		driver.findElement(By.id("change_request.short_description")).sendKeys(SD);
	}
	
	@And ("click on Submit")
	public void clickonSub() {
		driver.findElement(By.id("sysverb_insert")).click();
	}
	
	@And ("click Open")
	public void clickOpen() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
	}
	
	@Then ("verify Change Created")
	public void chancreated() {
		driver.switchTo().frame(0);
		WebElement number = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(number).selectByVisibleText("Number");
		WebElement changeNumber = driver.findElement(By.xpath("//input[@class='form-control']"));
		changeNumber.click();
		changeNumber.sendKeys(changerequestnumber);
		changeNumber.sendKeys(Keys.ENTER);
		String cHG = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(cHG.equals(changerequestnumber)) {
			System.out.println("Change request should be created successfully");
		}else {
			System.out.println("Change request is not created successfully");
		}
	}
}
