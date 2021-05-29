package week6.day2.Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.Assignment.Hooks.TestNgHooks;

public class ServiceChatPage extends TestNgHooks{
	
	public ServiceChatPage getChatIN() {
	chatqueueentrynumber = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value");
	System.out.println("ChatQueueNumber is"+chatqueueentrynumber);
	return this;
	}

	public ServiceChatPage typeShortDescription(String sD) {
		driver.findElement(By.id("chat_queue_entry.short_description")).sendKeys(sD);
		return this;
	}
	
	public ServiceChatPage typeDescription(String deS) {
		driver.findElement(By.id("chat_queue_entry.short_description")).sendKeys(deS);
		return this;
	}
	
	public ServiceTaskPage clickSubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
		return new ServiceTaskPage();
	}
	
	public ServiceChatPage updateState() {
		WebElement state = driver.findElement(By.id("chat_queue_entry.state")); 
		new Select(state).selectByVisibleText("Work In Progress"); 
		return this;
		}
	
	public ServiceChatPage updatePriority() {
		WebElement priority = driver.findElement(By.id("chat_queue_entry.priority")); 
		new Select(priority).selectByVisibleText("3 - Moderate");
		return this;
	}
	
	public ServiceTaskPage clickOnUpdate() {
		driver.findElement(By.id("sysverb_update")).click();
		return new ServiceTaskPage();
	}
	
	public ServiceChatPage clickDelete() {
		driver.findElement(By.id("sysverb_delete")).click();
		return this;
	}
	public ServiceTaskPage alertDelete() {
		driver.findElement(By.id("ok_button")).click();
		return new ServiceTaskPage();
	}
	
}
