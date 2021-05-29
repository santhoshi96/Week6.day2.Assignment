package week6.day2.Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.Assignment.Hooks.TestNgHooks;

public class ServiceOpenPage extends TestNgHooks{

	public ServiceOpenPage clickSearch(String searchvalue) {
		driver.switchTo().frame(0);
		WebElement forShortDes = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forShortDes).selectByVisibleText("Short description"); 
		WebElement firstNumber = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		firstNumber.click();
		firstNumber.sendKeys(searchvalue);
		return this;
	}
		public ServiceIncidentUpadatePage clickIncident() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		return new ServiceIncidentUpadatePage();
	}
		public ServiceOpenPage clickOnSearch() {
			WebElement forShortDes = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
			new Select(forShortDes).selectByVisibleText("Number");
			WebElement incidentNumber2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
			incidentNumber2.click();
			incidentNumber2.sendKeys(IncidentNumber);
			incidentNumber2.sendKeys(Keys.ENTER);
			return this;
		}
	    
	    public ServiceOpenPage verifyUpdatedIncident() {
	    	String State = driver.findElement(By.xpath("//td[text()='In Progress']")).getText();
			if(State.equals("In Progress")) {
				System.out.println("In Progress updated sucessfully");
			}else
			{
				System.out.println("In Progress is not updated sucessfully");
			}
			return this;
	    }
}
