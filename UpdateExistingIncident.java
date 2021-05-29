package week6.day2.Assignment.Testrun;

import org.testng.annotations.Test;

import week6.day2.Assignment.Hooks.TestNgHooks;
import week6.day2.Assignment.Pages.ServiceLoginPage;
import week6.learning.LoginPage;

public class UpdateExistingIncident extends TestNgHooks {

	@Test
	public void updateIncident()
	{
		new ServiceLoginPage()
		.typeUserName("Admin")
		.typePassword("India@123")
		.clickLoginButton()
		.clickFilter()
		.typeFilter("Incident")
		.clickOpen()
		.clickSearch("Hiii")
		.clickIncident()
		.getUpdatedIncident()
		.updateUrgency()
		.updateImpact()
		.clickupdate()
		.clickOnSearch()
		.verifyUpdatedIncident();
		
	}
}
