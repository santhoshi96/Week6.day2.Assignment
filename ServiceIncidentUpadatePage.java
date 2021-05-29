package week6.day2.Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import week6.day2.Assignment.Hooks.TestNgHooks;

public class ServiceIncidentUpadatePage extends TestNgHooks {
    public ServiceIncidentUpadatePage getUpdatedIncident() {
    IncidentNumber=driver.findElement(By.name("incident.number")).getAttribute("value");
	System.out.println("updated Incident Number is:"+IncidentNumber);
	return this;
    }
    
    public ServiceIncidentUpadatePage updateUrgency() {
    	WebElement urgencyDd = driver.findElement(By.id("incident.urgency"));
		Select dd = new Select(urgencyDd);
		dd.selectByVisibleText("1 - High");
		System.out.println("selected and updated urgency value is High");
		return this;
    }
    public ServiceIncidentUpadatePage updateImpact() {
    	Select stateDd = new Select(driver.findElement(By.id("incident.state")));
		stateDd .selectByIndex(1);
		System.out.println("selected and updated State value is In Progress");
		return this;
    }
    
    public ServiceOpenPage clickupdate() {
    	driver.findElement(By.id("sysverb_update_bottom")).click();
    	return new ServiceOpenPage();
    }
    
}
