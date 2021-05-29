package week6.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateProposal extends BaseForService {
	
	@And ("click My Proposals")
	public void clickMyPro() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
	}

	@And ("click New button")
	public void clickNew() {
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();
	}
	
	@And ("get proposal number")
	public void getproposal() {
		stdchangeproposalnumber = driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
	System.out.println("proposal number is:"+stdchangeproposalnumber);
	}
	
	@And ("type Template Description as {string}")
	public void typeTd(String tD) {
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys(tD);
	}
	@And ("type the Short Description")
	public void typeshortDes() throws InterruptedException {
	driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
	//driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("Test - New proposal creation");

	//driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
	//WebElement shortDesc = driver.findElement(By.xpath("//input[@class='filerTableInput form-control']"));
	Thread.sleep(2000);
	WebElement shortDesc = driver.findElement(By.xpath("//td[@data-value='Short description']//input[1]"));
	shortDesc.click();
	shortDesc.clear();
	shortDesc.sendKeys("Test - New proposal creation");
	}
	
	@And ("click on the Submit")
	public void clicksubmit() {
		driver.findElement(By.id("sysverb_insert")).click();
	}
	
	@Then ("verify Proposal Created")
	public void proCreated() {
		WebElement number1 = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(number1).selectByVisibleText("Number");
		WebElement eleNumber = driver.findElement(By.cssSelector("span#std_change_proposal_hide_search>div>div>input"));
		eleNumber.click();
		eleNumber.sendKeys(stdchangeproposalnumber);
		eleNumber.sendKeys(Keys.ENTER);

		String resultantNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		
		if (resultantNumber.equalsIgnoreCase(stdchangeproposalnumber)) {
			System.out.println("Proposal number created");
			driver.quit();

		} else {
			System.err.println("Proposal number is not created");
		}

	}
}
