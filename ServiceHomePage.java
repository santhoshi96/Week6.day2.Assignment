package week6.day2.Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import week6.day2.Assignment.Hooks.TestNgHooks;

public class ServiceHomePage extends TestNgHooks {

	
	
	public ServiceHomePage clickFilter() {
	driver.findElement(By.id("filter")).click();
    return this;
	}
	public ServiceHomePage typeFilter(String fliter) {
		driver.findElement(By.id("filter")).sendKeys(fliter,Keys.ENTER);
	    return this;
		}
	public ServiceOpenPage clickOpen() {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
	    return new ServiceOpenPage();
		}
	public ServiceTaskPage clickMyWork() {
		driver.findElement(By.xpath("//div[text()='My Work']")).click();
		return new ServiceTaskPage();
	}
	
	public ServiceHomePage clickK() {
		driver.findElement(By.xpath("//div[text()='Knowledge']")).click();
		return this;
	}
	public ServiceCreateArticle clickCreateNew() {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[contains(@class,'btn-icon icon-article-document')]")).click();
		return new ServiceCreateArticle();
	}
}
