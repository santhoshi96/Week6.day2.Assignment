package week6.stepdef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateIncident extends BaseForService {
	
	@And ("click caller")
	public void clickCal(){
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("System");
		oldWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
	}
	
	@And ("select System Administrator in caller")
	public void selectcaller() {
		Set<String> findCaller = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(findCaller);
		driver.switchTo().window(lstWindowHandles.get(1));
		String text = driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
	}
	
	@And ("type Short Description as {string}")
	public void typeShortDes(String sD) {
		driver.switchTo().window(oldWindow);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("Hiiiiiiiiiiiiii");
	}
	
	@And ("click on Submit button")
	public void clicksubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
	}
	
	@Then ("verify Incident Created")
	public void incCreated() {
		WebElement forShortDes = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forShortDes).selectByVisibleText("Number");
		WebElement incidentNumber2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		incidentNumber2.click();
		incidentNumber2.sendKeys(incidentNumber);
		incidentNumber2.sendKeys(Keys.ENTER);
		String createdNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(createdNumber .equals( incidentNumber)) {
			System.out.println("New incident created successfully");
			
		}else
		{
			System.out.println("New incident is not created successfully");
		}
		
	}
	}

