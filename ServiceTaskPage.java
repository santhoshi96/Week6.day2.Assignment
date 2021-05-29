package week6.day2.Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.Assignment.Hooks.TestNgHooks;

public class ServiceTaskPage extends TestNgHooks {

	public ServiceTaskPage clickNew() {
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();
		return this;
	}
	
	public ServiceChatPage clickChatQuery() {
		driver.findElement(By.linkText("Chat_queue_entry")).click();
		return new ServiceChatPage();
		}
	
	public ServiceTaskPage clickTaskSearch() {
		WebElement forNumber = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forNumber).selectByVisibleText("Number");
		WebElement searchNumber = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		searchNumber.click();
		searchNumber.sendKeys(chatqueueentrynumber);
		searchNumber.sendKeys(Keys.ENTER);
		return this;
	}
	
	public ServiceTaskPage verifyChatQueryCreated() {
		String cHAT = driver.findElement(By.xpath("//td[@class='vt']")).getText();
		if (cHAT.equals(chatqueueentrynumber)) {
			System.out.println("Chatquery created successfully");
		}else
		{
			System.out.println("Chatquery failure");
		}
		return this;
	}
	
	public ServiceTaskPage selecChatqueue () {
		driver.switchTo().frame(0);
		WebElement taskType = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(taskType).selectByVisibleText("Task type"); 
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Chat Queue",Keys.ENTER);
		return this;
	}
	
	public ServiceChatPage clickChatQueue() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new ServiceChatPage();
	}
	
	public ServiceTaskPage selectNumber () {
		WebElement number = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(number).selectByVisibleText("Number"); 
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(chatqueueentrynumber,Keys.ENTER);
		return this;
	}
	
	public ServiceTaskPage verifyChatQueueupdated() {
		String priority1 = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
		if (priority1.equals("3 - Moderate")) {
			System.out.println("priority is updated successfully");
		}
		else
		{
			System.out.println("priority is not updated");
		}
		String state1 = driver.findElement(By.xpath("(//td[@class='vt'])[3]")).getText();
		if (state1.contentEquals("Work In Progress")) {
			System.out.println("state is updated successfully");
		}else
		{
			System.out.println("state failure");
		}
		return this;
	}
	
	public ServiceTaskPage verifyDeleteChatQueue() {
		String records = driver.findElement(By.xpath("//td[@colspan='11']")).getText();
		if(records.equals("No records to display")) {
			System.out.println("chatqueue deleted");
		}
		else
		{
			System.out.println("chatqueue not deleted");
		}
		return this;
	}
	
	}
	
	

