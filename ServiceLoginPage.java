package week6.day2.Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week6.day2.Assignment.Hooks.TestNgHooks;
import week6.learning.LoginPage;
import week6.learning.WelcomePage;

public class ServiceLoginPage extends TestNgHooks {
	
	public ServiceLoginPage typeUserName(String UserName) {
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys(UserName);;
		return this;
	}
	
	public ServiceLoginPage typePassword(String password) {
		driver.findElement(By.id("user_password")).sendKeys(password);;
		return this;
	}
	
	public ServiceHomePage clickLoginButton() {
		driver.findElement(By.id("sysverb_login")).click();
		return new ServiceHomePage();
	}
	
	public ServiceLoginPage clickLoginForFailure() {
		driver.findElement(By.id("sysverb_login")).click();
		return this;
	}
	
}


